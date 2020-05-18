package org.hexrobot.fe5randomizer;

import java.util.Random;
import java.util.zip.CRC32;

import org.hexrobot.fe5randomizer.characters.GameCharacter;
import org.hexrobot.fe5randomizer.items.Item;

public class Rom {
    private static final long FE5_HEADERED_CRC32_CHK = 2514651613L;
    private static final long FE5_UNHEADERED_CRC32_CHK = 4233206098L;
    private static final int MIN_FILE_SIZE = 4194304;
    private static final int HEADER_SIZE = 0x200;
    private static final int GAME_TITLE_OFFSET = 0x81C0;
    private static final int ITEMS_OFFSET = 0x1802C2;
    private static final int CHARACTERS_OFFSET = 0x31C2D;
    private byte[] bytes;
    private String name = "Fire Emblem 5 (Unknown)";
    private boolean headered;
    private boolean validFileSize;
    private long crc32Checksum;
    private boolean fireEmblem5;
    private Random random;

    public Rom(byte[] bytes) {
        this.bytes = bytes;
        random = new Random();

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
        if(Math.abs(length) != 2) {
            throw new IllegalArgumentException("Only retrieving 2 bytes are supported.");
        }

        if(!headered) {
            offset -= HEADER_SIZE;
        }

        int value = 0;

        if(length == 2) {
            value = (bytes[offset] & 0xFF) << 8 | (bytes[offset + 1] & 0xFF);
        } else if(length == -2) {
            value = (bytes[offset + 1] & 0xFF) << 8 | (bytes[offset] & 0xFF);
        }

        return value;
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

    public void initializeItems() {
        for(Item item : Item.values()) {
            item.readItem(this, ITEMS_OFFSET);
        }
    }

    public void initializeCharacters() {
        for(GameCharacter character : GameCharacter.values()) {
            character.readCharacter(this, CHARACTERS_OFFSET);
        }
    }
    
    public void randomizeUnitsBasesVariance(int delta) {
        GameCharacter[] characters = GameCharacter.values();
        int baseHp, baseAtk, baseMag, baseSkl, baseSpd, baseLck, baseDef, baseBld, baseMov;
        int newBaseHp, newBaseAtk, newBaseMag, newBaseSkl, newBaseSpd, newBaseLck, newBaseDef, newBaseBld, newBaseMov;
        
        for(int i = 0; i < characters.length; i++) {
            GameCharacter character = characters[i];
            
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
        GameCharacter[] characters = GameCharacter.values();
        
        for(int i = 0; i < characters.length; i++) {
            GameCharacter character = characters[i];
            int totalBases = 0;
            int baseHp, baseAtk, baseMag, baseSkl, baseSpd, baseLck, baseDef, baseBld, baseMov;
            float totalWeights = 0;
            float hpWeight, atkWeight, magWeight, sklWeight, spdWeight, lckWeight, defWeight, bldWeight, movWeight;
            
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
    
    public void randomizeUnitsGrowths() {
        
    }

    @Override
    public String toString() {
        String text = String.format(
                "[ROM] Name: %s, FE5: %b, Header: %b, CRC32Chk: %d, File Size: %d bytes, Valid file size: %b", name,
                fireEmblem5, headered, crc32Checksum, bytes.length, validFileSize);

        return text;
    }
}
