package ventaentradas.View;

import VentaEntradas.Model.Estadio;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import ventaentradas.Controller.ControllerEstadio;


public class FormularioEditarEstadio extends JFrame {
    private JTextField txtDescripcion, txtCapacidad;
    private Estadio estadio;
    private ControllerEstadio controller;
    private JTable table;

    public FormularioEditarEstadio(Estadio estadio, ControllerEstadio controller, JTable table) {
        this.estadio = estadio;
        this.controller = controller;
        this.table = table;

        setTitle("Editar Estadio");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField(estadio.getDescripcion());
        add(txtDescripcion);

        add(new JLabel("Capacidad:"));
        txtCapacidad = new JTextField(String.valueOf(estadio.getCapacidad()));
        add(txtCapacidad);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarCambios());
        add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        add(btnCancelar);

        setVisible(true);
    }

    private void guardarCambios() {
        try {
            String nuevaDescripcion = txtDescripcion.getText().trim();
            int nuevaCapacidad = Integer.parseInt(txtCapacidad.getText().trim());

            if (nuevaDescripcion.isEmpty() || nuevaCapacidad <= 0) {
                JOptionPane.showMessageDialog(this, "Datos inválidos. Verifica los campos.");
                return;
            }

            estadio.setDescripcion(nuevaDescripcion);
            estadio.setCapacidad(nuevaCapacidad);
            try {
                controller.actualizarEstadio(estadio);
            } catch (IOException ex) {
                System.getLogger(FormularioEditarEstadio.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }

            JOptionPane.showMessageDialog(this, "Estadio actualizado con éxito.");
            dispose();

            // Recargar la tabla para mostrar los datos actualizados
            ((DefaultTableModel) table.getModel()).fireTableDataChanged();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: La capacidad debe ser un número válido.");
        }
    }
}