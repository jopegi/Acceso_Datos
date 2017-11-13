package controlador;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import controlador.Parser;
//import controlador.GestionEventos;
//import vista.Ventana;

public class Parser_Libro {
	
	 
	
	public static void main(String[] args) {
		
		
		
		//Mediante un JOptionPane se recoge el fichero xml que indique el usuario
		String xml = JOptionPane.showInputDialog("Por favor, indique el documento xml que desea parsear");
		 
		try {
		Parser parser=new Parser();
		parser.parseFicheroXml(xml);
		//parser.parseFicheroXml("libros.xml");
		//parser.parseFicheroXml("libros.xml");
		parser.parseDocument();
		parser.print();
		}catch (ParserConfigurationException e) {
			System.err.print("ha fallado el parseo!");
			e.printStackTrace();
			
		} catch (SAXException e) {
			System.err.print("ha fallado el parseo!");
			e.printStackTrace();
			
		}catch (IOException e) {
			System.err.print("ha fallado el parseo!");
			e.printStackTrace();
		}

	}

}
