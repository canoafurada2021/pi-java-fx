package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Vendedores;

public class VendedoresDAO {

	public boolean inserir(Vendedores v) {

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		String query = "INSERT INTO (idVendedores, salario, nome, sobrenome) VALUES (?, ?, ?, ?);";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, Integer.toString(v.getIdVendedores()));
			ps.setString(2, Double.toString(v.getSalario()));
			ps.setString(2, v.getNome());
			ps.setString(4, v.getSobrenome());

			ps.executeUpdate();

			c.fecharConexao();

		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

		return true;

	}

}
