package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import modelo.Vendedor;

public class ControllerEdicaoFuncionario implements Initializable{

	  @FXML
	    private Button btnCancelar;

	    @FXML
	    private Button btnSalvar;

	    @FXML
	    private ComboBox<?> comboIdFuncionario;

	    @FXML
	    private Label lblIdFuncionario;

	    @FXML
	    private Label lblNomeFuncionario;

	    @FXML
	    private Label lblSalario;

	    @FXML
	    private Label lblSobrenomeFuncionario;

	    @FXML
	    private Pane pnlFormEdicao1;

	    @FXML
	    private TextField txtNome;

	    @FXML
	    private TextField txtSalario;

	    @FXML
	    private TextField txtSobrenome;

	    @FXML
	    void alterarFuncionario(ActionEvent event) {

	    }

	    @FXML
	    void cancelarAlteracaoFuncionario(ActionEvent event) {

	    }

	
	Vendedor vendedor = new Vendedor();
	
	public void setVendedor(Vendedor v) {
	    // Preencher os campos do formulário com as informações do vendedor
	    txtNome.setText(v.getNome());
	    txtSobrenome.setText(v.getSobrenome());
	    txtSalario.setText(String.valueOf(v.getSalario()));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
