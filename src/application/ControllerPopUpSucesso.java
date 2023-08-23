package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerPopUpSucesso implements Initializable {

	
	 @FXML
	    private Pane PanelMensagemEdicaoSucesso;

	    @FXML
	    private Button btnOk;

	    @FXML
	    private ImageView imgCircleCheck;

	    @FXML
	    private Label lblMensagem;

	    @FXML
	    private Label lblSucesso;

	    @FXML
	    private AnchorPane panelEdicaoSucesso;

	    @FXML
	    void abreListagem(ActionEvent event) {
	    	
	    	try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Fornecedores.fxml"));
				Parent root = loader.load();

				ControllerListFornecedores controllerNovaTela = loader.getController();

				Scene scene = new Scene(root);
				Stage stage = new Stage();

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
