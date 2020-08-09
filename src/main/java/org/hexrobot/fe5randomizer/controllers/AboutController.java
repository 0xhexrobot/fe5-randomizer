package org.hexrobot.fe5randomizer.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AboutController {
    @FXML
    private Label lblVersion;
    
    @FXML
    private void initialize() {
        lblVersion.setText(MainController.VERSION);
    }
}
