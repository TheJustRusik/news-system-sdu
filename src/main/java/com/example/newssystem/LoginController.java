package com.example.newssystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    public GridPane rootGPane;
    @FXML
    private Text forgotPass;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField loginField;
    @FXML
    private Button joinButton;
    @FXML
    private CheckBox rememberMe;
    @FXML
    private Button registerButton;


    @FXML
    protected void mouseEnteredToForgotPass(){
        forgotPass.setUnderline(true);
    }
    @FXML
    protected void mouseExitedFromForgotPass(){
        forgotPass.setUnderline(false);
    }
    @FXML
    protected void onForgotPassClick(){

    }
    @FXML
    protected void onJoinClick(){

    }
    @FXML
    protected void onRegisterClick() throws IOException {
        GridPane pane = FXMLLoader.load(getClass().getResource("Register.fxml"));
        rootGPane.getScene().setRoot(pane);
    }


}