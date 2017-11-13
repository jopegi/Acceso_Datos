class Consumer implements Runnable {
  Q q;
  Consumer(Q q) {
    this.q = q;
    new Thread(this, "Consumidor").start();
  }
  public void run() {
    while(true) {
      q.get();
    }
  }
}