package animales_prioridad;

//Clase que extiende de Thread
public class Animal_Thread extends Thread {

	//Variable para definir el nombre del hilo
	private String nombre;
	
	//Constructor de la clase
	public Animal_Thread (String nombre) {

		this.nombre = nombre;

	}

	//M�todo run() que se ejecuta cuando se invoca el m�todo start() de un hilo
	public void run() {
		
		//Se definen 5 iteraciones para cada hilo
		for (int i = 0; i < 5; i++) {

			System.out.println(nombre);
		}
		
		System.out.println("Termina " + nombre);
	}

	//M�todo main que lanza la app
	public static void main(String[] args) {
		
		//Se instancian 3 hilos distintos
		Thread t = new Animal_Thread("tortuga");
		Thread l = new Animal_Thread("liebre");
		Thread g = new Animal_Thread("guepardo");
		
		/*
		 * Esto tambi�n ser�a v�lido
		//Se instancian 3 hilos distintos
		Animal_Thread t = new Animal_Thread("tortuga");
		Animal_Thread l = new Animal_Thread("liebre");
		Animal_Thread g = new Animal_Thread("guepardo");
		*/
		
		//Se asignan prioridades a cada uno de los hilos
		g.setPriority(Thread.MAX_PRIORITY); //M�xima prioridad para la guepardo == 10
		l.setPriority(Thread.NORM_PRIORITY); //Prioridad media para la liebre == 5
		t.setPriority(Thread.MIN_PRIORITY); //M�xima prioridad para la tortuga == 1
		
		//Se lanzan los hilos
		t.start();
		l.start();
		g.start();

	}

}
