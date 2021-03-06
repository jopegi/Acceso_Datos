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

public class Parser {

	private Document dom = null;
	private ArrayList<Persona> personas = null;

	public Parser() {

		personas = new ArrayList<Persona>();
	}

	public void parseFicheroXML(String fichero) {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;

		try {
			db = dbf.newDocumentBuilder();
			Document dom = db.parse(fichero);

		} catch (ParserConfigurationException e) {

			e.printStackTrace();

		} catch (SAXException | IOException e) {

			e.printStackTrace();
		}
	}

	public void parseDocument() {

		Element DocEl = dom.getDocumentElement();

		NodeList nl = DocEl.getElementsByTagName("persona");

		if (nl != null && nl.getLength() > 0) {

			for (int i = 0; i < nl.getLength(); i++) {

				Element el = (Element) nl.item(i);

				Persona p = getPersona(el);

				personas.add(p);
			}
		}

	}

	public Persona getPersona(Element e) {

		String nombre = getTextValue(e, "nombre");
		int edad = getIntValue(e, "edad");

		Persona pers = new Persona(nombre, edad);

		return pers;
	}

	public String getTextValue(Element el, String tag) {

		String textVal = null;

		NodeList nl = el.getElementsByTagName(tag);

		if (nl != null && nl.getLength() > 0) {

			Element elem = (Element) nl.item(0);
			textVal = elem.getFirstChild().getNodeValue();

		}

		return textVal;

	}
	
	public int getIntValue (Element e, String tag) {
		
		int a = Integer.parseInt(getTextValue(e,tag));
		
		return a;
	}
	
	
	public void print() {

		Iterator it = personas.iterator();
		while (it.hasNext()) {
			Persona p = (Persona) it.next();
			p.print();
			System.out.println("-----------------------------\n");
		}
	}

}
