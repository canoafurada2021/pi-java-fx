package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Endereco;
import modelo.Locador;



// VERIFICAR SE O MÉTODO DE INSERÇÃO DE LOCADOR FUNCIONA POR CONTA DA CHAVE ESTRANGEIRA!!!	

public class LocadorDAO {

	  public boolean inserir(Locador l) {

	        Conexao c = Conexao.getInstancia();
	        Connection con = c.conectar();

	        
	        String queryPessoa = "INSERT INTO pessoas (cpf, nome, sobrenome) VALUES (?, ?, ?)";

	        String query = "INSERT INTO locador (pessoas_cpf, telContato, nome, sobrenome, enderecos_id) VALUES (?, ?, ?, ?, ?)";

	        try {
	        	
	        	
	        	// insert primeiro de pessoa na tabela pessoa
	        	   PreparedStatement psPessoa = con.prepareStatement(queryPessoa);
	               psPessoa.setFloat(1, l.getCpf());
	               psPessoa.setString(2, l.getNome());
	               psPessoa.setString(3, l.getSobrenome());
	               psPessoa.executeUpdate();
	        	
	        	
	            PreparedStatement ps = con.prepareStatement(query);
	           
	            ps.setFloat(1, l.getCpf());
	            ps.setLong(2, l.getTelContato());
	            ps.setString(3, l.getNome());
	            ps.setString(4, l.getSobrenome());

	            
	 
	            ps.executeUpdate();

	            c.fecharConexao();

	        } catch (SQLException e1) {
	            e1.printStackTrace();
	            return false;
	        }

	        return true;
	    }
}
