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
	Accion acc = null;

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

		NodeList nodoAcciones = raizDocumento.getElementsByTagName("accion");

		if (nodoAcciones != null && nodoAcciones.getLength() > 0) {

			for (int i = 0; i < nodoAcciones.getLength(); i++) {

				Element elementoAccion = (Element) nodoAcciones.item(i);

				NodeList nodoAccion1 = elementoAccion.getElementsByTagName("nombre");

				if (nodoAccion1 != null && nodoAccion1.getLength() > 0) {

					Element elementoNombre = (Element) nodoAccion1.item(0);

					String nombre = elementoNombre.getFirstChild().getNodeValue();

					System.out.println("El nombre de la acción es: " + nombre);

					acc = new Accion(nombre);

					ArrayList<Compra> compras = new ArrayList<Compra>();

					ArrayList<Venta> ventas = new ArrayList<Venta>();

					NodeList nodoAccion2 = elementoAccion.getElementsByTagName("operaciones");

					if (nodoAccion2 != null && nodoAccion2.getLength() > 0) {

						Element elementoOperaciones = (Element) nodoAccion2.item(0);

						NodeList nodoOperaciones = elementoOperaciones.getElementsByTagName("compras");

						if (nodoOperaciones != null && nodoOperaciones.getLength() > 0) {

							for (int a = 0; a < nodoAcciones.getLength(); a++) {

								Element elementoCompra = (Element) nodoAcciones.item(a);

								Compra nuevaCompra = getCompra(elementoCompra);

								compras.add(nuevaCompra);

							}

							acc.setCompras(compras);
						}

						NodeList nodoOperaciones2 = elementoOperaciones.getElementsByTagName("ventas");

						if (nodoOperaciones2 != null && nodoOperaciones2.getLength() > 0) {

							for (int e = 0; e < nodoAcciones.getLength(); e++) {

								Element elementoVenta = (Element) nodoAcciones.item(e);

								Venta nuevaVenta = getVenta(elementoVenta);

								ventas.add(nuevaVenta);

							}
							
							acc.setVentas(ventas);

						}

					}

				}

			}
		}
		
		acc.print();

	}

	private Compra getCompra(Element compraEle) {

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
	}


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
