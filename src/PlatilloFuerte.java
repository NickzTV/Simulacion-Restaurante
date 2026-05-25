public class PlatilloFuerte extends Platillo{
    private String terminoCoccion;

    public PlatilloFuerte(String nombre, int precio, String descripcion, int tiempoPreparacion, String alergenos) {
        super(nombre, precio, descripcion, tiempoPreparacion, alergenos);
        this.terminoCoccion = terminoCoccion;
    }

}
