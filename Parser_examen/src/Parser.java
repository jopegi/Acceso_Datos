import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	private Document dom = null;
	private ArrayList<Accion> acciones;
	private ArrayList<Operacion> operaciones = new ArrayList<Operacion>();

	// Constructor de la clase Parser
	public Parser() {

		//acciones = new ArrayList<Accion>();
		//operaciones = new ArrayList<Operacion>();
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
		// obtenemos el elemento raíz <acciones>
		Element raiz = dom.getDocumentElement();

		// iteramos sobre los hijos de la raíz
		NodeList hijosRaiz = raiz.getElementsByTagName("accion");

		if (hijosRaiz != null && hijosRaiz.getLength() > 0) {

			for (int i = 0; i < hijosRaiz.getLength(); i++) {

				Element elementoAccion = (Element) hijosRaiz.item(i);
				String atributoNombre = elementoAccion.getAttribute("nombre");
				//System.out.println("Atributo nombre de la etiqueta <accion>: " + atributoNombre);
				Accion accion = new Accion(atributoNombre, operaciones);

				NodeList hijosAccion = elementoAccion.getElementsByTagName("operaciones");

				if (hijosAccion != null && hijosAccion.getLength() > 0) {

					Element elementoOperaciones = (Element) hijosAccion.item(0);
					NodeList hijosOperaciones = elementoOperaciones.getElementsByTagName("operacion");

					if (hijosOperaciones != null && hijosOperaciones.getLength() > 0) {

						for (int o = 0; o < hijosOperaciones.getLength(); o++) {

							Element elementoOperacion = (Element) hijosOperaciones.item(o);

							Operacion op = getOperacion(elementoOperacion);
							
							operaciones.add(op);
							
							accion.setOperaciones(operaciones);

						}
						
						
					}

				}
				accion.print();
			}
		}

	}

	private Operacion getOperacion(Element elementoOperacion) {

		String tipo = getTextValue(elementoOperacion, "tipo");
		int cantidad = getIntValue(elementoOperacion, "cantidad");
		double precio = getDoubleValue(elementoOperacion, "precio");

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

		return Integer.parseInt(getTextValue(e,tagName));

	}
	
	private double getDoubleValue(Element e, String tagName) {

		return Double.parseDouble(getTextValue(e,tagName));

	}
	
	private void printFinal () {
		
		
		
	}

}
