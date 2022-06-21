import java.util.ArrayList;

public class Main {
  public static void main(String args[]) {
    ArrayList<String> cores = new ArrayList<String>();
    cores.add("Azul");
    cores.add("Branco");
    cores.add("Amarelo");
    cores.add("Vermelho");
    System.out.println("Tamanho = " + cores.size());
    System.out.println("Elemento 2 = " + cores.get(1));
    System.out.println("Indice Amarelo = " + cores.indexOf("Amarelo"));

    cores.remove("Branco");
    System.out.println("Tem amarelo ? " + cores.contains("Amarelo"));
  }
}