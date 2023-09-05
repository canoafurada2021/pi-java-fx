package application;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import controle.VendedorDAO;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.StringConverter;
import modelo.Vendedor;

public class ControllerTableViewFuncionarios implements Initializable {

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
    private TextField txtPesquisa;
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
    private Label lblFornecedores;

    @FXML
    private Label lblFuncao;

    @FXML
    private Label lblNomeVendedor;

    @FXML
    private Pane panelConfiguracoes;

    
	@FXML
	private TableView<Vendedor> tableFuncionario;

	@FXML
	private TableColumn<Vendedor, String> columnCargo;

	@FXML
	private TableColumn<Vendedor, Integer> columnIdVendedor;

	@FXML
	private TableColumn<Vendedor, String> columnNome;

	@FXML
	private TableColumn<Vendedor, Double> columnSalario;
	
	

	private ObservableList<Vendedor> obsVendedores;

	@FXML
	private void sair(ActionEvent event) {
		// Implemente a lógica para sair aqui
		System.out.println("Botão de sair pressionado");
	}

	@FXML
	private void salvarDados(ActionEvent event) {
		System.out.println("AAAAAAAAAAAAAAAA"); //teste
	}

	// Formata a cédula do salário para o padrão PT-BR (R$ 0000,000)
	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		columnIdVendedor.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId_vendedor()));
		columnNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		columnCargo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCargo().toString()));

		// Configura a formatação da célula da coluna de salário
		columnSalario.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getSalario()));

		// Usa um StringConverter (Classe do FXML responsável por facilitar na conversão
		// de tipos Long e Double pra String)
		// para formatar o valor do salário como moeda

		StringConverter<Double> currencyConverter = new StringConverter<>() {
			private final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

			@Override
			public String toString(Double value) {
				if (value == null) {
					return "";
				}

				return currencyFormat.format(value);
			}

			@Override
			public Double fromString(String string) {
				return null;
			}

		};

		// Definição e criação das células na coluna
		// Expressão lambda para simplificar a criação de células
		columnSalario.setCellFactory(tc -> new TableCell<Vendedor, Double>() {
			@Override
			protected void updateItem(Double salario, boolean empty) {
				super.updateItem(salario, empty);
				// Validação caso a coluna de salário esteja vazia, a cédula é setada como nullo
				// ou " "
				if (empty || salario == null) {

					setText("");
				} else {
					// Trecho do código que faz a formatação do valor dentro da cédula
					setText(currencyConverter.toString(salario));
				}
			}
		});

		carregarVendedores();
	}

	public void carregarVendedores() {
		VendedorDAO dao = new VendedorDAO();
		ArrayList<Vendedor> vendedores = dao.listar();

		obsVendedores = FXCollections.observableArrayList(vendedores);
		tableFuncionario.setItems(obsVendedores);
	}
}
