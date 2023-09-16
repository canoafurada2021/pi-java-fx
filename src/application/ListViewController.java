package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import modelo.Categoria;
import modelo.Fornecedor;
import controle.CategoriaDAO;

public class ListViewController implements Initializable {

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
	private TextField txtPesquisa;

	@FXML
	private TableView<Categoria> tabela;

	@FXML
	private TableColumn<Categoria, String> columnAcoes;

	@FXML
	private TableColumn<Categoria, String> columnCategoria;
	
	CategoriaDAO dao = new CategoriaDAO();

	@FXML
	private TableColumn<Categoria, Integer> columnIdCategoria;

	@FXML
	void abrirCadastroCategoria(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Cadastro_categoria.fxml"));
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

	private ObservableList<Categoria> obsCategoria;

//    
//    List<Categoria> categorias = new ArrayList<>(
//            Arrays.asList(new Categoria(1, "coisinha"), new Categoria(2, "coisona")));

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		columnIdCategoria.setText("Id");
		columnIdCategoria.setCellValueFactory(new PropertyValueFactory<>("idCategoria"));

		columnCategoria.setText("Nome da Categoria");
		columnCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()));

		columnAcoes.setCellFactory(new Callback<TableColumn<Categoria, String>, TableCell<Categoria, String>>(){
			@Override 
			public TableCell<Categoria, String> call(TableColumn<Categoria, String> param ){
				return new TableCell<Categoria, String>(){
					
					
					//declarando varialel dos botoes
					private final Button viewButton = new Button();
					private final Button editButton = new Button();
					
					private final HBox buttonContainer = new HBox(viewButton, editButton);
					
					{
						buttonContainer.setSpacing(10); //setta ESPACAMENTO ENTRE OS BOTOES
						
						//estilizacao dos botoes
						
						ImageView viewImage = new ImageView(
								new Image(getClass().getResourceAsStream("/imgs/editar.png")));
						viewImage.setFitHeight(16);
						viewImage.setFitWidth(16);
						viewButton.setStyle("-fx-background-color:  #001C52; -fx-text-fill: white;");
						
						viewButton.setGraphic(viewImage);
						viewButton.setOnAction(event -> {
							//metodo p acionar o botao
							
							Categoria categoria = getTableView().getItems().get(getIndex());
							String id = String.valueOf(categoria.getIdCategoria());
							
							try {
								FXMLLoader loader = new FXMLLoader(
										getClass().getResource("/visao/Edicao_categoria.fxml"));
								Parent root = loader.load();
								ControllerEdicaoCategoria controllerNovaTela = loader.getController();

								controllerNovaTela.setCategoria(categoria);
								
								// Configurar a nova janela e mostrá-la
								Scene scene = new Scene(root);
								Stage stage = new Stage();
								stage.setScene(scene);
								stage.show();
							} catch (IOException e) {
								e.printStackTrace();
							}

							System.out.println("edição com o id categoria n achei o nome do id n quero procurar" );

							System.out.println("botao de edição clicado");

						});
						
						ImageView editImage = new ImageView(
								new Image (getClass().getResourceAsStream("/imgs/excluir.png")));
						editImage.setFitHeight(16);
						editImage.setFitWidth(16);
						editButton.setGraphic(editImage);
						editButton.setStyle("-fx-background-color: red;");
						editButton.setOnAction(event -> {
								Categoria categoria = getTableView().getItems().get(getIndex());
								if (dao.excluir(categoria)) {
									getTableView().getItems().remove(categoria);
									System.out.println("categoria excluida");
								}else {
								System.out.println("erro excluir cetegoria");
								}
								
								System.out.println("botao deletar clicado");							
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
			
		
		
		
		// método para tirar a coluna extra vazia criada como padrão no table column
		tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		carregarCategorias();
		System.out.println("teste funcionadeus ");
	}

	public void carregarCategorias() {

		CategoriaDAO dao = new CategoriaDAO();

		ArrayList<Categoria> categoriass = dao.listar();

		obsCategoria = FXCollections.observableArrayList(categoriass);

		tabela.setItems(obsCategoria);

		List<Categoria> categoriasFetched = dao.listar();
		obsCategoria = FXCollections.observableArrayList(categoriasFetched);

		tabela.setItems(obsCategoria);
		tabela.setItems(obsCategoria);
	}
}
