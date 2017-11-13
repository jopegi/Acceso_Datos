
public class Principal {

	public static void main(String[] args) {
		
		Libro libro1 = new Libro(1, "El Se�or de los Anillos", "Paco", 1945, "Anaya", 800);
		Libro libro2 = new Libro(2, "El Hobbit", "Paco", 1955, "Anaya", 450);
		
		libro1.printInfo();
		libro2.printInfo();
		
		Almacen almacen = new Almacen();
		
		//Guardamos un objeto serializable de tipo libro en un fichero de datos
		almacen.guardarObjeto(libro1,"almacen.dat");
		
		//Recuperamos el �ltimo objeto guardado en el fichero de datos
		almacen.recuperarLibro("almacen.dat");


	}

}
