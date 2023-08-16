package application;

import java.net.URL;
import java.util.ResourceBundle;

import controle.VendedoresDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modelo.Vendedores;

public class TestController implements Initializable {

	@FXML
	private Button btnCadastro;

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
	private Button btnProdutos;

	@FXML
	private Button btnSair;

	@FXML
	private Button btnUsuarios;

	@FXML
	private Label lblIdVendedor;

	@FXML
	private Label lblNome;

	@FXML
	private Label lblSalario;

	@FXML
	private Label lblSobrenome;

	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtSalario;

	@FXML
	private TextField txtIdVendedor;

	@FXML
	private TextField txtSobrenome;

	@FXML
	private void cadastrarFuncionario(ActionEvent event) {

		int idV = Integer.valueOf(txtIdVendedor.getText());
		Double salario = Double.valueOf(txtSalario.getText());
		String nome = txtNome.getText();
		String sobrenome = txtSobrenome.getText();

		txtIdVendedor.setText(null);
		txtSalario.setText(null);
		txtNome.setText(null);
		txtSobrenome.setText(null);

		// !----VALIDAR SE O MÉTODO DE INSERT VAI FUNCIONAR OU NAO- --!

//	    	String nome = txtNomeF.getText();
//Double salario = Double.valueOf(txtCpf.getText());
//Vendedores v = new Vendedores();
//
//v.setNome(nome);
//v.setSalario(salario);
//
//VendedorDAO dao = new VendedorDAO();
//	    	dao.inserir(v);
//	    	
//	    	txtNomeF.setText(null);
//txtCpf.setText(null);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
