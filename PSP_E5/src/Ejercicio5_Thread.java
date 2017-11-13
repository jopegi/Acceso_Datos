
/**
 *
 * @author jvperez
 */
public class Ejercicio5_Thread extends Thread{

    //Variables de clase
    private String palabra; //Contendr� la palabra que nos interese mostrar
    private int retardo; //contendr� el retardo de tiempo que queramos

    //Constructor de la clase
    public Ejercicio5_Thread (String p, int s){
        this.palabra = p;
        this.retardo = s;
    }

    //M�todo run() que contiene el c�digo que ejecutar� cada hilo
    //que se instancie
    public void run(){

        //bloque try-catch encargado de capturar posibles excepciones
        try {
            this.sleep(retardo);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.out.println("Error: se ha producido una interrupci�n inesperada!");
        }
        
        //Iteraci�n de 0 a 5, para definir los 5 ciclos que pide el enunciado.
        for(int i =0; i<5; i++){

        System.out.println("N�mero de ciclo: "+i+" >>>> "+palabra);
        
        }
    }

    //M�todo main encargado de lanzar la app
    public static void main (String[] args){

        //Instanciamos 2 nuevos thread
        Ejercicio5_Thread thread1 = new Ejercicio5_Thread("Hola",4000);
        Ejercicio5_Thread thread2 = new Ejercicio5_Thread("Adi�s",2000);
        

        //Lanzamos los thread
        thread1.start();
        thread2.start();
    }
}

