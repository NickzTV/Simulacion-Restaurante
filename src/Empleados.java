public class Empleados {
  
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
}
