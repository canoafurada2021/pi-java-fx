package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
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

public class ControllerLogin implements Initializable {

	@FXML
	private Button btnLogin;

	@FXML
	private ImageView imgLogin;

	@FXML
	private Label lblCpf;

	@FXML
	private Label lblLogin;

	@FXML
	private Label lblLogin2;

	@FXML
	private Label lblSenha;

	@FXML
	private AnchorPane panelLogin;

	@FXML
	private Pane panelLogin2;

	@FXML
	private Pane panelLoginDados;

	@FXML
	private SplitPane splitPaneLogin;

	@FXML
	private TextField txtCpf;

	@FXML
	private PasswordField txtSenha;

	@FXML
	void login(ActionEvent event) {

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
