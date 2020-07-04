package org.hexrobot.fe5randomizer;

import java.util.ArrayList;
import java.util.Random;
import java.util.zip.CRC32;

import org.hexrobot.fe5randomizer.chapters.Army;
import org.hexrobot.fe5randomizer.chapters.ArmyUnit;
import org.hexrobot.fe5randomizer.chapters.Chapter;
import org.hexrobot.fe5randomizer.characters.CharacterClass;
import org.hexrobot.fe5randomizer.characters.GameCharacter;
import org.hexrobot.fe5randomizer.characters.MovementStars;
import org.hexrobot.fe5randomizer.characters.Skill;
import org.hexrobot.fe5randomizer.items.Item;
import org.hexrobot.fe5randomizer.items.WeaponBladeEffect;
import org.hexrobot.fe5randomizer.items.WeaponSkill;
import org.hexrobot.fe5randomizer.items.WeaponStatBonus;

public class Rom {
    private static final long FE5_HEADERED_CRC32_CHK = 2514651613L;
    private static final long FE5_UNHEADERED_CRC32_CHK = 4233206098L;
    private static final int MIN_FILE_SIZE = 4194304;
    private static final int HEADER_SIZE = 0x200;
    private static final int GAME_TITLE_OFFSET = 0x81C0;
    private static final int ITEMS_OFFSET = 0x1802C2;
    private static final int CHARACTERS_OFFSET = 0x31C2D;
    private static final int CHARACTER_CLASSES_OFFSET = 0x30200;
    private static final int MOUNT_TABLE_OFFSET = 0x40200;
    private byte[] bytes;
    private byte[] bytesBackup = new byte[0];
    private String name = "Fire Emblem 5 (Unknown)";
    private boolean headered;
    private boolean validFileSize;
    private long crc32Checksum;
    private boolean fireEmblem5;
    private Random random;
    private RandomizationLogic logic = new RandomizationLogic();
    private ArrayList<ArmyUnit> armyUnits = new ArrayList<ArmyUnit>();
    private MountData mountData;
    
    public Rom(byte[] bytes) {
        this.bytes = bytes;
        random = new Random(0);

        headered = bytes.length % 1024 == 512;
        validFileSize = bytes.length % 1024 == 0 && bytes.length >= MIN_FILE_SIZE;

        CRC32 crc32 = new CRC32();
        crc32.update(bytes);
        crc32Checksum = crc32.getValue();

        if(crc32Checksum == FE5_HEADERED_CRC32_CHK || crc32Checksum == FE5_UNHEADERED_CRC32_CHK) {
            name = "Fire Emblem 5";
            fireEmblem5 = true;
        }

        if(!fireEmblem5) {
            String gameTitle = "";
            for(int i = 0; i < 11; i++) {
                char currentChar = (char) getValueAt(GAME_TITLE_OFFSET + i);
                gameTitle += currentChar;
            }
                        
            fireEmblem5 = gameTitle.equalsIgnoreCase("FIREEMBLEM5");
        }
    }
    
    public void setRandomSeed(long seed) {
        random = new Random(seed);
    }

    public int getValueAt(int offset) {
        if(!headered) {
            offset -= HEADER_SIZE;
        }

        return bytes[offset] & 0xFF;
    }

    public int getValueAt(int offset, int length) {
        if(length != 2) {
            throw new IllegalArgumentException("Only retrieving 2 bytes are supported.");
        }

        if(!headered) {
            offset -= HEADER_SIZE;
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
        
        if(!headered) {
            offset -= HEADER_SIZE;
        }

        bytes[offset] = (byte)(value & 0xFF);
    }
    
    public void set2ByteValueAt(int offset, int value) {
        if(value > 0xFFFF) {
            throw new IllegalArgumentException("Value exceeds 2 bytes");
        }

        if(!headered) {
            offset -= HEADER_SIZE;
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

    public long getCrc32Checksum() {
        return crc32Checksum;
    }
    
    public int getSize() {
        return bytes.length;
    }
    
    public void initialize() {
        initializeItems();
        initializeCharacterClasses();
        initializeMountData();
        initializeCharacters();
        initializeArmyData();
    }

    private void initializeItems() {
        for(Item item : Item.values()) {
            item.readItem(this, ITEMS_OFFSET);
        }
    }
    
    private void initializeCharacterClasses() {
        for(CharacterClass characterClass : CharacterClass.values()) {
            characterClass.readCharacterClass(this, CHARACTER_CLASSES_OFFSET);
        }
    }

    private void initializeCharacters() {
        for(GameCharacter character : GameCharacter.values()) {
            character.readCharacter(this, CHARACTERS_OFFSET);
        }
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
    
    private void initializeMountData() {
        mountData = new MountData(this, MOUNT_TABLE_OFFSET);
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
        
        for(GameCharacter character : characters) {
            int totalBases = 0;
            int baseHp, baseAtk, baseMag, baseSkl, baseSpd, baseLck, baseDef, baseBld, baseMov;
            float totalWeights = 0;
            float hpWeight, atkWeight, magWeight, sklWeight, spdWeight, lckWeight, defWeight, bldWeight, movWeight;
            int originalBases, newBases, basesDiff;
            
            hpWeight = random.nextFloat() * 2.0f;
            atkWeight = random.nextFloat();
            magWeight = random.nextFloat();
            sklWeight = random.nextFloat();
            spdWeight = random.nextFloat();
            lckWeight = random.nextFloat();
            defWeight = random.nextFloat();
            bldWeight = random.nextFloat() * 0.5f;
            movWeight = random.nextFloat() * 0.5f;
            
            totalWeights = hpWeight + atkWeight + magWeight + sklWeight + spdWeight + lckWeight + defWeight + bldWeight + movWeight;
            
            totalBases += character.getBaseHp();
            totalBases += character.getBaseAtk();
            totalBases += character.getBaseMag();
            totalBases += character.getBaseSkl();
            totalBases += character.getBaseSpd();
            totalBases += character.getBaseLck();
            totalBases += character.getBaseDef();
            totalBases += character.getBaseBld();
            totalBases += character.getBaseMov();
            
            originalBases = totalBases;
            totalBases += random.nextInt(variance * 2 + 1) - variance;
            
            baseHp = Math.round(hpWeight * totalBases / totalWeights);
            baseAtk = Math.round(atkWeight * totalBases / totalWeights);
            baseMag = Math.round(magWeight * totalBases / totalWeights);
            baseSkl = Math.round(sklWeight * totalBases / totalWeights);
            baseSpd = Math.round(spdWeight * totalBases / totalWeights);
            baseLck = Math.round(lckWeight * totalBases / totalWeights);
            baseDef = Math.round(defWeight * totalBases / totalWeights);
            baseBld = Math.round(bldWeight * totalBases / totalWeights);
            baseMov = Math.round(movWeight * totalBases / totalWeights);
            
            newBases = baseHp + baseAtk + baseMag + baseSkl + baseSpd + baseLck + baseDef + baseBld + baseMov;
            basesDiff = newBases - originalBases;
            
            character.setBaseHp(baseHp);
            character.setBaseAtk(baseAtk);
            character.setBaseMag(baseMag);
            character.setBaseSkl(baseSkl);
            character.setBaseSpd(baseSpd);
            character.setBaseLck(baseLck);
            character.setBaseDef(baseDef);
            character.setBaseBld(baseBld);
            character.setBaseMov(baseMov);
            
            System.out.println(String.format("%s bases(%+d): %d → %d", character.getName(), basesDiff, originalBases, newBases));
        }
    }
    
    public void randomizeUnitsGrowthsVariance(int delta) {
        ArrayList<GameCharacter> characters = GameCharacter.getPlayableUnits();
        
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
            
            newHpGrowth = Math.max(hpGrowth + random.nextInt(delta * 2 + 1) - delta, 0);
            newAtkGrowth = Math.max(atkGrowth + random.nextInt(delta * 2 + 1) - delta, 0);
            newMagGrowth = Math.max(magGrowth + random.nextInt(delta * 2 + 1) - delta, 0);
            newSklGrowth = Math.max(sklGrowth + random.nextInt(delta * 2 + 1) - delta, 0);
            newSpdGrowth = Math.max(spdGrowth + random.nextInt(delta * 2 + 1) - delta, 0);
            newLckGrowth = Math.max(lckGrowth + random.nextInt(delta * 2 + 1) - delta, 0);
            newDefGrowth = Math.max(defGrowth + random.nextInt(delta * 2 + 1) - delta, 0);
            newBldGrowth = Math.max(bldGrowth + random.nextInt(delta * 2 + 1) - delta, 0);
            newMovGrowth = Math.max(movGrowth + random.nextInt(delta * 2 + 1) - delta, 0);
            
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
        
        for(GameCharacter character : characters) {
            int totalGrowths = 0;
            int hpGrowth, atkGrowth, magGrowth, sklGrowth, spdGrowth, lckGrowth, defGrowth, bldGrowth, movGrowth;
            float totalWeights = 0;
            float hpWeight, atkWeight, magWeight, sklWeight, spdWeight, lckWeight, defWeight, bldWeight, movWeight;
            int originalGrowths, newGrowths, growthsDiff;
            
            hpWeight = random.nextFloat() * 2.0f;
            atkWeight = random.nextFloat();
            magWeight = random.nextFloat();
            sklWeight = random.nextFloat();
            spdWeight = random.nextFloat();
            lckWeight = random.nextFloat();
            defWeight = random.nextFloat();
            bldWeight = random.nextFloat() * 0.5f;
            movWeight = random.nextFloat() * 0.5f;
            
            totalWeights = hpWeight + atkWeight + magWeight + sklWeight + spdWeight + lckWeight + defWeight + bldWeight + movWeight;
            
            totalGrowths += character.getHpGrowth();
            totalGrowths += character.getAtkGrowth();
            totalGrowths += character.getMagGrowth();
            totalGrowths += character.getSklGrowth();
            totalGrowths += character.getSpdGrowth();
            totalGrowths += character.getLckGrowth();
            totalGrowths += character.getDefGrowth();
            totalGrowths += character.getBldGrowth();
            totalGrowths += character.getMovGrowth();
            
            originalGrowths = totalGrowths;
            totalGrowths += random.nextInt(variance * 2 + 1) - variance;
            
            hpGrowth = Math.round(hpWeight * totalGrowths / totalWeights);
            atkGrowth = Math.round(atkWeight * totalGrowths / totalWeights);
            magGrowth = Math.round(magWeight * totalGrowths / totalWeights);
            sklGrowth = Math.round(sklWeight * totalGrowths / totalWeights);
            spdGrowth = Math.round(spdWeight * totalGrowths / totalWeights);
            lckGrowth = Math.round(lckWeight * totalGrowths / totalWeights);
            defGrowth = Math.round(defWeight * totalGrowths / totalWeights);
            bldGrowth = Math.round(bldWeight * totalGrowths / totalWeights);
            movGrowth = Math.round(movWeight * totalGrowths / totalWeights);
            
            newGrowths = hpGrowth + atkGrowth + magGrowth + sklGrowth + spdGrowth + lckGrowth + defGrowth + bldGrowth + movGrowth;
            growthsDiff = newGrowths - originalGrowths;
            
            character.setHpGrowth(hpGrowth);
            character.setAtkGrowth(atkGrowth);
            character.setMagGrowth(magGrowth);
            character.setSklGrowth(sklGrowth);
            character.setSpdGrowth(spdGrowth);
            character.setLckGrowth(lckGrowth);
            character.setDefGrowth(defGrowth);
            character.setBldGrowth(bldGrowth);
            character.setMovGrowth(movGrowth);
            
            System.out.println(String.format("%s growths(%+d%%): %d%% → %d%%", character.getName(), growthsDiff, originalGrowths, newGrowths));
        }
    }
    
    public void randomizeUnitsGrowthsAbsolute(int min, int max) {
        ArrayList<GameCharacter> characters = GameCharacter.getPlayableUnits();
        int newHpGrowth, newAtkGrowth, newMagGrowth, newSklGrowth, newSpdGrowth, newLckGrowth, newDefGrowth, newBldGrowth, newMovGrowth;
        int maxDiff = max - min;
        
        for(GameCharacter character : characters) {
            newHpGrowth = min + random.nextInt(maxDiff + 1);
            newAtkGrowth = min + random.nextInt(maxDiff + 1);
            newMagGrowth = min + random.nextInt(maxDiff + 1);
            newSklGrowth = min + random.nextInt(maxDiff + 1);
            newSpdGrowth = min + random.nextInt(maxDiff + 1);
            newLckGrowth = min + random.nextInt(maxDiff + 1);
            newDefGrowth = min + random.nextInt(maxDiff + 1);
            newBldGrowth = min + random.nextInt(maxDiff + 1);
            newMovGrowth = min + random.nextInt(maxDiff + 1);
            
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
        
        if(excludeHealers) {
            characters.removeIf(unit -> unit.getCharacterClass().isHealer());
        }
        
        if(excludeThieves) {
            characters.removeIf(unit -> unit.getCharacterClass().isThief());
        }

        assignNewClasses(characters);
    }
    
    public void randomizeEnemyUnitClasses(boolean excludeBosses) {
        ArrayList<GameCharacter> characters = GameCharacter.getEnemyUnits();
        
        if(excludeBosses) {
            characters.removeAll(GameCharacter.getBossUnits());
        }

        assignNewClasses(characters);
    }
    
    private void assignNewClasses(ArrayList<GameCharacter> characters) {
        ArrayList<CharacterClass> unpromotedClasses = CharacterClass.getUnpromotedClasses();
        ArrayList<CharacterClass> promotedClasses = CharacterClass.getPromotedClasses();
        
        for(GameCharacter character : characters) {
            CharacterClass characterClass = character.getCharacterClass();
            CharacterClass newCharacterClass = characterClass;
            
            if(characterClass.isPromoted()) {
                newCharacterClass = getSelectedClass(character, promotedClasses);
            } else if(characterClass.isUnpromoted()) {
                newCharacterClass = getSelectedClass(character, unpromotedClasses);
            }
            
            character.setCharacterClass(newCharacterClass, random);
        }
        
        assignUnitInventories(characters);
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
                
                inventory.set(i, getSelectedItem(armyUnit));
            }
            
            armyUnit.setInventory(inventory);
        }
    }
    
    private Item getSelectedItem(ArmyUnit unit) {
        Item selectedItem = Item.BROKEN_SWORD;
        WeightedList<Item> itemWeights = new WeightedList<>();
        ArrayList<Item> items = Item.getItems(true, true);
        
        for(Item item : items) {
            float weight = logic.assignItemWeight(unit, item);
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
        enemies.removeIf(unit -> !unit.getCharacter().isEnemyUnit());
        
        for(ArmyUnit unit : enemies) {
            ArrayList<Item> inventory = unit.getInventory();
            maxExtraItems = Math.min(maxExtraItems, 7 - inventory.size());
            int extraInventoryCount = random.nextInt(maxExtraItems + 1);
            ArrayList<Item> extraInventory = new ArrayList<>(); 
            
            while(extraInventory.size() < extraInventoryCount) {
                Item item = getSelectedItem(unit);
                extraInventory.add(item);
            }
            
            inventory.addAll(extraInventory);
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
    // TODO randomize items
    public void randomizeItems(boolean randomizeMight, int mightDelta, boolean randomizeAccuracy, int accuracyDelta, boolean randomizeWeight, int weightDelta, boolean randomizeCritical, int criticalDelta,
            boolean randomizeMaxUses, boolean randomizeCost, boolean addBladeEffect, int bladeEffectChance, int availableBladeEffects, boolean addStatBonus, int statBonusChance, boolean addWeaponSkill, int weaponSkillChance, boolean allowMultipleWeaponSkills) {
        ArrayList<Item> weapons = Item.getWeapons(true, true);
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
    
    public ArrayList<ArmyUnit> getArmyUnits() {
        return armyUnits;
    }
    
    public void reset() {
        if(bytesBackup.length > 0) {
            bytes = bytesBackup;
            bytesBackup = new byte[0];
        }
        
        for(GameCharacter character : GameCharacter.values()) {
            character.reset();
        }
        
        for(ArmyUnit armyUnits : armyUnits) {
            armyUnits.reset();
        }
        
        for(Item item : Item.values()) {
            item.reset();
        }
    }
    
    public MountData getMountData() {
        return mountData;
    }
    
    public void applyChanges() {
        bytesBackup = bytes.clone();
        
        for(GameCharacter character : GameCharacter.values()) {
            character.writeCharacter(this, CHARACTERS_OFFSET);
        }

        for(ArmyUnit unit : armyUnits) {
            unit.writeArmyUnit(this);
        }
        
        for(Item item : Item.values()) {
            item.writeItem(this, ITEMS_OFFSET);
        }
    }
    
    public byte[] getBytes() {
        return bytes;
    }

    @Override
    public String toString() {
        String text = String.format(
                "[ROM] Name: %s, FE5: %b, Header: %b, CRC32Chk: %d, File Size: %d bytes, Valid file size: %b", name,
                fireEmblem5, headered, crc32Checksum, bytes.length, validFileSize);

        return text;
    }
}
