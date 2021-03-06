
public class Ejercicio3 implements Runnable {

	private String nombreHilo;


	public Ejercicio3(String nombreHilo) {
		
		this.nombreHilo = nombreHilo;

	}

	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			
			System.out.println("Hola, soy el hilo: " + nombreHilo);
		}
		
		System.out.println("Hola, soy el hilo: " + nombreHilo+" y he terminado mi ejecución");

	}

	public static void main(String[] args) {

		Ejercicio3 Runnable1 = new Ejercicio3 ("rana");
		Ejercicio3 Runnable2 = new Ejercicio3 ("hombre");
		Ejercicio3 Runnable3 = new Ejercicio3 ("perro");
		Ejercicio3 Runnable4 = new Ejercicio3 ("conejo");
		Ejercicio3 Runnable5 = new Ejercicio3 ("caballo");
		
		Thread hilo1 = new Thread(Runnable1);
		Thread hilo2 = new Thread(Runnable2);
		Thread hilo3 = new Thread(Runnable3);
		Thread hilo4 = new Thread(Runnable4);
		Thread hilo5 = new Thread(Runnable5);
		
		hilo1.setPriority(1);
		hilo2.setPriority(3);
		hilo3.setPriority(5);
		hilo4.setPriority(7);
		hilo5.setPriority(10);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		
		


	}

}
