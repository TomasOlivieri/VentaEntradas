package ventaentradas.View;

import VentaEntradas.Model.Estadio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import ventaentradas.Controller.ControllerEstadio;

public class ButtonEditor extends DefaultCellEditor {
    private JButton button;
    private boolean isPushed;
    private List<Estadio> estadios;
    private int row;
    private ControllerEstadio controller;

    public ButtonEditor(JButton btn, List<Estadio> estadios, ControllerEstadio controller) {
        super(new JTextField());
        this.button = btn;
        this.estadios = estadios;
        this.controller = controller;
        this.button.addActionListener(e -> fireEditingStopped());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        isPushed = true;
        button.setText((value == null) ? "" : value.toString());
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            Estadio estadio = estadios.get(row);
            if ("🗑️".equals(button.getText())) {
                int confirm = JOptionPane.showConfirmDialog(button, "¿Seguro que quieres eliminar el estadio: " + estadio.getDescripcion() + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    controller.eliminarEstadio(estadio);
                    estadios.remove(estadio);
                    SwingUtilities.getWindowAncestor(button).dispose();
                    new VentanaEstadios(estadios);
                    JOptionPane.showMessageDialog(button, "Estadio eliminado y lista actualizada.");
                }

            }
        }
        isPushed = false;
        return button.getText();
    }
}