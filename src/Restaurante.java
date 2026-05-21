import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {

    //este va a ser nuestro main :3

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<ColaDeOrden> colaDeOrdenes = new ArrayList<ColaDeOrden>();
    public static ArrayList<Platillo> Menu = new  ArrayList<Platillo>();

    public static void main(String[] args) {
        

        System.out.println("=====Bienvenido al restaurante labubub======");
        

        

        //rutas de los archivos para la serializacion
        String rutaMenu = "Menu.txt";
        String  rutaColaDeOrden = "ColaDeOrden.txt";

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
            case 1:
                
        }


        }
    }

    private static int leerInt(String string, int i, int j) {
        throw new UnsupportedOperationException("Unimplemented method 'leerInt'");
        
    }

    private static  void MostrarMenu(){

    }

    private static void  AgregarOrden(){

    }

    private static void ReporteOrdenes(){

    }

    private static void ReporteFechas(){

    }
}
