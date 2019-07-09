package chem;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController extends Controller {
    @FXML
    private Button calc1;
    @FXML
    private Button calc2;
    @FXML
    private Button calc3;
    @FXML
    private Button calc4;
    @FXML
    private Button calc5;
    @FXML
    private Button button_exit;

    @FXML
    public void goto_neutral() {
        try {
            System.out.println("중화");
            sceneChange(calc1, "neutral");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goto_energycalc() {
        try {
            sceneChange(calc1, "energycalc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goto_avogadro() {
        try {
            sceneChange(calc1, "avogadro");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goto_oxidation() {
        try {
            sceneChange(calc1, "oxidation");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goto_dipole() {
        try {
            sceneChange(calc1, "dipole");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exit() {
        Platform.exit();
    }

}
