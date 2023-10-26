package application;

import controle.EmpresaDAO;
import modelo.Empresa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmpresaDAOTest {

    private EmpresaDAO daoEmpresa;
    private Empresa empresaTeste;

    @BeforeEach
    public void setUp(){
        daoEmpresa = new EmpresaDAO();
        empresaTeste = new Empresa();
        empresaTeste.setPorte_empresa("Grande");
        empresaTeste.setIdEmpresa(1);
        empresaTeste.setNome("Get That Auto");
        empresaTeste.setCnpj(12345678911234);
        empresaTeste.setNome_fantasia("GTA");
        empresaTeste.setRazao_social("Deixar as pessoas felizes");
        empresaTeste.setTelefone(47992998877);
        empresaTeste.setTipoAcesso(1);
    }

    @Test
    @Order(1)
    public void testAtualizarEmpresa(){
        daoEmpresa.inserir(empresaTeste);

        daoEmpresa = new EmpresaDAO();
        empresaTeste = new Empresa();
        empresaTeste.setPorte_empresa("Grande");
        empresaTeste.setNome("Get That Auto");
        empresaTeste.setNome_fantasia("GTA");

        assertTrue(daoEmpresa.atualizar(empresaTeste));
    }

    @Test
    @Order(1)
    public void testAtualizarEmpresaErrado(){
        daoEmpresa.inserir(empresaTeste);

        daoEmpresa = new EmpresaDAO();
        empresaTeste = new Empresa();
        empresaTeste.setPorte_empresa(null);
        empresaTeste.setNome(null);
        empresaTeste.setNome_fantasia(null);

        assertFalse(daoEmpresa.atualizar(empresaTeste));
    }

}