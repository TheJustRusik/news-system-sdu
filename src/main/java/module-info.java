module com.example.newssystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.newssystem to javafx.fxml;
    exports com.example.newssystem;
}