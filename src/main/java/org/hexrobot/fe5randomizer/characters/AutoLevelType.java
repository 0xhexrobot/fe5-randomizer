package org.hexrobot.fe5randomizer.characters;

import javafx.util.Pair;
import org.hexrobot.fe5randomizer.Rom;

import java.util.ArrayList;
import java.util.List;

public enum AutoLevelType {
    PHYSICAL_1(0xFF, "Physical 1"),
    MAGICAL_1(0xFE, "Magical 1"),
    FIGHTER_1(0xFD, "Fighter 1"),
    PHYSICAL_2(0xFC, "Physical 2"),
    MAGICAL_2(0xFB, "Magical 2"),
    FIGHTER_2(0xFA, "Fighter 2"),
    ARENA_NORMAL(0xF9, "Arena"),
    ARENA_THIEF(0xF8, "Arena (Thief)"),
    BALLISTA(0xF7, "Ballista");

    private static final int CLASS_GROWTHS_OFFSET = 0x40246;
    private static final int GROWTHS_DATA_SIZE = 9;
    private static final int HP_OFFSET = 0;
    private static final int ATK_OFFSET = 1;
    private static final int MAG_OFFSET = 2;
    private static final int SKL_OFFSET = 3;
    private static final int SPD_OFFSET = 4;
    private static final int LCK_OFFSET = 7;
    private static final int DEF_OFFSET = 5;
    private static final int BLD_OFFSET = 6;
    private static final int MOV_OFFSET = 8;
    private final int OFFSET;
    private final String LABEL;
    private int hp;
    private int atk;
    private int mag;
    private int skl;
    private int spd;
    private int lck;
    private int def;
    private int bld;
    private int mov;

    AutoLevelType(int offset, String label) {
        this.OFFSET = offset;
        this.LABEL = label;
    }

    private void readAutoLevelType(Rom rom) {
        int relOffset = CLASS_GROWTHS_OFFSET + (0xFF - OFFSET) * GROWTHS_DATA_SIZE;
        hp = rom.getValueAt(relOffset + HP_OFFSET);
        atk = rom.getValueAt(relOffset + ATK_OFFSET);
        mag = rom.getValueAt(relOffset + MAG_OFFSET);
        skl = rom.getValueAt(relOffset + SKL_OFFSET);
        spd = rom.getValueAt(relOffset + SPD_OFFSET);
        lck = rom.getValueAt(relOffset + LCK_OFFSET);
        def = rom.getValueAt(relOffset + DEF_OFFSET);
        bld = rom.getValueAt(relOffset + BLD_OFFSET);
        mov = rom.getValueAt(relOffset + MOV_OFFSET);
    }

    public static void initializeAutoLevelTypes(Rom rom) {
        for (AutoLevelType type : values()) {
            type.readAutoLevelType(rom);
        }
    }

    public static AutoLevelType getAutoLevelTypeByOffset(int offset) {
        AutoLevelType type = AutoLevelType.BALLISTA;

        for(AutoLevelType t : values()) {
            if(t.OFFSET == offset) {
                type = t;
                break;
            }
        }

        return type;
    }

    public static ArrayList<Pair<AutoLevelType, Float>> getClassToAutoLevelType(CharacterClass characterClass) {
        ArrayList<Pair<AutoLevelType, Float>> options = new ArrayList<>();

        switch(characterClass) {
            case DARK_BISHOP:
            case SWORDMASTER:
            case SWORD_MASTER_F:
                options = new ArrayList<>(List.of(new Pair<>(FIGHTER_2, 1.0f))); break;
            case DUKE_KNIGHT:
            case DUKE_KNIGHT_DISMOUNTED:
                options = new ArrayList<>(List.of(new Pair<>(PHYSICAL_2, 1.0f))); break;
            case DANCER:
            case HUNTER:
            case PIRATE:
            case THIEF:
            case THIEF_F:
            case THIEF_FIGHTER:
            case THIEF_FIGHTER_F:
                options = new ArrayList<>(List.of(new Pair<>(FIGHTER_1, 1.0f))); break;
            case AXE_FIGHTER:
            case BERSERKER:
            case MOUNTAIN_THIEF:
            case MOUNTAIN_THIEF2:
            case WARRIOR:
                options = new ArrayList<>(List.of(new Pair<>(FIGHTER_1, 0.5f), new Pair<>(FIGHTER_2, 0.5f))); break;
            case WIND_MAGE:
            case WIND_MAGE_F:
                options = new ArrayList<>(List.of(new Pair<>(MAGICAL_1, 1.0f))); break;
            case BISHOP:
            case PRIEST:
            case PRIEST_F:
            case HIGH_PRIEST:
            case HIGH_PRIEST_F:
                options = new ArrayList<>(List.of(new Pair<>(MAGICAL_1, 0.5f), new Pair<>(FIGHTER_2, 0.5f))); break;
            case DARK_MAGE:
            case MAGE:
            case MAGE_F:
            case THUNDER_MAGE:
            case THUNDER_MAGE_F:
            case LOPTO_MAGE:
            case LOPTO_MAGE_F:
            case SAGE:
            case SAGE_F:
            case BARD:
                options = new ArrayList<>(List.of(new Pair<>(MAGICAL_1, 0.5f), new Pair<>(MAGICAL_2, 0.5f))); break;
            case AXE_KNIGHT:
            case AXE_KNIGHT_DISMOUNTED:
            case DRAGON_KNIGHT:
            case DRAGON_KNIGHT_DISMOUNTED:
            case DRAGON_KNIGHT_F:
            case DRAGON_KNIGHT_F_DISMOUNTED:
            case DRAGON_RIDER:
            case DRAGON_RIDER_DISMOUNTED:
            case DRAGON_RIDER_F:
            case DRAGON_RIDER_F_DISMOUNTED:
                options = new ArrayList<>(List.of(new Pair<>(PHYSICAL_1, 1.0f))); break;
            case SNIPER:
            case SNIPER_F:
                options = new ArrayList<>(List.of(new Pair<>(PHYSICAL_1, 0.5f), new Pair<>(FIGHTER_2, 0.5f))); break;
            case ARCH_KNIGHT:
            case ARCH_KNIGHT_DISMOUNTED:
            case ARCH_KNIGHT_F:
            case ARCH_KNIGHT_F_DISMOUNTED:
            case BOW_KNIGHT:
            case BOW_KNIGHT_DISMOUNTED:
            case BOW_KNIGHT_F:
            case BOW_KNIGHT_F_DISMOUNTED:
            case GREAT_KNIGHT:
            case GREAT_KNIGHT_DISMOUNTED:
            case LANCE_KNIGHT:
            case LANCE_KNIGHT_DISMOUNTED:
            case FORREST_KNIGHT:
            case FORREST_KNIGHT_DISMOUNTED:
            case MAGE_KNIGHT:
            case MAGE_KNIGHT2:
            case MAGE_KNIGHT_F:
            case MAGE_KNIGHT_F2:
            case PALADIN:
            case PALADIN_DISMOUNTED:
            case PALADIN_F:
            case PALADIN_F_DISMOUNTED:
            case PEGASUS_KNIGHT:
            case PEGASUS_KNIGHT_DISMOUNTED:
            case PEGASUS_RIDER:
            case PEGASUS_RIDER_DISMOUNTED:
            case SOCIAL_KNIGHT:
            case SOCIALKNIGHT_DISMOUNTED:
            case SOLDIER:
            case SWORD_ARMOR:
            case TROUBADOUR:
            case TROUBADOUR_DISMOUNTED:
            case LORD_KNIGHT:
            case LORD_KNIGHT_DISMOUNTED:
            case FREE_KNIGHT:
            case FREE_KNIGHT_DISMOUNTED:
                options = new ArrayList<>(List.of(new Pair<>(PHYSICAL_1, 0.5f), new Pair<>(PHYSICAL_2, 0.5f))); break;
            case AXE_ARMOR:
            case BOW_ARMOR:
            case GENERAL:
            case LANCE_ARMOR:
            case BARON:
            case BARON2:
            case EMPEROR:
                options = new ArrayList<>(List.of(new Pair<>(PHYSICAL_1, 0.5f), new Pair<>(PHYSICAL_2, 0.5f), new Pair<>(FIGHTER_2, 0.5f))); break;
            case BOW_FIGHTER:
            case BOW_FIGHTER_F:
            case ARCHER:
            case MERCENARY:
            case MERCENARY_F:
            case SWORD_FIGHTER:
            case SWORD_FIGHTER_F:
            case FORREST:
            case FORREST_F:
            case PRINCE:
            case DARK_PRINCE:
            case LORD:
            case JUNIOR_LORD:
                options = new ArrayList<>(List.of(new Pair<>(PHYSICAL_1, 0.5f), new Pair<>(FIGHTER_1, 0.5f), new Pair<>(FIGHTER_2, 0.5f))); break;
            case SISTER:
                options = new ArrayList<>(List.of(new Pair<>(PHYSICAL_1, 0.5f), new Pair<>(MAGICAL_1, 0.5f))); break;
        }

        if(options.isEmpty()) {
            throw new UnsupportedOperationException("Autolevel type. No options for "+ characterClass.getName());
        }

        return options;
    }

    public int getOffset() {
        return OFFSET;
    }

    public String getLabel() {
        return LABEL;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getMag() {
        return mag;
    }

    public int getSkl() {
        return skl;
    }

    public int getSpd() {
        return spd;
    }

    public int getLck() {
        return lck;
    }

    public int getDef() {
        return def;
    }

    public int getBld() {
        return bld;
    }

    public int getMov() {
        return mov;
    }

    @Override
    public String toString() {
        return String.format("AutoLevelType: %s. Hp: %d, Atk: %d, Mag: %d, Skl: %d, Spd: %d, Lck: %d, Def: %d, Bld: %d, Mov: %d",
                LABEL, hp, atk, mag, skl, spd, lck, def, bld, mov);
    }
}
