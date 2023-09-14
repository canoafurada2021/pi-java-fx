package application;

import java.awt.Font;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controle.EnderecoDAO;
import controle.FornecedorDAO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.Endereco;
import modelo.Fornecedor;
import utilities.CnpjFormatter;
import utilities.ExibePopUpErro;
import utilities.ExibePopUpSucesso;
import utilities.TelefoneFormatter;

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

		String telefoneFormat = txtTelefone.getText().replaceAll("[^0-9]", "");
		Long telefone = Long.parseLong(telefoneFormat);

		String atividaes = txtAtividades.getText();

		String cnpjFormatted = txtCNPJ.getText().replaceAll("\\D", "");
		Long cnpj = Long.parseLong(cnpjFormatted);

		// endereco selecionado
		String selectedEnderecoInfo = comboEnderecoIds.getValue();


		int enderecoId = Integer.parseInt(selectedEnderecoInfo.split(" - ")[0]);

		Endereco enderecoSelecionado = encontrarEnderecoPorId(enderecoId);

		Fornecedor f = new Fornecedor();

		f.setNome(nome);
		f.setTelefone(telefone);
		f.setEnderecoId(enderecoSelecionado);
		f.setAtividades(atividaes);
		f.setCnpj(cnpj);

		try {

			boolean insercaoSucesso = daoFornecedor.inserir(f);

			limpaCampos();

			if (insercaoSucesso) {
				ExibePopUpSucesso.ExibirPopUpSucesso();
			} else {
	        	ExibePopUpErro.ExibirPopUpErro();
			}

		} catch (Exception e) {

			ExibePopUpSucesso.ExibirPopUpSucesso();

		}

	}



	public void initialize(URL url, ResourceBundle resourceBundle) {


		txtTelefone.textProperty()
				.addListener((ChangeListener<? super String>) (observableValue, oldValue, newValue) -> {
					if (newValue != null && !newValue.isEmpty()) {
						txtTelefone.setText(TelefoneFormatter.formatTelefoneBrasil(newValue));
					}
				});

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

	@FXML
	void abrirDashboard(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Dashboard.fxml"));
			Parent root = loader.load();

			ControllerDashboard controllerNovaTela = loader.getController();

			Scene scene = new Scene(root);
			Stage stage = new Stage();
			// fecha a tela atual
			Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stageAtual.close();

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void abrirListaFornecedores(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Fornecedores.fxml"));
			Parent root = loader.load();

			ControllerListFornecedores controllerNovaTela = loader.getController();

			Scene scene = new Scene(root);
			Stage stage = new Stage();

			// fecha a tela atual
			Stage stageAtual = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stageAtual.close();

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void abrirListaFuncionarios(ActionEvent event) {

	}

}
