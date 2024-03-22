package insy4306.assignment1;

import java.io.FileWriter;
import java.nio.file.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

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
    private TextField nameField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField stateField;
    @FXML
    private TextField zipcodeField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField accountField;
    @FXML
    private boolean errorCheck=true;

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

    @FXML
    public void handleSubmit(){
        try {
            if(appButton.isSelected()){
                // Path path = Paths.get("app.txt");
                // String appOutput = appOutput();
                // Files.write(path, appOutput.getBytes(), StandardOpenOption.APPEND);
                FileWriter writer = new FileWriter("app.txt");
                writer.write(appOutput());
                writer.close();
            } else if (musicButton.isSelected()) {
                // Path path = Paths.get("music.txt");
                // String musicOutput = musicOutput();
                // Files.write(path, musicOutput.getBytes(), StandardOpenOption.APPEND);
                FileWriter writer = new FileWriter("music.txt");
                writer.write(musicOutput());
                writer.close();
            } else {
                nameField.requestFocus();
                Alert alert = new Alert(AlertType.ERROR, "Neither App nor Music Selected!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public String appOutput() {
        String returnString = "";
        while(errorCheck) {
            returnString += checkEmpty(nameField) + " | ";
            returnString += checkEmpty(streetField) + " | ";
            returnString += checkEmpty(cityField) + " | ";
            returnString += checkEmpty(stateField) + " | ";
            returnString += checkEmpty(zipcodeField) + " | ";
            returnString += checkEmpty(titleField) + " | ";
            returnString += checkEmpty(dateField) + " | ";
            returnString += checkEmpty(accountField) + " | ";
            returnString += "\n";
            break;
        }
        if(errorCheck) {
            return returnString;    
        } else {
            errorCheck = true;
            return "";
        }
    }

    @FXML
    public String musicOutput() {
        String returnString = "";
        while(errorCheck) {
            returnString += checkEmpty(nameField) + " | ";
            returnString += checkEmpty(streetField) + " | ";
            returnString += checkEmpty(cityField) + " | ";
            returnString += checkEmpty(stateField) + " | ";
            returnString += checkEmpty(zipcodeField) + " | ";
            returnString += checkEmpty(titleField) + " | ";
            returnString += checkEmpty(dateField) + " | ";
            returnString += checkEmpty(accountField) + " | ";
            returnString += "\n";
            break;
        }
        if(errorCheck) {
            return returnString;    
        } else {
            errorCheck = true;
            return "";
        }
    }

    @FXML
    public String checkEmpty(TextField textField) {
        if(textField.getText().trim().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR, "One of your fields is empty");
            alert.showAndWait();
            textField.requestFocus();
            return "";
        } else {
            errorCheck=true;
            return textField.getText();
        }
    }
    
    @FXML
    public void handleFinish() {
        System.exit(0);
    }
}