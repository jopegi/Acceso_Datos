//Se crea la clase caller que implementa la interfaz Runnable
public class Caller implements Runnable {
	//Se declaran dos variables de clase
	String msg; //Una de tipo string
	Callme target; //Otra de tipo Callme
    
	//Se crea un método caller que recibe dos parámetros, un objeto de 	//tipo caller y un mensaje de texto	
    public Caller(Callme t, String s) {
    	target = t;
    	msg = s;
		//Se instancia un hilo a partir de la propia clase Runnable
		//y se inicializa con el método start()
    	new Thread(this).start();
    }
    
	//Se sobreescribe el método abstracto run() perteneciente a la 	//interfaz Runnable	
    public void run() {
		//Se instancia un bloque sincronizado. De esta forma se señala 
		//una parte de código que está sincronizado con un objeto target
		//de tipo Callme
    	synchronized(target) {
			//Se llama al método sincronizado call() de la clase 				//Callme
    		target.call(msg);
    	}
    }
}
