//Creamos una clase que extiende de la interfaz Thread
public class Animales_Thread extends Thread{

	//Variables de clase
	private String nombre;

	//Constructor de la clase
	public Animales_Thread(String nombre) {

		this.nombre = nombre;

	}

	//Método run() sobreescrito, propio de la clase Thread
	public void run() {

		//Iteramos cada hilo 5 veces
		for (int i = 0; i < 5; i++) {
			System.out.println(nombre);
		}

		//Cuando terminen las iteraciones se lanzará el siguiente mensaje
		System.out.println("Soy el/la " + nombre + " y he llegado a la meta");
	}

	//La aplicación comienza a ejecutarse a partir del método main()
	public static void main(String[] args) {

		//Creamos objetos de tipo Thread
		Thread tortuga = new Animales_Thread("Tortuga");
		Thread liebre = new Animales_Thread("Liebre");
		Thread guepardo = new Animales_Thread("Guepardo");

		//Definimos la prioridad de cada hilo
		//Nota: hemos de tener en cuenta en habilitar tan solo un núcleo en nuestro pc
		tortuga.setPriority(Thread.MIN_PRIORITY);
		liebre.setPriority(Thread.NORM_PRIORITY);
		guepardo.setPriority(Thread.MAX_PRIORITY);

		//Arrancamos los hilos mediante la llamada al método start() de la clase Thread
		tortuga.start();
		liebre.start();
		guepardo.start();

	}

}
