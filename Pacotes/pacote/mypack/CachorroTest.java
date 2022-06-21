package pacote.mypack;

public class CachorroTest {
  public static void main(String args[]) {
    Cachorro pitbull = new Cachorro();
    pitbull.tamanho = 30;
    pitbull.raca = "pitbull";
    pitbull.latir();

    Cachorro viralata = new Cachorro();
    viralata.raca = "viralata";
    viralata.tamanho = 30;
    viralata.latir();
  }
}
