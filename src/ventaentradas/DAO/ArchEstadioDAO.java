package VentaEntradas.DAO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import VentaEntradas.Model.Estadio;

public class ArchEstadioDAO implements ICrud <Estadio>{
    private static final String nombreArchivo = "Archivos/Estadio.txt";

    @Override
	public void grabar(Estadio e) throws IOException {
		FileOutputStream fos = new FileOutputStream(String.valueOf(e.getIdEstadio()).concat(".txt"));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(Estadio t) {
		// TODO Auto-generated method stub
		
	}

}
