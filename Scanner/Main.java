import java.util.Scanner;

public class Main {
  public static Scanner sc = new Scanner(System.in);

  public static void main(String args[]) {
    int x, y;
    System.out.print("Digite o primeiro numero para somar: ");
    x = sc.nextInt();
    System.out.print("Digite o sgundo numero para somar: ");
    y = sc.nextInt();
    System.out.printf("A soma dos numeros e %d\n", (x + y));
  }
}