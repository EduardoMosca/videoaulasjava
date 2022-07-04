import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatServer {
  private Scanner sc;
  List<PrintWriter> esctitores = new ArrayList<>();

  public ChatServer() {
    try (ServerSocket server = new ServerSocket(5000)) {
      while (true) {
        Socket socket = server.accept();
        new Thread(new EscutaCliente(socket)).start();
        PrintWriter p = new PrintWriter(socket.getOutputStream());
        esctitores.add(p);
      }
    } catch (Exception e) {
      e.getStackTrace();
    }
  }

  private void encaminharParaTodos(String texto) {
    for (PrintWriter printWriter : esctitores) {
      try {
        printWriter.println(texto);
        printWriter.flush();
      } catch (Exception e) {
        e.getStackTrace();
      }
    }
  }

  private class EscutaCliente implements Runnable {

    public EscutaCliente(Socket socket) {
      try {
        sc = new Scanner(socket.getInputStream());
      } catch (Exception e) {
        e.getStackTrace();
      }
    }

    @Override
    public void run() {
      try {
        String texto;
        while ((texto = sc.nextLine()) != null) {
          System.out.println(texto);
          encaminharParaTodos(texto);
        }
      } catch (Exception e) {
        e.getStackTrace();
      }
    }

  }

  public static void main(String[] args) {
    new ChatServer();
  }
}
