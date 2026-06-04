import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
public class PanelAgregarOrden extends JPanel{
    private MarcoSencillo marco;
    private JTextField txtCliente, txtMesa;
    private JComboBox<String> comboPlatillos;
    private JComboBox<String> comboTerminos;
    private JLabel lblTermino;
    private JTextArea txtConsolaEstado;

    public PanelAgregarOrden(MarcoSencillo marco){
        this.marco = marco;
        setLayout(new BorderLayout());
        setBackground(new Color(210, 215, 211));
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel titulo = new JLabel("REGISTRAR NUEVA ORDEN");
        titulo.setFont(new Font("ASLONG TITLING", Font.BOLD, 30));
        titulo.setForeground(new Color(120, 62, 23));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        add(titulo, BorderLayout.NORTH);

        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font fuenteEtiquetas = new Font("Arial", Font.BOLD, 16);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lblCliente = new JLabel("Nombre del cliente:");
        lblCliente.setFont(fuenteEtiquetas);
        panelFormulario.add(lblCliente, gbc);

        gbc.gridx = 1;
        txtCliente = new JTextField(20);
        txtCliente.setFont(new Font("Arial", Font.PLAIN, 14));
        panelFormulario.add(txtCliente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lblMesa = new JLabel("Número de mesa:");
        lblMesa.setFont(fuenteEtiquetas);
        panelFormulario.add(lblMesa, gbc);

        gbc.gridx = 1;
        txtMesa = new JTextField(20);
        txtMesa.setFont(new Font("Arial", Font.PLAIN, 14));
        panelFormulario.add(txtMesa, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel lblPlatillo = new JLabel("Nombre del Platillo: ");
        lblPlatillo.setFont(fuenteEtiquetas);
        panelFormulario.add(lblPlatillo, gbc);

        gbc.gridx = 1;
        comboPlatillos = new JComboBox<>();
        comboPlatillos.setFont(new Font("Arial", Font.PLAIN, 14));
        for(Platillo p : Restaurante.Menu){
            comboPlatillos.addItem(p.getNombre());
        }
        panelFormulario.add(comboPlatillos, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        lblTermino = new JLabel("Término de cocción: ");
        lblTermino.setFont(fuenteEtiquetas);
        panelFormulario.add(lblTermino, gbc);

        gbc.gridx = 1;
        String[] terminos = {"Rare", "Medium rare", "Medium", "Medium well", "Well donde"};
        comboTerminos = new JComboBox<>(terminos);
        comboTerminos.setFont(new Font("Arial", Font.PLAIN, 14));
        panelFormulario.add(comboTerminos, gbc);
        
        txtConsolaEstado = new JTextArea(6, 30);
        txtConsolaEstado.setEditable(false);
        txtConsolaEstado.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtConsolaEstado.setBackground(Color.BLACK);
        txtConsolaEstado.setForeground(Color.GREEN);
        txtConsolaEstado.setText("Listo para capturar");
        JScrollPane scrollConsola = new JScrollPane(txtConsolaEstado);

        JPanel contenedorCentro = new JPanel(new BorderLayout(0, 15));
        contenedorCentro.setOpaque(false);
        contenedorCentro.add(panelFormulario, BorderLayout.NORTH);
        contenedorCentro.add(scrollConsola, BorderLayout.CENTER);
        add(contenedorCentro, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        panelBotones.setOpaque(false);

        JButton btnEnviar = new JButton("Enviar a la cocina");
        JButton btnVolver = new JButton("Volver al menú");

        btnEnviar.setPreferredSize(new Dimension(200, 45));
        btnEnviar.setBackground(new Color(34, 139, 34));
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setFont(new Font("Arial", Font.BOLD, 14));
        btnEnviar.setFocusable(false);

        btnVolver.setPreferredSize(new Dimension(160, 45));
        btnVolver.setBackground(new Color(161, 109, 64));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
        btnVolver.setFocusable(false);

        panelBotones.add(btnVolver);
        panelBotones.add(btnEnviar);
        add(panelBotones, BorderLayout.SOUTH);

        comboPlatillos.addActionListener(e ->{
            int index = comboPlatillos.getSelectedIndex();
            if (index>=0){
                Platillo seleccionado = Restaurante.Menu.get(index);
                if (seleccionado instanceof PlatilloFuerte){
                    comboTerminos.setEnabled(true);
                    lblTermino.setEnabled(true);
                }else{
                    comboTerminos.setEnabled(false);
                    lblTermino.setEnabled(false);
                }
            }
        });
        if (comboPlatillos.getItemCount()>0){
            comboPlatillos.getActionListeners()[0].actionPerformed(null);
        }

        btnVolver.addActionListener(e -> marco.mostrar("Menu"));
        btnEnviar.addActionListener(e ->{
            String nombreCliente = txtCliente.getText().trim();
            String mesaStr = txtMesa.getText().trim();

            if(nombreCliente.isEmpty() || mesaStr.isEmpty()){
                JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Campos incompletos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int numeroMesa = 0;
            try {
                numeroMesa = Integer.parseInt(mesaStr);
                if(numeroMesa <= 0){
                    throw new IllegalArgumentException("Número de mesa debe ser mayor a 0.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Número de mesa debe ser un número entero.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Entrada inválida", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int indexPlatillo = comboPlatillos.getSelectedIndex();
            Platillo platilloEncontrado = Restaurante.Menu.get(indexPlatillo);
            if(platilloEncontrado != null){
                if (platilloEncontrado instanceof PlatilloFuerte){
                    String terminoStr = (String) comboTerminos.getSelectedItem();
                    ((PlatilloFuerte) platilloEncontrado).setTerminoCoccion(terminoStr);
                }
                Cliente cliente = new Cliente(nombreCliente, numeroMesa, false);
                ColaDeOrden nuevaOrden = new ColaDeOrden(platilloEncontrado, LocalDateTime.now(), cliente);

                Restaurante.colaDeOrdenes.add(nuevaOrden);

                txtConsolaEstado.append("Orden agregada: "+platilloEncontrado.getNombre()+" para mesa " +numeroMesa +" ("+nombreCliente +")");
                JOptionPane.showMessageDialog(this, "Orden enviada a la cocina con éxito");

                txtCliente.setText("");
                txtMesa.setText("");
                txtCliente.requestFocus();
            }
        });
    }

}
