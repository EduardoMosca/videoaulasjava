import java.util.Scanner;

public class Fibonacci {
  public static Scanner sc = new Scanner(System.in);

  // recursivo
  public static int fibonacci(int i) {
    if (i == 0)
      return 0;
    if (i <= 2)
      return 1;
    int termo = fibonacci(i - 1) + fibonacci(i - 2);
    return termo;
  }

  public static void main(String args[]) {
    int fib = 1, numeroAnterior = 0, soma = 0, quantidadeSerie;
    System.out.print("Digite quantos numeros da sequencia deseja: ");
    quantidadeSerie = sc.nextInt();
    for (int i = 0; i < quantidadeSerie; i++) {
      System.out.println(fib);
      soma = fib + numeroAnterior;
      numeroAnterior = fib;
      fib = soma;
    }
  }
}