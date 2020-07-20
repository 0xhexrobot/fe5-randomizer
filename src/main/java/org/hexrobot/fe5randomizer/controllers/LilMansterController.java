package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.RandomizationSummary;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

public class LilMansterController {
    @FXML
    private VBox lilManster;
    @FXML
    private CheckBox chkPugi;
    
    @FXML
    private void initialize() {
        RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();
        chkPugi.selectedProperty().bindBidirectional(summary.lilMansterPugiProperty());
    }
}
