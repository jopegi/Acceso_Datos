package josevi.parser;

public class Principal {

	public static void main(String[] args) {

		// **************PARSER: DE XML A OBJETO***************************************
		Parser parser = new Parser();
		parser.parseFicheroXml("acciones.xml");
		parser.parseDocument();
		// **************FIN PARSER: DE XML A OBJETO***********************************

	}

}
