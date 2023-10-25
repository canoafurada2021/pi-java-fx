package application;

import static org.junit.jupiter.api.Assertions.*;

import controle.FornecedorDAO;
import modelo.Endereco;
import modelo.Fornecedor;
import org.junit.jupiter.api.*;

public class FornecedorDAOTest {

    private FornecedorDAO daoFornecedor;
    private Fornecedor fornecedorTeste;

    @BeforeEach
    public void setUp() {

        Endereco enderecoTeste = new Endereco();
        enderecoTeste.setRua("Rua Florianópolis");
        enderecoTeste.setBairro("Bela Vista");
        enderecoTeste.setCidade("Gaspar");
        enderecoTeste.setEstado("Santa Catarina");
        enderecoTeste.setCep(89111042);


        // Inicializar o DAO e criar um fornecedor de teste
        daoFornecedor = new FornecedorDAO();
        fornecedorTeste = new Fornecedor();
        fornecedorTeste.setCnpj(1234567890L);
        fornecedorTeste.setEnderecoId(enderecoTeste);
        fornecedorTeste.setNome("Fornecedor de Teste");
        fornecedorTeste.setAtividades("Atividades de Teste");
        fornecedorTeste.setTelefone(1234567890L);
    }

    @Test
    @Order(1)
    public void testInserirFornecedor() {
        assertTrue(daoFornecedor.inserir(fornecedorTeste));
    }

    @Test
    @Order(2)
    public void testListarFornecedores() {
        // Inserir o fornecedor de teste para listar
        daoFornecedor.inserir(fornecedorTeste);

        // Verificar se a lista de fornecedores não está vazia
        assertFalse(daoFornecedor.listar().isEmpty());
    }

    @Test
    @Order(3)
    public void testAtualizarFornecedor() {
        // Inserir o fornecedor de teste
        daoFornecedor.inserir(fornecedorTeste);

        // Atualizar os detalhes do fornecedor de teste
        fornecedorTeste.setNome("Novo Nome de Teste");
        fornecedorTeste.setTelefone(987654321L);
        fornecedorTeste.setAtividades("Novas Atividades de Teste");

        assertTrue(daoFornecedor.atualizar(fornecedorTeste));
    }

    @Test
    @Order(4)
    public void testExcluirFornecedor() {
        daoFornecedor.inserir(fornecedorTeste);

        assertTrue(daoFornecedor.excluir(fornecedorTeste));
    }

    @AfterEach
    public void tearDown() {
        daoFornecedor.excluir(fornecedorTeste);
    }
}
