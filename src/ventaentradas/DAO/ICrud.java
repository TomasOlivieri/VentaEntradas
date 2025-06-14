package VentaEntradas.DAO;

import java.io.IOException;
import java.util.List;

public interface ICrud<T> {
	
	public void grabar(T t) throws IOException;
	public T leer() throws IOException, ClassNotFoundException;
	public T leer(Integer id) throws IOException, ClassNotFoundException;
	public List<T> leerTodos();
	public void modificar(T t);
        public void eliminar(T t); 

}