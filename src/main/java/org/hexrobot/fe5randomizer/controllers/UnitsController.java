package org.hexrobot.fe5randomizer.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
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
    private RadioButton rbBasesAbsolute;
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
    private HBox parBasesAbsoluteOptions;
    @FXML
    private HBox parGrowthsVarianceOptions;
    @FXML
    private HBox parGrowthsRedistributeOptions;
    @FXML
    private HBox parGrowthsAbsoluteOptions;
    
    @FXML
    private void initialize() {
        // bases controls
        parBasesVarianceOptions.managedProperty().bind(parBasesVarianceOptions.visibleProperty());
        parBasesRedistributeOptions.managedProperty().bind(parBasesRedistributeOptions.visibleProperty());
        parBasesAbsoluteOptions.managedProperty().bind(parBasesAbsoluteOptions.visibleProperty());
        parBasesVarianceOptions.visibleProperty().bind(rbBasesVariance.selectedProperty());
        parBasesRedistributeOptions.visibleProperty().bind(rbBasesRedistribute.selectedProperty());
        parBasesAbsoluteOptions.visibleProperty().bind(rbBasesAbsolute.selectedProperty());
        parBasesControls.disableProperty().bind(chkBases.selectedProperty().not());
        
        // growths controls
        parGrowthsVarianceOptions.managedProperty().bind(parGrowthsVarianceOptions.visibleProperty());
        parGrowthsRedistributeOptions.managedProperty().bind(parGrowthsRedistributeOptions.visibleProperty());
        parGrowthsAbsoluteOptions.managedProperty().bind(parGrowthsAbsoluteOptions.visibleProperty());
        parGrowthsVarianceOptions.visibleProperty().bind(rbGrowthsVariance.selectedProperty());
        parGrowthsRedistributeOptions.visibleProperty().bind(rbGrowthsRedistribute.selectedProperty());
        parGrowthsAbsoluteOptions.visibleProperty().bind(rbGrowthsAbsolute.selectedProperty());
        parGrowthsControls.disableProperty().bind(chkGrowths.selectedProperty().not());
    }
}
