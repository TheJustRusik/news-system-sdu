package com.example.newssystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        File file = new File(".files/rmmbr.me");
        FXMLLoader fxmlLoader;
        if (file.exists()) {
            fxmlLoader = new FXMLLoader(getClass().getResource("Application.fxml"));
        } else {
            fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        }
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}