import java.util.ArrayList;
import java.util.List;

/**
 * Main
 */
public class Main {
  public static long carregarMemoria() {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 100_000; i++) {
      list.add(i);
    }
    return Runtime.getRuntime().freeMemory();
  }

  public static void main(String[] args) {
    Runtime rt = Runtime.getRuntime();
    int MB = 1_048_576;
    double total = rt.maxMemory() / MB;
    double inicio = total - (carregarMemoria() / MB);

    rt.runFinalization();
    rt.gc();

    double fim = total - (rt.freeMemory() / MB);

    System.out.println("Inicio: " + inicio + " Fim: " + fim);
  }
}