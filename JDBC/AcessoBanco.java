import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcessoBanco {
  public static void main(String[] args) throws SQLException {
    String sql = "select codigo, nome, sexo, email from pessoa";
    String url = "jdbc:postgresql://localhost:5432/xti";

    try (Connection con = DriverManager.getConnection(url, "postgres", "123");
        PreparedStatement stm = con.prepareStatement(sql);
        ResultSet resultado = stm.executeQuery()) {
      while (resultado.next()) {
        String s = resultado.getString("codigo") + "\t" + resultado.getString("nome") + "\t"
            + resultado.getString("sexo") + "\t" + resultado.getString("email");
        System.out.println(s);
      }
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }

  }
}