package com.example.newssystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class LoginController extends LogRegWorker {
    static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

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
    private Text problemText;

    @FXML
    public void initialize() throws IOException {
        problemText.setVisible(false);
    }

    @FXML
    protected void onRegisterClick() throws IOException {
        GridPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Register.fxml")));
        rootGPane.getScene().setRoot(pane);
    }

    @FXML
    protected void mouseEnteredToForgotPass() {
        forgotPass.setUnderline(true);
    }

    @FXML
    protected void mouseExitedFromForgotPass() {
        forgotPass.setUnderline(false);
    }

    @FXML
    protected void onForgotPassClick() throws IOException {
        if (checkData(loginField.getText(), 'l')) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("forgetPass.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            problemText.setVisible(false);
        } else {
            problemText.setVisible(true);
            problemText.setText("Incorrect login!");
        }
    }

    @FXML
    protected void onJoinClick() throws IOException {
        createFolder();
        if (checkData(loginField.getText(), 'l')) {
            if (!checkPassword(loginField.getText(), passwordField.getText())) {
                problemText.setVisible(true);
                problemText.setText("Incorrect password!");
                return;
            }
        } else {
            problemText.setVisible(true);
            problemText.setText("Incorrect login!");
            return;
        }

        if (rememberMe.isSelected()) {
            File file = new File(".files/rmmbr.me");
            file.createNewFile();
        }

        GridPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Application.fxml")));
        rootGPane.getScene().setRoot(pane);
    }
}