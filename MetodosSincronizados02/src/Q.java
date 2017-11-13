
//Se crea la clase Q
public class Q {
  int n;
  //Se declara el método get(), de tipo getter, como sincronizado
  synchronized int get() {
    System.out.println("Obtengo: " + n);
    return n;
  }
  //Se declara el método put(), de tipo setter, también 
  //como sincronizado
  synchronized void put(int n) {
    this.n = n;
    System.out.println("Pongo: " + n);
  }
}
