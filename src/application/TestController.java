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

	private VendedorDAO dao = new VendedorDAO();

	private ArrayList<Vendedor> vendedores = dao.listar();

	@FXML
	private void cadastrarFuncionario(ActionEvent event) {

//		String idVendedorSelect = comboIdVendedor.getValue();
//		System.out.println("id selecionado "+ idVendedorSelect);
		
		Double salario = Double.valueOf(txtSalario.getText());
		String nome = txtNome.getText();
		String sobrenome = txtSobrenome.getText();
		

		
		 
		
		Vendedor v = new Vendedor();
	
		System.out.println("cargo"+v.getTipoAcesso());
		
		v.setSalario(salario);
		v.setNome(nome);
		v.setSobrenome(sobrenome);
		
		try {

			boolean insercaoSucesso = dao.inserir(v);

			limpaCampos();

			if (insercaoSucesso) {
				ExibirPopUpSucesso();
			} else {
				ExibirPopUpErro();
			}

		} catch (Exception e) {

			ExibirPopUpSucesso();

		}

		
	

	}
	private void ExibirPopUpSucesso() {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/visao/PopUpCadastroSucesso.fxml"));
			Parent popupRoot = fxmlLoader.load();

			Stage popupStage = new Stage();
			popupStage.initModality(Modality.APPLICATION_MODAL);
			popupStage.setTitle("Success Popup");

			Scene popupScene = new Scene(popupRoot);
			popupStage.setScene(popupScene);
			popupStage.show();

			// Define the duration for displaying the popup (in milliseconds)
			int popupDuration = 3000; // Change this value as needed

			// Create a Timeline to close the popup after the specified duration
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(popupDuration), event -> {
				popupStage.close();
			}));
			timeline.setCycleCount(1);
			timeline.play();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void ExibirPopUpErro() {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/visao/PopUpCadastroErro.fxml"));
			Parent popupRoot = fxmlLoader.load();

			Stage popupStage = new Stage();
			popupStage.initModality(Modality.APPLICATION_MODAL);
			popupStage.setTitle("Error Popup");

			Scene popupScene = new Scene(popupRoot);
			popupStage.setScene(popupScene);
			popupStage.show();

			// Define the duration for displaying the popup (in milliseconds)
			int popupDuration = 3000; // Change this value as needed

			// Create a Timeline to close the popup after the specified duration
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(popupDuration), event -> {
				popupStage.close();
			}));
			timeline.setCycleCount(1);
			timeline.play();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		}
	
	//metodo preencher combobox
//	 private void preencherComboBoxVendedor() {
//
//        for (Vendedor vendedor: vendedores) {
//            String vendedorInfo= vendedor.getId_vendedor() + " - " + vendedor.getNome();
//            comboIdVendedor.getItems().add(vendedorInfo);
//        }
//
//    } 
	
	//metodo p/ comboBox
	private Vendedor encontrarVendedorPorId(int vendedorId) {
		for (Vendedor vendedor : vendedores) {
			if(vendedor.getId_vendedor()== vendedorId) {
				return vendedor;
			}
		}
		return null;
	}

	private void limpaCampos() {

		txtNome.setText(null);
		txtSobrenome.setText(null);
		txtSalario.setText(null);

	}
}
