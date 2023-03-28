package com.example.newssystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    // Declare any @FXML-annotated fields here:
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;

    // Declare any non-FXML fields or methods here:
    private Stage primaryStage;

    // Define any @FXML-annotated methods here:
    @FXML
    private void handleLoginButtonAction() {
        try {
            // Load the Login.fxml file using the FXMLLoader
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();

            // Create a new Scene using the loaded root node and set it on the primary stage
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);

            // Get a reference to the LoginController and pass the primary stage to it

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleRegisterButtonAction() {
        try {
            // Load the Register.fxml file using the FXMLLoader
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));
            Parent root = loader.load();

            // Create a new Scene using the loaded root node and set it on the primary stage
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);

            // Get a reference to the RegisterController and pass the primary stage to it

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Define any non-FXML methods here:
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
