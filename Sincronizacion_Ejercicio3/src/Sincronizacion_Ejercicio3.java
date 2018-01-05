/**
 *
 * @author jvperez
 */
//Definimos una clase que implementa la interfaz Runnable
public class Sincronizacion_Ejercicio3 implements Runnable {

    private String nombre;

    //Constructor de la clase
    public Sincronizacion_Ejercicio3(String nombre) {

        this.nombre = nombre;

    }

    //M�todo run() que contiene al c�digo que ejecutar� cada hilo
    //creado tras invocar al m�todo start()
    public void run() {
        //Definimos 3 iteraciones
        for (int i = 0; i < 3; i++) {

            //Mensaje a mostrar en cada iteraci�n
            System.out.println("Soy el " + nombre+" Runnable");
        }
        //Mensaje a mostrar cuando termine la ejecuci�n del hilo
        System.out.println("Soy el " + nombre + " Runnable, y he finalizado");
    }

    //M�todo main que lanza la app
    public static void main(String[] args) {

    	Sincronizacion_Ejercicio3 h1 = new Sincronizacion_Ejercicio3("hilo1");
    	Sincronizacion_Ejercicio3 h2 = new Sincronizacion_Ejercicio3("hilo2");
    	Sincronizacion_Ejercicio3 h3 = new Sincronizacion_Ejercicio3("hilo3");
    	Sincronizacion_Ejercicio3 h4 = new Sincronizacion_Ejercicio3("hilo4");
    	Sincronizacion_Ejercicio3 h5 = new Sincronizacion_Ejercicio3("hilo5");

        //Instanciamos 3 hilos de ejecuci�n
        Thread hilo1 = new Thread(h1);
        Thread hilo2 = new Thread(h2);
        Thread hilo3 = new Thread(h3);
        Thread hilo4 = new Thread(h4);
        Thread hilo5 = new Thread(h5);

        //Asignamos la prioridad a cada hilo creado
        hilo1.setPriority(1);
        hilo2.setPriority(3);
        hilo3.setPriority(4);
        hilo4.setPriority(6);
        hilo5.setPriority(10);

        //lanzamos cada uno de los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();

    }
}
