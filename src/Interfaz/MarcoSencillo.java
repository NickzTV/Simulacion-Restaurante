package Interfaz;
import javax.swing.*;
import java.awt.*;

public class MarcoSencillo extends JFrame{
    private CardLayout cardLayout;
    private JPanel contenedor;

    public MarcoSencillo(){
        super("Restaurante");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);

        contenedor.add(new PanelInicio(this), "INICIO");
        contenedor.add(new PanelMenu(this), "Menu");
        contenedor.add(new PanelAgregarOrden(this), "AGREGAR");
        contenedor.add(new PanelCompletadas(this), "COMPLETADAS");
        contenedor.add(new PanelFiltroFecha(this), "FECHA");

        add(contenedor);

        cardLayout.show(contenedor, "INICIO");
    }

    public void mostrar(String nombrePantalla){
        cardLayout.show(contenedor, nombrePantalla);
    }
}
