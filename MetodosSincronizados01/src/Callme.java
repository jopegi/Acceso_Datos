
//Se crea una clase llamada Callme
public class Callme {
//Se crea un m�todo y se declara como sincronizado mediante la palabra clave 
 //synchronized. Al m�todo se le pasa un mensaje como par�metro.
//Al a�adir el modificador syncronized al m�todo call() conseguimos que dicho
//m�todo no pueda ser ejecutado al mismo tiempo por varios threads.
	synchronized void call (String msg) { 
		//Se imprime por consola el mensaje
		System.out.print("[" + msg);
		//Se crea un bloque try-catch para capturar posibles excepciones
		try {	
			//Se duerme el hilo en ejecuci�n durante 1 segundo	
			Thread.sleep(1000); 
		}
		catch (Exception e) {};

		//Se imprime por consola un corchete de cierre
		System.out.println("]");
    }
}
