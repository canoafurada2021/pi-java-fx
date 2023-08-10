package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Endereco;

public class EnderecoDAO {
	public boolean inserir (Endereco e)
	{
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		
		String query = "INSERT INTO enderecos (cep, id, rua, bairro, cidade, estado) VALUES (?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, e.getRua() );
			ps.setString(2, e.getBairro());
			ps.setString(3, e.getCidade());
			ps.setString(4, e.getEstado());
			ps.setString(5, Long.toString(e.getCep()));
			
			ps.executeUpdate();
			
			c.fecharConexao();
			
		} catch (SQLException e1 ) {
			e1.printStackTrace();
			return false;
		}
		return true;
		
	}
}
