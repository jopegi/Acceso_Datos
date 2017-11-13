
class PCFixed {
  public static void main(String args[]) {
    Q q = new Q();
    Producer producer = new Producer(q);
    new Consumer(q);
    System.out.println("Pulsa Control-C para parar.");
  }
}