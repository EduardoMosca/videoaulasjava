import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

  public static void main(String[] args) throws IOException {
    Path path = Paths.get("files\\texto.txt");
    // System.out.println(Files.exists(path));
    // System.out.println(Files.isDirectory(path));
    // System.out.println(Files.isRegularFile(path));
    // System.out.println(Files.isReadable(path));
    // System.out.println(Files.isExecutable(path));
    // System.out.println(Files.size(path));
    // System.out.println(Files.isRegularFile(path));
    // System.out.println(Files.getOwner(path));
    // System.out.println(Files.probeContentType(path));

    // Files.delete(path);
    Files.deleteIfExists(path);

    Files.createFile(path);
    Files.write(path, "Meu texto".getBytes());

    // Path copia = Paths.get("files\\copia.txt");
    // Files.copy(path, copia, StandardCopyOption.REPLACE_EXISTING);

    Path mover = Paths.get("files\\mover\\texto.txt");
    Files.createDirectories(mover.getParent());
    Files.move(path, mover, StandardCopyOption.REPLACE_EXISTING);

  }
}