package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.EnumCargos;
import modelo.Login;

public class LoginDAO {

    public boolean inserirLogin(Login login) {
        Conexao c = Conexao.getInstancia();
        try (Connection con = c.conectar()) {
            String query = "INSERT INTO login (cpf, senha, tipo_usuario) VALUES (?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, login.getCpf());
                ps.setString(2, login.getSenha());
                ps.setString(3, mapearTipoUsuario(login.getTipoUsuario()));
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private String mapearTipoUsuario(EnumCargos role) {
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

    public boolean fazerLogin(String cpf, String senha) {
        String selectQuery = "SELECT * FROM login WHERE cpf = ? AND senha = ?";
        try (Connection connection = Conexao.getInstancia().conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, cpf);
            preparedStatement.setString(2, senha);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
	

