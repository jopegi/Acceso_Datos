
/**
 *
 * @author jvperez
 */
//Definimos una clase que implementa la interfaz Runnable
public class AnimalesRunnable implements Runnable {

    private String nombre;

    //Constructor de la clase
    public AnimalesRunnable(String nombre) {

        this.nombre = nombre;

    }

    //Método run() que contiene al código que ejecutará cada hilo
    //creado tras invocar al método start()
    public void run() {
        //Definimos 5 iteraciones
        for (int i = 0; i < 5; i++) {

            //Mensaje a mostrar en cada iteración
            System.out.println("Soy el/la " + nombre+" Runnable");
        }
        //Mensaje a mostrar cuando termine la ejecución del hilo
        System.out.println("Soy el/la " + nombre + " Runnable, y he llegado a la meta");
    }

    //Método main que lanza la app
    public static void main(String[] args) {

        AnimalesRunnable liebre = new AnimalesRunnable("liebre");
        AnimalesRunnable tortuga = new AnimalesRunnable("tortuga");
        AnimalesRunnable guepardo = new AnimalesRunnable("guepardo");

        //Instanciamos 3 hilos de ejecución
        Thread hilo1 = new Thread(guepardo);
        Thread hilo2 = new Thread(liebre);
        Thread hilo3 = new Thread(tortuga);

        //Asignamos la prioridad a cada hilo creado
        //según las prioridades asignadas, el guepardo debería de llegar primero,
        //a continuación la liebre y, finalemente la tortuga
        hilo1.setPriority(Thread.MAX_PRIORITY);
        hilo2.setPriority(Thread.NORM_PRIORITY);
        hilo3.setPriority(Thread.MIN_PRIORITY);

        //lanzamos cada uno de los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();

    }
}
