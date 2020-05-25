package org.hexrobot.fe5randomizer;

import java.util.ArrayList;

import org.hexrobot.fe5randomizer.characters.GameCharacter;
import org.hexrobot.fe5randomizer.items.Item;

public class ArmyUnit {    
    private GameCharacter character;
    private int xCoord;
    private int yCoord;
    private int armyOrigin;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int level;
    private boolean promoted;
    private int unknown1;
    private int unknown2;
    private int unknown3;
    private int unknown4;
    
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
        character = GameCharacter.findById(rom.getValueAt(relOffset + CHARACTER_NUMBER_OFFSET, -2));
        xCoord = rom.getValueAt(relOffset + X_COORD_OFFSET);
        yCoord = rom.getValueAt(relOffset + Y_COORD_OFFSET);
        armyOrigin = rom.getValueAt(relOffset + ARMY_ORIGIN_OFFSET, -2);
        
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
        promoted = (level & 0x80) == 0x80;
        level &= 0x1F; 
        unknown1 = rom.getValueAt(relOffset + UNKNOWN_1_OFFSET);
        unknown2 = rom.getValueAt(relOffset + UNKNOWN_2_OFFSET);
        unknown3 = rom.getValueAt(relOffset + UNKNOWN_3_OFFSET);
        unknown4 = rom.getValueAt(relOffset + UNKNOWN_4_OFFSET);
    }
    
    private void addToInventory(int offset) {
        if(offset > 0) {
            inventory.add(Item.findById(offset - 1));
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
                character.getName(), character.getOffset(), xCoord, yCoord, armyOrigin, textInventory, level, promoted ? "(P)" : "", unknown1, unknown2, unknown3, unknown4);
        
        return text;
    }
}
