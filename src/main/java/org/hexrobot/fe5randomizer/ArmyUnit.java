package org.hexrobot.fe5randomizer;

import org.hexrobot.fe5randomizer.characters.GameCharacter;

public class ArmyUnit {    
    private GameCharacter character;
    private int xCoord;
    private int yCoord;
    private int armyOrigin;
    private int inventory1;
    private int inventory2;
    private int inventory3;
    private int inventory4;
    private int inventory5;
    private int inventory6;
    private int inventory7;
    private int level;
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
        inventory1 = rom.getValueAt(relOffset + INVENTORY_SLOT_1_OFFSET);
        inventory2 = rom.getValueAt(relOffset + INVENTORY_SLOT_2_OFFSET);
        inventory3 = rom.getValueAt(relOffset + INVENTORY_SLOT_3_OFFSET);
        inventory4 = rom.getValueAt(relOffset + INVENTORY_SLOT_4_OFFSET);
        inventory5 = rom.getValueAt(relOffset + INVENTORY_SLOT_5_OFFSET);
        inventory6 = rom.getValueAt(relOffset + INVENTORY_SLOT_6_OFFSET);
        inventory7 = rom.getValueAt(relOffset + INVENTORY_SLOT_7_OFFSET);
        level = rom.getValueAt(relOffset + LEVEL_OFFSET);
        unknown1 = rom.getValueAt(relOffset + UNKNOWN_1_OFFSET);
        unknown2 = rom.getValueAt(relOffset + UNKNOWN_2_OFFSET);
        unknown3 = rom.getValueAt(relOffset + UNKNOWN_3_OFFSET);
        unknown4 = rom.getValueAt(relOffset + UNKNOWN_4_OFFSET);
    }
    
    @Override
    public String toString() {
        String text = "[ARMY UNIT]";
        
        text += String.format(
                "Character: %s(0x%04X), X: %d, Y: %d, Army: 0x%04X Inv1: 0x%02X, Inv2: 0x%02X, Inv3: 0x%02X, Inv4: 0x%02X, Inv5: 0x%02X, Inv6: 0x%02X, Inv7: 0x%02X, Level: %d, Unknown1: 0x%02X, Unknown2: 0x%02X, Unknown3: 0x%02X, Unknown4: 0x%02X",
                character.getName(), character.getOffset(), xCoord, yCoord, armyOrigin, inventory1, inventory2, inventory3,
                inventory4, inventory5, inventory6, inventory7, level, unknown1, unknown2, unknown3, unknown4);
        
        return text;
    }
}
