package com.example.newssystem;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

public abstract class NewsPattern {
    String url1;
    String url2;
    String url3;
    String url4;

    @FXML
    public Pane pane1;
    @FXML
    public Pane pane2;
    @FXML
    public Pane pane3;
    @FXML
    public Pane pane4;
    @FXML
    public Text text1;
    @FXML
    public Text text2;
    @FXML
    public Text text3;
    @FXML
    public Text text4;

    @FXML
    public void onMouseEntered(Event event) {
        if (event.getSource() == pane1) {
            text1.setUnderline(true);
        } else if (event.getSource() == pane2) {
            text2.setUnderline(true);
        } else if (event.getSource() == pane3) {
            text3.setUnderline(true);
        } else if (event.getSource() == pane4) {
            text4.setUnderline(true);
        }
    }

    @FXML
    public void onMouseExited(Event event) {
        if (event.getSource() == pane1) {
            text1.setUnderline(false);
        } else if (event.getSource() == pane2) {
            text2.setUnderline(false);
        } else if (event.getSource() == pane3) {
            text3.setUnderline(false);
        } else if (event.getSource() == pane4) {
            text4.setUnderline(false);
        }
    }

    @FXML
    public void onClick(Event event) throws IOException {
        Desktop desktop = Desktop.getDesktop();

        if (event.getSource() == pane1) {
            desktop.browse(URI.create(url1));
        } else if (event.getSource() == pane2) {
            desktop.browse(URI.create(url2));
        } else if (event.getSource() == pane3) {
            desktop.browse(URI.create(url3));
        } else if (event.getSource() == pane4) {
            desktop.browse(URI.create(url4));
        }
    }
}
