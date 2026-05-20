public class Platillo {
    

    private String nombre;
    private int precio;
    private String TerminoCoccion;
    private int TiempoPreparacion; 
    private boolean esVegano;
    
    public Platillo(String nombre, int precio, String terminoCoccion, int tiempoPreparacion, boolean esVegano) {
        this.nombre = nombre;
        this.precio = precio;
        TerminoCoccion = terminoCoccion;
        TiempoPreparacion = tiempoPreparacion;
        this.esVegano = esVegano;
    }

    
}
