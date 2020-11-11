package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.RandomizationSummary;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;

public class ItemRewardsController {
    @FXML
    private ScrollPane itemRewards;
    @FXML
    private CheckBox chkChestRewards;
    @FXML
    private CheckBox chkChestShuffle;
    @FXML
    private CheckBox chkChestSimilar;
    @FXML
    private CheckBox chkHouseRewards;
    @FXML
    private CheckBox chkHouseShuffle;
    @FXML
    private CheckBox chkHouseSimilar;
    @FXML
    private CheckBox chkShopItems;
    @FXML
    private CheckBox chkShopSimilar;
    private RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();
    
    @FXML
    private void initialize() {
        //chkHouseSimilar.disableProperty().bind(chkHouseRewards.selectedProperty().not());
        //chkChestSimilar.disableProperty().bind(chkChestRewards.selectedProperty().not());
        
        chkHouseRewards.selectedProperty().bindBidirectional(summary.randomizeHouseRewardsProperty());
        chkHouseSimilar.selectedProperty().bindBidirectional(summary.itemsHousesSimilarProperty());
        
        chkChestRewards.selectedProperty().bindBidirectional(summary.randomizeChestRewardsProperty());
        chkChestSimilar.selectedProperty().bindBidirectional(summary.itemsChestSimilarProperty());
    }
}
