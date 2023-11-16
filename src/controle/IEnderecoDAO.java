package controle;

import modelo.Endereco;

import java.util.ArrayList;

public interface IEnderecoDAO {
    public boolean inserir(Endereco e) ;

    public ArrayList<Endereco> listar();

    public boolean excluir(int enderecoId);






    }
