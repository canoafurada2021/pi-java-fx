package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controle.VendedorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import modelo.Vendedor;
import utilities.ExibePopUpErro;
import utilities.ExibePopUpSucesso;

public class ControllerEdicaoFuncionario implements Initializable {

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnSalvar;

	@FXML
	private ComboBox<Integer> comboIdFuncionario;

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

	private VendedorDAO dao = new VendedorDAO();
	private ArrayList<Vendedor> vendedores = dao.listar();

	@FXML
	void alterarFuncionario(ActionEvent event) {
		String nomeNovo = txtNome.getText();
		Double salarioNovo = Double.parseDouble(txtSalario.getText());
		String sobrenomeNovo = txtSobrenome.getText();

		Vendedor vendedor = new Vendedor();

		vendedor.setIdVendedor(comboIdFuncionario.getValue());
		vendedor.setNome(nomeNovo);
		vendedor.setSalario(salarioNovo);
		vendedor.setSobrenome(sobrenomeNovo);

		if (dao.atualizar(vendedor)) {
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
	void cancelarAlteracaoFuncionario(ActionEvent event) {

		// Obtém o Node (geralmente um botão) que acionou o evento
		Node source = (Node) event.getSource();

		// Obtém o Stage (janela) atual com base no Node
		Stage stage = (Stage) source.getScene().getWindow();

		// Fecha o Stage atual
		stage.close();

	}

	Vendedor vendedor = new Vendedor();

	public void setVendedor(Vendedor v) {
		// Preencher os campos do formulário com as informações do vendedor
		txtNome.setText(v.getNome());
		txtSobrenome.setText(v.getSobrenome());
		txtSalario.setText(String.valueOf(v.getSalario()));

		Integer idVendedor = v.getId_vendedor();

		if (idVendedor != null) {
			int vendedorIndex = encontrarIndexVendedor(v.getId_vendedor());
			String vendedorText = String.valueOf(v.getId_vendedor());

			comboIdFuncionario.getEditor().setText(vendedorText);

			if (vendedorIndex != -1) {
				comboIdFuncionario.getEditor().setText(vendedorText);

				comboIdFuncionario.getSelectionModel().select(vendedorIndex);
			}

		}
	}

	private int encontrarIndexVendedor(long vendedorId) {
		for (int i = 0; i < vendedores.size(); i++) {
			if (vendedores.get(i).getId_vendedor() == vendedorId) {
				System.out.println("indeice: " + i);
				return i;
			}
		}
		return -1; // vai retornar -q se o ID do endereco nao for encontrado
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		preencherComboBoxVendedorAlter();
		comboIdFuncionario.setDisable(true);
	}

	private void preencherComboBoxVendedorAlter() {
		for (Vendedor vendedor : vendedores) {
			int infoVendedor = vendedor.getId_vendedor();
			comboIdFuncionario.getItems().add(infoVendedor);
		}
	}

	// metodo p combobox 
	
	//achoq  repeteiu
	private Vendedor encontrarVendedorPeloId(int idVendedor) {
		for (Vendedor vendedor : vendedores) {
			if (vendedor.getId_vendedor() == idVendedor) {
				return vendedor;
			}
		}
		return null;
	}

}
