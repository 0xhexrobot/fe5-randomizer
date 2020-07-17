package org.hexrobot.fe5randomizer.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.hexrobot.fe5randomizer.RandomizationSummary;
import org.hexrobot.fe5randomizer.Rom;
import org.hexrobot.fe5randomizer.service.RandomizeRomService;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public class RandomizeController {
    @FXML
    private VBox randomize;
    @FXML
    private CheckBox chkWriteDebugLog;
    
    @FXML
    private void initialize() {
        RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();
        chkWriteDebugLog.selectedProperty().bindBidirectional(summary.writeDebugLogProperty());
    }

    @FXML
    public void randomize() {
        FileChooser fileChooser = new FileChooser();
        File file = new File(MainController.CONFIG_FILENAME);
        Properties properties = new Properties();
        String lastDirectory;
        
        MainController mainController = MainController.getInstance();
        Rom rom = mainController.getRom();
        rom.setRandomSeed(mainController.getSeed());
        RandomizationSummary randomizeSummary = mainController.getRandomizeSummary();
        System.out.println(mainController.getRandomizeSummary().toString());
        Label statusLabel = mainController.getStatusLabel();
        ProgressBar progressBar = mainController.getProgressBar();
        ScrollPane content = mainController.getContent();
        
        if(file.exists()) {
            try {
                properties = MainController.readPropertiesFile(MainController.CONFIG_FILENAME);
                lastDirectory = properties.getProperty("lastDirectory", "");
                
                if(!lastDirectory.isEmpty()) {
                    fileChooser.setInitialDirectory(new File(lastDirectory));
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        
        fileChooser.setTitle("Choose rom file name...");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("SNES ROM files (*.sfc, *.smc, *.fig)", "*.sfc", "*.smc", "*.fig"));
        fileChooser.setInitialFileName("filename.sfc");
        File selectedFile = fileChooser.showSaveDialog(randomize.getScene().getWindow());
        
        if(selectedFile != null) {
            RandomizeRomService randomizeRomService = new RandomizeRomService(rom, randomizeSummary, selectedFile);
            properties.setProperty("lastDirectory", selectedFile.getParent());

            try {
                properties.store(new FileOutputStream(MainController.CONFIG_FILENAME), null);
            } catch(IOException e) {
                e.printStackTrace();
            }
            
            statusLabel.textProperty().bind(randomizeRomService.messageProperty());
            progressBar.progressProperty().bind(randomizeRomService.progressProperty());
            content.disableProperty().bind(randomizeRomService.runningProperty());
            statusLabel.setVisible(true);
            progressBar.setVisible(true);
            mainController.getMenuBar().setDisable(true);

            randomizeRomService.start();

            randomizeRomService.setOnSucceeded((e) -> {
                mainController.getStatusLabel().textProperty().unbind();
                mainController.getProgressBar().progressProperty().unbind();
                content.disableProperty().unbind();
                statusLabel.setVisible(false);
                progressBar.setVisible(false);
                content.setDisable(false);
                mainController.getMenuBar().setDisable(false);
            });

            randomizeRomService.setOnFailed((e) -> {
                Throwable throwable = randomizeRomService.getException();
                throwable.printStackTrace();
            });
        }
    }
}
