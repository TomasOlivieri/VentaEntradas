package ventaentradas.View;

import VentaEntradas.Model.Estadio;
import javax.swing.*;
import java.awt.*;
import ventaentradas.Controller.ControllerEstadio;


public class FormularioNuevoEstadio extends JFrame {
    private JTextField txtId, txtNombre, txtCapacidad;

    public FormularioNuevoEstadio(ControllerEstadio controller) {
        setTitle("Nuevo Estadio");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Crear componentes
        add(new JLabel("ID de Estadio:"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Capacidad:"));
        txtCapacidad = new JTextField();
        add(txtCapacidad);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarEstadio(controller));
        add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        add(btnCancelar);

        setVisible(true);
    }

    private void guardarEstadio(ControllerEstadio controller) {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String nombre = txtNombre.getText().trim();
            int capacidad = Integer.parseInt(txtCapacidad.getText().trim());

            if (nombre.isEmpty() || capacidad <= 0) {
                JOptionPane.showMessageDialog(this, "Datos inválidos. Verifica los campos.");
                return;
            }

            Estadio nuevoEstadio = new Estadio(id, nombre, capacidad);
            controller.guardarEstadio(nuevoEstadio);

            JOptionPane.showMessageDialog(this, "Estadio agregado con éxito.");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: ID y capacidad deben ser números.");
        }
    }
}
