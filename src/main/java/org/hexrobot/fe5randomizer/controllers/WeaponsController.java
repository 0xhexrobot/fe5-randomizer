package org.hexrobot.fe5randomizer.controllers;

import org.hexrobot.fe5randomizer.RandomizationSummary;

import javafx.beans.binding.IntegerBinding;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;

public class WeaponsController {
    @FXML
    private ScrollPane weapons;
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
    private CheckBox chkExcludeIronWeapons;
    private RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();
        
    @FXML
    private void initialize() {
        parMightDelta.disableProperty().bind(chkMight.selectedProperty().not());
        parAccuracyDelta.disableProperty().bind(chkAccuracy.selectedProperty().not());
        parWeightDelta.disableProperty().bind(chkWeight.selectedProperty().not());
        parCriticalDelta.disableProperty().bind(chkCritical.selectedProperty().not());
        parBladeEffects.disableProperty().bind(chkAddBladeEffect.selectedProperty().not());
        parStatBonus.disableProperty().bind(chkAddStatBonus.selectedProperty().not());
        parAddWeaponSkill.disableProperty().bind(chkAddSkill.selectedProperty().not());
                
        chkMight.selectedProperty().bindBidirectional(summary.randomizeWpnsMightProperty());
        chkAccuracy.selectedProperty().bindBidirectional(summary.randomizeWpnsAccuracyProperty());
        chkWeight.selectedProperty().bindBidirectional(summary.randomizeWpnsWeightProperty());
        chkCritical.selectedProperty().bindBidirectional(summary.randomizeWpnsCriticalProperty());
        
        spMightDelta.getValueFactory().valueProperty().bindBidirectional(summary.wpnsMightDeltaProperty());
        spAccuracyDelta.getValueFactory().valueProperty().bindBidirectional(summary.wpnsAccuracyDeltaProperty());
        spWeightDelta.getValueFactory().valueProperty().bindBidirectional(summary.wpnsWeightDeltaProperty());
        spCriticalDelta.getValueFactory().valueProperty().bindBidirectional(summary.wpnsCriticalDeltaProperty());
        
        chkUses.selectedProperty().bindBidirectional(summary.randomizeWpnsMaxUsesProperty());
        chkCost.selectedProperty().bindBidirectional(summary.randomizeWpnsCostProperty());
        chkAddBladeEffect.selectedProperty().bindBidirectional(summary.wpnsAddBladeEffectProperty());
        chkAddStatBonus.selectedProperty().bindBidirectional(summary.wpnsAddStatBonusProperty());
        chkAddSkill.selectedProperty().bindBidirectional(summary.wpnsAddWeaponSkillProperty());
        spBladeEffectChance.getValueFactory().valueProperty().bindBidirectional(summary.wpnsBladeEffectChanceProperty());
        spStatBonusChance.getValueFactory().valueProperty().bindBidirectional(summary.wpnsStatBonusChanceProperty());
        spAddSkillChance.getValueFactory().valueProperty().bindBidirectional(summary.wpnsWeaponSkillChanceProperty());
        chkAllowMoreThan1Skill.selectedProperty().bindBidirectional(summary.wpnsAllowMultipleWeaponSkillsProperty());
        
        IntegerBinding bladeEffectBinding = new IntegerBinding() {
            {
                super.bind(chkPoison.selectedProperty(), chkDevil.selectedProperty(), chkBerserk.selectedProperty(), chkSleep.selectedProperty(), chkStealHp.selectedProperty(), chkStone.selectedProperty(), chkHell.selectedProperty());
            }
            
            @Override
            protected int computeValue() {
                return (chkPoison.selectedProperty().get() ? 1 : 0)
                        + (chkDevil.selectedProperty().get() ? 2 : 0)
                        + (chkStealHp.selectedProperty().get() ? 4 : 0)
                        + (chkStone.selectedProperty().get() ? 8 : 0)
                        + (chkHell.selectedProperty().get() ? 16 : 0)
                        + (chkBerserk.selectedProperty().get() ? 32 : 0)
                        + (chkSleep.selectedProperty().get() ? 64 : 0);
            }
        };
        
        summary.wpnsAvailableBladeEffectsProperty().bind(bladeEffectBinding);
        
        chkExcludeIronWeapons.selectedProperty().bindBidirectional(summary.wpnsExcludeIronWeaponsProperty());
        chkUses.disableProperty().bind(summary.balanceWpnsIncreaseUsesProperty());
        chkExcludeIronWeapons.disableProperty().bind(summary.anyItemRandomization.not());
    }
}
