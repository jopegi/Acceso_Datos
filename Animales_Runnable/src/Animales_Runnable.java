
//Creamos una clase que implementa la interfaz Runnable
public class Animales_Runnable implements Runnable {
	
	//Variables de clase
	private String nombre;
	
	//Constructor de la clase
	public Animales_Runnable (String nombre) {
		
		this.nombre=nombre;
	}

	//M�todo abstracto run() propio de la interfaz Runnable
	@Override
	public void run() {
		//Iteramos cada hilo 5 veces
		for (int i=0; i<5; i++) {
			System.out.println(nombre);
		}
		//Cuando terminen las iteraciones se lanzar� el siguiente mensaje
		System.out.println("Soy el/la "+nombre+" y he llegado a la meta");
	}
	

	//La aplicaci�n comienza a ejecutarse a partir del m�todo main()
	public static void main(String[] args) {

		//Creamos objetos de tipo Runnable
		Animales_Runnable guepardo = new Animales_Runnable("guepardo");
		Animales_Runnable liebre = new Animales_Runnable("liebre");
		Animales_Runnable tortuga = new Animales_Runnable("tortuga");
		
		//Creamos los hilos mediante la clase Thread, a partir de los objetos Runnable anteriores
		Thread hilo1 = new Thread(tortuga);
		Thread hilo2 = new Thread(liebre);
		Thread hilo3 = new Thread(guepardo); 
		
		//Definimos la prioridad de cada hilo
		//Nota: hemos de tener en cuenta en habilitar tan solo un n�cleo en nuestro pc
		hilo1.setPriority(Thread.MIN_PRIORITY);//PRIORIDAD M�NIMA = 1
		hilo2.setPriority(Thread.NORM_PRIORITY);//PRIORIDAD NORMAL = 5
		hilo3.setPriority(Thread.MAX_PRIORITY);//PRIORIDAD M�XIMA = 10
		
		//Arrancamos los hilos mediante la llamada al m�todo start() de la clase Thread
		hilo1.start();
		hilo2.start();
		hilo3.start();

	}

}


