import java.io.File;
import java.util.ArrayList;

import javax.xml.transform.TransformerException;

public class Principal {

	public static void main(String[] args) {
		
		//**************PARSER: DE XML A OBJETO***************************************
		Parser parser = new Parser();
		parser.parseFicheroXml("biblioteca2.xml");
		parser.parseDocument();
		//parser.print();
		//**************FIN PARSER: DE XML A OBJETO***********************************
		
		
		
	}

}

