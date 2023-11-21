package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controle.VendedorDAO;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.Vendedor;
import utilities.ExibePopUpErro;
import utilities.ExibePopUpSucesso;

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
	private ComboBox<String> comboIdVendedor;

	@FXML
	private TextField txtIdVendedor;

	@FXML
	private TextField txtSobrenome;

	@FXML
	private PasswordField txtSenha;

	@FXML
	private TextField txtCPF;

	private VendedorDAO dao = new VendedorDAO();

	private ArrayList<Vendedor> vendedores = dao.listar();

	@FXML
	private void cadastrarFuncionario(ActionEvent event) {

//		String idVendedorSelect = comboIdVendedor.getValue();
//		System.out.println("id selecionado "+ idVendedorSelect);

		Double salario = Double.valueOf(txtSalario.getText());
		String nome = txtNome.getText();
		String sobrenome = txtSobrenome.getText();
		Long cpf = Long.parseLong(txtCPF.getText());
		String senha = txtSenha.getText();
		
		
		Vendedor v = new Vendedor();

		System.out.println("cargo" + v.getTipoAcesso());

		v.setSalario(salario);
		v.setNome(nome);
		v.setSobrenome(sobrenome);
		v.setCpf(cpf);
		v.setSenha(senha);

		try {
		boolean insercaoSucesso = dao.inserir(v);

		limpaCampos();

			if (insercaoSucesso) {
				System.out.println("inserção sucesso" + insercaoSucesso);
				System.out.println("deu bom");
				ExibePopUpSucesso.ExibirPopUpSucesso();
			} else {
				ExibePopUpErro.ExibirPopUpErro();
				System.out.println("n deu bom");

			}
		} catch (Exception e) {

		ExibePopUpSucesso.ExibirPopUpSucesso();

		}

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	// metodo preencher combobox
//	 private void preencherComboBoxVendedor() {
//
//        for (Vendedor vendedor: vendedores) {
//            String vendedorInfo= vendedor.getId_vendedor() + " - " + vendedor.getNome();
//            comboIdVendedor.getItems().add(vendedorInfo);
//        }
//
//    } 

	// metodo p/ comboBox
	private Vendedor encontrarVendedorPorId(int vendedorId) {
		for (Vendedor vendedor : vendedores) {
			if (vendedor.getId_vendedor() == vendedorId) {
				return vendedor;
			}
		}
		return null;
	}

	private void limpaCampos() {

		txtNome.setText(null);
		txtSobrenome.setText(null);
		txtSalario.setText(null);
		txtCPF.setText(null);
		txtSenha.setText(null);

	}

	@FXML
	void abriListFornecedores(ActionEvent event) {
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
	void abriListProd(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Produtos.fxml"));
			Parent root = loader.load();

			ControllerListProdutos controllerNovaTela = loader.getController();

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
	void abriLocacao(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Locacoes.fxml"));
			Parent root = loader.load();

			ControllerListLocacoes controllerNovaTela = loader.getController();

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
	void abrirClientes(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/ListClientes.fxml"));
			Parent root = loader.load();

			ControllerListClientes controllerNovaTela = loader.getController();

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
	void abrirConfiguracao(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Configuracoes.fxml"));
			Parent root = loader.load();

			ControllerConfiguracoes controllerNovaTela = loader.getController();

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
	void abrirDash(ActionEvent event) {
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
	void abrirListCategoria(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Categorias.fxml"));
			Parent root = loader.load();

			ListViewController controllerNovaTela = loader.getController();

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
	void abrirListFuncionarios(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Funcionarios.fxml"));
			Parent root = loader.load();

			ControllerTableViewFuncionarios controllerNovaTela = loader.getController();

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
	void sairCadasFuncionario(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Login.fxml"));
			Parent root = loader.load();

			ControllerLogin controllerNovaTela = loader.getController();

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



}
