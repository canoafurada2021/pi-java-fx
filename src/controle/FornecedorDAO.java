package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Endereco;
import modelo.Fornecedores;

public class FornecedorDAO {

	public ArrayList<Fornecedores> listar(){
	    Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();
	    
	    ArrayList<Fornecedores> fornecedores = new ArrayList<>();
	    
	    
	    String query = "SELECT f.*, e.rua FROM fornecedores f " +
                "INNER JOIN enderecos e ON f.enderecos_id = e.id";	    
	    
	    
	    try {
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	    	
	        
	        
	    	while(rs.next()) {
	    		
	    		
	    	int cnpj = rs.getInt("cnpj");
	    	String nome = rs.getString("nome");
	    	int telefone = rs.getInt("telefone");
	    	String atividades = rs.getString("atividades");
	    	
	    	Fornecedores f = new Fornecedores();
	    	
	    	f.setCnpj(cnpj);
	    	f.setNome(nome);
	    	f.setTelefone(telefone);
	    	f.setAtividades(atividades);
	    	
	    	  // Crie um objeto Endereco e configure os atributos
            Endereco endereco = new Endereco();
            endereco.setRua(rs.getString("rua"));
            // Preencha os demais atributos do endereço se necessário

            // Associe o endereço ao fornecedor
            f.setEnderecoId(endereco);

            fornecedores.add(f);
            
            
	    	
	    	}
	    }catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        c.fecharConexao();
	    }
	    return fornecedores;
	    
	}
	
	public boolean inserir(Fornecedores f) {

		// Instanciar a classe
		Conexao c = Conexao.getInstancia();

		// Abrir a conexao com o banco de dados
		Connection con = c.conectar();

		String query = "INSERT INTO fornecedores "
				+ "(" + "cnpj,"
				+ "enderecos_id,"
				+ "nome," 
				+ "atividades,"
				+ "telefone) "
				+ "VALUES (?, ?, ?, ?);";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, f.getCnpj());
			ps.setInt(2, f.getEnderecoId().getId());
			ps.setString(3, f.getNome());
			ps.setString(4, f.getAtividades());

			ps.setInt(5, f.getTelefone());

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
