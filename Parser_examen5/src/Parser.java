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
	private ArrayList<String> nombres = null;
	private Libro l = null;
	private int anyo;
	private String titulo;
	private String editor;
	private int paginas;

	public Parser() {
		nombres = new ArrayList<String>();
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
		// obtenemos el elemento raíz <biblioteca>
		Element docRaiz = dom.getDocumentElement();

		// obtenemos el nodelist de elementos
		NodeList nodoLibros = docRaiz.getElementsByTagName("libro");
		
		if (nodoLibros != null && nodoLibros.getLength() > 0) {
			
			for (int i = 0; i < nodoLibros.getLength(); i++) {

				Element elementoLibro = (Element) nodoLibros.item(i);
				
				NodeList nodoLibro1 = elementoLibro.getElementsByTagName("titulo");
				NodeList nodoLibro2 = elementoLibro.getElementsByTagName("autor");
				NodeList nodoLibro3 = elementoLibro.getElementsByTagName("editor");
				NodeList nodoLibro4 = elementoLibro.getElementsByTagName("paginas");

				if (nodoLibro1 != null && nodoLibro1.getLength() > 0) {
					
					Element elementoTitulo = (Element) nodoLibro1.item(0);
					
					anyo = Integer.parseInt(elementoTitulo.getAttribute("anyo"));
					
					titulo = elementoTitulo.getFirstChild().getNodeValue();
					
					//System.out.println(anyo);
					//System.out.println(titulo);
					
				}
				
				if (nodoLibro2 != null && nodoLibro2.getLength() > 0) {
					
					Element elementoAutor = (Element) nodoLibro2.item(0);
					
					NodeList nodoAutor = elementoAutor.getElementsByTagName("nombre");
					
					if (nodoAutor != null && nodoAutor.getLength() > 0) {
						
						for (int a = 0; a < nodoAutor.getLength(); a++) {
							
							Element elementoNombre = (Element) nodoAutor.item(a);
							
							nombres.add(elementoNombre.getFirstChild().getNodeValue());	
						}
					}
					
					if (nodoLibro3 != null && nodoLibro3.getLength() > 0) {
						
						Element elementoEditor = (Element) nodoLibro3.item(0);
						
						editor = elementoEditor.getFirstChild().getNodeValue();
						
						//System.out.println(editor);
						
					}
					
					if (nodoLibro4 != null && nodoLibro4.getLength() > 0) {
						
						Element elementoPaginas = (Element) nodoLibro4.item(0);
						
						paginas = Integer.parseInt(elementoPaginas.getFirstChild().getNodeValue());
						
						//System.out.println(paginas);
						
					}

				}
				l = new Libro (anyo, titulo, editor, paginas, nombres);
				l.print();
			}

		}

	}

	/*private Libro getLibro(Element libroEle) {

		String titulo = getTextValue(libroEle, "titulo");
		String editor = getTextValue(libroEle, "editor");
		int paginas = getIntValue(libroEle, "paginas");
		ArrayList<String> lista=getNombres(libroEle,"autor");
		int anyo=Integer.parseInt(getAttribute(libroEle,"titulo","anyo"));
		
		Libro l = new Libro(titulo, lista, editor, paginas,anyo);

		return l;

	}*/
	
	private String getAttribute(Element ele, String tag, String attr) {
	
		String textVal="";
		NodeList nl = ele.getElementsByTagName(tag);
		if (nl != null && nl.getLength() > 0) {
			Element el = (Element) nl.item(0);
			textVal = el.getAttribute(attr);
		}
		return textVal;

		
	}

	private ArrayList<String> getNombres(Element ele, String tag) {
		ArrayList<String> lista_nombres = new ArrayList<String>();
		
		NodeList nl = ele.getElementsByTagName(tag);

		if (nl != null && nl.getLength() > 0) {
			Element el_autor = (Element) nl.item(0);

			NodeList nodelist_nombres = el_autor.getElementsByTagName("nombre");

			if (nodelist_nombres != null && nodelist_nombres.getLength() > 0) {
				for (int i = 0; i < nodelist_nombres.getLength(); i++) {
					Element el_nombre = (Element) nodelist_nombres.item(i);
					String texto = el_nombre.getFirstChild().getNodeValue();
					lista_nombres.add(texto);					
				}
			}

		}
		return lista_nombres;
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

	/*public void print() {

		Iterator it = libros.iterator();
		while (it.hasNext()) {
			Libro l = (Libro) it.next();
			l.print();
			System.out.println("-----------------------------\n");
		}*/
	}


