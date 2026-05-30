public class Empleados implements Runnable{
  
  private String nombre;
  private int aniosExperiencia;
  private int edad;
  private int id;
  private Preparar preparar;
  
   public Empleados (String nombre, int aniosExperiencia, int edad, int id) {
    this.nombre = nombre;
    this.aniosExperiencia = aniosExperiencia;
    this.edad = edad;
    this.id = id;
    this.preparar = new Preparar(); //para inicializar el simulador
  }

    public String getNombre() {
        return nombre;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public int getEdad() {
        return edad;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void run(){
        while (true){
            ColaDeOrden ordenAsignada = Restaurante.tomarPlatilloPorEspecialidad(this);
            if(ordenAsignada != null){
                Platillo platillo = ordenAsignada.getPlatillo();
                System.out.println(nombre + " ha recibido el pedido: " +platillo.getNombre());
                //aqui llama al metodo para simular el tiempo de preparacion del platillo
                preparar.preparando(nombre, platillo.getNombre(), platillo.getTiempoPreparacion());
                System.out.println(nombre + " ha entregado el pedido: " +platillo.getNombre());
            }else {
                //si no hay pedidos de su especialidad, se espera
                try{
                    Thread.sleep(1000); //espera 1 segundo antes de revisar nuevamente
                }catch (InterruptedException e){
                    System.out.println(nombre + " ha sido interrumpido.");
                    break;
                }
            }
        }
    }
}
