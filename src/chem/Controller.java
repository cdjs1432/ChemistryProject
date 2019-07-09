package chem;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {


    @FXML
    private Button button_goback;

    @FXML
    public void sceneChange(Button button, String str) throws Exception {
        Stage stage = (Stage) button.getScene().getWindow();
        Parent loader = FXMLLoader.load(getClass().getResource("/chem/" + str + ".fxml"));
        Scene scene = new Scene(loader, 600, 450);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    @FXML
    public void return_main() {
        try {
            sceneChange(button_goback, "MainScreen");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
