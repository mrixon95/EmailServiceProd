package com.example.emailclientprod;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        // https://github.com/barosanuemailtest/JavaFxEmailClientCourse/commit/1b62360566f4ef6624e999282d522dd829f71fce
        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.showLoginWindow();
        viewFactory.updateStyle();

    }

    public static void main(String[] args) {
        launch();
    }


}
