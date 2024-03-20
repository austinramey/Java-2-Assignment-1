package insy4306.assignment1;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private RadioButton gameButton;
    @FXML
    private RadioButton prodButton;
    @FXML
    private RadioButton eduButton;
    @FXML
    private CheckBox appButton;
    @FXML
    private CheckBox musicButton;
    @FXML
    private Label labelTypeApp;
    // @FXML
    // private ComboBox comboBox;

    @FXML
    public void initialize(){
        gameButton.setSelected(true);
    }

    @FXML
    public void handleChooseOne() {
        if (appButton.isSelected()) {
            labelTypeApp.setStyle("-fx-text-fill: gray");
            gameButton.setDisable(true);
            prodButton.setDisable(true);
            eduButton.setDisable(true);
        } else {
            labelTypeApp.setStyle("-fx-text-fill: black");
            gameButton.setDisable(false);
            prodButton.setDisable(false);
            eduButton.setDisable(false);
        }
    }
}