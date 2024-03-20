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
    @FXML
    private Label labelTypeMusic;
    @FXML
    private ComboBox<String> comboMusicBox;

    @FXML
    public void initialize(){
        gameButton.setSelected(true);
    }

    @FXML
    public void handleChooseOne() {
        clearDisabled();

        if(appButton.isSelected()){
            labelTypeMusic.setStyle("-fx-text-fill: gray");
            comboMusicBox.setDisable(true);
            musicButton.setDisable(true);
        } else if (musicButton.isSelected()) {
            labelTypeApp.setStyle("-fx-text-fill: gray");
            gameButton.setDisable(true);
            prodButton.setDisable(true);
            eduButton.setDisable(true);
            appButton.setDisable(true);
        } else {
            clearDisabled();
            appButton.setDisable(false);
            musicButton.setDisable(false);
        }
    }

    @FXML
    public void clearDisabled(){
        labelTypeMusic.setStyle("-fx-text-fill: black");
        comboMusicBox.setDisable(false);

        labelTypeApp.setStyle("-fx-text-fill: black");
        gameButton.setDisable(false);
        prodButton.setDisable(false);
        eduButton.setDisable(false);
    }
}