
/**
 *
 * @author jvperez
 */
public class Ejercicio5_Runnable implements Runnable{

    private String palabra;
    private String nombre;
    private int retardo;
    private Thread t;

    //Constructor de la clase
    public Ejercicio5_Runnable (String nombreHilo, int retardoHilo, String mensaje){

        this.nombre = nombreHilo;
        this.retardo = retardoHilo;
        this.palabra = mensaje;
        //Instanciamos un objeto Thread a partir de un objeto de tipo Ejercicio5_Runnable
        //Este objeto se encargará de crear un hilo de ejecución
        t = new Thread(this, nombre);
        //Lanzamos el hilo
        t.start();
    }

    public void run() {

        try {
        	//Iteración de 0 a 5, para definir los 5 ciclos que pide el enunciado.
            for (int i = 0; i < 5; i++) {
                System.out.println("Número de ciclo: " + i + " >>>> " + palabra);
                Thread.sleep(retardo);
            }

        } catch (InterruptedException e) {

            e.printStackTrace();
            System.err.println("Se ha interrumpido la ejecución del hilo: " + nombre);
        }
    }

    //Método main encargado de lanzar la app
    public static void main (String[] args){

        //Se instancian dos objetos de tipo Runnable
        //Cada objeto ejecutará su método run() que se encargará
        //de crear un thread distinto
        Ejercicio5_Runnable t1 = new Ejercicio5_Runnable ("hilo1", 1000, "Hola!");
        Ejercicio5_Runnable t2 = new Ejercicio5_Runnable ("hilo2", 2000, "Adiós!");

    }

}
