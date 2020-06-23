package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.RandomizationSummary;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ItemsController {
    @FXML
    private VBox items;
    @FXML
    private CheckBox chkMight;
    @FXML
    private HBox parMightDelta;
    @FXML
    private Spinner<Integer> spMightDelta; 
    @FXML
    private CheckBox chkAccuracy;
    @FXML
    private HBox parAccuracyDelta;
    @FXML
    private Spinner<Integer> spAccuracyDelta;
    @FXML
    private CheckBox chkWeight;
    @FXML
    private HBox parWeightDelta;
    @FXML
    private Spinner<Integer> spWeightDelta;
    @FXML
    private CheckBox chkCritical;
    @FXML
    private HBox parCriticalDelta;
    @FXML
    private Spinner<Integer> spCriticalDelta;
    @FXML
    private CheckBox chkUses;
    @FXML
    private CheckBox chkAddBladeEffect;
    @FXML
    private CheckBox chkRandomizeScrolls;
    @FXML
    private CheckBox chkAddSkill;
    @FXML
    private Spinner<Integer> spScrollsMin;
    @FXML
    private Spinner<Integer> spScrollsMax;
    
    @FXML
    private void initialize() {
        parMightDelta.disableProperty().bind(chkMight.selectedProperty().not());
        parAccuracyDelta.disableProperty().bind(chkAccuracy.selectedProperty().not());
        parWeightDelta.disableProperty().bind(chkWeight.selectedProperty().not());
        parCriticalDelta.disableProperty().bind(chkCritical.selectedProperty().not());
        
        RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();
        
        chkMight.selectedProperty().bindBidirectional(summary.randomizeItemsMightProperty());
        chkAccuracy.selectedProperty().bindBidirectional(summary.randomizeItemsAccuracyProperty());
        chkWeight.selectedProperty().bindBidirectional(summary.randomizeItemsWeightProperty());
        chkCritical.selectedProperty().bindBidirectional(summary.randomizeItemsCriticalProperty());
        
        spMightDelta.getValueFactory().valueProperty().bindBidirectional(summary.itemsMightDeltaProperty());
        spAccuracyDelta.getValueFactory().valueProperty().bindBidirectional(summary.itemsAccuracyDeltaProperty());
        spWeightDelta.getValueFactory().valueProperty().bindBidirectional(summary.itemsWeightDeltaProperty());
        spCriticalDelta.getValueFactory().valueProperty().bindBidirectional(summary.itemsCriticalDeltaProperty());
    }
}
