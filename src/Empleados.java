public class Empleados implements Runnable{
  
  private String nombre;
  private int AniosExperiencia;
  private int edad;
  private int Id;
  
   public Empleados (String nombre, int aniosExperiencia, int edad, int id) {
    this.nombre = nombre;
    AniosExperiencia = aniosExperiencia;
    this.edad = edad;
    Id = id;
  }

    public String getNombre() {
        return nombre;
    }

    public int getAniosExperiencia() {
        return AniosExperiencia;
    }

    public int getEdad() {
        return edad;
    }

    public int getId() {
        return Id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        AniosExperiencia = aniosExperiencia;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public void run(){
        System.out.println(nombre +" ha recibido el pedido " +pedido);
        preparar.preparando(nombre, pedido.getNombre(), pedido.getTiempoPreparacion());

        System.out.println(nombre + " ha entregado el pedido " +pedido.getNombre());
    }
}
