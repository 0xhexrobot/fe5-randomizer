package org.hexrobot.fe5randomizer.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.hexrobot.fe5randomizer.HexTemplateNumberFormatFactory;
import org.hexrobot.fe5randomizer.RandomizationSummary;
import org.hexrobot.fe5randomizer.Rom;
import org.hexrobot.fe5randomizer.chapters.Chapter;
import org.hexrobot.fe5randomizer.characters.CharacterClass;
import org.hexrobot.fe5randomizer.characters.GameCharacter;
import org.hexrobot.fe5randomizer.items.Item;

import freemarker.core.TemplateNumberFormatFactory;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class RandomizeRomService extends Service<Void> {
    private Rom rom;
    private RandomizationSummary summary;
    private Configuration cfg;
    private File romFile;
    
    public RandomizeRomService(Rom rom, RandomizationSummary randomizeSummary, File romFile) {
        this.rom = rom;
        this.summary = randomizeSummary;
        this.romFile = romFile;
        
        cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setClassForTemplateLoading(getClass(), "/");
        cfg.setDefaultEncoding("UTF-8");

        Map<String, TemplateNumberFormatFactory> customNumberFormats = new HashMap<String, TemplateNumberFormatFactory>();
        customNumberFormats.put("hex", HexTemplateNumberFormatFactory.INSTANCE);
        cfg.setCustomNumberFormats(customNumberFormats);
    }
    
    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                Map<String, Object> input = new HashMap<String, Object>();
                
                rom.reset();
                
                if(summary.getItemsRemoveWeaponsPrfLocks()) {
                    rom.removePrfLocks();
                }
                
                if(summary.getItemsDowngradeWindTome()) {
                    rom.downgradeWindTome();
                }
                
                if(summary.getRandomizePlayableUnitClasses()) {
                    updateMessage("Randomize playable unit classes...");
                    rom.randomizePlayableUnitClasses(summary.getExcludeHealers(), summary.getExcludeThieves());
                }
                
                if(summary.getRandomizeEnemyUnitClasses()) {
                    updateMessage("Randomize enemy classes...");
                    rom.randomizeEnemyUnitClasses(summary.getRandomizeEnemyUnitClassesExcludeBosses());
                }
                
                if(summary.getRandomizeBases()) {
                    updateMessage("Randomize unit bases...");
                    
                    if(summary.getBasesRandomizationType().equals("variance")) {
                        rom.randomizeUnitsBasesVariance(summary.getBasesVariance());
                    } else if(summary.getBasesRandomizationType().equals("redistribute")) {
                        rom.randomizeUnitsBasesRedistribute(summary.getBasesRedistributeVar());
                    }
                }
                
                if(summary.getRandomizeGrowths()) {
                    updateMessage("Randomize unit growths...");
                    
                    if(summary.getGrowthsRandomizationType().equals("variance")) {
                        rom.randomizeUnitsGrowthsVariance(summary.getGrowthsVariance());
                    } else if(summary.getGrowthsRandomizationType().equals("redistribute")) {
                        rom.randomizeUnitsGrowthsRedistribute(summary.getBasesRedistributeVar());
                    } else if(summary.getGrowthsRandomizationType().equals("absolute")) {
                        rom.randomizeUnitsGrowthsAbsolute(summary.getGrowthsAbsoluteMin(), summary.getGrowthsAbsoluteMax());
                    }
                }
                
                if(summary.getRandomizeMovStars()) {
                    rom.randomizeMoveStars(summary.getMovStarsExcludeZero());
                }
                
                if(summary.getRandomizeLeadershipStars()) {
                    rom.randomizeLeadershipStars(summary.getLeadershipExcludeZero());
                }
                
                if(summary.getRandomizeEnemyMovStars() ) {
                    rom.randomizeEnemyMoveStars(summary.getEnemyMovStarsExcludeZero());
                }
                
                if(summary.getRandomizeEnemyLeadershipStars()) {
                    rom.randomizeEnemyLeadershipStars(summary.getEnemyLeadershipExcludeZero());
                }
                
                if(summary.getRandomizeSkills()) {
                    rom.randomizeSkills(summary.getMaxSkillCount());
                }
                
                if(summary.getRandomizeBossSkills() | summary.getRandomizeEnemySkills()) {
                    rom.randomizeEnemySkills(summary.getRandomizeBossSkills(), summary.getMaxBossSkillCount(), summary.getRandomizeEnemySkills(), summary.getMaxEnemySkillCount());
                }
                
                if(summary.getEnemiesAddExtraInventory()) {
                    rom.enemiesAddExtraInventory(summary.getEnemiesMaxExtraInventoryCount());
                }
                
                if(summary.getNerfBallistae()) {
                    rom.nerfBallistae();
                }
                
                if(summary.getItemsAddWeaponUses()) {
                    rom.addWeaponUses();
                }
                
                if(summary.getRandomizeItems()) {
                    rom.randomizeItems(
                            summary.getRandomizeItemsMight(), summary.getItemsMightDelta(),
                            summary.getRandomizeItemsAccuracy(), summary.getItemsAccuracyDelta(),
                            summary.getRandomizeItemsWeight(), summary.getItemsWeightDelta(),
                            summary.getRandomizeItemsCritical(), summary.getItemsCriticalDelta(),
                            summary.getRandomizeItemsMaxUses(), summary.getRandomizeItemsCost(),
                            summary.getItemsAddBladeEffect(), summary.getItemsBladeEffectChance(), summary.getItemsAvailableBladeEffects(),
                            summary.getItemsAddStatBonus(), summary.getItemsStatBonusChance(),
                            summary.getItemsAddWeaponSkill(), summary.getItemsWeaponSkillChance(), summary.getItemsAllowMultipleWeaponSkills(),
                            summary.getItemsExcludeIronWeapons());
                }
                
                updateMessage("Writing rom...");
                rom.applyChanges();
                
                if(summary.getLilMansterRenamePugi()) {
                    rom.lilMansterRenamePugi();
                }
                
                if(summary.getProjectExileRenamePugi()) {
                    rom.projectExileRenamePugi();
                }

                try {
                    OutputStream os = new FileOutputStream(romFile);
                    os.write(rom.getBytes());
                    os.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }

                if(summary.getWriteDebugLog()) {
                    updateMessage("Writing log...");
                    
                    input.put("romName", rom.getName());
                    input.put("romHeadered", rom.isHeadered());
                    input.put("romChecksum", Long.toHexString(rom.getCrc32Checksum()));
                    input.put("seed", rom.getSeedAsArray());
                    input.put("summary", summary);
                    //input.put("units", GameCharacter.values());
                    //input.put("classes", CharacterClass.values());
                    input.put("items", Item.values());
                    //input.put("armyData", rom.getArmyUnits());
                    //input.put("chapterData", Chapter.values());

                    try {
                        Writer fileWriter = new FileWriter(new File(romFile.getAbsolutePath().concat(".md")));
                        Template template = cfg.getTemplate("md.ftl");
                        
                        template.process(input, fileWriter);
                        fileWriter.close();
                    } catch(IOException e) {
                        e.printStackTrace();
                    } catch(TemplateException e) {
                        e.printStackTrace();
                    }
                }
                
                return null;
            }
        };
    }
}
