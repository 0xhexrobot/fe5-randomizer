package org.hexrobot.fe5randomizer.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;

import org.hexrobot.fe5randomizer.MainView;
import org.hexrobot.fe5randomizer.RandomizationSummary;
import org.hexrobot.fe5randomizer.Rom;
import org.hexrobot.fe5randomizer.WeaponSeed;
import org.hexrobot.fe5randomizer.items.WeaponBladeEffect;
import org.hexrobot.fe5randomizer.services.RandomizeRomService;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.binding.StringBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class RandomizeController {
    @FXML
    private ScrollPane randomize;
    @FXML
    private Label lblRandomizerVersion;
    @FXML
    private ImageView imgSeed1;
    @FXML
    private ImageView imgSeed2;
    @FXML
    private ImageView imgSeed3;
    @FXML
    private ImageView imgSeed4;
    @FXML
    private ImageView imgSeed5;
    @FXML
    private ImageView imgSeed6;
    @FXML
    private Label lblRomName;
    @FXML
    private Label lblPlayerUnits;
    @FXML
    private Label lblUnitBases;
    @FXML
    private Label lblUnitGrowths;
    @FXML
    private Label lblUnitClasses;
    @FXML
    private Label lblAllyUnitClasses;
    @FXML
    private Label lblUnitMovStars;
    @FXML
    private Label lblUnitLeadStars;
    @FXML
    private Label lblUnitSkills;
    @FXML
    private Label lblEnemies;
    @FXML
    private Label lblEnemyClasses;
    @FXML
    private Label lblEnemyExtraInventory;
    @FXML
    private Label lblEnemyMovStars;
    @FXML
    private Label lblEnemyLeadStars;
    @FXML
    private Label lblEnemyBossSkills;
    @FXML
    private Label lblEnemySkills;
    @FXML
    private Label lblWeapons;
    @FXML
    private Label lblItemsMight;
    @FXML
    private Label lblItemsAccuracy;
    @FXML
    private Label lblItemsWeight;
    @FXML
    private Label lblItemsCritical;
    @FXML
    private Label lblItemsMaxUses;
    @FXML
    private Label lblItemsCost;
    @FXML
    private Label lblItemsBladeEffect;
    @FXML
    private Label lblItemsStatBonus;
    @FXML
    private Label lblItemsWeaponSkill;
    @FXML
    private Label lblItemsExcludeIronWeapons;
    @FXML
    private Label lblItems;
    @FXML
    private Label lblRandomizeRewards;
    @FXML
    private Label lblRandomizeShops;
    @FXML
    private Label lblRandomizeScrolls;
    @FXML
    private Label lblBalance;
    @FXML
    private Label lblBalanceNerfBallistaeAcc;
    @FXML
    private Label lblBalanceAddWeaponUses;
    @FXML
    private Label lblBalanceDowngradeWindTome;
    @FXML
    private Label lblBalanceRemovePrfLocks;
    @FXML
    private Label lblBalanceChangeBraveAxeToBRank;
    @FXML
    private Label lblBalanceBuffAllyUnits;
    @FXML
    private Label lblBalanceAllyAddInventory;
    @FXML
    private Label lblShufflePalettes;
    @FXML
    private Label lblPalettes;
    @FXML
    private Label lblLilManster;
    @FXML
    private Label lblLilMansterRenamePugi;
    @FXML
    private CheckBox chkWriteDebugLog;
    @FXML
    private CheckBox chkWriteLog;
    private RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();
    
    private ObjectBinding<Image> icon1 = new ObjectBinding<Image>() {
        {
            super.bind(summary.seedProperty());
        }

        @Override
        protected Image computeValue() {
            WeaponSeed wpnSeed = WeaponSeed.getBySeed(summary.seedProperty().getValue() >> 25);
            return getWpnSeedImage(wpnSeed);
        }
    };

    private ObjectBinding<Image> icon2 = new ObjectBinding<Image>() {
        {
            super.bind(summary.seedProperty());
        }

        @Override
        protected Image computeValue() {
            WeaponSeed wpnSeed = WeaponSeed.getBySeed((summary.seedProperty().getValue() >> 20) & 0x1F);
            return getWpnSeedImage(wpnSeed);
        }
    };
    
    private ObjectBinding<Image> icon3 = new ObjectBinding<Image>() {
        {
            super.bind(summary.seedProperty());
        }

        @Override
        protected Image computeValue() {
            WeaponSeed wpnSeed = WeaponSeed.getBySeed((summary.seedProperty().getValue() >> 15) & 0x1F);
            return getWpnSeedImage(wpnSeed);
        }
    };
    
    private ObjectBinding<Image> icon4 = new ObjectBinding<Image>() {
        {
            super.bind(summary.seedProperty());
        }

        @Override
        protected Image computeValue() {
            WeaponSeed wpnSeed = WeaponSeed.getBySeed((summary.seedProperty().getValue() >> 10) & 0x1F);
            return getWpnSeedImage(wpnSeed);
        }
    };
    
    private ObjectBinding<Image> icon5 = new ObjectBinding<Image>() {
        {
            super.bind(summary.seedProperty());
        }

        @Override
        protected Image computeValue() {
            WeaponSeed wpnSeed = WeaponSeed.getBySeed((summary.seedProperty().getValue() >> 5) & 0x1F);
            return getWpnSeedImage(wpnSeed);
        }
    };
    
    private ObjectBinding<Image> icon6 = new ObjectBinding<Image>() {
        {
            super.bind(summary.seedProperty());
        }

        @Override
        protected Image computeValue() {
            WeaponSeed wpnSeed = WeaponSeed.getBySeed(summary.seedProperty().getValue() & 0x1F);
            return getWpnSeedImage(wpnSeed);
        }
    };

    private Image getWpnSeedImage(WeaponSeed wpnSeed) {
        String iconPath = "img/" + wpnSeed.getImageName();

        return new Image(Objects.requireNonNull(
                MainView.class.getResourceAsStream(iconPath),
                wpnSeed.getImageName() + " icon not found."));
    }

    private BooleanBinding unitLabelVisible = new BooleanBinding() {
        {
            super.bind(summary.randomizeBasesProperty(), summary.randomizeGrowthsProperty(),
                    summary.randomizePlayableUnitClassesProperty(), summary.randomizeMovStarsProperty(),
                    summary.randomizeLeadershipStarsProperty(), summary.RandomizeSkillsProperty(),
                    summary.randomizeAllyUnitClassesProperty());
        }
        
        @Override
        protected boolean computeValue() {
            return summary.randomizeBasesProperty().getValue() || summary.randomizeGrowthsProperty().getValue()
                    || summary.randomizePlayableUnitClassesProperty().getValue() || summary.randomizeMovStarsProperty().getValue()
                    || summary.randomizeLeadershipStarsProperty().getValue() || summary.RandomizeSkillsProperty().getValue()
                    || summary.randomizeAllyUnitClassesProperty().getValue();
        }
    };
    
    private StringBinding txtUnitBases = new StringBinding() {
        {
            super.bind(summary.basesRandomizationTypeProperty(), summary.basesVarianceProperty(),
                    summary.basesRedistributeVarProperty());
        }
        
        @Override
        protected String computeValue() {
            String text = "unitBases";
            
            switch((String)summary.basesRandomizationTypeProperty().getValue().getUserData()) {
            case "variance":
                text = String.format("Randomize unit bases by Variance ±%d",
                        summary.basesVarianceProperty().getValue());
                break;
            case "redistribute":
                text = String.format("Randomize unit bases by Redistribution ±%d",
                        summary.basesRedistributeVarProperty().getValue());
                break;
            }
            
            return text;
        }
    };
    
    private StringBinding txtUnitGrowths = new StringBinding() {
        {
            super.bind(summary.growthsRandomizationTypeProperty(), summary.growthsVarianceProperty(),
                    summary.growthsRedistributeVarProperty(), summary.growthsAbsoluteMinProperty(),
                    summary.growthsAbsoluteMaxProperty());
        }
        
        @Override
        protected String computeValue() {
            String text = "unitGrowths";
            String randomizationType = (String)summary.growthsRandomizationTypeProperty().getValue().getUserData();
            
            switch(randomizationType) {
            case "variance":
                text = String.format("Randomize unit growths by Variance ±%d",
                        summary.growthsVarianceProperty().getValue());
                break;
            case "redistribute":
                text = String.format("Randomize unit growths by Redistribute ±%d",
                        summary.growthsRedistributeVarProperty().getValue());
                break;
            case "absolute":
                text = String.format("Randomize unit growths by Absolute [%d - %d]",
                        summary.growthsAbsoluteMinProperty().getValue(),
                        summary.growthsAbsoluteMaxProperty().getValue());
                break;
            }
            
            return text;
        }
    };
    
    private StringBinding txtUnitClasses = new StringBinding() {
        {
            super.bind(summary.randomizePlayableUnitClassesProperty(), summary.excludeHealersProperty(),
                    summary.excludeThievesProperty());
        }
        
        @Override
        protected String computeValue() {
            String text = "Randomize playable unit classes";
            
            if(summary.excludeHealersProperty().getValue()) {
                text += ", exclude healers";
            }
            
            if(summary.excludeThievesProperty().getValue()) {
                text += ", exclude thieves";
            }
            
            return text;
        }
    };

    private StringBinding txtUnitSkills = new StringBinding() {
        {
            super.bind(summary.maxSkillCountProperty());
        }
        
        @Override
        protected String computeValue() {
            return String.format("Randomize unit skills, skill count range [0 - %d]",
                    summary.maxSkillCountProperty().getValue());
        }
    };
    
    private BooleanBinding enemyLabelVisible = new BooleanBinding() {
        {
            super.bind(summary.randomizeEnemyUnitClassesProperty(), summary.enemiesAddExtraInventoryProperty(),
                    summary.randomizeEnemyMovStarsProperty(), summary.randomizeEnemyLeadershipStarsProperty(),
                    summary.randomizeBossSkillsProperty(), summary.randomizeEnemySkillsProperty());
        }
        
        @Override
        protected boolean computeValue() {
            return summary.randomizeEnemyUnitClassesProperty().getValue()
                    || summary.enemiesAddExtraInventoryProperty().getValue()
                    || summary.randomizeEnemyMovStarsProperty().getValue()
                    || summary.randomizeEnemyLeadershipStarsProperty().getValue()
                    || summary.randomizeBossSkillsProperty().getValue()
                    || summary.randomizeEnemySkillsProperty().getValue();
        }
    };
    
    private StringBinding txtEnemyClases = new StringBinding() {
        {
            super.bind(summary.randomizeEnemyUnitClassesExcludeBossesProperty());
        }
        
        @Override
        protected String computeValue() {
            String text = "Randomize enemy unit classes";
            
            if(summary.randomizeEnemyUnitClassesExcludeBossesProperty().getValue()) {
                text += ", exclude bosses";
            }
                        
            return text;
        }
    };
    
    private StringBinding txtEnemyExtraInventory = new StringBinding() {
        {
            super.bind(summary.enemiesMaxExtraInventoryCountProperty());
        }
        
        @Override
        protected String computeValue() {
            return String.format("Add extra inventory up to %d items",
                    summary.enemiesMaxExtraInventoryCountProperty().getValue());
        }
    };
    
    private StringBinding txtEnemyMovStars = new StringBinding() {
        {
            super.bind(summary.enemyMovStarsExcludeZeroProperty());
        }
        
        @Override
        protected String computeValue() {
            String text = "Randomize enemy Move stars";
            
            if(summary.enemyMovStarsExcludeZeroProperty().getValue()) {
                text += ", exclude units with 0 stars";
            }
                                    
            return text;
        }
    };

    private StringBinding txtEnemyLeadStars = new StringBinding() {
        {
            super.bind(summary.enemyLeadershipStarsCapProperty());
        }
        @Override
        protected String computeValue() {
            return String.format("Randomize enemy Leadership stars, cap at %s stars",
                    summary.enemyLeadershipStarsCapProperty().getValue().getUserData().equals("capAt5") ? "5" : "10");
        }
    };
    
    private StringBinding txtEnemyBossSkills = new StringBinding() {
        {
            super.bind(summary.maxBossSkillCountProperty());
        }
        
        @Override
        protected String computeValue() {
            return String.format("Randomize boss skills, max skill count: %d",
                    summary.maxBossSkillCountProperty().getValue());
        }
    };
    
    private StringBinding txtEnemySkills = new StringBinding() {
        {
            super.bind(summary.maxEnemySkillCountProperty());
        }
        
        @Override
        protected String computeValue() {
            return String.format("Randomize common enemy skills, max skill count: %d",
                    summary.maxEnemySkillCountProperty().getValue());
        }
    };
    
    private BooleanBinding weaponsLabelVisible = new BooleanBinding() {
        {
            super.bind(summary.randomizeWpnsMightProperty(), summary.randomizeWpnsAccuracyProperty(),
                    summary.randomizeWpnsWeightProperty(), summary.randomizeWpnsCriticalProperty(),
                    summary.randomizeWpnsMaxUsesProperty(), summary.randomizeWpnsCostProperty(),
                    summary.wpnsBladeEffectChanceProperty(), summary.wpnsAddStatBonusProperty(),
                    summary.wpnsAddBladeEffectProperty(), summary.wpnsBladeEffectChanceProperty(),
                    summary.wpnsAvailableBladeEffectsProperty(), summary.wpnsAddWeaponSkillProperty(),
                    summary.wpnsExcludeIronWeaponsProperty());
        }
        
        @Override
        protected boolean computeValue() {
            boolean visible = summary.randomizeWpnsMightProperty().getValue()
                    || summary.randomizeWpnsAccuracyProperty().getValue()
                    || summary.randomizeWpnsWeightProperty().getValue()
                    || summary.randomizeWpnsCriticalProperty().getValue()
                    || summary.randomizeWpnsMaxUsesProperty().getValue()
                    || summary.randomizeWpnsCostProperty().getValue()
                    || (summary.wpnsAddBladeEffectProperty().getValue()
                            && summary.wpnsBladeEffectChanceProperty().getValue() > 0
                            && summary.wpnsAvailableBladeEffectsProperty().getValue() > 0)
                    || summary.wpnsAddStatBonusProperty().getValue()
                    || summary.wpnsAddWeaponSkillProperty().getValue();

            return visible;
        }
    };

    private BooleanBinding balanceLabelVisible = new BooleanBinding() {
        {
            super.bind(summary.balanceBuffAllyUnitsProperty(), summary.balanceChangeBraveAxeToBRankProperty(),
                    summary.balanceDowngradeWindTomeProperty(), summary.balanceNerfBallistaeProperty(),
                    summary.balanceRemovePrfLocksProperty(), summary.balanceWpnsIncreaseUsesProperty(),
                    summary.balanceAllyAddExtraInventoryProperty());
        }

        @Override
        protected boolean computeValue() {
            return summary.balanceBuffAllyUnitsProperty().getValue()
                    || summary.balanceChangeBraveAxeToBRankProperty().getValue()
                    || summary.balanceDowngradeWindTomeProperty().getValue()
                    || summary.balanceNerfBallistaeProperty().getValue()
                    || summary.balanceRemovePrfLocksProperty().getValue()
                    || summary.balanceWpnsIncreaseUsesProperty().getValue()
                    || summary.balanceAllyAddExtraInventoryProperty().getValue();
        }
    };

    private StringBinding txtAllyExtraInventory = new StringBinding() {
        {
            super.bind(summary.balanceAllyMaxExtraInventoryCountProperty());
        }

        @Override
        protected String computeValue() {
            return String.format("Add ally units up to %d extra items",
                    summary.balanceAllyMaxExtraInventoryCountProperty().getValue());
        }
    };

    private StringBinding txtItemsMight = new StringBinding() {
        {
            super.bind(summary.wpnsMightDeltaProperty());
        }
        
        @Override
        protected String computeValue() {
            return String.format("Randomize items Might ±%d", summary.wpnsMightDeltaProperty().getValue());
        }
    };
    
    private StringBinding txtItemsAccuracy = new StringBinding() {
        {
            super.bind(summary.wpnsAccuracyDeltaProperty());
        }
        
        @Override
        protected String computeValue() {
            return String.format("Randomize items Accuracy ±%d", summary.wpnsAccuracyDeltaProperty().getValue());
        }
    };
    
    private StringBinding txtItemsWeight = new StringBinding() {
        {
            super.bind(summary.wpnsWeightDeltaProperty());
        }
        
        @Override
        protected String computeValue() {
            return String.format("Randomize items Weight ±%d", summary.wpnsWeightDeltaProperty().getValue());
        }
    };
    
    private StringBinding txtItemsCritical = new StringBinding() {
        {
            super.bind(summary.wpnsCriticalDeltaProperty());
        }
        
        @Override
        protected String computeValue() {
            String text = String.format("Randomize items Critical ±%d", summary.wpnsCriticalDeltaProperty().getValue());

            return text;
        }
    };
    
    private StringBinding txtItemsBladeEffect = new StringBinding() {
        {
            super.bind(summary.wpnsBladeEffectChanceProperty(), summary.wpnsAvailableBladeEffectsProperty());
        }

        @Override
        protected String computeValue() {
            ArrayList<WeaponBladeEffect> availableEffects = WeaponBladeEffect.intToWeaponBladeEffect(summary.wpnsAvailableBladeEffectsProperty().getValue());
            String txtAvailableEffects = "";
            
            for(int i = 0; i < availableEffects.size(); i++) {
                txtAvailableEffects += availableEffects.get(i).getName();
                
                if(i < availableEffects.size() - 1) {
                    txtAvailableEffects += ", ";
                }
            }
            
            String text = String.format("Add blade effect, chance: %d%%, effects: %s",
                    summary.wpnsBladeEffectChanceProperty().getValue(), txtAvailableEffects);

            return text;
        }
    };
    
    private BooleanBinding lblItemsBladeEffectVisible = new BooleanBinding() {
        {
            super.bind(summary.wpnsAddBladeEffectProperty(), summary.wpnsBladeEffectChanceProperty(), summary.wpnsAvailableBladeEffectsProperty());
        }
        
        @Override
        protected boolean computeValue() {
            return summary.wpnsAddBladeEffectProperty().getValue()
                    && summary.wpnsBladeEffectChanceProperty().getValue() > 0
                    && summary.wpnsAvailableBladeEffectsProperty().getValue() > 0;
        }
    };
    
    private StringBinding txtItemsStatBonus = new StringBinding() {
        {
            super.bind(summary.wpnsStatBonusChanceProperty());
        }
        
        @Override
        protected String computeValue() {
            String text = String.format("Add +5 Stat bonus, chance: %d%%", summary.wpnsStatBonusChanceProperty().getValue());

            return text;
        }
    };
    
    private StringBinding txtItemsWeaponSkill = new StringBinding() {
        {
            super.bind(summary.wpnsWeaponSkillChanceProperty(), summary.wpnsAllowMultipleWeaponSkillsProperty());
        }
        
        @Override
        protected String computeValue() {
            String text = String.format("Add Weapon skill, chance %d%%", summary.wpnsWeaponSkillChanceProperty().getValue());

            if(summary.wpnsAllowMultipleWeaponSkillsProperty().getValue()) {
                text += ", allow multiple skills";
            }
            
            return text;
        }
    };
    
    private BooleanBinding itemsLabelVisible = new BooleanBinding() {
        {
            super.bind(summary.randomizeRewardsProperty(), summary.randomizeShopsProperty(),
                    summary.randomizeScrollsProperty());
        }
        
        @Override
        protected boolean computeValue() {
            boolean visible = summary.randomizeRewardsProperty().getValue() 
                    || summary.randomizeShopsProperty().getValue()
                    || summary.randomizeScrollsProperty().getValue();

            return visible;
        }
    };
    
    private StringBinding txtItemRewards = new StringBinding() {
        {
            super.bind(summary.rewardsRandomizationTypeProperty(), summary.rewardsSafeScrollsProperty(),
                    summary.rewardsSafeKnightProofsProperty());
        }
        
        @Override
        protected String computeValue() {
            String rewardsType = "";
            String randomizationType = (String)summary.rewardsRandomizationTypeProperty().getValue().getUserData();
            
            switch(randomizationType) {
            case "random":
                rewardsType = "chaotic random"; break;
            case "shuffle":
                rewardsType = "shuffling"; break;
            case "replace":
                rewardsType = "replacing for similar items"; break;
            }
            
            String text = String.format("Randomize item rewards by %s", rewardsType);
            
            if(!randomizationType.equals("shuffle")) {
                if(summary.rewardsSafeScrollsProperty().getValue()) {
                    text += ", safe Scrolls";
                }
                
                if(summary.rewardsSafeKnightProofsProperty().getValue()) {
                    text += ", safe Knight proofs";
                }
            }
                                    
            return text;
        }
    };
    
    private StringBinding txtShopRandomization = new StringBinding() {
        {
            super.bind(summary.shopsRandomizationTypeProperty(), summary.shopsMaintainItemCountProperty());
        }
        
        @Override
        protected String computeValue() {
            String shopMethod = "";
            String randomizationType = (String)summary.shopsRandomizationTypeProperty().getValue().getUserData();
            
            switch(randomizationType) {
            case "random":
                shopMethod = "chaotic random"; break;
            case "shuffle":
                shopMethod = "shuffling"; break;
            case "replace":
                shopMethod = "replacing for similar items"; break;
            }
            
            String text = String.format("Randomize shop items by %s", shopMethod);
            
            if(!randomizationType.equals("replace")
                    && summary.shopsMaintainItemCountProperty().getValue()) {
                text += ", maintain item count";
            }
                                    
            return text;
        }
    };
    
    private StringBinding txtScrollRandomization = new StringBinding() {
        {
            super.bind(summary.scrollsRandomizationTypeProperty(), summary.scrollsShuffleAttributesProperty());
        }
        
        @Override
        protected String computeValue() {
            String scrollMethod = "";
            String randomizationType = (String)summary.scrollsRandomizationTypeProperty().getValue().getUserData();
            
            switch(randomizationType) {
            case "random":
                scrollMethod = "random"; break;
            case "shuffleAttributes":
                scrollMethod = "shuffling attributes"; break;
            case "shuffle":
                scrollMethod = "shuffling"; break;
            }
            
            String text = String.format("Randomize Scrolls by %s", scrollMethod);
            
            if(randomizationType.equals("shuffle")
                    && summary.scrollsShuffleAttributesProperty().getValue()) {
                text += " and then shuffling attributes";
            }
                                    
            return text;
        }
    };
    
    @FXML
    private void initialize() {
        RandomizationSummary summary = MainController.getInstance().getRandomizeSummary();
        
        // units
        lblPlayerUnits.managedProperty().bind(lblPlayerUnits.visibleProperty());
        lblUnitBases.managedProperty().bind(lblUnitBases.visibleProperty());
        lblUnitGrowths.managedProperty().bind(lblUnitGrowths.visibleProperty());
        lblUnitClasses.managedProperty().bind(lblUnitClasses.visibleProperty());
        lblAllyUnitClasses.managedProperty().bind(lblAllyUnitClasses.visibleProperty());
        lblUnitMovStars.managedProperty().bind(lblUnitMovStars.visibleProperty());
        lblUnitLeadStars.managedProperty().bind(lblUnitLeadStars.visibleProperty());
        lblUnitSkills.managedProperty().bind(lblUnitSkills.visibleProperty());
        
        lblPlayerUnits.visibleProperty().bind(unitLabelVisible);
        lblUnitBases.visibleProperty().bind(summary.randomizeBasesProperty());
        lblUnitGrowths.visibleProperty().bind(summary.randomizeGrowthsProperty());
        lblUnitClasses.visibleProperty().bind(summary.randomizePlayableUnitClassesProperty());
        lblAllyUnitClasses.visibleProperty().bind(summary.randomizeAllyUnitClassesProperty());
        lblUnitMovStars.visibleProperty().bind(summary.randomizeMovStarsProperty());
        lblUnitLeadStars.visibleProperty().bind(summary.randomizeLeadershipStarsProperty());
        lblUnitSkills.visibleProperty().bind(summary.RandomizeSkillsProperty());
        
        lblUnitBases.textProperty().bind(txtUnitBases);
        lblUnitGrowths.textProperty().bind(txtUnitGrowths);
        lblUnitClasses.textProperty().bind(txtUnitClasses);
        lblUnitSkills.textProperty().bind(txtUnitSkills);
        
        // enemies
        lblEnemies.managedProperty().bind(lblEnemies.visibleProperty());
        lblEnemyClasses.managedProperty().bind(lblEnemyClasses.visibleProperty());
        lblEnemyExtraInventory.managedProperty().bind(lblEnemyExtraInventory.visibleProperty());
        lblEnemyMovStars.managedProperty().bind(lblEnemyMovStars.visibleProperty());
        lblEnemyLeadStars.managedProperty().bind(lblEnemyLeadStars.visibleProperty());
        lblEnemyBossSkills.managedProperty().bind(lblEnemyBossSkills.visibleProperty());
        lblEnemySkills.managedProperty().bind(lblEnemySkills.visibleProperty());
        
        lblEnemies.visibleProperty().bind(enemyLabelVisible);
        lblEnemyClasses.visibleProperty().bind(summary.randomizeEnemyUnitClassesProperty());
        lblEnemyExtraInventory.visibleProperty().bind(summary.enemiesAddExtraInventoryProperty());
        lblEnemyMovStars.visibleProperty().bind(summary.randomizeEnemyMovStarsProperty());
        lblEnemyLeadStars.visibleProperty().bind(summary.randomizeEnemyLeadershipStarsProperty());
        lblEnemyBossSkills.visibleProperty().bind(summary.randomizeBossSkillsProperty());
        lblEnemySkills.visibleProperty().bind(summary.randomizeEnemySkillsProperty());
        
        lblEnemyClasses.textProperty().bind(txtEnemyClases);
        lblEnemyExtraInventory.textProperty().bind(txtEnemyExtraInventory);
        lblEnemyMovStars.textProperty().bind(txtEnemyMovStars);
        lblEnemyLeadStars.textProperty().bind(txtEnemyLeadStars);
        lblEnemyBossSkills.textProperty().bind(txtEnemyBossSkills);
        lblEnemySkills.textProperty().bind(txtEnemySkills);
        
        // weapons
        lblWeapons.managedProperty().bind(lblWeapons.visibleProperty());
        lblItemsMight.managedProperty().bind(lblItemsMight.visibleProperty());
        lblItemsAccuracy.managedProperty().bind(lblItemsAccuracy.visibleProperty());
        lblItemsWeight.managedProperty().bind(lblItemsWeight.visibleProperty());
        lblItemsCritical.managedProperty().bind(lblItemsCritical.visibleProperty());
        lblItemsMaxUses.managedProperty().bind(lblItemsMaxUses.visibleProperty());
        lblItemsCost.managedProperty().bind(lblItemsCost.visibleProperty());
        lblItemsBladeEffect.managedProperty().bind(lblItemsBladeEffect.visibleProperty());
        lblItemsStatBonus.managedProperty().bind(lblItemsStatBonus.visibleProperty());
        lblItemsWeaponSkill.managedProperty().bind(lblItemsWeaponSkill.visibleProperty());
        lblItemsExcludeIronWeapons.managedProperty().bind(lblItemsExcludeIronWeapons.visibleProperty());
        
        lblWeapons.visibleProperty().bind(weaponsLabelVisible);
        lblItemsMight.visibleProperty().bind(summary.randomizeWpnsMightProperty());
        lblItemsAccuracy.visibleProperty().bind((summary.randomizeWpnsAccuracyProperty()));
        lblItemsWeight.visibleProperty().bind(summary.randomizeWpnsWeightProperty());
        lblItemsCritical.visibleProperty().bind(summary.randomizeWpnsCriticalProperty());
        lblItemsMaxUses.visibleProperty().bind(summary.randomizeWpnsMaxUsesProperty().and(summary.balanceWpnsIncreaseUsesProperty().not()));
        lblItemsCost.visibleProperty().bind(summary.randomizeWpnsCostProperty());
        lblItemsBladeEffect.visibleProperty().bind(lblItemsBladeEffectVisible);
        lblItemsStatBonus.visibleProperty().bind(summary.wpnsAddStatBonusProperty());
        lblItemsWeaponSkill.visibleProperty().bind(summary.wpnsAddWeaponSkillProperty());
        lblItemsExcludeIronWeapons.visibleProperty().bind(summary.wpnsExcludeIronWeaponsProperty().and(summary.anyItemRandomization));
        
        lblItemsMight.textProperty().bind(txtItemsMight);
        lblItemsAccuracy.textProperty().bind(txtItemsAccuracy);
        lblItemsWeight.textProperty().bind(txtItemsWeight);
        lblItemsCritical.textProperty().bind(txtItemsCritical);
        lblItemsBladeEffect.textProperty().bind(txtItemsBladeEffect);
        lblItemsStatBonus.textProperty().bind(txtItemsStatBonus);
        lblItemsWeaponSkill.textProperty().bind(txtItemsWeaponSkill);
        
        // item rewards, shops, scrolls
        lblItems.managedProperty().bind(lblItems.visibleProperty());
        lblRandomizeRewards.managedProperty().bind(lblRandomizeRewards.visibleProperty());
        lblRandomizeShops.managedProperty().bind(lblRandomizeShops.visibleProperty());
        lblRandomizeScrolls.managedProperty().bind(lblRandomizeScrolls.visibleProperty());
        
        lblItems.visibleProperty().bind(itemsLabelVisible);
        lblRandomizeRewards.visibleProperty().bind(summary.randomizeRewardsProperty());
        lblRandomizeShops.visibleProperty().bind(summary.randomizeShopsProperty());
        lblRandomizeScrolls.visibleProperty().bind(summary.randomizeScrollsProperty());
        
        lblRandomizeRewards.textProperty().bind(txtItemRewards);
        lblRandomizeShops.textProperty().bind(txtShopRandomization);
        lblRandomizeScrolls.textProperty().bind(txtScrollRandomization);

        // balance
        lblBalance.managedProperty().bind(lblBalance.visibleProperty());
        lblBalanceNerfBallistaeAcc.managedProperty().bind(lblBalanceNerfBallistaeAcc.visibleProperty());
        lblBalanceAddWeaponUses.managedProperty().bind(lblBalanceAddWeaponUses.visibleProperty());
        lblBalanceDowngradeWindTome.managedProperty().bind(lblBalanceDowngradeWindTome.visibleProperty());
        lblBalanceRemovePrfLocks.managedProperty().bind(lblBalanceRemovePrfLocks.visibleProperty());
        lblBalanceChangeBraveAxeToBRank.managedProperty().bind(lblBalanceChangeBraveAxeToBRank.visibleProperty());
        lblBalanceBuffAllyUnits.managedProperty().bind(lblBalanceBuffAllyUnits.visibleProperty());
        lblBalanceAllyAddInventory.managedProperty().bind(lblBalanceAllyAddInventory.visibleProperty());

        lblBalance.visibleProperty().bind(balanceLabelVisible);
        lblBalanceNerfBallistaeAcc.visibleProperty().bind(summary.balanceNerfBallistaeProperty());
        lblBalanceAddWeaponUses.visibleProperty().bind(summary.balanceWpnsIncreaseUsesProperty().and(summary.randomizeWpnsMaxUsesProperty().not()));
        lblBalanceDowngradeWindTome.visibleProperty().bind(summary.balanceDowngradeWindTomeProperty());
        lblBalanceRemovePrfLocks.visibleProperty().bind(summary.balanceRemovePrfLocksProperty());
        lblBalanceChangeBraveAxeToBRank.visibleProperty().bind(summary.balanceChangeBraveAxeToBRankProperty());
        lblBalanceBuffAllyUnits.visibleProperty().bind(summary.balanceBuffAllyUnitsProperty());
        lblBalanceAllyAddInventory.visibleProperty().bind(summary.balanceAllyAddExtraInventoryProperty());

        lblBalanceAllyAddInventory.textProperty().bind(txtAllyExtraInventory);

        // palettes
        lblPalettes.managedProperty().bind(lblPalettes.visibleProperty());
        lblShufflePalettes.managedProperty().bind(lblShufflePalettes.visibleProperty());
        lblPalettes.visibleProperty().bind(summary.shufflePalettesProperty());
        lblShufflePalettes.visibleProperty().bind(summary.shufflePalettesProperty());
        
        // lil master
        lblLilManster.managedProperty().bind(lblLilManster.visibleProperty());
        lblLilMansterRenamePugi.managedProperty().bind(lblLilMansterRenamePugi.visibleProperty());
        
        lblLilMansterRenamePugi.visibleProperty().bind(summary.lilMansterRenamePugiProperty());
        
        // other
        imgSeed1.imageProperty().bind(icon1);
        imgSeed2.imageProperty().bind(icon2);
        imgSeed3.imageProperty().bind(icon3);
        imgSeed4.imageProperty().bind(icon4);
        imgSeed5.imageProperty().bind(icon5);
        imgSeed6.imageProperty().bind(icon6);
        
        // debug log
        chkWriteDebugLog.managedProperty().bind(chkWriteDebugLog.visibleProperty());
        chkWriteDebugLog.visibleProperty().bind(MainController.getInstance().debugProperty());
        chkWriteDebugLog.selectedProperty().bindBidirectional(summary.writeDebugLogProperty());
        // html log
        chkWriteLog.managedProperty().bind(chkWriteLog.visibleProperty());
        chkWriteLog.selectedProperty().bindBidirectional(summary.writeLogProperty());
    }
    
    public void setRom(Rom rom) {
        lblLilManster.visibleProperty().bind(rom.lilMansterHackProperty().and(summary.lilMansterRenamePugiProperty()));
        lblRomName.setText(rom.getName());
        lblRandomizerVersion.setText(MainController.getVersion());
    }

    @FXML
    public void randomize() {
        FileChooser fileChooser = new FileChooser();
        File file = new File(MainController.CONFIG_FILENAME);
        Properties properties = new Properties();
        String lastDirectory;
        
        MainController mainController = MainController.getInstance();
        Rom rom = mainController.getRom();
        rom.setRandomSeed(mainController.getSeed());
        RandomizationSummary randomizeSummary = mainController.getRandomizeSummary();
        System.out.println(mainController.getRandomizeSummary().toString());
        Label statusLabel = mainController.getStatusLabel();
        ProgressBar progressBar = mainController.getProgressBar();
        
        if(file.exists()) {
            try {
                properties = MainController.readPropertiesFile(MainController.CONFIG_FILENAME);
                lastDirectory = properties.getProperty("lastDirectory", "");

                if(!lastDirectory.isEmpty()) {
                    fileChooser.setInitialDirectory(new File(lastDirectory));
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        
        fileChooser.setTitle("Choose rom file name...");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("SNES ROM files (*.sfc, *.smc, *.fig)", "*.sfc", "*.smc", "*.fig"));
        fileChooser.setInitialFileName("filename.sfc");
        File selectedFile = fileChooser.showSaveDialog(randomize.getScene().getWindow());
        
        if(selectedFile != null) {
            RandomizeRomService randomizeRomService = new RandomizeRomService(rom, randomizeSummary, selectedFile);
            properties.setProperty("lastDirectory", selectedFile.getParent());

            try {
                properties.store(new FileOutputStream(MainController.CONFIG_FILENAME), null);
            } catch(IOException e) {
                e.printStackTrace();
            }
            
            statusLabel.textProperty().bind(randomizeRomService.messageProperty());
            progressBar.progressProperty().bind(randomizeRomService.progressProperty());
            mainController.statusBarControlsVisibleProperty().set(true);
            mainController.disableContentProperty().set(true);

            randomizeRomService.start();
            
            randomizeRomService.setOnFailed((e) -> {
                mainController.getStatusLabel().textProperty().unbind();
                mainController.getProgressBar().progressProperty().unbind();
                mainController.statusBarControlsVisibleProperty().set(false);
                mainController.disableContentProperty().set(false);
                
                Throwable throwable = randomizeRomService.getException();
                throwable.printStackTrace();
                
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText(throwable.getMessage());
                alert.show();
            });

            randomizeRomService.setOnSucceeded((e) -> {
                mainController.getStatusLabel().textProperty().unbind();
                mainController.getProgressBar().progressProperty().unbind();
                mainController.statusBarControlsVisibleProperty().set(false);
                mainController.disableContentProperty().set(false);
                
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("Randomization successful!");
                alert.show();
            });
        }
    }
}
