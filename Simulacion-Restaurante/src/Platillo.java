public class Platillo {
    private String nombre;
    private int precio;
    private int TiempoEstimado;
    private boolean esVegano;
    private String TerminoCoccion;

    public Platillo(String nombre, int precio, int tiempoEstimado, boolean esVegano, String terminoCoccion) {
        this.nombre = nombre;
        this.precio = precio;
        TiempoEstimado = tiempoEstimado;
        this.esVegano = esVegano;
        TerminoCoccion = terminoCoccion;
    }
}
