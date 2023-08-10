package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Categoria;

public class CategoriaDAO {
	
	public boolean inserir(Categoria c) {

	//instancia a classe
	Conexao a = Conexao.getInstancia();
	
	//ABRE conexao com banco
	Connection con = a.conectar();
	
	String query = "INSERT INTO categorias(idcategorias, categoria) VALUES(?, ?); ";
	
	try {
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, Integer.toString(c.getIdCategoria()));
		ps.setString(2, c.getNome());
		
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
