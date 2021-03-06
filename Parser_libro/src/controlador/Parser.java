package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import modelo.Libro;


//Clase Parser encargada de convertir el contenido de un xml dado en una estructura DOM
public class Parser {


	private Document dom = null;
	private ArrayList<Libro> libros = null;

	public Parser() {
		libros = new ArrayList<Libro>();
	}

	//M�todo encargado de parsear un fichero xml
	//Lanzamos las excepciones que se capturar�n por el m�todo main de la clase Parser_Libro
	public void parseFicheroXml(String fichero) throws ParserConfigurationException, SAXException, IOException {
		
		//1. Creamos una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		//2. Creamos un DocumentBuilder
		DocumentBuilder db = dbf.newDocumentBuilder();

		//3. Parseamos el XML y obtenemos una representaci�n DOM
		dom = db.parse(fichero);
		


		/*try {
			
			//2. Creamos un DocumentBuilder
			DocumentBuilder db = dbf.newDocumentBuilder();

			//3. Parseamos el XML y obtenemos una representaci�n DOM
			dom = db.parse(fichero);
			
		} catch (ParserConfigurationException pce) {
			
			pce.printStackTrace();
			
		} catch (SAXException se) {
			
			se.printStackTrace();
			
		} catch (IOException ioe) {
			 
			ioe.printStackTrace();
		}*/

	}

	public void parseDocument() {
		// Obtenemos el elemento ra�z
		Element docEle = dom.getDocumentElement();

		// Obtenemos el nodelist de elementos
		NodeList nl = docEle.getElementsByTagName("libro");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				// Obtenemos un elemento de la lista (libro)
				// Cada elemento de la lista est� compuesto por el contenido de 
				// todas sus etiquetas anidadas
				Element el = (Element) nl.item(i);

				// Obtenemos una libro
				Libro p = getLibro(el);

				// lo a�adimos al array
				libros.add(p);
			}
		}
	}
	
	private Libro getLibro(Element libroEle){
		
		//para cada elemento libro, obtenemos: id, t�tulo, autor, a�o de publicaci�n, editor, n�mero de p�ginas
		int id = getIntValue(libroEle,"id");
		String titulo = getTextValue(libroEle,"titulo");
		String autor = getTextValue(libroEle,"autor");
		int anyo_publi = getIntValue(libroEle,"anyo_publicacion");
		String editor = getTextValue(libroEle,"editor");
		int num_Paginas = getIntValue(libroEle,"num_paginas");
		
		//Creamos una nueva persona con los elementos le�dos del nodo
		Libro e = new Libro(id,titulo,autor,anyo_publi,editor,num_Paginas);
		

		return e;		
		
	}
	
	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}		
		return textVal;
	}
	
	private int getIntValue(Element ele, String tagName) {				
		return Integer.parseInt(getTextValue(ele,tagName));
	}
	
	//Imprimimos por consola la info que almacena el objeto libro obtenido
	public void print() {

		//Para ello hacemos uso de las funcionalidades que la clase Iterator
		//ofrece para recorrer ArrayLists
		Iterator it = libros.iterator();
		while (it.hasNext()) {
			Libro l = (Libro) it.next();
			l.printInfo();
		}
	}
	
	

}
