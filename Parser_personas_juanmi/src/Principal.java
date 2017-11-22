import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		Parser parser = new Parser();
		parser.parseFicheroXml("personas.xml");
		parser.parseDocument();
		//parser.print(); FALTA ESTO!!!!!
		
	}
}