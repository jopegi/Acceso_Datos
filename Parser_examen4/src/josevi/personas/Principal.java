package josevi.personas;


public class Principal {

	public static void main(String[] args) {
		
		Parser parse = new Parser();
		parse.parseFicheroXml("personas.xml");
		parse.parseDocument();
		

	}

}
