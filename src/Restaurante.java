import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    //este va a ser nuestro main :3

    public static Scanner sc = new Scanner(System.in);

    public static ArrayList<ColaDeOrden> colaDeOrdenes = new ArrayList<ColaDeOrden>();
    public static ArrayList<Platillo> Menu = new  ArrayList<Platillo>();
    public static ArrayList<HistorialDePedidos> historial = new ArrayList<HistorialDePedidos>(); //historial de pedidos completados

    public static void main(String[] args) {
        

        System.out.println("=====Bienvenido al restaurante labubub======");

       
        cargarMenu(); 

        ArrayList<ColaDeOrden> colaGuardada = AdministrarSerializacion.LeerObjetosColaDeOrden("ColaDeOrden.dat");
        if (colaGuardada != null) colaDeOrdenes = colaGuardada; //Aqui se recupera cola de ordenes guardada

        ArrayList<HistorialDePedidos> historialGuardado = AdministrarSerializacion.LeerObjectosHistorial("Historial.dat");
        if (historialGuardado != null) historial = historialGuardado; //Aqui se recupera el historial guardado

        Thread hiloChef = new Thread(new Chef("Ryan", 5, 25, 1));
        Thread hiloRepostero = new Thread(new Repostero("Andrea", 3, 25, 2));
        Thread hiloBarista = new Thread(new Barista("Nicole", 4, 25, 3));

        hiloChef.setDaemon(true); 
        hiloRepostero.setDaemon(true);
        hiloBarista.setDaemon(true);

        hiloChef.start();
        hiloRepostero.start();
        hiloBarista.start();

        boolean salir = false;
        while(!salir){
        System.out.println("=====MENU PRINCIPAL======");
        System.out.println("1.- Mostrar Menu");
        System.out.println("2.- Agregar nueva orden");
        System.out.println("3.- Ver reporte de ordenes completadas");
        System.out.println("4.- Ver reporte de ordenes por fecha");
        System.out.println("5.- Salir");
        int op = leerInt("Seleccione una opción", 1, 5);

            switch(op){
                case 1: leerMenu("Menu.txt");
                break;
                case 2: registrarOrden();
                break;
                case 3: verReporteCompletadas();
                break;
                case 4: verReportePorFecha();
                break;
                case 5:
                    salir = true;
                    break;
            }
        }
        //guardar datos antes de salir
        AdministrarSerializacion.guardarObjetosColaDeOrden(colaDeOrdenes, "ColaDeOrden.dat");
        AdministrarSerializacion.guardarObjetosHistorial(historial, "Historial.dat");
        System.exit(0);
    }

    //carga todos los platillos del menu como objetos para poder asignarlos a los cocineros segun su especialidad
    public static void cargarMenu(){
        
        //platillos fuertes - los prepara el Chef
        Menu.add(new PlatilloFuerte("Pasta Fettuccini", 120, "Pasta con salsa fettuccini", 8000, "Gluten, Lacteos", ""));
        Menu.add(new PlatilloFuerte("Pasta alfredo", 115, "Pasta con salsa alfredo", 8000, "Gluten, Lacteos", ""));
        Menu.add(new PlatilloFuerte("Pechuga en crema de chipotle", 140, "Pechuga bañada en salsa chipotle", 10000, "Ninguno", ""));
        Menu.add(new PlatilloFuerte("Milanesa de res", 130, "Filete de res empanizado", 12000, "Gluten, Huevo", ""));
        Menu.add(new PlatilloFuerte("Lomo en salsa de arandano", 160, "Lomo de res con salsa de arandano", 15000, "Ninguno", ""));
        Menu.add(new PlatilloFuerte("Corte de carne con salsa de cherri", 180, "Corte de res con salsa de cereza", 20000, "Ninguno", ""));
        Menu.add(new PlatilloFuerte("Tacos dorados", 90, "Tacos fritos rellenos de pollo", 7000, "Gluten", ""));

        //bebidas - las prepara el Barista
        Menu.add(new Bebida("Agua natural", 30, "Agua purificada", 1000, "Ninguno", false));
        Menu.add(new Bebida("Soda", 35, "Refresco de soda", 1000, "Ninguno", false));
        Menu.add(new Bebida("Cherry temple", 50, "Bebida de cereza con refresco", 2000, "Ninguno", true));
        Menu.add(new Bebida("Pink lemonade", 50, "Limonada rosa", 2000, "Ninguno", true));
        Menu.add(new Bebida("Te helado", 45, "Te frio con limon", 2000, "Ninguno", true));
        Menu.add(new Bebida("Vino tinto", 80, "Copa de vino tinto", 1000, "Sulfitos", false));
        Menu.add(new Bebida("Bloody marry", 70, "Coctel clasico con jugo de tomate", 3000, "Apio", false));
        Menu.add(new Bebida("Cerveza", 60, "Cerveza fria", 1000, "Gluten", false));

        //postres - los prepara el Repostero
        Menu.add(new Postre("Pie de queso", 75, "Pay de queso crema", 6000, "Lacteos, Gluten", false, false));
        Menu.add(new Postre("Pie de manzana", 70, "Pay de manzana con canela", 6000, "Gluten", false, false));
        Menu.add(new Postre("Brownies", 55, "Brownie de chocolate", 5000, "Gluten, Huevo, Lacteos", false, false));
        Menu.add(new Postre("Flan", 50, "Flan napolitano", 4000, "Lacteos, Huevo", false, true));
        Menu.add(new Postre("Banana split", 65, "Platano con helado y crema", 3000, "Lacteos", false, false));
        Menu.add(new Postre("Besos de nuez", 45, "Dulce de nuez con cajeta", 2000, "Nueces", true, false));
        Menu.add(new Postre("Galletas de chocolate", 40, "Galletas con chispas de chocolate", 2000, "Gluten, Huevo, Lacteos", false, false));
        Menu.add(new Postre("Pan de platano", 50, "Pan dulce de platano", 5000, "Gluten, Huevo", false, false));
    }
    
    public static synchronized ColaDeOrden tomarPlatilloPorEspecialidad(Empleados empleado){
        for (int i=0; i < colaDeOrdenes.size();i++) {
            ColaDeOrden orden = colaDeOrdenes.get(i);
            Platillo platillo = orden.getPlatillo();

            //para validar las especialidades 
            if (empleado instanceof Chef && platillo instanceof PlatilloFuerte){
                return colaDeOrdenes.remove(i); 
            }
            if (empleado instanceof Repostero && platillo instanceof Postre){
                return colaDeOrdenes.remove(i);
            }
            if (empleado instanceof Barista && platillo instanceof Bebida){
                return colaDeOrdenes.remove(i);
            }
        }
        return null; 
    }

    //agrega un pedido completado al historial
    public static synchronized void agregarAlHistorial(HistorialDePedidos pedido){
        historial.add(pedido);
    }

    //validacion para cuando se pide un numero en cierto rango
    private static int leerInt(String mensaje, int i, int j) {
        int opcion;
        do{
            System.out.print(mensaje + ": ");
            while (!sc.hasNextInt()){
                System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                sc.next(); 
            }
            opcion = sc.nextInt();
        }while (opcion < i || opcion > j);
        return opcion;
    }
        
    //lee el archivo del menu
    public static void leerMenu(String nombreArchivo){
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))){

            String linea;
            while ((linea = lector.readLine()) != null){
                System.out.println(linea);
            }

        }catch (IOException e){
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    //muestra todos los pedidos completados
    public static void verReporteCompletadas(){
        System.out.println("=====REPORTE DE ORDENES COMPLETADAS=====");
        if (historial.isEmpty()){
            System.out.println("No hay ordenes completadas aún.");
            return;
        }
        for (HistorialDePedidos h : historial){
            System.out.println(h.toString());
        }
    }

    //muestra los pedidos completados filtrados por fecha
    public static void verReportePorFecha(){
        System.out.println("=====REPORTE DE ORDENES POR FECHA=====");
        sc.nextLine();
        System.out.println("Ingrese la fecha a buscar (formato: YYYY-MM-DD): ");
        String fechaBuscar = sc.nextLine();
        boolean encontrado = false;
        for (HistorialDePedidos h : historial){
            if (h.getFechaYHora().toString().startsWith(fechaBuscar)){
                System.out.println(h.toString());
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("No se encontraron ordenes para la fecha: " + fechaBuscar);
        }
    }

    public static void registrarOrden(){
        sc.nextLine();

        System.out.println("=====Registrar nueva orden=====");
        System.out.println("Ingrese el nombre del cliente: ");
        String nombreCliente = sc.nextLine();
        while(nombreCliente.isEmpty()){
            System.out.println("El nombre no puede estar vacío. Ingrese el nombre del cliente: ");
            nombreCliente = sc.nextLine();
        }
        System.out.println("Ingrese el número de mesa: ");
        int numMesa = leerInt("Número de mesa", 1, 50);

        Cliente cliente = new Cliente(nombreCliente, numMesa, false);
        sc.nextLine();
        boolean agregarMas = true;
        while (agregarMas){
            System.out.println("Ingrese el nombre del platillo que desea pedir: ");
            String nombrePedido = sc.nextLine();
            while(nombrePedido.isEmpty()){
                System.out.println("El pedido no puede estar vacío. Ingrese el nombre del platillo: ");
                nombrePedido = sc.nextLine();
            }
            Platillo platilloEncontrado = null;
            for (Platillo p: Menu){
                if(p.getNombre().equalsIgnoreCase(nombrePedido)){
                    platilloEncontrado = p;
                    break;
                }
            }
            if (platilloEncontrado != null){
                //si el platillo es un platillo fuerte, se le pregunta al usuario el termino de coccion ( PLATILLO FUERTE)
                if (platilloEncontrado instanceof PlatilloFuerte){
                    System.out.println("¿En qué término de cocción desea su platillo?");
                    System.out.println("1.- Rojo  2.- Medio rojo  3.- Término medio  4.- Tres cuartos  5.- Bien cocido");
                    int opTermino = leerInt("Seleccione una opción", 1, 5);
                    String[] terminos = {"Rare", "Medium rare", "Medium", "Medium well ", "Well done"};
                    ((PlatilloFuerte) platilloEncontrado).setTerminoCoccion(terminos[opTermino - 1]);
                }
                ColaDeOrden nuevaOrden = new ColaDeOrden(platilloEncontrado, LocalDateTime.now(), cliente);
                colaDeOrdenes.add(nuevaOrden);
                System.out.println("El pedido ha sido agregado");
            }else{
                System.out.println("Lo sentimos, '"+nombrePedido+"' no se encuentra en nuestro menú");
            }
            System.out.println("¿Desea agregar otro pedido a la misma mesa? (1-SI 2-NO)");
            int opcion = leerInt("Seleccione una opción", 1, 2);
            sc.nextLine();
            if (opcion == 2){
                agregarMas = false;
            }
        }
        System.out.println("La orden ha sido enviada correctamente a la cocina");
        System.out.println("En un momento recibira su orden");
    }
}