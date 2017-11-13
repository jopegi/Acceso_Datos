
/**
 *
 * @author jvperez
 */
public class Ejercicio6_Runnable implements Runnable{

    private String name;
    private int retardo;
    private Thread t;

    //Constructor de la clase
    public Ejercicio6_Runnable (String nombreHilo, int retardoHilo){

        this.name = nombreHilo;
        this.retardo = retardoHilo;
        //Instanciamos un objeto Thread a partir de un objeto de tipo Ejercicio6_Runnable
        //Este objeto se encargar� de crear un hilo de ejecuci�n
        t = new Thread(this, name);
        System.out.println("Finaliza el "+name);
        //Lanzamos el hilo con el m�todo start()
        	t.start();
       //Lanzamos el hilo con el m�todo join()
        //Lanzamos los thread con el m�todo join() para que el mensaje de finalizaci�n
        //del programa se muestre cuando el hilo creado haya finalizado su m�todo run().
		//As�, el programa principal detendr� su ejecuci�n hasta que no haya finalizado 
		//el hilo.
        
    		try {
    			//System.out.println("Entra al join");
    			
				t.join();
				t.run();
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
    }

    public void run() {
    	
    	//System.out.println("Entra al run");

        try {

        	//Iteraci�n de 0 a 10, para crear los 10 ciclos que pide el enunciado.
            for (int i = 5; i > 0; i--) {
                System.out.println("Bienvenido, soy el "+name+" y estoy en la iteraci�n "+i);
                Thread.sleep(retardo);
            }

        } catch (InterruptedException e) {

            e.printStackTrace();
            System.err.println("Se ha interrumpido la ejecuci�n del hilo: " + name);
        }
        
        System.out.println("Finaliza el hilo "+name);
        
    }

    //M�todo main encargado de lanzar la app
    public static void main (String[] args){

        //Se instancian dos objetos de tipo Runnable
        //Cada objeto ejecutar� su m�todo run() que se encargar�
        //de crear un thread distinto.
        Ejercicio6_Runnable t1 = new Ejercicio6_Runnable ("hilo1", 1000);
        Ejercicio6_Runnable t2 = new Ejercicio6_Runnable ("hilo2", 1000);
        
        System.out.println("main terminado");

    }

}
