package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.RandomizationSummary;

import javafx.beans.binding.IntegerBinding;
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
    private CheckBox chkCost;
    @FXML
    private CheckBox chkAddBladeEffect;
    @FXML
    private CheckBox chkRandomizeScrolls;
    @FXML
    private CheckBox chkAddSkill;
    @FXML
    private HBox parAddWeaponSkill;
    @FXML
    private Spinner<Integer> spAddSkillChance;
    @FXML
    private CheckBox chkAllowMoreThan1Skill;
    @FXML
    private HBox parBladeEffects;
    @FXML
    private Spinner<Integer> spBladeEffectChance;
    @FXML
    private CheckBox chkPoison;
    @FXML
    private CheckBox chkDevil;
    @FXML
    private CheckBox chkStealHp;
    @FXML
    private CheckBox chkStone;
    @FXML
    private CheckBox chkHell;
    @FXML
    private CheckBox chkBerserk;
    @FXML
    private CheckBox chkSleep;
    @FXML
    private CheckBox chkAddStatBonus;
    @FXML
    private HBox parStatBonus;
    @FXML
    private Spinner<Integer> spStatBonusChance;
    
    @FXML
    private void initialize() {
        parMightDelta.disableProperty().bind(chkMight.selectedProperty().not());
        parAccuracyDelta.disableProperty().bind(chkAccuracy.selectedProperty().not());
        parWeightDelta.disableProperty().bind(chkWeight.selectedProperty().not());
        parCriticalDelta.disableProperty().bind(chkCritical.selectedProperty().not());
        parBladeEffects.disableProperty().bind(chkAddBladeEffect.selectedProperty().not());
        parStatBonus.disableProperty().bind(chkAddStatBonus.selectedProperty().not());
        parAddWeaponSkill.disableProperty().bind(chkAddSkill.selectedProperty().not());
        
        RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();
        
        chkMight.selectedProperty().bindBidirectional(summary.randomizeItemsMightProperty());
        chkAccuracy.selectedProperty().bindBidirectional(summary.randomizeItemsAccuracyProperty());
        chkWeight.selectedProperty().bindBidirectional(summary.randomizeItemsWeightProperty());
        chkCritical.selectedProperty().bindBidirectional(summary.randomizeItemsCriticalProperty());
        
        spMightDelta.getValueFactory().valueProperty().bindBidirectional(summary.itemsMightDeltaProperty());
        spAccuracyDelta.getValueFactory().valueProperty().bindBidirectional(summary.itemsAccuracyDeltaProperty());
        spWeightDelta.getValueFactory().valueProperty().bindBidirectional(summary.itemsWeightDeltaProperty());
        spCriticalDelta.getValueFactory().valueProperty().bindBidirectional(summary.itemsCriticalDeltaProperty());
        
        chkUses.selectedProperty().bindBidirectional(summary.randomizeItemsMaxUsesProperty());
        chkCost.selectedProperty().bindBidirectional(summary.randomizeItemsCostProperty());
        chkAddBladeEffect.selectedProperty().bindBidirectional(summary.itemsAddBladeEffectProperty());
        chkAddStatBonus.selectedProperty().bindBidirectional(summary.itemsAddStatBonusProperty());
        chkAddSkill.selectedProperty().bindBidirectional(summary.itemsAddWeaponSkillProperty());
        spBladeEffectChance.getValueFactory().valueProperty().bindBidirectional(summary.itemsBladeEffectChanceProperty());
        spStatBonusChance.getValueFactory().valueProperty().bindBidirectional(summary.itemsStatBonusChanceProperty());
        spAddSkillChance.getValueFactory().valueProperty().bindBidirectional(summary.itemsWeaponSkillChanceProperty());
        chkAllowMoreThan1Skill.selectedProperty().bindBidirectional(summary.itemsAllowMultipleWeaponSkillsProperty());
        
        IntegerBinding bladeEffectBinding = new IntegerBinding() {
            {
                super.bind(chkPoison.selectedProperty(), chkDevil.selectedProperty(), chkBerserk.selectedProperty(), chkSleep.selectedProperty(), chkStealHp.selectedProperty(), chkStone.selectedProperty(), chkHell.selectedProperty());
            }
            
            @Override
            protected int computeValue() {
                int value = (chkPoison.selectedProperty().get() ? 1 : 0)
                        + (chkDevil.selectedProperty().get() ? 2 : 0)
                        + (chkStealHp.selectedProperty().get() ? 4 : 0)
                        + (chkStone.selectedProperty().get() ? 8 : 0)
                        + (chkHell.selectedProperty().get() ? 16 : 0)
                        + (chkBerserk.selectedProperty().get() ? 32 : 0)
                        + (chkSleep.selectedProperty().get() ? 64 : 0);
                
                return value;
            }
        };
        
        summary.itemsAvailableBladeEffectsProperty().bind(bladeEffectBinding);
    }
}
