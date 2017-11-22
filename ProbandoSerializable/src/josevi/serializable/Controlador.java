package josevi.serializable;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Controlador {

	// private Coche coche= null;

	public Controlador() {

	}
	

	public void guardarObjeto(Coche c, String f) {

		ObjectOutputStream o = null;

		try {

			o = new ObjectOutputStream(new FileOutputStream(f));

			o.writeObject(c);

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			intentarCerrar(o);
		}

	}
	
	
	public Coche recuperarObjeto(String f) {
		
		Coche c = null;
		ObjectInputStream in = null;
		
		try {
			
			in = new ObjectInputStream (new FileInputStream(f));
			c = (Coche) in.readObject();
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}finally {
			
			intentarCerrar(in);
		}
		
		return c;


	}
	

	public void intentarCerrar(Closeable c) {

		try {

			if (c != null) {

				c.close();

			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
