package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Empresa;
import modelo.TipoAcessoLogin;

public class EmpresaDAO implements IEmpresaDAO {

    public Empresa listar() {
        Conexao c = Conexao.getInstancia();
        Connection con = c.conectar();

        ArrayList<Empresa> empresas = new ArrayList<>();

        String query = "SELECT * FROM empresa LIMIT 1";
        Empresa empresa = null;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String nome_fantasia = rs.getString("nome_fantasia");
                String razao_social = rs.getString("razao_social");
                String porte_empresa = rs.getString("porte_empresa");
                Long id_empresa = rs.getLong("id_empresa");
                Long cnpj = rs.getLong("cnpj");
                Long telefone = rs.getLong("telefone");

                int tipoAcessoId = rs.getInt("TipoAcessoLogin");
                TipoAcessoLogin tipoAcesso = TipoAcessoLogin.getById(tipoAcessoId);

                empresa = new Empresa();
                empresa.setNome_fantasia(nome_fantasia);
                empresa.setRazao_social(razao_social);
                empresa.setPorte_empresa(porte_empresa);
                empresa.setId_empresa(Math.toIntExact(id_empresa));
                empresa.setCnpj(cnpj);
                empresa.setTelefone(telefone);
                return empresa;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.fecharConexao();
        }

        return null;
    }


}









