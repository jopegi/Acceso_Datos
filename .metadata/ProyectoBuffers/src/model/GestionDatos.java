package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GestionDatos {

	// Constructor de la clase
	public GestionDatos() {

	}

	public BufferedReader abrirFicheros(String fichero) throws FileNotFoundException, IOException {
		// Se lanzan dos excepciones de tipo IOException (comprobadas) que obligan a un
		// try/catch
		// TODO: Implementa una funci�n para abrir ficheros

		// Cargamos el fichero de texto en un objeto FileReader
		FileReader fr = new FileReader(fichero);

		// Para poder leer l�neas y, no solo car�cteres, le pasamos el FileReader a un
		// BufferedReader
		BufferedReader br = new BufferedReader(fr);

		// El m�todo retorna el propio objeto BufferedReader
		return br;
	}

	public void cerrarFicheros(String fichero) throws FileNotFoundException, IOException {
		// Se lanzan dos excepciones de tipo IOException (comprobadas) que obligan a un
		// try/catch
		// TODO: Implementa una funci�n para cerrar ficheros

		// Cargamos el fichero de texto en un objeto FileReader
		// Juanmi: �Para cerrar un fichero? �No ser�a mejor pasar al m�todo, por
		// par�metro, un objeto de tipo FileReader?
		// Evitando as�, tener que abrir el fichero en el m�todo para, posteriormente,
		// poder cerrarlo?
		FileReader fr = new FileReader(fichero);

		// Cerramos el fichero
		fr.close();
	}

	public boolean compararContenido(String fichero1, String fichero2) throws FileNotFoundException, IOException {
		// Se lanzan dos excepciones de tipo IOException (comprobadas) que obligan a un
		// try/catch
		// TODO: Implementa la funci�n

		File ficheroUno = new File(fichero1);
		File ficheroDos = new File(fichero2);

		if (ficheroUno.length() != ficheroDos.length()) {

			System.out.println("Los ficheros son diferentes");
			return false;

		} else {

			// En un objeto de tipo BufferedReader y mediante la llamada al m�todo
			// abrirFicheros,
			// se almacena el contenido del primer fichero que se pasa como par�metro
			BufferedReader br1 = this.abrirFicheros(fichero1);

			// En un objeto de tipo BufferedReader y mediante la llamada al m�todo
			// abrirFicheros,
			// se almacena el contenido del segundo fichero que se pasa como par�metro
			BufferedReader br2 = this.abrirFicheros(fichero2);

			// Para que pueda ejecutarse el m�todo While, en una primera instancia, se
			// guarda en las variables
			// cadena 1 y cadena2 el contenido de la primera l�nea de los ficheros 1 y 2
			String cadena1 = br1.readLine();
			String cadena2 = br2.readLine();

			// Con el bucle While se va comparando, l�nea a l�nea, el contenido de los dos
			// ficheros
			while (cadena1 != null && cadena2 != null) {

				// En el momento en que el contenido de una l�nea de un fichero
				// no sea igual al contenido de la l�nea del otro fichero (considerando ambas
				// siempre en la misma posici�n),
				// Los ficheros ya no ser�n iguales y, por lo tanto, el m�todo retornar� falso.
				if (cadena1.equals(cadena2) == false) {

					// Cerramos los ficheros
					br1.close();
					br2.close();

					return false;
				}

				cadena1 = br1.readLine();
				cadena2 = br2.readLine();

			}

			System.out.println("El contenido del archivo de texto " + fichero1 + " es igual a " + fichero2);

			// Si se sale del bucle y se llega a este punto, significar� que se ha
			// comprobado que los ficheros no son distintos
			// y, por lo tanto, el m�todo retornar� verdadero

			// Cerramos los ficheros
			br1.close();
			br2.close();

			return true;

		}

	}

	// En este m�todo hay que tener en cuenta que se supone que cada l�nea del
	// fichero contiene una �nica palabra
	public int buscarPalabra(String fichero1, String palabra, boolean primera_aparicion)
			throws FileNotFoundException, IOException {
		// Se lanzan dos excepciones de tipo IOException (comprobadas) que obligan a un
		// try/catch

		// Variable que se encargar� de contar el n�mero de l�nea
		int contador = 0;

		// Variable de retorno que se inicializa a -1 como supuesto de que no se
		// encuentre la palabra buscada en el fichero
		int linea_encontrada = -1;
		

		// Abrimos el fichero y guardamos su contenido en un objeto BufferedReader
		BufferedReader br = this.abrirFicheros(fichero1);
		
		//Leemos la primera l�nea del fichero
		String linea = br.readLine();
		

		// Lectura del contenido del fichero mediante un bucle While
		//Mientras la l�nea le�da sea distinta de null se recorrer� el c�digo definido en el while
		while (linea != null) {

			// Cada l�nea le�da se incrementa el contador en una unidad
			contador += 1;
			
			// Si se encuentra la palabra buscada y se ha definido como par�metro booleano
			// true
			if (linea.equals(palabra) && primera_aparicion == true) {

				// Se indica el n�mero de l�nea de la primera aparici�n
				linea_encontrada = contador;

				// Como ya no hace falta seguir recorriendo el contenido del fichero, se cierra
				br.close();

				System.out.println("La palabra se ha encopntrado en la l�nea: "+linea_encontrada);
				// Al llegar al return, el m�todo finalizar�
				return linea_encontrada;
			}

			// Si se encuentra la palabra buscada y se ha definido como par�metro booleano
			// false
			if (linea.equals(palabra) && primera_aparicion == false) {

				// En la variable linea_encontrada se almacenar� el n�mero de l�nea de
				// la �ltima aparici�n
				linea_encontrada = contador;
			}
			
			//Se lee la siguiente l�nea del fichero y siempre que esta sea distinta de null
			//se volver� a entrar en el while
			linea = br.readLine();
		}

		// Se cierra el fichero
		br.close();

		// Si se ha entrado en el condicional if se retornar� el n�mero de l�nea de la
		// �ltima aparici�n
		// y si no se ha entrado, en dicho if, se retornar� el valor por defecto de la
		// variabe, es decir, -1
		
		System.out.println("La palabra se ha encopntrado en la l�nea: "+linea_encontrada);
		return linea_encontrada;

	}

	public void cerrarBufferedReader(BufferedReader br) {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
