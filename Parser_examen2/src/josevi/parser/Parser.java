package josevi.parser;

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
	private ArrayList<Accion> acciones = null;

	public Parser() {
		acciones = new ArrayList<Accion>();

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

		NodeList nodoAccion = raizDocumento.getElementsByTagName("accion");

		if (nodoAccion != null && nodoAccion.getLength() > 0) {

			for (int i = 0; i < nodoAccion.getLength(); i++) {

				Element elementoAccion = (Element) nodoAccion.item(i);

				String atributoNombre = elementoAccion.getAttribute("nombre");

				ArrayList<Operacion> operaciones = new ArrayList<Operacion>();

				Accion ac = new Accion(atributoNombre);

				System.out.println("He encontrado el elemento: " + atributoNombre);

				NodeList nodoOperaciones = elementoAccion.getElementsByTagName("operaciones");

				if (nodoOperaciones != null && nodoOperaciones.getLength() > 0) {

					Element elementoOperaciones = (Element) nodoOperaciones.item(0);

					NodeList nodoOperacion = elementoOperaciones.getElementsByTagName("operacion");

					if (nodoOperacion != null && nodoOperacion.getLength() > 0) {

						for (int a = 0; a < nodoOperacion.getLength(); a++) {

							Element elementoOperacion = (Element) nodoOperacion.item(a);
							System.out.println("a vale: " + a);

							String tipo = getTextValue(elementoOperacion, "tipo");
							int cantidad = getIntValue(elementoOperacion, "cantidad");
							float precio = getFloatValue(elementoOperacion, "precio");

							System.out.println(
									"Tipo vale: " + tipo + "\nCantidad vale:" + cantidad + "\nPrecio vale:" + precio);

							Operacion o = new Operacion(tipo, cantidad, precio);

							operaciones.add(o);

						}

						ac.setOperaciones(operaciones);
					}

				}

				acciones.add(ac);
			}
		}

	}

	private Accion getAccion(Element elementoAccion, String atributoNombre) {
		return null;
	}

	private Operacion getOperacion(Element elementoOperacion) {

		String tipo = getTextValue(elementoOperacion, "tipo");
		int cantidad = getIntValue(elementoOperacion, "cantidad");
		float precio = getFloatValue(elementoOperacion, "precio");

		Operacion operacion = new Operacion(tipo, cantidad, precio);

		return operacion;

	}

	private String getTextValue(Element e, String tagName) {

		String textValue = null;

		NodeList nl = e.getElementsByTagName(tagName);

		if (nl != null && nl.getLength() > 0) {

			Element ele = (Element) nl.item(0);

			textValue = ele.getFirstChild().getNodeValue();
		}

		return textValue;

	}

	private int getIntValue(Element e, String tagName) {

		return Integer.parseInt(getTextValue(e, tagName));

	}

	private float getFloatValue(Element e, String tagName) {

		return Float.parseFloat(getTextValue(e, tagName));

	}

}
