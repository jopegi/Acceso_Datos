import java.io.File;
import java.util.ArrayList;

import javax.xml.transform.TransformerException;

public class Principal {

	public static void main(String[] args) {
		
		//**************PARSER: DE XML A OBJETO***************************************
		Parser parser = new Parser();
		parser.parseFicheroXml("biblioteca.xml");
		parser.parseDocument();
		parser.print();
		//**************FIN PARSER: DE XML A OBJETO***********************************
		
		
		
		//**************MARSHALLER: DE OBJETO A XML***************************************
			//Cargamos datos en un objeto libro
		ArrayList<String> autores = new ArrayList<String>();
		autores.add("Galvin");
		autores.add("Silbershtah");
		Libro l1 = new Libro("Sistemas Operativos",autores,"ASDF",200,2015);
			//Cargamos datos en un objeto libro
		ArrayList<String> autores2 = new ArrayList<String>();
		autores2.add("Pedro");
		autores2.add("Manolo");
		Libro l2 = new Libro("Linux",autores2,"ASDF",100,2014);
		
			//A�adimos los distintos libros a un ArrayList
		ArrayList<Libro> libros = new ArrayList<Libro>();
		libros.add(l1);
		libros.add(l2);
		
			//Creamos un objeto de tipo Marshaller
		Marshaller marshaller = new Marshaller(libros);
		
			//Creamos el Document que contendr� la estructura DOM
		marshaller.crearDocumento();
			//Creamos la estructura DOM del Document
		marshaller.crearArbolDOM();
			//Ya solo nos falta pasar la estructura de datos DOM a un formato de texto XML
		File file = new File("biblioteca2.xml");
		
		try {
			//Escribimos en el fichero XML la estructura DOM que hemos creado
			marshaller.escribirDocumentAXml(file);
		} catch (TransformerException e) {			
			e.printStackTrace();
		}
		
		//************FIN MARSHALLER: DE OBJETO A XML***************************************
		
		
	}

}
