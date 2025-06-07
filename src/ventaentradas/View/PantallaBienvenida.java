package ventaentradas.View;

import VentaEntradas.Model.Estadio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import ventaentradas.Controller.ControllerEstadio;

public class PantallaBienvenida extends JFrame {
    
    public PantallaBienvenida() {
        setTitle("Gestión de Estadios");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1, 10, 10));

        // Botón para mostrar estadios
        JButton btnMostrar = new JButton("Mostrar Estadios");
        btnMostrar.addActionListener(e -> {
            ControllerEstadio controller = new ControllerEstadio();
            List<Estadio> estadios = controller.obtenerEstadiosDesdeArchivos(); // Llama al controlador
            new VentanaEstadios(estadios); // Muestra la ventana con los estadios cargados
        });


        // Botón para dar de alta un nuevo estadio
        JButton btnAlta = new JButton("Dar de Alta Estadio");
        btnAlta.addActionListener(e -> {
            ControllerEstadio controller = new ControllerEstadio();
            new FormularioNuevoEstadio(controller); // Pasamos el controlador al formulario
        });

        // Agregar los botones a la ventana
        add(btnMostrar);
        add(btnAlta);

        setVisible(true);
    }
}

