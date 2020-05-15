package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.RandomizeRomService;
import org.hexrobot.fe5randomizer.RandomizeSummary;
import org.hexrobot.fe5randomizer.Rom;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class RandomizeController {
    @FXML
    private VBox randomize;

    @FXML
    private void randomize() {
        MainController mainController = MainController.getInstance();
        Rom rom = mainController.getRom();
        RandomizeSummary randomizeSummary = mainController.getRandomizeSummary();
        System.out.println(mainController.getRandomizeSummary().toString());
        RandomizeRomService randomizeRomService = new RandomizeRomService(rom, randomizeSummary);
        Label statusLabel = mainController.getStatusLabel();
        ProgressBar progressBar = mainController.getProgressBar();
        
        statusLabel.textProperty().bind(randomizeRomService.messageProperty());
        progressBar.progressProperty().bind(randomizeRomService.progressProperty());
        statusLabel.setVisible(true);
        progressBar.setVisible(true);

        randomizeRomService.start();

        randomizeRomService.setOnSucceeded((e) -> {
            mainController.getStatusLabel().textProperty().unbind();
            mainController.getProgressBar().progressProperty().unbind();
            statusLabel.setVisible(false);
            progressBar.setVisible(false);
        });
    }
}
