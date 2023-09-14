package application;

import java.net.URL;
import java.util.ResourceBundle;

import controle.LocadorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import javafx.util.Callback;
import modelo.Locador;

public class ControllerListClientes implements Initializable{

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
	private TableColumn<?, ?> columnAcoes;

	@FXML
	private TableColumn<?, ?> columnCNH;

	@FXML
	private TableColumn<?, ?> columnCPF;

	@FXML
	private TableColumn<?, ?> columnIdCarteira;

	@FXML
	private TableColumn<?, ?> columnNome;

	@FXML
	private TableColumn<?, ?> columnPaisResidencia;

	@FXML
	private TableColumn<?, ?> columnTelefone;

	@FXML
	private TableColumn<?, ?> columnValidadeCarteira;

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
	private TableView<?> tableClientes;

	@FXML
	private TextField txtPesquisa;

	@FXML
	void salvarDados(ActionEvent event) {
		

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		LocadorDAO dao = new LocadorDAO();
		tableClientes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		/*Tabelas
		columnCPF
		columnTelefone.setCellFactory(cellData);
		columnPaisResidencia
		columnCNH
		columnValidadeCarteira
		
		*/
		
		//Método com os botões e o header
		columnAcoes.setCellFactory(new Callback<TableColumn<Locador, String>, TableCell<Locador, String>>(){	

			/*
			@Override
			public TableCell<Locador, String> call(TableColumn<Locador, String> param) {
				
				//Declarando variáveis				
				 private final Button viewButton = new Button();
				 private final Button editButton= new Button();
				
				private final HBox buttonCountainer = new HBox(viewButton, editButton);
				
				{
					buttonCountainer.setSpacing(10);
					
					ImageView viewImage = new ImageView();
					
					
				}
				
				return null;
			}
			
		});
		
	}*/

		}
