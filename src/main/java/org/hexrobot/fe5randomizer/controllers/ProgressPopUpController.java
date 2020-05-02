package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.LoadRomService;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class ProgressPopUpController {
    @FXML
    private VBox progressPopUp;
    @FXML
    private Label lblMessage;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button button;
    
    public void setLoadRomService(LoadRomService loadRomService) {
        lblMessage.textProperty().bind(loadRomService.messageProperty());
        progressBar.progressProperty().bind(loadRomService.progressProperty());
    }
    
    private void cancel() {
        System.out.println("Cancel load!");
    }
}
