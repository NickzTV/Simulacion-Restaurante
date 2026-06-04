import javax.swing.*;
import java.awt.*;
public class PanelMenu extends JPanel{
    private MarcoSencillo marco;
    private JTextArea txtMenu;

    public PanelMenu(MarcoSencillo marco){
        this.marco = marco;
        setLayout(new BorderLayout());
        setBackground(new Color(217, 190, 102));
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel titulo = new JLabel("---PLATILLOS---");
        titulo.setFont(new Font("ASLONG TITLING", Font.BOLD, 30));
        titulo.setForeground(new Color(120, 62, 23));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        add(titulo, BorderLayout.NORTH);

        txtMenu = new JTextArea();
        txtMenu.setEditable(false);
        txtMenu.setFont(new Font("Consolas", Font.PLAIN, 16));
        txtMenu.setBackground(new Color(255, 253, 245));
        txtMenu.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JScrollPane scrollPane = new JScrollPane(txtMenu);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnVolver = new JButton("Volver al menú");
        JButton btnRefrescar = new JButton("Cargar menú");
        JButton btnIrOrden = new JButton("Ordenar");

        Font fuenteBotones = new Font("Arial", Font.BOLD, 14);
        Color colorBotonCafes = new Color(161, 109, 64);
        Color colorBotonVerde = new Color(34, 139, 34);

        JButton[] botones = {btnVolver, btnRefrescar, btnIrOrden};
        for(JButton btn : botones){
            btn.setFont(fuenteBotones);
            btn.setForeground(Color.WHITE);
            btn.setFocusable(false);
            btn.setPreferredSize(new Dimension(180, 40));
            if (btn == btnIrOrden){
                btn.setBackground(colorBotonVerde);
            } else {
                btn.setBackground(colorBotonCafes);
            }
        }

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.add(btnVolver);
        panelBotones.add(btnRefrescar);
        panelBotones.add(btnIrOrden);
        add(panelBotones, BorderLayout.SOUTH);

        btnVolver.addActionListener(e -> marco.mostrar("INICIO"));
        btnIrOrden.addActionListener(e -> marco.mostrar("AGREGAR"));
        btnRefrescar.addActionListener(e -> {
            txtMenu.setText("");

            if(Restaurante.Menu == null || Restaurante.Menu.isEmpty()){
                txtMenu.setText("El menú está vacío.");
                return;
            } 
            txtMenu.append(String.format("%-15s %-25s %-10s %-15s\n", "CATEGORIA", "NOMBRE", "PRECIO", "TIEMPO PREP."));
            txtMenu.append("-----------------------------------------------------------------------\n");
            
                for (Platillo p : Restaurante.Menu) {
                    String categoria = "Platillo";
                    if (p instanceof PlatilloFuerte){
                        categoria = "Plato Fuerte";
                    }else if (p instanceof Bebida){
                        categoria = "Bebida";
                    } else if (p instanceof Postre){
                        categoria = "Postre";
                    }

                    long tiempoSegundos = 15;
                    try{
                        long tiempoMili = p.getTiempoPreparacion();
                        if (tiempoMili>0){
                            tiempoSegundos = tiempoMili/100;
                        }
                    }catch (Exception ex){
                        
                    }

                    txtMenu.append(String.format("%-15s %-25s $%-9.2f %d segundos\n", categoria, p.getNombre(), (double) p.getPrecio(), tiempoSegundos));                }
        });
    }

}
