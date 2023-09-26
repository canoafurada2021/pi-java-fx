package controle;

import java.util.ArrayList;

import modelo.Categoria;

public interface ICategoriaDAO {

	public ArrayList<Categoria> listar();
	public boolean inserir(Categoria c);
	public boolean excluir (Categoria ca);
}
