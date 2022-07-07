package org.hexrobot.fe5randomizer.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import org.hexrobot.fe5randomizer.RandomizationSummary;

public class BalanceController {
    @FXML
    private ScrollPane balance;
    @FXML
    private CheckBox chkChangeBraveAxeToBRank;
    @FXML
    private CheckBox chkNerfBallistaeAcc;
    @FXML
    private CheckBox chkBuffAllyUnits;
    @FXML
    private HBox parExtraInventory;
    @FXML
    private CheckBox chkExtraInventory;
    @FXML
    private Spinner<Integer> spExtraInventory;
    @FXML
    private CheckBox chkAddWeaponUses;
    @FXML
    private CheckBox chkDowngradeWindTome;
    @FXML
    private CheckBox chkRemovePrfLocks;

    @FXML
    private void initialize() {
        RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();

        parExtraInventory.disableProperty().bind(chkExtraInventory.selectedProperty().not());

        chkNerfBallistaeAcc.selectedProperty().bindBidirectional(summary.balanceNerfBallistaeProperty());
        chkAddWeaponUses.selectedProperty().bindBidirectional(summary.balanceWpnsIncreaseUsesProperty());
        chkDowngradeWindTome.selectedProperty().bindBidirectional(summary.balanceDowngradeWindTomeProperty());
        chkChangeBraveAxeToBRank.selectedProperty().bindBidirectional(summary.balanceChangeBraveAxeToBRankProperty());
        chkBuffAllyUnits.selectedProperty().bindBidirectional(summary.balanceBuffAllyUnitsProperty());
        chkExtraInventory.selectedProperty().bindBidirectional(summary.balanceAllyAddExtraInventoryProperty());
        spExtraInventory.getValueFactory().valueProperty().bindBidirectional(summary.balanceAllyMaxExtraInventoryCountProperty());
        chkRemovePrfLocks.selectedProperty().bindBidirectional(summary.balanceRemovePrfLocksProperty());

        // disable add weapon uses if randomize uses is active
        chkAddWeaponUses.disableProperty().bind(summary.randomizeWpnsMaxUsesProperty());
    }
}
