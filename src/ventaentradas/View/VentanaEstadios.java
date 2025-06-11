package ventaentradas.View;

import VentaEntradas.Model.Estadio;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import ventaentradas.Controller.ControllerEstadio;
import ventaentradas.View.ButtonEditor;
import ventaentradas.View.ButtonRenderer;
import ventaentradas.View.PantallaBienvenida;

public class VentanaEstadios extends JFrame {

    public VentanaEstadios(List<Estadio> estadios) {
        setTitle("Lista de Estadios");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Columnas de la tabla
        String[] columnNames = {"ID", "Nombre", "Capacidad", "Editar", "Eliminar"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        for (Estadio e : estadios) {
            model.addRow(new Object[]{e.getIdEstadio(), e.getDescripcion(), e.getCapacidad(), "Editar️", "Eliminar️"});
        }

        // Renderizar los botones de Editar y Eliminar
        table.getColumn("Editar").setCellRenderer(new ButtonRenderer());
        table.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());

        // Agregar acción a los botones
        ControllerEstadio controller = new ControllerEstadio();
        table.getColumn("Editar").setCellEditor(new ButtonEditor(new JButton("Editar"), estadios, controller));
        table.getColumn("Eliminar").setCellEditor(new ButtonEditor(new JButton("Eliminar"), estadios, controller));

        // Botón "Volver"
        JButton btnVolver = new JButton("Volver a Inicio");
        btnVolver.addActionListener(e -> {
            new PantallaBienvenida();
            dispose();
        });

        // Organizar los componentes en un panel
        JPanel panelInferior = new JPanel();
        panelInferior.add(btnVolver);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }
}