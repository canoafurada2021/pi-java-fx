package application;

import controle.LocadorDAO;
import modelo.Categoria;
import modelo.Locador;
import modelo.TipoAcessoLogin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LocadorDAOTest {
    private static LocadorDAO daoLocador;
    private static Locador locadorTeste;

    @BeforeAll
    public static void setUpDatabase() {
        daoLocador = new LocadorDAO();
        locadorTeste = new Locador();
        locadorTeste.setNome("josiane");

    }

    @Order(1)
    @Test
    public void TestInserirLocador() {
        // Corrija a criação da data passando o valor em milissegundos
        Date data = new Date(2025 - 1900, 1, 2); // Ano - 1900, Mês (0 a 11), Dia

        Locador l = new Locador();
        l.setCnh(657333L); // Adicione "L" para indicar que é um long literal
        l.setNome("Josiane");
        l.setNumIdentificacaoCarteira(3L); // Adicione "L" para indicar que é um long literal
        l.setPaisResidencia("Brasil");
        l.setPessoas_cpf("4444444444");
        l.setSobrenome("Wietcowski");
        l.setTel_contato(992783476L); // Adicione "L" para indicar que é um long literal
        l.setValidadeCarteira(String.valueOf(data));
        l.setCargo(TipoAcessoLogin.CLIENTE);

        LocadorDAO dao = new LocadorDAO();
        boolean inseriuok = dao.inserir(l);
        assertTrue(inseriuok);
    }


    @Order(2)
    @Test
    public void TestInserirErrado(){
        Date data = new Date(2025-02-02);
        Locador l = new Locador();
        l.setCnh(null);
        l.setNome("Josiane");
        l.setNumIdentificacaoCarteira((long) 3);
        l.setPaisResidencia("Brasil");
        l.setPessoas_cpf(null);
        l.setSobrenome("Wietcowski");
        l.setTel_contato((long) 992783476);
        l.setValidadeCarteira(String.valueOf(data));

        LocadorDAO dao = new LocadorDAO();
        if (l.getCnh() != null) {
            boolean inseriuerrado = dao.inserir(l);
            assertFalse(inseriuerrado);
        } else {
            // Lidere com o cenário em que 'chn' é nulo, talvez lançando uma exceção ou fazendo algo apropriado.
        }
    }

    @Order(3)
    @Test
    public void TestListarLocador() {
        Date data = new Date(2025-02-02);
        Locador l = new Locador();
        l.setCnh(3666666l);
        l.setNome("Josiane");
        l.setNumIdentificacaoCarteira((long) 3);
        l.setPaisResidencia("Brasil");
        l.setPessoas_cpf("12345698723");
        l.setSobrenome("Wietcowski");
        l.setTel_contato((long) 992783476);
        l.setValidadeCarteira(String.valueOf(data));

        LocadorDAO dao = new LocadorDAO();
        List<Locador> listouok = dao.listar();
    }

    @Order(4)
    @Test
    public void TestListarLocadorErrado() {
        Date data = new Date(2025-02-02);
        Locador l = new Locador();
        l.setCnh(null);
        l.setNome("Josiane");
        l.setNumIdentificacaoCarteira(null);
        l.setPaisResidencia("Brasil");
        l.setPessoas_cpf("12345698723");
        l.setSobrenome(null);
        l.setTel_contato((long) 992783476);
        l.setValidadeCarteira(String.valueOf(data));

        LocadorDAO dao = new LocadorDAO();
        List<Locador> listouerrado = dao.listar();
    }


    @Order(5)
    @Test
    public void TestAtualizarLocador() {
        Date data = new Date(2025-02-02);
        Locador l = new Locador();
        l.setCnh(658678l);
        l.setNome("Josiane");
        l.setNumIdentificacaoCarteira((long) 3);
        l.setPaisResidencia("Brasil");
        l.setPessoas_cpf("654789321");
        l.setSobrenome("Wietcowski");
        l.setTel_contato(992783476l);
        l.setValidadeCarteira(String.valueOf(data));
        l.setCargo(TipoAcessoLogin.CLIENTE);

        LocadorDAO dao = new LocadorDAO();
        boolean alterouok = dao.atualizar(l);
        assertTrue(alterouok);
    }

    @Order(6)
    @Test
    public void TestAtualizarLocadorErrado() {
        Locador l = new Locador();
        l.setCnh(null);
        l.setNome("Josiane");
        l.setNumIdentificacaoCarteira(345L);
        l.setPaisResidencia(null);
        l.setPessoas_cpf("565675687686");
        l.setSobrenome("Wietcowski");
        l.setTel_contato(992783476L);
        l.setValidadeCarteira((String) null);
        l.setCargo(TipoAcessoLogin.CLIENTE);

        if (l.getCnh() != null) {
            LocadorDAO dao = new LocadorDAO();
            boolean alterouErrado = dao.atualizar(l);
            assertFalse(alterouErrado);
        } else {
            // Lide com o cenário em que 'chn' é nulo, talvez lançando uma exceção ou fazendo algo apropriado.
        }
    }



    @Order(7)
    @Test
    public void TestExcluirLocador() {
        Date data = new Date(2025-02-02);
        Locador l = new Locador();
        l.setCnh(11111l);
        l.setNome("Josiane");
        l.setNumIdentificacaoCarteira((long) 3);
        l.setPaisResidencia("Brasil");
        l.setPessoas_cpf("4444444444");
        l.setSobrenome("Wietcowski");
        l.setTel_contato((long) 992783476);
        l.setValidadeCarteira(String.valueOf(data));

        LocadorDAO dao = new LocadorDAO();
        boolean excluiuok = dao.excluir(l);
        assertTrue(excluiuok);
    }

    @Order(8)
    @Test
    public void TestExcluirLocadorErrado() {
        Date data = new Date(2025-02-02);
        Locador l = new Locador();
        l.setCnh(null);
        l.setNome(null);
        l.setNumIdentificacaoCarteira(null);
        l.setPaisResidencia("Brasil");
        l.setPessoas_cpf("866565533");
        l.setSobrenome("Wietcowski");
        l.setTel_contato(null);
        l.setValidadeCarteira(String.valueOf(data));

        LocadorDAO dao = new LocadorDAO();
        boolean excluiuerrado = dao.excluir(l);
        assertFalse(excluiuerrado);
    }

}