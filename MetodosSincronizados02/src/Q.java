
//Se crea la clase Q
public class Q {
  int n;
  //Se declara el m�todo get(), de tipo getter, como sincronizado
  synchronized int get() {
    System.out.println("Obtengo: " + n);
    return n;
  }
  //Se declara el m�todo put(), de tipo setter, tambi�n 
  //como sincronizado
  synchronized void put(int n) {
    this.n = n;
    System.out.println("Pongo: " + n);
  }
}
