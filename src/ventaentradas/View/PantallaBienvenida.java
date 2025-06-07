package ventaentradas.View;

import VentaEntradas.Model.Estadio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PantallaBienvenida extends JFrame {
    
    public PantallaBienvenida(List<Estadio> estadios) {
        setTitle("Gestión de Estadios");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1, 10, 10));

        // Botón para mostrar estadios
        JButton btnMostrar = new JButton("Mostrar Estadios");
        btnMostrar.addActionListener(e -> new VentanaEstadios(estadios));

        // Botón para dar de alta un nuevo estadio
        JButton btnAlta = new JButton("Dar de Alta Estadio");
        btnAlta.addActionListener(e -> new FormularioNuevoEstadio(estadios)); // Se abrirá el formulario

        // Agregar los botones a la ventana
        add(btnMostrar);
        add(btnAlta);

        setVisible(true);
    }
}

