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
    // playable unit classes
    private final SimpleBooleanProperty randomizePlayableUnitClasses = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty excludeHealers = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty excludeThieves = new SimpleBooleanProperty(false);
    // enemy unit classes
    private final SimpleBooleanProperty randomizeEnemyUnitClasses = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty randomizeEnemyUnitClassesExcludeBosses = new SimpleBooleanProperty(false);
    
    // other
    private final SimpleBooleanProperty writeDebugLog = new SimpleBooleanProperty(true);
    
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
    
    public SimpleBooleanProperty randomizePlayableUnitClassesProperty() {
        return randomizePlayableUnitClasses;
    }
    
    public SimpleBooleanProperty excludeHealersProperty() {
        return excludeHealers;
    }
    
    public SimpleBooleanProperty excludeThievesProperty() {
        return excludeThieves;
    }
    
    public SimpleBooleanProperty randomizeEnemyUnitClassesProperty() {
        return randomizeEnemyUnitClasses;
    }

    public SimpleBooleanProperty randomizeEnemyUnitClassesExcludeBossesProperty() {
        return randomizeEnemyUnitClassesExcludeBosses;
    }
    
    public SimpleBooleanProperty writeDebugLogProperty() {
        return writeDebugLog;
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
    
    public boolean getRandomizeEnemyUnitClasses() {
        return randomizeEnemyUnitClasses.getValue();
    }

    public boolean getRandomizeEnemyUnitClassesExcludeBosses() {
        return randomizeEnemyUnitClassesExcludeBosses.getValue();
    }
    
    public boolean getWriteDebugLog() {
        return writeDebugLog.getValue();
    }
    
    @Override
    public String toString() {
        String text = "[RandomizationSummary]\n";
        
        text += String.format("Randomize bases? %b, Randomize type: %s, Delta: %d, Variance: %d\n",
                randomizeBases.getValue(), (String) basesRandomizationType.getValue().getUserData(), basesVariance.getValue(), basesRedistributeVar.getValue());
        text += String.format("Randomize growths? %b, Randomize type: %s, Delta: %d, Variance: %d, Absolute: [%d - %d]\n",
                randomizeGrowths.getValue(), (String) growthsRandomizationType.getValue().getUserData(), growthsVariance.getValue(), growthsRedistributeVar.getValue(), growthsAbsoluteMin.getValue(), growthsAbsoluteMax.getValue());
        text += String.format("Randomize enemy classes: %b, Exclude bosses: %b", randomizeEnemyUnitClasses.getValue(), randomizeEnemyUnitClassesExcludeBosses.getValue());
        
        return text;
    }
}