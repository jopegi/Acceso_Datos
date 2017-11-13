import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Almacen {
	
	//M�TODOS DE LA CLASE
	
	// M�todo para guardar objetos serializables
	// Recibe como par�metro un objeto a guardar y el nombre del fichero en que se
	// guardar�
	public void guardarObjeto(Libro lib, String fichero) {

		ObjectOutputStream out = null;

		try {

			// Creamos un Stream de objetos
			out = new ObjectOutputStream(new FileOutputStream(fichero));
			// Escribimos en el fichero el Objeto de tipo Libro serializable
			out.writeObject(lib);

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			
			//Cerramos el stream de objetos
			cerrarStreamObjetos(out);
		}
	}
	
	// M�todo para cerrar streams
	public void cerrarStreamObjetos(Closeable c) {
		
		try {
			if (c != null) {
				c.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Libro recuperarLibro (String fichero) {
		
		Libro lib = null;
		ObjectInputStream ois = null;
		
		try {
			//Creamos un objeto de tipo ObjectInputStream a partir de la informaci�n de un fichero de datos
			ois = new ObjectInputStream(new FileInputStream(fichero));
			//Mediante el stream de objetos, leemos la informaci�n del fichero de datos y la volvemos a guardar
			//en un objeto serializable de tipo Libro
			//Nota: Puesto que el m�todo readObject() lee objetos, hacemos un casting
			// al tipo de objeto que queremos guardar, en este caso, Libro
			lib = (Libro) ois.readObject();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("No se encuentra el fichero");
			
		}catch(IOException e) {
			e.printStackTrace();
			System.err.println("Erro IO");
			
		}finally {
			//Cerramos el stream
			cerrarStreamObjetos(ois);
		}
		
		return lib;
	}
	
	
	public Almacen() {
		
	}
	
	
	

}
