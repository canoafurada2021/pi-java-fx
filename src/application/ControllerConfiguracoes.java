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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ControllerConfiguracoes implements Initializable {

	   @FXML
	    private SplitPane SlipPaneConfigurações;

	    @FXML
	    private StackPane StackPanePerfil;

	    @FXML
	    private Button bntSalvar;

	    @FXML
	    private Button btnAlterar;

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
	    private Button btnProdutos;

	    @FXML
	    private Button btnSair;

	    @FXML
	    private Button btnUsuarios;

	    @FXML
	    private ImageView imgConfiguracoes;

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
	    private Label lblCnpj;

	    @FXML
	    private Label lblDados;

	    @FXML
	    private Label lblFuncao;

	    @FXML
	    private Label lblId;

	    @FXML
	    private Label lblNomeFantasia;

	    @FXML
	    private Label lblNomeVendedor;

	    @FXML
	    private Label lblPorte;

	    @FXML
	    private Label lblRazaoSocial;

	    @FXML
	    private Label lblTelefone;

	    @FXML
	    private Pane panelConfiguracoes;

	    @FXML
	    private TextField txtCnpj;

	    @FXML
	    private TextField txtId;

	    @FXML
	    private TextField txtNomeFantasia;

	    @FXML
	    private TextField txtPorteEmpresa;

	    @FXML
	    private TextField txtRazaoSocial;

	    @FXML
	    private TextField txtTelefone;

	    @FXML
	    void alterarDados(ActionEvent event) {

	    }

	    @FXML
	    void salvarDados(ActionEvent event) {

	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {

			
		}

		@FXML
		void sairTelaConfiguracoes(ActionEvent event) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Login.fxml"));
				Parent root = loader.load();

				ControllerLogin controllerNovaTela = loader.getController();

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

}
