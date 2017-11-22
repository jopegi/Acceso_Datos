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
	private ArrayList<Operacion> operaciones = null;
	ArrayList<Accion>  acciones = null;
	private Accion acc;

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

		Element docEle = dom.getDocumentElement();

		NodeList nodoAcciones = docEle.getElementsByTagName("accion");

		if (nodoAcciones != null && nodoAcciones.getLength() > 0) {

			for (int j = 0; j < nodoAcciones.getLength(); j++) {

				Element elementoAccion = (Element) nodoAcciones.item(j);

				String accion = elementoAccion.getAttribute("nombre");

				//System.out.println("La acción se llama: " + accion);
				
				acc = new Accion (accion, operaciones);

				NodeList nodoAccion = elementoAccion.getElementsByTagName("operaciones");

				if (nodoAccion != null && nodoAccion.getLength() > 0) {

					Element elementoOperaciones = (Element) nodoAccion.item(0);

					NodeList nodoOperaciones = elementoOperaciones.getElementsByTagName("operacion");

					if (nodoOperaciones != null && nodoOperaciones.getLength() > 0) {

						for (int i = 0; i < nodoOperaciones.getLength(); i++) {

							Operacion op = new Operacion();

							Element elementoOperacion = (Element) nodoOperaciones.item(i);

							NodeList nodoTipo = elementoOperacion.getElementsByTagName("tipo");
							NodeList nodoCantidad = elementoOperacion.getElementsByTagName("cantidad");
							NodeList nodoPrecio = elementoOperacion.getElementsByTagName("precio");

							if (nodoTipo != null && nodoTipo.getLength() > 0) {

								Element elementoTipo = (Element) nodoTipo.item(0);
								String tipo = elementoTipo.getFirstChild().getNodeValue();
								// System.out.println("Tipo: " + tipo);
								op.setTipo(tipo);
							}

							if (nodoCantidad != null && nodoCantidad.getLength() > 0) {

								Element elementoCantidad = (Element) nodoCantidad.item(0);
								int cantidad = Integer.parseInt(elementoCantidad.getFirstChild().getNodeValue());
								// System.out.println("Cantidad: " + cantidad);
								op.setCantidad(cantidad);
							}

							if (nodoPrecio != null && nodoPrecio.getLength() > 0) {

								Element elementoPrecio = (Element) nodoPrecio.item(0);
								float precio = Float.parseFloat(elementoPrecio.getFirstChild().getNodeValue());
								// System.out.println("Precio: " + precio);
								op.setPrecio(precio);
							}
							operaciones = new ArrayList<Operacion>();
							operaciones.add(op);
							/*
							 * Iterator it = operaciones.iterator(); while(it.hasNext()) { Operacion o =
							 * (Operacion) it.next(); System.out.println(o.getTipo());
							 * System.out.println(o.getCantidad()); System.out.println(o.getPrecio()); }
							 */
							acc.setOperaciones(operaciones);

							acciones = new ArrayList<Accion>();

							acciones.add(acc);

							Iterator it = acciones.iterator();
							while (it.hasNext()) {
								Accion a = (Accion) it.next();
								a.print();
							}

						}

				}

			}
		}

		}
	}
}
