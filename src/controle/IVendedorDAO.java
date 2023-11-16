package controle;

import modelo.Vendedor;

import java.util.ArrayList;

public interface IVendedorDAO {

    public ArrayList<Vendedor> listar();

    public boolean inserir(Vendedor v);

    public boolean excluir(Vendedor v);

    public boolean atualizar(Vendedor v);
    }
