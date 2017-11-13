//Se crea la clase PC que contiene el m�todo main() encargado
//de lanzar la app
public class PC {
  public static void main(String args[]) {
    //Se instancia un objeto de la clase Q para poder invocar
    //a los m�todos get() y put() sincronizados
    Q q = new Q();
    //Se instancia un objeto de la clase Producer
    new Producer(q);
    //Se instancia un objeto de la clase Consumer
    new Consumer(q);
    //Como se han generado bucles infinitos se avisa por consola
    //al usuario de que si desea parar la aplicaci�n debe de pulsar 
   //Control+C
    System.out.println("Pulsa Control-C para parar.");
  }
}
