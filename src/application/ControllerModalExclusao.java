package application;

import controle.VendedorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Vendedor;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerModalExclusao implements Initializable {
    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnProsseguir;

    @FXML
    private ImageView imgTrashIcon;

    @FXML
    private Label lblMensagem;

    @FXML
    private Pane panelBotoes;

    @FXML
    private Pane panelMessageImage;

    @FXML
    private Pane panelProsseguirExclusao;

    // Método chamado quando o botão "Cancelar" é clicado
    @FXML
    void cancelarExclusao(ActionEvent event) {
        // Coloque aqui a lógica para a ação de "Cancelar"
        System.out.println("Ação de Cancelar");

        // Fechar o palco (Stage) ao concluir a ação
        closeStage();
    }

    // Método chamado quando o botão "Prosseguir" é clicado
    @FXML
    void confirmarExclusao(ActionEvent event) {
        VendedorDAO dao = new VendedorDAO();

        Vendedor vendedor = new Vendedor();

        System.out.println("Ação de Prosseguir");
        // Executa a exclusão
        if (dao.excluir(vendedor)) {
            System.out.println("Vendedor excluído com sucesso");
        } else {
            System.out.println("Falha ao excluir vendedor");
        }
        // Fechar o palco (Stage) ao concluir a ação
        closeStage();
    }

    // Método para fechar o palco (Stage)
    private void closeStage() {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
