import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaCRUD {

  public void transferir(Connection con, Conta origem, Conta destino, double valorTransferencia) throws SQLException {
    if (origem.saldo >= valorTransferencia) {
      try {
        con.setAutoCommit(false);
        // SAQUE
        origem.saldo -= valorTransferencia;
        alterar(con, origem);

        // DEPOSITO
        destino.saldo += valorTransferencia;
        alterar(con, destino);

        con.commit();
      } catch (SQLException e) {
        con.rollback();
        System.err.println(e.getMessage());
      }
    }
  }

  public void criar(Connection con, Conta conta) throws SQLException {
    String sql = "insert into conta values (?, ?, ?)";
    try (PreparedStatement stm = con.prepareStatement(sql)) {
      stm.setInt(1, conta.numero);
      stm.setString(2, conta.cliente);
      stm.setDouble(3, conta.saldo);
      stm.executeUpdate();
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
  }

  public void alterar(Connection con, Conta conta) throws SQLException {
    String sql = "update conta set cliente=?, saldo=? where numero=?";
    try (PreparedStatement stm = con.prepareStatement(sql)) {
      stm.setString(1, conta.cliente);
      stm.setDouble(2, conta.saldo);
      stm.setInt(3, conta.numero);
      stm.executeUpdate();
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
  }

  public void excluir(Connection con, Conta conta) throws SQLException {
    String sql = "delete from conta where numero=?";
    try (PreparedStatement stm = con.prepareStatement(sql)) {
      stm.setInt(1, conta.numero);
      stm.executeUpdate();
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
  }

  public List<Conta> ler(Connection con) throws SQLException {
    List<Conta> lista = new ArrayList<>();
    String sql = "select numero, cliente, saldo from conta";
    try (PreparedStatement stm = con.prepareStatement(sql);
        ResultSet resultado = stm.executeQuery()) {
      while (resultado.next()) {
        lista.add(new Conta(resultado.getInt(1), resultado.getString(2), resultado.getDouble(3)));

      }
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
    return lista;
  }

  public static void main(String[] args) throws SQLException {
    String url = "jdbc:postgresql://localhost:5432/xti";
    try (Connection con = DriverManager.getConnection(url, "postgres", "123")) {
      ContaCRUD crud = new ContaCRUD();

      List<Conta> contas = crud.ler(con);
      for (Conta conta : contas) {
        System.out.println(conta);
      }

      Conta origem = contas.get(0);
      Conta destino = contas.get(1);

      crud.transferir(con, origem, destino, 500);
      contas = crud.ler(con);
      for (Conta conta : contas) {
        System.out.println(conta);
      }
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
  }
}
