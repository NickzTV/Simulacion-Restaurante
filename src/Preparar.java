public class Preparar {

    //no es Synchronized porque entiendo que si son de diferentes especialidades si pueden preparar al mismo tiempo
    public void preparando (String nombre, String nombrePlatillo, int tiempoPreparacion){

        System.out.println(nombre+ " esta preparando el platillo: "+nombrePlatillo);
        try{
            Thread.sleep(tiempoPreparacion);
        }
        catch (InterruptedException e){
            System.out.println("Se interrumpió la preparación del platillo: " + nombrePlatillo);
        }
        System.out.println(nombre+ " ha terminado el pedido " +nombrePlatillo);
        //aqui tendra los pasos para simular la preparacion del platillo
        //se menciona el nombre del chef, su area de especialidad, y el nombre del platillo.
        // Utilizar hilos, para poder simular la preparacion del platillo  y dependiendo de la informacion del platillo es lo que se tardara en cocinar dentro del archivo txt.

        //Utilizaremos X cosa para detectar a que chef le pertenece el platillo o la orden y finalmente entregalo
        //en la clase Restaurante en el metodo de tomarPlatilloPorEspecialidad ya se le asignan los pedidos a cada empleado
        

    }
}
