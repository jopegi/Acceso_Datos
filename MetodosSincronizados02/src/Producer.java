
//Se crea la clase Producer. Esta clase implementa la interfaz Runnable
public class Producer implements Runnable {
  Q q;
  //Constructor de la clase
  Producer(Q q) {
    this.q = q;
    //Cuando se cree un instancia de esta clase se crear� y lanzar�, a su vez,
    //un hilo de ejecuci�n
    new Thread(this, "Productor").start();
  }

  //M�todo run() que se ejecutar� cuando se cree un hilo
  public void run() {
    int i = 0;
    //Bucle infinito
    while(true) {
      q.put(i=i+1);
    }
  }
}