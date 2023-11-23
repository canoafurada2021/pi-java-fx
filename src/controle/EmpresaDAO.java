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


        String query = "SELECT * FROM empresa LIMIT 1";
      //  Empresa empresa = null;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String nome_fantasia = rs.getString("nome_fantasia");
                String razao_social = rs.getString("razao_social");
                String porte_empresa = rs.getString("porte_empresa");
                int id_empresa = rs.getInt("id_empresa");
                Long cnpj = rs.getLong("cnpj");
                Long telefone = rs.getLong("telefone");

                int tipoAcessoId = rs.getInt("TipoAcessoLogin");
                TipoAcessoLogin tipoAcesso = TipoAcessoLogin.getById(tipoAcessoId);




                Empresa empresa = new Empresa();
                empresa.setNome_fantasia(nome_fantasia);
                empresa.setRazao_social(razao_social);
                empresa.setPorte_empresa(porte_empresa);
                empresa.setIdEmpresa(id_empresa);
                empresa.setCnpj(cnpj);
                empresa.setTelefone(telefone);
                empresa.setTipoAcesso(tipoAcesso);

                System.out.println("empresa:" + empresa.getIdEmpresa());

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









