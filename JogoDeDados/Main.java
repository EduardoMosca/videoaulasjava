import java.util.Random;
import java.util.Scanner;

public class Main {
  public static Scanner sc = new Scanner(System.in);

  public static void main(String args[]) {
    String resultado;
    int palpite, valorDado;
    Random rand = new Random();
    System.out.print("Digite o palpite do dado: ");
    palpite = sc.nextInt();
    valorDado = rand.nextInt(6) + 1;
    resultado = (palpite == valorDado) ? "Voce acertou o palpite"
        : "Voce errou o palpite, o valor do dado foi " + valorDado;
    System.out.println(resultado);
  }
}