package com.example.newssystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.RandomAccessFile;


public class ForgetPassController extends LogRegWorker{
    @FXML
    private TextField login;
    @FXML
    private TextField eMail;
    @FXML
    private Button restore;
    @FXML
    private Text label;

    @FXML
    protected void onRestoreClick() throws IOException {
        if(checkData(login.getText(), 'l') && checkData(eMail.getText(), 'e')){
            RandomAccessFile file = new RandomAccessFile(".files/file.txt", "r");
            file.seek(0);
            String buff;
            while ((buff = file.readLine()) != null) {
                if (buff.equals("login: " + login.getText())) {
                    buff = file.readLine();
                    break;
                }
            }
            label.setText(buff);
            restore.setVisible(false);

        }else{
            label.setText("Wrong eMail, or Login");
        }
    }

}
