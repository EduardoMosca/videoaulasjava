public final class Galinha extends Animal {
  public Galinha(int tamanho, String tipo) {
    this.tamanho = tamanho;
    this.tipo = tipo;
  }

  @Override
  public void fazerBarulho() {
    System.out.println("Co! Co!");
  }

  @Override
  public void comer() {
    System.out.println("Galinha comendo!");
  }

  public void voar() {
    System.out.println("voando");
  }
}
