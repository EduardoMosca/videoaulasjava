public class Matriz {
  public static void main(String args[]) {
    String duas[][] = {
        { "Ricardo", "M", "DF" },
        { "Sandra", "F", "MG" },
        { "Beatriz", "F", "DF" },
        { "Lawrence", "M", "PA" },
        { "Laura", "F", "RJ" },
        { "Juliana", "F", "SP" }
    };
    for (var i : duas) {
      for (var j : i) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }
}