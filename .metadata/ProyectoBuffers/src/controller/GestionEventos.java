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
		
		//Mediante una clase anónima se implementa la interfaz ActionListener y, a partir de ella,
		//se crea un objeto llamado actionListener_comparar, el cual se encargará de definir el 
		//método abstracto actionPerformed que invocará las acciones que se quieran desencadenar
		//cuando se produzaca un evento.
		
		actionListener_comparar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_compararContenido
				call_compararContenido();
			}
		};
		
		//Mediante el objeto view de la clase LaunchView se llama al método getComparar(), el cual hace referencia 
		//al botón comparar de la Vista. A su vez, al botón comparar se le añade el addActionListener llamado
		//actionListener_comparar que se encargará de ejecutar el método call_compararContenido() cuando se 
		//produzca el evento de pulsar el botón comparar.
		
		view.getComparar().addActionListener(actionListener_comparar);

		//Mediante una clase anónima se implementa la interfaz ActionListener y, a partir de ella,
		//se crea un objeto llamado actionListener_comparar, el cual se encargará de definir el 
		//método abstracto actionPerformed que invocará las acciones que se quieran desencadenar 
		//cuando se produzaca un evento.
		
		actionListener_buscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la función call_buscarPalabra
				call_buscarPalabra();
			}
		};
		
		//Mediante el objeto view de la clase LaunchView se llama al método getBuscar(), el cual hace referencia 
		//al botón buscar de la Vista. A su vez, al botón buscar se le añade el addActionListener llamado
		//actionListener_buscar que se encargará de ejecutar el método call_buscarPalabra() cuando se 
		//produzca el evento de pulsar el botón buscar.
		
		view.getBuscar().addActionListener(actionListener_buscar);
	}

	private int call_compararContenido() {

		// TODO: Llamar a la función compararContenido de GestionDatos
		// TODO: Gestionar excepciones
		
		//Desde este método llamamos al método compararContenido de la clase GestionDatos.
		//Para ello, aprovechamos el objeto model declarado al inicio de esta clase.
		//Finalmente, en este método recogemos las excepciones lanzadas por el método
		//compararContenido y las encerramos en un bloque try-catch
		
		try {
		
		//Aquí, el método compararContenido recibe por parámetro dos Strings provenientes
		//de los JTextFields de la clase LaunchView, la cual sirve como Vista de la app.
		model.compararContenido(view.getFichero1().getText(), view.getFichero2().getText());
		
		//Primero, capturamos la excepción más específica
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
		//Después capturamos la excepción más genérica	
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		return 1;
	}

	private int call_buscarPalabra() {

		// TODO: Llamar a la función buscarPalabra de GestionDatos
		// TODO: Gestionar excepciones
		
		//Desde este método llamamos al método buscarPalabra de la clase GestionDatos.
		//Para ello, aprovechamos el objeto model declarado al inicio de esta clase.
		//Finalmente, en este método recogemos las excepciones lanzadas por el método
		//buscarPalabra y las encerramos en un bloque try-catch
		
		try {
			
		model.buscarPalabra(view.getFichero1().getText(), view.getPalabra().getText(), view.getPrimera().isSelected());
		
		//Primero, capturamos la excepción más específica
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
			
		//Después capturamos la excepción más genérica	
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		return 1;
	}

}
