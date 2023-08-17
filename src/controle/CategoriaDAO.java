package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Categoria;
import modelo.EnumRoles;
import modelo.Vendedores;

public class CategoriaDAO {
	
	
	
	public ArrayList<Categoria> listar() {
		
	    Conexao c = Conexao.getInstancia();
	    Connection con = c.conectar();
	    
	    ArrayList<Categoria> categorias = new ArrayList<>();

	    
	    String query = "SELECT * FROM categoria";
	    
	    try {
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            int idCategoria = rs.getInt("id_categoria");
	            String nome = rs.getString("categoria");
	            
	     
	            
	            Categoria cat = new Categoria();
	            cat.setCategoria(nome);
	            cat.setIdCategoria(idCategoria);
	
	            
	            categorias.add(cat);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        c.fecharConexao();
	    }
	    
	    return categorias;
	    
	    
	}
	
	
	
	public boolean inserir(Categoria c) {

	//instancia a classe
	Conexao a = Conexao.getInstancia();
	
	//ABRE conexao com banco
	Connection con = a.conectar();
	
	String query = "INSERT INTO categoria(id_categorias, categoria) VALUES(?, ?); ";
	
	try {
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, Integer.toString(c.getIdCategoria()));
		ps.setString(2, c.getCategoria());
		
		//consolida a execução do comando no banco
		ps.executeUpdate();
		
		//fecha a conexão com banco 
		
		a.fecharConexao();	
	} catch (SQLException e1) {
		e1.printStackTrace();
		return false; //retorna falso caso falha na inserção
	}
	return true; // retorna true se insercao bem sucedida
	}
}
