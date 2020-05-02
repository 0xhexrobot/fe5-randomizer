package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.Rom;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class SectionsController {
    @FXML
    private VBox sections;
    
    private Rom rom;
    
    @FXML
    private void generateRandomSeed() {
        
    }
    
    @FXML
    private void initialize() {
        System.out.println("Initializing sections controller.");
    }
    
    public void setRom(Rom rom) {
        this.rom = rom;
    }
}
