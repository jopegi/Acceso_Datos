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
   
   
    // M�todo abstractro run() de la clase, el cual pertenece a la interfaz Runnable
    @Override
    public void run() {

        // Iteraci�n de 0 a 10, para crear los 10 ciclos que pide el enunciado.
        for (int i = 0; i < 10; i++) {

            // Se capturan posibles excepciones dentro de un bloque try-catch
            try {
                // Con el m�todo est�tico sleep(), se detiene la ejecuci�n del hilo durante
                //el tiempo especificado en el retardo.
               
                Thread.sleep(retardo);

                System.out.println("Bienvenido, soy el " + nombreHilo + " y estoy en la iteraci�n " + i);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
        
        //Mostramos el mensaje de finalizaci�n con nombre que le hemos dado al hilo como par�metro
        //Este mensaje se mostrar� una vez finalizada la ejecuci�n de un hilo
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
				//Tambi�n podemos nombrar al hilo con el nombre de su propio atributo Name
				//Estos mensajes se mostrar�an al final de la ejecuci�n de los dos hilos,
				//justo antes del mensaje de finalizaci�n del main
				System.out.println("Finaliza el "+h1.getName());
				System.out.println("Finaliza el "+h2.getName());
				*/
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
        	
 
       
        System.out.println("main terminado");
    }

}