package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
//import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.imageio.ImageIO;

import view.*;
import java.awt.image.BufferedImage;



public class GestionDatos {
	
//private LaunchView vista;

	// Constructor de la clase
	public GestionDatos() {

	}

	public BufferedReader abrirFicheros(String fichero) throws FileNotFoundException, IOException {
		// Se lanzan dos excepciones de tipo IOException (comprobadas) que obligan a un
		// try/catch
		// TODO: Implementa una funci�n para abrir ficheros

		// Cargamos el fichero de texto en un objeto FileReader
		FileReader fr = new FileReader(fichero);

		// Para poder leer l�neas y, no solo car�cteres, envolvemos el FileReader en un
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
	
	//M�todo para cerrar Streams
	public void cerrarStream(Closeable c) {
		try {
			c.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean compararContenido(String fichero1, String fichero2) throws FileNotFoundException, IOException {
		// Se lanzan dos excepciones de tipo IOException (comprobadas) que obligan a un
		// try/catch
		// TODO: Implementa la funci�n

		boolean rtn;
		File ficheroUno = new File(fichero1);
		File ficheroDos = new File(fichero2);

		//Hacemos uso del m�todo length(), el cual ofrece el tama�o en bytes de un fichero
		//para averiguar en una primera instancia si los dos ficheros son diferentes
		if (ficheroUno.length() != ficheroDos.length()) {

			System.out.println("Los ficheros son diferentes");

			//vista.getTextArea().setText("Los ficheros son diferentes.");


			rtn = false;

		} else {

			// En un objeto de tipo BufferedReader, y mediante la llamada al m�todo
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

					rtn = false;
				}

				cadena1 = br1.readLine();
				cadena2 = br2.readLine();

			}

			System.out.println("El contenido del archivo de texto " + fichero1 + " es igual a " + fichero2);
			
			//vista.getTextArea().setText("Los ficheros son iguales.");

			// Si se sale del bucle y se llega a este punto, significar� que se ha
			// comprobado que los ficheros no son distintos
			// y, por lo tanto, el m�todo retornar� verdadero

			// Cerramos los ficheros
			br1.close();
			br2.close();

			rtn = true;

		}
		
		return rtn;
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

				System.out.println("La palabra se ha encontrado en la l�nea: "+linea_encontrada);
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
		
		System.out.println("La palabra se ha encontrado en la l�nea: "+linea_encontrada);
		return linea_encontrada;

	}

	public void cerrarBufferedReader(BufferedReader br) {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/*M�todo para comprobar si un fichero existe o no
	public boolean existeFichero(File fichero, LaunchView vista) {
		
		boolean rtn;
		
		if(fichero.isFile()) {
			rtn = true;
		}else {
			
			vista.showError("El fichero que usted indica no existe!!");
			rtn = false;
		}
		
		return rtn;
	}*/
	
	
	//M�todo para ordenar palabras de un fichero
	public String ordenarFichero(File origen, File destino, int tipo_orden) throws FileNotFoundException, IOException {

		String rtn = destino.getAbsolutePath();
		
		//Cargamos en un objeto de tipo FileReader el fichero or�gen a leer y ordenar
		FileReader frOrigen = new FileReader(origen);
		//Le pasamos a un BufferedReader el objeto de tipo FileReader
		BufferedReader brOrigen = new BufferedReader(frOrigen);
		//Declaramos una variable de tipo String que se encargar� de almacenar las l�neas del fichero de texto le�do
		String str;
		//Instanciamos un ArrayList en el que se almacenar�n las l�neas que ir� recogiendo la variable String anterior
		ArrayList<String> miArrayList = new ArrayList<String>();
		//Instanciamos un objeto de tipo FileWriter que indicar� el fichero destino en el que se almacenar� el texto ordenado
		FileWriter ficheroOrdenado = new FileWriter(destino);
		//Envolvemos el FileWriter anterior en un BufferedWriter
		BufferedWriter bwDestino = new BufferedWriter(ficheroOrdenado);
		//Recorremos el fichero a leer con un bucle while y guardamos su contenido en el ArrayList
		while ((str = brOrigen.readLine()) != null) {
			miArrayList.add(str);
		}

		//Cerramos el fichero origen una vez le�do
		frOrigen.close();

		if (tipo_orden == 1) {

			//Con el m�todo sort de un objeto de tipo Collections ordenamos el 
			//contenido del ArrayList de forma ascendente o "natural"
			Collections.sort(miArrayList);

			//Mostramos el contenido del fichero ordenado por consola y, a su vez, lo guardamos en un fichero destino
			for (int x = 0; x < miArrayList.size(); x++) {
				System.out.println(miArrayList.get(x));
				bwDestino.write(miArrayList.get(x)+"\n");
			}
			

		} else {
			
			//Con el objeto de tipo Comparator y el m�todo sort de un objeto de tipo Collections ordenamos el 
			//contenido del ArrayList de forma descendente
			Comparator<String> comparador = Collections.reverseOrder();
			
			Collections.sort(miArrayList, comparador);
			
			//Mostramos el contenido del fichero ordenado por consola y, a su vez, lo guardamos en un fichero destino
			for (int x = 0; x < miArrayList.size(); x++) {
				System.out.println(miArrayList.get(x));
				bwDestino.write(miArrayList.get(x)+"\n");
			}
			
		}
		//Cerramos el fichero destino una vez le�do
		bwDestino.close();
		
		return rtn;
	}

	public int copiarFicheroBinario (String fichero1, String fichero2) throws FileNotFoundException, IOException {

		//Declaramos las variables y objetos a utilizar
		File fEntrada = null;
		File fSalida = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int rtn = 0;

		//Generamos el fichero de entrada
		fEntrada = new File(fichero1);

		//Generamos el fichero de salida
		fSalida = new File(fichero2);

		//Averiguamos el tama�o en bytes del fichero de entrada
		int tamanyoBytesFOrigen = (int) fEntrada.length();

		//A�adimos una unidad al tama�o del fichero or�gen 
		//para asegurarnos que el parseo de log a integer
		//resulta acertado
		int bytesCopiados = tamanyoBytesFOrigen + 1;

		// Fichero de entrada
		fis = new FileInputStream(fEntrada);

		// Fichero de salida
		fos = new FileOutputStream(fSalida);

		// Creamos un buffer que se encargar� de almacenar los bytes le�dos
		byte[] buffer = new byte[bytesCopiados];
		// Leemos los bytes del fichero de entrada
		fis.read(buffer);
		fos.write(buffer);

		rtn = tamanyoBytesFOrigen;

		//Cerramos los streams
		cerrarStream(fis);
		cerrarStream(fos);

		return rtn;
	}
	
	
	//M�todo para rotar im�genes 90 grados hacia la derecha
	public void Rotacion90GradosDerecha(String ficheroEntrada, String ficheroSalida) throws IOException,FileNotFoundException {

		// Inicializaci�n de variables y objetos
		int anchoImagen;
		int altoImagen;
		int[][] arrayImagen;

		File f = new File(ficheroEntrada);
		BufferedImage bf = ImageIO.read(f);

		// columnas (p�xeles) de la imagen
		anchoImagen = bf.getWidth();
		// filas (p�xeles) de la imagen
		altoImagen = bf.getHeight();

		// anchoImagen = 512;
		// altoImagen = 512;

		// Creamos un array bidimensional para almacenar los valores RGB de la imagen
		arrayImagen = new int[altoImagen][anchoImagen];

		// Cargamos el array bidimensional con los valores RGB de la imagen
		for (int x = 0; x < altoImagen; x++) {
			for (int y = 0; y < anchoImagen; y++) {

				arrayImagen[x][y] = bf.getRGB(x, y);
			}
		}

		// Por si se quiere comprobar el contenido del array por consola:
		/*
		 * for (int i = 0; i < altoImagen; i++) { System.out.println(); for (int j = 0;
		 * j < anchoImagen; j++) {
		 * 
		 * System.out.print(arrayImagen[i][j] + " "); } }
		 */

		int[][] arrayImagen90 = new int[altoImagen][anchoImagen];

		// Rotamos la imagen 90� hacia la derecha
		for (int x = 0; x < altoImagen; x++) {
			for (int y = 0; y < anchoImagen; y++) {

				int n = (altoImagen - 1);

				// arrayImagen90[y][511 - x] = bf.getRGB(x, y);
				arrayImagen90[n - y][x] = bf.getRGB(x, y);
			}
		}

		// Creamos un nuevo BufferedImage para almacenar la imagen rotada
		BufferedImage img = new BufferedImage(512, 512, BufferedImage.TYPE_INT_RGB);

		// Creamos un nuevo fichero de salida
		File g = new File(ficheroSalida);

		// Cargamos los valores del array que forman la imagen rotada
		// en el BufferedImage
		for (int x = 0; x < 512; x++) {
			for (int y = 0; y < 512; y++) {
				img.setRGB(x, y, arrayImagen90[x][y]);
			}
		}

		// Con el m�todo est�tico write de la clase ImageIO escribimos en el fichero de
		// salida g el contenido del BufferedImage que ya contiene la info de la imagen
		// rotada
		// y le indicamos que se formatee a imagen de tipo PNG
		ImageIO.write(img, "PNG", g);

	}

	
	//M�todo para rotar im�genes de forma especular
	public void RotacionEspecular(String ficheroEntrada, String ficheroSalida) throws IOException,FileNotFoundException {

		// Inicializaci�n de variables y objetos
		int anchoImagen;
		int altoImagen;
		int[][] arrayImagen;

		File f = new File(ficheroEntrada);
		BufferedImage bf = ImageIO.read(f);

		// columnas (p�xeles) de la imagen
		anchoImagen = bf.getWidth();
		// filas (p�xeles) de la imagen
		altoImagen = bf.getHeight();

		// anchoImagen = 512;
		// altoImagen = 512;

		// Creamos un array bidimensional para almacenar los valores RGB de la imagen
		arrayImagen = new int[altoImagen][anchoImagen];

		// Cargamos el array bidimensional con los valores RGB de la imagen
		for (int x = 0; x < altoImagen; x++) {
			for (int y = 0; y < anchoImagen; y++) {

				arrayImagen[x][y] = bf.getRGB(x, y);
			}
		}

		// Por si se quiere comprobar el contenido del array por consola:
		/*
		 * for (int i = 0; i < altoImagen; i++) { System.out.println(); for (int j = 0;
		 * j < anchoImagen; j++) {
		 * 
		 * System.out.print(arrayImagen[i][j] + " "); } }
		 */

		int[][] arrayImagenEspejo = new int[altoImagen][anchoImagen];

		// Rotamos de forma especular
		for (int x = 0; x < altoImagen; x++) {
			for (int y = 0; y < anchoImagen; y++) {

				int n = (altoImagen - 1);
				// arrayImagenEspejo[x][n-y] = bf.getRGB(x, y);
				arrayImagenEspejo[n - x][y] = bf.getRGB(x, y);
			}
		}

		// Creamos un nuevo BufferedImage para almacenar la imagen rotada
		BufferedImage img = new BufferedImage(512, 512, BufferedImage.TYPE_INT_RGB);

		// Creamos un nuevo fichero de salida
		File g = new File(ficheroSalida);

		// Cargamos los valores del array que forman la imagen rotada
		// en el BufferedImage
		for (int x = 0; x < 512; x++) {
			for (int y = 0; y < 512; y++) {
				img.setRGB(x, y, arrayImagenEspejo[x][y]);
			}
		}

		// Con el m�todo est�tico write de la clase ImageIO escribimos en el fichero de
		// salida g el contenido del BufferedImage que ya contiene la info de la imagen
		// rotada
		// y le indicamos que se formatee a imagen de tipo PNG
		ImageIO.write(img, "PNG", g);
	}
	
	

	//************************M�TODOS****************************************************************************
	//M�todo para imprimir por pantalla la info de los libros
	public void printInfo() {

		Libro lib = new Libro();
		System.out.println("Id:	" + lib.getId());
		System.out.println("T�tulo:	" + lib.getTitulo());
		System.out.println("Autor: " + lib.getAutor());
		System.out.println("A�o de publicaci�n: " + lib.getAnyoPubli());
		System.out.println("Editor: " + lib.getEditor());
		System.out.println("N�mero de p�ginas: " + lib.getNumPaginas());
		System.out.println();	
	}
	
	
	// M�todo para cerrar streams
	public void cerrarStreamObjetos(Closeable c) {

		try {
			if (c != null) {
				c.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	//M�todo para recuperar objetos guardados en un fichero de datos
	public Libro recuperarLibro(String idlibro) throws ClassNotFoundException,IOException {

		Libro lib = null;
		ObjectInputStream ois = null;

		try {
			// Creamos un objeto de tipo ObjectInputStream a partir de la informaci�n de un
			// fichero de datos
			//System.out.println("VAig a fer "+idlibro);
			ois = new ObjectInputStream(new FileInputStream("libros/"+idlibro));
			//System.out.println("ois val "+ois);
			// Mediante el stream de objetos, leemos la informaci�n del fichero de datos y
			// la volvemos a guardar
			// en un objeto serializable de tipo Libro
			// Nota: Puesto que el m�todo readObject() lee objetos, hacemos un casting
			// al tipo de objeto que queremos guardar, en este caso, Libro
			lib = (Libro) ois.readObject();
			//System.out.println("HE llegit "+lib.getTitulo());
			
			//Finalmente, mostramos la info del libro por consola
			//lib.printInfo();
			
		}catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("ClassNotFoundException Error!");
		}catch (IOException e) {
			throw new IOException("IOException Error!");
		}


		 finally {
			// Cerramos el stream
			cerrarStreamObjetos(ois);
		}

		return lib;
	}
	
	
	public ArrayList<Libro> recuperar_todos() throws ClassNotFoundException, IOException{
		
		//Cargamos en un objeto File el directorio del proyecto llamado "Libros"
		File directori = new File("libros");
		
		//Hacemos uso del m�todo list() para obtener en un array el contenido del directorio "libros"
		String[] nombres = directori.list();
		
		ArrayList<Libro> misLibros = new ArrayList<Libro>();
		
		for (String o: nombres){
		    Libro l = recuperarLibro(o);
		    l.printInfo();
		    misLibros.add(l);
		    
		}
		
		return misLibros;	
		
	}
	

	
	// M�todo para guardar libros 
	
	public int guardarLibro(String titulo, String autor, int anyo, String editor, int num_paginas) throws ClassNotFoundException, IOException {

		//Variable que almacenar� el id del �ltimo libro guardado
		int i=recuperaId();
		
		//Creamos un objeto libro
		Libro lib = new Libro(i,titulo, autor, anyo, editor, num_paginas);
		
		//Definimos el directorio y el fichero en el que se almacenar�n los libros
		File ficheroLibro = new File("libros/"+i+".txt");

		ObjectOutputStream out = null;
		
		//Obtenemos el id correspondiente al libro a guardar
		int nuevoId=actualizaId();
		
		//System.out.println("El id es "+lib.getId());

		try {
			// Creamos un Stream de objetos
			out = new ObjectOutputStream(new FileOutputStream(ficheroLibro));
			// Escribimos en el fichero definido en el objeto out el Objeto de tipo Libro
			// serializable
			out.writeObject(lib);

		} catch (FileNotFoundException e) {
			
			System.err.println("No se ha encontrado el fichero!!");
			e.printStackTrace();
			
		}finally {

			// Cerramos el stream de objetos
			cerrarStreamObjetos(out);
		}

		return nuevoId;
	}
			
			

	//M�todo para obtener el id actual del fichero que guarda los id's
	public int recuperaId() throws IOException {
		
		FileReader fr = new FileReader("idLibros.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		int intLine = Integer.valueOf(line);
		br.close();
		fr.close();
		System.out.println("N�mero de identificador del fichero: "+intLine);
		return intLine;
	}
	
	//M�todo para actualizar el id en el fichero que guarda los id's, tras crear un nuevo libro
	public int actualizaId() throws IOException {
		
		int idnuevo=recuperaId()+1;
		FileWriter fw = new FileWriter("idLibros.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(""+idnuevo);
		bw.close();
		fw.close();
		
		return idnuevo;
		
	}
	
	//************ACTIVIDAD 1 EX�MEN****************************************************************************
	//M�TODO PARA MODIFICAR ELAUTOR DE UN LIBRO:
	
	//El m�todo modificaAutorLibro lanza dos tipos de excepciones de tipo IO
	public void modificaAutorLibro(String id_libro, String autor) throws ClassNotFoundException, IOException {
		
		//Intentamos Recuperar el libro 
		Libro lib = recuperarLibro(id_libro);
		
		//Indicamos en que archivo queremos que modifique el autor. En nuestro caso en el mismo fichero.
		File ficheroLibro = new File("libros/"+id_libro);
		
		//Declaramos un objeto de tipo ObjectOutputStream
		ObjectOutputStream out = null;
		
		//Si el libro que intentamos recuperar se muestra como null es porque no existe pr�viamente,
		//por lo que lanzamos un mensaje de avertencia por consola
		if (lib == null) {
			System.out.println("Error>>>El libro que intenta modificar no existe!!");
		//De no cumplirse la sentencia anterior es porque el libro si que existe
		}else {
			//Bloque try-catch obligado por la clase ObjectOutputStream
			//Podr�a lanzar la excepci�n pero la capturo aqu� mismo
			try {
				//Seteamos el nuevo nombre de autor en el objeto libro
				lib.setAutor(autor);
				//Creamos un Stream de objetos y le indicamos en que fichero debe de escribir
				out = new ObjectOutputStream(new FileOutputStream(ficheroLibro));
				// Escribimos en el fichero definido en el objeto out el Objeto de tipo Libro
				// serializable
				out.writeObject(lib);
				//Imprimos la nueva info modificada del libro haciendo uso del m�todo printInfo()
				//que ya ten�amos implementada
				lib.printInfo();

			//Capturamos una excepci�n de tipo FileNotFoundException
			} catch (FileNotFoundException e) {
				
				System.err.println("No se ha encontrado el fichero!!");
				e.printStackTrace();
				
			}finally {

				// Cerramos el stream de objetos
				cerrarStreamObjetos(out);
			}
		}
		
	}
		
	//************ACTIVIDAD 2 EX�MEN****************************************************************************
	//M�TODO PARA MOSTRAR UN DETERMINADO N�MERO DE PALABRAS DE UN FICHERO:	
	
	public void mostrarPalabras(String f, int n_palabras) {

		File archivo = null;

		try {
			// "archivo.txt" es el archivo que va a leer
			archivo = new File(f);
			// Variable para guardar la l�nea le�da
			String linea;

			FileReader fr = new FileReader(archivo);

			BufferedReader br = new BufferedReader(fr);
			
			if(archivo.length() <= 0) {
				
				System.out.println("El fichero est� vac�o!");
				
			}else {

			while ((linea = br.readLine()) != null) {
				for (int i = 0; i < n_palabras; i++) {
					System.out.print(linea.charAt(i));
				}
			}

			fr.close();
			
			}
			
		} catch (IOException e) {
			
			System.out.println(e);
		}

	}
	
	public int longitud(String fichero, int longitud) throws IOException,NumberFormatException{
		
		if(longitud<0) {
			throw new NumberFormatException("El n�mero insertado es negativo");
		}
		
		File f = new File (fichero);
		
		if(!f.exists()){
			
			throw new IOException ("ha fallado");
			
		}
		
		//System.out.println("El fichero es: " + fichero);
		//System.out.println("La longitud es: " + longitud);
		
		BufferedReader b = new BufferedReader (new FileReader(new File(fichero)));
		
		String s1;
		int contador = 0;
		
		while((s1=b.readLine())!=null){
			
			//System.out.println("He le�do: " + s1);
			
			if(s1.length() == longitud){
				contador++;
				//System.out.println("La palabra " + s1 + " tiene una longitud de " + longitud);
			}
			
		}
		
		System.out.println("Coinciden "+ contador + " palabras conla longitud indicada");
		
		return contador;
		
	}

}
