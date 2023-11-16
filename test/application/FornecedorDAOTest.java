package application;

import static org.junit.jupiter.api.Assertions.*;

import controle.EnderecoDAO;
import controle.FornecedorDAO;
import modelo.Endereco;
import modelo.Fornecedor;
import modelo.Locador;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Random;

public class FornecedorDAOTest {

    private static FornecedorDAO daoFornecedor;
    private static EnderecoDAO enderecoDAO;

    @BeforeEach
    public void setUpDatabase() {
        daoFornecedor = new FornecedorDAO();
        enderecoDAO = new EnderecoDAO();
    }


    public static long geraCepAleatorio(){
        Random r = new Random();

        return r.nextLong(1_000_000_000)
                + (r.nextInt(90) + 10) * 1_000_000_000L;
    }

    public static long gerarCnpjAleatorio(){
        Random r = new Random();

        return r.nextLong(1_000_000_000)
                + (r.nextInt(90) + 10) * 1_000_000_000L;
    }

    public static long gerarTelefoneAleatorio(){
        Random r = new Random();

        return r.nextLong(1_000_000_000)
                + (r.nextInt(90) + 10) * 1_000_000_000L;
    }

    @Test
    @Order(1)

    public void testInserirFornecedor() {

        ArrayList<Endereco> enderecos = enderecoDAO.listar();
        Endereco endereco = null;

        if(!enderecos.isEmpty()){
            endereco = enderecos.get((int) (Math.random() * enderecos.size()));

        }

        // 2. Crie um objeto de fornecedor e associe-o ao endereço pelo ID
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setEnderecoId(endereco); // Associe o endereço inserido
        fornecedor.setNome("Fornecedor Teste");
        fornecedor.setCnpj(gerarCnpjAleatorio());
        fornecedor.setTelefone(gerarTelefoneAleatorio());
        fornecedor.setAtividades("Atividades de Teste");

        // 3. Inserir o fornecedor no banco de dados
        boolean fornecedorInserido = daoFornecedor.inserir(fornecedor);
        assertTrue(fornecedorInserido, "Falha ao inserir o fornecedor");
    }

    @Test
    @Order(2)
    public void testListarFornecedores() {

        ArrayList<Fornecedor> locadores = daoFornecedor.listar();
        assertNotNull(locadores);
        assertTrue(locadores.size() > 0);
    }

    @Test
    @Order(3)
    public void testAtualizarFornecedor() {
        ArrayList<Fornecedor> fornecedores = daoFornecedor.listar();
        if (!fornecedores.isEmpty()) {
            // Escolha um locador aleatório para atualizar
            Fornecedor fornecedorParaAtualizar = fornecedores.get((int) (Math.random() * fornecedores.size()));

            // Atualize o locador
            String novoNome = "NovoNome";
            fornecedorParaAtualizar.setNome(novoNome);
            boolean alterouOk = daoFornecedor.atualizar(fornecedorParaAtualizar);
            assertTrue(alterouOk);
        }
    }

    @Test
    @Order(4)
    public void testExcluirFornecedor() {
        ArrayList<Fornecedor> fornecedores = daoFornecedor.listar();

        ArrayList<Endereco> enderecos = enderecoDAO.listar();



        if (!fornecedores.isEmpty()) {
            // Escolha um locador aleatório para excluir
            Fornecedor fornecedorParaExcluir = fornecedores.get((int) (Math.random() * fornecedores.size()));
            boolean excluiuOk = daoFornecedor.excluir(fornecedorParaExcluir);

            assertTrue(excluiuOk);
        }
    }


}
