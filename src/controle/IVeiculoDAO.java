package controle;

import modelo.Veiculo;

import java.util.ArrayList;

public interface IVeiculoDAO {

    public ArrayList<Veiculo> listar();

    public boolean inserir(Veiculo veiculo, byte[] imagemBytes);

    public boolean excluir(int idVeiculo);

    public boolean atualizar(Veiculo veiculo);
    }
