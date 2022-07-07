package org.hexrobot.fe5randomizer;

import java.util.ArrayList;

import org.hexrobot.fe5randomizer.items.WeaponBladeEffect;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Toggle;

public class RandomizationSummary {
    // playable units bases 
    private final SimpleBooleanProperty randomizeBases = new SimpleBooleanProperty(false);
    private final SimpleObjectProperty<Toggle> basesRandomizationType = new SimpleObjectProperty<Toggle>();
    private final SimpleObjectProperty<Integer> basesVariance = new SimpleObjectProperty<Integer>(3);
    private final SimpleObjectProperty<Integer> basesRedistributeVar = new SimpleObjectProperty<Integer>(5);
    // playable units growths
    private final SimpleBooleanProperty randomizeGrowths = new SimpleBooleanProperty(false);
    private final SimpleObjectProperty<Toggle> growthsRandomizationType = new SimpleObjectProperty<Toggle>();
    private final SimpleObjectProperty<Integer> growthsVariance = new SimpleObjectProperty<Integer>(30);
    private final SimpleObjectProperty<Integer> growthsRedistributeVar = new SimpleObjectProperty<Integer>(30);
    private final SimpleObjectProperty<Integer> growthsAbsoluteMin = new SimpleObjectProperty<Integer>(5);
    private final SimpleObjectProperty<Integer> growthsAbsoluteMax = new SimpleObjectProperty<Integer>(90);
    // Movement & Leadership stars
    private final SimpleBooleanProperty randomizeMovStars = new SimpleBooleanProperty();
    private final SimpleBooleanProperty movStarsExcludeZero = new SimpleBooleanProperty();
    private final SimpleBooleanProperty randomizeLeadershipStars = new SimpleBooleanProperty();
    private final SimpleBooleanProperty leadershipExcludeZero = new SimpleBooleanProperty();
    // playable unit classes
    private final SimpleBooleanProperty randomizePlayableUnitClasses = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty excludeHealers = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty excludeThieves = new SimpleBooleanProperty(false);
    // ally unit classes
    private final SimpleBooleanProperty randomizeAllyUnitClasses = new SimpleBooleanProperty(false);
    // skills
    private final SimpleBooleanProperty randomizeSkills = new SimpleBooleanProperty(false);
    private final SimpleObjectProperty<Integer> maxSkillCount = new SimpleObjectProperty<Integer>(3);
    // enemy unit classes
    private final SimpleBooleanProperty randomizeEnemyUnitClasses = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty randomizeEnemyUnitClassesExcludeBosses = new SimpleBooleanProperty(false);
    // extra inventory
    private final SimpleBooleanProperty enemiesAddExtraInventory = new SimpleBooleanProperty(false);
    private final SimpleObjectProperty<Integer> enemiesMaxExtraInventoryCount = new SimpleObjectProperty<Integer>(2);
    // enemy movement & Leadership stars
    private final SimpleBooleanProperty randomizeEnemyMovStars = new SimpleBooleanProperty();
    private final SimpleBooleanProperty enemyMovStarsExcludeZero = new SimpleBooleanProperty();
    private final SimpleBooleanProperty randomizeEnemyLeadershipStars = new SimpleBooleanProperty();
    // enemy skills
    private final SimpleBooleanProperty randomizeBossSkills = new SimpleBooleanProperty();
    private final SimpleObjectProperty<Integer> maxBossSkillCount = new SimpleObjectProperty<Integer>(3);
    private final SimpleBooleanProperty randomizeEnemySkills = new SimpleBooleanProperty();
    private final SimpleObjectProperty<Integer> maxEnemySkillCount = new SimpleObjectProperty<Integer>(1);
    // weapons
    private final SimpleBooleanProperty randomizeWpnsMight = new SimpleBooleanProperty();
    private final SimpleBooleanProperty randomizeWpnsAccuracy = new SimpleBooleanProperty();
    private final SimpleBooleanProperty randomizeWpnsWeight = new SimpleBooleanProperty();
    private final SimpleBooleanProperty randomizeWpnsCritical = new SimpleBooleanProperty();
    private final SimpleObjectProperty<Integer> wpnsMightDelta = new SimpleObjectProperty<Integer>(3);
    private final SimpleObjectProperty<Integer> wpnsAccuracyDelta = new SimpleObjectProperty<Integer>(30);
    private final SimpleObjectProperty<Integer> wpnsWeightDelta = new SimpleObjectProperty<Integer>(3);
    private final SimpleObjectProperty<Integer> wpnsCriticalDelta = new SimpleObjectProperty<Integer>(20);
    private final SimpleBooleanProperty randomizeWpnsMaxUses = new SimpleBooleanProperty();
    private final SimpleBooleanProperty randomizeWpnsCost = new SimpleBooleanProperty();
    private final SimpleBooleanProperty wpnsAddBladeEffect = new SimpleBooleanProperty();
    private final SimpleBooleanProperty wpnsAddStatBonus = new SimpleBooleanProperty();
    private final SimpleBooleanProperty wpnsAddWeaponSkill = new SimpleBooleanProperty();
    private final SimpleObjectProperty<Integer> wpnsBladeEffectChance = new SimpleObjectProperty<Integer>(10);
    private final SimpleObjectProperty<Integer> wpnsStatBonusChance = new SimpleObjectProperty<Integer>(3);
    private final SimpleObjectProperty<Integer> wpnsSkillChance = new SimpleObjectProperty<Integer>(5);
    private final SimpleIntegerProperty wpnsAvailableBladeEffects = new SimpleIntegerProperty(0);
    private final SimpleBooleanProperty wpnsAllowMultipleWeaponSkills = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty wpnsExcludeIronWeapons = new SimpleBooleanProperty(false);
    // item rewards
    private final SimpleBooleanProperty randomizeRewards = new SimpleBooleanProperty(false);
    private final SimpleObjectProperty<Toggle> rewardsRandomizationType = new SimpleObjectProperty<Toggle>();
    private final SimpleBooleanProperty rewardsSafeScrolls = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty rewardsSafeKnightProofs = new SimpleBooleanProperty(false);
    // shops
    private final SimpleBooleanProperty randomizeShops = new SimpleBooleanProperty(false);
    private final SimpleObjectProperty<Toggle> shopsRandomizationType = new SimpleObjectProperty<Toggle>();
    private final SimpleBooleanProperty shopsMaintainItemCount = new SimpleBooleanProperty(false);
    // scrolls
    private final SimpleBooleanProperty randomizeScrolls = new SimpleBooleanProperty(false);
    private final SimpleObjectProperty<Toggle> scrollsRandomizationType = new SimpleObjectProperty<Toggle>();
    private final SimpleBooleanProperty scrollsShuffleAttributes = new SimpleBooleanProperty(false);
    // balance
    private final SimpleBooleanProperty balanceChangeBraveAxeToBRank = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty balanceBuffAllyUnits = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty balanceAllyAddExtraInventory = new SimpleBooleanProperty(false);
    private final SimpleObjectProperty<Integer> balanceAllyMaxExtraInventoryCount = new SimpleObjectProperty<Integer>(2);
    private final SimpleBooleanProperty balanceNerfBallistae = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty balanceWpnsIncreaseUses = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty balanceDowngradeWindTome = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty balanceRemovePrfLocks = new SimpleBooleanProperty(false);
    // palettes
    private final SimpleBooleanProperty shufflePalettes = new SimpleBooleanProperty(false);
    // Lil Manster
    private final SimpleBooleanProperty lilMansterRenamePugi = new SimpleBooleanProperty(false);
    // Project Exile
    private final SimpleBooleanProperty exileRenamePugi = new SimpleBooleanProperty(false);
    // summary
    private final SimpleIntegerProperty seed = new SimpleIntegerProperty(0);
    private final SimpleBooleanProperty writeDebugLog = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty writeLog = new SimpleBooleanProperty(true);
    
    public BooleanBinding anyItemRandomization = new BooleanBinding() {
        {
            super.bind(randomizeWpnsMight, randomizeWpnsAccuracy, randomizeWpnsWeight, randomizeWpnsCritical,
                    randomizeWpnsMaxUses, randomizeWpnsCost,
                    wpnsAddBladeEffect, wpnsBladeEffectChance, wpnsAvailableBladeEffects, wpnsAddStatBonus,
                    wpnsStatBonusChance, wpnsAddWeaponSkill, wpnsSkillChance);
        }

        @Override
        protected boolean computeValue() {
            return randomizeWpnsMight.getValue()
                    || randomizeWpnsAccuracy.getValue()
                    || randomizeWpnsWeight.getValue()
                    || randomizeWpnsCritical.getValue()
                    || randomizeWpnsMaxUses.getValue()
                    || randomizeWpnsCost.getValue()
                    || (wpnsAddBladeEffect.getValue() && wpnsBladeEffectChance.getValue() > 0 && wpnsAvailableBladeEffects.getValue() > 0)
                    || (wpnsAddStatBonus.getValue() && wpnsStatBonusChance.getValue() > 0)
                    || (wpnsAddWeaponSkill.getValue() && wpnsSkillChance.getValue() > 0);
        }
    };
    
    public SimpleBooleanProperty randomizeBasesProperty() {
        return randomizeBases;
    }
    
    public SimpleObjectProperty<Toggle> basesRandomizationTypeProperty() {
        return basesRandomizationType;
    }
    
    public SimpleObjectProperty<Integer> basesVarianceProperty() {
        return basesVariance;
    }
    
    public SimpleObjectProperty<Integer> basesRedistributeVarProperty() {
        return basesRedistributeVar;
    }
    
    public SimpleBooleanProperty randomizeGrowthsProperty() {
        return randomizeGrowths;
    }
    
    public SimpleObjectProperty<Toggle> growthsRandomizationTypeProperty() {
        return growthsRandomizationType;
    }
    
    public SimpleObjectProperty<Integer> growthsVarianceProperty() {
        return growthsVariance;
    }
    
    public SimpleObjectProperty<Integer> growthsRedistributeVarProperty() {
        return growthsRedistributeVar;
    }
    
    public SimpleObjectProperty<Integer> growthsAbsoluteMinProperty() {
        return growthsAbsoluteMin;
    }
    
    public SimpleObjectProperty<Integer> growthsAbsoluteMaxProperty() {
        return growthsAbsoluteMax;
    }
    
    public SimpleBooleanProperty randomizeMovStarsProperty() {
        return randomizeMovStars;
    }

    public SimpleBooleanProperty movStarsExcludeZeroProperty() {
        return movStarsExcludeZero;
    }

    public SimpleBooleanProperty randomizeLeadershipStarsProperty() {
        return randomizeLeadershipStars;
    }

    public SimpleBooleanProperty leadershipExcludeZeroProperty() {
        return leadershipExcludeZero;
    }

    public SimpleBooleanProperty randomizePlayableUnitClassesProperty() {
        return randomizePlayableUnitClasses;
    }

    public SimpleBooleanProperty randomizeAllyUnitClassesProperty() {
        return randomizeAllyUnitClasses;
    }
    
    public SimpleBooleanProperty excludeHealersProperty() {
        return excludeHealers;
    }
    
    public SimpleBooleanProperty excludeThievesProperty() {
        return excludeThieves;
    }
    
    public SimpleBooleanProperty RandomizeSkillsProperty() {
        return randomizeSkills;
    }

    public SimpleObjectProperty<Integer> maxSkillCountProperty() {
        return maxSkillCount;
    }
    
    public SimpleBooleanProperty randomizeEnemyUnitClassesProperty() {
        return randomizeEnemyUnitClasses;
    }

    public SimpleBooleanProperty randomizeEnemyUnitClassesExcludeBossesProperty() {
        return randomizeEnemyUnitClassesExcludeBosses;
    }
    
    public SimpleBooleanProperty enemiesAddExtraInventoryProperty() {
        return enemiesAddExtraInventory;
    }

    public SimpleObjectProperty<Integer> enemiesMaxExtraInventoryCountProperty() {
        return enemiesMaxExtraInventoryCount;
    }

    public SimpleBooleanProperty randomizeEnemyMovStarsProperty() {
        return randomizeEnemyMovStars;
    }

    public SimpleBooleanProperty enemyMovStarsExcludeZeroProperty() {
        return enemyMovStarsExcludeZero;
    }

    public SimpleBooleanProperty randomizeEnemyLeadershipStarsProperty() {
        return randomizeEnemyLeadershipStars;
    }

    public SimpleBooleanProperty randomizeBossSkillsProperty() {
        return randomizeBossSkills;
    }

    public SimpleObjectProperty<Integer> maxBossSkillCountProperty() {
        return maxBossSkillCount;
    }

    public SimpleBooleanProperty randomizeEnemySkillsProperty() {
        return randomizeEnemySkills;
    }

    public SimpleObjectProperty<Integer> maxEnemySkillCountProperty() {
        return maxEnemySkillCount;
    }

    public SimpleBooleanProperty balanceChangeBraveAxeToBRankProperty() {
        return balanceChangeBraveAxeToBRank;
    }

    public SimpleBooleanProperty balanceBuffAllyUnitsProperty() {
        return balanceBuffAllyUnits;
    }

    public SimpleBooleanProperty balanceAllyAddExtraInventoryProperty() {
        return balanceAllyAddExtraInventory;
    }

    public SimpleObjectProperty<Integer> balanceAllyMaxExtraInventoryCountProperty() {
        return balanceAllyMaxExtraInventoryCount;
    }
    
    public SimpleBooleanProperty balanceNerfBallistaeProperty() {
        return balanceNerfBallistae;
    }

    public SimpleBooleanProperty randomizeWpnsMightProperty() {
        return randomizeWpnsMight;
    }

    public SimpleBooleanProperty randomizeWpnsAccuracyProperty() {
        return randomizeWpnsAccuracy;
    }

    public SimpleBooleanProperty randomizeWpnsWeightProperty() {
        return randomizeWpnsWeight;
    }

    public SimpleBooleanProperty randomizeWpnsCriticalProperty() {
        return randomizeWpnsCritical;
    }

    public SimpleObjectProperty<Integer> wpnsMightDeltaProperty() {
        return wpnsMightDelta;
    }

    public SimpleObjectProperty<Integer> wpnsAccuracyDeltaProperty() {
        return wpnsAccuracyDelta;
    }

    public SimpleObjectProperty<Integer> wpnsWeightDeltaProperty() {
        return wpnsWeightDelta;
    }

    public SimpleObjectProperty<Integer> wpnsCriticalDeltaProperty() {
        return wpnsCriticalDelta;
    }
    
    public SimpleBooleanProperty randomizeWpnsMaxUsesProperty() {
        return randomizeWpnsMaxUses;
    }

    public SimpleBooleanProperty randomizeWpnsCostProperty() {
        return randomizeWpnsCost;
    }

    public SimpleBooleanProperty wpnsAddBladeEffectProperty() {
        return wpnsAddBladeEffect;
    }

    public SimpleBooleanProperty wpnsAddStatBonusProperty() {
        return wpnsAddStatBonus;
    }

    public SimpleBooleanProperty wpnsAddWeaponSkillProperty() {
        return wpnsAddWeaponSkill;
    }

    public SimpleObjectProperty<Integer> wpnsBladeEffectChanceProperty() {
        return wpnsBladeEffectChance;
    }

    public SimpleObjectProperty<Integer> wpnsStatBonusChanceProperty() {
        return wpnsStatBonusChance;
    }

    public SimpleObjectProperty<Integer> wpnsWeaponSkillChanceProperty() {
        return wpnsSkillChance;
    }

    public SimpleIntegerProperty wpnsAvailableBladeEffectsProperty() {
        return wpnsAvailableBladeEffects;
    }

    public SimpleBooleanProperty wpnsAllowMultipleWeaponSkillsProperty() {
        return wpnsAllowMultipleWeaponSkills;
    }
    
    public SimpleBooleanProperty wpnsExcludeIronWeaponsProperty() {
        return wpnsExcludeIronWeapons;
    }

    public SimpleBooleanProperty balanceWpnsIncreaseUsesProperty() {
        return balanceWpnsIncreaseUses;
    }

    public SimpleBooleanProperty balanceDowngradeWindTomeProperty() {
        return balanceDowngradeWindTome;
    }

    public SimpleBooleanProperty balanceRemovePrfLocksProperty() {
        return balanceRemovePrfLocks;
    }
    
    public SimpleBooleanProperty randomizeRewardsProperty() {
        return randomizeRewards;
    }

    public SimpleObjectProperty<Toggle> rewardsRandomizationTypeProperty() {
        return rewardsRandomizationType;
    }

    public SimpleBooleanProperty rewardsSafeScrollsProperty() {
        return rewardsSafeScrolls;
    }
    
    public SimpleBooleanProperty rewardsSafeKnightProofsProperty() {
        return rewardsSafeKnightProofs;
    }
    
    public SimpleBooleanProperty randomizeShopsProperty() {
        return randomizeShops;
    }

    public SimpleObjectProperty<Toggle> shopsRandomizationTypeProperty() {
        return shopsRandomizationType;
    }

    public SimpleBooleanProperty shopsMaintainItemCountProperty() {
        return shopsMaintainItemCount;
    }
    
    public SimpleBooleanProperty randomizeScrollsProperty() {
        return randomizeScrolls;
    }

    public SimpleObjectProperty<Toggle> scrollsRandomizationTypeProperty() {
        return scrollsRandomizationType;
    }
    
    public SimpleBooleanProperty scrollsShuffleAttributesProperty() {
        return scrollsShuffleAttributes;
    }

    public BooleanBinding anyItemRandomizationProperty() {
        return anyItemRandomization;
    }

    public SimpleBooleanProperty shufflePalettesProperty() {
        return shufflePalettes;
    }

    public SimpleBooleanProperty lilMansterRenamePugiProperty() {
        return lilMansterRenamePugi;
    }
    
    public SimpleBooleanProperty projectExileRenamePugiProperty() {
        return exileRenamePugi;
    }
    
    public SimpleIntegerProperty seedProperty() {
        return seed;
    }

    public SimpleBooleanProperty writeDebugLogProperty() {
        return writeDebugLog;
    }

    public SimpleBooleanProperty writeLogProperty() {
        return writeLog;
    }

    public boolean getRandomizeBases() {
        return randomizeBases.getValue();
    }

    public String getBasesRandomizationType() {
        return (String) basesRandomizationType.getValue().getUserData();
    }

    public int getBasesVariance() {
        return basesVariance.getValue();
    }

    public int getBasesRedistributeVar() {
        return basesRedistributeVar.getValue();
    }

    public boolean getRandomizeGrowths() {
        return randomizeGrowths.getValue();
    }

    public String getGrowthsRandomizationType() {
        return (String) growthsRandomizationType.getValue().getUserData();
    }

    public int getGrowthsVariance() {
        return growthsVariance.getValue();
    }

    public int getGrowthsRedistributeVar() {
        return growthsRedistributeVar.getValue();
    }

    public int getGrowthsAbsoluteMin() {
        return growthsAbsoluteMin.getValue();
    }

    public int getGrowthsAbsoluteMax() {
        return growthsAbsoluteMax.getValue();
    }
    
    public boolean getRandomizePlayableUnitClasses() {
        return randomizePlayableUnitClasses.getValue();
    }

    public boolean getRandomizeAllyUnitClasses() {
        return randomizeAllyUnitClasses.getValue();
    }
    
    public boolean getExcludeHealers() {
        return excludeHealers.getValue();
    }
    
    public boolean getExcludeThieves() {
        return excludeThieves.getValue();
    }
    
    public boolean getRandomizeSkills() {
        return randomizeSkills.getValue();
    }

    public int getMaxSkillCount() {
        return maxSkillCount.getValue();
    }

    public boolean getRandomizeMovStars() {
        return randomizeMovStars.getValue();
    }

    public boolean getMovStarsExcludeZero() {
        return movStarsExcludeZero.getValue();
    }

    public boolean getRandomizeLeadershipStars() {
        return randomizeLeadershipStars.getValue();
    }

    public boolean getLeadershipExcludeZero() {
        return leadershipExcludeZero.getValue();
    }
    
    public boolean getRandomizeEnemyUnitClasses() {
        return randomizeEnemyUnitClasses.getValue();
    }

    public boolean getRandomizeEnemyUnitClassesExcludeBosses() {
        return randomizeEnemyUnitClassesExcludeBosses.getValue();
    }
    
    public boolean getEnemiesAddExtraInventory() {
        return enemiesAddExtraInventory.getValue();
    }

    public int getEnemiesMaxExtraInventoryCount() {
        return enemiesMaxExtraInventoryCount.getValue();
    }
    
    public boolean getRandomizeEnemyMovStars() {
        return randomizeEnemyMovStars.getValue();
    }

    public boolean getEnemyMovStarsExcludeZero() {
        return enemyMovStarsExcludeZero.getValue();
    }

    public boolean getRandomizeEnemyLeadershipStars() {
        return randomizeEnemyLeadershipStars.getValue();
    }

    public boolean getRandomizeBossSkills() {
        return randomizeBossSkills.getValue();
    }

    public int getMaxBossSkillCount() {
        return maxBossSkillCount.getValue();
    }

    public boolean getRandomizeEnemySkills() {
        return randomizeEnemySkills.getValue();
    }

    public int getMaxEnemySkillCount() {
        return maxEnemySkillCount.getValue();
    }

    public boolean getBalanceChangeBraveAxeToBRank() {
        return balanceChangeBraveAxeToBRank.getValue();
    }

    public boolean getBalanceBuffAllyUnits() {
        return balanceBuffAllyUnits.getValue();
    }

    public boolean getBalanceAllyAddExtraInventory() {
        return balanceAllyAddExtraInventory.getValue();
    }

    public int getBalanceAllyMaxExtraInventoryCount() {
        return balanceAllyMaxExtraInventoryCount.getValue();
    }
    
    public boolean getNerfBallistae() {
        return balanceNerfBallistae.getValue();
    }

    public boolean getRandomizeWpnsMight() {
        return randomizeWpnsMight.getValue();
    }

    public boolean getRandomizeWpnsAccuracy() {
        return randomizeWpnsAccuracy.getValue();
    }

    public boolean getRandomizeWpnsWeight() {
        return randomizeWpnsWeight.getValue();
    }

    public boolean getRandomizeWpnsCritical() {
        return randomizeWpnsCritical.getValue();
    }

    public int getWpnsMightDelta() {
        return wpnsMightDelta.getValue();
    }

    public int getWpnsAccuracyDelta() {
        return wpnsAccuracyDelta.getValue();
    }

    public int getWpnsWeightDelta() {
        return wpnsWeightDelta.getValue();
    }

    public int getWpnsCriticalDelta() {
        return wpnsCriticalDelta.getValue();
    }
    
    public boolean getRandomizeWpns() {
        return randomizeWpnsMight.getValue() 
                || randomizeWpnsAccuracy.getValue() || randomizeWpnsWeight.getValue()
                || randomizeWpnsCritical.getValue() || randomizeWpnsMaxUses.getValue()
                || randomizeWpnsCost.getValue() || wpnsAddBladeEffect.getValue() 
                || wpnsAddStatBonus.getValue()  || wpnsAddWeaponSkill.getValue();
    }
    
    public boolean getRandomizeWpnsMaxUses() {
        return randomizeWpnsMaxUses.getValue();
    }

    public boolean getRandomizeWpnsCost() {
        return randomizeWpnsCost.getValue();
    }

    public boolean getWpnsAddBladeEffect() {
        return wpnsAddBladeEffect.getValue();
    }

    public boolean getWpnsAddStatBonus() {
        return wpnsAddStatBonus.getValue();
    }

    public boolean getWpnsAddWeaponSkill() {
        return wpnsAddWeaponSkill.getValue();
    }

    public int getWpnsBladeEffectChance() {
        return wpnsBladeEffectChance.getValue();
    }

    public int getWpnsStatBonusChance() {
        return wpnsStatBonusChance.getValue();
    }

    public int getWpnsSkillChance() {
        return wpnsSkillChance.getValue();
    }

    public int getWpnsAvailableBladeEffects() {
        return wpnsAvailableBladeEffects.getValue();
    }
    
    public ArrayList<WeaponBladeEffect> getWpnsAvailableBladeEffectsList() {
        return WeaponBladeEffect.intToWeaponBladeEffect(wpnsAvailableBladeEffects.getValue());
    }

    public boolean getWpnsAllowMultipleWeaponSkills() {
        return wpnsAllowMultipleWeaponSkills.getValue();
    }
    
    public boolean getWpnsExcludeIronWeapons() {
        return wpnsExcludeIronWeapons.getValue();
    }

    public boolean getBalanceWpnsIncreaseUses() {
        return balanceWpnsIncreaseUses.getValue();
    }

    public boolean getBalanceDowngradeWindTome() {
        return balanceDowngradeWindTome.getValue();
    }

    public boolean getBalanceRemovePrfLocks() {
        return balanceRemovePrfLocks.getValue();
    }
    
    public boolean getRandomizeRewards() {
        return randomizeRewards.getValue();
    }

    public String getRewardsRandomizationType() {
        return (String)rewardsRandomizationType.getValue().getUserData();
    }

    public boolean getRewardsSafeScrolls() {
        return rewardsSafeScrolls.getValue();
    }
    
    public boolean getRewardsSafeKnightProofs() {
        return rewardsSafeKnightProofs.getValue();
    }
    
    public boolean getRandomizeScrolls() {
        return randomizeScrolls.getValue();
    }

    public String getScrollsRandomizationType() {
        return (String)scrollsRandomizationType.getValue().getUserData();
    }
    
    public boolean getScrollsShuffleAttributes() {
        return scrollsShuffleAttributes.getValue();
    }

    public boolean getShopsMaintainItemCount() {
        return shopsMaintainItemCount.getValue();
    }
    
    public boolean getRandomizeShops() {
        return randomizeShops.getValue();
    }

    public String getShopsRandomizationType() {
        return (String)shopsRandomizationType.getValue().getUserData();
    }

    public BooleanBinding getAnyItemRandomization() {
        return anyItemRandomization;
    }

    public boolean getShufflePalettes() {
        return shufflePalettes.getValue();
    }

    public boolean getLilMansterRenamePugi() {
        return lilMansterRenamePugi.getValue();
    }
    
    public boolean getProjectExileRenamePugi() {
        return exileRenamePugi.getValue();
    }
    
    public int getSeed() {
        return seed.getValue();
    }
    
    public boolean getWriteDebugLog() {
        return writeDebugLog.getValue();
    }
    
    public boolean getWriteLog() {
        return writeLog.getValue();
    }
    
    @Override
    public String toString() {
        String text = "[RandomizationSummary]\n";
        
        text += String.format("Randomize bases? %b, Randomize type: %s, Delta: %d, Variance: %d\n",
                randomizeBases.getValue(), getBasesRandomizationType(), basesVariance.getValue(), basesRedistributeVar.getValue());
        text += String.format("Randomize growths? %b, Randomize type: %s, Delta: %d, Variance: %d, Absolute: [%d - %d]\n",
                randomizeGrowths.getValue(), getGrowthsRandomizationType(), growthsVariance.getValue(), growthsRedistributeVar.getValue(), growthsAbsoluteMin.getValue(), growthsAbsoluteMax.getValue());
        text += String.format("Randomize playable unit clases? %b, Exclude healers: %b, Exclude thieves: %b, Randomize ally unit classes? %b\n",
                randomizePlayableUnitClasses.getValue(), excludeHealers.getValue(), excludeThieves.getValue(), randomizeAllyUnitClasses.getValue());
        text += String.format("Randomize Mov stars? %b, Exclude units with zero stars: %b, Randomize Leadership stars? %b, Exclude units with 0 stars: %b\n",
                randomizeMovStars.getValue(), movStarsExcludeZero.getValue(), randomizeLeadershipStars.getValue(), leadershipExcludeZero.getValue());
        text += String.format("Randomize enemy classes: %b, Exclude bosses: %b\n",
                randomizeEnemyUnitClasses.getValue(), randomizeEnemyUnitClassesExcludeBosses.getValue());
        text += String.format("Randomize enemy Mov stars? %b, Exclude units with zero stars: %b, Randomize enemy Leadership stars? %b\n",
                randomizeEnemyMovStars.getValue(), enemyMovStarsExcludeZero.getValue(), randomizeEnemyLeadershipStars.getValue());
        text += String.format("Randomize boss skills? %b, Max skill count: %d, Randomize normal enemy skills? %b, Max skill count: %d, Nerf Ballistae: %b\n",
                randomizeBossSkills.getValue(), maxBossSkillCount.getValue(), randomizeEnemySkills.getValue(), maxEnemySkillCount.getValue(), balanceNerfBallistae.getValue());
        text += String.format("Randomize weapons... Might? %b, Delta: %d, Accuracy? %b, Delta: %d, Weight? %b, Delta: %d, Critical: %b, Delta %d\n",
                randomizeWpnsMight.getValue(), wpnsMightDelta.getValue(), randomizeWpnsAccuracy.getValue(), wpnsAccuracyDelta.getValue(), randomizeWpnsWeight.getValue(), wpnsWeightDelta.getValue(), randomizeWpnsCritical.getValue(), wpnsCriticalDelta.getValue());
        text += String.format("Randomize weapons... Max uses? %b, Cost? %b, Blade effect? %b, Chance: %d, Effects: %d, Stat bonus: %b, Chance %d, Weapon skill: %b, Chance: %d, Allow multiple: %b, Exclude iron weapons? %b\n",
                randomizeWpnsMaxUses.getValue(), randomizeWpnsCost.getValue(), wpnsAddBladeEffect.getValue(), wpnsBladeEffectChance.getValue(), wpnsAvailableBladeEffects.getValue(), wpnsAddStatBonus.getValue(), wpnsStatBonusChance.getValue(), wpnsAddWeaponSkill.getValue(), wpnsSkillChance.getValue(), wpnsAllowMultipleWeaponSkills.getValue(), wpnsExcludeIronWeapons.getValue());
        text += String.format("Randomize rewards: %b... Randomization type: %s, Safe scrolls: %b, Safe KnightProofs: %b\n",
                randomizeRewards.getValue(), getRewardsRandomizationType(), rewardsSafeScrolls.getValue(), rewardsSafeKnightProofs.getValue());
        text += String.format("Randomize shops: %b... Randomization type: %s, Maintain item count: %b\n",
                randomizeShops.getValue(), getShopsRandomizationType(), shopsMaintainItemCount.getValue());
        text += String.format("Randomize scrolls: %b... Randomization type: %s, Shuffle attributes: %b\n",
                randomizeScrolls.getValue(), getScrollsRandomizationType(), scrollsShuffleAttributes.getValue());
        text += String.format("Balance. Brave axe rank B: %b, Nerf ballistae acc: %b, Buff Ally units: %b, Allies add extra inventory: %b, Allies max etra inventory: %d, Add weapon uses: %b, Downgrade Wind tome: %b, Remove Prf* locks: %b\n",
                balanceChangeBraveAxeToBRank.getValue(), balanceNerfBallistae.getValue(), balanceBuffAllyUnits.getValue(), balanceAllyAddExtraInventory.getValue(), balanceAllyMaxExtraInventoryCount.getValue(), balanceWpnsIncreaseUses.getValue(), balanceDowngradeWindTome.getValue(), balanceRemovePrfLocks.getValue());
        text += String.format("Randomize palettes: %b\n", shufflePalettes.getValue());
        text += String.format("Lil' Manster Rename to Pugi: %b\n", lilMansterRenamePugi.getValue());
        text += String.format("Project Exile Rename to Pugi: %b\n", exileRenamePugi.getValue());
        
        return text;
    }
}
