public class Platillo {

    private String nombre;
    private int precio;
    private String descripcion;
    private String TerminoCoccion;
    private int TiempoPreparacion;
    private Boolean esVegano;
    private String alergenos;


    public Platillo(String nombre, int precio, String descripcion, String terminoCoccion, int tiempoPreparacion, Boolean esVegano, String alergenos) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        TerminoCoccion = terminoCoccion;
        TiempoPreparacion = tiempoPreparacion;
        this.esVegano = esVegano;
        this.alergenos = alergenos;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEsVegano() {
        return esVegano;
    }

    public void setEsVegano(Boolean esVegano) {
        this.esVegano = esVegano;
    }

    public String getAlergenos() {
        return alergenos;
    }

    public void setAlergenos(String alergenos) {
        this.alergenos = alergenos;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " - Es vegano: " + getEsVegano() + " - Alergenos: " + alergenos + " - Precio: " + getPrecio()
                + "\n Descripcion: " + getDescripcion();
    }



}
