package com.example.newssystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Objects;

public class ApplicationController {
    @FXML private GridPane rootroot;
    @FXML private HBox root;
    @FXML private GridPane pane;
    @FXML private Button tech;
    @FXML private Button sport;
    @FXML private Button economy;
    @FXML private Button logout;

    public void initialize() throws IOException {
        onTechClick();
    }

    @FXML protected void onSportClick() throws IOException {
        sport.setStyle("-fx-background-color: #01B075; -fx-font-size: 20");
        tech.setStyle("-fx-background-color: #16171B; -fx-font-size: 20");
        economy.setStyle("-fx-background-color: #16171B; -fx-font-size: 20");

        root.getChildren().remove(pane);
        pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SportNews.fxml")));
        HBox.setMargin(pane,  new Insets(10, 0, 10, 0));
        root.getChildren().add(pane);

    }
    @FXML protected void onTechClick() throws IOException {
        tech.setStyle("-fx-background-color: #01B075; -fx-font-size: 20");
        sport.setStyle("-fx-background-color: #16171B; -fx-font-size: 20");
        economy.setStyle("-fx-background-color: #16171B; -fx-font-size: 20");

        root.getChildren().remove(pane);
        pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TechNews.fxml")));
        HBox.setMargin(pane,  new Insets(10, 0, 10, 0));
        root.getChildren().add(pane);


    }
    @FXML protected void onEconmyClick() throws IOException {
        economy.setStyle("-fx-background-color: #01B075; -fx-font-size: 20");
        tech.setStyle("-fx-background-color: #16171B; -fx-font-size: 20");
        sport.setStyle("-fx-background-color: #16171B; -fx-font-size: 20");

        root.getChildren().remove(pane);
        pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EconomyNews.fxml")));
        HBox.setMargin(pane,  new Insets(10, 0, 10, 0));
        root.getChildren().add(pane);

    }
    @FXML
    protected void onLogoutClick() throws IOException {
        GridPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        rootroot.getScene().setRoot(pane);
    }

}
