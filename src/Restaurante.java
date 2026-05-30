import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    //este va a ser nuestro main :3

    public static Scanner sc = new Scanner(System.in);

    public static ArrayList<ColaDeOrden> colaDeOrdenes = new ArrayList<ColaDeOrden>();
    public static ArrayList<Platillo> Menu = new  ArrayList<Platillo>();

    public static void main(String[] args) {
        

        System.out.println("=====Bienvenido al restaurante labubub======");

        Thread hiloChef = new Thread(new Chef("Ryan", 5, 25, 1));
        Thread hiloRepostero = new Thread(new Repostero("Andrea", 3, 25, 2));
        Thread hiloBarista = new Thread(new Barista("Nicole", 4, 25, 3));

        hiloChef.start();
        hiloRepostero.start();
        hiloBarista.start();


        //rutas de los archivos para la serializacion
        //String rutaMenu = "Menu.txt";
        //String  rutaColaDeOrden = "ColaDeOrden.dat";

        //cargar datos existentes (si hay)

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
                case 5:
                    salir = true;
                    break;
            }
        }
        System.exit(0);
    }
    
    public static synchronized ColaDeOrden tomarPlatilloPorEspecialidad(Empleados empleado){
        for (int i=0; i < colaDeOrdenes.size();i++) {
            ColaDeOrden orden = colaDeOrdenes.get(i);
            Platillo platillo = orden.getPlatillo();

            //para validar las especialidades 
            if (empleado instanceof Chef && platillo instanceof PlatilloFuerte){
                return colaDeOrdenes.remove(i); //una vez que se inicia el pedido, tambien se elimina de la cola de ordenes
            }
            if (empleado instanceof Repostero && platillo instanceof Postre){
                return colaDeOrdenes.remove(i);
            }
            if (empleado instanceof Barista && platillo instanceof Bebida){
                return colaDeOrdenes.remove(i);
            }
        }
        return null; //si no hay ordenes disponibles para el empleado, se devuelve null
    }
    //validacion para cuando se pide un numero en cierto rango
    private static int leerInt(String mensaje, int i, int j) {
        int opcion;
        do{
            System.out.print(mensaje + ": ");
            while (!sc.hasNextInt()){
                System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                sc.next(); // Limpiar la entrada no válida
            }
            opcion = sc.nextInt();
        }while (opcion < i || opcion > j);
        return opcion;
    }
        
    //lee el archivo de texto del menu
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
        int numMesa = leerInt("Número de mesa", 1, 50);//no se cuantas mesas tenemos en el restaurante
        //sobre el cliente
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
            if (PlatilloEncontrado != null){
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