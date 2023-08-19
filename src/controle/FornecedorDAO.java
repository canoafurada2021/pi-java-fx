package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Fornecedores;

public class FornecedorDAO {

	
	
	public boolean inserir(Fornecedores f) {

		// Instanciar a classe
		Conexao c = Conexao.getInstancia();

		// Abrir a conexao com o banco de dados
		Connection con = c.conectar();

		String query = "INSERT INTO fornecedores (" + "cnpj," + "enderecos_id," + "nome," + "telefone) "
				+ "VALUES (?, ?, ?, ?);";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, f.getCnpj());
			ps.setInt(2, f.getEnderecoId().getId());
			ps.setString(3, f.getNome());
			ps.setInt(4, f.getTelefone());

			// Consolidar a execução do comando no banco
			ps.executeUpdate();

			// Fecha a conexão com o banco
			c.fecharConexao();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false; // Retorna false em caso de falha na inserção
		}

		return true; // Retorna true se a inserção for bem-sucedida
	}
}
