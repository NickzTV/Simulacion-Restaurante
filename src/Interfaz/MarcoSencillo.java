package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MarcoSencillo extends JFrame{
    private CardLayout cardLayout;
    private JPanel contenedor;

    public MarcoSencillo(){
        super("Restaurante");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                Restaurante.guardarDatos();
                System.exit(0);
            }
        });
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
