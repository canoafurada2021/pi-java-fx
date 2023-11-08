package application;

import controle.LocadorDAO;
import modelo.Locador;
import modelo.TipoAcessoLogin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LocadorDAOTest {
    private static LocadorDAO daoLocador;

    @BeforeAll
    public static void setUpDatabase() {
        daoLocador = new LocadorDAO();
    }

    // Método auxiliar para criar objetos de teste de forma dinâmica
    private Locador createTestLocador() {
        Locador locador = new Locador();
        locador.setPessoas_cpf("547658648"); // Substitua por um CPF real
        locador.setNome("NomeAleatorio"); // Substitua por um nome real
        locador.setCnh(987654321L); // Substitua por um número de CNH real
        locador.setValidadeCarteira("2025-02-02"); // Substitua por uma data real
        locador.setPaisResidencia("brasil");
        locador.setSobrenome("sobrenome aleatorio");
        locador.setNumIdentificacaoCarteira(243L);
        locador.setImg_Base64("aaa");
        locador.setTipoAcesso(TipoAcessoLogin.CLIENTE);
        locador.setTel_contato(343243L);
        // Defina outras propriedades conforme necessário
        return locador;
    }

    @Test
    @Order(1)
    public void testInserirLocador() {
        Locador l = createTestLocador();
        boolean inseriuOk = daoLocador.inserir(l);
        assertTrue(inseriuOk);
    }

    @Test
    @Order(2)
    public void testListarLocador() {
        ArrayList<Locador> locadores = daoLocador.listar();
        assertNotNull(locadores);
        assertTrue(locadores.size() > 0);
    }

    @Test
    @Order(3)
    public void testAtualizarLocador() {
        ArrayList<Locador> locadores = daoLocador.listar();
        if (!locadores.isEmpty()) {
            // Escolha um locador aleatório para atualizar
            Locador locadorParaAtualizar = locadores.get((int) (Math.random() * locadores.size()));

            // Atualize o locador
            String novoNome = "NovoNome";
            locadorParaAtualizar.setNome(novoNome);
            boolean alterouOk = daoLocador.atualizar(locadorParaAtualizar);
            assertTrue(alterouOk);
        }
    }

    @Test
    @Order(4)
    public void testExcluirLocador() {
        ArrayList<Locador> locadores = daoLocador.listar();
        if (!locadores.isEmpty()) {
            // Escolha um locador aleatório para excluir
            Locador locadorParaExcluir = locadores.get((int) (Math.random() * locadores.size()));
            boolean excluiuOk = daoLocador.excluir(locadorParaExcluir);
            assertTrue(excluiuOk);
        }
    }
}
