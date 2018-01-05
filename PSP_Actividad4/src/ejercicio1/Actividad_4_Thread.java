package ejercicio1;

import ejercicio2.ClaseCalculo;

public class Actividad_4_Thread extends Thread{

	//////////////////Atributos de la clase/////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	private String name;  			//Definirá el nombre del hilo
	private String message;			//Definirá un mensaje a mostrar por consola
	private int delay = 0;			//Definirá un retardo
	
	private int numero_aleatorio;	//Variable para almacenar los números aleatorios almacenados
	
	private int iteraciones = 3;		//Controlador del número de iteraciones en el método run()
	
	///////////////////Fin atributos de la clase////////////////////////////
	////////////////////////////////////////////////////////////////////////
	/**********************************************************************/
	////////////////////////////////////////////////////////////////////////
	/////////////////Constructores de la clase//////////////////////////////
	
	public Actividad_4_Thread(String name, String message, int delay) {
		
		this.name = name;
		this.message = message;
		this.delay = delay;
		
	}
	
	public Actividad_4_Thread(String name, String message) {
		
		this.name = name;
		this.message = message;
		
	}
	
	////////////////////////////////////////////////////////////////////////
	/////////////////Fin constructores de la clase//////////////////////////
	/**********************************************************************/
	////////////////////////////////////////////////////////////////////////
	/////////////////Método run() de entrada al Thread//////////////////////
	
	public void run() {
	
		int n = 10;		//Controlador del rango de números aleatorios a generar. En este caso, se generarán números entre 1 y 10.
		
		try {
			
			sleep(delay);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		//Al inicio de un hilo se mostrará el siguiente mensaje
		System.out.println("Inicio hilo: " + name + "\n");
		
		//Iteramos cada hilo n veces
		for (int i = 0; i < iteraciones; i++) {
			
			System.out.println(message + "\n");
			//Generamos un número aleatorio entre 1 y n
			numero_aleatorio = (int) (Math.random() * n + 1);
			//Mostramos el número aleatorio generado
			System.out.println("numero aleatorio "+name+ "= "+numero_aleatorio + "\n");
			//Aplicamos el método sincronizado nuevoValor(double valor) al número aleatorio obtenido
			//Cuando se instancie un Thread mediante un objeto de tipo Actividad_4_Thread
			//se llamará al método sincronizado nuevoValor(double valor). Y de esta forma, se
			//evitará que dicho método pueda ser ejecutado por varios threads al mismo tiempo.
			ClaseCalculo.nuevoValor(numero_aleatorio);
			
		}

		//Cuando terminen las iteraciones se lanzará el siguiente mensaje
		System.out.println("Final hilo:  " + name + "\n");
	}
	/////////////////Fin método run() de entrada al Thread///////////////////
	////////////////////////////////////////////////////////////////////////
	/**********************************************************************/
	////////////////////////////////////////////////////////////////////////
	/////////////////Método main() de entrada a la app//////////////////////
	public static void main(String[] args) {
		
		//Si forzamos al nuestro pc a trabajar únicamente con un núcleo, el primer hilo que se ejecute 
		//instanciará el método sincronizado nuevoValor(double valor) declarado en el run(), impidiendo así que
		//el segundo hilo en ejecución pueda acceder a el hasta que no haya terminado de ejecutarlo.
		Thread hilo1 = new Actividad_4_Thread("hilo1","hilo 1 aquí...");
		Thread hilo2 = new Actividad_4_Thread("hilo2","hilo 2 aquí...");
		
		for (int j=0;j<3;j++) {
			System.out.println("main aquí..." + "\n");
		}
		
		
		hilo1.start();
		hilo2.start();
		
		/*try {
			
			hilo1.join();
			hilo2.join();
			
		} catch (InterruptedException e) {

			e.printStackTrace();
		}*/

	}
	/////////////////Fin método main() de entrada a la app///////////////////
	////////////////////////////////////////////////////////////////////////
}
