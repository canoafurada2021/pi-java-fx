//package application;
//
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
////import java.util.ResourceBundle;
//
//import controle.Conexao;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.SplitPane;
//import javafx.scene.control.TextField;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
//
//import static controle.Conexao.DATABASE;
//
//public class ControllerConfiguracoes implements Initializable {
//
//	@FXML
//	private SplitPane SlipPaneConfigurações;
//
//	@FXML
//	private Pane panelConfiguracoes;
//
//	@FXML
//	private ImageView imgConfiguracoes;
//
//	@FXML
//	private Label lblDados;
//
//	@FXML
//	private Label lblId;
//
//	@FXML
//	private Label lblRazaoSocial;
//
//	@FXML
//	private Label lblTelefone;
//
//	@FXML
//	private Label lblCnpj;
//
//	@FXML
//	private Label lblNomeFantasia;
//
//	@FXML
//	private Label lblPorte;
//
//	@FXML
//	private TextField txtNomeFantasia;
//
//	@FXML
//	private TextField txtRazaoSocial;
//
//	@FXML
//	private TextField txtPorteEmpresa;
//
//	@FXML
//	private TextField txtId;
//
//	@FXML
//	private TextField txtCnpj;
//
//	@FXML
//	private TextField txtTelefone;
//
//	@FXML
//	private Button bntSalvarAlteraoes;
//
//	@FXML
//	private ImageView imgLogo;
//
//	@FXML
//	private Button btnPerfil;
//
//	@FXML
//	private StackPane StackPanePerfil;
//
//	@FXML
//	private ImageView imgFotoPerfil;
//
//	@FXML
//	private Label lblNomeVendedor;
//
//	@FXML
//	private Label lblFuncao;
//
//	@FXML
//	private Button btnDashboard;
//
//	@FXML
//	private ImageView imgDefaultDashboard;
//
//	@FXML
//	private Button btnProdutos;
//
//	@FXML
//	private ImageView imgDefaultProdutos;
//
//	@FXML
//	private Button btnLocacao;
//
//	@FXML
//	private ImageView imgDefaultLocacao;
//
//	@FXML
//	private Button btnFuncionarios;
//
//	@FXML
//	private ImageView imgDefaultFuncionarios;
//
//	@FXML
//	private Button btnUsuarios;
//
//	@FXML
//	private ImageView imgDefaultUsuarios;
//
//	@FXML
//	private Button btnFornecedores;
//
//	@FXML
//	private ImageView imgDefaultFornecedores;
//
//	@FXML
//	private Button btnCoategorias;
//
//	@FXML
//	private ImageView imgDefaultConfiguracoes1;
//
//	@FXML
//	private Button btnConfiguracoes;
//
//	@FXML
//	private ImageView imgDefaultConfiguracoes;
//
//	@FXML
//	private Button btnSair;
//
//	@FXML
//	private ImageView imgSair;
//
//	@FXML
//	void salvarDados(ActionEvent event) throws SQLException {
//
//		Conexao conexao = Conexao.getInstancia();
//		Connection con = conexao.conectar();
//
//		String url = Conexao.getURL();
//		String user = Conexao.getUSER();
//		String psw = Conexao.getPSW();
//
//		try (Connection connection = DriverManager.getConnection(url, user, psw);
//			 Statement statement = connection.createStatement()) {
//
//			int linhasAfetadas = statement.executeUpdate("UPDATE empresa SET telefone = 'Novo Telefone', TipoAcessoLogin = 'Novo TipoAcessoLogin' WHERE razao social = 'O objetivo da empresa é deixar as pessoas felizes andando de gol'");
//
//
//			System.out.println("Registros stualizados: " + linhasAfetadas);
//		} catch (SQLException e){
//			e.printStackTrace();
//		}
//	}
//
//		@Override
//		public void initialize(URL location, ResourceBundle resources) {
//
//
//		}
//
//
//
//
//	@FXML
//	void abrirListProdutos(ActionEvent event) {
//		try {
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Produtos.fxml"));
//			Parent root = loader.load();
//
//			ControllerListProdutos controllerNovaTela = loader.getController();
//
//
//			Scene scene = new Scene(root);
//			Stage stage = new Stage();
//
//			// fecha a tela atual
//			Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
//			stageAtual.close();
//
//			stage.setScene(scene);
//			stage.show();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@FXML
//	void abrirDashboard(ActionEvent event) {
//		try {
//
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Dashboard.fxml"));
//			Parent root = loader.load();
//
//			ControllerTableViewFuncionarios controllerNovaTela = loader.getController();
//
//			Scene scene = new Scene(root);
//			Stage stage = new Stage();
//
//			// fecha a tela atual
//			Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
//			stageAtual.close();
//
//			stage.setScene(scene);
//			stage.show();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//
//	@FXML
//	void abrirListFuncionarios(ActionEvent event) {
//		try {
//
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Funcionarios.fxml"));
//			Parent root = loader.load();
//
//			ControllerTableViewFuncionarios controllerNovaTela = loader.getController();
//
//			Scene scene = new Scene(root);
//			Stage stage = new Stage();
//
//			// fecha a tela atual
//			Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
//			stageAtual.close();
//
//			stage.setScene(scene);
//			stage.show();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//
//	@FXML
//	void abrirListLocacao(ActionEvent event) {
//		try {
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Locacoes.fxml"));
//			Parent root = loader.load();
//
//			ControllerListLocacoes controllerNovaTela = loader.getController();
//			Scene scene = new Scene(root);
//			Stage stage = new Stage();
//
//			// fecha a tela atual
//			Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
//			stageAtual.close();
//
//			stage.setScene(scene);
//			stage.show();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@FXML
//	void abrirListUsuarios(ActionEvent event) {
//		try {
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/ListClientes.fxml"));
//			Parent root = loader.load();
//
//			ControllerListClientes controllerNovaTela = loader.getController();
//
//			Scene scene = new Scene(root);
//			Stage stage = new Stage();
//
//			// fecha a tela atual
//			Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
//			stageAtual.close();
//
//			stage.setScene(scene);
//			stage.show();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@FXML
//	void abrirListFornecedores(ActionEvent event) {
//		try {
//
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Fornecedores.fxml"));
//			Parent root = loader.load();
//
//			ControllerListFornecedores controllerNovaTela = loader.getController();
//
//			Scene scene = new Scene(root);
//			Stage stage = new Stage();
//
//			// fecha a tela atual
//			Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
//			stageAtual.close();
//
//			stage.setScene(scene);
//			stage.show();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@FXML
//	void abrirListCategorias(ActionEvent event) {
//		try {
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Categorias.fxml"));
//			Parent root = loader.load();
//
//			ListViewController controllerNovaTela = loader.getController();
//
//			Scene scene = new Scene(root);
//			Stage stage = new Stage();
//
//			// fecha a tela atual
//			Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
//			stageAtual.close();
//
//			stage.setScene(scene);
//			stage.show();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@FXML
//	void abrirTelaConfiguracoes(ActionEvent event) {
//		try {
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Configuracoes.fxml"));
//			Parent root = loader.load();
//
//			ControllerConfiguracoes controllerNovaTela = loader.getController();
//
//			Scene scene = new Scene(root);
//			Stage stage = new Stage();
//
//			// fecha a tela atual
//			Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
//			stageAtual.close();
//
//			stage.setScene(scene);
//			stage.show();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//		@FXML
//		void sairTelaConfiguracoes(ActionEvent event) {
//			try {
//				FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Login.fxml"));
//				Parent root = loader.load();
//
//				ControllerLogin controllerNovaTela = loader.getController();
//
//				Scene scene = new Scene(root);
//				Stage stage = new Stage();
//
//				// fecha a tela atual
//				Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
//				stageAtual.close();
//
//				stage.setScene(scene);
//				stage.show();
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//}
