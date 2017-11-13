
//Se crea la clase Consumer. Esta clase implementa la interfaz Runnable
public class Consumer implements Runnable {
  Q q;
  //Constructor de la clase
  Consumer(Q q) {
    this.q = q;
    //Cuando se cree un instancia de esta clase se crear� y lanzar�, a su vez,
   //un hilo de ejecuci�n
    new Thread(this, "Consumidor").start();
  }

  //M�todo run() que se ejecutar� cuando se cree un hilo
  public void run() {
 //Bucle infinito
     while(true) {
     q.get();
    }
  }
}