//Clase que implementa la interfaz Runnable
public class Sincronizacion_Ejercicio4 implements Runnable{

	
    private String nombre;
    private String mensaje;

    //Constructor de la clase
    public Sincronizacion_Ejercicio4(String nombre, String mensaje) {

        this.nombre = nombre;
        this.mensaje = mensaje;

    }
    
	@Override
	public void run() {
		
		//Cuando se instancie un Thread mediante un objeto de tipo Sincronizacion_Ejercicio4
		//se llamar� al m�todo sincronizado escribeMensaje(string mensaje). Y de esta forma, se
		//evitar� que dicho m�todo pueda ser ejecutado por varios threads al mismo tiempo.
		Mensajes.escribeMensaje(mensaje);
	}
	
	
	public static void  main (String[] args) {
		
		//Si forzamos al nuestro pc a trabajar �nicamente con un n�cleo, el primer hilo que se ejecute 
		//instanciar� el m�todo sincronizado escribeMensaje() declarado en el run(), impidiendo as� que
		//el segundo hilo en ejecuci�n pueda acceder a el hasta que no haya terminado de ejecutarlo.
		Sincronizacion_Ejercicio4 h1 = new Sincronizacion_Ejercicio4("hilo1", "Amaneciendo");
		Sincronizacion_Ejercicio4 h2 = new Sincronizacion_Ejercicio4("hilo2", "Buenas noches, a descansar");
		
		Thread hilo1 = new Thread (h1);
		Thread hilo2 = new Thread (h2);
		
		//Por otra parte, si lo que nos interesa es definir que hilo debe de acceder primero al m�todo
		//sincronizado escribeMensaje() podemos definir prioridades en los hilos.
		
		hilo1.setPriority(Thread.MAX_PRIORITY); //As�, nos aseguramos de que el hilo1 se ejecute primero y, por tanto se muestre antes el mensaje "Amaneciendo"
		hilo2.setPriority(Thread.MIN_PRIORITY); 
		
		hilo1.start();
		hilo2.start();
		
		try {
			//Con el join() nos aseguramos de que hasta que no finalicen los hilos lanzados
			//no continue el hilo de ejecuci�n
			hilo1.join();
			hilo2.join();
			
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
		
		System.out.println("Otra semana de clases acabadas!");
		
	}
	
	

}
