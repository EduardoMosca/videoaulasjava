package Matemagica.Matemagica;

public class Matematica {
  public int maior(int um, int dois) {
    return (um > dois) ? um : dois;
  }

  public double soma(double num1, double num2) {
    return num1 + num2;
  }

  public int raiz(int num) {
    if (num < 0)
      throw new NumberFormatException("Nao existe raiz de negativo");
    int cont = 0, impar = 1;
    while (num >= impar) {
      num -= impar;
      impar += 2;
      cont++;
    }
    return cont;
  }

  public String romanos(int num) {
    return Integer.toString(num);
  }
}
