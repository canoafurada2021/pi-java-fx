package controle;

import modelo.Locador;

import java.util.ArrayList;

public interface ILocadorDAO {
    public ArrayList<Locador> listar() ;

    public boolean inserir(Locador l);

    public boolean atualizar(Locador l);

    public boolean excluir(Locador l);

    }
