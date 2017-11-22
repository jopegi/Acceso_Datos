package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class GestionDatos {

	public GestionDatos() {

	}

	//TODO: Implementa una función para abrir ficheros
	
	//TODO: Implementa una función para cerrar ficheros
	
	public boolean compararContenido (String fichero1, String fichero2) throws FileNotFoundException{
		
		File f1 = new File(fichero1);
		
		File f2 = new File(fichero2);
		
		
		if (f1.length() != (f2.length())) {
			
			System.out.println("Los ficheros son diferentes");
			
		}else {
			
			
		
		BufferedReader br1 = new BufferedReader(new FileReader(f1));
		
		BufferedReader br2 = new BufferedReader(new FileReader(f2));
		
		
		}
		
		return true;
	}
	
	public int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion){
		//TODO: Implementa la función
		return 1;
	}	

}
