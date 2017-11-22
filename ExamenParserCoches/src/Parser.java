
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
	private ArrayList<Taller> concesionarios = new ArrayList<Taller>();
	
	private Coche c;
	private Direccion d;
	private Taller t;

	private String nombreCalle;
	private String nombreLocalidad;
	
	private String nombreMarca;
	private String nombreModelo;
	
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

		NodeList nodoConcesionarios = docEle.getElementsByTagName("taller");

		if (nodoConcesionarios != null && nodoConcesionarios.getLength() > 0) {

			for (int i = 0; i < nodoConcesionarios.getLength(); i++) {

				Element elementoTaller = (Element) nodoConcesionarios.item(i);

				NodeList nodoTaller1 = elementoTaller.getElementsByTagName("nombre");

				if (nodoTaller1 != null && nodoTaller1.getLength() > 0) {

					Element elementoNombreTaller = (Element) nodoTaller1.item(0);

					String nombreTaller = elementoNombreTaller.getFirstChild().getNodeValue();

					//System.out.println("Nombre del taller: " + nombreTaller);
					
					t = new Taller(nombreTaller);
				}

				NodeList nodoTaller2 = elementoTaller.getElementsByTagName("direccion");

				if (nodoTaller2 != null && nodoTaller2.getLength() > 0) {

					for (int j = 0; j < nodoTaller2.getLength(); j++) {

						Element elementoDireccion = (Element) nodoTaller2.item(j);

						NodeList nodoDireccion1 = elementoDireccion.getElementsByTagName("nombre");

						if (nodoDireccion1 != null && nodoDireccion1.getLength() > 0) {

							Element elementoNombreDir = (Element) nodoDireccion1.item(0);

							nombreCalle = elementoNombreDir.getFirstChild().getNodeValue();

							//System.out.println("Dirección del taller: " + nombreCalle);
						}

						NodeList nodoDireccion2 = elementoDireccion.getElementsByTagName("poblacion");

						if (nodoDireccion2 != null && nodoDireccion2.getLength() > 0) {

							Element elementoPoblacionDir = (Element) nodoDireccion2.item(0);

							nombreLocalidad = elementoPoblacionDir.getFirstChild().getNodeValue();

							//System.out.println("Localidad del taller: " + nombreLocalidad);
						}
						
						d = new Direccion(nombreCalle,nombreLocalidad);
						
					}
				}

				NodeList nodoTaller3 = elementoTaller.getElementsByTagName("coches");

				if (nodoTaller3 != null && nodoTaller3.getLength() > 0) {

					Element elementoCoches = (Element) nodoTaller3.item(0);

					NodeList nodoCoche = elementoCoches.getElementsByTagName("coche");

					if (nodoCoche != null && nodoCoche.getLength() > 0) {

						for (int k = 0; k < nodoCoche.getLength(); k++) {

							Element elementoCoche = (Element) nodoCoche.item(k);

							NodeList nodoMarca = elementoCoche.getElementsByTagName("marca");

							if (nodoMarca != null && nodoMarca.getLength() > 0) {

								Element elementoMarca = (Element) nodoMarca.item(0);

								nombreMarca = elementoMarca.getFirstChild().getNodeValue();

								//System.out.println("Marca del coche: " + nombreMarca);
							}

							NodeList nodoModelo = elementoCoche.getElementsByTagName("modelo");
							
							if (nodoModelo != null && nodoModelo.getLength() > 0) {

								Element elementoModelo = (Element) nodoModelo.item(0);

								nombreModelo= elementoModelo.getFirstChild().getNodeValue();

								//System.out.println("Modelo del coche: " + nombreModelo);
							}

							c = new Coche(nombreMarca,nombreModelo);
						}

					}

				}
				concesionarios = new ArrayList<Taller>();
				t.setCoche(c);
				t.setDireccion(d);
				concesionarios.add(t);
				
				Iterator it = concesionarios.iterator();
				
				while(it.hasNext()) {
					
					Taller tllr = (Taller) it.next();
					tllr.print();
			}
			

		}
	
		}
	
	}

	public void print() {

		Iterator it = concesionarios.iterator();
		while (it.hasNext()) {
			Taller t = (Taller) it.next();
			t.print();
			System.out.println("-----------------------------\n");
		}
	}

}
