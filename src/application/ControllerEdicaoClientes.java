package application;

import java.net.URL;
import java.util.ResourceBundle;

import controle.LocadorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
			long telefone = Long.valueOf(txtTel.getText());
			String pais = txtPais.getText();
			long cnh = Long.valueOf(txtCnh.getText());
			String validadeCar = txtValidadeCateira.getText();
			long identificacaoCarteira = Long.valueOf(txtNumIdent.getText());

			String cpf = txtCpf.getText();

			// Criar objeto Locador
			Locador locador = new Locador();
			locador.setNome(nome);
			locador.setSobrenome(sobrenome);
			locador.setTelefone(telefone);
			locador.setPaisResidencia(pais);
			locador.setCnh(cnh);
			locador.setValidadeCarteira(validadeCar);
			locador.setNumIdentificacaoCarteira(identificacaoCarteira);
			locador.setPessoas_cpf(cpf);


			// Imprimir dados para verificar
			System.out.println("nome: " + locador.getNome());
			System.out.println("sobrenome: " + locador.getSobrenome());
			System.out.println("telefone: " + locador.getTelefone());
			System.out.println("pais: " + locador.getPaisResidencia());
			System.out.println("cnh: " + locador.getCnh());
			System.out.println("validade carteira: " + locador.getValidadeCarteira());
			System.out.println("identificacao carteira: " + locador.getNumIdentificacaoCarteira());

			// Chamar o método atualizar do dao
			if (dao.atualizar(locador)) {
				ExibePopUpSucesso.ExibirPopUpSucesso();
				Node source = (Node) event.getSource();
				Stage stage = (Stage) source.getScene().getWindow();
				stage.getOnCloseRequest().handle(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
				stage.close();
			} else {
				ExibePopUpErro.ExibirPopUpErro();




			}
		}




	    @FXML
	    void cancelarAlteracaoLocador(ActionEvent event) {
			Node source = (Node) event.getSource();

			// Obtém o Stage (janela) atual com base no Node
			Stage stage = (Stage) source.getScene().getWindow();

			// Fecha o Stage atual
			stage.close();
	    }
	    
	    Locador locador = new Locador();
	public void setLocador(Locador l) {
		txtCnh.setText(String.valueOf(l.getCnh()));
		txtCpf.setText(l.getPessoas_cpf());
		txtTel.setText(String.valueOf(l.getTelefone()));
		txtNome.setText(l.getNome());
		txtNumIdent.setText(String.valueOf(l.getNumIdentificacaoCarteira()));
		txtPais.setText(l.getPaisResidencia());
		txtSobrenome.setText(l.getSobrenome());
		txtValidadeCateira.setText(l.getValidadeCarteira());
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setLocador(locador);
		txtCpf.setDisable(true);
	}

}
