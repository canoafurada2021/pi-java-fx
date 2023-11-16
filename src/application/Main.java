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

    	
<<<<<<< HEAD
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Dashboard.fxml"));
=======
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/Login.fxml"));
>>>>>>> ecefd7195bb0a56cb56db8f7565fe7c1eef3c03c
        Parent root = loader.load();
		// root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

<<<<<<< HEAD
		ControllerDashboard controller = loader.getController(); // Obtém uma referência ao controlador
=======
		ControllerLogin controller = loader.getController(); // Obtém uma referência ao controlador
>>>>>>> ecefd7195bb0a56cb56db8f7565fe7c1eef3c03c

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}