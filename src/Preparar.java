public class Preparar {

    public synchronized void preparando (String nombre, String nombrePlatillo, int tiempoPreparacion){

        System.out.println(nombre+ " esta preparando el platillo "+nombrePlatillo);
        try{
            Thread.sleep(tiempoPreparacion);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println()
        //aqui tendra los pasos para simular la preparacion del platillo
        //se menciona el nombre del chef, su area de especialidad, y el nombre del platillo.
        // Utilizar hilos, para poder simular la preparacion del platillo  y dependiendo de la informacion del platillo es lo que se tardara en cocinar dentro del archivo txt.

        //Utilizaremos X cosa para detectar a que chef le pertenece el platillo o la orden y finalmente entregalo

        

    }
}
