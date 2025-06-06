package ventaentradas;

import VentaEntradas.DAO.ArchEstadioDAO;
import VentaEntradas.Model.Estadio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ventaentradas.View.VentanaEstadios;



public class Main {
    public static void main(String[] args) {
        List<Estadio> listaEstadios; // Tu método para cargar estadios
        listaEstadios = new ArrayList<>();
        
        Estadio e1 = new Estadio (1, "Monumental", 100000);
        Estadio e2 = new Estadio (2, "La Plata", 100000);
        Estadio e3 = new Estadio (3, "Gran Rex", 100000);
        
        listaEstadios.add(e1);
        listaEstadios.add(e2);
        listaEstadios.add(e3);
        
        new VentanaEstadios(listaEstadios);
    }
}
