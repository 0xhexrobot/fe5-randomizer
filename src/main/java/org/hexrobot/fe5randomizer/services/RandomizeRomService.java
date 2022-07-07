package org.hexrobot.fe5randomizer.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.hexrobot.fe5randomizer.HexTemplateNumberFormatFactory;
import org.hexrobot.fe5randomizer.RandomizationSummary;
import org.hexrobot.fe5randomizer.Rom;
import org.hexrobot.fe5randomizer.chapters.Chapter;
import org.hexrobot.fe5randomizer.characters.CharacterClass;
import org.hexrobot.fe5randomizer.characters.GameCharacter;
import org.hexrobot.fe5randomizer.characters.PortraitPalette;
import org.hexrobot.fe5randomizer.items.ItemReward;
import org.hexrobot.fe5randomizer.items.Scroll;
import org.hexrobot.fe5randomizer.items.Shop;
import org.hexrobot.fe5randomizer.items.Item;

import freemarker.core.TemplateNumberFormatFactory;
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
        
        cfg = new Configuration(Configuration.VERSION_2_3_29);
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

                // apply balance first

                if(summary.getBalanceRemovePrfLocks()) {
                    rom.removePrfLocks();
                }

                if(summary.getBalanceDowngradeWindTome()) {
                    rom.downgradeWindTome();
                }

                if(summary.getNerfBallistae()) {
                    rom.nerfBallistae();
                }

                if(summary.getBalanceWpnsIncreaseUses()) {
                    rom.addWeaponUses();
                }

                if(summary.getBalanceChangeBraveAxeToBRank()) {
                    rom.changeBraveAxeToBRank();
                }

                if(summary.getBalanceBuffAllyUnits()) {
                    rom.buffAllyUnits();
                }

                if(summary.getRandomizeAllyUnitClasses() || summary.getRandomizeEnemyUnitClasses()
                || summary.getEnemiesAddExtraInventory() || summary.getRandomizeEnemySkills()
                || summary.getBalanceAllyAddExtraInventory()
                || (summary.getRandomizeEnemyMovStars() && summary.getEnemyMovStarsExcludeZero())) {
                    rom.convertCh4AlliesToAllyCharacter();
                }

                // then randomize

                if(summary.getRandomizePlayableUnitClasses()) {
                    updateMessage("Randomize playable unit classes...");
                    rom.randomizePlayableUnitClasses(summary.getExcludeHealers(), summary.getExcludeThieves());
                }

                if(summary.getRandomizeAllyUnitClasses()) {
                    rom.randomizeAllyUnitClasses();
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
                        rom.randomizeUnitsGrowthsRedistribute(summary.getGrowthsRedistributeVar());
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
                    rom.randomizeEnemyLeadershipStars();
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

                if(summary.getBalanceAllyAddExtraInventory()) {
                    rom.alliesAddExtraInventory(summary.getEnemiesMaxExtraInventoryCount());
                }

                if(summary.getRandomizeWpns()) {
                    rom.randomizeWeapons(
                            summary.getRandomizeWpnsMight(), summary.getWpnsMightDelta(),
                            summary.getRandomizeWpnsAccuracy(), summary.getWpnsAccuracyDelta(),
                            summary.getRandomizeWpnsWeight(), summary.getWpnsWeightDelta(),
                            summary.getRandomizeWpnsCritical(), summary.getWpnsCriticalDelta(),
                            summary.getRandomizeWpnsMaxUses(), summary.getRandomizeWpnsCost(),
                            summary.getWpnsAddBladeEffect(), summary.getWpnsBladeEffectChance(), summary.getWpnsAvailableBladeEffects(),
                            summary.getWpnsAddStatBonus(), summary.getWpnsStatBonusChance(),
                            summary.getWpnsAddWeaponSkill(), summary.getWpnsSkillChance(), summary.getWpnsAllowMultipleWeaponSkills(),
                            summary.getWpnsExcludeIronWeapons());
                }
                
                if(summary.getRandomizeScrolls()) {
                    switch(summary.getScrollsRandomizationType()) {
                    case "random":
                        rom.randomizeScrollsRandom();
                        break;
                    case "shuffleAttributes":
                        rom.randomizeScrollsShuffleAttributes();
                        break;
                    case "shuffle":
                        rom.randomizeScrollsShuffle(summary.getScrollsShuffleAttributes());
                        break;
                    }
                }
                
                if(summary.getRandomizeRewards()) {
                    switch(summary.getRewardsRandomizationType()) {
                    case "random":
                        rom.randomizeRewardsChaotic(summary.getRewardsSafeScrolls(), summary.getRewardsSafeKnightProofs());
                        break;
                    case "shuffle":
                        rom.randomizeRewardsShuffle();
                        break;
                    case "replace":
                        rom.randomizeRewardsReplaceSimilar(summary.getRewardsSafeScrolls(), summary.getRewardsSafeKnightProofs());
                        break;
                    }
                }
                
                if(summary.getRandomizeShops()) {
                    switch(summary.getShopsRandomizationType()) {
                    case "random":
                        rom.randomizeShopsChaotic(summary.getShopsMaintainItemCount());
                        break;
                    case "shuffle":
                        rom.randomizeShopsShuffle(summary.getShopsMaintainItemCount());
                        break;
                    case "replace":
                        rom.randomizeShopsReplaceSimilar();
                        break;
                    }
                }

                if(summary.getShufflePalettes()) {
                    rom.shufflePalettes();
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
                
                InputStream is = getClass().getClassLoader().getResourceAsStream("style.css");
                String cssStyle = getFileContent(is);

                input.put("cssStyle", cssStyle);
                input.put("romName", rom.getName());
                input.put("romHeadered", rom.isHeadered());
                input.put("romChecksum", Long.toHexString(rom.getCrc32Checksum()));
                input.put("seed", rom.getSeedAsWeaponArray());
                input.put("summary", summary);
                input.put("units", GameCharacter.values());
                input.put("classes", CharacterClass.values());
                input.put("items", Item.values());
                input.put("scrolls", Scroll.values());
                input.put("eventRewards", ItemReward.getEventRewards());
                input.put("chestRewards", ItemReward.getChestRewards());
                input.put("houseRewards", ItemReward.getHouseRewards());
                input.put("shops", Shop.values());
                input.put("armyData", rom.getArmyUnits());
                input.put("chapterData", Chapter.values());
                input.put("portraitPalettes", PortraitPalette.values());
                
                if(summary.getWriteDebugLog()) {
                    updateMessage("Writing debug log...");
                    
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
                
                if(summary.getWriteLog()) {
                    updateMessage("Writing log...");

                    try {
                        Writer fileWriter = new FileWriter(new File(romFile.getAbsolutePath().concat(".html")));
                        Template template = cfg.getTemplate("html.ftl");
                        
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
    
    private String getFileContent(InputStream is) {
    	String fileContents = "";
    	
        try (InputStreamReader streamReader =
                    new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                fileContents += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return fileContents;
    }
}
