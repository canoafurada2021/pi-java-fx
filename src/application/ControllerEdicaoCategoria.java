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
import modelo.Categoria;

public class ControllerEdicaoCategoria implements Initializable{

	  @FXML
	    private Button btnCancelarCategoria;

	    @FXML
	    private Button btnSalvar;

	    @FXML
	    private ComboBox<?> comboIdCategoria;

	    @FXML
	    private Label lblIdCategoria;

	    @FXML
	    private Label lblNomeCategoria;

	    @FXML
	    private Pane pnlFormEdicao1;

	    @FXML
	    private TextField txtNomeCategoria;

	    @FXML
	    void alterarCategoria(ActionEvent event) {

	    }

	    @FXML
	    void cancelarAlteracaoCategoria(ActionEvent event) {

	    }

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	Categoria categoria = new Categoria();
	
	public void setCategoria(Categoria ca) {
		txtNomeCategoria.setText(ca.getCategoria());
		
	}

}
