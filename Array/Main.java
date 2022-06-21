import java.util.Random;
import java.util.Arrays;

public class Main {
  public static void main(String args[]) {
    int array[] = new int[20];
    Random rand = new Random();
    for (int i = 0; i < array.length; i++) {
      array[i] = rand.nextInt(array.length) + 1;
    }
    Arrays.sort(array, 0, array.length);
    for (var i : array) {
      System.out.println(i);
    }
  }
}