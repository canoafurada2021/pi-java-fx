package application;

import controle.FornecedorDAO;
import controle.LocadorDAO;
import modelo.Fornecedor;
import modelo.Locador;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertTrue;
public class FornecedorDAOTest {

    private FornecedorDAO daoFornecedor;


    @Order(1)
    @Test
    public  void TestInserirFornecedor(){
        Fornecedor f = new Fornecedor();

        daoFornecedor.inserir(f);
    }

}
