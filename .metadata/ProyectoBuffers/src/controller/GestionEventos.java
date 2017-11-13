package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.*;
import view.*;

public class GestionEventos {

	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar;

	public GestionEventos(GestionDatos m, LaunchView v) {
		this.model = m;
		this.view = v;
	}

	public void contol() {
		
		//Mediante una clase an�nima se implementa la interfaz ActionListener y, a partir de ella,
		//se crea un objeto llamado actionListener_comparar, el cual se encargar� de definir el 
		//m�todo abstracto actionPerformed que invocar� las acciones que se quieran desencadenar
		//cuando se produzaca un evento.
		
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_compararContenido
				call_compararContenido();
			}
		};
		
		//Mediante el objeto view de la clase LaunchView se llama al m�todo getComparar(), el cual hace referencia 
		//al bot�n comparar de la Vista. A su vez, al bot�n comparar se le a�ade el addActionListener llamado
		//actionListener_comparar que se encargar� de ejecutar el m�todo call_compararContenido() cuando se 
		//produzca el evento de pulsar el bot�n comparar.
		
		view.getComparar().addActionListener(actionListener_comparar);

		//Mediante una clase an�nima se implementa la interfaz ActionListener y, a partir de ella,
		//se crea un objeto llamado actionListener_comparar, el cual se encargar� de definir el 
		//m�todo abstracto actionPerformed que invocar� las acciones que se quieran desencadenar 
		//cuando se produzaca un evento.
		
		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_buscarPalabra
				call_buscarPalabra();
			}
		};
		
		//Mediante el objeto view de la clase LaunchView se llama al m�todo getBuscar(), el cual hace referencia 
		//al bot�n buscar de la Vista. A su vez, al bot�n buscar se le a�ade el addActionListener llamado
		//actionListener_buscar que se encargar� de ejecutar el m�todo call_buscarPalabra() cuando se 
		//produzca el evento de pulsar el bot�n buscar.
		
		view.getBuscar().addActionListener(actionListener_buscar);
	}

	private int call_compararContenido() {

		// TODO: Llamar a la funci�n compararContenido de GestionDatos
		// TODO: Gestionar excepciones
		
		//Desde este m�todo llamamos al m�todo compararContenido de la clase GestionDatos.
		//Para ello, aprovechamos el objeto model declarado al inicio de esta clase.
		//Finalmente, en este m�todo recogemos las excepciones lanzadas por el m�todo
		//compararContenido y las encerramos en un bloque try-catch
		
		try {
		
		//Aqu�, el m�todo compararContenido recibe por par�metro dos Strings provenientes
		//de los JTextFields de la clase LaunchView, la cual sirve como Vista de la app.
		model.compararContenido(view.getFichero1().getText(), view.getFichero2().getText());
		
		//Primero, capturamos la excepci�n m�s espec�fica
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
		//Despu�s capturamos la excepci�n m�s gen�rica	
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		return 1;
	}

	private int call_buscarPalabra() {

		// TODO: Llamar a la funci�n buscarPalabra de GestionDatos
		// TODO: Gestionar excepciones
		
		//Desde este m�todo llamamos al m�todo buscarPalabra de la clase GestionDatos.
		//Para ello, aprovechamos el objeto model declarado al inicio de esta clase.
		//Finalmente, en este m�todo recogemos las excepciones lanzadas por el m�todo
		//buscarPalabra y las encerramos en un bloque try-catch
		
		try {
			
		model.buscarPalabra(view.getFichero1().getText(), view.getPalabra().getText(), view.getPrimera().isSelected());
		
		//Primero, capturamos la excepci�n m�s espec�fica
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
			
		//Despu�s capturamos la excepci�n m�s gen�rica	
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		return 1;
	}

}
