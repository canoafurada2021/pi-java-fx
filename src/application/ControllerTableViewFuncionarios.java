package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controle.VendedoresDAO;
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
import modelo.Vendedores;

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
    private TableView<Vendedores> tableFuncionario;

    @FXML
    private TableColumn<Vendedores, String > columnCargo;

    @FXML
    private TableColumn<Vendedores, Integer> columnIdVendedor;

    @FXML
    private TableColumn<Vendedores, String> columnNome;

    @FXML
    private TableColumn<Vendedores, Double> columnSalario;
    
    private ObservableList<Vendedores> obsVendedores;
    
    
    
  
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	
	
	  @FXML
	    void sair(ActionEvent event) {

	    }

	    @FXML
	    void salvarDados(ActionEvent event) {
	    	VendedoresDAO dao = new VendedoresDAO();
	    	ArrayList<Vendedores> vendedores = dao.listar();
	    	
	    	obsVendedores = FXCollections.observableArrayList(vendedores);
	    	
	    	tableFuncionario.setItems(obsVendedores);
	    	
	    	List<Vendedores>vendedoresFetched = dao.listar();
	    	obsVendedores = FXCollections.observableArrayList(vendedoresFetched);;
	    	
	    	tableFuncionario.setItems(obsVendedores);
	    	tableFuncionario.setItems(obsVendedores);
	    }

}
