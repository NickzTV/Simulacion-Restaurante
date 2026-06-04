package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PanelFiltroFecha extends JPanel{
    private MarcoSencillo marco;
    private JTextArea txtReporteFecha;
    private JComboBox<String> comboOrden;

    public PanelFiltroFecha(MarcoSencillo marco){
        this.marco = marco;
        setLayout(new BorderLayout());
        setBackground(new Color(217, 190, 102));
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel titulo = new JLabel("REPORTE: ORDENES POR FECHA");
        titulo.setFont(new Font("ASLON TITLING", Font.BOLD, 26));
        titulo.setForeground(new Color(120, 62, 23));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        add(titulo, BorderLayout.NORTH);

        JPanel panelControl = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelControl.setOpaque(false);

        JLabel lblOrden = new JLabel("Ordenar por fecha:");
        lblOrdenar.setFont(new Font("Arial", Font.BOLD, 14));
        lblOrdenar.setForeground(new Color(120, 62, 23));

        comboOrden = new JComboBox<>();
        comboOrden.addItem("Mas antiguas primero");
        comboOrden.addItem("Mas recientes primero");
        comboOrden.setFont(new Font("Arial", Font.PLAIN, 13));
        comboOrden.setPreferredSize(new Dimension(280, 30));

        JButton btnConsultar = new JButton("Cargar");
        btnConsultar.setFont(new Font("Arial", Font.BOLD, 13));
        btnConsultar.setBackground(new Color(161, 109, 64));
        btnConsultar.setForeground(Color.WHITE);

        panelControl.add(lblOrdenar);
        panelControl.add(comboOrden);
        panelControl.add(btnConsultar);

        txtReporteFecha = new JTextArea();
        txtReporteFecha.setEditable(false);
        txtReporteFecha.setFont(new Font("Consolas", Font.PLAIN, 15));
        txtReporteFecha.setBackground(new Color(255, 253, 245));
        txtReporteFecha.setForeground(new Color(50, 30, 10));
        txtReporteFecha.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JScrollPane scrollPane = new JScrollPane(txtReporteFecha);

        JPanel contenedorCentro = new JPanel(new BorderLayout(0, 10));
        contenedorCentro.setOpaque(false);
        contenedorCentro.add(panelControl, BorderLayout.NORTH);
        contenedorCentro.add(scrollPane, BorderLayout.CENTER);
        add(contenedorCentro, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInferior.setOpaque(false);

        JButton btnVolver = new JButton("Volver al inicio");
        btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
        btnVolver.setBackground(new Color(153, 9, 9));
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setPreferredSize(new Dimension(160, 40));
        btnVolver.setFocusable(false);

        panelInferior.add(btnVolver);
        add(panelInferior, BorderLayout.SOUTH);

        btnConsultar.addActionListener(e -> {
            txtReporteFecha.setText("");

            File archivo = new File("Hisotrial.dat");
            if(!archivo.exists()){
                txtReporteFecha.setText("No se ha encontrado el archivo de historial.");
                return;
            }
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))){
                @SuppressWarnings("unchecked")
                ArrayList<ColaDeOrden> listaOrdenes = (ArrayList<ColaDeOrden>) ois.readObject();

                if(listaOrdenes.isEmpty()){
                    txtReporteFecha.setText("No hay ordenes registradas en el historial.");
                    return;
                }
                int opcionSeleccionada = comboOrden.getSelectedIndex();
                if(opcionSeleccionada == 0){
                    listaOrdenes.sort(Comparator.comparing(ColaDeOrden::getFechaHora));
                }else {
                    listaOrdenes.sort(Comparator.comparing(ColaDeOrden::getFechaHora).reversed());
                }
                txtReporteFecha.append(String.format("%-20s %-25s %-15s\n", "FECHA Y HORA", "PLATILLO", "PRECIO"));
                txtReporteFecha.append("-------------------------------------------------------------\n");
                for(ColaDeOrden orden : listaOrdenes){
                    String fechaStr = orden.getFechaHora().toString().replace("T", " ").substring(0, 16);
                    String platillo = orden.getPlatillo().getNombre();
                    double precio = orden.getPlatillo().getPrecio();
                    txtReporteFecha.append(String.format("%-20s %-25s $%-15.2f\n", fechaStr, platillo, precio));
                }
            } catch (IOException | ClassNotFoundException ex){
                JOptionPane.showMessageDialog(this, "Error al cargar el historial: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
