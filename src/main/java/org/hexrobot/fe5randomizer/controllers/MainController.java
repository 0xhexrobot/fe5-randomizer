package org.hexrobot.fe5randomizer.controllers;

import java.io.IOException;

import org.hexrobot.fe5randomizer.ChangesTracker;
import org.hexrobot.fe5randomizer.RandomizeSummary;
import org.hexrobot.fe5randomizer.Rom;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class MainController {
    @FXML
    private ScrollPane content;
    @FXML
    private Label lblStatus;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private LoadRomController loadRomController;
    
    private static MainController instance;
    private Stage stage;
    private SectionsController sectionsController;
    private Parent vBox;
    private RandomizeSummary randomizeSummary;
    private Rom rom;
    private ChangesTracker changesTracker;
    
    public MainController() {
        instance = this;
        changesTracker = new ChangesTracker();
    }
    
    public static MainController getInstance() {
        return instance;
    }
    
    @FXML
    private void initialize()  throws IOException {
        randomizeSummary = new RandomizeSummary();
        loadRomController.setMainController(this);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Sections.fxml"));
        vBox = loader.load();
        sectionsController = loader.getController();
        
        lblStatus.setVisible(false);
        progressBar.setVisible(false);
    }
    
    public void switchToSectionsController(Rom rom) {
        sectionsController.setRom(rom, stage);
        content.setContent(vBox);
        stage.sizeToScene();
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public Label getStatusLabel() {
        return lblStatus;
    }
    
    public ProgressBar getProgressBar() {
        return progressBar;
    }
    
    public ChangesTracker getChangesTracker() {
        return changesTracker;
    }
    
    public RandomizeSummary getRandomizeSummary() {
        return randomizeSummary;
    }
    
    public Rom getRom() {
        return rom;
    }
    
    public void setRom(Rom rom) {
        this.rom = rom;
    }
}
