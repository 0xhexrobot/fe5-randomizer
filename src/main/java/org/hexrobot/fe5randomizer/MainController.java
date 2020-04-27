package org.hexrobot.fe5randomizer;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;

public class MainController {
    @FXML
    private ScrollPane content;
    @FXML
    private LoadRomController loadRomController;

    /*@FXML
    private void initialize() {
        loadRomController.setMainController(this);
    }*/
    
    public void switchToTabbedController() {
        System.out.println("Switching to TabbedController");
    }
}
