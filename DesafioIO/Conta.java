public class Conta {
  private String cliente;
  private double saldo;

  public Conta() {
  };

  public Conta(String cliente, double saldo) {
    this.cliente = cliente;
    this.saldo = saldo;
  }

  public String getCliente() {
    return this.cliente;
  }

  public double getSaldo() {
    return this.saldo;
  }

  void exibeSaldo() {
    System.out.println(cliente + " seu saldo é " + saldo);
  }

  void saca(double valor) {
    saldo -= valor;
  }

  void deposita(double valor) {
    saldo += valor;
  }

  void transferePara(Conta destino, double valor) {
    this.saca(valor);
    destino.deposita(valor);
  }
}
