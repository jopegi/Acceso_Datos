package josevi.parser;

public class Principal {

	public static void main(String[] args) {
		
		Parser parser = new Parser();
		parser.parseFicheroXml("fichero1.xml");
		parser.parseDocument();

	}

}
