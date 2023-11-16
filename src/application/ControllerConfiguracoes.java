package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import controle.Conexao;
import controle.EmpresaDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.WindowEvent;
import modelo.Empresa;
import modelo.Locador;

public class ControllerConfiguracoes implements Initializable {

	@FXML
	private SplitPane SlipPaneConfigurações;

	@FXML
	private Pane panelConfiguracoes;

	@FXML
	private ImageView imgConfiguracoes;

	@FXML
	private Label lblDados;

	@FXML
	private Label lblId;

	@FXML
	private Label lblRazaoSocial;

	@FXML
	private Label lblTelefone;

	@FXML
	private Label lblCnpj;

	@FXML
	private Label lblNomeFantasia;

	@FXML
	private Label lblPorte;

	@FXML
	private TextField txtNomeFantasia;

	@FXML
	private TextField txtRazaoSocial;

	@FXML
	private TextField txtPorteEmpresa;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtCnpj;

	@FXML
	private TextField txtTelefone;

	@FXML
	private Button bntSalvarAlteraoes;

	@FXML
	private ImageView imgLogo;

	@FXML
	private Button btnPerfil;

	@FXML
	private StackPane StackPanePerfil;

	@FXML
	private ImageView imgFotoPerfil;

	@FXML
	private Label lblNomeVendedor;

	@FXML
	private Label lblFuncao;

	@FXML
	private Button btnDashboard;

	@FXML
	private ImageView imgDefaultDashboard;

	@FXML
	private Button btnProdutos;

	@FXML
	private ImageView imgDefaultProdutos;

	@FXML
	private Button btnLocacao;

	@FXML
	private ImageView imgDefaultLocacao;

	@FXML
	private Button btnFuncionarios;

	@FXML
	private ImageView imgDefaultFuncionarios;

	@FXML
	private Button btnUsuarios;

	@FXML
	private ImageView imgDefaultUsuarios;

	@FXML
	private Button btnFornecedores;

	@FXML
	private ImageView imgDefaultFornecedores;

	@FXML
	private Button btnCoategorias;

	@FXML
	private ImageView imgDefaultConfiguracoes1;

	@FXML
	private Button btnConfiguracoes;

	@FXML
	private ImageView imgDefaultConfiguracoes;

	@FXML
	private Button btnSair;

	@FXML
	private ImageView imgSair;

    @FXML
    void irParaEdicaoConfiguracoes(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/visao/Edicao_empresa.fxml"));
			Parent root = loader.load();
			ControllerEdicaoConfiguracao controllerNovaTela = loader.getController();

			// Passando os dados do fornecedor selecionado de uma tela para outra
			//controllerNovaTela.setFornecedor(fornecedor);

			// Configurar a nova janela e mostrá-la
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);

			stage.setOnCloseRequest((EventHandler<WindowEvent>) new EventHandler<WindowEvent>() {
				public void handle(WindowEvent we) {
					tblViewDivergenciaSearch();// Esse método eu populo o tableView (ver acima)
				}

				private void tblViewDivergenciaSearch() {
				}
			});

			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	public void setEmpresa(Empresa e){
		if (e!=null) {
			System.out.println("teste bomba configuracao");
			txtNomeFantasia.setText(e.getNome_fantasia());
			txtCnpj.setText(String.valueOf(e.getCnpj()));
			txtId.setText(String.valueOf(e.getIdEmpresa()));
			txtTelefone.setText(String.valueOf(e.getTelefone()));
			txtPorteEmpresa.setText(e.getPorte_empresa());
			txtRazaoSocial.setText(e.getRazao_social());
		} else {
			System.out.println("Obj de empresa esta nulo");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		EmpresaDAO dao = new EmpresaDAO();
		Empresa empresa = dao.listar();
		setEmpresa(empresa);

		txtRazaoSocial.setDisable(true);
		txtPorteEmpresa.setDisable(true);
		txtTelefone.setDisable(true);
		txtId.setDisable(true);
		txtNomeFantasia.setDisable(true);
		txtCnpj.setDisable(true);
	}

	@FXML
	void abrirListProdutos(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Produtos.fxml"));
			Parent root = loader.load();

			ControllerListProdutos controllerNovaTela = loader.getController();


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
	void abrirTelaDashboard(ActionEvent event) {
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
	void abrirListFuncionarios(ActionEvent event) {
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
	void abrirListLocacao(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Locacoes.fxml"));
			Parent root = loader.load();

			ControllerListLocacoes controllerNovaTela = loader.getController();
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
	void abrirListUsuarios(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/ListClientes.fxml"));
			Parent root = loader.load();

			ControllerListClientes controllerNovaTela = loader.getController();

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
	void abrirListFornecedores(ActionEvent event) {
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
	void abrirTelaConfiguracoes(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Configuracoes.fxml"));
			Parent root = loader.load();

			ControllerConfiguracoes controllerNovaTela = loader.getController();

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