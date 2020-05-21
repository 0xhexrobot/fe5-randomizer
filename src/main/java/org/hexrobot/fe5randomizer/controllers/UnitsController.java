package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.RandomizeSummary;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UnitsController {
    @FXML
    private CheckBox chkBases;
    @FXML
    private CheckBox chkGrowths;
    @FXML
    private RadioButton rbBasesVariance;
    @FXML
    private RadioButton rbBasesRedistribute;
    @FXML
    private RadioButton rbGrowthsVariance;
    @FXML
    private RadioButton rbGrowthsRedistribute;
    @FXML
    private RadioButton rbGrowthsAbsolute;
    @FXML
    private VBox parBasesControls;
    @FXML
    private VBox parGrowthsControls;
    @FXML
    private HBox parBasesVarianceOptions;
    @FXML
    private HBox parBasesRedistributeOptions;
    @FXML
    private HBox parGrowthsVarianceOptions;
    @FXML
    private HBox parGrowthsRedistributeOptions;
    @FXML
    private HBox parGrowthsAbsoluteOptions;
    @FXML
    private Spinner<Integer> spBasesDelta;
    @FXML
    private Spinner<Integer> spBasesVar;
    @FXML
    private Spinner<Integer> spGrowthsDelta;
    @FXML
    private Spinner<Integer> spGrowthsVar;
    @FXML
    private Spinner<Integer> spGrowthsAbsMin;
    @FXML
    private Spinner<Integer> spGrowthsAbsMax;
    @FXML
    private ToggleGroup tgBases;
    @FXML
    private ToggleGroup tgGrowths;
    @FXML
    private CheckBox chkClasses;
    @FXML
    private VBox parClassesControls;
    @FXML
    private CheckBox chkExcludeHealers;
    @FXML
    private CheckBox chkExcludeThieves;
        
    @FXML
    private void initialize() {
        // bases controls
        parBasesVarianceOptions.managedProperty().bind(parBasesVarianceOptions.visibleProperty());
        parBasesRedistributeOptions.managedProperty().bind(parBasesRedistributeOptions.visibleProperty());
        parBasesVarianceOptions.visibleProperty().bind(rbBasesVariance.selectedProperty());
        parBasesRedistributeOptions.visibleProperty().bind(rbBasesRedistribute.selectedProperty());
        parBasesControls.disableProperty().bind(chkBases.selectedProperty().not());
        
        // growths controls
        parGrowthsVarianceOptions.managedProperty().bind(parGrowthsVarianceOptions.visibleProperty());
        parGrowthsRedistributeOptions.managedProperty().bind(parGrowthsRedistributeOptions.visibleProperty());
        parGrowthsAbsoluteOptions.managedProperty().bind(parGrowthsAbsoluteOptions.visibleProperty());
        parGrowthsVarianceOptions.visibleProperty().bind(rbGrowthsVariance.selectedProperty());
        parGrowthsRedistributeOptions.visibleProperty().bind(rbGrowthsRedistribute.selectedProperty());
        parGrowthsAbsoluteOptions.visibleProperty().bind(rbGrowthsAbsolute.selectedProperty());
        parGrowthsControls.disableProperty().bind(chkGrowths.selectedProperty().not());
        
        // radiobuttons user data
        rbBasesVariance.setUserData("variance");
        rbBasesRedistribute.setUserData("redistribute");
        rbGrowthsVariance.setUserData("variance");
        rbGrowthsRedistribute.setUserData("redistribute");
        rbGrowthsAbsolute.setUserData("absolute");
        
        RandomizeSummary randomizeSummary = MainController.getInstance().getRandomizeSummary();
        
        // bases
        chkBases.selectedProperty().bindBidirectional(randomizeSummary.randomizeBasesProperty());
        randomizeSummary.basesRandomizationTypeProperty().bind(tgBases.selectedToggleProperty());
        spBasesDelta.getValueFactory().valueProperty().bindBidirectional(randomizeSummary.basesVarianceProperty());
        spBasesVar.getValueFactory().valueProperty().bindBidirectional(randomizeSummary.basesRedistributeVarProperty());
        
        // growths
        chkGrowths.selectedProperty().bindBidirectional(randomizeSummary.randomizeGrowthsProperty());
        randomizeSummary.growthsRandomizationTypeProperty().bind(tgGrowths.selectedToggleProperty());
        spGrowthsDelta.getValueFactory().valueProperty().bindBidirectional(randomizeSummary.growthsVarianceProperty());
        spGrowthsVar.getValueFactory().valueProperty().bindBidirectional(randomizeSummary.growthsRedistributeVarProperty());
        spGrowthsAbsMin.getValueFactory().valueProperty().bindBidirectional(randomizeSummary.growthsAbsoluteMinProperty());
        spGrowthsAbsMax.getValueFactory().valueProperty().bindBidirectional(randomizeSummary.growthsAbsoluteMaxProperty());
        
        // classes
        chkExcludeHealers.disableProperty().bind(chkClasses.selectedProperty().not());
        chkExcludeThieves.disableProperty().bind(chkClasses.selectedProperty().not());
        chkClasses.selectedProperty().bindBidirectional(randomizeSummary.randomizeUnitClassesProperty());
        chkExcludeHealers.selectedProperty().bindBidirectional(randomizeSummary.excludeHealersProperty());
        chkExcludeThieves.selectedProperty().bindBidirectional(randomizeSummary.excludeThievesProperty());
    }
}
