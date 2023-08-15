package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.EnumRoles;
import modelo.Login;

public class LoginDAO {

	// VERIFICAR SE O MÉTODO DE INSERÇÃO DE LOCADOR FUNCIONA POR CONTA DA CHAVE ESTRANGEIRA!!!	


	      public boolean inserirLogin(Login login) {

	          Conexao c = Conexao.getInstancia();
	          Connection con = c.conectar();

	          String query = "INSERT INTO login (cpf, senha, tipo_usuario) VALUES (?, ?, ?)";

	          try {
	              PreparedStatement ps = con.prepareStatement(query);
	              ps.setString(1, login.getCpf());
	              ps.setString(2, login.getSenha());
	              ps.setString(3, mapearTipoUsuario(login.getTipoUsuario())); // mapeia o enum para os tipos de usuarios no sistema

	              ps.executeUpdate();

	              c.fecharConexao();

	          } catch (SQLException e1) {
	              e1.printStackTrace();
	              return false;
	          }

	          return true;
	      }
	      
	 
		  private String mapearTipoUsuario(EnumRoles role) {
		        switch (role) {
		            case MASTER:
		                return "master";
		            case FUNCIONARIO:
		                return "funcionario";
		            case CLIENTE:
		                return "cliente";
		            default:
		                throw new IllegalArgumentException("Tipo de usuário não reconhecido: " + role);
		        }
		    }
		  

		    private static boolean fazerLogin(Connection connection, String cpf, String senha) throws SQLException {
		        String selectQuery = "SELECT * FROM login WHERE cpf = ? AND senha = ?";
		        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
		            preparedStatement.setString(1, cpf);
		            preparedStatement.setString(2, senha);
		            try (ResultSet resultSet = preparedStatement.executeQuery()) {
		                return resultSet.next(); // Retorna true se encontrou um registro
		            }
		        }

}
}
	

