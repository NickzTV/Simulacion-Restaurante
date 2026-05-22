public class Postre extends Platillo{
    private Boolean esVegano;
    private Boolean esDiabetico;


    public Postre(String nombre, int precio, String descripcion, int tiempoPreparacion, String alergenos, Boolean esVegano, Boolean esDiabetico) {
        super(nombre, precio, descripcion, tiempoPreparacion, alergenos);
        this.esVegano = esVegano;
        this.esDiabetico = esDiabetico;
    }
}
