module insy4306.assignment1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens insy4306.assignment1 to javafx.fxml;
    exports insy4306.assignment1;
}