package josevi.personas;

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

	Document dom = null;
	Persona p = null;
	
	String dni;
	String nombre;
	int edad;
	float altura;

	public Parser() {

	}

	// Método para obtener la estructura DOM del documento xml
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

		Element raizDocumento = dom.getDocumentElement();

		NodeList nodoPersonas = raizDocumento.getElementsByTagName("persona");

		if (nodoPersonas != null && nodoPersonas.getLength() > 0) {

			for (int i = 0; i < nodoPersonas.getLength(); i++) {

				Element elementoPersona = (Element) nodoPersonas.item(i);

				NodeList nodoPersona = elementoPersona.getElementsByTagName("pers");

				if (nodoPersona != null && nodoPersona.getLength() > 0) {

					for (int a = 0; a < nodoPersona.getLength(); a++) {

						Element elementoPers = (Element) nodoPersona.item(a);
						
						dni = elementoPers.getAttribute("dni");
						
						//System.out.println(dni);

						NodeList nodoPers = elementoPers.getElementsByTagName("nombre");
						NodeList nodoPers2 = elementoPers.getElementsByTagName("altura");
						NodeList nodoPers3 = elementoPers.getElementsByTagName("edad");

						if (nodoPers != null && nodoPers.getLength() > 0) {

							Element elementoNombre = (Element) nodoPers.item(0);

							nombre = elementoNombre.getFirstChild().getNodeValue();
							
							//System.out.println(nombre);
						}
						
						if (nodoPers2 != null && nodoPers2.getLength() > 0) {

							Element elementoAltura = (Element) nodoPers2.item(0);

							altura = Float.parseFloat(elementoAltura.getFirstChild().getNodeValue());
							
							//System.out.println(altura);
						}
						
						if (nodoPers3 != null && nodoPers3.getLength() > 0) {

							Element elementoEdad = (Element) nodoPers3.item(0);

							edad = Integer.parseInt(elementoEdad.getFirstChild().getNodeValue());
							
							//System.out.println(edad);
						}
						
						
						p = new Persona(dni, nombre, altura, edad);
						
						p.print();

					}
					

				}
			}

		}

	}

	/*private Compra getCompra(Element compraEle) {

		int cantidad = getIntValue(compraEle, "cantidad");
		float precio = getFloatValue(compraEle, "precio");

		Compra c = new Compra(cantidad, precio);

		return c;
	}

	private Venta getVenta(Element ventaEle) {

		int cantidad = getIntValue(ventaEle, "cantidad");
		float precio = getFloatValue(ventaEle, "precio");

		Venta v = new Venta(cantidad, precio);

		return v;
	}*/

	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}
		return textVal;
	}

	private int getIntValue(Element ele, String tagName) {
		return Integer.parseInt(getTextValue(ele, tagName));
	}

	private float getFloatValue(Element ele, String tagName) {
		return Float.parseFloat(getTextValue(ele, tagName));
	}

}
