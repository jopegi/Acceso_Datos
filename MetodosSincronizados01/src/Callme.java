
//Se crea una clase llamada Callme
public class Callme {
//Se crea un método y se declara como sincronizado mediante la palabra clave 
 //synchronized. Al método se le pasa un mensaje como parámetro.
//Al añadir el modificador syncronized al método call() conseguimos que dicho
//método no pueda ser ejecutado al mismo tiempo por varios threads.
	synchronized void call (String msg) { 
		//Se imprime por consola el mensaje
		System.out.print("[" + msg);
		//Se crea un bloque try-catch para capturar posibles excepciones
		try {	
			//Se duerme el hilo en ejecución durante 1 segundo	
			Thread.sleep(1000); 
		}
		catch (Exception e) {};

		//Se imprime por consola un corchete de cierre
		System.out.println("]");
    }
}
