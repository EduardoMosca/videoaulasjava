public class Main implements Runnable {

  String palavra;
  long tempo;

  public Main(String palavra, long tempo) {
    this.palavra = palavra;
    this.tempo = tempo;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < 100; i++) {
        System.out.println(palavra);
        Thread.sleep(tempo);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
      return;
    }

  }

  public static void main(String[] args) {
    Runnable ping = new Main("ping", 1500);
    Runnable pong = new Main("pong", 1500);

    new Thread(ping, "ping").start();
    new Thread(pong, "pong").start();

    System.out.println("Ver Thread");
  }

}