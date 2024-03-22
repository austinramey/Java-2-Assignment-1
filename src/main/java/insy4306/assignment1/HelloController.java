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
                FileWriter writer = new FileWriter("app.txt", true);
                writer.write(appOutput());
                writer.close();
                Alert success = new Alert(AlertType.CONFIRMATION, "Sucessfully submitted music!");
                success.showAndWait();
                clearFields();
                nameField.requestFocus();
            } else if (musicButton.isSelected()) {
                FileWriter writer = new FileWriter("music.txt", true);
                writer.write(musicOutput());
                writer.close();
                Alert success = new Alert(AlertType.CONFIRMATION, "Sucessfully submitted music!");
                success.showAndWait();
                clearFields();
                nameField.requestFocus();
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
        try{
            returnString += checkEmpty(nameField) + " | ";
            returnString += checkEmpty(streetField) + " | ";
            returnString += checkEmpty(cityField) + " | ";
            returnString += checkEmpty(stateField) + " | ";
            returnString += checkEmpty(zipcodeField) + " | ";
            returnString += appSelection() + " | ";
            returnString += checkEmpty(titleField) + " | ";
            returnString += checkEmpty(dateField) + " | ";
            returnString += checkEmpty(accountField) + " | ";
            returnString += "\n";
            return returnString;
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, e.getMessage());
            alert.showAndWait();
            return "";
        }
    }

    @FXML
    public String musicOutput() {
        String returnString = "";
        try{
            returnString += checkEmpty(nameField) + " | ";
            returnString += checkEmpty(streetField) + " | ";
            returnString += checkEmpty(cityField) + " | ";
            returnString += checkEmpty(stateField) + " | ";
            returnString += checkEmpty(zipcodeField) + " | ";
            returnString += musicSelection() + " | ";
            returnString += checkEmpty(titleField) + " | ";
            returnString += checkEmpty(dateField) + " | ";
            returnString += checkEmpty(accountField) + " | ";
            returnString += "\n";
            return returnString;
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR, e.getMessage());
            alert.showAndWait();
            return "";
        }
    }

    @FXML
    public String checkEmpty(TextField textField) throws Exception {
        if(textField.getText().trim().isEmpty()) {
            textField.requestFocus();
            throw new Exception("This field is empty, please fill it in!");
        } else {
            return textField.getText();
        }
    }

    @FXML
    public String appSelection() throws Exception {
        if(gameButton.isSelected()) {
            return "GAME";
        } else if (prodButton.isSelected()) {
            return "PRODUCTIVITY";
        } else if (eduButton.isSelected()) {
            return "EDUCATION";
        } else {
            throw new Exception("No type of app selected");
        }
    }

    @FXML
    public String musicSelection() throws Exception {
        switch (comboMusicBox.getSelectionModel().getSelectedItem()) {
            case "CHOOSE ONE":
                throw new Exception("No music type selected");
            default:
                return comboMusicBox.getSelectionModel().getSelectedItem();
        }
    }
    
    @FXML
    public void clearFields() {
        nameField.setText("");
        streetField.setText("");
        cityField.setText("");
        stateField.setText("");
        zipcodeField.setText("");
        titleField.setText("");
        dateField.setText("");
        accountField.setText("");
        comboMusicBox.setValue("CHOOSE ONE");
        appButton.setSelected(true);
        prodButton.setSelected(false);
        eduButton.setSelected(false);
        appButton.setSelected(false);
        musicButton.setSelected(false);
        appButton.setDisable(false);
        musicButton.setDisable(false);
        clearDisabled();
    }

    @FXML
    public void handleFinish() {
        System.exit(0);
    }
}