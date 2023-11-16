package application;

import controle.CategoriaDAO;
import modelo.Categoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CategoriaDAOTest {
    private CategoriaDAO categoriaDAO;

    private Categoria categoriaTeste;

    @BeforeEach
    void setUp() {
        categoriaDAO = new CategoriaDAO();
        categoriaTeste = new Categoria();
        categoriaTeste.setCategoria("Categoria");
    }

    @Order(1)
    @Test
    void testInserirCategoria() {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(35);
        categoria.setCategoria("Nova Categoria");

        Integer inseriuOk = categoriaDAO.inserir(categoria);
        assertTrue(inseriuOk > 0);
    }

    @Order(2)
    @Test
    void testListarCategorias() {
        ArrayList<Categoria> categorias = categoriaDAO.listar();
        assertNotNull(categorias);
        assertFalse(categorias.isEmpty());
    }

    @Order(3)
    @Test
    void testAtualizarCategoria() {
        // Insere a categoria a ser atualizada
        Categoria categoria = new Categoria();
        categoria.setCategoria("Categoria da patricia linda");
        CategoriaDAO cDAO = new CategoriaDAO();
        Integer idCategoria = cDAO.inserir(categoria);

        categoria.setIdCategoria(idCategoria);
        categoria.setCategoria("Nova categoria teste");

        // Em seguida, atualiza a categoria
        boolean atualizouOk = categoriaDAO.atualizar(categoria);
        assertTrue(atualizouOk, "Falha na atualização da categoria");
    }


    @Order(4)
    @Test
    void testExcluirCategoria() {
        Categoria categoria = new Categoria();
        categoria.setCategoria("Teste Andrieli");

        CategoriaDAO cDAO = new CategoriaDAO();
        Integer idCategoria = cDAO.inserir(categoria);
        categoria.setIdCategoria(idCategoria);

        // Em seguida, tente excluir a categoria
        boolean excluiuOk = categoriaDAO.excluir(categoria);

        assertTrue(excluiuOk, "A exclusão falhou ou o registro não existia");
    }

}