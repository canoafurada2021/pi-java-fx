package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Connection conexao;
	private static Conexao instancia;
	private static final String DATABASE = "banco_teste";
	private static final String URL =  "jdbc:mysql://localhost/"+ DATABASE + "?serverTimezone=UTC";
	private static final String USER     = "root";
	private static final String PSW      = "aluno";
	
	private Conexao() {}
	
	public static Conexao getInstancia() {
		if (instancia == null) { 
			instancia = new Conexao(); 
		}
		return instancia;	
	}
	
	public Connection conectar() {
		try {
			conexao = DriverManager.getConnection(URL, USER, PSW);
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		return conexao;		
	}
	
	public boolean fecharConexao() { 
		try { 
			conexao.close(); 
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
