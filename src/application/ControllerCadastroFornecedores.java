package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controle.EnderecoDAO;
import controle.FornecedorDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Endereco;
import modelo.Fornecedores;
import utilities.CnpjFormatter;

public class ControllerCadastroFornecedores implements Initializable {

	@FXML
	private Button btnDashboard;

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
	private Button btnSair;

	@FXML
	private Label lblCNPJ;

	@FXML
	private TextField txtCNPJ;

	@FXML
	private Label lblIdEndereco;

	@FXML
	private TextField txtIdEndereco;

	@FXML
	private ComboBox<String> comboEnderecoIds;

	@FXML
	private Label lblNome;

	@FXML
	private TextField txtNome;

	@FXML
	private Label lblTelefone;

	@FXML
	private TextField txtTelefone;

	@FXML
	private Label lblAtividades;

	@FXML
	private TextField txtAtividades;

	@FXML
	private Button btnCadastrar;

	private EnderecoDAO dao = new EnderecoDAO();

	private ArrayList<Endereco> enderecos = dao.listar();

	@FXML
	void cadastrarFornecedor(ActionEvent event) {

		FornecedorDAO daoFornecedor = new FornecedorDAO();

		String nome = txtNome.getText();
		Long telefone = Long.parseLong(txtTelefone.getText());
		String atividaes = txtAtividades.getText();

		String cnpjFormatted = txtCNPJ.getText().replaceAll("\\D", "");
		Long cnpj = Long.parseLong(cnpjFormatted);

		// endereco selecionado
		String selectedEnderecoInfo = comboEnderecoIds.getValue();

		System.out.println("enderço selecionado" + selectedEnderecoInfo);

		int enderecoId = Integer.parseInt(selectedEnderecoInfo.split(" - ")[0]);

		Endereco enderecoSelecionado = encontrarEnderecoPorId(enderecoId);

		Fornecedores f = new Fornecedores();

		f.setNome(nome);
		f.setTelefone(telefone);
		f.setEnderecoId(enderecoSelecionado);
		f.setCnpj(cnpj);
		f.setAtividades(atividaes);

		System.out.println("Cadastro de fornecedor:");
		System.out.println("Nome: " + f.getNome());
		System.out.println("Telefone: " + f.getTelefone());
		System.out.println("CNPJ: " + f.getCnpj());
		System.out.println("Atividades: " + f.getAtividades());
		System.out.println("Endereço selecionado" + f.getEnderecoId());

		daoFornecedor.inserir(f);
		limpaCampos();

	}

	// Aqui você pode adicionar métodos e lógica para lidar com as ações dos botões
	// e interações com os campos de texto.

	// Exemplo de método para manipular o clique do botão "Cadastrar"

	public void initialize(URL url, ResourceBundle resourceBundle) {

		  txtCNPJ.textProperty().addListener((ChangeListener<? super String>) (observableValue, oldValue, newValue) -> {
		        if (newValue != null && !newValue.isEmpty()) {
		            txtCNPJ.setText(CnpjFormatter.formatCnpj(newValue));
		        }
		    });
		
	

		preencherComboBox();
	}

	private void preencherComboBox() {

		System.out.println("enderecos" + enderecos);

		for (Endereco endereco : enderecos) {
			String enderecoInfo = endereco.getId() + " - " + endereco.getRua();
			comboEnderecoIds.getItems().add(enderecoInfo);
		}

	}

	private void limpaCampos() {

		txtNome.setText(null);
		txtTelefone.setText(null);
		txtAtividades.setText(null);
		txtCNPJ.setText(null);

	}

	private Endereco encontrarEnderecoPorId(int enderecoId) {
		for (Endereco endereco : enderecos) {
			if (endereco.getId() == enderecoId) {
				return endereco;
			}
		}
		return null; // Retorna null se não encontrar o endereço
	}

}
