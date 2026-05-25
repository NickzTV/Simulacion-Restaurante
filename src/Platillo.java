public class Platillo {

    private String nombre;
    private int precio;
    private String descripcion;
    private int TiempoPreparacion;
    private String alergenos;


    public Platillo(String nombre, int precio, String descripcion, int tiempoPreparacion, String alergenos) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        TiempoPreparacion = tiempoPreparacion;
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

    public String getAlergenos() {
        return alergenos;
    }

    public void setAlergenos(String alergenos) {
        this.alergenos = alergenos;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " - Alergenos: " + alergenos + " - Precio: " + getPrecio()
                + "\n Descripcion: " + getDescripcion();
    }



}
