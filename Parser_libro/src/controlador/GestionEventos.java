package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import controlador.Parser;
import vista.Ventana;

public class GestionEventos {
	
	private Parser model;
	private Ventana view;
	private ActionListener actionListener_parsear;

	public GestionEventos(Parser p, Ventana v) {
		this.model = p;
		this.view = v;
	}
	
public void control() {
		

		actionListener_parsear = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
			
				call_parsearXML();
			}
		};
		

		
		view.getBotonParsear().addActionListener(actionListener_parsear);
}

private int call_parsearXML() {

	try {
		//System.out.println("Entra al try");
		model.parseFicheroXml(view.getFichero1().getText());
		model.parseDocument();
		model.print();
		
	} catch (ParserConfigurationException e) {
		System.err.print("ha fallado el parseo!");
		view.showError("ha fallado el parseo!");
		e.printStackTrace();
		
	} catch (SAXException e) {
		System.err.print("ha fallado el parseo!");
		view.showError("ha fallado el parseo!");
		e.printStackTrace();
		
	}catch (IOException e) {
		System.err.print("ha fallado el parseo!");
		view.showError("ha fallado el parseo!");
		e.printStackTrace();
	}
	
	return 1;
}

}
