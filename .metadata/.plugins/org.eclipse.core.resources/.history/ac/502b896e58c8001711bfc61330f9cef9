import java.io.File;
import java.util.ArrayList;

import javax.xml.transform.TransformerException;

public class Principal {

	public static void main(String[] args) {
		Parser parser = new Parser();
		parser.parseFicheroXml("biblioteca.xml");
		parser.parseDocument();
		parser.print();
		
		ArrayList<String> autores = new ArrayList<String>();
		autores.add("Galvin");
		autores.add("Silbershtah");
		Libro l1 = new Libro("Sistemas Operativos",autores,"ASDF",200,2015);
		ArrayList<String> autores2 = new ArrayList<String>();
		autores2.add("Pedro");
		autores2.add("Manolo");
		Libro l2 = new Libro("Linux",autores2,"ASDF",100,2014);
		
		ArrayList<Libro> libros = new ArrayList<Libro>();
		libros.add(l1);
		libros.add(l2);
		
		Marshaller marshaller = new Marshaller(libros);
		
		marshaller.crearDocumento();
		marshaller.crearArbolDOM();
		
		File file = new File("biblioteca2.xml");
		
		try {
			marshaller.escribirDocumentAXml(file);
		} catch (TransformerException e) {			
			e.printStackTrace();
		}
		
		
	}

}
