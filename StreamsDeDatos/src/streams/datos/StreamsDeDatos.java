package streams.datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StreamsDeDatos {

	public static void main(String[] args) {
		
		try {
			
			FileReader fr = new FileReader (new File ("ficheroDatos.txt"));
			
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter (new File ("ficheroSalida.txt"));
			
			BufferedWriter bw = new BufferedWriter(fw);
			
			String liniaLeida;
			int contador = 0;
			
			while((liniaLeida=br.readLine()) != null) {
				
				contador ++;
				
				System.out.println("Línia " + contador + ": "+liniaLeida);
				
				bw.write(liniaLeida+"\n");
			}
			
			
			/*int leer;
			
			while((leer = fr.read())!= -1) {
				
				System.out.print((char)leer);
				
				fw.write(leer);
			}*/
			
			//fr.close();
			//fw.close();
			bw.close();
			br.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
