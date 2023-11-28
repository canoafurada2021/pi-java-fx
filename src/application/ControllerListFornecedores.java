package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controle.FornecedorDAO;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import modelo.Fornecedor;
import javafx.scene.image.Image;

import javafx.scene.control.TextField;

public class ControllerListFornecedores implements Initializable {

	@FXML
	private SplitPane SlipPaneConfigurações;

	@FXML
	private Button bntDashboard;

	@FXML
	private Button btnProdutos;

	@FXML
	private Button btnLocacao;

	@FXML
	private Button btnFuncionarios;

	@FXML
	private Button btnUsuarios;

	@FXML
	private Button btnFornecedores;

	@FXML
	private Button btnConfiguracoes;
	@FXML
	private Button btnSair;

	@FXML
	private Pane panelFornecedores;

	@FXML
	private Label lblFornecedores;

	@FXML
	private TableView<Fornecedor> tableFornecedores;

	@FXML
	private TableColumn<Fornecedor, Long> columnCnpj;

	@FXML
	private TableColumn<Fornecedor, String> columnNome;

	@FXML
	private TableColumn<Fornecedor, Long> columnTelefone;

	@FXML
	private TableColumn<Fornecedor, String> columnEndereco;

	@FXML
	private TableColumn<Fornecedor, String> columnAtividade;

	@FXML
	private TableColumn<Fornecedor, String> columnAcoes;

	@FXML
	private Button bntCadastrar;

	@FXML
	private TextField txtBusca;

	private ObservableList<Fornecedor> obsFornecedores;

	FornecedorDAO daoFor = new FornecedorDAO();

	public void tblViewDivergenciaSearch() {

		tableFornecedores.getItems().clear();
		columnCnpj.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCnpj()));
		columnNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		columnAtividade.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAtividades()));
		ObservableList<Fornecedor> obsFornecedores = FXCollections.observableArrayList(daoFor.listar());
		tableFornecedores.setItems(obsFornecedores);
		;

	}




	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//	filtroPesquisa();
		FornecedorDAO dao = new FornecedorDAO();
		tableFornecedores.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		columnCnpj.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCnpj()));
		columnNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		columnAtividade.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAtividades()));

		// Método responsável pela criação dos botões de edição e exclusão de fornecedor
		// dentro da tabela com o header 'Ações'

		columnAcoes.setCellFactory(new Callback<TableColumn<Fornecedor, String>, TableCell<Fornecedor, String>>() {
			@Override
			public TableCell<Fornecedor, String> call(TableColumn<Fornecedor, String> param) {
				return new TableCell<Fornecedor, String>() {

					// Declaração das variáveis dos dois botões
					private final Button viewButton = new Button();
					private final Button editButton = new Button();

					private final HBox buttonContainer = new HBox(viewButton, editButton);

					{
						buttonContainer.setSpacing(10); // Setta o espaçamento entre os botões

						// Estilização do botão de edição de funcionário, settando a imagem do lapis e a
						// cor de fundo do botão
						ImageView viewImage = new ImageView(
								new Image(getClass().getResourceAsStream("/imgs/editar.png")));
						viewImage.setFitHeight(16);
						viewImage.setFitWidth(16);
						viewButton.setStyle("-fx-background-color:  #001C52; -fx-text-fill: white;");

						viewButton.setGraphic(viewImage);
						viewButton.setOnAction(event -> {

							// Método de acionamento do botão de edição
							Fornecedor fornecedor = getTableView().getItems().get(getIndex());
							String cnpj = fornecedor.getCnpj().toString();

							try {
								FXMLLoader loader = new FXMLLoader(
										getClass().getResource("/visao/Edicao_fornecedores.fxml"));
								Parent root = loader.load();
								ControllerEdicaoFornecedores controllerNovaTela = loader.getController();

								// Passando os dados do fornecedor selecionado de uma tela para outra
								controllerNovaTela.setFornecedor(fornecedor);

								// Configurar a nova janela e mostrá-la
								Scene scene = new Scene(root);
								Stage stage = new Stage();
								stage.setScene(scene);

								stage.setOnCloseRequest((EventHandler<WindowEvent>) new EventHandler<WindowEvent>() {
									public void handle(WindowEvent we) {
										tblViewDivergenciaSearch();// Esse método eu populo o tableView (ver acima)
									}
								});

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

							Fornecedor fornecedor = getTableView().getItems().get(getIndex());

							if (dao.excluir(fornecedor)) {

								// ADICIONAR POPUP DE CONFIRMAÇÃO DE EXCLUSÃO DE FORNECEDOR
								dao.excluir(fornecedor);
								getTableView().getItems().remove(fornecedor);

								System.out.println("Fornecedor excluído com sucesso.");

							} else {
								System.out.println("Erro ao excluir o fornecedor.");
							}

							System.out.println("botao de delete clicado");

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

		// pega o valor do endereço com base no id de endereço existente no back-end e
		// exibe somente a rua.
		// caso seja necessário mais informações a respeito do endereço, seguir o
		// exemplo existente
		// e ajustar. Por exemplo para o dado CEP do endereço cadastrado no id 1: 'cep =
		// fornecedor.getEnderecoId.getCep()'
		// para exibir tudo relacionado ao endereco, adicionar mais colunas específicas
		// para a entidade 'Endereco nessa tabela

		columnEndereco.setCellValueFactory(cellData -> {
			Fornecedor fornecedor = cellData.getValue();
			String rua = "";
			if (fornecedor.getEnderecoId() != null) {
				rua = fornecedor.getEnderecoId().getRua();
			}
			return new SimpleStringProperty(rua);
		});

		// Configuração da coluna de telefone com formatação
		columnTelefone.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTelefone()));

		columnTelefone.setCellFactory(tc -> new TableCell<Fornecedor, Long>() {

			// máscara responsável pela formatação de número de telefone com base no modelo
			// (99) 99999-9999
			@Override
			protected void updateItem(Long telefone, boolean empty) {

				super.updateItem(telefone, empty);

				// caso o numero venha vazio a mascara não será aplicada
				if (telefone == null || empty) {
					setText(null);
					// faz a formatação com base na quantidade de caracteres dentro do atributo
					// 'Telefone'da classe 'Fornecedores'
					// padrão de número de telefone com 11 dígitos no modelo Brasileiro (padrões do
					// tipo EUA não irão funcionar)
				} else {
					String telefoneStr = String.valueOf(telefone);
					if (telefoneStr.length() == 10) {
						setText("(" + telefoneStr.substring(0, 2) + ") " + telefoneStr.substring(2, 6) + "-"
								+ telefoneStr.substring(6));
					} else if (telefoneStr.length() == 11) {
						setText("(" + telefoneStr.substring(0, 2) + ") " + telefoneStr.substring(2, 7) + "-"
								+ telefoneStr.substring(7));
					} else {
						setText(telefoneStr);
					}
				}
			}
		});

		txtBusca.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue) {
				if (txtBusca.getText().equals("pesquisar")) {
					txtBusca.clear();
				}
			} else {
				if (txtBusca.getText().isEmpty()) {
					txtBusca.setText("pesquisar");
				}
			}
		});

		// Configuração do filtro de pesquisa
		txtBusca.textProperty().addListener((observable, oldValue, newValue) -> {
			// Lista filtrada de fornecedores que inicializa todos os fornecedores na lista
			// 'obgsFornecedores'
			FilteredList<Fornecedor> listaFiltrada = new FilteredList<>(obsFornecedores, p -> true);

			if (newValue != null && !newValue.isEmpty()) {
				String termoBusca = newValue.toLowerCase();
				listaFiltrada.setPredicate(fornecedor -> {
					// O filtro permite a busca pelos campos de tipo nome e cnpj do fornecedor
					String nome = fornecedor.getNome().toLowerCase();
					String cnpj = fornecedor.getCnpj().toString();
					return nome.contains(termoBusca) || cnpj.contains(termoBusca);

					// Implemente a lógica de filtro com base nos campos do objeto
				});
			}

			tableFornecedores.setItems(listaFiltrada);
		});

		txtBusca.setOnMouseClicked(event -> {
			if (txtBusca.getText().equals("pesquisar")) {
				txtBusca.setText("");
			}
		});

		carregarFornecedores();
	}

	@FXML
	public void abrirTelaCadastroGemFornecedores(ActionEvent event) {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Cadastro_fornecedor.fxml"));
			Parent root = loader.load();

			ControllerCadastroFornecedores controllerNovaTela = loader.getController();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
//			// fecha a tela atual
			Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stageAtual.close();

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Lógica para salvar os dados
	}

	public void carregarFornecedores() {
		FornecedorDAO dao = new FornecedorDAO();

		ArrayList<Fornecedor> fornecedores = dao.listar();

		obsFornecedores = FXCollections.observableArrayList(fornecedores);
		tableFornecedores.setItems(obsFornecedores);
	}

	@FXML
	void abrirDashboard(ActionEvent event) {
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
	void abrirListFundionarios(ActionEvent event) {
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
	void abrirListLocacoes(ActionEvent event) {
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
	void sairListForncedores(ActionEvent event) {
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