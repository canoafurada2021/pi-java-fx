package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controle.FornecedorDAO;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import modelo.Categoria;
import modelo.Fornecedores;
import modelo.Vendedor;

public class ControllerListFornecedores implements Initializable{

	@FXML
    private SplitPane  SlipPaneConfigurações;
    
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
    private Pane panelFornecedores;
    
    @FXML
    private Label lblFornecedores;
    
    @FXML
    private TableView<Fornecedores> tableFornecedores;
    
    @FXML
    private TableColumn<Fornecedores, Integer > columnCnpj;
    
    @FXML
    private TableColumn<Fornecedores, String> columnNome;
    
    @FXML
    private TableColumn<Fornecedores, Integer> columnTelefone;
    
    @FXML
    private TableColumn<Fornecedores, String> columnEndereco;
    
   @FXML
    private TableColumn<Fornecedores, String> columnAtividade;
//    
//    @FXML
//    private TableColumn<?, ?> columnAcoes;
    
    
	private ObservableList<Fornecedores> obsFornecedores;

    
    @FXML
    private Button bntCadastrar;

    // Add event handler methods here
    
    
    @FXML
    public void sair(ActionEvent event) {
        // Lógica para sair do aplicativo
    }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		columnCnpj.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCnpj()));
		columnNome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		columnTelefone.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTelefone()));
		columnAtividade.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAtividades()));
		
		columnEndereco.setCellValueFactory(cellData -> {
		        Fornecedores fornecedor = cellData.getValue();
		        String rua = "";
		        if (fornecedor.getEnderecoId() != null) {
		            rua = fornecedor.getEnderecoId().getRua();
		        }
		        return new SimpleStringProperty(rua);
		    });
		
		carregarFornecedores();
	}
	
	
	@FXML
	public void salvarDados(ActionEvent event) {
	    // Lógica para salvar os dados
	}
	
	
	public void carregarFornecedores() {
		FornecedorDAO dao = new FornecedorDAO();
		
		ArrayList<Fornecedores> fornecedores = dao.listar();
		
		obsFornecedores = FXCollections.observableArrayList(fornecedores);
		tableFornecedores.setItems(obsFornecedores);
	}

}
