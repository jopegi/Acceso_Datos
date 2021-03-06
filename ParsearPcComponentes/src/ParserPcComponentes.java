import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParserPcComponentes {

	// Definimos la url de la p�gina web cuyo contenido querenos parsear
	public static final String url = "https://www.pccomponentes.com/";

	//Instanciamos una variable de clase de tipo Document a null
	static Document doc = null;

	//M�todo main que lanza la app
	public static void main(String[] args) {

		try {

			//Guardamos en el Document el contenido HTML de la web referenciada con la url
			doc = Jsoup.connect(url).get();

		} catch (IOException e) {

			e.printStackTrace();
		}

		//Obtenemos el t�tulo definido en la etiqueta <title> de la p�gina web
		String title = doc.title();

		//Mostramos el t�tulo por consola
		System.out.println(title + "\n\n");

		//Guardamos todas las entradas cuyo atributo class contenga en valor de "tarjeta-articulo__elementos-basicos"
		Elements a = doc.select("div.tarjeta-articulo__elementos-basicos");

		//Generamos una variable contador que nos servir� para contar el n�mero de elementos impresos por consola
		int contador = 0;

		//Con un bucle for-each recorremos los elementos selecionados
		for (Element e : a) {
			contador++;
			//En cada iteraci�n nos quedamos con las etiquetas <a>
			Elements tag_a = e.getElementsByTag("a");

			//Y, dentro de cada etiqueta <a> nos quedamos con al valor de sus atributo "data-name" y "data-price"
			String contenido = tag_a.attr("data-name");
			String precio = tag_a.attr("data-price");
			
			//Imprimmimos el resultado de cada iteraci�n por consola
			System.out.println("Producto n�: " +contador + " >> " + "Contenido: " + contenido+ " - Precio: " +precio+ "� " + "\n");

		}

	}

}

