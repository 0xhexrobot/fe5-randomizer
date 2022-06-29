package org.hexrobot.fe5randomizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.zip.CRC32;

import javafx.util.Pair;
import org.hexrobot.fe5randomizer.chapters.Army;
import org.hexrobot.fe5randomizer.chapters.ArmyUnit;
import org.hexrobot.fe5randomizer.chapters.Chapter;
import org.hexrobot.fe5randomizer.characters.*;
import org.hexrobot.fe5randomizer.controllers.MainController;
import org.hexrobot.fe5randomizer.items.ItemReward;
import org.hexrobot.fe5randomizer.items.Scroll;
import org.hexrobot.fe5randomizer.items.Shop;
import org.hexrobot.fe5randomizer.items.Item;
import org.hexrobot.fe5randomizer.items.WeaponBladeEffect;
import org.hexrobot.fe5randomizer.items.WeaponRank;
import org.hexrobot.fe5randomizer.items.WeaponSkill;
import org.hexrobot.fe5randomizer.items.WeaponStatBonus;

import javafx.beans.property.SimpleBooleanProperty;

public class Rom {
    private static final long FE5_HEADERED_CRC32_CHK = 2514651613L;
    private static final long FE5_UNHEADERED_CRC32_CHK = 4233206098L;
    private static final long FE5_REV_1_NP = 3937021011L;
    private static final long FE5_PROJECT_EXILE_1_04 = 402087895L; 
    private static final long FE5_PROJECT_EXILE_1_04_TOP_WAIT = 3995459323L;
    private static final int MIN_FILE_SIZE = 4194304;
    private static final int HEADER_SIZE = 0x200;
    private static final int GAME_TITLE_OFFSET = 0x7FC0;
    private byte[] bytes;
    private byte[] bytesBackup = new byte[0];
    private String name = "Fire Emblem 5 (Unknown)";
    private boolean headered;
    private boolean validFileSize;
    private long crc32Checksum;
    private boolean fireEmblem5;
    private SimpleBooleanProperty lilMansterHack = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty projectExile = new SimpleBooleanProperty(false);
    private Random random;
    private RandomizationLogic logic;
    private ArrayList<ArmyUnit> armyUnits = new ArrayList<ArmyUnit>();
    private PromotionData promotionData;
    private long seed;
    
    public Rom(byte[] bytes) {
        this.bytes = bytes;
        random = new Random(0);

        headered = bytes.length % 1024 == 512;
        validFileSize = bytes.length % 1024 == 0 && bytes.length >= MIN_FILE_SIZE;

        CRC32 crc32 = new CRC32();
        crc32.update(bytes);
        crc32Checksum = crc32.getValue();

        checkFireEmblem5Version();
        logic = new RandomizationLogic(MainController.getInstance().getRandomizeSummary());
    }
    
    private void checkFireEmblem5Version() {
        // known versions
        if(crc32Checksum == FE5_HEADERED_CRC32_CHK || crc32Checksum == FE5_UNHEADERED_CRC32_CHK || crc32Checksum == FE5_REV_1_NP) {
            if(crc32Checksum == FE5_REV_1_NP) {
                name = "Fire Emblem 5 Rev 1 (NP)";
            } else {
                name = "Fire Emblem 5";
            }
            
            fireEmblem5 = true;
        } else if(crc32Checksum == FE5_PROJECT_EXILE_1_04 || crc32Checksum == FE5_PROJECT_EXILE_1_04_TOP_WAIT) {
            fireEmblem5 = true;
            projectExile.set(true);
            
            if(crc32Checksum == FE5_PROJECT_EXILE_1_04) {
                name = "Fire Emblem 5 + Project Exile 1.04";
            } else if(crc32Checksum == FE5_PROJECT_EXILE_1_04_TOP_WAIT) {
                name = "Fire Emblem 5 + Project Exile (Top Wait) 1.04";
            }
        }

        // modified versions
        if(!fireEmblem5) {
            String gameTitle = "";
            int charsToRead = 16;
            
            for(int i = 0; i < charsToRead; i++) {
                char currentChar = (char) getValueAt(GAME_TITLE_OFFSET + i);
                gameTitle += currentChar;
            }
            
            if(gameTitle.contains("FIREEMBLEM5")) {
                fireEmblem5 = true;
            } else if(gameTitle.equals("FE5 Lil' Manster")){
                name = "Fire Emblem 5 + Lil' Manster hack";
                fireEmblem5 = true;
                lilMansterHack.set(true);
            }
        }
    }
    
    public void setRandomSeed(long seed) {
        this.seed = seed;
        random = new Random(seed);
    }

    public int getValueAt(int offset) {
        if(headered) {
            offset += HEADER_SIZE;
        }

        return bytes[offset] & 0xFF;
    }

    public int getValueAt(int offset, int length) {
        if(length != 2) {
            throw new IllegalArgumentException("Only retrieving 2 bytes are supported.");
        }

        if(headered) {
            offset += HEADER_SIZE;
        }

        int value = 0;

        if(length == 2) {
            value = (bytes[offset + 1] & 0xFF) << 8 | (bytes[offset] & 0xFF);
        }

        return value;
    }
    
    public void setValueAt(int offset, int value) {
        if(value > 0xFF) {
            throw new IllegalArgumentException("Value exceeds 1 byte");
        }
        
        if(headered) {
            offset += HEADER_SIZE;
        }

        bytes[offset] = (byte)(value & 0xFF);
    }
    
    public void set2ByteValueAt(int offset, int value) {
        if(value > 0xFFFF) {
            throw new IllegalArgumentException("Value exceeds 2 bytes");
        }

        if(headered) {
            offset += HEADER_SIZE;
        }

        bytes[offset] = (byte) (value & 0xFF);
        bytes[offset + 1] = (byte) ((value >> 8) & 0xFF);
    }

    public boolean isHeadered() {
        return headered;
    }

    public String getName() {
        return name;
    }

    public boolean isFireEmblem5() {
        return fireEmblem5;
    }
    
    public boolean isLilMansterHack() {
        return lilMansterHack.getValue();
    }
    
    public boolean isProjectExileHack() {
        return projectExile.getValue();
    }

    public long getCrc32Checksum() {
        return crc32Checksum;
    }
    
    public int getSize() {
        return bytes.length;
    }
    
    public SimpleBooleanProperty lilMansterHackProperty() {
        return lilMansterHack;
    }
    
    public void initialize() {
        Item.initializeItems(this);
        Scroll.initializeScrolls(this);
        Shop.initializeShops(this);
        CharacterClass.initializeCharacterClasses(this);
        promotionData = new PromotionData(this);
        GameCharacter.initializeCharacters(this);
        initializeArmyData();
        PortraitPalette.readAll(this);
        AutoLevelType.initializeAutoLevelTypes(this);
    }
    
    private void initializeArmyData() {
        Army[] armies = Army.values();
        
        for(int i = 0; i < armies.length; i++) {
            Army army = armies[i];
            ArrayList<ArmyUnit> chapterUnits = new ArrayList<>();
            int separation = army.getSeparation();
            
            for(int j = 0; j < army.getUnitCount(); j++) {
                ArmyUnit armyUnit = new ArmyUnit(this, army.getOffset() + j * separation);
                armyUnits.add(armyUnit);
                chapterUnits.add(armyUnit);
            }
            
            String chName = army.getName().split(" ")[0];
            Chapter chapter = Chapter.findByShortName(chName);
            
            chapter.addArmyData(chapterUnits);
        }
    }
    
    public void randomizeUnitsBasesVariance(int delta) {
        ArrayList<GameCharacter> characters = GameCharacter.getPlayableUnits();
        int baseHp, baseAtk, baseMag, baseSkl, baseSpd, baseLck, baseDef, baseBld, baseMov;
        int newBaseHp, newBaseAtk, newBaseMag, newBaseSkl, newBaseSpd, newBaseLck, newBaseDef, newBaseBld, newBaseMov;
        
        for(GameCharacter character : characters) {
            baseHp = character.getBaseHp();
            baseAtk = character.getBaseAtk();
            baseMag = character.getBaseMag();
            baseSkl = character.getBaseSkl();
            baseSpd = character.getBaseSpd();
            baseLck = character.getBaseLck();
            baseDef = character.getBaseDef();
            baseBld = character.getBaseBld();
            baseMov = character.getBaseMov();
            
            newBaseHp = Math.max(baseHp + random.nextInt(delta * 2 + 1) - delta, 0);
            newBaseAtk = Math.max(baseAtk + random.nextInt(delta * 2 + 1) - delta, 0);
            newBaseMag = Math.max(baseMag + random.nextInt(delta * 2 + 1) - delta, 0);
            newBaseSkl = Math.max(baseSkl + random.nextInt(delta * 2 + 1) - delta, 0);
            newBaseSpd = Math.max(baseSpd + random.nextInt(delta * 2 + 1) - delta, 0);
            newBaseLck = Math.max(baseLck + random.nextInt(delta * 2 + 1) - delta, 0);
            newBaseDef = Math.max(baseDef + random.nextInt(delta * 2 + 1) - delta, 0);
            newBaseBld = Math.max(baseBld + random.nextInt(delta * 2 + 1) - delta, 0);
            newBaseMov = Math.max(baseMov + random.nextInt(delta * 2 + 1) - delta, 0);
            
            character.setBaseHp(newBaseHp);
            character.setBaseAtk(newBaseAtk);
            character.setBaseMag(newBaseMag);
            character.setBaseSkl(newBaseSkl);
            character.setBaseSpd(newBaseSpd);
            character.setBaseLck(newBaseLck);
            character.setBaseDef(newBaseDef);
            character.setBaseBld(newBaseBld);
            character.setBaseMov(newBaseMov);
        }
    }
    
    public void randomizeUnitsBasesRedistribute(int variance) {
        ArrayList<GameCharacter> characters = GameCharacter.getPlayableUnits();
        final int MAX_BASES = 20;
        
        for(GameCharacter character : characters) {
            int totalBases = 0;
            int baseHp = 0, baseAtk = 0, baseMag = 0, baseSkl = 0, baseSpd = 0, baseLck = 0, baseDef = 0, baseBld = 0, baseMov = 0;
            float hpWeight, atkWeight, magWeight, sklWeight, spdWeight, lckWeight, defWeight, bldWeight, movWeight;
            WeightedList<String> statWeights = new WeightedList<>();
            
            hpWeight = random.nextFloat() * 2.0f;
            atkWeight = random.nextFloat();
            magWeight = random.nextFloat();
            sklWeight = random.nextFloat();
            spdWeight = random.nextFloat();
            lckWeight = random.nextFloat();
            defWeight = random.nextFloat();
            bldWeight = random.nextFloat() * 0.5f;
            movWeight = random.nextFloat() * 0.25f;
            
            statWeights.add("hp", hpWeight);
            statWeights.add("atk", atkWeight);
            statWeights.add("mag", magWeight);
            statWeights.add("skl", sklWeight);
            statWeights.add("spd", spdWeight);
            statWeights.add("lck", lckWeight);
            statWeights.add("def", defWeight);
            statWeights.add("bld", bldWeight);
            statWeights.add("mov", movWeight);
            
            totalBases += character.getBaseHp();
            totalBases += character.getBaseAtk();
            totalBases += character.getBaseMag();
            totalBases += character.getBaseSkl();
            totalBases += character.getBaseSpd();
            totalBases += character.getBaseLck();
            totalBases += character.getBaseDef();
            totalBases += character.getBaseBld();
            totalBases += character.getBaseMov();
            
            totalBases += random.nextInt(variance * 2 + 1) - variance;

            for(int i = 0; i < totalBases; i++) {
                String stat = statWeights.getSelection(random.nextFloat());
                
                switch(stat) {
                case "hp":
                    baseHp++;
                    
                    if(baseHp == MAX_BASES) {
                        statWeights.remove("hp");
                    }
                    break;
                case "atk":
                    baseAtk++;
                    
                    if(baseAtk == MAX_BASES) {
                        statWeights.remove("atk");
                    }
                    break;
                case "mag":
                    baseMag++;
                    
                    if(baseMag == MAX_BASES) {
                        statWeights.remove("mag");
                    }
                    break;
                case "skl":
                    baseSkl++;
                    
                    if(baseSkl == MAX_BASES) {
                        statWeights.remove("skl");
                    }
                    break;
                case "spd":
                    baseSpd++;
                    
                    if(baseSpd == MAX_BASES) {
                        statWeights.remove("spd");
                    }
                    break;
                case "lck":
                    baseLck++;
                    
                    if(baseLck == MAX_BASES) {
                        statWeights.remove("lck");
                    }
                    break;
                case "def":
                    baseDef++;
                    
                    if(baseDef == MAX_BASES) {
                        statWeights.remove("def");
                    }
                    break;
                case "bld":
                    baseBld++;
                    
                    if(baseBld == MAX_BASES) {
                        statWeights.remove("bld");
                    }
                    break;
                case "mov":
                    baseMov++;
                    
                    if(baseMov == MAX_BASES) {
                        statWeights.remove("mov");
                    }
                    break;
                }
            }
                        
            character.setBaseHp(baseHp);
            character.setBaseAtk(baseAtk);
            character.setBaseMag(baseMag);
            character.setBaseSkl(baseSkl);
            character.setBaseSpd(baseSpd);
            character.setBaseLck(baseLck);
            character.setBaseDef(baseDef);
            character.setBaseBld(baseBld);
            character.setBaseMov(baseMov);
        }
    }
    
    public void randomizeUnitsGrowthsVariance(int delta) {
        ArrayList<GameCharacter> characters = GameCharacter.getPlayableUnits();
        int deltaPoints = delta / 5;
        
        for(GameCharacter character : characters) {
            int hpGrowth, atkGrowth, magGrowth, sklGrowth, spdGrowth, lckGrowth, defGrowth, bldGrowth, movGrowth;
            int newHpGrowth, newAtkGrowth, newMagGrowth, newSklGrowth, newSpdGrowth, newLckGrowth, newDefGrowth, newBldGrowth, newMovGrowth;
            
            hpGrowth = character.getHpGrowth();
            atkGrowth = character.getAtkGrowth();
            magGrowth = character.getMagGrowth();
            sklGrowth = character.getSklGrowth();
            spdGrowth = character.getSpdGrowth();
            lckGrowth = character.getLckGrowth();
            defGrowth = character.getDefGrowth();
            bldGrowth = character.getBldGrowth();
            movGrowth = character.getMovGrowth();
            
            newHpGrowth = Math.max(hpGrowth / 5 + random.nextInt(deltaPoints * 2 + 1) - deltaPoints, 0) * 5;
            newAtkGrowth = Math.max(atkGrowth / 5 + random.nextInt(deltaPoints * 2 + 1) - deltaPoints, 0) * 5;
            newMagGrowth = Math.max(magGrowth / 5 + random.nextInt(deltaPoints * 2 + 1) - deltaPoints, 0) * 5;
            newSklGrowth = Math.max(sklGrowth / 5 + random.nextInt(deltaPoints * 2 + 1) - deltaPoints, 0) * 5;
            newSpdGrowth = Math.max(spdGrowth / 5 + random.nextInt(deltaPoints * 2 + 1) - deltaPoints, 0) * 5;
            newLckGrowth = Math.max(lckGrowth / 5 + random.nextInt(deltaPoints * 2 + 1) - deltaPoints, 0) * 5;
            newDefGrowth = Math.max(defGrowth / 5 + random.nextInt(deltaPoints * 2 + 1) - deltaPoints, 0) * 5;
            newBldGrowth = Math.max(bldGrowth / 5 + random.nextInt(deltaPoints * 2 + 1) - deltaPoints, 0) * 5;
            newMovGrowth = Math.max(movGrowth / 5 + random.nextInt(deltaPoints * 2 + 1) - deltaPoints, 0) * 5;
            
            character.setHpGrowth(newHpGrowth);
            character.setAtkGrowth(newAtkGrowth);
            character.setMagGrowth(newMagGrowth);
            character.setSklGrowth(newSklGrowth);
            character.setSpdGrowth(newSpdGrowth);
            character.setLckGrowth(newLckGrowth);
            character.setDefGrowth(newDefGrowth);
            character.setBldGrowth(newBldGrowth);
            character.setMovGrowth(newMovGrowth);
        }
    }
    
    public void randomizeUnitsGrowthsRedistribute(int variance) {
        ArrayList<GameCharacter> characters = GameCharacter.getPlayableUnits();
        final int STAT_COUNT = 9;
        
        for(GameCharacter character : characters) {
            int hpGrowth = 5, atkGrowth = 5, magGrowth = 5, sklGrowth = 5, spdGrowth = 5, lckGrowth = 5, defGrowth = 5, bldGrowth = 5, movGrowth = 5;
            int originalGrowths;
            float hpWeight = random.nextFloat() * 2.0f;
            float atkWeight = random.nextFloat();
            float magWeight = random.nextFloat();
            float sklWeight = random.nextFloat();
            float spdWeight = random.nextFloat();
            float lckWeight = random.nextFloat();
            float defWeight = random.nextFloat();
            float bldWeight = random.nextFloat() * 0.5f;
            float movWeight = random.nextFloat() * 0.25f;
            WeightedList<String> statWeights = new WeightedList<>();
            int growthPoints;
            int variancePoints = variance / 5;
            
            statWeights.add("hp", hpWeight);
            statWeights.add("atk", atkWeight);
            statWeights.add("mag", magWeight);
            statWeights.add("skl", sklWeight);
            statWeights.add("spd", spdWeight);
            statWeights.add("lck", lckWeight);
            statWeights.add("def", defWeight);
            statWeights.add("bld", bldWeight);
            statWeights.add("mov", movWeight);
            
            originalGrowths = character.getHpGrowth();
            originalGrowths += character.getAtkGrowth();
            originalGrowths += character.getMagGrowth();
            originalGrowths += character.getSklGrowth();
            originalGrowths += character.getSpdGrowth();
            originalGrowths += character.getLckGrowth();
            originalGrowths += character.getDefGrowth();
            originalGrowths += character.getBldGrowth();
            originalGrowths += character.getMovGrowth();
            
            growthPoints = originalGrowths / 5 - STAT_COUNT;
            growthPoints += random.nextInt(variancePoints * 2 + 1) - variancePoints;
            
            for(int i = 0; i < growthPoints; i++) {
                String stat = statWeights.getSelection(random.nextFloat());
                
                switch(stat) {
                case "hp":
                    hpGrowth += 5;
                    break;
                case "atk":
                    atkGrowth += 5;
                    break;
                case "mag":
                    magGrowth += 5;
                    break;
                case "skl":
                    sklGrowth += 5;
                    break;
                case "spd":
                    spdGrowth += 5;
                    break;
                case "lck":
                    lckGrowth += 5;
                    break;
                case "def":
                    defGrowth += 5;
                    break;
                case "bld":
                    bldGrowth += 5;
                    break;
                case "mov":
                    movGrowth += 5;
                    break;
                }
            }
            
            character.setHpGrowth(hpGrowth);
            character.setAtkGrowth(atkGrowth);
            character.setMagGrowth(magGrowth);
            character.setSklGrowth(sklGrowth);
            character.setSpdGrowth(spdGrowth);
            character.setLckGrowth(lckGrowth);
            character.setDefGrowth(defGrowth);
            character.setBldGrowth(bldGrowth);
            character.setMovGrowth(movGrowth);
        }
    }
    
    public void randomizeUnitsGrowthsAbsolute(int min, int max) {
        ArrayList<GameCharacter> characters = GameCharacter.getPlayableUnits();
        int newHpGrowth, newAtkGrowth, newMagGrowth, newSklGrowth, newSpdGrowth, newLckGrowth, newDefGrowth, newBldGrowth, newMovGrowth;
        int minPoints = min / 5;
        int maxPoints = max / 5;
        int maxDiff = maxPoints - minPoints;
        
        for(GameCharacter character : characters) {
            newHpGrowth = (minPoints + random.nextInt(maxDiff) + 1) * 5;
            newAtkGrowth = (minPoints + random.nextInt(maxDiff) + 1) * 5;
            newMagGrowth = (minPoints + random.nextInt(maxDiff) + 1) * 5;
            newSklGrowth = (minPoints + random.nextInt(maxDiff) + 1) * 5;
            newSpdGrowth = (minPoints + random.nextInt(maxDiff) + 1) * 5;
            newLckGrowth = (minPoints + random.nextInt(maxDiff) + 1) * 5;
            newDefGrowth = (minPoints + random.nextInt(maxDiff) + 1) * 5;
            newBldGrowth = (minPoints + random.nextInt(maxDiff) + 1) * 5;
            newMovGrowth = (minPoints + random.nextInt(maxDiff) + 1) * 5;
            
            character.setHpGrowth(newHpGrowth);
            character.setAtkGrowth(newAtkGrowth);
            character.setMagGrowth(newMagGrowth);
            character.setSklGrowth(newSklGrowth);
            character.setSpdGrowth(newSpdGrowth);
            character.setLckGrowth(newLckGrowth);
            character.setDefGrowth(newDefGrowth);
            character.setBldGrowth(newBldGrowth);
            character.setMovGrowth(newMovGrowth);
        }
    }
    
    public void randomizePlayableUnitClasses(boolean excludeHealers, boolean excludeThieves) {
        ArrayList<GameCharacter> characters = GameCharacter.getPlayableUnits();
        ArrayList<CharacterClass> bannedClasses = new ArrayList<>();
        
        if(excludeHealers) {
            characters.removeIf(unit -> unit.getCharacterClass().isHealer());
            bannedClasses.addAll(CharacterClass.getHealerClasses());
        }
        
        if(excludeThieves) {
            characters.removeIf(unit -> unit.getCharacterClass().isThief());
            bannedClasses.addAll(CharacterClass.getThiefClasses());
        }

        assignNewClasses(characters, bannedClasses);

        updateEyvelCh5Weapon();
        
        promotionData.updatePromotions();
    }

    public void updateEyvelCh5Weapon() {
        final int CH5_EYVEL_ITEM_OFFSET = 0xCA204;
        if(GameCharacter.EYVEL.getOldValues().containsKey("characterClass")) {
            ArmyUnit eyvelUnit = Chapter.CHAPTER_1.getArmyData().get(21);
            Item selectedItem = getSelectedItem(eyvelUnit, new ArrayList<>(1));

            setValueAt(CH5_EYVEL_ITEM_OFFSET, selectedItem.getOffset() + 1);
            System.out.println("Ch5 Eyvel item: " + selectedItem.getName());
        }
    }
    
    public void randomizeEnemyUnitClasses(boolean excludeBosses) {
        ArrayList<GameCharacter> characters = GameCharacter.getEnemyUnits();
        
        characters.removeAll(GameCharacter.getBallistaeUnits());
        
        if(excludeBosses) {
            characters.removeAll(GameCharacter.getBossUnits());
        }

        assignNewClasses(characters, List.of());
    }
    
    private void assignNewClasses(ArrayList<GameCharacter> characters, List<CharacterClass> bannedClasses) {
        ArrayList<CharacterClass> unpromotedClasses = CharacterClass.getUnpromotedClasses();
        ArrayList<CharacterClass> promotedClasses = CharacterClass.getPromotedClasses();
        
        unpromotedClasses.removeIf(chClass -> bannedClasses.contains(chClass));
        promotedClasses.removeIf(chClass -> bannedClasses.contains(chClass));
        
        for(GameCharacter character : characters) {
            CharacterClass characterClass = character.getCharacterClass();
            CharacterClass newCharacterClass = characterClass;
            
            if(characterClass.isPromoted()) {
                newCharacterClass = getSelectedClass(character, promotedClasses);
            } else if(characterClass.isUnpromoted()) {
                newCharacterClass = getSelectedClass(character, unpromotedClasses);
            }
            
            character.setCharacterClass(newCharacterClass, random);

            if(character.hasRandomBases()) {
                character.setPortrait(CharacterClass.getGenericPortrait(newCharacterClass));
                assignAutoLevelType(character, newCharacterClass, random);
            }
        }
        
        assignUnitInventories(characters);
    }

    private void assignAutoLevelType(GameCharacter character, CharacterClass newClass, Random random) {
        List<Pair<AutoLevelType, Float>> autoLevelOptions = AutoLevelType.getClassToAutoLevelType(newClass);
        int newBaseHp = 0;

        if(autoLevelOptions.size() == 1) {
            newBaseHp = autoLevelOptions.get(0).getKey().getOffset();
        } else if(autoLevelOptions.size() > 1) {
            WeightedList<AutoLevelType> options = new WeightedList<>();

            for (Pair<AutoLevelType, Float> autoLevelOption: autoLevelOptions) {
                options.add(autoLevelOption.getKey(), autoLevelOption.getValue());
            }

            newBaseHp = options.getSelection(random.nextFloat()).getOffset();
        }

        character.setBaseHp(newBaseHp);
    }
    
    private void assignUnitInventories(ArrayList<GameCharacter> characters) {
        ArrayList<ArmyUnit> unitsToModify = new ArrayList<>(armyUnits);
        unitsToModify.removeIf(unit -> !characters.contains(unit.getCharacter()));
        
        for(ArmyUnit armyUnit : unitsToModify) {
            ArrayList<Item> inventory = armyUnit.getInventory();
            
            for(int i = 0; i < inventory.size(); i++) {
                Item item = inventory.get(i);
                
                if(item.isItem() || armyUnit.canUseWeapon(item)) {
                    continue;
                }
                
                inventory.set(i, getSelectedItem(armyUnit, inventory));
            }
            
            armyUnit.setInventory(inventory);
        }
    }
    
    private Item getSelectedItem(ArmyUnit unit, ArrayList<Item> inventory) {
        Item selectedItem = Item.BROKEN_SWORD;
        WeightedList<Item> itemWeights = new WeightedList<>();
        ArrayList<Item> items = Item.getItems(true, false);
        
        for(Item item : items) {
            float weight = logic.assignItemWeight(unit, item, inventory);
            itemWeights.add(item, weight);
        }
        
        selectedItem = itemWeights.getSelection(random.nextFloat());
        
        return selectedItem;
    }
    
    private CharacterClass getSelectedClass(GameCharacter character, ArrayList<CharacterClass> classesList) {
        CharacterClass selectedClass = character.getCharacterClass();
        WeightedList<CharacterClass> classWeights = new WeightedList<>();
        
        for(CharacterClass characterClass : classesList) {
            float weight = logic.assignClassWeight(character, characterClass);
            
            if(weight > 0) {
                classWeights.add(characterClass, weight);
            }
        }
        
        selectedClass = classWeights.getSelection(random.nextFloat());
        
        return selectedClass;
    }
    
    public void enemiesAddExtraInventory(int maxExtraItems) {
        ArrayList<ArmyUnit> enemies = new ArrayList<>(armyUnits);
        enemies.removeIf(unit -> !unit.getCharacter().isEnemyUnit() || unit.getCharacter().isBallistaUnit());
        
        for(ArmyUnit unit : enemies) {
            ArrayList<Item> inventory = unit.getInventory();
            maxExtraItems = Math.min(maxExtraItems, 7 - inventory.size());
            int itemsToAdd = random.nextInt(maxExtraItems + 1);
            int itemsAdded = 0;
            
            while(itemsAdded < itemsToAdd) {
                Item item = getSelectedItem(unit, inventory);
                inventory.add(item);
                itemsAdded++;
            }

            unit.setInventory(inventory);
        }
    }
    
    public void randomizeMoveStars(boolean excludeZeroStars) {
        ArrayList<GameCharacter> playableCharacters = GameCharacter.getPlayableUnits();
        
        if(excludeZeroStars) {
            playableCharacters.removeIf(unit -> unit.getMovementStars().getAmount() == 0);
        }
        
        assignMoveStars(playableCharacters);
    }
    
    public void randomizeEnemyMoveStars(boolean excludeZeroStars) {
        ArrayList<GameCharacter> enemyCharacters = GameCharacter.getEnemyUnits();

        if(excludeZeroStars) {
            enemyCharacters.removeIf(unit -> unit.getMovementStars().getAmount() == 0);
        }

        assignMoveStars(enemyCharacters);
    }
    
    private void assignMoveStars(ArrayList<GameCharacter> characters) {
        WeightedList<Integer> starWeights = new WeightedList<>();
        int cap = 5;

        for(int i = 0; i < cap + 1; i++) {
            float weight = 1 / (float)Math.pow(1.8f, i);
            starWeights.add(i, weight);
        }

        for(GameCharacter character : characters) {
            int selectedAmount = starWeights.getSelection(random.nextFloat());
            character.setMovementStars(MovementStars.findByAmount(selectedAmount));
        }
    }
    
    public void randomizeLeadershipStars(boolean excludeZeroStars) {
        ArrayList<GameCharacter> playableCharacters = GameCharacter.getPlayableUnits();
        
        if(excludeZeroStars) {
            playableCharacters.removeIf(unit -> unit.getLeadershipStars() == 0);
        }

        assignLeadershipStars(playableCharacters, false);
    }
    
    public void randomizeEnemyLeadershipStars(boolean excludeZeroStars) {
        ArrayList<GameCharacter> enemyCharacters = GameCharacter.getEnemyUnits();

        if(excludeZeroStars) {
            enemyCharacters.removeIf(unit -> unit.getLeadershipStars() == 0);
        }

        assignLeadershipStars(enemyCharacters, true);
    }
    
    private void assignLeadershipStars(ArrayList<GameCharacter> characters, boolean capAt10) {
        int cap = 5;
        
        if(capAt10) {
            cap = 10;
        }
        
        WeightedList<Integer> starWeights = new WeightedList<>();

        for(int i = 0; i < cap + 1; i++) {
            float weight;
            
            if(capAt10) {
                weight = 1 / (float)Math.pow(1.5f, i);
            } else {
                weight = 1 / (float)Math.pow(1.8f, i);
            }
            
            starWeights.add(i, weight);
        }
        
        for(GameCharacter character : characters) {
            int selectedAmount = starWeights.getSelection(random.nextFloat());
            character.setLeadershipStars(selectedAmount);
        }
    }
    
    public void randomizeSkills(int maxSkillCount) {
        ArrayList<GameCharacter> characters = GameCharacter.getPlayableUnits();
        
        for(GameCharacter character : characters) {
            ArrayList<Skill> skills = character.getSkills();
            ArrayList<Skill> availableSkills = Skill.getRandomizableSkills();
            int newSkillCount = random.nextInt(maxSkillCount + 1);
            
            skills.removeIf(skill -> skill.isRandomizableSkill());
            
            for(int i = 0; i < newSkillCount; i++) {
                Skill skill = availableSkills.get(random.nextInt(availableSkills.size()));
                
                availableSkills.remove(skill);
                skills.add(skill);
            }
            
            character.setSkills(skills);
        }
    }
    
    public void randomizeEnemySkills(boolean randomizeBossSkills, int maxBossSkillCount, boolean randomizeEnemySkills, int maxEnemySkillCount) {
        ArrayList<GameCharacter> characters = GameCharacter.getEnemyUnits();
        
        for(GameCharacter character : characters) {
            if(!randomizeBossSkills && character.isBoss()) {
                continue;
            }
            
            if(!randomizeEnemySkills && !character.isBoss()) {
                continue;
            }
            
            ArrayList<Skill> skills = character.getSkills();
            ArrayList<Skill> availableSkills = Skill.getRandomizableSkills();
            int maxSkillCount;
            
            if(character.isBoss()) {
                maxSkillCount = maxBossSkillCount;
            } else {
                maxSkillCount = maxEnemySkillCount;
            }
            
            int newSkillCount = random.nextInt(maxSkillCount + 1);
            
            skills.removeIf(skill -> skill.isRandomizableSkill());
            
            for(int i = 0; i < newSkillCount; i++) {
                Skill skill = availableSkills.get(random.nextInt(availableSkills.size()));
                
                availableSkills.remove(skill);
                skills.add(skill);
            }
            
            character.setSkills(skills);
        }
    }

    public void randomizeWeapons(boolean randomizeMight, int mightDelta, boolean randomizeAccuracy, int accuracyDelta, boolean randomizeWeight, int weightDelta, boolean randomizeCritical, int criticalDelta,
            boolean randomizeMaxUses, boolean randomizeCost, boolean addBladeEffect, int bladeEffectChance, int availableBladeEffects, boolean addStatBonus, int statBonusChance, boolean addWeaponSkill, int weaponSkillChance, boolean allowMultipleWeaponSkills, boolean excludeIronWeapons) {
        ArrayList<Item> weapons = Item.getWeapons(true);
        WeightedList<Integer> maxUsesList = new WeightedList<>();
        WeightedList<Integer> costPerUseList = new WeightedList<>();
        ArrayList<WeaponStatBonus> wpnStatBonuses = WeaponStatBonus.getPlus5();
        ArrayList<WeaponBladeEffect> bladeEffects = WeaponBladeEffect.intToWeaponBladeEffect(availableBladeEffects);
        ArrayList<WeaponSkill> weaponSkills = WeaponSkill.getRandomizableSkills();
        
        maxUsesList.add(5, 1.0f);
        maxUsesList.add(10, 2.0f);
        maxUsesList.add(20, 10.0f);
        maxUsesList.add(30, 18.0f);
        maxUsesList.add(40, 8.0f);
        maxUsesList.add(60, 2.0f);
        
        costPerUseList.add(20, 2.0f);
        costPerUseList.add(30, 4.0f);
        costPerUseList.add(40, 8.0f);
        costPerUseList.add(50, 12.0f);
        costPerUseList.add(60, 20.0f);
        costPerUseList.add(90, 16.0f);
        costPerUseList.add(100, 14.0f);
        costPerUseList.add(140, 10.0f);
        costPerUseList.add(150, 7.0f);
        costPerUseList.add(200, 4.0f);
        costPerUseList.add(300, 3.0f);
        costPerUseList.add(400, 2.0f);
        costPerUseList.add(500, 1.0f);
        
        for(Item weapon : weapons) {
            if(excludeIronWeapons) {
                if(weapon.equals(Item.IRON_SWORD) || weapon.equals(Item.IRON_LANCE) || weapon.equals(Item.IRON_AXE)
                        || weapon.equals(Item.IRON_BOW)) {
                    continue;
                }
            }
            
            if(randomizeCost) {
                int weaponCost = weapon.getCostPerUse();
                
                if(weaponCost > 0) {
                    int newCost = costPerUseList.getSelection(random.nextFloat());
                    weapon.setCostPerUse(newCost);
                }
            }
                        
            if(weapon.isStaff()) {
                continue;
            }
            
            if(randomizeMight) {
            	if(weapon.getPower() == 255) {
            		return;
            	}
            	
                int newMight = Math.max(weapon.getPower() - mightDelta + random.nextInt(mightDelta * 2 + 1), 0);
                weapon.setPower(newMight);
            }
            
            if(randomizeAccuracy) {
                int accuracyPoints = accuracyDelta / 5;
                int diffAccuracy = random.nextInt(accuracyPoints * 2 + 1) - accuracyPoints;
                int newAccuracy = Math.max(weapon.getAccuracy() + diffAccuracy * 5, 30);
                weapon.setAccuracy(newAccuracy);
            }
            
            if(randomizeWeight) {
                int newWeight = Math.max(weapon.getWeight() - weightDelta + random.nextInt(weightDelta * 2 + 1), 0);
                newWeight = Math.min(newWeight, 20);
                weapon.setWeight(newWeight);
            }
            
            if(randomizeCritical) {
                int criticalPoints = criticalDelta / 5;
                int diffCritical = random.nextInt(criticalPoints * 2 + 1) - criticalPoints;
                int newCritical = Math.max(weapon.getCritical() + diffCritical * 5, 0);
                weapon.setCritical(newCritical);
            }

            if(randomizeMaxUses) {
                int newMaxUses = maxUsesList.getSelection(random.nextFloat());
                weapon.setMaxUses(newMaxUses);
            }

            if(addBladeEffect) {
                if(bladeEffects.size() > 0 && weapon.getWeaponBladeEffect().equals(WeaponBladeEffect.NOTHING)) {
                    if(random.nextFloat() < bladeEffectChance / 100.0f) {
                        WeaponBladeEffect newBladeEffect = bladeEffects.get(random.nextInt(bladeEffects.size()));
                        weapon.setWeaponBladeEffect(newBladeEffect);
                    }
                }
            }

            if(addStatBonus) {
                WeaponStatBonus statBonus = weapon.getWeaponStatBonus();
                
                if(statBonus.equals(WeaponStatBonus.NONE) || statBonus.equals(WeaponStatBonus.NONE2)) {
                    if(random.nextFloat() < statBonusChance / 100.0f) {
                        WeaponStatBonus newWpnStatBonus = wpnStatBonuses.get(random.nextInt(wpnStatBonuses.size()));
                        weapon.setWeaponStatBonus(newWpnStatBonus);
                    }
                }
            }
            
            if(addWeaponSkill) {
                ArrayList<WeaponSkill> skills = weapon.getSkills();
                
                if(allowMultipleWeaponSkills) {
                    boolean addedSkill;
                    ArrayList<WeaponSkill> availableWpnSkills = new ArrayList<WeaponSkill>(weaponSkills);
                    availableWpnSkills.removeAll(skills);
                    
                    do {
                        float wpnSkillChance = weaponSkillChance / ((float)Math.pow(2, skills.size()) * 100.0f);
                        
                        addedSkill = availableWpnSkills.size() > 0 && random.nextFloat() < wpnSkillChance;
                        
                        if(addedSkill) {
                            WeaponSkill newWeaponSkill = availableWpnSkills.get(random.nextInt(availableWpnSkills.size()));
                            skills.add(newWeaponSkill);
                            availableWpnSkills.remove(newWeaponSkill);
                        }
                    } while(addedSkill);
                } else {
                    if(skills.isEmpty() && random.nextFloat() < weaponSkillChance / 100.0f) {
                        WeaponSkill newWeaponSkill = weaponSkills.get(random.nextInt(weaponSkills.size()));
                        skills.add(newWeaponSkill);
                    }
                }
                
                weapon.setSkills(skills);
            }
        }
    }

    public void randomizeRewardsChaotic(boolean safeScrolls, boolean safeKnightProofs) {
        ArrayList<Item> availableItems = Item.getItems(true, true);
        List<ItemReward> excludedRewards = ItemReward.getExcludedRewards();
        List<Item> safeItems = new ArrayList<Item>();
        int possibleSafeItems = ItemReward.values().length - excludedRewards.size();
        
        if(safeScrolls) {
            List<Item> scrolls = Item.getScrolls();
            availableItems.removeAll(scrolls);
            // remove scrolls in characters inventory
            scrolls.removeAll(List.of(
                    Item.HEZUL_SCROLL, Item.DAIN_SCROLL, Item.BLAGI_SCROLL, Item.TORDO_SCROLL));
            safeItems.addAll(scrolls);
        }
        
        if(safeKnightProofs) {
            safeItems.addAll(Collections.nCopies(11, Item.KNIGHT_PROOF));
            availableItems.remove(Item.KNIGHT_PROOF);
        }
        
        Collections.shuffle(safeItems, random);
        
        for(ItemReward reward : ItemReward.values()) {
            if(excludedRewards.contains(reward)) {
                continue;
            }
            
            if(safeItems.size() > 0) {
                float safeItemChance = safeItems.size() / (float)possibleSafeItems;
                possibleSafeItems--;
                
                if(random.nextFloat() < safeItemChance) {
                    reward.setItem(safeItems.remove(0));
                    continue;
                }
            }
            
            Item selectedItem = availableItems.get(random.nextInt(availableItems.size()));
            reward.setItem(selectedItem);
        }
    }

    public void randomizeRewardsShuffle() {
        List<Item> allRewards = new ArrayList<>();
        List<ItemReward> excludedRewards = ItemReward.getExcludedRewards();
        
        for(ItemReward reward : ItemReward.values()) {
            if(excludedRewards.contains(reward)) {
                continue;
            }
            
            allRewards.add(reward.getItem());
        }
        
        Collections.shuffle(allRewards, random);
        
        for(ItemReward reward : ItemReward.values()) {
            if(excludedRewards.contains(reward)) {
                continue;
            }
            
            reward.setItem(allRewards.remove(0));
        }
    }
    
    public void randomizeRewardsReplaceSimilar(boolean safeScrolls, boolean safeKnightProofs) {
        List<Item> availableScrolls = Item.getScrolls();
        List<ItemReward> excludedRewards = ItemReward.getExcludedRewards();
        int remainingKnightProofs = 11;
        int possibleKnightProofs = 39;
        
        if(safeScrolls) {
            // remove scrolls in characters inventory
            availableScrolls.removeAll(List.of(
                    Item.HEZUL_SCROLL, Item.DAIN_SCROLL, Item.BLAGI_SCROLL, Item.TORDO_SCROLL));
            Collections.shuffle(availableScrolls, random);
        }
                
        for(ItemReward reward : ItemReward.values()) {
            if(excludedRewards.contains(reward)) {
                continue;
            }
            
            Item rewardItem = reward.getItem();
            
            if(safeScrolls && rewardItem.isScroll()) {
                reward.setItem(availableScrolls.remove(0));
                continue;
            }
            
            List<Item> similarItems = Item.getSimilarItemList(reward.getItem());
            
            if(safeKnightProofs && remainingKnightProofs > 0 && similarItems.contains(Item.KNIGHT_PROOF)) {
                float knightProofChance = remainingKnightProofs / (float)possibleKnightProofs;
                possibleKnightProofs--;
                
                if(random.nextFloat() < knightProofChance) {
                    reward.setItem(Item.KNIGHT_PROOF);
                    remainingKnightProofs--;
                    continue;
                } else {
                    similarItems.remove(Item.KNIGHT_PROOF);
                }
            }
            
            Item newItem = similarItems.get(random.nextInt(similarItems.size()));
            reward.setItem(newItem);
        }
    }
    
    public void randomizeShopsChaotic(boolean maintainItemCount) {
        List<Item> availableItems = Item.getItemsForShops();
        List<Shop> excludedShops = new ArrayList<>(List.of(Shop.BATTLE_PREPS, Shop.CH24_SECRET));
        
        for(Shop shop: Shop.values()) {
            if(excludedShops.contains(shop)) {
                continue;
            }
            
            int newItemCount;
            List<Item> newItems = new ArrayList<>();
            
            if(maintainItemCount) {
                newItemCount = shop.getItems().size();
            } else {
                newItemCount = 1 + random.nextInt(5);
            }
            
            for(int i = 0; i < newItemCount; i++) {
                Item newItem;

                do {
                    // force distinct items
                    newItem = availableItems.get(random.nextInt(availableItems.size()));
                } while(newItems.contains(newItem));
                
                newItems.add(newItem);
            }
            
            shop.setItems(newItems);
        }
        
        setCostForPrfweapons();
    }
    
    public void randomizeShopsShuffle(boolean maintainItemCount) {
        List<Shop> excludedShops = new ArrayList<>(List.of(Shop.BATTLE_PREPS, Shop.CH24_SECRET));
        List<Item> allShopItems = new ArrayList<>();
        List<Integer> shopItemCounts = new ArrayList<>();
        List<Shop> shopsDuplicatedItems = new ArrayList<>();
        
        for(Shop shop : Shop.values()) {
            if(excludedShops.contains(shop)) {
                continue;
            }
            
            allShopItems.addAll(shop.getItems());
            shopItemCounts.add(shop.getItems().size());
        }
        
        Collections.shuffle(allShopItems, random);
        Collections.shuffle(shopItemCounts, random);
        
        for(Shop shop : Shop.values()) {
            if(excludedShops.contains(shop)) {
                continue;
            }
            
            List<Item> newShopItems = new ArrayList<>();
            int newItemCount = shop.getItems().size();
            
            if(!maintainItemCount) {
                newItemCount = shopItemCounts.remove(0);
            }
            
            // assign shop items
            for(int i = 0; i < newItemCount; i++) {
                Item newItem = allShopItems.remove(0);
                boolean duplicatedItem = newShopItems.contains(newItem);
                
                if(duplicatedItem &&  !shopsDuplicatedItems.contains(shop)) {
                    shopsDuplicatedItems.add(shop);
                }
                                
                newShopItems.add(newItem);
            }
            
            shop.setItems(newShopItems);
        }
        
        // deal with duplicates
        while(!shopsDuplicatedItems.isEmpty()) {
            Shop shop = shopsDuplicatedItems.remove(0);
            List<Item> shopItems = shop.getItems();
            List<Item> duplicatedItems = new ArrayList<>();
            List<Shop> otherShops = new ArrayList<>(Arrays.asList(Shop.values()));
            otherShops.removeAll(excludedShops);
            
            Collections.shuffle(otherShops, random);
            Iterator<Item> shopItemsIterator = shopItems.iterator();
            
            // remove shop duplicate items
            while(shopItemsIterator.hasNext()) {
                Item item = shopItemsIterator.next();
                
                if(Collections.frequency(shopItems, item) > 1) {
                    duplicatedItems.add(item);
                    shopItemsIterator.remove();
                }
            }
            
            // exchange duplicated items with other shops
            while(!duplicatedItems.isEmpty()) {
                Item duplicatedItem = duplicatedItems.remove(0);
                
                for(Shop otherShop : otherShops) {
                    if(duplicatedItem == null) {
                        break;
                    }
                    
                    List<Item> otherShopItems = otherShop.getItems();
                    
                    if(!otherShopItems.contains(duplicatedItem)) {
                        for(Item otherItem : otherShopItems) {
                            if(!shopItems.contains(otherItem)) {
                                // exchange items
                                shopItems.add(otherItem);
                                otherShopItems.remove(otherItem);
                                otherShopItems.add(duplicatedItem);
                                otherShop.setItems(otherShopItems);
                                duplicatedItem = null;
                                
                                break;
                            }
                        }
                    }
                }
            }
            
            shop.setItems(shopItems);
        }
    }
    
    public void randomizeShopsReplaceSimilar() {
        List<Shop> excludedShops = new ArrayList<>(List.of(Shop.BATTLE_PREPS, Shop.CH24_SECRET));
        
        for(Shop shop: Shop.values()) {
            if(excludedShops.contains(shop)) {
                continue;
            }
            
            List<Item> shopItems = shop.getItems();
            List<Item> newItems = new ArrayList<>();
            
            for(Item item : shopItems) {
                Item newItem;
                List<Item> similarItems = Item.getSimilarItemList(item);
                
                do {
                    newItem = similarItems.get(random.nextInt(similarItems.size()));
                } while(newItems.contains(newItem));
                
                newItems.add(newItem);
            }
            
            shop.setItems(newItems);
        }
    }
    
    public void randomizeScrollsRandom() {
        List<int[]> scrollPatterns = new ArrayList<>();
        scrollPatterns.add(new int[] {6});
        scrollPatterns.add(new int[] {6,2,1,-1,-2});
        scrollPatterns.add(new int[] {6,2,-2});
        scrollPatterns.add(new int[] {6,1,1,-2});
        scrollPatterns.add(new int[] {4,4,-2});
        scrollPatterns.add(new int[] {4,2});
        scrollPatterns.add(new int[] {4,2,2,-2});
        scrollPatterns.add(new int[] {4,2,1,1,-2});
        scrollPatterns.add(new int[] {4,1,1});
        scrollPatterns.add(new int[] {4,2,1,-1});
        scrollPatterns.add(new int[] {2,2,2,2,-2});
        scrollPatterns.add(new int[] {2,2,2});
        scrollPatterns.add(new int[] {2,2,1,1});
        scrollPatterns.add(new int[] {2,1,1,1,1});
        scrollPatterns.add(new int[] {1,1,1,1,1,1});
        
        Collections.shuffle(scrollPatterns, random);

        for(Scroll scroll : Scroll.values()) {
            int[] pattern = scrollPatterns.remove(0);
            WeightedList<String> statWeights = new WeightedList<>();
            statWeights.add("hp", 1.0f);
            statWeights.add("atk", 1.0f);
            statWeights.add("mag", 1.0f);
            statWeights.add("skl", 1.0f);
            statWeights.add("spd", 1.0f);
            statWeights.add("lck", 1.0f);
            statWeights.add("def", 1.0f);
            statWeights.add("bld", 0.25f);
            statWeights.add("mov", 0.25f);
            
            scroll.setToZero();
            
            for(int i = 0; i < pattern.length; i++) {
                String stat = statWeights.getSelection(random.nextFloat());
                statWeights.remove(stat);
                int statValue = pattern[i] * 5;
                
                switch(stat) {
                case "hp":
                    scroll.setHp(statValue);
                    break;
                case "atk":
                    scroll.setAtk(statValue);
                    break;
                case "mag":
                    scroll.setMag(statValue);
                    break;
                case "skl":
                    scroll.setSkl(statValue);
                    break;
                case "spd":
                    scroll.setSpd(statValue);
                    break;
                case "lck":
                    scroll.setLck(statValue);
                    break;
                case "def":
                    scroll.setDef(statValue);
                    break;
                case "bld":
                    scroll.setBld(statValue);
                    break;
                case "mov":
                    scroll.setMov(statValue);
                    break;
                }
            }
        }
    }
    
    public void randomizeScrollsShuffleAttributes() {
        for(Scroll scroll : Scroll.values()) {
            shuffleScrollAttributes(scroll);
        }
    }
    
    private void shuffleScrollAttributes(Scroll scroll) {
        List<Integer> attributes = new ArrayList<>();
        
        attributes.add(scroll.getHp());
        attributes.add(scroll.getAtk());
        attributes.add(scroll.getMag());
        attributes.add(scroll.getSkl());
        attributes.add(scroll.getSpd());
        attributes.add(scroll.getLck());
        attributes.add(scroll.getDef());
        attributes.add(scroll.getBld());
        attributes.add(scroll.getMov());
        
        Collections.shuffle(attributes, random);
        
        scroll.setHp(attributes.remove(0));
        scroll.setAtk(attributes.remove(0));
        scroll.setMag(attributes.remove(0));
        scroll.setSkl(attributes.remove(0));
        scroll.setSpd(attributes.remove(0));
        scroll.setLck(attributes.remove(0));
        scroll.setDef(attributes.remove(0));
        scroll.setBld(attributes.remove(0));
        scroll.setMov(attributes.remove(0));
    }
    
    public void randomizeScrollsShuffle(boolean shuffleAttributes) {
        List<int[]> scrollAttributes = new ArrayList<>();
        
        for(Scroll scroll : Scroll.values()) {
            int[] attributes = new int[9];
            
            attributes[0] = scroll.getHp();
            attributes[1] = scroll.getAtk();
            attributes[2] = scroll.getMag();
            attributes[3] = scroll.getSkl();
            attributes[4] = scroll.getSpd();
            attributes[5] = scroll.getLck();
            attributes[6] = scroll.getDef();
            attributes[7] = scroll.getBld();
            attributes[8] = scroll.getMov();
            
            scrollAttributes.add(attributes);
        }
        
        Collections.shuffle(scrollAttributes, random);
        
        for(Scroll scroll : Scroll.values()) {
            int[] attributes = scrollAttributes.remove(0);
            
            scroll.setToZero();
            scroll.setHp(attributes[0]);
            scroll.setAtk(attributes[1]);
            scroll.setMag(attributes[2]);
            scroll.setSkl(attributes[3]);
            scroll.setSpd(attributes[4]);
            scroll.setLck(attributes[5]);
            scroll.setDef(attributes[6]);
            scroll.setBld(attributes[7]);
            scroll.setMov(attributes[8]);
            
            if(shuffleAttributes) {
                shuffleScrollAttributes(scroll);
            }
        }
    }
    
    private void setCostForPrfweapons() {
        Item.BEOSWORD.setCostPerUse(200);
        Item.HOLY_SWORD.setCostPerUse(200);
        Item.BLAGI_SWORD.setCostPerUse(200);
        Item.LIGHT_SWORD.setCostPerUse(160);
        Item.BRAVE_SWORD.setCostPerUse(200);
        Item.KING_SWORD.setCostPerUse(160);
        Item.EARTH_SWORD.setCostPerUse(200);
        Item.MAREETAS_SWORD.setCostPerUse(150);
        Item.DARKNESS_SWORD.setCostPerUse(150);
        Item.BRAVE_LANCE.setCostPerUse(200);
        Item.DRAGON_LANCE.setCostPerUse(200);
        Item.PUGI.setCostPerUse(150);
        Item.BRAVE_AXE.setCostPerUse(200);
        Item.BRAVE_BOW.setCostPerUse(200);
        Item.GRAFCALIBUR.setCostPerUse(150);
    }
    
    public void downgradeWindTome() {
        Item windTome = Item.WIND;
        
        windTome.setWeaponRank(WeaponRank.E);
        windTome.setPower(4); // Was 6
        windTome.setAccuracy(80); // Was 90
        windTome.setCritical(5); // Was 10
    }
    
    public void addWeaponUses() {
        Item.MASTER_SWORD.setMaxUses(30);
        Item.THIN_LANCE.setMaxUses(30);
        Item.KILLER_LANCE.setMaxUses(30);
        Item.MASTER_LANCE.setMaxUses(30);
        Item.KILLER_AXE.setMaxUses(30);
        Item.MASTER_AXE.setMaxUses(30);
        Item.KILLER_BOW.setMaxUses(30);
        Item.MASTER_BOW.setMaxUses(30);
        Item.FIRE.setMaxUses(30);
        Item.VOLCANNON.setMaxUses(20);
        Item.TRON.setMaxUses(20);
        Item.WIND.setMaxUses(30);
        Item.TORNADO.setMaxUses(20);
        Item.LIGHTNING.setMaxUses(30);
        Item.HEAL.setMaxUses(30);
        Item.MEND.setMaxUses(20);
        Item.TORCH.setMaxUses(10);
        Item.PHYSIC.setMaxUses(10);
        Item.RESTORE.setMaxUses(10);
        Item.HOLY_WATER.setMaxUses(3);
        Item.HOLY_WATER.setCostPerUse(300);
        Item.TORCH.setMaxUses(5);
        Item.TORCH.setCostPerUse(100);
    }
    
    public void removePrfLocks() {
        Item.LIGHT_SWORD.setWeaponRank(WeaponRank.B);
        Item.EARTH_SWORD.setWeaponRank(WeaponRank.B);
        Item.DARKNESS_SWORD.setWeaponRank(WeaponRank.C);
        Item.MAREETAS_SWORD.setWeaponRank(WeaponRank.C);
        Item.BEOSWORD.setWeaponRank(WeaponRank.A);
        Item.HOLY_SWORD.setWeaponRank(WeaponRank.A);
        Item.BLAGI_SWORD.setWeaponRank(WeaponRank.B);
        Item.DRAGON_LANCE.setWeaponRank(WeaponRank.B);
        Item.BRAVE_LANCE.setWeaponRank(WeaponRank.B);
        Item.PUGI.setWeaponRank(WeaponRank.C);
        Item.DAIM_THUNDER.setWeaponRank(WeaponRank.B);
        Item.GRAFCALIBUR.setWeaponRank(WeaponRank.B);
        Item.REPAIR.setWeaponRank(WeaponRank.B);
        Item.THIEF_STAFF.setWeaponRank(WeaponRank.B);
        Item.UNLOCK.setWeaponRank(WeaponRank.C);
        Item.KIA_STAFF.setWeaponRank(WeaponRank.C);
        
        assignUnitInventories(GameCharacter.getPrfWeaponOwners());
    }
    
    public void nerfBallistae() {
        Item.LONG_ARCH.setAccuracy(65);
        Item.IRON_ARCH.setAccuracy(65);
        Item.KILLER_ARCH.setAccuracy(65);
    }
    
    public ArrayList<ArmyUnit> getArmyUnits() {
        return armyUnits;
    }

    public void shufflePalettes() {
        ArrayList<PortraitPalette> availablePalettes = PortraitPalette.getAvailablePalettes();
        ArrayList<PortraitPalette> shuffledPalettes = new ArrayList<>(PortraitPalette.getAvailablePalettes());
        Collections.shuffle(shuffledPalettes, random);

        System.out.println("Shuffle palettes");
        for (PortraitPalette pPalette : availablePalettes) {
            PortraitPalette selPorPalette = shuffledPalettes.remove(0);
            ColorBGR555[] selPalette = selPorPalette.getPalette();
            ColorBGR555[] newPalette;

            if(selPorPalette.isModified()) {
                selPalette = selPorPalette.getOldPalette();
            }

            newPalette = PortraitPalette.getPaletteConverted(
                    selPorPalette.getPaletteHairType(), selPalette, pPalette.getPaletteHairType());
            pPalette.setPalette(newPalette);

            System.out.println(String.format("%s(0x%02x) -> %s(0x%02x)",
                    pPalette.getLabel(), pPalette.getOffset(), selPorPalette.getLabel(), selPorPalette.getOffset()));
        }

        // fix revived character palettes
        PortraitPalette.EINS_LEIDRICK.setPalette(PortraitPalette.LEIDRICK.getPaletteDeadified());
        PortraitPalette.ZWEI_GALZUS.setPalette(PortraitPalette.GALZUS.getPaletteDeadified());
        PortraitPalette.DREI_DAGDA.setPalette(PortraitPalette.DAGDA.getPaletteDeadified());
        PortraitPalette.ELF_SARA.setPalette(PortraitPalette.SARA.getPaletteDeadified());
        PortraitPalette.ZWOLF_LIFIS.setPalette(PortraitPalette.LIFIS.getPaletteDeadified());
    }

    public void testPalettes() {
        System.out.println("Palette test");
        PortraitPalette test = PortraitPalette.DAISY;
        System.out.println("Testing " + test.name());

        for (PortraitPalette pPalette : PortraitPalette.values()) {
            if(pPalette.equals(test)) {
                continue;
            }

            ColorBGR555[] newPalette;

            newPalette = PortraitPalette.getPaletteConverted(
                    test.getPaletteHairType(), test.getPalette(), pPalette.getPaletteHairType());
            pPalette.setPalette(newPalette);
        }
    }

    public void testDeadify() {
        System.out.println("Testing Deadify");
        for (PortraitPalette pPalette : PortraitPalette.values()) {
            ColorBGR555[] palette = pPalette.getPalette();
            ColorBGR555[] newPalette = new ColorBGR555[16];

            for (int i = 0; i < palette.length; i++) {
                newPalette[i] = ColorBGR555.deadify(palette[i]);
            }

            pPalette.setPalette(newPalette);
        }
    }

    public void testPortraits() {
        System.out.println("Portrait test");

        GameCharacter.LEAF.setPortrait(GameCharacter.KEMPF_BOSS.getPortrait());
        GameCharacter.FINN.setPortrait(GameCharacter.IZENAU_BOSS.getPortrait());
        GameCharacter.OTHIN.setPortrait(GameCharacter.MIRANDA.getPortrait());
        GameCharacter.SARA.setPortrait(GameCharacter.AMALDA.getPortrait());

        //GameCharacter.LEAF.setPortrait(0x41);
        //GameCharacter.FINN.setPortrait(0x8F);
        //GameCharacter.EYVEL.setPortrait(0xA2);
    }

    public void lilMansterRenamePugi() {
        int pugiOffset = 0x1813D7;
        int[] pugiValues = new int[] {0x20, 0x50, 0x75, 0x67, 0x69, 0x20}; // " Pugi "
        
        for(int i = 0; i < pugiValues.length; i++) {
            setValueAt(pugiOffset + i, pugiValues[i]);
        }
    }
    
    public void projectExileRenamePugi() {
        int pugiOffset = 0x18139B;
        int[] pugiValues = new int[] {0x50, 0x75, 0x67, 0x69}; // "Pugi"
        
        for(int i = 0; i < pugiValues.length; i++) {
            setValueAt(pugiOffset + i, pugiValues[i]);
        }
    }
    
    public void reset() {
        if(bytesBackup.length > 0) {
            bytes = bytesBackup;
            bytesBackup = new byte[0];
        }
        
        GameCharacter.resetGameCharacters();
        
        for(ArmyUnit armyUnits : armyUnits) {
            armyUnits.reset();
        }
        
        Item.resetItems();
        Scroll.resetScrolls();
        ItemReward.reset();
        Shop.resetShops();
        
        promotionData.reset();
        PortraitPalette.resetAll();
    }
    
    public void applyChanges() {
        bytesBackup = bytes.clone();
        
        GameCharacter.writeCharacters(this);

        for(ArmyUnit unit : armyUnits) {
            unit.writeArmyUnit(this);
        }
        
        Item.writeItems(this);
        Scroll.writeScrolls(this);
        ItemReward.writeItemRewards(this);
        Shop.writeShops(this);
        
        promotionData.writePromotions(this);
        PortraitPalette.writeAll(this);
    }
    
    public byte[] getBytes() {
        return bytes;
    }
    
    public WeaponSeed[] getSeedAsWeaponArray() {
        WeaponSeed[] seedArray = new WeaponSeed[6];
        seedArray[5] = WeaponSeed.getBySeed((int)(0x1F & seed));
        seedArray[4] = WeaponSeed.getBySeed((int)(0x1F & seed >> 5));
        seedArray[3] = WeaponSeed.getBySeed((int)(0x1F & seed >> 10));
        seedArray[2] = WeaponSeed.getBySeed((int)(0x1F & seed >> 15));
        seedArray[1] = WeaponSeed.getBySeed((int)(0x1F & seed >> 20));
        seedArray[0] = WeaponSeed.getBySeed((int)(0x1F & seed >> 25));
        
        return seedArray;
    }

    @Override
    public String toString() {
        String text = String.format(
                "[ROM] Name: %s, FE5: %b, Header: %b, CRC32Chk: %d, File Size: %d bytes, Valid file size: %b", name,
                fireEmblem5, headered, crc32Checksum, bytes.length, validFileSize);

        return text;
    }
}
