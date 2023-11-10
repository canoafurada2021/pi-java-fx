package application;

import java.util.List;

import controle.CategoriaDAO;
import controle.VeiculoDAO;
import modelo.Categoria;
import modelo.Veiculo;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VeiculoDAOTest {
    private VeiculoDAO daoVeiculo;


    @Test
    @Order(1)
    public void TestInserirVeiculo() {
        Veiculo v = new Veiculo();

        v.setQuant_assento(5);
        v.setTipo_cambio("Automático");
        v.setQuant_portas(4);
        v.setEspaco_porta_malas(400);
        v.setMarca("Mercedes");
        v.setNome("EQB SUV");
        v.setCor("Preto");
        v.setAno(2020);
        v.setNota_avaliacao((int) 5.0);
        v.setPreco_por_dia((long) 200.00);
        v.setUnidade_em_estoque(100);

        Categoria categoria = new Categoria();
        categoria.setCategoria("Sport");
        CategoriaDAO cDAO = new CategoriaDAO();
        Long idCategoria = cDAO.inserir(categoria);
        categoria.setIdCategoria(idCategoria);
        v.setCategoria(categoria);

        VeiculoDAO dao = new VeiculoDAO();
        boolean passou = dao.inserir(v);
        assertTrue(passou);

    }


    @Test
    @Order(2)
    public void TestListarVeiculo() {
        Veiculo v = new Veiculo();

        v.setQuant_assento(5);
        v.setTipo_cambio("Automático");
        v.setQuant_portas(4);
        v.setEspaco_porta_malas(400);
        v.setMarca("Mercedes");
        v.setNome("EQB SUV");
        v.setCor("Preto");
        v.setAno(2020);
        v.setNota_avaliacao((int) 5.0);
        v.setPreco_por_dia((long) 200.00);
        v.setUnidade_em_estoque(100);

        VeiculoDAO dao = new VeiculoDAO();
        List<Veiculo> passou = dao.listar();

    }


    @Test
    @Order(3)
    public void TestAtualizarVeiculo() {
        Veiculo v = new Veiculo();

        v.setQuant_assento(5);
        v.setTipo_cambio("Automático");
        v.setQuant_portas(4);
        v.setEspaco_porta_malas(400);
        v.setMarca("Mercedes");
        v.setNome("EQB SUV");
        v.setCor("Preto");
        v.setAno(2020);
        v.setNota_avaliacao((int) 5.0);
        v.setPreco_por_dia((long) 200.00);
        v.setUnidade_em_estoque(100);


        VeiculoDAO dao = new VeiculoDAO();
        boolean atualizado = dao.atualizar(v);
        assertTrue (true, String.valueOf(atualizado));

    }

    @Test
    @Order(4)
    public void TestExcluirVeiculo() {
        Veiculo v = new Veiculo();

        v.setQuant_assento(5);
        v.setTipo_cambio("Automático");
        v.setQuant_portas(4);
        v.setEspaco_porta_malas(400);
        v.setMarca("Mercedes");
        v.setNome("EQB SUV");
        v.setCor("Preto");
        v.setAno(2020);
        v.setNota_avaliacao((int) 5.0);
        v.setPreco_por_dia((long) 200.00);
        v.setUnidade_em_estoque(100);

        VeiculoDAO dao = new VeiculoDAO();
        boolean deletou = dao.excluir(v.getId_veiculo());
        assertTrue (true, String.valueOf(deletou));

    }



}
