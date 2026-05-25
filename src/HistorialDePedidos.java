import java.io.Serializable;
import java.time.LocalDateTime;

public class HistorialDePedidos implements Serializable {

    private Platillo platillo;
    private LocalDateTime fechaYHora;
    private Cliente cliente;

    public HistorialDePedidos(Platillo platillo, LocalDateTime fechaYHora, Cliente cliente) {
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

    //lo que se escribe dentro del archivo del hitorial de pedidos
    @Override
    public String toString() {
        return "Pedidos{ " + "platillo=" + platillo
                + ", Cliente=" + cliente.getNombre() + ", Mesa=" + cliente.getNumeroMesa()
                + ", Fecha=" + fechaYHora +'}';
    }

}
