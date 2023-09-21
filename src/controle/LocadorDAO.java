package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.EnumCargos;
import modelo.Locador;

public class LocadorDAO {

	public List<Locador> listar() {

		// Instanciando a classe conexao
		Conexao c = Conexao.getInstancia();

		// Abrindo a conexao
		Connection con = c.conectar();

		String query = "SELECT * FROM locador";
		List<Locador> locadores = new ArrayList<>();

		try {

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Locador l = new Locador();

				l.setNome(rs.getString("nome"));
				l.setSobrenome(rs.getString("sobrenome"));
				l.setPessoas_cpf(rs.getString("pessoas_cpf"));
				l.setTel_contato(rs.getLong("tel_contato"));
				l.setPaisResidencia(rs.getString("pais_residencia"));
				l.setChn(rs.getLong("cnh"));
				l.setValidadeCarteira(rs.getDate("validade_carteira"));
				l.setImg_Base64("img_Base64Locador");

				/// Pegando a variável do tipo do cargo do usuário diretamente do banco
				String cargoFromDatabase = rs.getString("cargo");

				// Faz a conversão do valor do banco de dados para o mesmo tipo do EnumCargos
				EnumCargos cargoEnum = EnumCargos.valueOf(cargoFromDatabase);

				// Settando o valor do cargo corretamente para a entidade locador
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

	
	public boolean atualizar(Locador l) { //ta certo esse?
	    Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();
	    String query = "INSERT INTO locador " +
                "(pessoas_cpf, nome, sobrenome, tel_contato, pais_residencia, cnh, validade_carteira, num_identificacao_carteira, cargo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";	 
	    
	    
	    try {
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, l.getPessoas_cpf());
	        ps.setString(2, l.getNome());
	        ps.setString(3, l.getSobrenome());
	        ps.setLong(4, l.getTel_contato());
	        ps.setString(5, l.getPaisResidencia());
	        ps.setLong(6, l.getCnh());
	        
	        int rowsUpdated = ps.executeUpdate();
	        
	        if (rowsUpdated > 0) {
	            // Os dados foram atualizados com sucesso
	            return true;
	        } else {
	            // Nenhum registro foi atualizado (o CNPJ pode não existir)
	            return false;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        c.fecharConexao();
	    }
	}
	

	
	public boolean inserir(Locador l) {
	    Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();

	    String query = "INSERT INTO locador " +
	                   "(pessoas_cpf, nome, sobrenome, tel_contato, pais_residencia, cnh, validade_carteira, num_identificacao_carteira, cargo) " +
	                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try {
	        PreparedStatement ps = con.prepareStatement(query);

	        // Substitua os índices no setXXX pelos valores corretos (1, 2, 3, etc.)
	        ps.setString(1, l.getPessoas_cpf());
	        ps.setString(2, l.getNome());
	        ps.setString(3, l.getSobrenome());
	        ps.setLong(4, l.getTel_contato());
	        ps.setString(5, l.getPaisResidencia());
	        ps.setLong(6, l.getCnh());

	        
	        
	        Date validadeCarteira = new Date(l.getValidadeCarteira().getTime());

	        // Certifique-se de que getValidadeCarteira() retorna um java.sql.Date
	        ps.setDate(7, validadeCarteira);

	        // Substitua os índices restantes pelos valores apropriados
	        ps.setLong(8, l.getNumIdentificacaoCarteira());
	        
	        
	        
	        ps.setString(9, l.getCargo().toString()); //conversão da role para o valor especifico estabelecido para essa coluna no banco

      ps.setString(10, l.getImg_Base64());

	        // Execute a consulta SQL
	        ps.executeUpdate();
	        
	        
	        // Fecha a conexão com o banco
            c.fecharConexao();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false; // Retorna false em caso de erro
	    } finally {
	        c.fecharConexao();
	    }

	    return true;
	}


	public boolean excluir(Locador l) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM locador WHERE pessoas_cpf = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, l.getPessoas_cpf());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
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