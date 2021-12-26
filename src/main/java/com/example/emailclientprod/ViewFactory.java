package com.example.emailclientprod;

import com.example.emailclientprod.controller.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private EmailManager emailManager;
    private ArrayList<Stage> activeStages;
    private boolean mainViewInitialised = false;

    public boolean isMainViewInitialised() {
        return mainViewInitialised;
    }


    public ViewFactory(EmailManager emailManager) {

        this.emailManager = emailManager;
        this.activeStages = new ArrayList<Stage>();
    }

    // View options handling
    private ColorTheme colorTheme = ColorTheme.DARK;
    private FontSize fontSize = FontSize.MEDIUM;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public void showLoginWindow() {
        System.out.println("Login window called");
        BaseController controller = new LoginWindowController(emailManager, this, "login.fxml");
        initializeStage(controller);

    }

    public void showMainWindow() {
        System.out.println("Main window called");
        BaseController controller = new MainWindowController(emailManager, this, "mainwindow.fxml");
        initializeStage(controller);
        mainViewInitialised = true;

    }

    public void showOptionsWindow() {
        System.out.println("Options window called");
        BaseController controller = new OptionsWindowController(emailManager, this, "OptionsWindow.fxml");
        initializeStage(controller);

    }



    private void initializeStage(BaseController baseController) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFXMLName()));
        fxmlLoader.setController(baseController);
        Parent parent;

        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        activeStages.add(stage);
    }

    public void closeStage(Stage stage) {
        stage.close();
        activeStages.remove(stage);
    }

    public void updateStyle() {
        for(Stage stage: activeStages) {
            Scene scene = stage.getScene();
            // handle the CSS
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource(ColorTheme.getCssPath(colorTheme)).toExternalForm());
            scene.getStylesheets().add(getClass().getResource(FontSize.getCssPath(fontSize)).toExternalForm());

        }
    }

}
