
//package application;
//
//import java.sql.Date;
//import controle.VendedorDAO;
//import modelo.Vendedor;
//
//public class VendedorDAOTeste{
//    private VendedorDAO daoVendedor;
//
//    @Test
//    @Order(1)
//    public void TesteListarVendedor() {
//        Data data = new Date(2030-04-04);
//        Vendedor v = new Vendedor();
//
//        v.setNome(nome);
//        v.setSobrenome(sobrenome);
//        v.setSalario(salario);
//        v.setCpf(cpf);
//        v.setSenha(senha);
//        v.setTipoAcesso(tipoAcesso);
//
//        VendedorDAO dao = new VendedorDAO();
//        List<Vendedor> passou = dao.listar();
//
//    }
//
//    @Test
//    @Order(2)
//    public void TesteInserirVendedor() {
//        Data data = new Date(2030-04-04);
//        Vendedor v = new Vendedor();
//
//        v.setNome("Emily");
//        v.setSobrenome("Snow");
//       // v.setSalario((int)1500);
//       // v.setCpf((long)11011011010);
//        v.setSenha("Senha1234567");
//       // v.setTipoAcesso((int)1);
//
//        VendedorDAO dao = new VendedorDAO();
//        boolean passou = dao.inserir(v);
//        assertTrue(passou);
//
//    }
//
//    @Test
//    @Order(3)
//    public void TesteExcluirVendedor() {
//        Data data = new Date(2030-04-04);
//        Vendedor v = new Vendedor();
//
//        v.setNome("Emily");
//        v.setSobrenome("Snow");
//        v.setSalario((int)1500);
//        v.setCpf((long)11011011010);
//        v.setSenha("Senha1234567");
//        v.setTipoAcesso((int)1);
//
//        VendedorDAO dao = new VendedorDAO();
//        boolean deletou = dao.exluir(v);
//        assertTrue (true, deletou);
//
//    }
//
//    @Test
//    @Order(4)
//    public void TesteAtualizarVendedor() {
//        Data data = new Date(2030-04-04);
//        Vendedor v = new Vendedor();
//
//        v.setNome("Emily");
//        v.setSobrenome("Snow");
//        v.setSalario((int)1500);
//        v.setCpf((long)11011011010);
//        v.setSenha("Senha1234567");
//        v.setTipoAcesso((int)1);
//
//        VendedorDAO dao = new VendedorDAO();
//        boolean atualizado = dao.atulaizar(v);
//        assertTrue (true, atualizado);
//
//    }
//
//}
