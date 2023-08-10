package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Empresa;

public class EmpresaDAO {

    public boolean inserir(Empresa e) {

        // Instanciar a classe
        Conexao c = Conexao.getInstancia();

        // Abrir a conexao com o banco de dados
        Connection con = c.conectar();

        String query = "INSERT INTO empresa (razaosocial, telefone, cnpj, nomefantasia, porteEmpresa) VALUES (?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, e.getRazaoSocial());
            ps.setLong(2, e.getTelefone());
            ps.setString(3, Double.toString(e.getCnpj()));
            ps.setString(4, e.getNomeFantasia());
            ps.setString(5, e.getPorteEmpresa());

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
