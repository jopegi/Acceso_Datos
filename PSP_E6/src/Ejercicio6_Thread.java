
/**
 *
 * @author jvperez
 */
public class Ejercicio6_Thread extends Thread{

     //Variables de clase
    private String nombre; //Contendrá el nombre del hilo
    private int retardo; //contendrá el retardo de tiempo que queramos
    String nombreHilo = null; //almacenará el nombre del hilo en curso

    //Constructor de la clase
    public Ejercicio6_Thread (String p, int s){
        this.nombre = p;
        this.retardo = s;
    }

    //Método run() que contiene el código que ejecutará cada hilo
    //que se instancie
    public void run(){

        //bloque try-catch encargado de capturar posibles excepciones
        try {
            this.sleep(retardo);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.out.println("Error: se ha producido una interrupción inesperada!");
        }

        //Iteración de 0 a 10, para crear los 10 ciclos que pide el enunciado.
        for (int i = 0; i < 10; i++) {

            //Se instancia una variable encargada de almacenar el nombre del hilo en curso
            nombreHilo = Thread.currentThread().getName();

            System.out.println("Bienvenido, soy " + nombre + " y estoy en la iteración " + i);
            //***También podría obtenerse el nombre del thread en curso de la siguiente manera:
            //System.out.println("Bienvenido, soy el "+nombreHilo+" y estoy en la iteración "+i);

        }

        System.out.println("Finaliza el "+nombre);
        //***También podría obtenerse el nombre del thread en curso de la siguiente manera:
        //System.out.println("Finaliza el hilo "+nombreHilo);
    }

    //Método main encargado de lanzar la app
    public static void main (String[] args){

        //Instanciamos 2 nuevos thread
        Ejercicio6_Thread hilo1 = new Ejercicio6_Thread("hilo1",4000);
        Ejercicio6_Thread hilo2 = new Ejercicio6_Thread("hilo2",2000);

        //Lanzamos los thread con el método start()
        	hilo1.start();
        	hilo2.start();
        
        	try {
        		//Lanzamos los thread con el método join() para que el mensaje de finalización
        		//del programa se muestre cuando los tres hilos hayan finalizado su método run().
        		//así, el programa principal detendrá su ejecución hasta que no hayan finalizado 
        		//los dos hilos definidos.
				hilo1.join();
				hilo2.join();
				
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
        	
        	System.out.println("main terminado!");
        	
    }

}
