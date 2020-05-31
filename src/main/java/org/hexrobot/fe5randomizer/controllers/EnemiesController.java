package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.RandomizationSummary;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EnemiesController {
    @FXML
    private VBox enemies;
    @FXML
    private CheckBox chkClasses;
    @FXML
    private CheckBox chkClassExcludeBosses;
    @FXML
    private CheckBox chkExtraInventory;
    @FXML
    private HBox parExtraInventory;
    @FXML
    private Spinner<Integer> spExtraInventory;
    @FXML
    private CheckBox chkMovementStars;
    @FXML
    private CheckBox chkMovementExcludeZero;
    @FXML
    private CheckBox chkLeadershipStars;
    @FXML
    private CheckBox chkLeadershipExcludeZero;
    
    @FXML
    private void initialize() {
        chkClassExcludeBosses.disableProperty().bind(chkClasses.selectedProperty().not());
        parExtraInventory.disableProperty().bind(chkExtraInventory.selectedProperty().not());
        chkLeadershipExcludeZero.disableProperty().bind(chkLeadershipStars.selectedProperty().not());
        
        RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();
        chkClasses.selectedProperty().bindBidirectional(summary.randomizeEnemyUnitClassesProperty());
        chkClassExcludeBosses.selectedProperty().bindBidirectional(summary.randomizeEnemyUnitClassesExcludeBossesProperty());
    }
}
