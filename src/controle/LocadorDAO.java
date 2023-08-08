package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Endereco;



// VERIFICAR SE O MÉTODO DE INSERÇÃO DE LOCADOR FUNCIONA POR CONTA DA CHAVE ESTRANGEIRA!!!	

public class LocadorDAO {

	  public boolean inserirLocador(int cpf, int telContato, String nome, String sobrenome, int enderecoId) {

	        Conexao c = Conexao.getInstancia();
	        Connection con = c.conectar();

	        EnderecoDAO enderecoDAO = new EnderecoDAO();
	        Endereco endereco = enderecoDAO.getEndereco(enderecoId);

	        if (endereco == null) {
	            // Lidar com a falha ao obter o endereço
	            return false;
	        }

	        String query = "INSERT INTO locador (pessoas_cpf, telContato, nome, sobrenome, enderecos_id) VALUES (?, ?, ?, ?, ?)";

	        try {
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setInt(1, cpf);
	            ps.setInt(2, telContato);
	            ps.setString(3, nome);
	            ps.setString(4, sobrenome);
	            ps.setInt(5, endereco.getId()); // Usar o ID do endereço obtido

	            ps.executeUpdate();

	            c.fecharConexao();

	        } catch (SQLException e1) {
	            e1.printStackTrace();
	            return false;
	        }

	        return true;
	    }
}
