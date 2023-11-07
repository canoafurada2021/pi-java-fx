//
//package application;
//
//import controle.VendedorDAO;
//import modelo.TipoAcessoLogin;
//import modelo.Vendedor;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class VendedorDAOTest {
//    private VendedorDAO daoVendedor;
//
//
//    @Test
//    @Order(1)
//    public void TesteInserirVendedor() {
//        Vendedor v = new Vendedor();
//
//        v.setNome("Emily");
//        v.setSobrenome("Snow");
//        v.setSalario((double)1500);
//        v.setCpf((long) 11011011010);
//        v.setSenha("Senha1234567");
//
//        TipoAcessoLogin tipoAcessoLogin =  TipoAcessoLogin.getById(1);
//        v.setTipoAcesso(tipoAcessoLogin);
//
//        VendedorDAO dao = new VendedorDAO();
//        boolean passou = dao.inserir(v);
//        assertTrue(passou);
//
//    }
//
//    @Test
//    @Order(2)
//    public void TesteExcluirVendedor() {
//        Vendedor v = new Vendedor();
//
//        v.setNome("Emily");
//        v.setSobrenome("Snow");
//        v.setSalario((double) 1500);
//        v.setCpf((long) 11011011010);
//        v.setSenha("Senha1234567");
//
//        TipoAcessoLogin tipoAcessoLogin =  TipoAcessoLogin.getById(1);
//        v.setTipoAcesso(tipoAcessoLogin);
//
//        VendedorDAO dao = new VendedorDAO();
//        dao.inserir(v);
//
//        boolean deletou = dao.excluir(v);
//        assertTrue (true, String.valueOf(deletou));
//
//    }
//
//    @Test
//    @Order(3)
//    public void TesteAtualizarVendedor() {
//        Vendedor v = new Vendedor();
//
//        v.setNome("Emily");
//        v.setSobrenome("Snow");
//        v.setSalario(15000.0);
//        v.setCpf(89L);
//        v.setSenha("Senha1234567");
//        TipoAcessoLogin tipoAcessoLogin =  TipoAcessoLogin.getById(1);
//        v.setTipoAcesso(tipoAcessoLogin);
//
//        VendedorDAO dao = new VendedorDAO();
//        dao.inserir(v);
//
//        boolean atualizado = dao.atualizar(v);
//        assertTrue (true, String.valueOf(atualizado));
//
//    }
//
//}
