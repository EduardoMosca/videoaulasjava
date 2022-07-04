import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IncluirDados {
  public static void main(String[] args) {
    String url = "jdbc:postgresql://localhost:5432/xti";
    String sql = "insert into pessoa(nome, sexo, email) values (?, ?, ?)";
    String[] pessoas = { "Sandra", "Beatriz", "Juliana", "Fatima", "Veranda", "Tereza", "Leila" };
    try (Connection con = DriverManager.getConnection(url, "postgres", "123")) {
      try (PreparedStatement stm = con.prepareStatement(sql)) {

        for (int i = 0; i < pessoas.length; i++) {
          stm.setString(1, pessoas[i]);
          stm.setString(2, "F");
          stm.setString(3, pessoas[i].toLowerCase() + "@xti.com.br");
          stm.addBatch();
        }
        stm.executeBatch();
      } catch (SQLException e) {
        System.err.println(e.getMessage());
      }
      sql = "select nome, email from pessoa";
      try (PreparedStatement stm2 = con.prepareStatement(sql);
          ResultSet resultado = stm2.executeQuery()) {
        while (resultado.next()) {
          System.out.println(resultado.getString(1) + "\t" + resultado.getString(2));
        }
      }
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
  }
}
