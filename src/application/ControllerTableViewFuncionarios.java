package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controle.VendedorDAO;
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
import javafx.scene.layout.Pane;
import modelo.Vendedor;

public class ControllerTableViewFuncionarios implements Initializable{

	@FXML
    private SplitPane SlipPaneConfigurações;

    @FXML
    private Button bntDashboard;

    @FXML
    private Button bntSalvar;

    @FXML
    private Button btnConfiguracoes;

    @FXML
    private Button btnFornecedores;

    @FXML
    private Button btnFuncionarios;

    @FXML
    private Button btnLocacao;

    @FXML
    private Button btnProdutos;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnUsuarios;

    @FXML
    private Label lblFornecedores;

    @FXML
    private Pane panelConfiguracoes;

    @FXML
    private TableView<Vendedor> tableFuncionario;

    @FXML
    private TableColumn<Vendedor, String > columnCargo;

    @FXML
    private TableColumn<Vendedor, Integer> columnIdVendedor;

    @FXML
    private TableColumn<Vendedor, String> columnNome;

    @FXML
    private TableColumn<Vendedor, Double> columnSalario;
    
    private ObservableList<Vendedor> obsVendedores;
    
    
    
  
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarVendedores();
		System.out.println("teste deys funca");

	}
	
	
	
	  @FXML
	    void sair(ActionEvent event) {

	    }

	    @FXML
	    void salvarDados(ActionEvent event) {
	    	
	    }
	    public void carregarVendedores() {
	    	
	    	VendedorDAO dao = new VendedorDAO();
	    	ArrayList<Vendedor> vendedores = dao.listar();
	    	
	    	obsVendedores = FXCollections.observableArrayList(vendedores);
	    	
	    	tableFuncionario.setItems(obsVendedores);
	    	
	    	List<Vendedor>vendedoresFetched = dao.listar();
	    	obsVendedores = FXCollections.observableArrayList(vendedoresFetched);;
	    	
	    	tableFuncionario.setItems(obsVendedores);
	    }

}
