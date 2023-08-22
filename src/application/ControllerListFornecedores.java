package application;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
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
    private TableColumn<Fornecedores, Long > columnCnpj;
    
    @FXML
    private TableColumn<Fornecedores, String> columnNome;
    
    @FXML
    private TableColumn<Fornecedores, Long> columnTelefone;
    
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
		columnAtividade.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAtividades()));
		
		
		// pega o valor do endereço com base no id de endereço existente no back-end e exibe somente a rua.
		// caso seja necessário mais informações a respeito do endereço, seguir o exemplo existente
		// e ajustar. Por exemplo para o dado CEP do endereço cadastrado no id 1: 'cep = fornecedor.getEnderecoId.getCep()'
		// para exibir tudo relacionado ao endereco, adicionar mais colunas específicas para a entidade 'Endereco nessa tabela
		
		columnEndereco.setCellValueFactory(cellData -> {
		        Fornecedores fornecedor = cellData.getValue();
		        String rua = "";
		        if (fornecedor.getEnderecoId() != null) {
		            rua = fornecedor.getEnderecoId().getRua();
		        }
		        return new SimpleStringProperty(rua);
		    });
		
		
		
	    // Configuração da coluna de telefone com formatação
		  // Configuração da coluna de telefone com formatação
	    columnTelefone.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTelefone()));
	   
	    
	    
	    
columnTelefone.setCellFactory(tc -> new TableCell<Fornecedores, Long>(){
	
	//máscara responsável pela formatação de número de telefone com base no modelo (99) 99999-9999
    @Override
    protected void updateItem(Long telefone, boolean empty) {
    	
        super.updateItem(telefone, empty);
        
        //caso o numero venha vazio a mascara não será aplicada
        if (telefone == null || empty) {
            setText(null);
            // faz a formatação com base na quantidade de caracteres dentro do atributo 'Telefone'da classe 'Fornecedores'
            //padrão de número de telefone com 11 dígitos no modelo Brasileiro (padrões do tipo EUA não irão funcionar)
        } else {
            String telefoneStr = String.valueOf(telefone);
            if (telefoneStr.length() == 10) {
                setText("(" + telefoneStr.substring(0, 2) + ") " +
                        telefoneStr.substring(2, 6) + "-" +
                        telefoneStr.substring(6));
            } else if (telefoneStr.length() == 11) {
                setText("(" + telefoneStr.substring(0, 2) + ") " +
                        telefoneStr.substring(2, 7) + "-" +
                        telefoneStr.substring(7));
            } else {
                setText(telefoneStr);
            }
        }
    }
});
		
		
		carregarFornecedores();
	}
	
	
	@FXML
	public void abrirTelaCadastroFornecedores(ActionEvent event) {
		try{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Cadastro_fornecedor.fxml"));
		Parent root = loader.load();
		
		
		
        ControllerCadastroFornecedores controllerNovaTela = loader.getController();

		
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		
		
		
		
		
		stage.setScene(scene);
		stage.show();
		
		} catch (IOException e){
			e.printStackTrace();
		}
		
	    // Lógica para salvar os dados
	}
	
	
	public void carregarFornecedores() {
		FornecedorDAO dao = new FornecedorDAO();
		
		ArrayList<Fornecedores> fornecedores = dao.listar();
		
		obsFornecedores = FXCollections.observableArrayList(fornecedores);
		tableFornecedores.setItems(obsFornecedores);
	}
	
	
	
	
	public class TelefoneFormatter {
	    public static String formatTelefoneBrasil(int telefone) {
	        String telefoneStr = String.valueOf(telefone);
	        if (telefoneStr.length() == 10) { // (XX) XXXX-XXXX
	            return "(" + telefoneStr.substring(0, 2) + ") " + 
	                   telefoneStr.substring(2, 6) + "-" + telefoneStr.substring(6);
	        } else if (telefoneStr.length() == 11) { // (XX) XXXXX-XXXX
	            return "(" + telefoneStr.substring(0, 2) + ") " + 
	                   telefoneStr.substring(2, 7) + "-" + telefoneStr.substring(7);
	        }
	        return telefoneStr; // Retornar sem formatação se não corresponder a nenhum padrão
	    }
	}

}
