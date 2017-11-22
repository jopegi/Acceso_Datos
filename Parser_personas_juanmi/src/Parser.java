import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	private Document dom = null;
	private ArrayList<Persona> listapersonas = new ArrayList<Persona>();

	public Parser() {
		
	}

	public void parseFicheroXml(String fichero) {
		// creamos una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			// creamos un documentbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// parseamos el XML y obtenemos una representación DOM
			dom = db.parse(fichero);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
	
	public void parseDocument() {
		// obtenemos el elemento raíz
		Element docEle = dom.getDocumentElement();
		
		NodeList n1 = docEle.getElementsByTagName("persona");
		
		if (n1 != null && n1.getLength() > 0) {
			
			for(int i=0; i<n1.getLength(); i++) {
				
				Element persoEle = (Element) n1.item(i);
				
				Persona persona = new Persona();
				
				NodeList n2 = persoEle.getElementsByTagName("pers");
				
				
				if (n2 != null && n2.getLength() > 0) {
					
					for(int j=0; j<n2.getLength(); j++) {
						
						Element persEle = (Element) n2.item(j);
						Pers p = new Pers();
						
						String dni = persEle.getAttribute("dni");
						
						System.out.println("Dni: "+dni);
						p.setDni(dni);
						
						String n = getValores(persEle, "nombre");
						p.setNombre(n);
						
						String a = getValores(persEle, "altura");
						p.setAltura(Float.parseFloat(a));
						
						String e = getValores(persEle, "edad");
						p.setEdad(Integer.parseInt(e));
						
						persona.getArraypers().add(p);
						
					}
					
					
				}
				listapersonas.add(persona);
				
			}
			
		}
	}
			
		
		public String getValores(Element e, String etiqueta){
			NodeList n3 = e.getElementsByTagName(etiqueta);
			String n="";
			
			if (n3 != null && n3.getLength() > 0) {
				
				Element elNombre = (Element) n3.item(0);				
				n = elNombre.getFirstChild().getNodeValue();
				
			}
			return n;
		}
		
		
		
}
	
