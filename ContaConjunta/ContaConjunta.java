/**
 * Main
 */
public class ContaConjunta {

  private int saldo = 100;

  public int getSaldo() {
    return saldo;
  }

  public synchronized void sacar(int valor, String cliente) {
    if (saldo >= valor) {
      int saldoOriginal = saldo;
      try {
        System.out.println(cliente + " esperando");
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      saldo -= valor;
      System.out
          .println(cliente + " sacou: " + valor + " [Saldo Original= " + saldoOriginal + ", SaldoFinal=" + saldo + "]");
    } else {
      System.out.println("Saldo insuficiente");
    }
  }
}