package controle;

import java.sql.*;
import java.util.ArrayList;

import modelo.TipoAcessoLogin;
import modelo.Vendedor;

public class VendedorDAO implements IVendedorDAO{

	public ArrayList<Vendedor> listar() {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		ArrayList<Vendedor> vendedores = new ArrayList<>();

		String query = "SELECT * FROM vendedor";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Integer idVendedor = rs.getInt("id_vendedor");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				Long cpf = rs.getLong("cpf");
				String senha = rs.getString("senha");
				double salario = rs.getDouble("salario");

				// Recupere o valor do cargo do enum
				int tipoAcessoId = rs.getInt("TipoAcessoLogin");
				TipoAcessoLogin tipoAcesso = TipoAcessoLogin.getById(tipoAcessoId);

				Vendedor v = new Vendedor();
				v.setId_vendedor(idVendedor);
				v.setNome(nome);
				v.setSobrenome(sobrenome);
				v.setSalario(salario);
				v.setCpf(cpf);
				v.setSenha(senha);
				v.setTipoAcesso(tipoAcesso);

				vendedores.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return vendedores;
	}

	public boolean inserir(Vendedor v) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "INSERT INTO vendedor (salario, nome, sobrenome, cpf, senha, TipoAcessoLogin) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.setDouble(1, v.getSalario());
			ps.setString(2, v.getNome());
			ps.setString(3, v.getSobrenome());
			ps.setLong(4, v.getCpf());
			ps.setString(5, v.getSenha());
			ps.setInt(6, TipoAcessoLogin.FUNCIONARIO.getId());

			int rowsInserted = ps.executeUpdate();

			c.fecharConexao();

			return rowsInserted > 0;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	public boolean excluir(Vendedor v) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM vendedor WHERE id_vendedor = ?";

		try {
			if (v.getId_vendedor() != null) { // Verifica se o ID não é nulo
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, v.getId_vendedor().intValue()); // Chama intValue() apenas se não for nulo

				int rowsAffected = ps.executeUpdate();

				c.fecharConexao();

				return rowsAffected > 0;
			} else {
				System.out.println("ID do vendedor é nulo. Não é possível excluir.");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean atualizar(Vendedor v) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE vendedor SET salario = ?, nome = ?, sobrenome = ?, cpf = ?, senha = ?, TipoAcessoLogin = ? WHERE id_vendedor = ?";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);

			preparedStatement.setDouble(1, v.getSalario());
			preparedStatement.setString(2, v.getNome());
			preparedStatement.setString(3, v.getSobrenome());
			preparedStatement.setLong(4, v.getCpf());
			preparedStatement.setString(5, v.getSenha());
			preparedStatement.setInt(6, v.getTipoAcesso().getId());
			preparedStatement.setInt(7, v.getId_vendedor());

			int rowsUpdated = preparedStatement.executeUpdate();

			c.fecharConexao();

			return rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
