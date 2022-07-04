public class PonteSincronizada implements Ponte {
  private int valor = -1;
  private boolean ocupada = false;

  @Override
  public synchronized void set(int valor) throws InterruptedException {
    while (ocupada) {
      System.out.println("Ponte cheia. Produtor aguardar");
      wait();
    }
    System.out.print("Produziu " + valor);
    this.valor = valor;

    ocupada = true;
    notifyAll();
  }

  @Override
  public synchronized int get() throws InterruptedException {
    while (!ocupada) {
      System.out.println("Ponte vazia. Consumidor aguardar");
      wait();
    }
    System.err.print("Consumiu " + valor);
    ocupada = false;
    notifyAll();
    return this.valor;
  }

}
