
import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
public class PanelCompletadas extends JPanel{
    private MarcoSencillo marco;
    private JTextArea txtHistorial;

    public PanelCompletadas(MarcoSencillo marco){
        this.marco = marco;

        setLayout(new BorderLayout());
        setBackground(new Color(181, 120, 82));
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel titulo = new JLabel("REPORTE: ORDENES COMPLETADAS");
        titulo.setFont(new Font("ASLON TITLING", Font.BOLD, 26));
        titulo.setForeground(Color.WHITE);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        add(titulo, BorderLayout.NORTH);

        txtHistorial = new JTextArea();
        txtHistorial.setEditable(false);
        txtHistorial.setFont(new Font("Consolas", Font.PLAIN, 15));
        txtHistorial.setBackground(new Color(255, 253, 245));
        txtHistorial.setForeground(new Color(50, 30, 10));
        txtHistorial.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JScrollPane scrollPane = new JScrollPane(txtHistorial);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 20));
        panelBotones.setOpaque(false);

        JButton btnVolver = new JButton("Volver al menú");
        JButton btnCargarHistorial = new JButton("Cargar historial");

        Font fuenteBtn = new Font("Arial", Font.BOLD, 14);

        btnVolver.setFont(fuenteBtn);
        btnVolver.setBackground(new Color(153, 9, 9));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFocusable(false);
        btnVolver.setPreferredSize(new Dimension(160, 40));

        btnCargarHistorial.setFont(fuenteBtn);
        btnCargarHistorial.setBackground(new Color(161, 109, 64));
        btnCargarHistorial.setForeground(Color.WHITE);
        btnCargarHistorial.setFocusable(false);
        btnCargarHistorial.setPreferredSize(new Dimension(180, 40));

        panelBotones.add(btnVolver);
        panelBotones.add(btnCargarHistorial);
        add(panelBotones, BorderLayout.SOUTH);

        btnVolver.addActionListener(e -> marco.mostrar("Menu"));

        btnCargarHistorial.addActionListener(e -> {
            txtHistorial.setText("");

            if(Restaurante.historial == null || Restaurante.historial.isEmpty()){
                txtHistorial.setText("No hay órdenes completadas en el historial actual");
                return;
            }
                txtHistorial.append(String.format("%-25s %-15s %-20s\n", "  PLATILLO COCINADO", "PRECIO", "HORA REGISTRO"));
                txtHistorial.append("-------------------------------------------------------------\n");

                DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm:ss");

                for(ColaDeOrden orden : Restaurante.hisorial){
                    String nombrePlatillo = orden.getPlatillo().getNombre();
                    double precio = orden.getPlatillo().getPrecio();

                    String horaStr = orden.getFechaHora().format(formateador);

                    txtHistorial.append(String.format("%-25s $%-14.2f %s hrs\n", nombrePlatillo, precio, horaStr));
            }
        });
    }

}
