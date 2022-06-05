package org.hexrobot.fe5randomizer.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import org.hexrobot.fe5randomizer.RandomizationSummary;

public class PalettesController {
    @FXML
    private VBox palettes;
    @FXML
    private CheckBox chkShufflePalettes;
    
    @FXML
    private void initialize() {
        RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();
        chkShufflePalettes.selectedProperty().bindBidirectional(summary.shufflePalettesProperty());
    }
}
