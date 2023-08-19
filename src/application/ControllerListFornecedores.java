package application;

import java.net.URL;
import java.util.ResourceBundle;

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
    private TableView<?> tableFornecedores;
    
    @FXML
    private TableColumn<?, ?> columnCnpj;
    
    @FXML
    private TableColumn<?, ?> columnNome;
    
    @FXML
    private TableColumn<?, ?> columnTelefone;
    
    @FXML
    private TableColumn<?, ?> columnEndereco;
    
    @FXML
    private TableColumn<?, ?> columnAtividade;
    
    @FXML
    private TableColumn<?, ?> columnAcoes;
    
    @FXML
    private Button bntCadastrar;

    // Add event handler methods here
    
    @FXML
    public void sair(ActionEvent event) {
        // Lógica para sair do aplicativo
    }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		
	}
	
	
	@FXML
	public void salvarDados(ActionEvent event) {
	    // Lógica para salvar os dados
	}

}
