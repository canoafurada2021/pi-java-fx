package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ControllerListCategoria implements Initializable{

	@FXML
    private SplitPane SlipPaneConfigurações;

    @FXML
    private StackPane StackPanePerfil;

    @FXML
    private Button bntSalvar;

    @FXML
    private Button btnConfiguracoes;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnFornecedores;

    @FXML
    private Button btnFuncionarios;

    @FXML
    private Button btnLocacao;

    @FXML
    private Button btnPerfil;

    @FXML
    private ImageView btnPesquisa;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnProdutos;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnUsuarios;

    @FXML
    private TableColumn<?, ?> columnAcoes;

    @FXML
    private TableColumn<?, ?> columnCategoria;

    @FXML
    private TableColumn<?, ?> columnIdCategoria;

    @FXML
    private ImageView imgDefaultConfiguracoes;

    @FXML
    private ImageView imgDefaultDashboard;

    @FXML
    private ImageView imgDefaultFornecedores;

    @FXML
    private ImageView imgDefaultFuncionarios;

    @FXML
    private ImageView imgDefaultLocacao;

    @FXML
    private ImageView imgDefaultProdutos;

    @FXML
    private ImageView imgDefaultUsuarios;

    @FXML
    private ImageView imgFotoPerfil;

    @FXML
    private ImageView imgLogo;

    @FXML
    private ImageView imgSair;

    @FXML
    private Label lblCategorias;

    @FXML
    private Label lblFuncao;

    @FXML
    private Label lblNomeVendedor;

    @FXML
    private Pane panelConfiguracoes;

    @FXML
    private TableView<?> tableCategorias;

    @FXML
    private TextField txtPesquisa;

    @FXML
    void cadastrarCategoria(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Cadastro_categoria.fxml"));
			Parent root = loader.load();

			ControllerCadastroCategoria controllerNovaTela = loader.getController();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			// fecha a tela atual
			Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stageAtual.close();

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
	}

	
	
}
