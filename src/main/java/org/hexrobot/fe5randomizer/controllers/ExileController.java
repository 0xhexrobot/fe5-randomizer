package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.RandomizationSummary;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

public class ExileController {
    @FXML
    private VBox exile;
    @FXML
    private CheckBox chkRenamePugi;

    @FXML
    private void initialize() {
        RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();
        
        chkRenamePugi.selectedProperty().bindBidirectional(summary.projectExileRenamePugiProperty());
    }
}
