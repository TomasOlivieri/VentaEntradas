package ventaentradas.Controller;

import VentaEntradas.DAO.ArchEstadioDAO;
import VentaEntradas.Model.Estadio;
import java.io.IOException;
import java.util.List;

public class ControllerEstadio {
    private ArchEstadioDAO estadioDAO;

    public ControllerEstadio() {
        this.estadioDAO = new ArchEstadioDAO();
    }

    // Método que obtiene los estadios desde los archivos usando el DAO
    public List<Estadio> obtenerEstadiosDesdeArchivos() {
        return estadioDAO.leerTodos();
    }

    // Método para guardar un estadio en archivo
    public void guardarEstadio(Estadio estadio) {
        try {
            estadioDAO.grabar(estadio);
        } catch (IOException e) {
            System.err.println("Error al guardar el estadio: " + e.getMessage());
        }
    }
}
