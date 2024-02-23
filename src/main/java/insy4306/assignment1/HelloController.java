package insy4306.assignment1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private RadioButton gameButton;
    @FXML
    private RadioButton prodButton;
    @FXML
    private RadioButton eduButton;

    public void initialize(){
        gameButton.setSelected(true);
    }



}