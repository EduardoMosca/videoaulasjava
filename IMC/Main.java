import java.util.Scanner;
import java.lang.Math;

public class Main {
  public static Scanner sc = new Scanner(System.in);

  public static void main(String args[]) {
    float pesoEmQuilogramas, alturaEmMetros, resultado;
    System.out.print("Digite seu peso em quilogramas: ");
    pesoEmQuilogramas = sc.nextFloat();
    System.out.print("Digite sua altura em metros: ");
    alturaEmMetros = sc.nextFloat();
    resultado = pesoEmQuilogramas / (float) Math.pow((float) alturaEmMetros, 2);
    String msg = ((resultado >= 20 && resultado <= 25) ? "Peso Ideal" : "Fora do peso ideal");
    System.out.printf("IMC = %.2f\n", resultado);
    System.out.println(msg);
  }
}