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
		//se llamará al método sincronizado escribeMensaje(string mensaje). Y de esta forma, se
		//evitará que dicho método pueda ser ejecutado por varios threads al mismo tiempo.
		Mensajes.escribeMensaje(mensaje);
	}
	
	
	public static void  main (String[] args) {
		
		//Si forzamos al nuestro pc a trabajar únicamente con un núcleo, el primer hilo que se ejecute 
		//instanciará el método sincronizado escribeMensaje() declarado en el run(), impidiendo así que
		//el segundo hilo en ejecución pueda acceder a el hasta que no haya terminado de ejecutarlo.
		Sincronizacion_Ejercicio4 h1 = new Sincronizacion_Ejercicio4("hilo1", "Amaneciendo");
		Sincronizacion_Ejercicio4 h2 = new Sincronizacion_Ejercicio4("hilo2", "Buenas noches, a descansar");
		
		Thread hilo1 = new Thread (h1);
		Thread hilo2 = new Thread (h2);
		
		//Por otra parte, si lo que nos interesa es definir que hilo debe de acceder primero al método
		//sincronizado escribeMensaje() podemos definir prioridades en los hilos.
		
		hilo1.setPriority(Thread.MAX_PRIORITY); //Así, nos aseguramos de que el hilo1 se ejecute primero y, por tanto se muestre antes el mensaje "Amaneciendo"
		hilo2.setPriority(Thread.MIN_PRIORITY); 
		
		hilo1.start();
		hilo2.start();
		
		try {
			//Con el join() nos aseguramos de que hasta que no finalicen los hilos lanzados
			//no continue el hilo de ejecución
			hilo1.join();
			hilo2.join();
			
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
		
		System.out.println("Otra semana de clases acabadas!");
		
	}
	
	

}
