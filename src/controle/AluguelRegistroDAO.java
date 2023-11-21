package controle;

import java.sql.*;
import java.util.ArrayList;

import modelo.AluguelRegistro;
import modelo.Locador;
import modelo.Vendedor;

public class AluguelRegistroDAO implements IAluguelRegistroDAO {

    public ArrayList<AluguelRegistro> listar() {
        Conexao c = Conexao.getInstancia();
        Connection con = c.conectar();
        ArrayList<AluguelRegistro> alugueis = new ArrayList<>();

        String query = "SELECT ar.id_venda, ar.forma_pagamento, ar.data_inicio, ar.quant_dias, ar.valor, v.id_vendedor, l.pessoas_cpf as locador_cpf "
                + "FROM aluguelRegistro ar "
                + "INNER JOIN locador l ON ar.locador_pessoas_cpf = l.pessoas_cpf "
                + "INNER JOIN vendedor v ON ar.vendedor_id_vendedor = v.id_vendedor";


        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                AluguelRegistro aluguel = new AluguelRegistro();

                Integer idRegistro = rs.getInt("id_venda");
                String formaPagamento = rs.getString("forma_pagamento");
                String dataInicio = rs.getString("data_inicio");
                int quantDias = rs.getInt("quant_dias");
                Double valor = rs.getDouble("valor");
                Integer idVendedor = rs.getInt("v.id_vendedor");
                String cpfLocador = rs.getString("locador_cpf");

                aluguel.setIdVenda(idRegistro);
                aluguel.setFormaPagamento(formaPagamento);
                aluguel.setDataInicio(dataInicio);
                aluguel.setQuantDias(quantDias);
                aluguel.setValor(valor);

                Vendedor vendedor = new Vendedor();
                vendedor.setId_vendedor(idVendedor);
                aluguel.setVendedor(vendedor);


                Locador locador = new Locador();
                locador.setPessoas_cpf(cpfLocador);
                aluguel.setLocador(locador);


                alugueis.add(aluguel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            c.fecharConexao();
        }

        return alugueis;
    }

    public boolean inserir(AluguelRegistro ar) {

        boolean insercaoSucesso = false;
        if (ar != null) {
            Conexao a = Conexao.getInstancia();
            Connection con = a.conectar();

            String query = "INSERT INTO aluguelRegistro (forma_pagamento, data_inicio, quant_dias, valor, vendedor_id_vendedor, locador_pessoas_cpf) "
                    + "VALUES (?, ?, ?, ?, ?, ?);";

            try {
                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, ar.getFormaPagamento());
                ps.setString(2, ar.getDataInicio());
                ps.setInt(3, ar.getQuantDias());
                ps.setDouble(4, ar.getValor());
                ps.setLong(5, ar.getIdVendedor().getId_vendedor());
                ps.setString(6, ar.getLocador().getPessoas_cpf());

                int linhasAfetadas = ps.executeUpdate();

                if (linhasAfetadas > 0) {
                    insercaoSucesso = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                a.fecharConexao();
            }
        }

        return insercaoSucesso;
    }

    public boolean excluir(AluguelRegistro ar) {
        Conexao c = Conexao.getInstancia();
        Connection con = c.conectar();

        String query = "DELETE FROM aluguelRegistro WHERE id_venda = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, ar.getIdVenda());

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

    public boolean atualizar(AluguelRegistro ar) {
        Conexao c = Conexao.getInstancia();
        Connection con = c.conectar();

        String query = "UPDATE aluguelRegistro SET forma_pagamento = ?, data_inicio = ?, quant_dias = ?,"
                + " valor = ?, vendedor_id_vendedor = ?, locador_pessoas_cpf = ?, fornecedor_cnpj = ? "
                + "WHERE id_venda = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, ar.getFormaPagamento());
            ps.setString(2, ar.getDataInicio());
            ps.setInt(3, ar.getQuantDias());
            ps.setDouble(4, ar.getValor());
            ps.setLong(5, ar.getIdVendedor().getId_vendedor());
            ps.setString(6, ar.getLocador().getPessoas_cpf());
            ps.setLong(7, ar.getFornecedor().getCnpj());
            ps.setInt(8, ar.getIdVenda());

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            c.fecharConexao();
        }
    }
}
