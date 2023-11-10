package controle;

import java.util.ArrayList;

import modelo.Categoria;

public interface ICategoriaDAO {

	public ArrayList<Categoria> listar();
	public Long inserir(Categoria c);
	public boolean excluir (Categoria ca);
}
