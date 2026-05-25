public class PlatilloFuerte extends Platillo{
    private String terminoCoccion;

    public PlatilloFuerte(String nombre, int precio, String descripcion, int tiempoPreparacion, String alergenos) {
        super(nombre, precio, descripcion, tiempoPreparacion, alergenos);
        this.terminoCoccion = terminoCoccion;
    }

    public String getTerminoCoccion() {
        return terminoCoccion;
    }

    public void setTerminoCoccion(String terminoCoccion) {
        this.terminoCoccion = terminoCoccion;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " - Termino de Coccion: " + terminoCoccion + " - Precio: " + getPrecio()
                + "\n Descripcion: " + getDescripcion();
    }

}
