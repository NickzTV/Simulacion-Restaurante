import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
public class PanelAgregarOrden extends JPanel{
    private MarcoSencillo marco;
    private JTextField txtCliente, txtMesa, txtPlatillo;
    public PanelAgregarOrden(MarcoSencillo marco){
        this.marco = marco;
        setLayout(new BorderLayout());
        setBackground(new Color(210, 215, 211));

        JLabel titulo = new JLabel("REGISTRAR NUEVA ORDEN");
        titulo.setFont(new Font("ASLONG TITLING", Font.BOLD, 30));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(titulo, BorderLayout.NORTH);
    }

}
