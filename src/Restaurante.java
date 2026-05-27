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
    private static int leerInt(String string, int i, int j) {
        int opcion;
        do{
            System.out.print(string + ": ");
            while (!sc.hasNextInt()){
                System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                sc.next(); // Limpiar la entrada no válida
            }
            opcion = sc.nextInt();
        }while (opcion < i || opcion > j);
        return opcion;
    }
        //throw new UnsupportedOperationException("Unimplemented method 'leerInt'");
        
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

    public static void registrarOrden(ArrayList /* <Platillo> lista */){
        boolean confirmarPedido = false;

        System.out.print("Ingrese el nombre del platillo que desea pedir: ");
        String pedido = sc.next().toLowerCase();

        while (!confirmarPedido) {
            while (pedido.isEmpty()) {
                System.out.println("El pedido no puede estar vacio.");
                pedido = sc.nextLine().trim();
            }
            //realizar lo siguiente:
            //checar si lo que ingreso el usuario es lo mismo que un platillo(objeto) existente

            try{
                System.out.println("Desea agregar otro pedido? (1-SI 2-NO)");
                int opcion = sc.nextInt();

                if (opcion < 1 || opcion > 2) {
                    throw new IllegalArgumentException("Opcion no valida.");
                }

                if (opcion == 1) {
                    confirmarPedido = false;
                } else if (opcion == 2) {

                    //realizar lo siguiente:
                    //agrega la orden dentro de la cola de orden y historial

                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }


}