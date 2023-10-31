package application;

import controle.CategoriaDAO;
import modelo.Categoria;
import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void testInserirCategoria() {
        Categoria categoria = new Categoria();
        categoria.setCategoria("Nova Categoria");

        boolean inseriuOk = categoriaDAO.inserir(categoria);
        assertTrue(inseriuOk);
    }

    @Test
    void testListarCategorias() {
        ArrayList<Categoria> categorias = categoriaDAO.listar();
        assertNotNull(categorias);
        assertFalse(categorias.isEmpty());
    }

    @Test
    void testAtualizarCategoria() {
        // Primeiro, insira uma categoria para atualizar
        Categoria categoria = new Categoria();
        categoria.setCategoria("Categoria a ser atualizada");
        categoriaDAO.inserir(categoria);

        // Em seguida, atualize a categoria
        categoria.setCategoria("Categoria Atualizada");
        boolean atualizouOk = categoriaDAO.atualizar(categoria);
        assertTrue(atualizouOk);
    }

    @Test
    void testExcluirCategoria() {
        Categoria categoria = new Categoria();
        // Preencha a categoria com os dados necessários, incluindo o campo idCategoria

        boolean excluiuOk = categoriaDAO.excluir(categoria);

        // Verifica se a exclusão foi bem-sucedida ou se o registro não existia
        assertTrue(excluiuOk, "A exclusão falhou ou o registro não existia");
    }

}