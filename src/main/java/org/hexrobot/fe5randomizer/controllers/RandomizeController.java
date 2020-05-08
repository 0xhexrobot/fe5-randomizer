package org.hexrobot.fe5randomizer.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class RandomizeController {
    @FXML
    private VBox randomize;
    
    @FXML
    private void randomize() {
        System.out.println(MainController.randomizeSummary.toString());
    }
}
