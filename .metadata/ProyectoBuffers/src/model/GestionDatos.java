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
		// TODO: Implementa una función para abrir ficheros

		// Cargamos el fichero de texto en un objeto FileReader
		FileReader fr = new FileReader(fichero);

		// Para poder leer líneas y, no solo carácteres, le pasamos el FileReader a un
		// BufferedReader
		BufferedReader br = new BufferedReader(fr);

		// El método retorna el propio objeto BufferedReader
		return br;
	}

	public void cerrarFicheros(String fichero) throws FileNotFoundException, IOException {
		// Se lanzan dos excepciones de tipo IOException (comprobadas) que obligan a un
		// try/catch
		// TODO: Implementa una función para cerrar ficheros

		// Cargamos el fichero de texto en un objeto FileReader
		// Juanmi: ¿Para cerrar un fichero? ¿No sería mejor pasar al método, por
		// parámetro, un objeto de tipo FileReader?
		// Evitando así, tener que abrir el fichero en el método para, posteriormente,
		// poder cerrarlo?
		FileReader fr = new FileReader(fichero);

		// Cerramos el fichero
		fr.close();
	}

	public boolean compararContenido(String fichero1, String fichero2) throws FileNotFoundException, IOException {
		// Se lanzan dos excepciones de tipo IOException (comprobadas) que obligan a un
		// try/catch
		// TODO: Implementa la función

		File ficheroUno = new File(fichero1);
		File ficheroDos = new File(fichero2);

		if (ficheroUno.length() != ficheroDos.length()) {

			System.out.println("Los ficheros son diferentes");
			return false;

		} else {

			// En un objeto de tipo BufferedReader y mediante la llamada al método
			// abrirFicheros,
			// se almacena el contenido del primer fichero que se pasa como parámetro
			BufferedReader br1 = this.abrirFicheros(fichero1);

			// En un objeto de tipo BufferedReader y mediante la llamada al método
			// abrirFicheros,
			// se almacena el contenido del segundo fichero que se pasa como parámetro
			BufferedReader br2 = this.abrirFicheros(fichero2);

			// Para que pueda ejecutarse el método While, en una primera instancia, se
			// guarda en las variables
			// cadena 1 y cadena2 el contenido de la primera línea de los ficheros 1 y 2
			String cadena1 = br1.readLine();
			String cadena2 = br2.readLine();

			// Con el bucle While se va comparando, línea a línea, el contenido de los dos
			// ficheros
			while (cadena1 != null && cadena2 != null) {

				// En el momento en que el contenido de una línea de un fichero
				// no sea igual al contenido de la línea del otro fichero (considerando ambas
				// siempre en la misma posición),
				// Los ficheros ya no serán iguales y, por lo tanto, el método retornará falso.
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

			// Si se sale del bucle y se llega a este punto, significará que se ha
			// comprobado que los ficheros no son distintos
			// y, por lo tanto, el método retornará verdadero

			// Cerramos los ficheros
			br1.close();
			br2.close();

			return true;

		}

	}

	// En este método hay que tener en cuenta que se supone que cada línea del
	// fichero contiene una única palabra
	public int buscarPalabra(String fichero1, String palabra, boolean primera_aparicion)
			throws FileNotFoundException, IOException {
		// Se lanzan dos excepciones de tipo IOException (comprobadas) que obligan a un
		// try/catch

		// Variable que se encargará de contar el número de línea
		int contador = 0;

		// Variable de retorno que se inicializa a -1 como supuesto de que no se
		// encuentre la palabra buscada en el fichero
		int linea_encontrada = -1;
		

		// Abrimos el fichero y guardamos su contenido en un objeto BufferedReader
		BufferedReader br = this.abrirFicheros(fichero1);
		
		//Leemos la primera línea del fichero
		String linea = br.readLine();
		

		// Lectura del contenido del fichero mediante un bucle While
		//Mientras la línea leída sea distinta de null se recorrerá el código definido en el while
		while (linea != null) {

			// Cada línea leída se incrementa el contador en una unidad
			contador += 1;
			
			// Si se encuentra la palabra buscada y se ha definido como parámetro booleano
			// true
			if (linea.equals(palabra) && primera_aparicion == true) {

				// Se indica el número de línea de la primera aparición
				linea_encontrada = contador;

				// Como ya no hace falta seguir recorriendo el contenido del fichero, se cierra
				br.close();

				System.out.println("La palabra se ha encopntrado en la línea: "+linea_encontrada);
				// Al llegar al return, el método finalizará
				return linea_encontrada;
			}

			// Si se encuentra la palabra buscada y se ha definido como parámetro booleano
			// false
			if (linea.equals(palabra) && primera_aparicion == false) {

				// En la variable linea_encontrada se almacenará el número de línea de
				// la última aparición
				linea_encontrada = contador;
			}
			
			//Se lee la siguiente línea del fichero y siempre que esta sea distinta de null
			//se volverá a entrar en el while
			linea = br.readLine();
		}

		// Se cierra el fichero
		br.close();

		// Si se ha entrado en el condicional if se retornará el número de línea de la
		// última aparición
		// y si no se ha entrado, en dicho if, se retornará el valor por defecto de la
		// variabe, es decir, -1
		
		System.out.println("La palabra se ha encopntrado en la línea: "+linea_encontrada);
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
