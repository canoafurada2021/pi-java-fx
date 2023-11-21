package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	//primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/imgs/favicon.png")));

    	
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Funcionarios.fxml"));
        Parent root = loader.load();
		 root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		ControllerTableViewFuncionarios controller = loader.getController(); // Obtém uma referência ao controlador

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}