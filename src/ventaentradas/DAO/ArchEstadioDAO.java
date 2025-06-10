package VentaEntradas.DAO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.io.File;
import VentaEntradas.Model.Estadio;
import java.util.ArrayList;


public class ArchEstadioDAO implements ICrud <Estadio>{
    private static final String nombreArchivo = "Archivos/Estadios";

    @Override
	public void grabar(Estadio e) throws IOException {
            File carpeta = new File(nombreArchivo);
            File archivo = new File(carpeta, e.getIdEstadio() + ".txt");
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(e);
            oos.close();
            fos.close();
        }

        
    @Override
	public Estadio leer() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(nombreArchivo);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Estadio e = (Estadio) ois.readObject();
		ois.close();
		fis.close();
		return e;
	}

        
    @Override
	public Estadio leer(Integer id) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(String.valueOf(id));
		ObjectInputStream ois = new ObjectInputStream(fis);
		Estadio e = (Estadio) ois.readObject();
		ois.close();
		fis.close();
		return e;
	}

        
    @Override
        public List<Estadio> leerTodos() {
            List<Estadio> estadios = new ArrayList<>();
            File carpeta = new File(nombreArchivo);

            // Obtener todos los archivos en la carpeta
            File[] archivos = carpeta.listFiles((dir, name) -> name.endsWith(".txt"));

            if (archivos != null) {
                for (File archivo : archivos) {
                    try (FileInputStream fis = new FileInputStream(archivo);
                        ObjectInputStream ois = new ObjectInputStream(fis)) {

                        Estadio estadio = (Estadio) ois.readObject();
                        estadios.add(estadio);

                    } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Error al leer el archivo: " + archivo.getName());
                }
            }
        }
        return estadios;
    }
    

    @Override
    public void modificar(Estadio t) {
        System.out.println("a implementar");
    }

    
    @Override
    public void eliminar(Estadio t) {
        File carpeta = new File(nombreArchivo);
        File archivo = new File(carpeta, t.getIdEstadio() + ".txt");

        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("Estadio eliminado correctamente: " + t.getIdEstadio());
            } else {
                System.err.println("Error al eliminar el archivo del estadio: " + t.getIdEstadio());
            }
        } else {
        System.err.println("El archivo del estadio no existe: " + t.getIdEstadio());
    }
}


}
