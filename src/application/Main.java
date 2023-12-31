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

    	
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Login.fxml"));
        Parent root = loader.load();
        root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		ControllerLogin controller = loader.getController(); // Obtém uma referência ao controlador

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}