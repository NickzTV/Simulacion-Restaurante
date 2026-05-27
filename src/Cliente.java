public class Cliente {

    private String nombre;
    private int numeroMesa;
    private boolean TieneReservado;

    
    public Cliente(String nombre, int numeroMesa, boolean tieneReservado) {
        this.nombre = nombre;
        this.numeroMesa = numeroMesa;
        TieneReservado = tieneReservado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public boolean isTieneReservado() {
        return TieneReservado;
    }

    public void setTieneReservado(boolean tieneReservado) {
        TieneReservado = tieneReservado;
    }

    public void imprimirReserva() {
        if (TieneReservado) {
            System.out.println("El cliente tiene mesa reservada");
        } else {
            System.out.println("El cliente no tiene mesa reservada");
        }
    }
}
