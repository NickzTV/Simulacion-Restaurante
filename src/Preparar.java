public class Preparar {

    
    public void preparando (String nombre, String nombrePlatillo, int tiempoPreparacion, Empleados empleado){

        
        String especialidad;
        if (empleado instanceof Chef){
            especialidad = "Cocina";
        } else if (empleado instanceof Repostero){
            especialidad = "Reposteria";
        } else if (empleado instanceof Barista){
            especialidad = "Barra de bebidas";
        } else {
            especialidad = "Cocina general";
        }

        // nombre del chef, su area de especialidad, y el nombre del platillo
        System.out.println("[" + especialidad + "] " + nombre + " esta preparando: " + nombrePlatillo);

        try{
            Thread.sleep(tiempoPreparacion);
        }
        catch (InterruptedException e){
            System.out.println("Se interrumpió la preparación del platillo: " + nombrePlatillo);
        }

        System.out.println("[" + especialidad + "] " + nombre + " ha terminado el pedido: " + nombrePlatillo);
    }
}