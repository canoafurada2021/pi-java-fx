package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controle.VeiculoDAO;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import modelo.Veiculo;
import modelo.Vendedor;

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
	private TableColumn<Veiculo, String> columnAcoes;

	@FXML
	private TableColumn<Veiculo, Integer> columnAno;

	@FXML
	private TableColumn<Veiculo, Integer> columnIdProduto;

	@FXML
	private TableColumn<Veiculo, String> columnMarca;

	@FXML
	private TableColumn<Veiculo, String> columnNome;

	@FXML
	private TableColumn<Veiculo, Long > columnPreco;

	@FXML
	private TableColumn<Veiculo, Integer> columnUnidade;

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
	private TableView<Veiculo> tableProdutos;

	@FXML
	private TextField txtPesquisa;
	
	private ObservableList<Veiculo>obsVeiculos;
	
	VeiculoDAO daoFor = new VeiculoDAO();
	
	public void tblViewVeiculoSearch() {
		tableProdutos.getItems().clear();
		columnIdProduto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId_veiculo()));
		columnAno.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAno()));
		columnMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
		columnNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		columnPreco.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPreco_por_dia()));
		columnUnidade.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getUnidade_em_estoque()));
		ObservableList<Veiculo> obsVeiculos = FXCollections.observableArrayList(daoFor.listar());
		tableProdutos.setItems(obsVeiculos);
	;
	}

	@FXML
	void abrirTelaDashboard(ActionEvent event) {
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
	void abrirListCategorias(ActionEvent event) {
		// Abre a tela Dashboard

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
	void abrirListFornecedores(ActionEvent event) {
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
	void abrirListFuncionarios(ActionEvent event) {
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
	void abrirTelaCadastroProduto(ActionEvent event) {
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
		columnIdProduto.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getId_veiculo()));
		columnMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
		columnNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		columnAno.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getAno()));
		columnPreco.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getPreco_por_dia()));
		columnUnidade.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getUnidade_em_estoque()));
		columnAcoes.setCellFactory(new Callback<TableColumn<Veiculo, String>, TableCell<Veiculo, String>>(){
			@Override
			public TableCell<Veiculo, String> call(TableColumn<Veiculo, String> param) {
				return new TableCell<>() {
					
					//declaracao variaveis dos botoes
					private final Button viewButton = new Button();
					private final Button editButton = new Button();
					
					private final HBox buttonContainer = new HBox (viewButton, editButton);
					{
						buttonContainer.setSpacing(10);
						ImageView viewImage = new ImageView(
								new Image(getClass().getResourceAsStream("/imgs/editar.png")));
						
						viewImage.setFitHeight(16);
						viewImage.setFitWidth(16);
						viewButton.setStyle("-fx-background-color:  #001C52; -fx-text-fill: white;");
						viewButton.setGraphic(viewImage);
						viewButton.setOnAction(event -> {
							Veiculo veiculo = getTableView().getItems().get(getIndex());
							int idVeic = veiculo.getId_veiculo();
							try {
								FXMLLoader loader = new FXMLLoader(
										getClass().getResource("/visao/Edicao_produtos.fxml"));
								Parent root = loader.load();
								ControllerEdicaoProduto controllerNovaTela = loader.getController();

								controllerNovaTela.setVeiculo(veiculo);

								Scene scene = new Scene(root);
								Stage stage = new Stage();
								stage.setScene(scene);
								
								stage.setOnCloseRequest((EventHandler<WindowEvent>) new EventHandler<WindowEvent>() {
									public void handle(WindowEvent we) {
										tblViewVeiculoSearch();// Esse método eu populo o tableView (ver acima)
									}
								});
								stage.show();
							}catch (IOException e) {
								e.printStackTrace();
							}
							System.out.println("edicao com id");
							System.out.println("botao edicao clicado");
						});
						
						ImageView editImage = new ImageView(
								new Image(getClass().getResourceAsStream("/imgs/excluir.png")));
						editImage.setFitHeight(16);
						editImage.setFitWidth(16);
						editButton.setGraphic(editImage);
						editButton.setStyle("-fx-background-color: red;");
						editButton.setOnAction(event -> {
							Veiculo veiculo = getTableView().getItems().get(getIndex());
							 int idVeiculo = veiculo.getId_veiculo();
							if(daoFor.excluir(idVeiculo)) {
								daoFor.excluir(idVeiculo);
								getTableView().getItems().remove(veiculo);
								System.out.println("veiculo excluidp");
							}else {
								System.out.println("erro ao exlucir o veiculo");
							}
							System.out.println("botao de excluir clicado");
						});

					}
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if(empty) {
							setGraphic(null);
						}else {
							setGraphic(buttonContainer);
						}
					}
					};
	            }
	        });
		carregarVeiculos();
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

	    public void carregarVeiculos() {
	    	VeiculoDAO dao = new VeiculoDAO();
	    	
	    	ArrayList<Veiculo> veiculos = dao.listar();
	    	obsVeiculos = FXCollections.observableArrayList(veiculos);
	    	tableProdutos.setItems(obsVeiculos);
	    }

	}
				
				