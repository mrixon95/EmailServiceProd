package com.example.emailclientprod;

import com.example.emailclientprod.controller.BaseController;
import com.example.emailclientprod.controller.EmailLoginResult;
import com.example.emailclientprod.controller.services.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController extends BaseController implements Initializable {

    // MVC used for UI, separates functionality

    @FXML
    private TextField emailAddressField;

    @FXML
    private Label errorLabel;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction() {
        if (fieldsAreValid()) {
            EmailAccount emailAccount = new EmailAccount(emailAddressField.getText(), passwordField.getText());
            LoginService loginService = new LoginService(emailAccount, emailManager);
            loginService.start();
            loginService.setOnSucceeded(event ->
            {
                EmailLoginResult emailLoginResult = loginService.getValue();
                switch (emailLoginResult) {
                    case SUCCESS -> {
                        System.out.println("Login success!!!" + emailAccount);
                        if (!viewFactory.isMainViewInitialised()) {
                            viewFactory.showMainWindow();
                        }

                        Stage stage = (Stage) errorLabel.getScene().getWindow();
                        viewFactory.closeStage(stage);
                    } case FAILED_BY_UNEXPECTED_ERROR -> {
                        System.out.println("Unexpected Error");
                    } case FAILED_BY_CREDENTIALS -> {
                        System.out.println("Invalid credentials");
                    } default -> {
                        return;
                    }
                }
            });


        }

    }

    private boolean fieldsAreValid() {
        if (emailAddressField.getText().isEmpty()) {
            errorLabel.setText("Please fill email");
            return false;
        }
        if (passwordField.getText().isEmpty()) {
            errorLabel.setText("Please fill password");
            return false;
        }
        return true;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        emailAddressField.setText("michaelrixon95@gmail.com");
        passwordField.setText("Stephen22968402###");
    }
}
