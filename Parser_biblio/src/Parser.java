import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Parser {
	
	private Document dom = null;
	private ArrayList<Libro> libros = null;
	
	
	public Parser() {
		
		libros = new ArrayList<Libro>();
			
	}
	
	public void parseDocumentXML (String ficheroxml) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder db;
		
		try {
			
			db = dbf.newDocumentBuilder();
			Document dom = db.parse(ficheroxml);
			
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		} catch (SAXException | IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
