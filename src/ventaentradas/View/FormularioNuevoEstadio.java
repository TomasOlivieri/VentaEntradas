package ventaentradas.View;

import VentaEntradas.Model.Estadio;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FormularioNuevoEstadio extends JFrame {
    private JTextField txtId, txtNombre, txtCapacidad;
    private List<Estadio> estadios;

    public FormularioNuevoEstadio(List<Estadio> estadios) {
        this.estadios = estadios;

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
        btnGuardar.addActionListener(e -> guardarEstadio());
        add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        add(btnCancelar);

        setVisible(true);
    }

    private void guardarEstadio() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String nombre = txtNombre.getText().trim();
            
            
            int capacidad = Integer.parseInt(txtCapacidad.getText().trim());

            // Validaciones básicas
            if (nombre.isEmpty() || capacidad <= 0) {
                JOptionPane.showMessageDialog(this, "Datos inválidos. Verifica los campos.");
                return;
            }

            // Crear el estadio y agregarlo a la lista
            Estadio nuevoEstadio = new Estadio(id, nombre, capacidad);
            estadios.add(nuevoEstadio);

            JOptionPane.showMessageDialog(this, "Estadio agregado con éxito.");
            dispose(); // Cerrar la ventana después de agregarlo
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: ID y capacidad deben ser números.");
        }
    }
}
