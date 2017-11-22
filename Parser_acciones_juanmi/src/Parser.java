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
	private ArrayList<Accion> acciones = new ArrayList<Accion>();

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

		// obtenemos el nodelist de elementos
		NodeList nl = docEle.getElementsByTagName("accion");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {

				// obtenemos un elemento de la lista (persona)
				Element elAccion = (Element) nl.item(i);
				
				Accion accion = new Accion();
				
				String nombre = elAccion.getAttribute("nombre");
				accion.setNombre(nombre);
				System.out.println("El nombre es: "+nombre);
				
				NodeList nl2 = elAccion.getElementsByTagName("operaciones");
				
				if (nl2 != null && nl2.getLength() > 0) {
					Element elOperaciones = (Element) nl2.item(0);
					
					//ArrayList<Operacion> operaciones = new ArrayList<Operacion>();
					
					NodeList nl3 = elOperaciones.getElementsByTagName("operacion");
					
					if (nl3 != null && nl3.getLength() > 0) {
						for (int j=0; j < nl3.getLength(); j++) {
							
							Element elOperacion = (Element) nl3.item(j);

							Operacion op = new Operacion();
							
							NodeList nl4 = elOperacion.getElementsByTagName("tipo");
							
							if (nl4 != null && nl4.getLength() > 0) {
								Element elTipo = (Element) nl4.item(0);
								String tipo = elTipo.getFirstChild().getNodeValue();
								System.out.println("tipo vale: "+tipo);
								op.setTipo(tipo);
							}
							
							NodeList nl5 = elOperacion.getElementsByTagName("cantidad");
							
							if (nl5 != null && nl5.getLength() > 0) {
								Element elCantidad = (Element) nl5.item(0);
								String cantidad = elCantidad.getFirstChild().getNodeValue();
								System.out.println("cantidad vale: "+cantidad);
								op.setCantidad(cantidad);
							}
							
							NodeList nl6 = elOperacion.getElementsByTagName("precio");
							
							if (nl6 != null && nl6.getLength() > 0) {
								Element elPrecio = (Element) nl6.item(0);
								String precio = elPrecio.getFirstChild().getNodeValue();
								System.out.println("precio vale: "+precio);
								op.setPrecio(precio);
							}
							
							accion.getOperaciones().add(op);
							
							//elOperacion.getElementsByTagName("cantidad");
							//elOperacion.getElementsByTagName("precio");
							
						}
					}
					
					
				}

				//Aquí tenemos un objeto Accion completo
				acciones.add(accion);
				
			}
		}
	}
}