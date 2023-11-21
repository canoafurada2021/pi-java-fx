package utilities;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class ExibePopUpConfExclusao {

    public static boolean ExibirPopUpConfExclusao() {

        try {
            // a parte 'ExibePopUpErro.class' se refere a classe em que esta diretamente definido o metodo 'ExibirPopUpSucesso'
            FXMLLoader fxmlLoader = new FXMLLoader(ExibePopUpErro.class.getResource("/visao/PopUpProsseguirExclusao.fxml"));
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
        return false;
    }
}
