
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
        //Este objeto se encargará de crear un hilo de ejecución
        t = new Thread(this, name);
        System.out.println("Finaliza el "+name);
        //Lanzamos el hilo con el método start()
        	t.start();
       //Lanzamos el hilo con el método join()
        //Lanzamos los thread con el método join() para que el mensaje de finalización
        //del programa se muestre cuando el hilo creado haya finalizado su método run().
		//Así, el programa principal detendrá su ejecución hasta que no haya finalizado 
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

        	//Iteración de 0 a 10, para crear los 10 ciclos que pide el enunciado.
            for (int i = 5; i > 0; i--) {
                System.out.println("Bienvenido, soy el "+name+" y estoy en la iteración "+i);
                Thread.sleep(retardo);
            }

        } catch (InterruptedException e) {

            e.printStackTrace();
            System.err.println("Se ha interrumpido la ejecución del hilo: " + name);
        }
        
        System.out.println("Finaliza el hilo "+name);
        
    }

    //Método main encargado de lanzar la app
    public static void main (String[] args){

        //Se instancian dos objetos de tipo Runnable
        //Cada objeto ejecutará su método run() que se encargará
        //de crear un thread distinto.
        Ejercicio6_Runnable t1 = new Ejercicio6_Runnable ("hilo1", 1000);
        Ejercicio6_Runnable t2 = new Ejercicio6_Runnable ("hilo2", 1000);
        
        System.out.println("main terminado");

    }

}
