package controle;

import modelo.Fornecedor;

import java.util.ArrayList;

public interface IFornecedorDAO {

    public ArrayList<Fornecedor> listar();

    public boolean inserir(Fornecedor f);

    public boolean excluir(Fornecedor f);

    public boolean atualizar(Fornecedor f);
    }
