package controle;

import java.sql.Connection;
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
				l.setPessoas_cpf(rs.getInt("pessoas_cpf"));
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
	
	
	public boolean excluir(Locador l) {
	    Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();
	    
	    String query = "DELETE FROM locador WHERE pessoas_cpf = ?";
	    
	    try {
	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setInt(1, l.getPessoas_cpf());
	        
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