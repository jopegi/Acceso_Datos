package ejercicio1;

import ejercicio2.ClaseCalculo;

public class Actividad_4_Thread extends Thread{

	//////////////////Atributos de la clase/////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	private String name;  			//Definir� el nombre del hilo
	private String message;			//Definir� un mensaje a mostrar por consola
	private int delay = 0;			//Definir� un retardo
	
	private int numero_aleatorio;	//Variable para almacenar los n�meros aleatorios almacenados
	
	private int iteraciones = 3;		//Controlador del n�mero de iteraciones en el m�todo run()
	
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
	/////////////////M�todo run() de entrada al Thread//////////////////////
	
	public void run() {
	
		int n = 10;		//Controlador del rango de n�meros aleatorios a generar. En este caso, se generar�n n�meros entre 1 y 10.
		
		try {
			
			sleep(delay);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		//Al inicio de un hilo se mostrar� el siguiente mensaje
		System.out.println("Inicio hilo: " + name + "\n");
		
		//Iteramos cada hilo n veces
		for (int i = 0; i < iteraciones; i++) {
			
			System.out.println(message + "\n");
			//Generamos un n�mero aleatorio entre 1 y n
			numero_aleatorio = (int) (Math.random() * n + 1);
			//Mostramos el n�mero aleatorio generado
			System.out.println("numero aleatorio "+name+ "= "+numero_aleatorio + "\n");
			//Aplicamos el m�todo sincronizado nuevoValor(double valor) al n�mero aleatorio obtenido
			//Cuando se instancie un Thread mediante un objeto de tipo Actividad_4_Thread
			//se llamar� al m�todo sincronizado nuevoValor(double valor). Y de esta forma, se
			//evitar� que dicho m�todo pueda ser ejecutado por varios threads al mismo tiempo.
			ClaseCalculo.nuevoValor(numero_aleatorio);
			
		}

		//Cuando terminen las iteraciones se lanzar� el siguiente mensaje
		System.out.println("Final hilo:  " + name + "\n");
	}
	/////////////////Fin m�todo run() de entrada al Thread///////////////////
	////////////////////////////////////////////////////////////////////////
	/**********************************************************************/
	////////////////////////////////////////////////////////////////////////
	/////////////////M�todo main() de entrada a la app//////////////////////
	public static void main(String[] args) {
		
		//Si forzamos al nuestro pc a trabajar �nicamente con un n�cleo, el primer hilo que se ejecute 
		//instanciar� el m�todo sincronizado nuevoValor(double valor) declarado en el run(), impidiendo as� que
		//el segundo hilo en ejecuci�n pueda acceder a el hasta que no haya terminado de ejecutarlo.
		Thread hilo1 = new Actividad_4_Thread("hilo1","hilo 1 aqu�...");
		Thread hilo2 = new Actividad_4_Thread("hilo2","hilo 2 aqu�...");
		
		for (int j=0;j<3;j++) {
			System.out.println("main aqu�..." + "\n");
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
	/////////////////Fin m�todo main() de entrada a la app///////////////////
	////////////////////////////////////////////////////////////////////////
}
