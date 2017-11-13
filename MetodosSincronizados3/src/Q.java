public class Q {
  int n;
  boolean valueSet = false;
  synchronized int get() {
    if(!valueSet)
      try {
        wait();
      } catch(InterruptedException e) {
        System.out.println("InterruptedException capturada");
      }
    System.out.println("Obtengo: " + n);
    valueSet = false;
    notify();
    return n;
  }
  synchronized void put(int n) {
    if(valueSet)
      try {
        wait();
      } catch(InterruptedException e) {
        System.out.println("InterruptedException capturada");
      }
    this.n = n;
    valueSet = true;
    System.out.println("Pongo: " + n);
    notify();
  }
}