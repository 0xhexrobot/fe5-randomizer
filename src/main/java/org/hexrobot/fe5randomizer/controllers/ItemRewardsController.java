package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.RandomizationSummary;

import javafx.beans.binding.BooleanBinding;
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
    private CheckBox chkSafeScrolls;
    @FXML
    private CheckBox chkSafeKnightProofs;
    @FXML
    private ToggleGroup tgRewardsRandomization;
    private RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();
    
    @FXML
    private void initialize() {
        rbRewardsRandom.disableProperty().bind(chkRandomizeRewards.selectedProperty().not());
        rbRewardsShuffle.disableProperty().bind(chkRandomizeRewards.selectedProperty().not());
        rbRewardsReplace.disableProperty().bind(chkRandomizeRewards.selectedProperty().not());
        
        BooleanBinding safeUniqueItems = new BooleanBinding() {
            {
                super.bind(chkRandomizeRewards.selectedProperty(), rbRewardsRandom.selectedProperty(),
                        rbRewardsReplace.selectedProperty());
            }
            
            @Override
            protected boolean computeValue() {
                return chkRandomizeRewards.selectedProperty().getValue() && (rbRewardsRandom.selectedProperty().getValue()
                        || rbRewardsReplace.selectedProperty().getValue());
            }
        };
        
        chkSafeScrolls.disableProperty().bind(safeUniqueItems.not());
        chkSafeKnightProofs.disableProperty().bind(safeUniqueItems.not());
        
        chkRandomizeRewards.selectedProperty().bindBidirectional(summary.randomizeRewardsProperty());
        summary.rewardsRandomizationTypeProperty().bind(tgRewardsRandomization.selectedToggleProperty());
        summary.rewardsSafeScrollsProperty().bind(chkSafeScrolls.selectedProperty());
        summary.rewardsSafeKnightProofsProperty().bind(chkSafeKnightProofs.selectedProperty());
    }
}
