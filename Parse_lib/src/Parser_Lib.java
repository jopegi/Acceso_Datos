import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;


public class Parser_Lib {
	
	
	
	public static void main(String[] args) {
		
			
		Ventana v = new Ventana();
		v.setVisible(true);
			

		
		//ActionListener botón Parsear
		v.getBotonParsear().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Parser parser=new Parser();
					parser.parseFicheroXml(v.getCajaParsear().getText());
					parser.parseDocument();
					parser.print();
					}catch (ParserConfigurationException e) {
						System.err.print("ha fallado el parseo!");
						e.printStackTrace();
						
					} catch (SAXException e) {
						System.err.print("ha fallado el parseo!");
						e.printStackTrace();
						
					}catch (IOException e) {
						System.err.print("ha fallado el parseo!");
						e.printStackTrace();
					}
			}
		});
		
		
		//ActionListener botón Serializar
		v.getBotonSerializar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Libro> libros;
				libros = new ArrayList<Libro>();
				
				int id = Integer.valueOf(v.getCajaId().getText());
				String titulo = v.getCajaTitulo().getText();
				String autor = v.getCajaAutor().getText();
				int anyo = Integer.valueOf(v.getCajaAnyo().getText());
				String editor = v.getCajaEditor().getText();
				int paginas = Integer.valueOf(v.getCajaPaginas().getText());
				
				//Cargamos los datos que conformarán la info del objeto libro en el ArrayList o almacén de objetos
				libros.add(new Libro(id,titulo,autor,anyo,editor,paginas));
				
				Marshaller marshaller = new Marshaller (libros);
				
				//Capturamos en el main la correspondiente excepción lanzada por el método crearDocumento() 
				try {
					
					//Creamos el documento
					marshaller.crearDocumento();
					
				} catch (ParserConfigurationException e1) {
					
					e1.printStackTrace();
				}
				
				//Creamos el arbol DOM
				marshaller.crearArbolDOM();
				
				//Creamos un fichero xml en el que se almacenará la estructura DOM creada
				File f = new File ("libros.xml");
				
				//Capturamos en el main la correspondiente excepción lanzada por el método escribirDocumentAXml() 
				try {
					
					marshaller.escribirDocumentAXml(f);
					
				} catch (TransformerException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});


		
	}

}

