package application;

import java.util.ArrayList;
import java.util.List;

import controle.*;
import modelo.Categoria;
import modelo.Endereco;
import modelo.Fornecedor;
import modelo.Veiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VeiculoDAOTest {
    private VeiculoDAO daoVeiculo;
    private FornecedorDAO daoFornecedor;

    private CategoriaDAO daoCategoria;
    private EnderecoDAO daoEndereco;


    @BeforeEach
    public void setUpDatabase(){
        daoVeiculo = new VeiculoDAO();
        daoFornecedor = new FornecedorDAO();
        daoCategoria = new CategoriaDAO();
        daoEndereco = new EnderecoDAO();
    }

    @Test
    @Order(1)
    public void TestInserirVeiculo() {
        ArrayList<Endereco> enderecos = daoEndereco.listar();
        Endereco endereco = null;
        if (!enderecos.isEmpty()){
             endereco = enderecos.get((int) (Math.random() * enderecos.size()));
        }

        ArrayList<Fornecedor> fornecedores = daoFornecedor.listar();
        Fornecedor fornecedor = null;
        if (!fornecedores.isEmpty()){
            fornecedor = fornecedores.get((int) (Math.random() * fornecedores.size()));
        }

        ArrayList<Categoria> categorias = daoCategoria.listar();
        Categoria categoria = null;
        if (!categorias.isEmpty()){
             categoria = categorias.get((int) (Math.random() * categorias.size()));
        }

        if (categoria != null && fornecedor != null && categoria != null){
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
            v.setFornecedor(fornecedor);

            v.setCategoria(categoria);
            boolean passou = daoVeiculo.inserir(v);
            assertTrue(passou);

        }
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
        ArrayList<Veiculo> veiculos = daoVeiculo.listar();
        if (!veiculos.isEmpty()){
           Veiculo veiculo = veiculos.get((int) (Math.random() * veiculos.size()));

           veiculo.setNome("Novo Nome");
           boolean atualizou = daoVeiculo.atualizar(veiculo);
           assertTrue(atualizou);
        }

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

        Fornecedor f = new Fornecedor();
        f.setCnpj(12345678901234l);

        VeiculoDAO dao = new VeiculoDAO();
        boolean deletou = dao.excluir(v.getId_veiculo());
        assertTrue (true, String.valueOf(deletou));

    }



}
