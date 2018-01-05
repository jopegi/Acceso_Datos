package ejercicio1;

import ejercicio2.ClaseCalculo;

public class Actividad_4_Runnable implements Runnable {

	private String name;
	private String message;
	private int valorSuma;
	private int iteraciones = 3;

	public Actividad_4_Runnable(String name, String message) {
		
		this.name = name;
		this.message = message;
	}

	public Actividad_4_Runnable(String name, String message, int valorSuma) {
		
		this.name = name;
		this.message = message;
		this.valorSuma = valorSuma;
	}
	
	@Override
	public void run() {

		// Al iniciarse se lanzará el siguiente mensaje
		System.out.println("Inicio hilo: " + name + "\n");
		
		//Cuando se instancie un Thread mediante un objeto de tipo Actividad_4_Runnable
		//se llamará al método sincronizado nuevoValor(double valor). Y de esta forma, se
		//evitará que dicho método pueda ser ejecutado por varios threads al mismo tiempo.
		ClaseCalculo.nuevoValor(valorSuma);
		
		// Iteramos cada hilo 5 veces
		for (int i = 0; i < iteraciones; i++) {
			System.out.println(message + "\n");
		}

		// Cuando terminen las iteraciones se lanzará el siguiente mensaje
		System.out.println("Final hilo:  " + name + "\n");

	}
	
	public static void main(String[] args) {
		
		//Si forzamos al nuestro pc a trabajar únicamente con un núcleo, el primer hilo que se ejecute 
		//instanciará el método sincronizado nuevoValor(double valor) declarado en el run(), impidiendo así que
		//el segundo hilo en ejecución pueda acceder a el hasta que no haya terminado de ejecutarlo.
		Actividad_4_Runnable hilo1 = new Actividad_4_Runnable("hilo1", "hilo 1 aquí...", 2);
		Actividad_4_Runnable hilo2 = new Actividad_4_Runnable("hilo2", "hilo 2 aquí...", 4);
		Actividad_4_Runnable hilo3 = new Actividad_4_Runnable("hilo2", "hilo 2 aquí...", 3);
		
		Thread h1 = new Thread (hilo1);
		Thread h2 = new Thread (hilo2);
		Thread h3 = new Thread (hilo3);
		
		h1.start();
		h2.start();
		h3.start();

	}

}
