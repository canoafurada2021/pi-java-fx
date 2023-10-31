package application;

import controle.VeiculoDAO;
import modelo.Veiculo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VeiculoDAOTeste {
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
        daoVeiculo.inserir(veiculoTeste);

        assertFalse(daoVeiculo.listar().isEmpty());
    }

    @Test
    @Order(3)
    public void testeAtualizarVeiculo() {
        daoVeiculo.inserir(veiculoTeste);

        veiculoTeste.setQuant_assento(4);
        veiculoTeste.setTipo_cambio("Manual");
        veiculoTeste.setQuant_portas(2);
        veiculoTeste.setEspaco_porta_malas(200);
        veiculoTeste.setMarca("Volkswagen");
        veiculoTeste.setNome("Polo");
        veiculoTeste.setCor("Prata");

        assertTrue(daoVeiculo.atualizar(veiculoTeste));
    }

    @Test
    @Order(4)
    public void testExcluirVeiculo() {
        daoVeiculo.inserir(veiculoTeste);

        assertTrue(daoVeiculo.excluir(veiculoTeste.getId_veiculo()));
    }

    @AfterEach
    public void tearDown() { daoVeiculo.excluir(veiculoTeste.getId_veiculo());}

}