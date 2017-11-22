import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		
		File directorio1 = new File ("directorio1");
		File directorio2 = new File ("directorio2");

		
		try {
			
			localizar(directorio1);
			localizar(directorio2);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
			System.err.println("La ruta que indicada no existe o coincide con la de un directorio");
		}
		
		comparar(directorio1, directorio2);
		

	}
	
	
	public static void localizar(File f) throws IOException{
		
		if (!f.exists()) {
			
			throw new IOException("El directorio no existe");
		}
		
		if (!f.isDirectory()) {
			
			throw new IOException("La ruta no se corresponde con un directorio");
		}
		
	}
	
	public static void comparar(File f1, File f2){
		
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("Comparación\n");
		
		String[] s1 = f1.list();
		String [] s2 = f2.list();
		
		int num_contenido_f1 = s1.length;
		int num_contenido_f2 = s2.length;
		
		sb.append("\tNúmero de ficheros/directorios del directorio1:" + num_contenido_f1+"\n");
		
		sb.append("\tNúmero de ficheros/directorios del directorio2:" + num_contenido_f2+"\n");
		
		if (num_contenido_f1>=num_contenido_f2) {
			sb.append("\t El directorio1 contiene mayor número de ficheros/directorios que el directorio2");
		}else {
			sb.append("\t El directorio2 contiene mayor número de ficheros/directorios que el directorio1");
		}
		
		sb.toString();
		
		System.out.println(sb);
		
	}

}

