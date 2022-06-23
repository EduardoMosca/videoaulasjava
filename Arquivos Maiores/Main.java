import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    Path path = Paths.get(
        "files\\texto.txt");

    System.out.println(path.toAbsolutePath());
    System.out.println(path.getParent());
    System.out.println(path.getRoot());
    System.out.println(path.getFileName());
    Charset utf8 = StandardCharsets.UTF_8;

    Files.createDirectories(path.getParent());

    try (BufferedWriter w = Files.newBufferedWriter(path, utf8)) {
      w.write("Texto\n");
      w.write("Outro texto\n");
      w.write("Outro texto");
      w.flush();
      w.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (BufferedReader r = Files.newBufferedReader(path, utf8)) {
      String line = null;
      while ((line = r.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}