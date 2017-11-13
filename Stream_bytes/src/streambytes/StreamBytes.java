package streambytes;

import java.io.*;

public class StreamBytes {

	public static void intentarCerrar(Closeable c) {
		try {
			c.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Definir el perfil que se desee para esta función */
	public void copiaBytes() {

	}

	/* Definir el perfil que se desee para esta función */
	public void abrirFichero() {

	}

	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		try {

			fis = new FileInputStream("lena.jpg");
			fos = new FileOutputStream("lina.jpg");
			dos = new DataOutputStream(fos);

			byte[] buffer = new byte[5000];
			fis.read(buffer);
			fos.write(buffer);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			intentarCerrar(fis);
			intentarCerrar(fos);
			intentarCerrar(dos);
		}

	}

}
