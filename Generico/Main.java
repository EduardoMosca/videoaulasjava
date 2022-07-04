import java.util.ArrayList;
import java.util.Arrays;

public class Main<E> {

  private E elemento;

  public void setElemento(E elemento) {
    this.elemento = elemento;
  }

  public E getElemento() {
    return elemento;
  }

  public double soma(ArrayList<? extends Number> lista) {
    double total = 0;
    for (var i : lista) {
      total += i.doubleValue();
    }
    return total;
  }

  public static void main(String[] args) {
    Main<String> g = new Main<>();
    Main<Integer> i = new Main<>();
    Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    g.setElemento("teste");
    System.out.println(g.getElemento());
    System.out.println((int) i.soma(new ArrayList<>(Arrays.asList(array))));
  }
}