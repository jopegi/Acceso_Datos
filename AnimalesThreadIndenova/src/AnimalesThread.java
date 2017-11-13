

/**
 *
 * @author jvperez
 */

//Definimos una clase que extiende de Thread
public class AnimalesThread extends Thread {

    private String nombre;

    //Constructor de la clase
    public AnimalesThread(String nombre) {
        
        this.nombre = nombre;

    }

    //Método run() que contiene al código que ejecutará cada hilo
    //creado tras invocar al método start()
    @Override
    public void run() {

        //Definimos 5 iteraciones
        for (int i = 0; i < 5; i++) {
            //Mensaje a mostrar en cada iteración
            System.out.println("Soy el/la " + nombre);
        }
        //Mensaje a mostrar cuando termine la ejecución del hilo
        System.out.println("Soy el/la " + nombre + " y he llegado a la meta");
    }

    //Método main que lanza la app
    public static void main(String[] args) {


        //Instanciamos 3 hilos de ejecución
        Thread guepardo = new AnimalesThread("Guepardo");
        Thread liebre = new AnimalesThread("Liebre");
        Thread tortuga = new AnimalesThread("Tortuga");
        

        //Asignamos la prioridad a cada hilo creado
        //según las prioridades asignadas, el guepardo debería de llegar primero,
        //a continuación la liebre y, finalemente la tortuga
        tortuga.setPriority(Thread.MIN_PRIORITY);
        liebre.setPriority(Thread.NORM_PRIORITY);
        guepardo.setPriority(Thread.MAX_PRIORITY);
        
        //lanzamos cada uno de los hilos
        guepardo.start();
        liebre.start();
        tortuga.start();

    }
}

