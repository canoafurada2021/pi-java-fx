package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controle.VeiculoDAO;
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

public class ControllerListProdutos implements Initializable {

	@FXML
    private SplitPane SlipPaneProdutos;

    @FXML
    private StackPane StackPanePerfil;

    @FXML
    private Button bntCadastrar;

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
    private TableColumn<?, ?> columnAno;

    @FXML
    private TableColumn<?, ?> columnIdProduto;

    @FXML
    private TableColumn<?, ?> columnMarca;

    @FXML
    private TableColumn<?, ?> columnNome;

    @FXML
    private TableColumn<?, ?> columnPreco;

    @FXML
    private TableColumn<?, ?> columnUnidade;

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
    private Label lblFuncao;

    @FXML
    private Label lblNomeVendedor;

    @FXML
    private Label lblProdutos;

    @FXML
    private Pane panelProdutos;

    @FXML
    private TableView<?> tableProdutos;

    @FXML
    private TextField txtPesquisa;
    
    @FXML
    void abrirDashboard(ActionEvent event) {
    	// Abre a tela Dashboard
    	
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Dashboard.fxml"));
			Parent root = loader.load();

			ControllerDashboard controllerNovaTela = loader.getController();

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
    void abrirFornecedores(ActionEvent event) {
    	// Abre a tela Fornecedores
    	
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Fornecedores.fxml"));
			Parent root = loader.load();

			ControllerListFornecedores controllerNovaTela = loader.getController();

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
    void abrirFuncionarios(ActionEvent event) {
    	// Abre a tela Funcinoarios 
    	
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Funcionarios.fxml"));
			Parent root = loader.load();

			ControllerTableViewFuncionarios controllerNovaTela = loader.getController();

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
    void sair(ActionEvent event) {
    	// Lógica para sair do aplicativo
    	
    	// CONTINUAR
    }
    
    @FXML
    void cadastrar(ActionEvent event) {
    	// Ir para a tela de cadastro de produtos
    	
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Cadastro_produto.fxml"));
			Parent root = loader.load();

			ControllerCadastroProduto controllerNovaTela = loader.getController();

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
		
		VeiculoDAO daoVeiculo = new VeiculoDAO();
		// CONTINUAR
		
	}
	
}