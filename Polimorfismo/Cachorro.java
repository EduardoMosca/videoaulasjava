public final class Cachorro extends Animal {
  public Cachorro(int tamanho, String tipo) {
    this.tamanho = tamanho;
    this.tipo = tipo;
  }

  @Override
  public void fazerBarulho() {
    System.out.println("Au! Au!");
  }

  @Override
  public void comer() {
    System.out.println("Cachorro comendo!");
  }

  public void balancarRabo() {
    System.out.println("Balancando rabo");
  }
}
