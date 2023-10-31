package application;

import controle.VeiculoDAO;
import modelo.Veiculo;
import org.junit.jupiter.api.*;


import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class VeiculoDAOTeste {

    @BeforeAll
    public static void setUpClass(){
        Connection connection = controle.Conexao.getInstancia().conectar();
    }

    @AfterAll
    public static void tearDownClass(){
        controle.Conexao.getInstancia().fecharConexao();
    }

    private VeiculoDAO daoVeiculo;
    private Veiculo veiculoTeste;

    @BeforeEach
    public void setUp() {
        daoVeiculo = new VeiculoDAO();
        veiculoTeste = new Veiculo();

        veiculoTeste.setQuant_assento(5);
        veiculoTeste.setTipo_cambio("Automático");
        veiculoTeste.setQuant_portas(4);
        veiculoTeste.setEspaco_porta_malas(400);
        veiculoTeste.setMarca("Mercedes");
        veiculoTeste.setNome("EQB SUV");
        veiculoTeste.setCor("Preto");
        veiculoTeste.setAno(2020);
        veiculoTeste.setNota_avaliacao((int) 5.0);
        veiculoTeste.setPreco_por_dia((long) 200.00);
        veiculoTeste.setUnidade_em_estoque(100);

    }

    @Test
    @Order(1)
    public void testInserirFornecedor() {
        assertTrue(daoVeiculo.inserir(veiculoTeste));
    }

    @Test
    @Order(2)
    public void testeListarVeiculo() {
        ArrayList<Veiculo> veiculos = daoVeiculo.listar();
        assertNotNull(veiculos);
        assertFalse(veiculos.isEmpty());
    }

    @Test
    @Order(3)
    public void testeAtualizarVeiculo() {
        Veiculo veiculo = new Veiculo();

            veiculo.setQuant_assento(4);
            veiculo.setTipo_cambio("Manual");
            veiculo.setQuant_portas(2);
            veiculo.setEspaco_porta_malas(200);
            veiculo.setMarca("Volkswagen");
            veiculo.setNome("Polo");
            veiculo.setCor("Prata");
            veiculo.setPreco_por_dia(0L);


        veiculo.setPreco_por_dia(1L);

        boolean updt = daoVeiculo.atualizar(veiculo);
        if (updt) {
            assertTrue(true, "Veículo atualizado");
        } else {
            assertTrue(false, "Veículo não encontrado para atualização");
        }
    }



    @Test
    @Order(4)
    public void testExcluirVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setId_veiculo(98);
        daoVeiculo.inserir(veiculoTeste);

        assertTrue(daoVeiculo.excluir(veiculoTeste.getId_veiculo()));
    }

    @AfterEach
    public void tearDown() { daoVeiculo.excluir(veiculoTeste.getId_veiculo());}

}