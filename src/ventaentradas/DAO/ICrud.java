package VentaEntradas.DAO;

import java.io.IOException;
import java.util.List;

public interface ICrud<T> {
	
	public void grabar(T t) throws IOException;
	public T leer() throws IOException, ClassNotFoundException;
	public T leer(Integer id) throws IOException, ClassNotFoundException;
	public List<T> leerTodos() throws IOException, ClassNotFoundException;
	public void modificar(T t) throws IOException, ClassNotFoundException;
        public void eliminar(T t) throws IOException, ClassNotFoundException; 

}