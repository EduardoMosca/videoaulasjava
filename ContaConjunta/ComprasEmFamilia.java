public class ComprasEmFamilia implements Runnable {

  ContaConjunta conta = new ContaConjunta();

  public static void main(String[] args) {
    ComprasEmFamilia irAscompras = new ComprasEmFamilia();
    new Thread(irAscompras, "Pai").start();
    new Thread(irAscompras, "Mae").start();
    new Thread(irAscompras, "Filha").start();
    new Thread(irAscompras, "Baba").start();
  }

  @Override
  public void run() {
    String cliente = Thread.currentThread().getName();
    for (int i = 0; i < 5; i++) {
      conta.sacar(20, cliente);
      if (conta.getSaldo() < 0) {
        System.out.println("Estourou");
      }
    }
  }

}
