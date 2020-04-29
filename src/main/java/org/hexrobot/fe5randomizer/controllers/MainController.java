package org.hexrobot.fe5randomizer.controllers;

import java.io.IOException;

import org.hexrobot.fe5randomizer.Rom;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController {
    @FXML
    private ScrollPane content;
    @FXML
    private LoadRomController loadRomController;
    
    private Stage stage;
    
    public void switchToSectionsController(Rom rom) throws IOException {
        
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
