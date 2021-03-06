import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Marshaller {

	private Document dom = null;
	private ArrayList<Libro> libros = null;

	public Marshaller(ArrayList<Libro> p) {
		libros = p;
	}

	public void crearDocumento() {
		// creamos una factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// creamos un documentbuilder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// creamos una instancia de DOM
			dom = db.newDocument();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}

	}

	public void crearArbolDOM() {

		// creamos el elemento ra�z
		Element docEle = dom.createElement("biblioteca");

		Iterator it = libros.iterator();
		while (it.hasNext()) {
			
			Libro l = (Libro) it.next();
			
			Element elementoLibro = setLibro(l);
			
			docEle.appendChild(elementoLibro);
			
			
		}
		dom.appendChild(docEle);

	}

	private Element setLibro(Libro l) {
		
		//*******Creamos el elemento ra�z <libro> en la estructura DOM**********
		Element elementoLibro = dom.createElement("libro");
		//**********************************************************************
		
		//********Creamos el elemento <titulo> en la estructura DOM*************
		Element tituloLibro = dom.createElement("titulo");
		//Definimos el texto que contendr� el elemento <titulo>, el cual obtenemos con el 
		//m�todo getTitulo() de la clase Libro
		Text tit = dom.createTextNode(l.getTitulo());
		//A�adimos el valor  de tipo texto anterior a su correspondiente etiqueta, en este caso, <titulo>
		tituloLibro.appendChild(tit);
		//A�adimos el anyo como atributo de la etiqueta <titulo>
		tituloLibro.setAttribute("anyo", Integer.toString(l.getAnyo()));
		//Finalmente, a�adimos la etiqueta <libro> y su contenido (texto + atributo) al elemento <libro>
		elementoLibro.appendChild(tituloLibro);
		//**********************************************************************
		
		//********Creamos el elemento <autor> en la estructura DOM**************
		Element autorLibro = dom.createElement("autor");
		//Como la etiqueta <autor> contiene el nombre de varios autores, los recogemos todos del 
		//array que los almacena dentro de la clase Libro
		for(int i=0;i<l.getNombres().size();i++) {
			//Guardamos cada nombre en una variable de tipo String
			String nombre_rec=l.getNombres().get(i);
			//Creamos la etiqueta <nombre>
			Element nombre = dom.createElement("nombre");
			//Creamos el correspondiente nodo de texto para cada nombre
			Text t = dom.createTextNode(nombre_rec);
			//A�adimos el nodo de texto a la etiqueta <nombre>
			nombre.appendChild(t);
			//A�adimos la etiqueta <nombre> a la etiqueta padre <autor>
			autorLibro.appendChild(nombre);			
		}
		//Finalmente, a�adimos la etiqueta <autor> al nodo ra�z <libro>
		elementoLibro.appendChild(autorLibro);
		//*********************************************************************
		
		
		//********Creamos el elemento <editor> en la estructura DOM**************
		Element editorLibro = dom.createElement("editor");
		//Definimos el texto que contendr� el elemento <editor>, el cual obtenemos con el 
		//m�todo getEditor() de la clase Libro
		Text contenido = dom.createTextNode(l.getEditor());
		//A�adimos el texto anterior a la etiqueta <editor>
		editorLibro.appendChild(contenido);
		//Finalmente, a�adimos la etiqueta <editor> al nodo ra�z <libro>
		elementoLibro.appendChild(editorLibro);
		//***********************************************************************
		
		
		//********Creamos el elemento <paginas> en la estructura DOM**************
		Element pagLibro = dom.createElement("paginas");
		//Definimos el texto que contendr� el elemento <paginas>, el cual obtenemos con el 
		//m�todo getPaginas() de la clase Libro
		Text nump = dom.createTextNode(Integer.toString(l.getPaginas()));
		//A�adimos el texto anterior a la etiqueta <paginas>
		pagLibro.appendChild(nump);
		//Finalmente, a�adimos la etiqueta <paginas> al nodo ra�z <libro>
		elementoLibro.appendChild(pagLibro);
		//***********************************************************************
		
		
		return elementoLibro;
		
	}
	
	
	
	/*
	 * private Element setPersona(Libro p) {
	 * 
	 * // creamos el elemento persona Element PersonaEle =
	 * dom.createElement("persona");
	 * 
	 * // creamos el elemento nombre y el nodo de texto y lo a�adimos al elemento
	 * persona Element nombreEle = dom.createElement("nombre"); Text nombreTexto =
	 * dom.createTextNode(p.getNombre()); nombreEle.appendChild(nombreTexto);
	 * PersonaEle.appendChild(nombreEle);
	 * 
	 * // creamos el elemento edad y el nodo de valor entero y lo a�adimos al
	 * elemento persona Element edadEle = dom.createElement("edad"); Text edadTexto
	 * = dom.createTextNode(Integer.toString(p.getEdad()));
	 * edadEle.appendChild(edadTexto); PersonaEle.appendChild(edadEle);
	 * 
	 * return PersonaEle; }
	 */

	
	//****M�TODO PARA TRANSFORMAR DE DOM A XML********************************
	public void escribirDocumentAXml(File file) throws TransformerException {

		// creamos una instacia para escribir el resultado
		Transformer trans = TransformerFactory.newInstance().newTransformer();
			//Propiedad para que se tengan en cuenta los saltos de linea en la transformaci�n a xml
		trans.setOutputProperty(OutputKeys.INDENT, "yes");

		// especificamos d�nde escribimos y la fuente de datos
			//Indicamos el fichero sobre el que queremos escribir
		StreamResult result = new StreamResult(file);
			//Indicamos cual ser� la fuente de los datos, en nuestro caso nuestra estructura DOM
		DOMSource source = new DOMSource(dom);
			//El m�todo transform() se encarga de la transformaci�n
		trans.transform(source, result);

	}
	//************************************************************************
	
}