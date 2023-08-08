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

public class TestController implements Initializable{
	
	 @FXML
	    private Button btnCadastro;

	    @FXML
	    private TextField txtCpf;

	    @FXML
	    private TextField txtEmailF;

	    @FXML
	    private TextField txtNomeF;

	    @FXML
	    private PasswordField txtSenhaF;
	    @FXML
	    private Label lblCpf;

	    @FXML
	    private Label lblEmail;

	    @FXML
	    private Label lblNome;

	    @FXML
	    private Label lblSenha;


	    @FXML
	   private void cadastrarFuncionario(ActionEvent event) {

	    	
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

	    	System.out.println("você clicou ...");
	    	lblNome.setText("ola mundo "+ txtNomeF.getText());
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}
