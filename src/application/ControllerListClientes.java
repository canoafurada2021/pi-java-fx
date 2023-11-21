package application;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controle.LocadorDAO;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import modelo.Locador;
import modelo.TipoAcessoLogin;
import utilities.CpfFormatter;

public class ControllerListClientes implements Initializable {

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
	private TableColumn<Locador, String> columnAcoes;

	@FXML
	private TableColumn<Locador, Long> columnCNH;

	@FXML
	private TableColumn<Locador, String> columnCPF;

	@FXML
	private TableColumn<Locador, Long> columnIdCarteira;

	@FXML
	private TableColumn<Locador, String> columnNome;

	@FXML
	private TableColumn<Locador, String> columnPaisResidencia;

	@FXML
	private TableColumn<Locador, Long> columnTelefone;

	@FXML
	private TableColumn<Locador, String> columnValidadeCarteira;


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
	private Label lblClientes;

	@FXML
	private Label lblFuncao;

	@FXML
	private Label lblNomeVendedor;

	@FXML
	private Pane panelConfiguracoes;

	@FXML
	private TableView<Locador> tableClientes;

	@FXML
	private TextField txtPesquisa;

	private ObservableList<Locador> obsLocadores;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LocadorDAO dao = new LocadorDAO();
		tableClientes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);




		columnCPF.setCellValueFactory(cellData -> new SimpleObjectProperty<>(CpfFormatter.formatCpf(cellData.getValue().getPessoas_cpf())));		columnNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		columnIdCarteira.setCellValueFactory(
				cellData -> new SimpleObjectProperty<>(cellData.getValue().getNumIdentificacaoCarteira()));
		columnTelefone
				.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTel_contato()));
		columnPaisResidencia
				.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPaisResidencia()));
		columnCNH.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCnh()));
		columnValidadeCarteira.setCellValueFactory(
				cellData -> new SimpleStringProperty(cellData.getValue().getValidadeCarteira()));


		columnAcoes.setCellFactory(new Callback<TableColumn<Locador, String>, TableCell<Locador, String>>() {
			@Override
			public TableCell<Locador, String> call(TableColumn<Locador, String> param) {
				return new TableCell<Locador, String>() {
					private final Button viewButton = new Button();
					private final Button editButton = new Button();

					private final HBox buttonContainer = new HBox(viewButton, editButton);

					{
						buttonContainer.setSpacing(10);

						ImageView viewImage = new ImageView(
								new Image(getClass().getResourceAsStream("/imgs/editar.png")));
						viewImage.setFitHeight(16);
						viewImage.setFitWidth(16);
						viewButton.setStyle("-fx-background-color:  #001C52; -fx-text-fill: white;");

						viewButton.setGraphic(viewImage);
						viewButton.setOnAction(event -> {

							// MUDAR PARA FORNECEDOR
							Locador locador = getTableView().getItems().get(getIndex());
							String validadeCarteira = locador.getValidadeCarteira().toString();

							try {
								// PRECISA MUDAR PRO CONTROLLER CLIENTES !!!!! - ANDRI
								FXMLLoader loader = new FXMLLoader(
										getClass().getResource("/visao/Edicao_locador.fxml"));
								Parent root = loader.load();
								ControllerEdicaoClientes controllerNovaTela = loader.getController();

								// Passando os dados do fornecedor selecionado de uma tela para outra
								controllerNovaTela.setLocador(locador);

								// Configurar a nova janela e mostrá-la
								Scene scene = new Scene(root);
								Stage stage = new Stage();
								stage.setScene(scene);
								stage.show();
							} catch (IOException e) {
								e.printStackTrace();
							}
						});

						ImageView editImage = new ImageView(
								new Image(getClass().getResourceAsStream("/imgs/excluir.png")));
						editImage.setFitHeight(16);
						editImage.setFitWidth(16);
						editButton.setGraphic(editImage);
						editButton.setStyle("-fx-background-color: red;");
						editButton.setOnAction(event -> {
							Locador locador = getTableView().getItems().get(getIndex());

							if (dao.excluir(locador)) {
								getTableView().getItems().remove(locador);
							} else {
								System.out.println("erro ao excluir cliente");
							}
						});
					}

					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);

						if (empty) {
							setGraphic(null);
						} else {
							setGraphic(buttonContainer);
						}
					}
				};
			}
		});
		carregarLocadores();
	}

	public void carregarLocadores() {
		LocadorDAO dao = new LocadorDAO();

		List<Locador> locadores = dao.listar();

		obsLocadores = FXCollections.observableArrayList(locadores);
		tableClientes.setItems(obsLocadores);

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
	void abrirListClientes(ActionEvent event) {
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
	void abrirTelaConfiguracoes(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Configuracoes.fxml"));
			Parent root = loader.load();

			//ControllerConfiguracoes controllerNovaTela = loader.getController();

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
	void sairListCliente(ActionEvent event) {
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