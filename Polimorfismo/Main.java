public class Main {

  public static void main(String[] args) {
    Animal cachorro = new Cachorro(30, "Salsicha");
    Animal galinha = new Galinha(2, "Galinha");
    galinha.fazerBarulho();
    cachorro.fazerBarulho();
  }
}