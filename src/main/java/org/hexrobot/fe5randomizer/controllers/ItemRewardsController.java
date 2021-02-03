package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.RandomizationSummary;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;

public class ItemRewardsController {
    @FXML
    private ScrollPane itemRewards;
    @FXML
    private CheckBox chkRandomizeRewards;
    @FXML
    private RadioButton rbRewardsRandom;
    @FXML
    private RadioButton rbRewardsShuffle;
    @FXML
    private RadioButton rbRewardsReplace;
    @FXML
    private CheckBox chkIncludeHeldScrolls;
    @FXML
    private ToggleGroup tgRewardsRandomization;
    @FXML
    private CheckBox chkShopItems;
    @FXML
    private CheckBox chkShopSimilar;
    private RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();
    
    @FXML
    private void initialize() {
        rbRewardsRandom.disableProperty().bind(chkRandomizeRewards.selectedProperty().not());
        rbRewardsShuffle.disableProperty().bind(chkRandomizeRewards.selectedProperty().not());
        rbRewardsReplace.disableProperty().bind(chkRandomizeRewards.selectedProperty().not());
        chkIncludeHeldScrolls.disableProperty().bind(rbRewardsShuffle.selectedProperty().not());
        
        chkRandomizeRewards.selectedProperty().bindBidirectional(summary.randomizeRewardsProperty());
        chkIncludeHeldScrolls.selectedProperty().bindBidirectional(summary.rewardsShuffleIncludeHeldScrollsProperty());
        summary.rewardsRandomizationTypeProperty().bind(tgRewardsRandomization.selectedToggleProperty());
    }
}
