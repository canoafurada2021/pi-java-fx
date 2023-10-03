package testes;

import controle.CategoriaDAO;
import modelo.Categoria;

public class CategoriaDAOTest {

	@Test
	public void TestListarCategoria() {
		Categoria c = new Categoria();
		c.setCategoria("andri");

		CategoriaDAO dao = new CategoriaDAO();
		boolean inserirok = dao.inserir(null);
//		assertEquals(false, inserirok);
		
		
	}
}
