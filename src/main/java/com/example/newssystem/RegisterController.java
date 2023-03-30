package com.example.newssystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static com.example.newssystem.LoginController.hashPassword;

public class RegisterController extends LogRegWorker{
    @FXML
    GridPane rootGPane;
    @FXML
    private PasswordField passwordField1;
    @FXML
    private PasswordField passwordField2;
    @FXML
    private TextField loginField;
    @FXML
    private TextField emailField;
    @FXML
    private Button registerButton;
    @FXML
    private Text PStext;
    @FXML
    private ProgressBar PSprogressBar;
    @FXML
    private Text PSprogressText;
    @FXML
    private Text problemText;

    public void initialize(){
        PStext.setVisible(false);
        PSprogressBar.setVisible(false);
        PSprogressText.setVisible(false);
        problemText.setVisible(false);
    }

    @FXML
    protected void onLoginClick() throws IOException {
        GridPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        rootGPane.getScene().setRoot(pane);
    }
    @FXML
    protected boolean checkLogin(){
        if(loginField.getText().length() < 2){
            problemText.setVisible(true);
            problemText.setText("Login can't be less than 2 characters");
            return false;
        }
        if(loginField.getText().length() > 16){
            problemText.setVisible(true);
            problemText.setText("Login can't be more than 16 characters");
            return false;
        }
        if(loginExist(loginField.getText())){
            problemText.setVisible(true);
            problemText.setText("Login are taken");
            return false;
        }
        problemText.setVisible(false);
        return true;
    }
    @FXML
    protected boolean checkEmail(){
        String email = emailField.getText();
        if(!(email.contains("@") && (email.contains(".")))){
            problemText.setVisible(true);
            problemText.setText("Incorrect eMail");
            return false;
        }
        if(emailExist(emailField.getText())){
            problemText.setVisible(true);
            problemText.setText("eMail are taken");
            return false;
        }
        problemText.setVisible(false);
        return true;
    }
    @FXML
    protected boolean checkPass(){
        PSprogressBar.setVisible(true);
        PSprogressText.setVisible(true);
        PStext.setVisible(true);

        double strengthVal = passwordField1.getText().length() / 16d;
        strengthVal = Math.min(strengthVal, 1d);
        if(strengthVal > 0d && strengthVal <= 0.33d){
            PSprogressBar.getStyleClass().removeAll("middle", "high");
            PSprogressText.setText("Weak");
        }else if(strengthVal > 0.33d && strengthVal <= 0.66d){
            PSprogressBar.getStyleClass().removeAll("high");
            PSprogressBar.getStyleClass().add("middle");
            PSprogressText.setText("Middle");
        }else if(strengthVal > 0.66d && strengthVal <= 1d){
            PSprogressBar.getStyleClass().removeAll("middle");
            PSprogressBar.getStyleClass().add("high");
            PSprogressText.setText("High");
        }
        PSprogressBar.setProgress(strengthVal);

        if(passwordField1.getText().length() < 4){
            problemText.setVisible(true);
            problemText.setText("Password's minimum length should be 4");
            return false;
        }
        String pass1 = passwordField1.getText();
        String pass2 = passwordField2.getText();
        if(!pass1.equals(pass2)){
            problemText.setVisible(true);
            problemText.setText("Password mismatch");
            return false;
        }


        problemText.setVisible(false);
        return true;
    }
    private boolean loginExist(String text) {
        return false;//TODO
    }
    private boolean emailExist(String text) {
        return false;//TODO
    }
    @FXML
    protected void onRegisterClick() throws IOException {
        if(!checkLogin()){
            return;
        }else if(!checkEmail()){
            return;
        }else if(!checkPass()){
            return;
        }

        createFolder();

        GridPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Application.fxml")));
        rootGPane.getScene().setRoot(pane);
    }

}
