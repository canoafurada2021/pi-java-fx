package application;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import controle.LocadorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import modelo.Locador;
import utilities.ExibePopUpErro;
import utilities.ExibePopUpSucesso;

public class ControllerEdicaoClientes implements Initializable{

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnSalvar;

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
	private TextField txtNome;

	@FXML
	private TextField txtNumIdent;

	@FXML
	private TextField txtPais;

	@FXML
	private TextField txtSobrenome;

	@FXML
	private TextField txtTel;

	@FXML
	private TextField txtValidadeCateira;

		private LocadorDAO dao = new LocadorDAO();
	    @FXML
	    void alterarLocador(ActionEvent event) {
			String nome = txtNome.getText();
			String sobrenome = txtSobrenome.getText();
			Long telefone = Long.valueOf(txtTel.getText());
			String pais =txtPais.getText();
			Long cnh = Long.valueOf(txtCnh.getText());
			String validadeCar = txtValidadeCateira.getText();
			Long indentificacaoCarteira = Long.valueOf(txtNumIdent.getText());

			Locador locador = new Locador();

			locador.setNome(nome);
			locador.setSobrenome(sobrenome);
			locador.setTel_contato(telefone);
			locador.setPaisResidencia(pais);
			locador.setCnh(cnh);
			locador.setValidadeCarteira(validadeCar);
			locador.setNumIdentificacaoCarteira(indentificacaoCarteira);


			if(dao.atualizar(locador)){
				ExibePopUpSucesso.ExibirPopUpSucesso();

				Node source = (Node) event.getSource();
				Stage stage = (Stage) source.getScene().getWindow();

				stage.getOnCloseRequest().handle(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));

				System.out.println("deu bomba " + stage);

				// Verifica se onCloseRequest é nulo antes de chamar handle

				stage.close();
			} else {
				ExibePopUpErro.ExibirPopUpErro();
				System.out.println("bomba");
			}
		}




	    @FXML
	    void cancelarAlteracaoLocador(ActionEvent event) {

//			// Obtém o Stage (janela) atual com base no Node
//			Stage stage = (Stage)             source.getScene().getWindow();
//
//			// Fecha o Stage atual
//			stage.close();
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
		txtValidadeCateira.setText(l.getValidadeCarteira());


	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtCpf.setDisable(true);
	}

}
