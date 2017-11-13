
/**
 *
 * @author jvperez
 */
public class Ejercicio5_Thread extends Thread{

    //Variables de clase
    private String palabra; //Contendrá la palabra que nos interese mostrar
    private int retardo; //contendrá el retardo de tiempo que queramos

    //Constructor de la clase
    public Ejercicio5_Thread (String p, int s){
        this.palabra = p;
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
        
        //Iteración de 0 a 5, para definir los 5 ciclos que pide el enunciado.
        for(int i =0; i<5; i++){

        System.out.println("Número de ciclo: "+i+" >>>> "+palabra);
        
        }
    }

    //Método main encargado de lanzar la app
    public static void main (String[] args){

        //Instanciamos 2 nuevos thread
        Ejercicio5_Thread thread1 = new Ejercicio5_Thread("Hola",4000);
        Ejercicio5_Thread thread2 = new Ejercicio5_Thread("Adiós",2000);
        

        //Lanzamos los thread
        thread1.start();
        thread2.start();
    }
}

