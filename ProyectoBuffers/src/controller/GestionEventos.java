package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import model.*;
import view.*;

public class GestionEventos {

	private Libro lib;
	private GestionDatos model;
	private LaunchView view;
	private ActionListener actionListener_comparar, actionListener_buscar, actionListener_ordenar,actionListener_copiarStream, 
	actionListener_rotar90, actionListener_rotarEspecular,actionListener_longitud;

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
				//call_compararContenido();
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
		
		
		actionListener_ordenar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_ordenarFichero
				call_ordenarFichero();
			}
		};
		
		//Mediante el objeto view de la clase LaunchView se llama al m�todo getOrdenar(), el cual hace referencia 
		//al bot�n ordenar fichero de la Vista. A su vez, al bot�n ordenar se le a�ade el addActionListener llamado
		//actionListener_ordenar que se encargar� de ejecutar el m�todo call_ordenarFichero() cuando se 
		//produzca el evento de pulsar el bot�n ordenar.
		
		view.getOrdenar().addActionListener(actionListener_ordenar);
		
		// Mediante una clase an�nima se implementa la interfaz ActionListener y, a partir de ella,
		// se crea un objeto llamado actionListener_copiarStream, el cual se encargar� de definir el
		// m�todo abstracto actionPerformed que invocar� las acciones que se quieran desencadenar
		// cuando se produzaca un evento.

		actionListener_copiarStream = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				// TODO: Llamar a la funci�n call_copiarStream
				call_copiarStream();
			}
		};

		// Mediante el objeto view de la clase LaunchView se llama al m�todo
		// getComparar(), el cual hace referencia
		// al bot�n comparar de la Vista. A su vez, al bot�n comparar se le a�ade el
		// addActionListener llamado
		// actionListener_comparar que se encargar� de ejecutar el m�todo
		// call_compararContenido() cuando se
		// produzca el evento de pulsar el bot�n comparar.

		view.getCopiar().addActionListener(actionListener_copiarStream);
		
		
		// Mediante una clase an�nima se implementa la interfaz ActionListener y, a
		// partir de ella,
		// se crea un objeto llamado actionListener_rotar90, el cual se encargar�
		// de definir el
		// m�todo abstracto actionPerformed que invocar� las acciones que se quieran
		// desencadenar
		// cuando se produzaca un evento.

		actionListener_rotar90 = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				call_rotar90();
			}
		};

		// Mediante el objeto view de la clase LaunchView se llama al m�todo
		// getRotar90(), el cual hace referencia
		// al bot�n rotar90 de la Vista. A su vez, al bot�n rotar90 se le a�ade el
		// addActionListener llamado
		// actionListener_rotar90 que se encargar� de ejecutar el m�todo
		// call_rotar90() cuando se
		// produzca el evento de pulsar el bot�n rotar.

		view.getRotar90().addActionListener(actionListener_rotar90);
		
		
		
		// Mediante una clase an�nima se implementa la interfaz ActionListener y, a
		// partir de ella,
		// se crea un objeto llamado actionListener_rotarEspecular, el cual se encargar�
		// de definir el
		// m�todo abstracto actionPerformed que invocar� las acciones que se quieran
		// desencadenar
		// cuando se produzaca un evento.

		actionListener_rotarEspecular = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				call_rotarEspecular();
			}
		};

		// Mediante el objeto view de la clase LaunchView se llama al m�todo
		// getEspecular(), el cual hace referencia
		// al bot�n especular de la Vista. A su vez, al bot�n especular se le a�ade el
		// addActionListener llamado
		// actionListener_rotarEspecular que se encargar� de ejecutar el m�todo
		// call_rotarEspecular() cuando se
		// produzca el evento de pulsar el bot�n especular.

		view.getEspecular().addActionListener(actionListener_rotarEspecular);
		
		
		
		actionListener_longitud = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				
				call_longitud();
			}
		};
		
		//view.getComparar().addActionListener(actionListener_longitud);
		
		//*******************************
		
		ActionListener actionListener_guardarLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				call_guardarLibro();
			}
		};


		view.getGuardar().addActionListener(actionListener_guardarLibro);
		
		//*******************************
		
		ActionListener actionListener_rotarRecuperarLibro = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				call_recuperarLibro();
			}
		};


		view.getRecuperar().addActionListener(actionListener_rotarRecuperarLibro);
		
		//*******************************
		
		ActionListener actionListener_rotarRecuperarTodos = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				call_recuperarTodos();
			}
		};


		view.getRecuperarTodos().addActionListener(actionListener_rotarRecuperarTodos);
		
		//*******************************
		
		
		// **********ACTIVIDAD 1 EX�MEN*********************
		//CONTROL DEL EVENTO QUE SE LANZA AL HACER CLICK SOBRE EL BOT�N DE MODIFICAR AUTOR

		ActionListener actionListener_ModificarAutor = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				call_modificarAutorLibro();
			}
		};

		view.getModificar().addActionListener(actionListener_ModificarAutor);
		
		// *******************************
		
		// **********ACTIVIDAD 2 EX�MEN*********************
		//CONTROL DEL EVENTO QUE SE LANZA AL HACER CLICK SOBRE EL BOT�N DE MODIFICAR AUTOR

		ActionListener actionListener_MostrarPalabras = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				call_mostrarPalabras();
			}
		};

		view.getMostrar_palabras().addActionListener(actionListener_MostrarPalabras);
		
		// *******************************
		
		// actividad 1 Ex�men Evaluaci�n 1 ADD

		ActionListener actionListener_PalabraMasLarga = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				try {
					
					call_longitudMaxima();
					
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
					view.showError("Error... Posiblemente el fichero no exista!" );
					
				}catch(IOException e) {
					
					e.printStackTrace();
					view.showError("Error... de tipo IOException!" );
				}
			}
		};

		view.getComparar().addActionListener(actionListener_PalabraMasLarga);

		// *******************************
	}

	private int call_compararContenido() {

		// TODO: Llamar a la funci�n compararContenido de GestionDatos
		// TODO: Gestionar excepciones

		// Desde este m�todo llamamos al m�todo compararContenido de la clase
		// GestionDatos.
		// Para ello, aprovechamos el objeto model declarado al inicio de esta clase.
		// Finalmente, en este m�todo recogemos las excepciones lanzadas por el m�todo
		// compararContenido y las encerramos en un bloque try-catch

		try {

			//Me anticipo al catch y compruebo si alguno de los ficheros introducidos no existen
			if (new File(view.getFichero1().getText()).isFile() && new File(view.getFichero2().getText()).isFile()) {

				// Aqu�, el m�todo compararContenido recibe por par�metro dos Strings
				// provenientes
				// de los JTextFields de la clase LaunchView, la cual sirve como Vista de la
				// app.
				boolean b = model.compararContenido(view.getFichero1().getText(), view.getFichero2().getText());
				if(b == false) {

					view.getTextArea().setText("Los ficheros son diferentes.");
				}else {

					view.getTextArea().setText("Los ficheros son iguales.");
				}

				
			}else {
				view.showError("Alguno de los ficheros indicados no existe!!");
			}
				
			// Primero, capturamos la excepci�n m�s espec�fica
		} catch (FileNotFoundException e) {

			view.showError("No se ha encontrado el archivo!!");
			e.printStackTrace();
			// Despu�s capturamos la excepci�n m�s gen�rica
		} catch (IOException e) {

			view.showError("Se ha producido un error!!");
			e.printStackTrace();
		}

		return 1;

	}
	
	
	//**************EX�MEN  JUANMI**************
	private int call_longitud() {
		
		try {
			int rtn = model.longitud(view.getFichero1().getText(), Integer.parseInt(view.getFichero2().getText()));
			view.getTextArea().setText("han coincidido este n�mero de palabras: "+rtn);
			
		} catch (NumberFormatException e) {
			System.err.print("El n�mero insertado es negativo");
			view.showError("El n�mero insertado es negativo");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.print("ha fallado");
			view.showError("ha fallado");
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
			
		int c = model.buscarPalabra(view.getFichero5().getText(), view.getPalabra().getText(), view.getPrimera().isSelected());
		
		
		if(c == -1) {

			view.getTextArea().setText("No se ha encontrado la palabra.");
		}else {

			view.getTextArea().setText("La palabra se ha encontrado en la linea: "+c+".");
		}
		
		//Primero, capturamos la excepci�n m�s espec�fica
		}catch(FileNotFoundException e) {
			view.showError("No se ha encontrado el archivo!!");
			e.printStackTrace();
			
		//Despu�s capturamos la excepci�n m�s gen�rica	
		}catch(IOException e) {
			view.showError("Se ha producido un error!!");
			e.printStackTrace();
		}
		
		return 1;
	}

	
	
	private int call_ordenarFichero() {
		// TODO: Llamar a la funci�n ordenarFichero de GestionDatos
		// TODO: Gestionar excepciones
		
		try {
			
		File fOrigen = new File(view.getFichero3().getText());
		File fDestino = new File(view.getFichero4().getText());

		//int orden = view.getRBOrden();
		
		String path = model.ordenarFichero(fOrigen, fDestino, view.getRBOrden());
	
		//model.ordenarFichero(fOrigen, fDestino, 1);
		
		view.getTextArea().setText("Puede ver el fichero ordenado en: "+path);

		
		}catch(FileNotFoundException e){
			view.showError("No se ha encontrado el archivo!!");
			e.printStackTrace();
			
		}catch(IOException e) {
			view.showError("Se ha producido un error!!");
			e.printStackTrace();
		}
		
		return 1;
		
	}
	
	private int call_copiarStream() {

		try {

			int bytes = model.copiarFicheroBinario(view.getFichero6().getText(), view.getFichero7().getText());

			view.getTextArea().setText("En total se han copiado: " + bytes + " bytes.");

		// Primero, capturamos la excepci�n m�s espec�fica
		} catch (FileNotFoundException e) {
			view.showError("No se ha encontrado el archivo!!");
			e.printStackTrace();

		// Despu�s capturamos la excepci�n m�s gen�rica
		} catch (IOException e) {
			view.showError("Se ha producido un error!!");
			e.printStackTrace();
		}

		return 1;
	}
	
	private int call_rotar90() {

		try {

			model.Rotacion90GradosDerecha(view.getFichero8().getText(), view.getFichero9().getText());

			view.getTextArea().setText("Su imagen a sido rotada 90� hacia la derecha");

		// Primero, capturamos la excepci�n m�s espec�fica
		} catch (FileNotFoundException e) {
			view.showError("No se ha encontrado el archivo!!");
			e.printStackTrace();

		// Despu�s capturamos la excepci�n m�s gen�rica
		} catch (IOException e) {
			view.showError("Se ha producido un error!!");
			e.printStackTrace();
		}

		return 1;
	}
	
	
	private int call_rotarEspecular() {

		try {

			model.RotacionEspecular(view.getFichero8().getText(), view.getFichero9().getText());

			view.getTextArea().setText("Su imagen ha sido rotada especularmente");

		// Primero, capturamos la excepci�n m�s espec�fica
		} catch (FileNotFoundException e) {
			view.showError("No se ha encontrado el archivo!!");
			e.printStackTrace();

		// Despu�s capturamos la excepci�n m�s gen�rica
		} catch (IOException e) {
			view.showError("Se ha producido un error!!");
			e.printStackTrace();
		}

		return 1;
	}
	
	
	private int call_guardarLibro() {

		int paginas = Integer.parseInt(view.getFichero14().getText());
		int anyo = Integer.parseInt(view.getFichero12().getText());

			try {
				int id_libro_recien_guardado=model.guardarLibro(view.getFichero10().getText(), view.getFichero11().getText(), anyo, view.getFichero13().getText(), paginas);
				//System.out.println("Dins de call, despres de guardar");
				String idText = String.valueOf(id_libro_recien_guardado);
				//idText = String.valueOf(lib.recuperarIdLibro());
				view.getFichero16().setText(""+id_libro_recien_guardado);
				//view.getTextArea().setText(""+lib.getIdLib());
				view.getTextArea().setText("hola");
				
			} catch (ClassNotFoundException e) {
				view.showError("No se ha encontrado el fichero!!");
				e.printStackTrace();
				
			}catch (IOException e) {
				view.showError("Se ha producido un error de tipo IO!!");
				e.printStackTrace();
			}


		view.getTextArea().setText("Su libro se ha guardado");

		return 1;
	}
	
	
private int call_recuperarLibro() {

			try {
				
				model.recuperarLibro(view.getFichero15().getText());
				view.getTextArea().setText("Su libro se ha recuperado");
				
			} catch (ClassNotFoundException e) {
				view.showError("No se ha encontrado el archivo!!");
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
				view.showError("Se ha producido un error!!");
			}
			
		return 1;
	}

private int call_recuperarTodos() {

	try {
		
	model.recuperar_todos();
	view.getTextArea().setText("Sus libros se han recuperado");
	
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
		System.err.println("No se ha encontrado el directorio");
		view.showError("No se ha encontrado el directorio!!");
	}catch (IOException e) {
		e.printStackTrace();
		System.err.println("Se ha producido un error de tipo IOException");
		view.showError("Se ha producido un error!!");
	}

return 1;
}

//********ACTIVIDAD 1 EX�MEN***********************************************
//DEFINIMOS UN M�TODO QUE LLAMAR� TRABAJAR� CON OBJETOS DE LA VISTA Y DEL MODELO
private int call_modificarAutorLibro() {
	
	try {
		
		model.modificaAutorLibro(view.getFichero17().getText(), view.getFichero18().getText());
		view.getTextArea().setText("El libro se ha modificado con el nombre de autor: " + view.getFichero18().getText());
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
		System.err.println("Error de tipo ClassNotFoundException!");
		
	} catch (IOException e) {
		
		e.printStackTrace();
		System.err.println("Error de tipo IOException!");
	}
	
	return 1;
}

//********ACTIVIDAD 2 EX�MEN***********************************************
//DEFINIMOS UN M�TODO QUE LLAMAR� TRABAJAR� CON OBJETOS DE LA VISTA Y DEL MODELO
private int call_mostrarPalabras() {
	
		int palabrasCoincidentes = model.mostrarPalabras(view.getFichero19().getText(), Integer.valueOf(view.getFichero20().getText()));
		
		//if (palabrasCoincidentes == Integer.valueOf(view.getFichero20().getText())){
		if (palabrasCoincidentes == 0){
			
			view.getTextArea().setText("En el fichero indicado no existe ninguna palabra con la longitud indicada");
			
			view.showError("No hay palabras coincidentes!!");
		}else {
			
			view.getMostrarCoincidencias().setText(String.valueOf(palabrasCoincidentes));
			
			view.getTextArea().setText("");
			
		}
		

	return 1;
}

//Actividad 1 ex�men evaluaci�n 1 ADD
private int call_longitudMaxima() throws IOException {
	
	String palabraMasLarga = model.palabraMasLarga(view.getFichero1().getText());
		
		view.getTextArea().setText("La palabra m�s larga es: " +palabraMasLarga);
		view.getFichero2().setText(palabraMasLarga);

return 1;
}

	
}

