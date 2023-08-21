package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.Vendedor;

public class EnderecoDAO {
	public boolean inserir(Endereco e) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "INSERT INTO enderecos (cep, id, rua, bairro, cidade, estado) VALUES (?, ?, ?, ?, ?, ?);";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, e.getRua());
			ps.setString(2, e.getBairro());
			ps.setString(3, e.getCidade());
			ps.setString(4, e.getEstado());
			ps.setString(5, Long.toString(e.getCep()));

			ps.executeUpdate();

			c.fecharConexao();

		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
		return true;

	}

	public ArrayList<Endereco> listar() {
		
	    ArrayList<Endereco> enderecos = new ArrayList<>();

		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();

		String query = "SELECT * FROM enderecos";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String rua = rs.getString("rua");
				String estado = rs.getString("estado");

				String bairro = rs.getString("bairro");

				String cidade = rs.getString("cidade");

				Long cep = rs.getLong("cep");

				Endereco e = new Endereco();
				e.setBairro(bairro);
				e.setId(id);
				e.setRua(rua);
				e.setCidade(cidade);
				e.setEstado(estado);
				e.setCep(cep);
				
				enderecos.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return enderecos; // Retorna null se não encontrar o endereço
	}
	


}
