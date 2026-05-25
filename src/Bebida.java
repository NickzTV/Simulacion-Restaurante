public class Bebida extends Platillo{
    private Boolean hieloExtra;

    public Bebida(String nombre, int precio, String descripcion, int tiempoPreparacion, String alergenos, Boolean hieloExtra) {
        super(nombre, precio, descripcion, tiempoPreparacion, alergenos);
        this.hieloExtra = hieloExtra;
    }


}
