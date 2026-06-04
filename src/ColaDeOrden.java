import java.io.Serializable;
import java.time.LocalDateTime;
public class ColaDeOrden implements Serializable {
    private Cliente cliente;
    private Platillo platillo;
    private LocalDateTime fechaYHora;
    public ColaDeOrden(Platillo platillo, LocalDateTime fechaYHora, Cliente cliente) { 
        this.platillo = platillo;
        this.fechaYHora = fechaYHora;
        this.cliente = cliente; 
    }
    public Platillo getPlatillo() {
        return platillo;
    }
    public void setPlatillo(Platillo platillo) {
        this.platillo = platillo;
    }
    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }
    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
    public Cliente getCliente() { 
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    @Override
    public String toString() {
        return "Pedidos{ " + "platillo=" + platillo
                + ", Cliente=" + cliente.getNombre() + ", Mesa=" + cliente.getNumeroMesa()
                + ", Fecha=" + fechaYHora +'}';
    }
}