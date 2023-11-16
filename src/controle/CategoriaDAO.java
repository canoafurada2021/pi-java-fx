package controle;

import java.sql.*;
import java.util.ArrayList;

import modelo.Categoria;

public class CategoriaDAO implements ICategoriaDAO {

	public ArrayList<Categoria> listar() {

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		ArrayList<Categoria> categorias = new ArrayList<>();

		String query = "SELECT * FROM categoria";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Integer idCategoria = rs.getInt("id_categoria");
				String nome = rs.getString("categoria");

				Categoria cat = new Categoria();
				cat.setCategoria(nome);
				cat.setIdCategoria(idCategoria);
				categorias.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return categorias;

	}

	public int inserir(Categoria c) {

		// instancia a classe
		Conexao a = Conexao.getInstancia();

		// ABRE conexao com banco
		Connection con = a.conectar();

		String query = "INSERT INTO categoria( categoria) VALUES( ?); ";

		try {
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, c.getCategoria());

			// consolida a execução do comando no banco
			ps.executeUpdate();

			// fecha a conexão com banco
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getInt(1); // retorna o id se conseguir inserir
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			a.fecharConexao();
		}
		return 0; // retorna zero se nao conseguir inserir
	}

	public boolean excluir(Categoria ca) {
		//if (ca.getIdCategoria() == null) {
		//	return false; // Não é possível excluir uma categoria com id nulo
		//}

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM categoria WHERE id_categoria = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, ca.getIdCategoria());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				c.fecharConexao();
				return true; // se bem sucedida
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}
		return false; // se bem falha na exclusão
	}


	public boolean atualizar(Categoria ca) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE categoria SET categoria = ? WHERE id_categoria = ?";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, ca.getCategoria());
			preparedStatement.setInt(2, ca.getIdCategoria());

			int rowsUpdated = preparedStatement.executeUpdate();

			return rowsUpdated > 0; // Retorna verdadeiro se a atualização foi bem-sucedida
		} catch (SQLException e) {
			e.printStackTrace();
			return false; // Retorna falso em caso de falha na atualização
		} finally {
			c.fecharConexao(); // Garante que a conexão será fechada
		}
	}



}
