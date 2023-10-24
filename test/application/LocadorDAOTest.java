package application;

import controle.LocadorDAO;
import modelo.Locador;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocadorDAOTest {
    private LocadorDAO daoLocador;

    @Order(1)

    @Test
    public void TestInserirLocador() {
        Date data = new Date(2025-02-02);
        Locador l = new Locador();
        l.setChn((long) 123456789);
        l.setNome("Josiane");
        l.setNumIdentificacaoCarteira((long) 3);
        l.setPaisResidencia("Brasil");
        l.setPessoas_cpf("12345698723");
        l.setSobrenome("Wietcowski");
        l.setTel_contato((long) 992783476);
        l.setValidadeCarteira(data);

        LocadorDAO dao = new LocadorDAO();
        boolean inseriuok = dao.inserir(l);
        assertTrue(inseriuok);
    }

    @Order(2)
    @Test
    public void TestListarLocador() {
        Date data = new Date(2025-02-02);
        Locador l = new Locador();
        l.setChn((long) 123456789);
        l.setNome("Josiane");
        l.setNumIdentificacaoCarteira((long) 3);
        l.setPaisResidencia("Brasil");
        l.setPessoas_cpf("12345698723");
        l.setSobrenome("Wietcowski");
        l.setTel_contato((long) 992783476);
        l.setValidadeCarteira(data);

        LocadorDAO dao = new LocadorDAO();
        List<Locador> listouok = dao.listar();
    }


    @Order(3)

    @Test
    public void TestAtualizarLocador() {
        Date data = new Date(2025-02-02);
        Locador l = new Locador();
        l.setChn((long) 123456789);
        l.setNome("Josiane");
        l.setNumIdentificacaoCarteira((long) 3);
        l.setPaisResidencia("Brasil");
        l.setPessoas_cpf("12345698723");
        l.setSobrenome("Wietcowski");
        l.setTel_contato((long) 992783476);
        l.setValidadeCarteira(data);

        LocadorDAO dao = new LocadorDAO();
        boolean alterouok = dao.atualizar(l);
        assertTrue(alterouok);
    }

    @Order(4)

    @Test
    public void TestExcluirLocador() {
        Date data = new Date(2025-02-02);
        Locador l = new Locador();
        l.setChn((long) 123456789);
        l.setNome("Josiane");
        l.setNumIdentificacaoCarteira((long) 3);
        l.setPaisResidencia("Brasil");
        l.setPessoas_cpf("12345698723");
        l.setSobrenome("Wietcowski");
        l.setTel_contato((long) 992783476);
        l.setValidadeCarteira(data);

        LocadorDAO dao = new LocadorDAO();
        boolean excluiuok = dao.excluir(l);
        assertTrue(excluiuok);
    }





}
