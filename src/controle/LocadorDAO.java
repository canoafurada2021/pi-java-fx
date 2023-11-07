package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
				l.setCnh(rs.getLong("cnh"));
				l.setValidadeCarteira(rs.getString("validade_carteira"));


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

		String query = "INSERT INTO locador " +
				"(pessoas_cpf, nome, sobrenome, tel_contato, pais_residencia, cnh, validade_carteira, num_identificacao_carteira, TipoAcessoLogin) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, l.getPessoas_cpf());
			ps.setString(2, l.getNome());
			ps.setString(3, l.getSobrenome());
			ps.setLong(4, l.getTel_contato());
			ps.setString(5, l.getPaisResidencia());
			ps.setLong(6, l.getCnh());

			ps.setString(7, l.getValidadeCarteira());

			ps.setLong(8, l.getNumIdentificacaoCarteira());
			ps.setInt(9, l.getTipoAcesso().getId()); // Converte o Enum para o valor correspondente no banco

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

		return false;
	}

	public boolean atualizar(Locador l) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE locador SET " +
				"nome = ?, sobrenome = ?, tel_contato = ?, pais_residencia = ?, cnh = ?, validade_carteira = ?, num_identificacao_carteira = ?, TipoAcessoLogin = ? " +
				"WHERE pessoas_cpf = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, l.getNome());
			ps.setString(2, l.getSobrenome());
			ps.setLong(3, l.getTel_contato());
			ps.setString(4, l.getPaisResidencia());
			ps.setLong(5, l.getCnh());

			ps.setString(6, l.getValidadeCarteira());

			ps.setLong(7, l.getNumIdentificacaoCarteira());
			ps.setInt(8, l.getTipoAcesso().getId());



			ps.setString(9, l.getPessoas_cpf());

			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated > 0) {
				// Os dados foram atualizados com sucesso
				return true;
			} else {
				// Nenhum registro foi atualizado (o CPF pode não existir)
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			c.fecharConexao();
		}
	}
	public boolean excluir (Locador l ){
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();


		String query = "DELETE FROM locador WHERE pessoas_cpf = ?";

		try{


			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, l.getPessoas_cpf());

			int rowsAffected = ps.executeUpdate();


			if(rowsAffected > 0){
				c.fecharConexao();
				return true;
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return false;
	}







}








