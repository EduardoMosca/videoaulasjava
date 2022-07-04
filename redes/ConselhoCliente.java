import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ConselhoCliente {

  public static void main(String[] args) throws UnknownHostException, IOException {
    Socket socket = new Socket("localhost", 5000);

    Scanner s = new Scanner(socket.getInputStream());
    System.out.println("Mensagem: " + s.nextLine());
    s.close();
    socket.close();
  }
}