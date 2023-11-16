package controle;

import java.sql.*;
import java.util.ArrayList;

import modelo.Endereco;

public class EnderecoDAO implements  IEnderecoDAO{


    public boolean inserir(Endereco e) {
        Conexao c = Conexao.getInstancia();
        Connection con = c.conectar();

        String query = "INSERT INTO endereco (cep,  rua, bairro, cidade, estado) VALUES (?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, Long.toString(e.getCep()));
            ps.setString(2, e.getRua());
            ps.setString(3, e.getBairro());
            ps.setString(4, e.getCidade());
            ps.setString(5, e.getEstado());

  return true;

        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            c.fecharConexao();
        }
    return false;
    }

    public ArrayList<Endereco> listar() {

        ArrayList<Endereco> enderecos = new ArrayList<>();

        Conexao c = Conexao.getInstancia();
        Connection con = c.conectar();

        String query = "SELECT * FROM endereco";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String rua = rs.getString("rua");
                String estado = rs.getString("estado");

                String bairro = rs.getString("bairro");

                String cidade = rs.getString("cidade");

                Long cep = rs.getLong("cep");

                Endereco e = new Endereco();
                e.setBairro(bairro);
                e.setId(id);
                e.setRua(rua);
                e.setCidade(cidade);
                e.setEstado(estado);
                e.setCep(cep);

                enderecos.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.fecharConexao();
        }

        return enderecos; // Retorna null se não encontrar o endereço
    }

    public boolean excluir(int enderecoId) {
        Conexao c = Conexao.getInstancia();
        Connection con = c.conectar();

        String query = "DELETE FROM endereco WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, enderecoId);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                c.fecharConexao();
                return true; // Indica que o endereço foi excluído com sucesso
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.fecharConexao();
        }

        return false; // Indica que a exclusão falhou
    }

}
