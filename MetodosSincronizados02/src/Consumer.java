
//Se crea la clase Consumer. Esta clase implementa la interfaz Runnable
public class Consumer implements Runnable {
  Q q;
  //Constructor de la clase
  Consumer(Q q) {
    this.q = q;
    //Cuando se cree un instancia de esta clase se creará y lanzará, a su vez,
   //un hilo de ejecución
    new Thread(this, "Consumidor").start();
  }

  //Método run() que se ejecutará cuando se cree un hilo
  public void run() {
 //Bucle infinito
     while(true) {
     q.get();
    }
  }
}