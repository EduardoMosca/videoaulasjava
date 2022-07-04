import java.lang.Math;

public class Matematica {
  double raiz(int numero) {
    return Math.sqrt(numero);
  }

  int maior(int a, int b) {
    return (a > b) ? a : b;
  }

  int divide(int a, int b) {
    return a / b;
  }

  double soma(double a, double b) {
    return a + b;
  }

  double media(int a, int b) {
    return (a + b) / 2;
  }

  double media(double... ds) {
    double aux = 0;
    for (int i = 0; i < ds.length; i++) {
      aux += ds[i];
    }
    return aux / ds.length;
  }
}
