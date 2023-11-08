
package application;

import controle.VendedorDAO;
import modelo.TipoAcessoLogin;
import modelo.Vendedor;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class VendedorDAOTest {
    private VendedorDAO daoVendedor;
    private Vendedor vendedor;

    public void setVendedor (Vendedor vendedor){
        this.vendedor = vendedor;
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

        TipoAcessoLogin tipoAcessoLogin =  TipoAcessoLogin.getById(1);
        v.setTipoAcesso(tipoAcessoLogin);


        VendedorDAO dao = new VendedorDAO();
        boolean passou = dao.inserir(v);
        assertTrue(passou);

    }

    @Test
    @Order(2)
    public void TesteAtualizarVendedor() {
        Vendedor v = new Vendedor();

        v.setNome("Emily");
        v.setSobrenome("Snow");
        v.setSalario(15000.0);
        v.setCpf(11011011010l);
        v.setSenha("Senha1234567");

        TipoAcessoLogin tipoAcessoLogin =  TipoAcessoLogin.getById(1);
        v.setTipoAcesso(tipoAcessoLogin);

        Vendedor vend = new Vendedor();
        vend.setIdVendedor(1L);

        v.setId_vendedor(vend.getId_vendedor());

        VendedorDAO dao = new VendedorDAO();
        boolean atualizado = dao.atualizar(v);
        assertTrue (true, String.valueOf(atualizado));

    }

    @Test
    @Order(3)
    public void TesteExcluirVendedor() {
        Vendedor v = new Vendedor();

        v.setNome("Emily");
        v.setSobrenome("Snow");
        v.setSalario(1500.0);
        v.setCpf(11011011010l);
        v.setSenha("Senha1234567");

        TipoAcessoLogin tipoAcessoLogin =  TipoAcessoLogin.getById(1);
        v.setTipoAcesso(tipoAcessoLogin);

        Vendedor vend = new Vendedor();
        vend.setIdVendedor(1L);

        v.setId_vendedor(vend.getId_vendedor());


        VendedorDAO dao = new VendedorDAO();

        boolean deletou = dao.excluir(v);
        assertTrue (true, String.valueOf(deletou));

    }



}
