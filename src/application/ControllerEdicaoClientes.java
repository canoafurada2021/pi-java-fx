package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import modelo.Locador;

public class ControllerEdicaoClientes implements Initializable{

	 @FXML
	    private Button btnCancelar;

	    @FXML
	    private Button btnSalvar;

	    @FXML
	    private DatePicker dateDataValidade;

	    @FXML
	    private Label lblCnh;

	    @FXML
	    private Label lblCpf;

	    @FXML
	    private Label lblNome;

	    @FXML
	    private Label lblNumeroIdent;

	    @FXML
	    private Label lblPais;

	    @FXML
	    private Label lblSobrenome;

	    @FXML
	    private Label lblTelefone;

	    @FXML
	    private Label lblValidadeCardeira;

	    @FXML
	    private Pane pnlLocadorEdicao;

	    @FXML
	    private TextField txtCnh;

	    @FXML
	    private TextField txtCpf;

	    @FXML
	    private TextField txtTel;

	    @FXML
	    private TextField txtNome;

	    @FXML
	    private TextField txtNumIdent;

	    @FXML
	    private TextField txtPais;

	    @FXML
	    private TextField txtSobrenome;

	    @FXML
	    void alterarLocador(ActionEvent event) {

	    }

	    @FXML
	    void cancelarAlteracaoLocador(ActionEvent event) {

	    }
	    
	    Locador locador = new Locador();
	    public void setLocador(Locador l) {
	    	txtCnh.setText(l.getCnh().toString());
	    	txtCpf.setText(l.getPessoas_cpf());
	    	txtTel.setText(l.getTel_contato().toString());
	    	txtNome.setText(l.getNome());
	    	txtNumIdent.setText(l.getNumIdentificacaoCarteira().toString());
	    	txtPais.setText(l.getPaisResidencia());
	    	txtSobrenome.setText(l.getSobrenome());
	    }
	    
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
