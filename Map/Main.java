import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {
    Map<String, String> pais = new HashMap<>();
    pais.put("BR", "Brasil");
    pais.put("RU", "Russia");
    pais.put("IN", "India");
    pais.put("JP", "Japao");
    pais.put("CN", "China");
    System.out.println(pais);

    System.out.println(pais.containsKey("BR"));
    System.out.println(pais.containsValue("Brasil"));
    System.out.println(pais.get("CN"));
    pais.remove("RU");
    System.out.println(pais);

    Set<String> keys = pais.keySet();
    for (var i : keys) {
      System.out.println(i + " : " + pais.get(i));
    }
  }
}