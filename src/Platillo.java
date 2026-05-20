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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTerminoCoccion() {
        return TerminoCoccion;
    }

    public void setTerminoCoccion(String terminoCoccion) {
        TerminoCoccion = terminoCoccion;
    }

    public int getTiempoPreparacion() {
        return TiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        TiempoPreparacion = tiempoPreparacion;
    }

    public boolean isEsVegano() {
        return esVegano;
    }

    public void setEsVegano(boolean esVegano) {
        this.esVegano = esVegano;
    }
}
