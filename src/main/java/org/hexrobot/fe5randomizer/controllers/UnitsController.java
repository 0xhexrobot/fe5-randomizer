package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.RandomizationSummary;

import javafx.beans.binding.IntegerBinding;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UnitsController {
    @FXML
    private ScrollPane units;
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
    private CheckBox chkRandomizeMovStars;
    @FXML
    private CheckBox chkMovExcludeZero;
    @FXML
    private CheckBox chkRandomizeLeadershipStars;
    @FXML
    private CheckBox chkLeadershipExcludeZero;
    @FXML
    private CheckBox chkClasses;
    @FXML
    private VBox parClassesControls;
    @FXML
    private CheckBox chkExcludeHealers;
    @FXML
    private CheckBox chkExcludeThieves;
    @FXML
    private CheckBox chkRandomizeSkills;
    @FXML
    private HBox parSkillCount;
    @FXML
    private Spinner<Integer> spMaxSkillCount;
        
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
        
        // Movement & Leadership stars
        chkMovExcludeZero.disableProperty().bind(chkRandomizeMovStars.selectedProperty().not());
        chkLeadershipExcludeZero.disableProperty().bind(chkRandomizeLeadershipStars.selectedProperty().not());
        
        // skills
        parSkillCount.disableProperty().bind(chkRandomizeSkills.selectedProperty().not());
        
        RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();
        
        // bases
        chkBases.selectedProperty().bindBidirectional(summary.randomizeBasesProperty());
        summary.basesRandomizationTypeProperty().bind(tgBases.selectedToggleProperty());
        spBasesDelta.getValueFactory().valueProperty().bindBidirectional(summary.basesVarianceProperty());
        spBasesVar.getValueFactory().valueProperty().bindBidirectional(summary.basesRedistributeVarProperty());
        
        // growths
        chkGrowths.selectedProperty().bindBidirectional(summary.randomizeGrowthsProperty());
        summary.growthsRandomizationTypeProperty().bind(tgGrowths.selectedToggleProperty());
        spGrowthsDelta.getValueFactory().valueProperty().bindBidirectional(summary.growthsVarianceProperty());
        spGrowthsVar.getValueFactory().valueProperty().bindBidirectional(summary.growthsRedistributeVarProperty());
        spGrowthsAbsMin.getValueFactory().valueProperty().bindBidirectional(summary.growthsAbsoluteMinProperty());
        spGrowthsAbsMax.getValueFactory().valueProperty().bindBidirectional(summary.growthsAbsoluteMaxProperty());
        SpinnerValueFactory.IntegerSpinnerValueFactory fMin = (IntegerSpinnerValueFactory)spGrowthsAbsMin.getValueFactory();
        SpinnerValueFactory.IntegerSpinnerValueFactory fMax = (IntegerSpinnerValueFactory)spGrowthsAbsMax.getValueFactory();
        
        IntegerBinding minUpperValue = new IntegerBinding() {
            {
                super.bind(fMax.valueProperty());
            }
            
            @Override
            protected int computeValue() {
                return Math.min(fMax.valueProperty().getValue(), 200);
            }
        };
        
        IntegerBinding maxLowerValue = new IntegerBinding() {
            {
                super.bind(fMin.valueProperty());
            }
            
            @Override
            protected int computeValue() {
                return Math.max(fMin.valueProperty().getValue(), 0);
            }
        };
        
        fMin.maxProperty().bind(minUpperValue);
        fMax.minProperty().bind(maxLowerValue);
        
        // Movement & Leadership stars
        chkRandomizeMovStars.selectedProperty().bindBidirectional(summary.randomizeMovStarsProperty());
        chkMovExcludeZero.selectedProperty().bindBidirectional(summary.movStarsExcludeZeroProperty());
        chkRandomizeLeadershipStars.selectedProperty().bindBidirectional(summary.randomizeLeadershipStarsProperty());
        chkLeadershipExcludeZero.selectedProperty().bindBidirectional(summary.leadershipExcludeZeroProperty());
        
        // classes
        chkExcludeHealers.disableProperty().bind(chkClasses.selectedProperty().not());
        chkExcludeThieves.disableProperty().bind(chkClasses.selectedProperty().not());
        chkClasses.selectedProperty().bindBidirectional(summary.randomizePlayableUnitClassesProperty());
        chkExcludeHealers.selectedProperty().bindBidirectional(summary.excludeHealersProperty());
        chkExcludeThieves.selectedProperty().bindBidirectional(summary.excludeThievesProperty());
        
        // skills
        chkRandomizeSkills.selectedProperty().bindBidirectional(summary.RandomizeSkillsProperty());
        spMaxSkillCount.getValueFactory().valueProperty().bindBidirectional(summary.maxSkillCountProperty());
    }
}
