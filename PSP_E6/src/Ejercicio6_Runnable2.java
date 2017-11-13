/**
 *
 * @author jvperez
 */

public class Ejercicio6_Runnable2 implements Runnable{
   
    //Variables de la clase
    private String nombreHilo;
    private int retardo;
   
    // Constructor de la clase
    public Ejercicio6_Runnable2(String n, int r) {

        this.nombreHilo = n;
        this.retardo = r;

    }
   
   
    // Método abstractro run() de la clase, el cual pertenece a la interfaz Runnable
    @Override
    public void run() {

        // Iteración de 0 a 10, para crear los 10 ciclos que pide el enunciado.
        for (int i = 0; i < 10; i++) {

            // Se capturan posibles excepciones dentro de un bloque try-catch
            try {
                // Con el método estático sleep(), se detiene la ejecución del hilo durante
                //el tiempo especificado en el retardo.
               
                Thread.sleep(retardo);

                System.out.println("Bienvenido, soy el " + nombreHilo + " y estoy en la iteración " + i);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
        
        //Mostramos el mensaje de finalización con nombre que le hemos dado al hilo como parámetro
        //Este mensaje se mostrará una vez finalizada la ejecución de un hilo
        System.out.println("Finaliza el "+nombreHilo);
        
    }
   
    public static void main (String[] args) {
       
     
        	
        	Ejercicio6_Runnable2 hilo1 = new Ejercicio6_Runnable2("hilo1", 1000);
        	Ejercicio6_Runnable2 hilo2 = new Ejercicio6_Runnable2("hilo2", 2000);
        	
        	Thread h1 = new Thread (hilo1);
        	Thread h2 = new Thread (hilo2);
        	
        	h1.start();
        	h2.start();
        	
        	try {
        		
				h1.join();
				h2.join();
				
				/*
				//También podemos nombrar al hilo con el nombre de su propio atributo Name
				//Estos mensajes se mostrarían al final de la ejecución de los dos hilos,
				//justo antes del mensaje de finalización del main
				System.out.println("Finaliza el "+h1.getName());
				System.out.println("Finaliza el "+h2.getName());
				*/
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
        	
 
       
        System.out.println("main terminado");
    }

}