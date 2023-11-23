package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controle.LoginDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utilities.ExibePopUpErro;

public class ControllerLogin implements Initializable {

	@FXML
	private SplitPane splitPaneLogin;

	@FXML
	private AnchorPane panelLogin;

	@FXML
	private Pane panelLoginDados;

	@FXML
	private Button btnLogin;

	@FXML
	private Label lblCpf;

	@FXML
	private Label lblSenha;

	@FXML
	private TextField txtSenha;

	@FXML
	private TextField txtCpf;

	@FXML
	private Button btnViewOpen;

	@FXML
	private ImageView imgEyeOpen;

	@FXML
	private Button btnViewClosed;

	@FXML
	private ImageView imgEyeClosed;

	@FXML
	private Pane panelLogin2;

	@FXML
	private Label lblLogin;

	@FXML
	private Label lblLogin2;

	private LoginDAO dao = new LoginDAO();
	
	@FXML
	void login(ActionEvent event) {
		
		  String cpf = txtCpf.getText();
	        String senha = txtSenha.getText();

	        // metodo de login atribuido a uma variável do tipo boolean
	        boolean loginSucesso = dao.fazerLogin(cpf, senha);
		
		
	        if(loginSucesso){
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
	        } else {
	        	ExibePopUpErro.ExibirPopUpErro();
	        	
	        }

	}



	private boolean senhaVisivel = false;
	@FXML
	void toggleView(ActionEvent event) {
		senhaVisivel = !senhaVisivel;

		if (senhaVisivel) {
			txtSenha.setStyle("-fx-text-fill: black;");
			txtSenha.setText(txtSenha.getText());
		} else {
			String mascara = "*".repeat(txtSenha.getText().length());
			txtSenha.setStyle("-fx-text-fill: transparent;");
			txtSenha.setText(mascara);
		}

		// Alternar entre os botões "abrir olho" e "fechar olho"
		btnViewOpen.setVisible(!senhaVisivel);
		btnViewClosed.setVisible(senhaVisivel);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtSenha.setManaged(true);
		txtSenha.setText(" ");

		btnViewOpen.setOnAction(this::toggleView);
		btnViewClosed.setOnAction(this::toggleView);
	}

}
