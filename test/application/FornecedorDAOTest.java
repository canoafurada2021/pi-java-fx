package application;

import static org.junit.jupiter.api.Assertions.*;

import controle.EnderecoDAO;
import controle.FornecedorDAO;
import modelo.Endereco;
import modelo.Fornecedor;
import org.junit.jupiter.api.*;



        public class FornecedorDAOTest {

            private FornecedorDAO daoFornecedor;
            private EnderecoDAO enderecoDAO;
            private Fornecedor fornecedorTeste;

            private Endereco enderecoTeste;

            @BeforeEach
            public void setUp() {
                daoFornecedor = new FornecedorDAO();
                enderecoDAO = new EnderecoDAO();
            }

            @Test
            public void testInserirFornecedor() {
                // 1. Crie um endereço e insira-o no banco de dados
                Endereco enderecoExistente = new Endereco();
                enderecoExistente.setRua("Rua de Teste");
                enderecoExistente.setBairro("bairro teste");
                enderecoExistente.setCep(23434);
                enderecoExistente.setEstado("puta que pariu");
                enderecoExistente.setCidade("rjqowrkjqw");
                // Outros atributos do endereço, se necessário

                // Insira o endereço no banco de dados
                boolean enderecoInserido = enderecoDAO.inserir(enderecoExistente);
                assertTrue(enderecoInserido, "Falha ao inserir o endereço");

                // 2. Crie um objeto de fornecedor e associe-o ao endereço pelo ID
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setEnderecoId(enderecoExistente); // Associe o endereço inserido
                fornecedor.setNome("Fornecedor Teste");
                fornecedor.setCnpj(424324L);
                fornecedor.setTelefone(47984273688L);
                fornecedor.setAtividades("Atividades de Teste");

                // 3. Inserir o fornecedor no banco de dados
                boolean fornecedorInserido = daoFornecedor.inserir(fornecedor);
              //  assertTrue(fornecedorInserido, "Falha ao inserir o fornecedor");
            }

            @Test
            @Order(2)
            public void testListarFornecedores() {
                // Inserir o fornecedor de teste para listar
                daoFornecedor.listar();

                // Verificar se a lista de fornecedores não está vazia
                assertFalse(daoFornecedor.listar().isEmpty());
            }

            @Test
            @Order(3)
            public void testAtualizarFornecedor() {
                // Inserir o fornecedor de teste
                //daoFornecedor.inserir(fornecedorTeste);

                // Atualizar os detalhes do fornecedor de teste
                fornecedorTeste.setNome("Novo Nome de Teste");
                fornecedorTeste.setTelefone(987654321L);
                fornecedorTeste.setAtividades("Novas Atividades de Teste");

                assertTrue(daoFornecedor.atualizar(fornecedorTeste));
            }

            @Test
            @Order(4)
            public void testExcluirFornecedor() {
                // Inserir o fornecedor de teste
               // daoFornecedor.inserir(fornecedorTeste);

                assertTrue(daoFornecedor.excluir(fornecedorTeste));
            }

            @AfterEach
            public void tearDown() {
                // Limpar o banco de dados após os testes
                if (enderecoTeste != null) {
                    enderecoDAO.excluir(enderecoTeste.getId());
                }

                if (fornecedorTeste != null) {
                    daoFornecedor.excluir(fornecedorTeste);
                }
            }


        }



