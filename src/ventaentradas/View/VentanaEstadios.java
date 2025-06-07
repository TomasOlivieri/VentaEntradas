package ventaentradas.View;

import VentaEntradas.Model.Estadio;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaEstadios extends JFrame {

    public VentanaEstadios(List<Estadio> estadios) {
        setTitle("Lista de Estadios");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear tabla
        String[] columnNames = {"ID", "Nombre", "Capacidad"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        for (Estadio e : estadios) {
            model.addRow(new Object[]{e.getIdEstadio(), e.getDescripcion(), e.getCapacidad()});
        }

        // Crear botón "Volver"
        JButton btnVolver = new JButton("Volver a Inicio");
        btnVolver.addActionListener(e -> {
            new PantallaBienvenida();
            dispose(); // Cierra la ventana actual
        });

        // Organizar los componentes en un panel
        JPanel panelInferior = new JPanel();
        panelInferior.add(btnVolver);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }
}
