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
	
	//El constructor de la clase Marshaller recibir� como par�metro un ArrayList 
	//que contendr� los objetos libro a serializar
	public Marshaller (ArrayList<Libro> lib) {
		
		libros = lib;
		
	}
	
	//M�todos de la clase Marhaller
	
	public void crearDocumento() throws ParserConfigurationException {
		//Creamos una Factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//Creamos un DocumentBuilder
		DocumentBuilder db = dbf.newDocumentBuilder();
		//Creamos un Document
		dom = db.newDocument();
	}
	
	//M�todo para crear la estructura DOM
	public void crearArbolDOM() {
		//Creamos el elemento ra�z libros
		Element docEl = dom.createElement("libros");
		//A�adimos el elemento ra�z al Document
		dom.appendChild(docEl);
		
		//Recorremosel ArrayList libros en el que se ha guardado el objeto libro seg�n los datos del usuario
		Iterator it = libros.iterator();
		
		while(it.hasNext()) {
			Libro l = (Libro) it.next();
			//Para cada objeto libro creamos una etiqueta <libro> y la a�adimos al Document
			Element libroEle = setLibro(l);
			docEl.appendChild(libroEle);
		}
		
	}
	
	//M�todo para almacenar elementos en el �rbol DOM
	private Element setLibro(Libro l) {
		//Creamos el elemento libro
		Element libroEle = dom.createElement("libro");
		
		//Creamos los elementos anidados dentro del elemento Persona anterior
		
		//1.creamos el elemento <id>
		Element idEle = dom.createElement("id");
		//2.definimos el contenido del elemento id
		Text idTexto = dom.createTextNode(Integer.toString(l.getId()));
		//3.a�adimos el contenido al elemento id
		idEle.appendChild(idTexto);
		//4.a�adimos el elmento id al elemento padre libro
		libroEle.appendChild(idEle);
		
		//1.creamos el elemento <titulo>
		Element titleEle = dom.createElement("titulo");
		//2.definimos el contenido del elemento titulo
		Text titleTexto = dom.createTextNode(l.getTitulo());
		//3.a�adimos el contenido al elemento titulo
		titleEle.appendChild(titleTexto);
		//4.a�adimos el elmento titulo al elemento padre libro
		libroEle.appendChild(titleEle);
		
		//1.creamos el elemento <autor>
		Element autorEle = dom.createElement("autor");
		//2.definimos el contenido del elemento autor
		Text autorTexto = dom.createTextNode(l.getAutor());
		//3.a�adimos el contenido al elemento autor
		autorEle.appendChild(autorTexto);
		//4.a�adimos el elmento autor al elemento padre libro
		libroEle.appendChild(autorEle);
		
		//1.creamos el elemento <anyo>
		Element anyoEle = dom.createElement("anyo");
		//2.definimos el contenido del elemento anyo
		Text anyoTexto = dom.createTextNode(Integer.toString(l.getAnyoPubli()));
		//3.a�adimos el contenido al elemento anyo
		anyoEle.appendChild(anyoTexto);
		//4.a�adimos el elmento anyo al elemento padre libro
		libroEle.appendChild(anyoEle);
		
		//1.creamos el elemento <editor>
		Element editorEle = dom.createElement("editor");
		//2.definimos el contenido del elemento editor
		Text editorTexto = dom.createTextNode(l.getEditor());
		//3.a�adimos el contenido al elemento editor
		editorEle.appendChild(editorTexto);
		//4.a�adimos el elmento editor al elemento padre libro
		libroEle.appendChild(editorEle);
		
		//1.creamos el elemento <paginas>
		Element paginasEle = dom.createElement("paginas");
		//2.definimos el contenido del elemento paginas
		Text paginasTexto = dom.createTextNode(Integer.toString(l.getNumPaginas()));
		//3.a�adimos el contenido al elemento paginas
		paginasEle.appendChild(paginasTexto);
		//4.a�adimos el elmento paginas al elemento padre libro
		libroEle.appendChild(paginasEle);
		
		return libroEle;
		
	}
	
	//M�todo para almacenar los datos del DOM en un fichero xml
	public void escribirDocumentAXml(File file) throws TransformerException {
		
		//Creamos una instancia de la clase abstracta Transformer, la cual se 
		//encargar� de transformar el �rbol DOM en un documento xml
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		//Instrucci�n que implementa los saltos de l�nea en el documento xml
		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		
		//Definimos donde se escribir�n los datos y desde que fuente
		StreamResult result = new StreamResult(file);
		
		DOMSource source = new DOMSource(dom);
		
		trans.transform(source, result);
		
	}
	
	
	
	

}
