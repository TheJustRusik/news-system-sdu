module com.example.newssystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.newssystem to javafx.fxml;
    exports com.example.newssystem;
}