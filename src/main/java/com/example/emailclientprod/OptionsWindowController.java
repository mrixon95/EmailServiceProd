package com.example.emailclientprod;

import com.example.emailclientprod.controller.BaseController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsWindowController extends BaseController implements Initializable {

    @FXML
    private Slider fontsizePicker;

    @FXML
    private ChoiceBox<ColorTheme> themePicker;

    public OptionsWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void applyButtonAction(ActionEvent event) {
        viewFactory.setColorTheme(themePicker.getValue());
        viewFactory.setFontSize(FontSize.values()[(int) (fontsizePicker.getValue()) ]);
        viewFactory.updateStyle();
        System.out.println(viewFactory.getColorTheme());
        System.out.println(viewFactory.getFontSize());

    }

    @FXML
    void cancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) fontsizePicker.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUpThemePicker();
        setUpSizePicker();
    }

    private void setUpSizePicker() {
        fontsizePicker.setMin(0);
        fontsizePicker.setMax(FontSize.values().length - 1);
        fontsizePicker.setValue(viewFactory.getFontSize().ordinal());
        fontsizePicker.setMajorTickUnit(1);
        fontsizePicker.setMinorTickCount(0);
        fontsizePicker.setBlockIncrement(1);
        fontsizePicker.setSnapToTicks(true);
        fontsizePicker.setShowTickMarks(true);
        fontsizePicker.setShowTickLabels(true);


        fontsizePicker.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double aDouble) {
                int i = aDouble.intValue();
                return FontSize.values()[i].toString();
            }

            @Override
            public Double fromString(String s) {
                return null;
            }
        });

        fontsizePicker.valueProperty().addListener(( observable, oldValue, newValue ) -> {
            fontsizePicker.setValue(newValue.intValue());
        });

    }

    private void setUpThemePicker() {
        themePicker.setItems(FXCollections.observableArrayList(ColorTheme.values()));
        themePicker.setValue(viewFactory.getColorTheme());
    }
}
