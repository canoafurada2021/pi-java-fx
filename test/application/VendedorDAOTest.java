package application;

import controle.VendedorDAO;
import modelo.Endereco;
import modelo.TipoAcessoLogin;
import modelo.Vendedor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VendedorDAOTest {
    private VendedorDAO daoVendedor;

    @BeforeEach
    public void setUpDatabase() {
        daoVendedor = new VendedorDAO();
    }

    @Test
    @Order(1)
    public void TesteInserirVendedor() {
        Vendedor v = new Vendedor();

        v.setNome("Emily");
        v.setSobrenome("Snow");
        v.setSalario(1500.0);
        v.setCpf(11011011010l);
        v.setSenha("Senha1234567");
        v.setTipoAcesso(TipoAcessoLogin.FUNCIONARIO);

        boolean passou = daoVendedor.inserir(v);
        assertTrue(passou);

    }


    @Test
    @Order(2)
    public void TesteAtualizarVendedor() {
        ArrayList<Vendedor> vendedores = daoVendedor.listar();
        Vendedor vendedor = null;
        if (!vendedores.isEmpty()) {
            vendedor = vendedores.get((int) (Math.random() * vendedores.size()));

            vendedor.setNome("João");
            boolean atualizado = daoVendedor.atualizar(vendedor);
            assertTrue(true, String.valueOf(atualizado));
        }

    }

    @Test
    @Order(3)
    public void TesteExcluirVendedor() {
        ArrayList<Vendedor> vendedores = daoVendedor.listar();
        Vendedor vendedor = null;
        if (!vendedores.isEmpty()) {
            vendedor = vendedores.get((int) (Math.random() * vendedores.size()));

            vendedor.setNome("João");
            boolean excluido = daoVendedor.excluir(vendedor);
            assertTrue(true, String.valueOf(excluido));
        }

    }
}
