package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.RandomizationSummary;
import org.hexrobot.fe5randomizer.Rom;
import org.hexrobot.fe5randomizer.service.RandomizeRomService;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class RandomizeController {
    @FXML
    private VBox randomize;
    @FXML
    private CheckBox chkWriteDebugLog;
    @FXML
    private CheckBox chkWriteRom;
    
    @FXML
    private void initialize() {
        RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();
        chkWriteDebugLog.selectedProperty().bindBidirectional(summary.writeDebugLogProperty());
        chkWriteRom.selectedProperty().bindBidirectional(summary.writeToFileProperty());
    }

    @FXML
    private void randomize() {
        MainController mainController = MainController.getInstance();
        Rom rom = mainController.getRom();
        rom.setRandomSeed(mainController.getSeed());
        RandomizationSummary randomizeSummary = mainController.getRandomizeSummary();
        System.out.println(mainController.getRandomizeSummary().toString());
        RandomizeRomService randomizeRomService = new RandomizeRomService(rom, randomizeSummary);
        Label statusLabel = mainController.getStatusLabel();
        ProgressBar progressBar = mainController.getProgressBar();
        ScrollPane content = mainController.getContent();
        
        statusLabel.textProperty().bind(randomizeRomService.messageProperty());
        progressBar.progressProperty().bind(randomizeRomService.progressProperty());
        content.disableProperty().bind(randomizeRomService.runningProperty());
        statusLabel.setVisible(true);
        progressBar.setVisible(true);

        randomizeRomService.start();

        randomizeRomService.setOnSucceeded((e) -> {
            mainController.getStatusLabel().textProperty().unbind();
            mainController.getProgressBar().progressProperty().unbind();
            content.disableProperty().unbind();
            statusLabel.setVisible(false);
            progressBar.setVisible(false);
            content.setDisable(false);
        });
        
        randomizeRomService.setOnFailed((e) -> {            
            Throwable throwable = randomizeRomService.getException(); 
            throwable.printStackTrace();
        });
    }
}
