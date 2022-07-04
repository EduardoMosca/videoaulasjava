public class Main extends Thread {

  String palavra;
  long tempo;

  public Main(String palavra, long tempo) {
    this.palavra = palavra;
    this.tempo = tempo;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < 5; i++) {
        System.out.println(palavra);
        sleep(tempo);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
      return;
    }
  }

  public static void main(String[] args) {
    new Main("ping", 1500).start();
    new Main("pong", 2000).start();

    System.out.println("Ver Thread");
  }
}