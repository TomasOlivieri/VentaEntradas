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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear tabla
        String[] columnNames = {"ID", "Descripcion", "Capacidad"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        // Agregar estadios a la tabla
        for (Estadio e : estadios) {
            model.addRow(new Object[]{e.getIdEstadio(), e.getDescripcion(), e.getCapacidad()});
        }

        // Agregar la tabla a la ventana
        add(new JScrollPane(table), BorderLayout.CENTER);

        setVisible(true);
    }
}