package application;

import java.sql.Date;

import controle.VeiculoDAO;
import controle.VendedorDAO;
import modelo.TipoAcessoLogin;
import modelo.Vendedor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VendedorDAOTeste{
    private VendedorDAO daoVendedor;

    private Vendedor vendedorTest;

    @Test
    @BeforeEach
        public void setUp() {
        daoVendedor = new VendedorDAO();
        vendedorTest = new Vendedor();

        vendedorTest.setNome("Emily");
        vendedorTest.setSobrenome("Snow");
        vendedorTest.setSalario(1500.00);
        vendedorTest.setCpf((long) 11011011010L);
        vendedorTest.setSenha("Senha1234");
        vendedorTest.setTipoAcesso(TipoAcessoLogin.getById(1));
    }

    @Test
    @Order(1)
    public void TesteInserirVendedor() {
        assertTrue(daoVendedor.inserir(vendedorTest));
    }

    @Test
    @Order(2)
    public void TesteAtualizarVendedor() {
        daoVendedor.inserir(vendedorTest);

        vendedorTest.setNome("Fernanda");
        vendedorTest.setSobrenome("Souza");

        assertTrue(daoVendedor.atualizar(vendedorTest));
    }

    @Test
    @Order(3)
        public void TesteExcluirVendedor() {
        daoVendedor.inserir(vendedorTest);

        assertTrue(daoVendedor.excluir(vendedorTest));
    }

    @AfterEach
    public void tearDown(){daoVendedor.excluir(vendedorTest);}

}
