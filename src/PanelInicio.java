import javax.swing.*;
import java.awt.*;
public class PanelInicio extends JPanel{
    private MarcoSencillo marco;

    public PanelInicio(MarcoSencillo marco){
        this.marco = marco;
        setLayout(new BorderLayout());
        setBackground(new Color(181, 120, 83));

        JLabel titulo = new JLabel("Restaurante");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("ASLON TITLING", Font.BOLD, 50));
        titulo.setForeground(new Color(120, 62, 23));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

        JButton btnMenu = new JButton("Mostrar menú");
        JButton btnAgregar = new JButton("Agregar nueva orden");
        JButton btnCompletadas = new JButton("Ordenes completadas");
        JButton btnFiltroFecha = new JButton("Ordenes por fecha");
        JButton btnSalir = new JButton("Salir");

        Dimension tamBoton = new Dimension(400, 65);
        JButton[] botones = {btnMenu, btnAgregar, btnCompletadas, btnFiltroFecha, btnSalir};

        JPanel panelBotones = new JPanel();
        panel.Botones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panel.Botones.setBackground(new Color(181, 120, 83));
        panelBotones.setOpaque(true);

        Font fuenteBoton = new Font("Spectrum", Font.BOLD, 22);
        Color bcolor = new Color(161, 109, 64);

        for(JButtonn b : botones){
            b.setAlignmentX(Component.CENTER_ALIGNMENT);
            b.setMaximumSize(tamBoton);
            b.setPreferredSize(tamBoton);
            b.setBackground(bcolor);
            b.setForeground(Color.WHITE);
            b.setFont(fuenteBoton);
            b.setFocusable(false);

            panelBotones.add(b);
            panelBotones.add(Box.createVerticalStrut(20));
        }
        btnSalir.setBackground(new Color(153, 9, 9));

        JPanel centro = new JPanel(new GridBagLayout());
        centro.setBackground(new Color(181, 120, 83));
        centro.add(panelBotones);
        add(centro, BorderLayout.CENTER);

        btnMenu.addActionListener(e -> marco.mostrar("MENU"));
        btnAgregar.addActionListener(e -> marco.mostrar("AGREGAR"));
        btnCompletadas.addActionListener(e -> marco.mostrar("COMPLETADAS"));
        btnFiltroFecha.addActionListener(e -> marco.mostrar("FECHA"));
        btnSalir.addActionListener(e -> System.exit(0));
    }

}
