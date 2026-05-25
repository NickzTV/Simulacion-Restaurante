public class Postre extends Platillo{
    private Boolean esVegano;
    private Boolean esDiabetico;


    public Postre(String nombre, int precio, String descripcion, int tiempoPreparacion, String alergenos, Boolean esVegano, Boolean esDiabetico) {
        super(nombre, precio, descripcion, tiempoPreparacion, alergenos);
        this.esVegano = esVegano;
        this.esDiabetico = esDiabetico;
    }

    public Boolean getEsVegano() {
        return esVegano;
    }

    public void setEsVegano(Boolean esVegano) {
        this.esVegano = esVegano;
    }

    public Boolean getEsDiabetico() {
        return esDiabetico;
    }

    public void setEsDiabetico(Boolean esDiabetico) {
        this.esDiabetico = esDiabetico;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " - es Vegano: " + esVegano + " - es Diabetico: " + esDiabetico + " - Precio: " + getPrecio()
                + "\n Descripcion: " + getDescripcion();
    }



}
