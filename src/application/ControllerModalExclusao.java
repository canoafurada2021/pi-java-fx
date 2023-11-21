package application;

import controle.VendedorDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Vendedor;
import utilities.ExibePopUpConfExclusao;

import javafx.scene.control.TableView; // Correção aqui

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

    private ObservableList<Vendedor> obsVendedores;
    private TableView<Vendedor> tableFuncionario;

    private Vendedor vendedor;  // Altere o tipo para Vendedor
    public void setTableFuncionario(TableView<Vendedor> tableFuncionario, ObservableList<Vendedor> obsVendedores) {
        this.tableFuncionario = tableFuncionario;
        this.obsVendedores = obsVendedores;
    }
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @FXML
    void cancelarExclusao(ActionEvent event) {
        // Coloque aqui a lógica para a ação de "Cancelar"
        System.out.println("Ação de Cancelar");

        // Fechar o palco (Stage) ao concluir a ação
        closeStage();
    }

    @FXML
    void confirmarExclusao(ActionEvent event) {
        VendedorDAO dao = new VendedorDAO();

        if (vendedor != null) {
            boolean confirmacao = ExibePopUpConfExclusao.ExibirPopUpConfExclusao();

            if (confirmacao) {
                if (dao.excluir(vendedor)) {
                    // Lógica após a exclusão bem-sucedida
                    obsVendedores.remove(vendedor);
                    System.out.println("Vendedor excluído com sucesso");
                } else {
                    System.out.println("Falha ao excluir vendedor");
                }
            } else {
                System.out.println("vendedor esta nulo");
            }
        } else {
            System.out.println("Nenhum vendedor fornecido para exclusão.");
        }

        // Fecha o palco (Stage) ao concluir a ação
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
