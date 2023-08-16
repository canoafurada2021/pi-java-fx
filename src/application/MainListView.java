package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainListView extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/ListView.fxml"));
		Parent root = loader.load();
		ListViewController controller = loader.getController(); // Obtém uma referência ao controlador

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		System.out.println("teste se ta funcionadno o start");
	}

}
