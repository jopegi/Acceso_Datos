package gestionficherosapp;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import gestionficheros.FormatoVistas;
import gestionficheros.GestionFicheros;
import gestionficheros.GestionFicherosException;
import gestionficheros.TipoOrden;

public class GestionFicherosImpl implements GestionFicheros {
	private File carpetaDeTrabajo = null;
	private File file2 = null;
	private Object[][] contenido;
	private int filas = 0;
	private int columnas = 3;
	private FormatoVistas formatoVistas = FormatoVistas.NOMBRES;
	private TipoOrden ordenado = TipoOrden.DESORDENADO;

	public GestionFicherosImpl() {
		carpetaDeTrabajo = File.listRoots()[0];
		actualiza();
	}

	//Método que actualiza el contenido del directorio mostrado en la interfaz gráfica
	private void actualiza() {

		String[] ficheros = carpetaDeTrabajo.list(); // obtener los nombres
		// calcular el número de filas necesario
		filas = ficheros.length / columnas;
		if (filas * columnas < ficheros.length) {
			filas++; // si hay resto necesitamos una fila más
		}

		// dimensionar la matriz contenido según los resultados

		contenido = new String[filas][columnas];
		// Rellenar contenido con los nombres obtenidos
		for (int i = 0; i < columnas; i++) {
			for (int j = 0; j < filas; j++) {
				int ind = j * columnas + i;
				if (ind < ficheros.length) {
					contenido[j][i] = ficheros[ind];
				} else {
					contenido[j][i] = "";
				}
			}
		}
	}

	//Método para acceder al directorio superior al que estamos situados 
	@Override
	public void arriba() {

		//System.out.println("holaaa");
		
		//Hay que controlar que se actualice la carpeta de trabajo a un directorio anterior 
		//siempre y cuando ese supuesto directorio padre exista
		if (carpetaDeTrabajo.getParentFile() != null) {
			carpetaDeTrabajo = carpetaDeTrabajo.getParentFile();
			actualiza();
		}

	}

	@Override
	public void creaCarpeta(String arg0) throws GestionFicherosException {
		
		File file = new File(carpetaDeTrabajo,arg0);
		
		//que no exista el directorio -> lanzará una excepción
		if (file.exists()) {
			
			throw new GestionFicherosException();
		}
		//que se pueda escribir en el directorio-> lanzará una excepción
		if (!carpetaDeTrabajo.canWrite()) {
			
			throw new GestionFicherosException();
		}
		
		file.mkdir();

		actualiza();
	}

	@Override
	public void creaFichero(String arg0) throws GestionFicherosException {
		
		File file = new File(carpetaDeTrabajo,arg0);
		
		// que no exista el fichero -> lanzará una excepción
		if (file.exists()) {

			throw new GestionFicherosException();
		}
		// que se pueda escribir en el directorio padre-> lanzará una excepción
		if (!carpetaDeTrabajo.canWrite()) {

			throw new GestionFicherosException();
		}

		try {
			file.createNewFile();
		}catch(IOException e) {
			
			System.err.println("Error al crear el fichero");
			e.printStackTrace();
			
		}
		

	}

	@Override
	public void elimina(String arg0) throws GestionFicherosException {

		File file = new File(carpetaDeTrabajo, arg0);

		// Si el fichero no existe -> lanzará una excepción
		if (!file.exists()) {

			throw new GestionFicherosException();
		}
		// Si los permisos del directorio no permiten que se pueda eliminar-> lanzará
		// una excepción
		if (!carpetaDeTrabajo.canWrite()) {

			throw new GestionFicherosException();
		}

		//Borramos el fichero
		file.delete();

		//Actualizamos
		actualiza();

	}

	//Método para poder cambiar de carpeta de trabajo
	@Override
	public void entraA(String arg0) throws GestionFicherosException {
		
		//Necesitamos construir una nueva ruta a partir del string que recibe el método como parámetro
		//Dicha ruta se corresponderá con el directorio al que pretendemos acceder. 
		File file = new File(carpetaDeTrabajo, arg0);
		// se controla que el nombre corresponda a una carpeta existente
		if (!file.isDirectory()) {
			throw new GestionFicherosException("Error. Se ha encontrado "
					+ file.getAbsolutePath()
					+ " pero se esperaba un directorio");
		}
		// se controla que se tengan permisos para leer carpeta
		if (!file.canRead()) {
			throw new GestionFicherosException("Alerta. No se puede acceder a "
					+ file.getAbsolutePath() + ". No hay permiso");
		}
		// nueva asignación de la carpeta de trabajo
		carpetaDeTrabajo = file;
		// se requiere actualizar contenido
		actualiza();

	}

	@Override
	public int getColumnas() {
		return columnas;
	}

	@Override
	public Object[][] getContenido() {
		return contenido;
	}

	@Override
	public String getDireccionCarpeta() {
		return carpetaDeTrabajo.getAbsolutePath();
	}

	@Override
	public String getEspacioDisponibleCarpetaTrabajo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEspacioTotalCarpetaTrabajo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFilas() {
		return filas;
	}

	@Override
	public FormatoVistas getFormatoContenido() {
		return formatoVistas;
	}

	@Override
	public String getInformacion(String arg0) throws GestionFicherosException {
		
		//Para concatenar cadenas de texto hacemos uso de la Clase StringBuilder y su método append()
		StringBuilder strBuilder=new StringBuilder();
		
		File file = new File(carpetaDeTrabajo,arg0);
		

		// Controlar que existe. Si no, se lanzará una excepción
		if (!file.exists()) {
			throw new GestionFicherosException("el fichero no existe");
		}
		// Controlar que haya permisos de lectura. Si no, se lanzará una excepción
		if (!file.canRead()) {
			throw new GestionFicherosException("el fichero no tiene permisos de lectura");
		}

		//Título
		strBuilder.append("INFORMACIÓN DEL SISTEMA");
		strBuilder.append("\n\n");
		
		//Nombre
		strBuilder.append("Nombre: ");
		strBuilder.append(arg0);
		strBuilder.append("\n");
		
		//Tipo: fichero o directorio
		if (file.isDirectory()) {
			strBuilder.append("Tipo: directorio");
			strBuilder.append("\n");
			
		}else {
			strBuilder.append("Tipo: fichero");
			strBuilder.append("\n");
		}
		
		//Ubicación
		strBuilder.append("Ubicación: ");
		strBuilder.append(file.getAbsolutePath());
		strBuilder.append("\n");
		
		//Fecha de última modificación
		strBuilder.append("Última modificación: ");
		//strBuilder.append(file.lastModified());
		strBuilder.append(new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(
			    new Date(file.lastModified()))
			);
		
		strBuilder.append("\n");
		
		//Si es un fichero oculto o no
		if (file.isHidden()) {
			strBuilder.append("Visibilidad: oculto");
			strBuilder.append("\n");
			
		}else {
			strBuilder.append("Visibilidad: visible");
			strBuilder.append("\n");
		}
		
		
		//Si es directorio: Espacio libre, espacio disponible, espacio total
		//bytes
		
		if (file.isDirectory()) {
			strBuilder.append("Espacio libre: ");
			strBuilder.append(file.getFreeSpace());
			strBuilder.append("\n");
			strBuilder.append("Espacio disponible: ");
			strBuilder.append(file.getUsableSpace());
			strBuilder.append("\n");
			strBuilder.append("Espacio total: ");
			strBuilder.append(file.getTotalSpace());
			strBuilder.append("\n");
		}
		
		if (file.isDirectory()) {
			strBuilder.append("Elementos contenidos: ");
			strBuilder.append(file.list().length);
			strBuilder.append("\n");
			
			strBuilder.append("Tamaño (bytes): ");
			strBuilder.append(file.getTotalSpace());
			strBuilder.append("\n");
			
		}
			
		
		return strBuilder.toString();
	}

	@Override
	public boolean getMostrarOcultos() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNombreCarpeta() {
		return carpetaDeTrabajo.getName();
	}

	@Override
	public TipoOrden getOrdenado() {
		return ordenado;
	}

	@Override
	public String[] getTituloColumnas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getUltimaModificacion(String arg0)
			throws GestionFicherosException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String nomRaiz(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numRaices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void renombra(String arg0, String arg1) throws GestionFicherosException {
		
		//arg0 : hace referencia a la ruta del fichero orígen
		//arg1 : hace referencia al nuevo nombre del fichero 
		
		//1º Debemos comprobar que el fichero que queremos renombrar, realmente exista:
		
		File file = new File(carpetaDeTrabajo, arg0);

		// Si el fichero no existe -> lanzará una excepción
		if (!file.exists()) {

			throw new GestionFicherosException();
		}
		// Si los permisos del directorio no permiten que el fichero se pueda renombrar-> lanzará
		// una excepción
		if (!carpetaDeTrabajo.canWrite()) {

			throw new GestionFicherosException();
		}

		//2º Debemos comprobar que no existe ningun fichero con el nuevo nombre que pretendemos asignarle al nuevo fichero:
		
		file2 = new File(carpetaDeTrabajo, arg1);
		
		// Si el fichero ya existe -> lanzará una excepción
				if (file2.exists()) {

					throw new GestionFicherosException();
				}
				// Si los permisos del directorio no permiten que el fichero se pueda renombrar-> lanzará
				// una excepción
				if (!carpetaDeTrabajo.canWrite()) {

					throw new GestionFicherosException();
				}
		
		//Tras las comprobaciones pertinentes, renombramos el fichero
		file.renameTo(file2);
		
		//Actualizamos
		actualiza();

	}

	@Override
	public boolean sePuedeEjecutar(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sePuedeEscribir(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sePuedeLeer(String arg0) throws GestionFicherosException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setColumnas(int arg0) {
		columnas = arg0;

	}

	//Método encargado de indicar una nueva carpeta de trabajo a que acceder
	@Override
	public void setDirCarpeta(String arg0) throws GestionFicherosException {
		File file = new File(arg0);

		// se controla que la dirección exista y sea directorio
		if (!file.isDirectory()) {
			throw new GestionFicherosException("Error. Se esperaba "
					+ "un directorio, pero " + file.getAbsolutePath()
					+ " no es un directorio.");
		}

		// se controla que haya permisos para leer carpeta
		if (!file.canRead()) {
			throw new GestionFicherosException(
					"Alerta. No se puede acceder a  " + file.getAbsolutePath()
							+ ". No hay permisos");
		}

		// actualizar la carpeta de trabajo
		carpetaDeTrabajo = file;

		// actualizar el contenido
		actualiza();

	}

	@Override
	public void setFormatoContenido(FormatoVistas arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMostrarOcultos(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOrdenado(TipoOrden arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSePuedeEjecutar(String arg0, boolean arg1)
			throws GestionFicherosException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSePuedeEscribir(String arg0, boolean arg1)
			throws GestionFicherosException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSePuedeLeer(String arg0, boolean arg1)
			throws GestionFicherosException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUltimaModificacion(String arg0, long arg1)
			throws GestionFicherosException {
		// TODO Auto-generated method stub

	}

}
