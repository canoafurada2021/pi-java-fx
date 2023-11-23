package controle;

import java.sql.*;
import java.util.ArrayList;

import modelo.TipoAcessoLogin;
import modelo.Locador;

public class LocadorDAO implements ILocadorDAO{


    public ArrayList<Locador> listar() {
        Conexao c = Conexao.getInstancia();
        Connection con = c.conectar();

        String query = "SELECT * FROM locador";
        ArrayList<Locador> locadores = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Locador l = new Locador();

                l.setPessoas_cpf(rs.getString("pessoas_cpf"));
                l.setNome(rs.getString("nome"));
                l.setSobrenome(rs.getString("sobrenome"));
                l.setTelefone(rs.getLong("telefone"));
                l.setPaisResidencia(rs.getString("pais_residencia"));
                l.setCnh(rs.getLong("cnh"));
                l.setValidadeCarteira(rs.getString("validade_carteira"));


                l.setNumIdentificacaoCarteira(rs.getLong("num_identificacao_carteira"));

                System.out.println("locador" + l.getTipoAcesso());



                locadores.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception: " + e.getMessage());

        } finally {
            c.fecharConexao();
        }
        return locadores;
    }

    public boolean inserir(Locador l) {
        Conexao c = Conexao.getInstancia();
        Connection con = c.conectar();

        String query = "INSERT INTO locador " +
                "(pessoas_cpf, nome, sobrenome, telefone, pais_residencia, cnh, validade_carteira, num_identificacao_carteira, TipoAcessoLogin) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, l.getPessoas_cpf());
            ps.setString(2, l.getNome());
            ps.setString(3, l.getSobrenome());
            ps.setLong(4, l.getTelefone());
            ps.setString(5, l.getPaisResidencia());
            ps.setLong(6, l.getCnh());
            ps.setString(7, l.getValidadeCarteira());
            ps.setLong(8, l.getNumIdentificacaoCarteira());
            ps.setInt(6, TipoAcessoLogin.CLIENTE.getId());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.fecharConexao();
        }

        return false;
    }

    public boolean atualizar(Locador l) {
        Conexao c = Conexao.getInstancia();
        Connection con = c.conectar();

        String query = "UPDATE locador SET " +
                "nome = ?, sobrenome = ?, telefone = ?, pais_residencia = ?, cnh = ?, validade_carteira = ?, num_identificacao_carteira = ? " +
                "WHERE pessoas_cpf = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, l.getNome());
            ps.setString(2, l.getSobrenome());
                ps.setLong(3, l.getTelefone());
              ps.setString(4, l.getPaisResidencia());
            ps.setLong(5, l.getCnh());
            ps.setString(6, l.getValidadeCarteira());
            ps.setLong(7, l.getNumIdentificacaoCarteira());
            ps.setString(8, l.getPessoas_cpf());

            int rowsUpdated = ps.executeUpdate();

            System.out.println("Query parametros: ");

            System.out.println("nome: " + l.getNome());
            System.out.println("sobrenome: " + l.getSobrenome());
            System.out.println("telefone: " + l.getTelefone());
            System.out.println("pais: " + l.getPaisResidencia());
            System.out.println("cnh: " + l.getCnh());
            System.out.println("validade carteira: " + l.getValidadeCarteira());
            System.out.println("identificacao carteira: " + l.getNumIdentificacaoCarteira());


            if (rowsUpdated > 0) {
                // Os dados foram atualizados com sucesso
                return true;
            } else {
                // Nenhum registro foi atualizado (o CPF pode não existir)
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            c.fecharConexao();
        }
    }

    public boolean excluir(Locador l) {
        Conexao c = Conexao.getInstancia();
        Connection con = c.conectar();


        String query = "DELETE FROM locador WHERE pessoas_cpf = ?";

        try {


            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, l.getPessoas_cpf());

            int rowsAffected = ps.executeUpdate();


            if (rowsAffected > 0) {
                c.fecharConexao();
                return true;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.fecharConexao();
        }

        return false;
    }


}








