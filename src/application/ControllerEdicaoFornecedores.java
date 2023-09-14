package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controle.EnderecoDAO;
import controle.FornecedorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import modelo.Endereco;
import modelo.Fornecedor;

public class ControllerEdicaoFornecedores implements Initializable{

	@FXML
	private StackPane StackPanePerfil;

	@FXML
	private Button btnCancelar;

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
	private Button btnProdutos;

	@FXML
	private Button btnSair;

	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnUsuarios;

	@FXML
	private ComboBox<String> comboEnderecoIds;

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
	private Button infoButton;

	@FXML
	private Label lblAtividades;

	@FXML
	private Label lblCNPJ;

	@FXML
	private Label lblFuncao;

	@FXML
	private Label lblIdEndereco;

	@FXML
	private Label lblNome;

	@FXML
	private Label lblNomeVendedor;

	@FXML
	private Label lblTelefone;

	@FXML
	private Pane pnlFormEdicao;

	@FXML
	private TextField txtAtividades;

	@FXML
	private TextField txtCNPJ;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtTelefone;
	
	private EnderecoDAO dao = new EnderecoDAO();

	private ArrayList<Endereco> enderecos = dao.listar();
	
	FornecedorDAO daoFornecedor = new FornecedorDAO();

	
	@FXML
	void abrirDashboard(ActionEvent event) {

	}

	@FXML
	void abrirListaFornecedores(ActionEvent event) {

	}

	@FXML
	void abrirListaFuncionarios(ActionEvent event) {

	}

	@FXML
	void alterarFornecedor(ActionEvent event) {
		
		  // Capture as alterações dos campos do formulário
	    String novoNome = txtNome.getText();
	    String novoAtividades = txtAtividades.getText();
	    long novoTelefone = Long.parseLong(txtTelefone.getText());

	    // Atualize o objeto Fornecedor com as alterações
	    Fornecedor fornecedor = new Fornecedor();
	    fornecedor.setCnpj(fornecedor.getCnpj()); // Defina o ID do fornecedor que você está editando
	    fornecedor.setNome(novoNome);
	    fornecedor.setAtividades(novoAtividades);
	    fornecedor.setTelefone(novoTelefone);
	    
	    
	    if(daoFornecedor.atualizar(fornecedor)) {
	    	System.out.println(("Edição com sucesso"));
	    } else {
	    	System.out.println("Deu ruim");
	    }
	}

	@FXML
	void cancelarAlteracaoFornecedor(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherComboBox();
		txtCNPJ.setDisable(true);

	}
	
	
	private void preencherComboBox() {

		System.out.println("enderecos" + enderecos);

		for (Endereco endereco : enderecos) {
			String enderecoInfo = endereco.getId() + " - " + endereco.getRua();
			comboEnderecoIds.getItems().add(enderecoInfo);
		}

	}

	
	public void setFornecedor(Fornecedor f) {
		txtNome.setText(f.getNome());
		txtCNPJ.setText(String.valueOf(f.getCnpj()));
		txtAtividades.setText(f.getAtividades());
		txtTelefone.setText(String.valueOf(f.getTelefone()));
		
	    if (f.getEnderecoId() != null) {
	        int enderecoIndex = encontrarIndiceEndereco(f.getEnderecoId().getId());
	        String enderecoText = f.getEnderecoId().getRua(); // Suponha que 'getRua()' seja o método que retorna o nome da rua.
            
	        comboEnderecoIds.getEditor().setText(enderecoText);

            
	        if (enderecoIndex != -1) {
	            // Defina o índice no ComboBox
	            comboEnderecoIds.getEditor().setText(enderecoText);

	        	comboEnderecoIds.getSelectionModel().select(enderecoIndex);

	        }
	    }
	}
	
	private int encontrarIndiceEndereco(long enderecoId) {
	    for (int i = 0; i < enderecos.size(); i++) {
	        if (enderecos.get(i).getId() == enderecoId) {
	        	System.out.println("indice"+ i);
	            return i;
	        }
	    }
	    return -1; // Retornar -1 se o ID do endereço não for encontrado (trate isso adequadamente)
	}
}
