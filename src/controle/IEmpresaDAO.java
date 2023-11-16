package controle;

import modelo.Empresa;

import java.util.ArrayList;

public interface IEmpresaDAO {
     public ArrayList<Empresa> listar();

    public boolean inserir(Empresa e);
    public boolean atualizar(Empresa e) ;






    }
