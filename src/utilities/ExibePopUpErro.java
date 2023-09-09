package utilities;

import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ExibePopUpErro {

public static void ExibirPopUpErro() {

		try {
            FXMLLoader fxmlLoader = new FXMLLoader(ExibePopUpErro.class.getResource("/visao/PopUpCadastroErro.fxml"));
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
}
