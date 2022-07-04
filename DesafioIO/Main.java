import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

  public static void armazenarContas(ArrayList<Conta> contas, String path) throws IOException {
    // Charset definition
    Charset utf8 = StandardCharsets.UTF_8;
    // Path with file to be written and created if necessary
    Path pathWrite = Paths.get(path);
    Files.createDirectories(pathWrite.getParent());

    // Configuration of the file
    BufferedWriter w = Files.newBufferedWriter(pathWrite, utf8, StandardOpenOption.APPEND,
        StandardOpenOption.CREATE,
        StandardOpenOption.SYNC);

    // Loop to store conta
    for (var i : contas) {
      try {
        w.write("Conta: " + i.getCliente() + "\n");
        w.write("Saldo: " + String.valueOf(i.getSaldo()) + "\n\n");
      } catch (IOException e) {
        e.printStackTrace();
        w.close();
      }
    }
    w.close();
  }

  public static ArrayList<Conta> lerContas(String path) throws IOException {
    // Returned ArrayList
    ArrayList<Conta> contas = new ArrayList<>();

    // Charset definition
    Charset utf8 = StandardCharsets.UTF_8;

    // Path to the file to be reader
    Path pathRead = Paths.get(path);

    // String that read the line from file
    String line = null;
    // String that stores the account name and salary
    String[] conta = new String[2];
    // Error treating and loop to read the document
    try (BufferedReader r = Files.newBufferedReader(pathRead, utf8);) {
      while ((line = r.readLine()) != null) {
        // IF to store account
        if (line.contains("Conta:")) {
          conta[0] = "";
          // Split string array of the line into LinkedList and remove the first ellement
          LinkedList<String> aux = new LinkedList<>(Arrays.asList(line.split(" ")));
          aux.pop();
          // Add the complete account name and remove the last space
          for (int i = 0; i < aux.size(); i++) {
            conta[0] += aux.get(i);
            if (i != aux.size() - 1) {
              conta[0] += " ";
            }
          }
        }
        // IF to store salary
        if (line.contains("Saldo:")) {
          // Add salary string
          conta[1] = line.split(" ")[1];
          // Create the object into ArrayList
          contas.add(new Conta(conta[0], Double.parseDouble(conta[1])));
          conta[0] = null;
          conta[1] = null;
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return contas;
  }

  public static void main(String[] args) throws IOException {
    ArrayList<Conta> guardaContas;
    ArrayList<Conta> armazenaContas = new ArrayList<>();
    armazenaContas.add(new Conta("Jorge da Silva", 120000));
    armazenaContas.add(new Conta("Eduardo Mosca", 5600.37));
    armazenaContas.add(new Conta("Sandra", 20308.49));
    armazenaContas.add(new Conta("Beatriz", 6300.78));

    String path = "files\\contas.txt";

    // armazenarContas(armazenaContas, path);
    guardaContas = lerContas(path);
    for (var i : guardaContas) {
      System.out.println("Conta: " + i.getCliente() + "\t" + "Saldo: " + i.getSaldo());
    }
  }
}