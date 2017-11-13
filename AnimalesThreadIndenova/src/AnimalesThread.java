

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

    //M�todo run() que contiene al c�digo que ejecutar� cada hilo
    //creado tras invocar al m�todo start()
    @Override
    public void run() {

        //Definimos 5 iteraciones
        for (int i = 0; i < 5; i++) {
            //Mensaje a mostrar en cada iteraci�n
            System.out.println("Soy el/la " + nombre);
        }
        //Mensaje a mostrar cuando termine la ejecuci�n del hilo
        System.out.println("Soy el/la " + nombre + " y he llegado a la meta");
    }

    //M�todo main que lanza la app
    public static void main(String[] args) {


        //Instanciamos 3 hilos de ejecuci�n
        Thread guepardo = new AnimalesThread("Guepardo");
        Thread liebre = new AnimalesThread("Liebre");
        Thread tortuga = new AnimalesThread("Tortuga");
        

        //Asignamos la prioridad a cada hilo creado
        //seg�n las prioridades asignadas, el guepardo deber�a de llegar primero,
        //a continuaci�n la liebre y, finalemente la tortuga
        tortuga.setPriority(Thread.MIN_PRIORITY);
        liebre.setPriority(Thread.NORM_PRIORITY);
        guepardo.setPriority(Thread.MAX_PRIORITY);
        
        //lanzamos cada uno de los hilos
        guepardo.start();
        liebre.start();
        tortuga.start();

    }
}

