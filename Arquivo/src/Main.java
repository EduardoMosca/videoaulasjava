import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");
		Path path = Paths.get("files\\text.txt");
		System.out.println(path.toAbsolutePath());
		System.out.println(path.getParent());
		System.out.println(path.getRoot());
		System.out.println(path.getFileName());

		Files.createDirectories(path.getParent());

		byte[] bytes = "Meu Texto".getBytes();
		Files.write(path, bytes);

		byte[] retorno = Files.readAllBytes(path);

		System.out.println(new String(retorno));
	}

}
