package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.RandomizationSummary;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;

public class EnemiesController {
    @FXML
    private ScrollPane enemies;
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
    private CheckBox chkRandomizeBossSkills;
    @FXML
    private HBox parBossMaxSkillCount;
    @FXML
    private Spinner<Integer> spBossMaxSkillCount;
    @FXML
    private CheckBox chkRandomizeEnemiesSkills;
    @FXML
    private HBox parEnemiesSkillCount;
    @FXML
    private Spinner<Integer> spEnemiesMaxSkillCount;
    @FXML
    private CheckBox chkNerfBallistae;
    
    @FXML
    private void initialize() {
        // classes
        chkClassExcludeBosses.disableProperty().bind(chkClasses.selectedProperty().not());
        // inventory
        parExtraInventory.disableProperty().bind(chkExtraInventory.selectedProperty().not());
        // movement & leadership
        chkMovementExcludeZero.disableProperty().bind(chkMovementStars.selectedProperty().not());
        chkLeadershipExcludeZero.disableProperty().bind(chkLeadershipStars.selectedProperty().not());
        // skills
        parBossMaxSkillCount.disableProperty().bind(chkRandomizeBossSkills.selectedProperty().not());
        parEnemiesSkillCount.disableProperty().bind(chkRandomizeEnemiesSkills.selectedProperty().not());
        
        RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();
        // classes
        chkClasses.selectedProperty().bindBidirectional(summary.randomizeEnemyUnitClassesProperty());
        chkClassExcludeBosses.selectedProperty().bindBidirectional(summary.randomizeEnemyUnitClassesExcludeBossesProperty());
        // inventory
        chkExtraInventory.selectedProperty().bindBidirectional(summary.enemiesAddExtraInventoryProperty());
        spExtraInventory.getValueFactory().valueProperty().bindBidirectional(summary.enemiesMaxExtraInventoryCountProperty());
        // movement
        chkMovementStars.selectedProperty().bindBidirectional(summary.randomizeEnemyMovStarsProperty());
        chkMovementExcludeZero.selectedProperty().bindBidirectional(summary.enemyMovStarsExcludeZeroProperty());
        // leadership
        chkLeadershipStars.selectedProperty().bindBidirectional(summary.randomizeEnemyLeadershipStarsProperty());
        chkLeadershipExcludeZero.selectedProperty().bindBidirectional(summary.enemyLeadershipExcludeZeroProperty());
        // skills
        chkRandomizeBossSkills.selectedProperty().bindBidirectional(summary.randomizeBossSkillsProperty());
        spBossMaxSkillCount.getValueFactory().valueProperty().bindBidirectional(summary.maxBossSkillCountProperty());
        chkRandomizeEnemiesSkills.selectedProperty().bindBidirectional(summary.randomizeEnemySkillsProperty());
        spEnemiesMaxSkillCount.getValueFactory().valueProperty().bindBidirectional(summary.maxEnemySkillCountProperty());
        // ballistae
        chkNerfBallistae.selectedProperty().bindBidirectional(summary.enemyNerfBallistaeProperty());
    }
}
