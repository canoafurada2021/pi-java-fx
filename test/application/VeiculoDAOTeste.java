package application;

import java.sql.Date;
import controle.VendedorDAO;
import modelo.Vendedor;

public class VeiculoDAOTeste{
    private VeiculoDAO daoVeiculo;

    @Test
    @Order(1)
    public void TesteListarVeiculo() {
        Veiculo v = new Veiculo();

        v.setQuant_assento(quantAssento);
        v.setTipo_cambio(tipoCambio);
        v.setQuant_portas(quantPortas);
        v.setEspaco_porta_malas(espacoPortaMalas);
        v.setMarca(marca);
        v.setNome(nome);
        v.setCor(cor);
        v.setAno(ano);
        v.setNota_avaliacao(notaAvaliacao);
        v.setPreco_por_dia(precoPorDia);
        v.setUnidade_em_estoque(unidadeEmEstoque);

        VeiculoDAO dao = new VeiculoDAO();
        List<Veiculo> passou = dao.listar();

    }

    @Test
    @Order(2)
    public void TesteInserirVeiculo() {
        Veiculo v = new Veiculo();

        v.setQuant_assento((int) 5);
        v.setTipo_cambio("Automático");
        v.setQuant_portas((int) 4);
        v.setEspaco_porta_malas((int) 400);
        v.setMarca("Mercedes");
        v.setNome("EQB SUV");
        v.setCor("Preto");
        v.setAno((int) 2020);
        v.setNota_avaliacao((boolean)5.0);
        v.setPreco_por_dia((boolean)200.00);
        v.setUnidade_em_estoque((int)100);

        VeiculoDAO dao = new VeiculoDAO();
        boolean passou = dao.inserir(v);
        assertTrue(passou);

    }

    @Test
    public void TesteExcluirVeiculo() {
        Veiculo v = new Veiculo();

        v.setQuant_assento((int) 5);
        v.setTipo_cambio("Automático");
        v.setQuant_portas((int) 4);
        v.setEspaco_porta_malas((int) 400);
        v.setMarca("Mercedes");
        v.setNome("EQB SUV");
        v.setCor("Preto");
        v.setAno((int) 2020);
        v.setNota_avaliacao((boolean)5.0);
        v.setPreco_por_dia((boolean)200.00);
        v.setUnidade_em_estoque((int)100);

        VeiculoDAO dao = new VeiculoDAO();
        boolean deletou = dao.exluir(v);
        assertTrue (true, deletou);

    }

    @Test
    public void TesteAtualizarVeiculo() {
        Veiculo v = new Veiculo();

        v.setQuant_assento((int) 5);
        v.setTipo_cambio("Automático");
        v.setQuant_portas((int) 4);
        v.setEspaco_porta_malas((int) 400);
        v.setMarca("Mercedes");
        v.setNome("EQB SUV");
        v.setCor("Preto");
        v.setAno((int) 2020);
        v.setNota_avaliacao((boolean)5.0);
        v.setPreco_por_dia((boolean)200.00);
        v.setUnidade_em_estoque((int)100);


        VeiculoDAO dao = new VeiculoDAO();
        boolean atualizado = dao.atulaizar(v);
        assertTrue (true, atualizado);

    }

}
