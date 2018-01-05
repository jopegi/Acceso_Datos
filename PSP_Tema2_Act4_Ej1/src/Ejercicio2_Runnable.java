
public class Ejercicio2_Runnable implements Runnable{
	
	private String name;
	private String message;
	private int iteraciones = 5;

	public Ejercicio2_Runnable(String name, String message) {
		
		this.name = name;
		this.message = message;
	}

	@Override
	public void run() {

		// Al inicio de un hilo se mostrará el siguiente mensaje
		System.out.println("Inicio hilo: " + name);

		// Iteramos cada hilo 5 veces
		for (int i = 0; i < iteraciones; i++) {
			System.out.println(message);
		}

		// Cuando terminen las iteraciones se lanzará el siguiente mensaje
		System.out.println("Final hilo:  " + name);

	}
	
	//Métodos setter y getter
	public int getIteraciones() {
		return iteraciones;
	}

	public void setIteraciones(int iteraciones) {
		this.iteraciones = iteraciones;
	}

	//Método Main de entrada a la app
	public static void main(String[] args) {

		Ejercicio2_Runnable hilo1 = new Ejercicio2_Runnable("hilo1", "hilo 1 aquí...");
		Ejercicio2_Runnable hilo2 = new Ejercicio2_Runnable("hilo2", "hilo 2 aquí...");
		
		Thread h1 = new Thread (hilo1);
		Thread h2 = new Thread (hilo2);
		
		h1.start();
		h2.start();
		
		//Si queremos asegurarnos de que el println() del main se muestre después de ejecutarse los hilos
				//deberemos descomentar el siguiente bloque de código:
				
				/*try {
					
					//Con el join() nos aseguramos de que hasta que no finalicen los hilos lanzados
					//no continue el hilo de ejecución
					h1.join();
					h2.join();
					
				} catch (InterruptedException e) {

					e.printStackTrace();
				}*/
		
		for (int j=0;j<3;j++) {
			
			System.out.println("main aquí...");
		}
	}


}
