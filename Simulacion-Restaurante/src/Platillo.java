public class Platillo {

    private String nombrePlatillo;
    private int Precio;
    private int TiempoPreparacion;
    private String TerminoCoccion;
    private boolean esVegano;

    
    public Platillo(String nombrePlatillo, int precio, int tiempoPreparacion, String terminoCoccion, boolean esVegano) {
        this.nombrePlatillo = nombrePlatillo;
        Precio = precio;
        TiempoPreparacion = tiempoPreparacion;
        TerminoCoccion = terminoCoccion;
        this.esVegano = esVegano;
    }

    
}
