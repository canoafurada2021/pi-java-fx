package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.TipoAcessoLogin;
import modelo.Locador;

public class LocadorDAO {

	public ArrayList<Locador> listar() {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "SELECT * FROM locador";
		ArrayList<Locador> locadores = new ArrayList<>();

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Locador l = new Locador();

				l.setPessoas_cpf(rs.getString("pessoas_cpf"));
				l.setNome(rs.getString("nome"));
				l.setSobrenome(rs.getString("sobrenome"));
				l.setTel_contato(rs.getLong("tel_contato"));
				l.setPaisResidencia(rs.getString("pais_residencia"));
				l.setChn(rs.getLong("cnh"));

				Date validadeCarteira = rs.getDate("validade_carteira");
				l.setValidadeCarteira(validadeCarteira);

				l.setNumIdentificacaoCarteira(rs.getLong("num_identificacao_carteira"));
				l.setImg_Base64(rs.getString("img_Base64Locador"));

				Integer cargoFromDatabase = rs.getInt("TipoAcessoLogin");
				TipoAcessoLogin cargoEnum = TipoAcessoLogin.getById(cargoFromDatabase);

				l.setCargo(cargoEnum);
				locadores.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}
		return locadores;
	}

	public boolean inserir(Locador l) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "INSERT INTO locador (pessoas_cpf, nome, sobrenome, tel_contato, pais_residencia, cnh, validade_carteira, num_identificacao_carteira, cargo, img_Base64Locador) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, l.getPessoas_cpf());
			ps.setString(2, l.getNome());
			ps.setString(3, l.getSobrenome());
			ps.setLong(4, l.getTel_contato());
			ps.setString(5, l.getPaisResidencia());
			ps.setLong(6, l.getCnh());

			Date validadeCarteira = new Date(l.getValidadeCarteira().getTime());
			ps.setDate(7, validadeCarteira);

			ps.setLong(8, l.getNumIdentificacaoCarteira());
			ps.setInt(9, l.getCargo().getId()); // Converte o Enum para o valor correspondente no banco
			ps.setString(10, l.getImg_Base64());

			int rowsInserted = ps.executeUpdate();

			if (rowsInserted > 0) {
				c.fecharConexao();
				return true; // Inserção bem-sucedida
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false; // Falha na inserção
	}

	public boolean atualizar(Locador l) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE locador SET nome = ?, sobrenome = ?, tel_contato = ?, pais_residencia = ?, cnh = ?, validade_carteira = ?, num_identificacao_carteira = ?, cargo = ?, img_Base64Locador = ? WHERE pessoas_cpf = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, l.getNome());
			ps.setString(2, l.getSobrenome());
			ps.setLong(3, l.getTel_contato());
			ps.setString(4, l.getPaisResidencia());
			ps.setLong(5, l.getCnh());

			Date validadeCarteira = new Date(l.getValidadeCarteira().getTime());
			ps.setDate(6, validadeCarteira);

			ps.setLong(7, l.getNumIdentificacaoCarteira());
			ps.setInt(8, l.getCargo().getId());
			ps.setString(9, l.getImg_Base64());
			ps.setString(10, l.getPessoas_cpf());

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				c.fecharConexao();
				return true; // Atualização bem-sucedida
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false; // Falha na atualização
	}

	public boolean excluir(Locador l) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM locador WHERE pessoas_cpf = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, l.getPessoas_cpf());

			int rowsDeleted = ps.executeUpdate();

			if (rowsDeleted > 0) {
				c.fecharConexao();
				return true; // Exclusão bem-sucedida
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false; // Falha na exclusão
	}
}
