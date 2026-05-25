public class Bebida extends Platillo{
    private Boolean hieloExtra;

    public Bebida(String nombre, int precio, String descripcion, int tiempoPreparacion, String alergenos, Boolean hieloExtra) {
        super(nombre, precio, descripcion, tiempoPreparacion, alergenos);
        this.hieloExtra = hieloExtra;
    }

    public Boolean getHieloExtra() {
        return hieloExtra;
    }

    public void setHieloExtra(Boolean hieloExtra) {
        this.hieloExtra = hieloExtra;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " - Hielo extra: " + hieloExtra + " - Precio: " + getPrecio()
                + "\n Descripcion: " + getDescripcion();
    }


}
