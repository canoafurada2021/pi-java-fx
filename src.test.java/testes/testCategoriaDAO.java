package testes;

import controle.CategoriaDAO;
import modelo.Categoria;
//import static org.junit.jupiter.api.Assertions.assertEquals; 

public class testCategoriaDAO {

    private CategoriaDAO daoCategoria;

    @Test
    public void TestListarCategoria() {
        Categoria c = new Categoria();
        c.setCategoria("andri");

        CategoriaDAO dao = new CategoriaDAO();
        boolean inserirok = dao.inserir(c);

//        assertEquals(true, inserirok);
    }
}
