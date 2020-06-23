package org.hexrobot.fe5randomizer;

import javafx.beans.property.SimpleBooleanProperty;
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
    private final SimpleBooleanProperty enemyLeadershipExcludeZero = new SimpleBooleanProperty();
    // enemy skills
    private final SimpleBooleanProperty randomizeBossSkills = new SimpleBooleanProperty();
    private final SimpleObjectProperty<Integer> maxBossSkillCount = new SimpleObjectProperty<Integer>(3);
    private final SimpleBooleanProperty randomizeEnemySkills = new SimpleBooleanProperty();
    private final SimpleObjectProperty<Integer> maxEnemySkillCount = new SimpleObjectProperty<Integer>(1);
    // items
    private final SimpleBooleanProperty randomizeItemsMight = new SimpleBooleanProperty();
    private final SimpleBooleanProperty randomizeItemsAccuracy = new SimpleBooleanProperty();
    private final SimpleBooleanProperty randomizeItemsWeight = new SimpleBooleanProperty();
    private final SimpleBooleanProperty randomizeItemsCritical = new SimpleBooleanProperty();
    private final SimpleObjectProperty<Integer> itemsMightDelta = new SimpleObjectProperty<Integer>(3);
    private final SimpleObjectProperty<Integer> itemsAccuracyDelta = new SimpleObjectProperty<Integer>(30);
    private final SimpleObjectProperty<Integer> itemsWeightDelta = new SimpleObjectProperty<Integer>(3);
    private final SimpleObjectProperty<Integer> itemsCriticalDelta = new SimpleObjectProperty<Integer>(20);
    // summary
    private final SimpleBooleanProperty writeDebugLog = new SimpleBooleanProperty(true);
    private final SimpleBooleanProperty writeToFile = new SimpleBooleanProperty(false);
    
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

    public SimpleBooleanProperty enemyLeadershipExcludeZeroProperty() {
        return enemyLeadershipExcludeZero;
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

    public SimpleBooleanProperty randomizeItemsMightProperty() {
        return randomizeItemsMight;
    }

    public SimpleBooleanProperty randomizeItemsAccuracyProperty() {
        return randomizeItemsAccuracy;
    }

    public SimpleBooleanProperty randomizeItemsWeightProperty() {
        return randomizeItemsWeight;
    }

    public SimpleBooleanProperty randomizeItemsCriticalProperty() {
        return randomizeItemsCritical;
    }

    public SimpleObjectProperty<Integer> itemsMightDeltaProperty() {
        return itemsMightDelta;
    }

    public SimpleObjectProperty<Integer> itemsAccuracyDeltaProperty() {
        return itemsAccuracyDelta;
    }

    public SimpleObjectProperty<Integer> itemsWeightDeltaProperty() {
        return itemsWeightDelta;
    }

    public SimpleObjectProperty<Integer> itemsCriticalDeltaProperty() {
        return itemsCriticalDelta;
    }

    public SimpleBooleanProperty writeDebugLogProperty() {
        return writeDebugLog;
    }

    public SimpleBooleanProperty writeToFileProperty() {
        return writeToFile;
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

    public boolean getEnemyLeadershipExcludeZero() {
        return enemyLeadershipExcludeZero.getValue();
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

    public boolean getRandomizeItemsMight() {
        return randomizeItemsMight.getValue();
    }

    public boolean getRandomizeItemsAccuracy() {
        return randomizeItemsAccuracy.getValue();
    }

    public boolean getRandomizeItemsWeight() {
        return randomizeItemsWeight.getValue();
    }

    public boolean getRandomizeItemsCritical() {
        return randomizeItemsCritical.getValue();
    }

    public int getItemsMightDelta() {
        return itemsMightDelta.getValue();
    }

    public int getItemsAccuracyDelta() {
        return itemsAccuracyDelta.getValue();
    }

    public int getItemsWeightDelta() {
        return itemsWeightDelta.getValue();
    }

    public int getItemsCriticalDelta() {
        return itemsCriticalDelta.getValue();
    }
    
    public boolean getRandomizeItems() {
        return randomizeItemsMight.getValue() || randomizeItemsAccuracy.getValue() || randomizeItemsWeight.getValue() || randomizeItemsCritical.getValue();
    }
    
    public boolean getWriteDebugLog() {
        return writeDebugLog.getValue();
    }
    
    public boolean getWriteToFile() {
        return writeToFile.getValue();
    }
    
    @Override
    public String toString() {
        String text = "[RandomizationSummary]\n";
        
        text += String.format("Randomize bases? %b, Randomize type: %s, Delta: %d, Variance: %d\n",
                randomizeBases.getValue(), (String) basesRandomizationType.getValue().getUserData(), basesVariance.getValue(), basesRedistributeVar.getValue());
        text += String.format("Randomize growths? %b, Randomize type: %s, Delta: %d, Variance: %d, Absolute: [%d - %d]\n",
                randomizeGrowths.getValue(), (String) growthsRandomizationType.getValue().getUserData(), growthsVariance.getValue(), growthsRedistributeVar.getValue(), growthsAbsoluteMin.getValue(), growthsAbsoluteMax.getValue());
        text += String.format("Randomize Mov stars? %b, Exclude units with zero stars: %b, Randomize Leadership stars? %b, Exclude units with 0 stars: %b\n",
                randomizeMovStars.getValue(), movStarsExcludeZero.getValue(), randomizeLeadershipStars.getValue(), leadershipExcludeZero.getValue());
        text += String.format("Randomize enemy classes: %b, Exclude bosses: %b\n",
                randomizeEnemyUnitClasses.getValue(), randomizeEnemyUnitClassesExcludeBosses.getValue());
        text += String.format("Randomize enemy Mov stars? %b, Exclude units with zero stars: %b, Randomize enemy Leadership stars? %b, Exclude units with zero stars: %b\n",
                randomizeEnemyMovStars.getValue(), enemyMovStarsExcludeZero.getValue(), randomizeEnemyLeadershipStars.getValue(), enemyLeadershipExcludeZero.getValue());
        text += String.format("Randomize boss skills? %b, Max skill count: %d, Randomize normal enemy skills? %b, Max skill count: %d\n",
                randomizeBossSkills.getValue(), maxBossSkillCount.getValue(), randomizeEnemySkills.getValue(), maxEnemySkillCount.getValue());
        text += String.format("Randomize items... Might? %b, Delta: %d, Accuracy? %b, Delta: %d, Weight? %b, Delta: %d, Critical: %b, Delta %d\n",
                randomizeItemsMight.getValue(), itemsMightDelta.getValue(), randomizeItemsAccuracy.getValue(), itemsAccuracyDelta.getValue(), randomizeItemsWeight.getValue(), itemsWeightDelta.getValue(), randomizeItemsCritical.getValue(), itemsCriticalDelta.getValue());
        
        return text;
    }
}
