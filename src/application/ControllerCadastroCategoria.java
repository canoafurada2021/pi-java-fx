package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Stack;

import controle.CategoriaDAO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.Categoria;
import utilities.ExibePopUpErro;
import utilities.ExibePopUpSucesso;


public class ControllerCadastroCategoria implements Initializable {

	@FXML
	private StackPane StackPanePerfil;

	@FXML
	private Button btnCadastroCategoria;

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
	private Label lblCategoria;

	@FXML
	private Label lblFuncao;

	@FXML
	private Label lblIdCategoria;

	@FXML
	private Label lblNomeVendedor;

	@FXML
	private TextField txtCategoria;

	// instanciando DAOCategora (pra pegar os metodos)
	CategoriaDAO daoCategoria = new CategoriaDAO();

	// para listar as categorias, já que está usando o comboBox, para listar todos
	// os ids já cadastrados
	ArrayList<Categoria> categorias = daoCategoria.listar();

	@FXML
	void cadastrarCategoria(ActionEvent event) {

		String nomeCategoria = txtCategoria.getText();

		// Instaciando os atributos, variaveis, a própria categoria
		Categoria c = new Categoria();

		c.setCategoria(nomeCategoria);

		
		// chamando o metodos pra fazer as validações (que já existem no pacote
		// utilities)
		try {

			boolean insercaoSucesso = daoCategoria.inserir(c);
		
			limpaCampos();

			if (insercaoSucesso) {
				ExibirPopUpSucesso();
			} else {
				ExibirPopUpErro();
			}

		} catch (Exception e) {

			ExibirPopUpSucesso();

		}

		
	

	}

	private void ExibirPopUpSucesso() {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/visao/PopUpCadastroSucesso.fxml"));
			Parent popupRoot = fxmlLoader.load();

			Stage popupStage = new Stage();
			popupStage.initModality(Modality.APPLICATION_MODAL);
			popupStage.setTitle("Success Popup");

			Scene popupScene = new Scene(popupRoot);
			popupStage.setScene(popupScene);
			popupStage.show();

			// Define the duration for displaying the popup (in milliseconds)
			int popupDuration = 3000; // Change this value as needed

			// Create a Timeline to close the popup after the specified duration
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(popupDuration), event -> {
				popupStage.close();
			}));
			timeline.setCycleCount(1);
			timeline.play();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void ExibirPopUpErro() {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/visao/PopUpCadastroErro.fxml"));
			Parent popupRoot = fxmlLoader.load();

			Stage popupStage = new Stage();
			popupStage.initModality(Modality.APPLICATION_MODAL);
			popupStage.setTitle("Error Popup");

			Scene popupScene = new Scene(popupRoot);
			popupStage.setScene(popupScene);
			popupStage.show();

			// Define the duration for displaying the popup (in milliseconds)
			int popupDuration = 3000; // Change this value as needed

			// Create a Timeline to close the popup after the specified duration
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(popupDuration), event -> {
				popupStage.close();
			}));
			timeline.setCycleCount(1);
			timeline.play();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	private void limpaCampos() {
		// Para quando cadastrar os dados, ele automaticamente limpar os campos
		txtCategoria.setText(null);
	}

	@FXML
	void abrirListCategorias(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Categorias.fxml"));
			Parent root = loader.load();

			ListViewController controllerNovaTela = loader.getController();

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

	@FXML
		void abrirConfiguracao(Action event) {
			try{

				FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Configuracao.fxml"))

			}
	}


	  @FXML
	    void sairCategoriaParaLogin(ActionEvent event) {
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
