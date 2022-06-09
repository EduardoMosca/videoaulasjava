import java.lang.Math;
import java.util.Scanner;

public class Main {
  public static Scanner sc = new Scanner(System.in);

  public static void main(String args[]) {
    double raio, resultado;
    System.out.print("Digite o valor do raio: ");
    raio = sc.nextDouble();
    resultado = 2 * raio * Math.PI;
    System.out.printf("O valor da circunferencia e aproximadamente: %f\n", resultado);
  }
}