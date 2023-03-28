package com.example.newssystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    @FXML
    GridPane rootGPane;
    @FXML
    protected void onLoginClick() throws IOException {
        GridPane ppane = FXMLLoader.load(getClass().getResource("Login.fxml"));
        rootGPane.getChildren().setAll(ppane);
    }
}