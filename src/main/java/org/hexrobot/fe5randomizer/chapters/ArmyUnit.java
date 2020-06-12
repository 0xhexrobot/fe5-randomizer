package org.hexrobot.fe5randomizer.chapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hexrobot.fe5randomizer.Rom;
import org.hexrobot.fe5randomizer.characters.CharacterClass;
import org.hexrobot.fe5randomizer.characters.GameCharacter;
import org.hexrobot.fe5randomizer.items.Item;
import org.hexrobot.fe5randomizer.items.ItemType;
import org.hexrobot.fe5randomizer.items.WeaponRank;

public class ArmyUnit {
    private int offset;
    private GameCharacter character;
    private int xCoord;
    private int yCoord;
    private int armyOrigin;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int level;
    private boolean autoLeveled;
    private int unknown1;
    private int unknown2;
    private int unknown3;
    private int unknown4;
    private Map<String, Object> oldValues = new HashMap<>();
    
    private static final int CHARACTER_NUMBER_OFFSET = 0x0;
    private static final int X_COORD_OFFSET = 0x04;
    private static final int Y_COORD_OFFSET = 0x05;
    private static final int ARMY_ORIGIN_OFFSET = 0x06;
    private static final int INVENTORY_SLOT_1_OFFSET = 0x08;
    private static final int INVENTORY_SLOT_2_OFFSET = 0x09;
    private static final int INVENTORY_SLOT_3_OFFSET = 0x0A;
    private static final int INVENTORY_SLOT_4_OFFSET = 0x0B;
    private static final int INVENTORY_SLOT_5_OFFSET = 0x0C;
    private static final int INVENTORY_SLOT_6_OFFSET = 0x0D;
    private static final int INVENTORY_SLOT_7_OFFSET = 0x0E;
    private static final int LEVEL_OFFSET = 0x0F;
    private static final int UNKNOWN_1_OFFSET = 0x10;
    private static final int UNKNOWN_2_OFFSET = 0x11;
    private static final int UNKNOWN_3_OFFSET = 0x12;
    private static final int UNKNOWN_4_OFFSET = 0x13;
    
    public ArmyUnit(Rom rom, int startingOffset) {
        int relOffset = startingOffset;
        offset = relOffset;
        character = GameCharacter.findById(rom.getValueAt(relOffset + CHARACTER_NUMBER_OFFSET, 2));
        xCoord = rom.getValueAt(relOffset + X_COORD_OFFSET);
        yCoord = rom.getValueAt(relOffset + Y_COORD_OFFSET);
        armyOrigin = rom.getValueAt(relOffset + ARMY_ORIGIN_OFFSET, 2);
        
        int inventory1 = rom.getValueAt(relOffset + INVENTORY_SLOT_1_OFFSET);
        int inventory2 = rom.getValueAt(relOffset + INVENTORY_SLOT_2_OFFSET);
        int inventory3 = rom.getValueAt(relOffset + INVENTORY_SLOT_3_OFFSET);
        int inventory4 = rom.getValueAt(relOffset + INVENTORY_SLOT_4_OFFSET);
        int inventory5 = rom.getValueAt(relOffset + INVENTORY_SLOT_5_OFFSET);
        int inventory6 = rom.getValueAt(relOffset + INVENTORY_SLOT_6_OFFSET);
        int inventory7 = rom.getValueAt(relOffset + INVENTORY_SLOT_7_OFFSET);
        
        addToInventory(inventory1);
        addToInventory(inventory2);
        addToInventory(inventory3);
        addToInventory(inventory4);
        addToInventory(inventory5);
        addToInventory(inventory6);
        addToInventory(inventory7);
        
        level = rom.getValueAt(relOffset + LEVEL_OFFSET);
        autoLeveled = (level & 0x80) == 0x80;
        level &= 0x1F; 
        unknown1 = rom.getValueAt(relOffset + UNKNOWN_1_OFFSET);
        unknown2 = rom.getValueAt(relOffset + UNKNOWN_2_OFFSET);
        unknown3 = rom.getValueAt(relOffset + UNKNOWN_3_OFFSET);
        unknown4 = rom.getValueAt(relOffset + UNKNOWN_4_OFFSET);
    }
    
    public void writeArmyUnit(Rom rom) {
        if(oldValues.containsKey("inventory")) {
            for(int i = 0; i < 7; i++) {
                int itemOffset = 0;
                
                if(i < inventory.size()) {
                    itemOffset = inventory.get(i).getOffset() + 1;
                }
                
                rom.setValueAt(offset + INVENTORY_SLOT_1_OFFSET + i, itemOffset);
            }
        }
    }
    
    public int getOffset() {
        return offset;
    }
    
    public GameCharacter getCharacter() {
        return character;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public int getArmyOrigin() {
        return armyOrigin;
    }

    public ArrayList<Item> getInventory() {
        return new ArrayList<Item>(inventory);
    }

    public int getLevel() {
        return level;
    }
    
    public boolean isAutoLeveled() {
        return autoLeveled;
    }

    public int getUnknown1() {
        return unknown1;
    }

    public int getUnknown2() {
        return unknown2;
    }

    public int getUnknown3() {
        return unknown3;
    }
    
    public int getUnknown4() {
        return unknown4;
    }
    
    public void setInventory(ArrayList<Item> inventory) {
        if(!oldValues.containsKey("inventory") && !this.inventory.equals(inventory)) {
            oldValues.put("inventory", this.inventory);
        }
        
        this.inventory = inventory;
    }
    
    public boolean canUseWeapon(Item item) {
        boolean canUseItem = false;
        WeaponRank rank = item.getWeaponRank();
        ItemType type = item.getItemType();
        CharacterClass chClass = character.getCharacterClass();
        
        if(chClass.canUseWeaponType(type)) {
            if(rank.isStdRank()) {
                switch(type) {
                case SWORD:
                case FIRE_SWORD:
                case THUNDER_SWORD:
                case WIND_SWORD:
                case LIGHT_SWORD:
                    canUseItem = chClass.getBaseSwordLv().getAmount() + character.getBaseSwordLv().getAmount() >= rank
                            .getOffset();
                    break;
                case LANCE:
                    canUseItem = chClass.getBaseLanceLv().getAmount() + character.getBaseLanceLv().getAmount() >= rank
                            .getOffset();
                    break;
                case AXE:
                    canUseItem = chClass.getBaseAxeLv().getAmount() + character.getBaseAxeLv().getAmount() >= rank
                            .getOffset();
                    break;
                case BOW:
                    canUseItem = chClass.getBaseBowLv().getAmount() + character.getBaseBowLv().getAmount() >= rank
                            .getOffset();
                    break;
                case STAFF:
                    canUseItem = chClass.getBaseStaffLv().getAmount() + character.getBaseStaffLv().getAmount() >= rank
                            .getOffset();
                    break;
                case FIRE:
                    canUseItem = chClass.getBaseFireLv().getAmount() + character.getBaseFireLv().getAmount() >= rank
                            .getOffset();
                    break;
                case THUNDER:
                    canUseItem = chClass.getBaseThunderLv().getAmount() + character.getBaseThunderLv().getAmount() >= rank
                            .getOffset();
                    break;
                case WIND:
                    canUseItem = chClass.getBaseWindLv().getAmount() + character.getBaseWindLv().getAmount() >= rank
                            .getOffset();
                    break;
                case LIGHT:
                    canUseItem = chClass.getBaseLightLv().getAmount() + character.getBaseLightLv().getAmount() >= rank
                            .getOffset();
                    break;
                case DARK:
                    canUseItem = chClass.getBaseDarkLv().getAmount() + character.getBaseDarkLv().getAmount() >= rank
                            .getOffset();
                    break;
                default:
                    break;
                }
            } else {
                canUseItem = rank.isUnlockedFor(character);
            }
        }
        
        return canUseItem;
    }
    
    private void addToInventory(int offset) {
        if(offset > 0) {
            inventory.add(Item.findById(offset - 1));
        }
    }
    
    public Map<String, Object> getOldValues() {
        return oldValues;
    }
    
    public void reset() {
        if(!oldValues.isEmpty()) {
            if(oldValues.containsKey("inventory")) {
                ArrayList<?> result = (ArrayList<?>) oldValues.get("inventory");
                ArrayList<Item> inventory = new ArrayList<>();
                
                for (Object object : result) {
                    if (object instanceof Item) {
                        inventory.add((Item) object);
                    }
                }
                
                this.inventory = inventory;
            }
            
            oldValues.clear();
        }
    }
    
    @Override
    public String toString() {
        String text = "[ARMY UNIT]";
        String textInventory = "";
        
        for(int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            
            textInventory += String.format("%d: %s(0x%02X)", i + 1, item.getName(), item.getOffset());
            
            if(i < inventory.size() - 1) {
                textInventory += ", ";
            }
        }
        
        text += String.format(
                "Character: %s(0x%04X), X: %d, Y: %d, Army: 0x%04X\n"
                + "Inventory -> %s\n"
                + "Level: %d%s, Unknown1: 0x%02X, Unknown2: 0x%02X, Unknown3: 0x%02X, Unknown4: 0x%02X",
                character.getName(), character.getOffset(), xCoord, yCoord, armyOrigin, textInventory, level, autoLeveled ? "(Auto)" : "", unknown1, unknown2, unknown3, unknown4);
        
        return text;
    }
}
