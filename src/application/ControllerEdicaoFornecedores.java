package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class ControllerEdicaoFornecedores implements Initializable{

	@FXML
	private StackPane StackPanePerfil;

	@FXML
	private Button btnCancelar;

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
	private Button btnSalvar;

	@FXML
	private Button btnUsuarios;

	@FXML
	private ComboBox<?> comboEnderecoIds;

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
	private Button infoButton;

	@FXML
	private Label lblAtividades;

	@FXML
	private Label lblCNPJ;

	@FXML
	private Label lblFuncao;

	@FXML
	private Label lblIdEndereco;

	@FXML
	private Label lblNome;

	@FXML
	private Label lblNomeVendedor;

	@FXML
	private Label lblTelefone;

	@FXML
	private Pane pnlFormEdicao;

	@FXML
	private TextField txtAtividades;

	@FXML
	private TextField txtCNPJ;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtTelefone;

	@FXML
	void abrirDashboard(ActionEvent event) {

	}

	@FXML
	void abrirListaFornecedores(ActionEvent event) {

	}

	@FXML
	void abrirListaFuncionarios(ActionEvent event) {

	}

	@FXML
	void alterarFornecedor(ActionEvent event) {

	}

	@FXML
	void cancelarAlteracaoFornecedor(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
