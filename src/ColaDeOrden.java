import java.io.Serializable;
import java.time.LocalDateTime;

public class ColaDeOrden implements Serializable {

    private Cliente cliente;
    private Platillo platillo;
    private LocalDateTime fechaYHora;

    public ColaDeOrden(Platillo platillo, LocalDateTime fechaYHora) {
        this.platillo = platillo;
        this.fechaYHora = fechaYHora;
    }

    public Platillo getPlatillo() {
        return platillo;
    }

    public void setPlatillo(Platillo platillo) {
        this.platillo = platillo;
    }


    @Override
    public String toString() {
        return "Pedidos{ " + "platillo=" + platillo
                + ", Cliente=" + cliente.getNombre() + ", Mesa=" + cliente.getNumeroMesa()
                + ", Fecha=" + fechaYHora +'}';
    }

}
