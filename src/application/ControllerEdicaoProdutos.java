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

public class ControllerEdicaoProdutos implements Initializable{

	@FXML
    private Button btnCancelar;

    @FXML
    private Button btnSalvar;

    @FXML
    private ComboBox<?> comboIdVendedor;

    @FXML
    private Label lblMarcaVeiculo;

    @FXML
    private Label lblMarcaVeiculo1;

    @FXML
    private Label lblNomeVeiculo;

    @FXML
    private Label lblNomeVeiculo1;

    @FXML
    private Label lblQuantidadeVeiculos;

    @FXML
    private Label lblTipoVeiculo;

    @FXML
    private Label lblTipoVeiculo1;

    @FXML
    private Pane pnlLocacaoEdicao;

    @FXML
    private TextField txtCpfLocador;

    @FXML
    private TextField txtDataInicio;

    @FXML
    private TextField txtFormPag;

    @FXML
    private TextField txtIdLocacao;

    @FXML
    private TextField txtQuantDias;

    @FXML
    private TextField txtValor;

    @FXML
    void alterarLocacao(ActionEvent event) {

    }

    @FXML
    void cancelarAlteracaoLocacao(ActionEvent event) {

    }

    @FXML
    void comboIdVendedor(ActionEvent event) {

    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
