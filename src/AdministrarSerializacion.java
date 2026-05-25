import java.io.*;
import java.util.ArrayList;

public class AdministrarSerializacion {

    //se guarda la COLA DE ORDEN dentro de un Arraylist
    public static void guardarObjetosColaDeOrden (ArrayList<ColaDeOrden> lista, String nombreArchio){
        try (ObjectOutputStream escritorObjetos = new ObjectOutputStream(new FileOutputStream(nombreArchio))) {

            escritorObjetos.writeObject(lista);
            System.out.println("La orden fue escrito en: " + nombreArchio);

        }catch (IOException e){
            System.err.println("Error al guardar la lista: " + e.getMessage());
        }
    }

    //se LEE la COLA DE ORDEN del arraylist
    public static ArrayList<ColaDeOrden> LeerObjetosColaDeOrden(String nombreArchivo){
        try(ObjectInputStream lectorObjetosColaDeOrden = new ObjectInputStream(new FileInputStream(nombreArchivo))){

            ArrayList<ColaDeOrden> listaRecuperada = (ArrayList<ColaDeOrden>) lectorObjetosColaDeOrden.readObject();
            System.out.println("La cola de orden de " + listaRecuperada.size() + " platillos fue recuperada de " + nombreArchivo);
            return listaRecuperada;

        }catch (IOException e){
            guardarObjetosColaDeOrden(new ArrayList<ColaDeOrden>(), nombreArchivo);
        }catch (ClassNotFoundException e){
            System.err.println("Error al leer la cola de orden de " + nombreArchivo);
        }
        return null;
    }

    //se guarda el HISTORIAL dentro de un Arraylist
    public static void guardarObjetosHistorial (ArrayList<HistorialDePedidos> lista, String nombreArchio){
        try (ObjectOutputStream escritorObjetosHistorial = new ObjectOutputStream(new FileOutputStream(nombreArchio))) {

            escritorObjetosHistorial.writeObject(lista);
            System.out.println("La orden fue escrito en: " + nombreArchio);

        }catch (IOException e){
            System.err.println("Error al guardar la lista: " + e.getMessage());
        }
    }

    //se LEE EL HISTORIAL del arraylist
    public static ArrayList<HistorialDePedidos> LeerObjectosHistorial(String nombreArchivo){
        try(ObjectInputStream lectorObjetosHistorial = new ObjectInputStream(new FileInputStream(nombreArchivo))){

            ArrayList<HistorialDePedidos> listaRecuperada = (ArrayList<HistorialDePedidos>) lectorObjetosHistorial.readObject();
            System.out.println("La cola de orden de " + listaRecuperada.size() + " platillos fue recuperada de " + nombreArchivo);
            return listaRecuperada;

        }catch (IOException e){
            guardarObjetosHistorial(new ArrayList<HistorialDePedidos>(), nombreArchivo);
        }catch (ClassNotFoundException e){
            System.err.println("Error al leer la cola de orden de " + nombreArchivo);
        }
        return null;
    }
}
