package org.hexrobot.fe5randomizer.characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hexrobot.fe5randomizer.Rom;
import org.hexrobot.fe5randomizer.items.ItemType;

public enum CharacterClass {
    SOCIAL_KNIGHT(0x01, "Social Knight", 0x81, 0x0A),
    LANCE_KNIGHT(0x02, "Lance Knight", 0x87, 0x08),
    ARCH_KNIGHT(0x03, "Arch Knight", 0x86, 0x0C),
    AXE_KNIGHT(0x04, "Axe Knight", 0x84, 0x0F),
    FREE_KNIGHT(0x05, "Free Knight", 0x85, 0x0D),
    TROUBADOUR(0x06, "Troubadour", 0x89, 0x0B),
    LORD_KNIGHT(0x07, "Lord Knight", 0x88, -1),
    DUKE_KNIGHT(0x08, "Duke Knight", 0x83, -1),
    MASTER_KNIGHT(0x09, "Master Knight", 0x93, -1),
    PALADIN(0x0A, "Paladin", 0x8B, -1),
    PALADIN_F(0x0B, "Paladin (F)", 0x9C, -1),
    BOW_KNIGHT(0x0C, "Bow Knight", 0x8D, -1),
    FORREST_KNIGHT(0x0D, "Forrest Knight", 0x94, -1),
    MAGE_KNIGHT(0x0E, "Mage Knight", 0x8F, -1),
    GREAT_KNIGHT(0x0F, "Great Knight", 0x8E, -1),
    PEGASUS_KNIGHT(0x10, "Pegasus Knight", 0x91, -1),
    FALCON_KNIGHT(0x11, "Falcon Knight", 0x92, -1),
    DRAGON_RIDER(0x12, "Dragon Rider", 0x80, 0x13),
    DRAGON_KNIGHT(0x13, "Dragon Knight", 0x90, -1),
    DRAGON_MASTER(0x14, "Dragon Master", 0x8C, -1),
    BOW_FIGHTER(0x15, "Bow Fighter", 0x07, 0x18),
    SWORD_FIGHTER(0x16, "Sword Fighter", 0x04, 0x17),
    SWORDMASTER(0x17, "Swordmaster", 0x17, -1),
    SNIPER(0x18, "Sniper", 0x21, -1),
    FORREST(0x19, "Forrest", 0x18, -1),
    GENERAL(0x1A, "General", 0x10, -1),
    EMPEROR(0x1B, "Emperor", 0x22, -1),
    BARON(0x1C, "Baron", 0x1D, -1),
    LANCE_ARMOR(0x1D, "Lance Armor", 0x05, 0x1A),
    AXE_ARMOR(0x1E, "Axe Armor", 0x0A, 0x1A),
    BOW_ARMOR(0x1F, "Bow Armor", 0x27, 0x1A),
    SWORD_ARMOR(0x20, "Sword Armor", 0x26, 0x1A),
    BERSERKER(0x21, "Berserker", 0x06, -1),
    MOUNTAIN_THIEF(0x22, "Mountain Thief", 0x12, 0x24),
    MOUNTAIN_THIEF2(0x23, "Mountain Thief (2)", 0x12, 0x24),
    WARRIOR(0x24, "Warrior", 0x19, -1),
    HUNTER(0x25, "Hunter", 0x16, 0x24),
    PIRATE(0x26, "Pirate", 0x1B, 0x21),
    JUNIOR_LORD(0x27, "Junior Lord", 0x03, -1),
    MAGE_KNIGHT_DISMOUNTED(0x28, "Mage Knight (Dismounted)", 0x31, -1),
    LORD(0x29, "Lord", 0x30, 0x2A),
    PRINCE(0x2A, "Prince", 0x30, -1),
    MAGE_KNIGHT_F(0x2B, "Mage Knight (F)", 0x9D, -1),
    BARON2(0x2C, "Baron (messed up battle sprite)", 0x1D, -1),
    DANCER(0x2D, "Dancer", 0x0C, -1),
    PRIEST(0x2E, "Priest", 0x15, 0x33),
    MAGE(0x2F, "Mage", 0x01, 0x0E),
    LOPTO_MAGE(0x30, "Lopto Mage", 0x29, 0x38),
    THUNDER_MAGE(0x31, "(Thunder) Mage", 0x2B, 0x0E),
    WIND_MAGE(0x32, "(Wind) Mage", 0x13, 0x0E),
    HIGH_PRIEST(0x33, "High Priest", 0x2C, -1),
    BISHOP(0x34, "Bishop", 0x35, -1),
    SAGE(0x35, "Sage", 0x3C, -1),
    BARD(0x36, "Bard", 0x39, 0x35),
    SISTER(0x37, "Sister", 0x11, 0x67),
    DARK_MAGE(0x38, "Dark Mage", 0x2F, -1),
    DARK_BISHOP(0x39, "Dark Bishop", 0x2E, -1),
    THIEF(0x3A, "Thief", 0x0F, 0x3B),
    THIEF_FIGHTER(0x3B, "Thief Fighter", 0x3B, -1),
    CIVILIAN(0x3C, "Civilian", -1, -1),
    LONG_ARCH(0x3D, "Long Arch", 0x95, -1),
    IRON_ARCH(0x3E, "Iron Arch", 0x96, -1),
    KILLER_ARCH(0x3F, "Killer Arch", 0x97, -1),
    DARK_PRINCE(0x40, "Dark Prince", 0x3E, -1),
    AXE_FIGHTER(0x41, "Axe Fighter", 0x45, 0x71),
    SOCIALKNIGHT_DISMOUNTED(0x42, "Socialknight (dismounted)", 0x3F, 0x0A),
    LANCE_KNIGHT_DISMOUNTED(0x43, "Lance Knight (dismounted)", 0x3F, 0x08),
    ARCH_KNIGHT_DISMOUNTED(0x44, "Arch Knight (dismounted)", 0x43, 0x0C),
    AXE_KNIGHT_DISMOUNTED(0x45, "Axe Knight (dismounted)", 0x3F, 0x0F),
    FREE_KNIGHT_DISMOUNTED(0x46, "Free Knight (dismounted)", 0x49, 0x0D),
    TROUBADOUR_DISMOUNTED(0x47, "Troubadour (dismounted)", 0x40, 0x0B),
    LORD_KNIGHT_DISMOUNTED(0x48, "Lord Knight (dismounted)", 0x41, -1), //?
    DUKE_KNIGHT_DISMOUNTED(0x49, "Duke Knight (dismounted)", 0x41, -1), //?
    MASTER_KNIGHT_DISMOUNTED(0x4A, "Master Knight (dismounted)", 0x41, -1), //?
    PALADIN_DISMOUNTED(0x4B, "Paladin (dismounted)", 0x41, -1),
    PALADIN_F_DISMOUNTED(0x4C, "Paladin (F) (dismounted)", 0x42, -1),
    BOW_KNIGHT_DISMOUNTED(0x4D, "Bow Knight (dismounted)", 0x44, -1),
    FORREST_KNIGHT_DISMOUNTED(0x4E, "Forrest Knight (dismounted)", 0x4A, -1),
    GREAT_KNIGHT_DISMOUNTED(0x4F, "Great Knight (dismounted)", 0x49, -1), //?
    PEGASUS_KNIGHT_DISMOUNTED(0x50, "Pegasus Knight (dismounted)", 0x40, -1), //?
    FALCON_KNIGHT_DISMOUNTED(0x51, "Falcon Knight (dismounted)", 0x40, -1), //?
    DRAGON_RIDER_DISMOUNTED(0x52, "Dragon Rider (dismounted)", 0x49, 0x13), //?
    DRAGON_KNIGHT_DISMOUNTED(0x53, "Dragon Knight (dismounted)", 0x4A, -1), //?
    DRAGON_MASTER_DISMOUNTED(0x54, "Dragon Master (dismounted)", 0x49, -1), //?
    ARCH_KNIGHT_F(0x55, "Arch Knight (F)", 0x9F, 0x57),
    ARCH_KNIGHT_F_DISMOUNTED(0x56, "Arch Knight (F) (dismounted)", 0x47, 0x57),
    BOW_KNIGHT_F(0x57, "Bow Knight (F)", 0xA0, -1),
    BOW_KNIGHT_F_DISMOUNTED(0x58, "Bow Knight (F) (dismounted)", 0x48, -1),
    MASTER_KNIGHT_F(0x59, "Master Knight (F)", 0x9E, -1),
    MASTER_KNIGHT_F_DISMOUNTED(0x5A, "Master Knight (F) (dismounted)", 0x42, -1), //?
    DRAGON_RIDER_F(0x5B, "Dragon Rider (F)", 0x99, 0x5D),
    DRAGON_RIDER_F_DISMOUNTED(0x5C, "Dragon Rider (F) (dismounted)", 0x40, 0x5D), //?
    DRAGON_KNIGHT_F(0x5D, "Dragon Knight (F)", 0x9A, -1),
    DRAGON_KNIGHT_F_DISMOUNTED(0x5E, "Dragon Knight (F) (dismounted)", 0x40, -1), //?
    DRAGON_MASTER_F(0x5F, "Dragon Master (F)", 0x9B, -1),
    DRAGON_MASTER_F_DISMOUNTED(0x60, "Dragon Master (F) (dismounted)", 0x42, -1), //?
    POISON_ARCH(0x61, "Poison Arch", 0xA1, -1),
    MAGE_F(0x62, "Mage (F)", 0, 0x2B),
    THUNDER_MAGE_F(0x63, "(Thunder) Mage (F)", 0x2A, 0x2B),
    LOPTO_MAGE_F(0x64, "Lopto Mage (F)", 0x28, 0x38),
    WIND_MAGE_F(0x65, "(Wind) Mage (F)", 0x14, 0x2B),
    MAGE_KNIGHT_F_DISMOUNTED(0x66, "Mage Knight (F) (Dismounted)", 0x2D, -1),
    SAGE_F(0x67, "Sage (F)", 0x34, -1),
    PRIEST_F(0x68, "Priest (F)", 0x02, 0x69),
    HIGH_PRIEST_F(0x69, "High Priest (F)", 0x1E, -1),
    SWORD_FIGHTER_F(0x6A, "Sword Fighter (F)", 0x0D, 0x6C),
    FORREST_F(0x6B, "Forrest (F)", 0x1c, -1),
    SWORD_MASTER_F(0x6C, "Sword Master (F)", 0x1F, -1),
    BOW_FIGHTER_F(0x6D, "Bow Fighter (F)", 0x09, 0x6E),
    SNIPER_F(0x6E, "Sniper (F)", 0x20, -1),
    THIEF_F(0x6F, "Thief (F)", 0x3A, 0x70),
    THIEF_FIGHTER_F(0x70, "Thief Fighter (F)", 0x38, -1),
    MERCENARY(0x71, "Mercenary", 0x18, -1),
    THIEF_FIGHTER_SPRITE(0x72, "Thief (Thief Fighter battle sprite)", 0x3B, -1),
    PEGASUS_RIDER(0x73, "Pegasus Rider", 0x82, 0x10),
    PEGASUS_RIDER_DISMOUNTED(0x74, "Pegasus Rider (dismounted)", 0x40, 0x10),
    SOLDIER(0x75, "Soldier", 0x08, 0x1C),
    ARCHER(0x76, "Archer", 0x0B, 0x18),
    MERCENARY_F(0x77, "Mercenary (F)", 0x1C, -1);

    private static final int MOUNT_TABLE_OFFSET = 0x40000;
    private static final int MOUNT_TABLE_SIZE = 28;
    private static final int UNMOUNTED_OFFSET = 0;
    private static final int MOUNTED_OFFSET = 0x1C;
    private int offset;
    private String name;
    private int mapSprite;
    private int promotion;
    private int baseHp = -1;
    private int baseAtk = -1;
    private int baseMag = -1;
    private int baseSkl = -1;
    private int baseSpd = -1;
    private int baseDef = -1;
    private int baseBld = -1;
    private int baseMov = -1; 
    private WeaponProficiency baseSwordLv = new WeaponProficiency();
    private WeaponProficiency baseLanceLv = new WeaponProficiency();
    private WeaponProficiency baseAxeLv = new WeaponProficiency();
    private WeaponProficiency baseBowLv = new WeaponProficiency();
    private WeaponProficiency baseStaffLv = new WeaponProficiency();
    private WeaponProficiency baseFireLv = new WeaponProficiency();
    private WeaponProficiency baseThunderLv = new WeaponProficiency();
    private WeaponProficiency baseWindLv = new WeaponProficiency();
    private WeaponProficiency baseLightLv = new WeaponProficiency();
    private WeaponProficiency baseDarkLv = new WeaponProficiency();
    private int skills1 = -1;
    private int skills2 = -1;
    private int skills3 = -1;
    private ArrayList<Skill> skills = new ArrayList<Skill>();
    private Map<String, Object> oldValues = new HashMap<>();
    private CharacterClass mountedComplement = null;
    
    private static final ArrayList<CharacterClass> THIEVES = new ArrayList<>(List.of(
            THIEF, THIEF_F, THIEF_FIGHTER, THIEF_FIGHTER_F));
    private static final ArrayList<CharacterClass> HEALERS = new ArrayList<>(List.of(
            TROUBADOUR, TROUBADOUR_DISMOUNTED, PALADIN_F, PRIEST, PRIEST_F, SISTER, SAGE, PALADIN_DISMOUNTED,
            PALADIN_F_DISMOUNTED, HIGH_PRIEST, HIGH_PRIEST_F, BISHOP, DARK_BISHOP, LOPTO_MAGE, LOPTO_MAGE_F,
            DARK_MAGE, SAGE_F));
    private static final ArrayList<CharacterClass> UNPROMOTED = new ArrayList<>(List.of(
            SOCIAL_KNIGHT, LANCE_KNIGHT, ARCH_KNIGHT, AXE_KNIGHT, FREE_KNIGHT, TROUBADOUR, DRAGON_RIDER, BOW_FIGHTER,
            SWORD_FIGHTER, LANCE_ARMOR, AXE_ARMOR, BOW_ARMOR, SWORD_ARMOR, MOUNTAIN_THIEF, MOUNTAIN_THIEF2,
            HUNTER, PIRATE, LORD, DANCER, PRIEST, MAGE, LOPTO_MAGE, THUNDER_MAGE, WIND_MAGE, BARD, SISTER, THIEF,
            AXE_FIGHTER, SOCIALKNIGHT_DISMOUNTED, LANCE_KNIGHT_DISMOUNTED, ARCH_KNIGHT_DISMOUNTED,
            AXE_KNIGHT_DISMOUNTED, FREE_KNIGHT_DISMOUNTED, TROUBADOUR_DISMOUNTED, DRAGON_RIDER_DISMOUNTED,
            ARCH_KNIGHT_F, ARCH_KNIGHT_F_DISMOUNTED, DRAGON_RIDER_F, DRAGON_RIDER_F_DISMOUNTED, MAGE_F, THUNDER_MAGE_F,
            LOPTO_MAGE_F, WIND_MAGE_F, PRIEST_F, SWORD_FIGHTER_F, BOW_FIGHTER_F, THIEF_F, PEGASUS_RIDER,
            PEGASUS_RIDER_DISMOUNTED, SOLDIER, ARCHER));
    private static final ArrayList<CharacterClass> PROMOTED = new ArrayList<>(List.of(
            PALADIN, PALADIN_F, FORREST_KNIGHT, BOW_KNIGHT, MAGE_KNIGHT, GREAT_KNIGHT, DRAGON_KNIGHT, PEGASUS_KNIGHT,
            SWORDMASTER, SNIPER, FORREST, GENERAL, BARON, BERSERKER, WARRIOR, MAGE_KNIGHT_DISMOUNTED, MAGE_KNIGHT_F, PRINCE,
            HIGH_PRIEST, BISHOP, SAGE, DARK_MAGE, DARK_BISHOP, THIEF_FIGHTER, DUKE_KNIGHT, DUKE_KNIGHT_DISMOUNTED,
            BOW_KNIGHT_DISMOUNTED, PALADIN_DISMOUNTED, PALADIN_F_DISMOUNTED, BOW_KNIGHT_F, BOW_KNIGHT_F_DISMOUNTED,
            PEGASUS_KNIGHT_DISMOUNTED, FORREST_KNIGHT_DISMOUNTED, DRAGON_KNIGHT_DISMOUNTED, GREAT_KNIGHT_DISMOUNTED,
            DRAGON_KNIGHT_F, DRAGON_KNIGHT_F_DISMOUNTED, MAGE_KNIGHT_F_DISMOUNTED, SAGE_F, HIGH_PRIEST_F, FORREST_F,
            SWORD_MASTER_F, SNIPER_F, THIEF_FIGHTER_F, MERCENARY, MERCENARY_F));
    private static final ArrayList<CharacterClass> UNUSED = new ArrayList<>(List.of(
            LORD_KNIGHT, MASTER_KNIGHT, EMPEROR, JUNIOR_LORD, KILLER_ARCH, DARK_PRINCE, LORD_KNIGHT_DISMOUNTED,
            MASTER_KNIGHT_DISMOUNTED, MASTER_KNIGHT_F, FALCON_KNIGHT_DISMOUNTED, MASTER_KNIGHT_F_DISMOUNTED,
            DRAGON_MASTER_F_DISMOUNTED, DRAGON_MASTER_F, DRAGON_MASTER, DRAGON_MASTER_DISMOUNTED, FALCON_KNIGHT));
    private static final ArrayList<CharacterClass> FEMALE_CLASSES = new ArrayList<>(List.of(
            TROUBADOUR, PALADIN_F, PEGASUS_KNIGHT, FALCON_KNIGHT, MAGE_KNIGHT_F, DANCER, SISTER, PALADIN_F_DISMOUNTED,
            ARCH_KNIGHT_F, ARCH_KNIGHT_F_DISMOUNTED, BOW_KNIGHT_F, BOW_KNIGHT_F_DISMOUNTED, MASTER_KNIGHT_F,
            MASTER_KNIGHT_F_DISMOUNTED, DRAGON_RIDER_F, DRAGON_RIDER_F_DISMOUNTED, DRAGON_KNIGHT_F,
            DRAGON_KNIGHT_F_DISMOUNTED, DRAGON_MASTER_F, DRAGON_MASTER_F_DISMOUNTED, MAGE_F, THUNDER_MAGE_F,
            LOPTO_MAGE_F, WIND_MAGE_F, PEGASUS_KNIGHT_DISMOUNTED, FALCON_KNIGHT_DISMOUNTED, TROUBADOUR_DISMOUNTED,
            MAGE_KNIGHT_F_DISMOUNTED, SAGE_F, PRIEST_F, HIGH_PRIEST_F, SWORD_FIGHTER_F, FORREST_F, SWORD_MASTER_F, BOW_FIGHTER_F,
            SNIPER_F, THIEF_F, THIEF_FIGHTER_F, PEGASUS_RIDER, PEGASUS_RIDER_DISMOUNTED, MERCENARY_F));
    private static final ArrayList<CharacterClass> MOUNTED = new ArrayList<>(List.of(
            DRAGON_KNIGHT, FORREST_KNIGHT, PEGASUS_KNIGHT, MASTER_KNIGHT_F, DUKE_KNIGHT, MAGE_KNIGHT, DRAGON_MASTER,
            AXE_KNIGHT, MASTER_KNIGHT, DRAGON_KNIGHT_F, MAGE_KNIGHT_F, LORD_KNIGHT, BOW_KNIGHT_F, LANCE_KNIGHT,
            PALADIN_F, ARCH_KNIGHT_F, DRAGON_RIDER_F, FALCON_KNIGHT, FREE_KNIGHT, SOCIAL_KNIGHT, ARCH_KNIGHT, PALADIN,
            DRAGON_MASTER_F, GREAT_KNIGHT, DRAGON_RIDER, TROUBADOUR, BOW_KNIGHT, PEGASUS_RIDER));
    private static final ArrayList<CharacterClass> DISMOUNTED = new ArrayList<>(List.of(
            SOCIALKNIGHT_DISMOUNTED, LANCE_KNIGHT_DISMOUNTED, ARCH_KNIGHT_DISMOUNTED, AXE_KNIGHT_DISMOUNTED,
            FREE_KNIGHT_DISMOUNTED, TROUBADOUR_DISMOUNTED, DRAGON_RIDER_DISMOUNTED, ARCH_KNIGHT_F_DISMOUNTED,
            DRAGON_RIDER_F_DISMOUNTED, PEGASUS_RIDER_DISMOUNTED, DUKE_KNIGHT_DISMOUNTED, BOW_KNIGHT_DISMOUNTED,
            PALADIN_DISMOUNTED, PALADIN_F_DISMOUNTED, BOW_KNIGHT_F_DISMOUNTED, PEGASUS_KNIGHT_DISMOUNTED,
            FORREST_KNIGHT_DISMOUNTED, DRAGON_KNIGHT_DISMOUNTED, GREAT_KNIGHT_DISMOUNTED, DRAGON_KNIGHT_F_DISMOUNTED,
            MAGE_KNIGHT_DISMOUNTED, MAGE_KNIGHT_F_DISMOUNTED));
    private static final ArrayList<CharacterClass> FLYING = new ArrayList<>(List.of(
            DRAGON_KNIGHT, PEGASUS_KNIGHT, DRAGON_MASTER, DRAGON_KNIGHT_F, DRAGON_RIDER_F, FALCON_KNIGHT,
            DRAGON_MASTER_F, DRAGON_RIDER, PEGASUS_RIDER));
    private static final ArrayList<CharacterClass> PROMOTED_UNMOUNTED_SWORD_USERS = new ArrayList<>(List.of(
            SWORDMASTER, FORREST, GENERAL, BARON, PRINCE, THIEF_FIGHTER, FORREST_F, SWORD_MASTER_F, THIEF_FIGHTER_F,
            MERCENARY, MERCENARY_F));
    private static final ArrayList<CharacterClass> PRIMARY_MAGIC = new ArrayList<>(List.of(
            TROUBADOUR, PRIEST, MAGE, LOPTO_MAGE, THUNDER_MAGE, WIND_MAGE, BARD, SISTER, TROUBADOUR_DISMOUNTED,
            MAGE_F, THUNDER_MAGE_F, LOPTO_MAGE_F, WIND_MAGE_F, PRIEST_F, PALADIN_F, MAGE_KNIGHT, MAGE_KNIGHT_DISMOUNTED,
            MAGE_KNIGHT_F, HIGH_PRIEST, BISHOP, SAGE, DARK_MAGE, DARK_BISHOP, PALADIN_F_DISMOUNTED, MAGE_KNIGHT_F_DISMOUNTED,
            SAGE_F, HIGH_PRIEST_F));
    
    private static final int CHARACTER_CLASSES_OFFSET = 0x30000;
    private static final int CLASS_DATA_SIZE = 36;
    private static final int BASE_HP_OFFSET = 0x0;
    private static final int BASE_ATK_OFFSET = 0x01;
    private static final int BASE_MAG_OFFSET = 0x02;
    private static final int BASE_SKL_OFFSET = 0x03;
    private static final int BASE_SPD_OFFSET = 0x04;
    private static final int BASE_DEF_OFFSET = 0x05;
    private static final int BASE_BLD_OFFSET = 0x06;
    private static final int BASE_MOV_OFFSET = 0x07;
    private static final int BASE_SWORD_LV_OFFSET = 0x09;
    private static final int BASE_LANCE_LV_OFFSET = 0x0A;
    private static final int BASE_AXE_LV_OFFSET = 0x0B;
    private static final int BASE_BOW_LV_OFFSET = 0x0C;
    private static final int BASE_STAFF_LV_OFFSET = 0x0D;
    private static final int BASE_FIRE_LV_OFFSET = 0x0E;
    private static final int BASE_THUNDER_LV_OFFSET = 0x0F;
    private static final int BASE_WIND_LV_OFFSET = 0x10;
    private static final int BASE_LIGHT_LV_OFFSET = 0x11;
    private static final int BASE_DARK_LV_OFFSET = 0x12;
    private static final int SKILLS_1_OFFSET = 0x13;
    private static final int SKILLS_2_OFFSET = 0x14;
    private static final int SKILLS_3_OFFSET = 0x15;
    
    private CharacterClass(int offset, String name, int mapSprite, int promotion) {
        this.offset = offset;
        this.name = name;
        this.mapSprite = mapSprite;
        this.promotion = promotion;
    }
    
    private void readCharacterClass(Rom rom) {
        int relOffset = CHARACTER_CLASSES_OFFSET + (offset - 1) * CLASS_DATA_SIZE;
        baseHp = rom.getValueAt(relOffset + BASE_HP_OFFSET);
        baseAtk = rom.getValueAt(relOffset + BASE_ATK_OFFSET);
        baseMag = rom.getValueAt(relOffset + BASE_MAG_OFFSET);
        baseSkl = rom.getValueAt(relOffset + BASE_SKL_OFFSET);
        baseSpd = rom.getValueAt(relOffset + BASE_SPD_OFFSET);
        baseDef = rom.getValueAt(relOffset + BASE_DEF_OFFSET);
        baseBld = rom.getValueAt(relOffset + BASE_BLD_OFFSET);
        baseMov = rom.getValueAt(relOffset + BASE_MOV_OFFSET);
        baseSwordLv.setAmount(rom.getValueAt(relOffset + BASE_SWORD_LV_OFFSET));
        baseLanceLv.setAmount(rom.getValueAt(relOffset + BASE_LANCE_LV_OFFSET));
        baseAxeLv.setAmount(rom.getValueAt(relOffset + BASE_AXE_LV_OFFSET));
        baseBowLv.setAmount(rom.getValueAt(relOffset + BASE_BOW_LV_OFFSET));
        baseStaffLv.setAmount(rom.getValueAt(relOffset + BASE_STAFF_LV_OFFSET));
        baseFireLv.setAmount(rom.getValueAt(relOffset + BASE_FIRE_LV_OFFSET));
        baseThunderLv.setAmount(rom.getValueAt(relOffset + BASE_THUNDER_LV_OFFSET));
        baseWindLv.setAmount(rom.getValueAt(relOffset + BASE_WIND_LV_OFFSET));
        baseLightLv.setAmount(rom.getValueAt(relOffset + BASE_LIGHT_LV_OFFSET));
        baseDarkLv.setAmount(rom.getValueAt(relOffset + BASE_DARK_LV_OFFSET));
        skills1 = rom.getValueAt(relOffset + SKILLS_1_OFFSET);
        skills2 = rom.getValueAt(relOffset + SKILLS_2_OFFSET);
        skills3 = rom.getValueAt(relOffset + SKILLS_3_OFFSET);
        skills = Skill.getSkills(skills1, skills2, skills3);
    }
    
    public static void initializeCharacterClasses(Rom rom) {
        for(CharacterClass characterClass : values()) {
            characterClass.readCharacterClass(rom);
        }

        // initialize mount data
        for(int i = 0; i < MOUNT_TABLE_SIZE; i++) {
            int unmountOffset = MOUNT_TABLE_OFFSET + UNMOUNTED_OFFSET + i;
            int mountOffset = MOUNT_TABLE_OFFSET + MOUNTED_OFFSET + i;

            CharacterClass unmountedClass = CharacterClass.findById(rom.getValueAt(unmountOffset));
            CharacterClass mountedClass = CharacterClass.findById(rom.getValueAt(mountOffset));

            unmountedClass.mountedComplement = mountedClass;
            mountedClass.mountedComplement = unmountedClass;
        }
    }

    public CharacterClass getMountedComplement() {
        return mountedComplement;
    }

    public int getOffset() {
        return offset;
    }
    
    public String getName() {
        return name;
    }
    
    public int getBaseHp() {
        return baseHp;
    }

    public int getBaseAtk() {
        return baseAtk;
    }

    public int getBaseMag() {
        return baseMag;
    }

    public int getBaseSkl() {
        return baseSkl;
    }

    public int getBaseSpd() {
        return baseSpd;
    }

    public int getBaseDef() {
        return baseDef;
    }

    public int getBaseBld() {
        return baseBld;
    }

    public int getBaseMov() {
        return baseMov;
    }

    public WeaponProficiency getBaseSwordLv() {
        return baseSwordLv;
    }

    public WeaponProficiency getBaseLanceLv() {
        return baseLanceLv;
    }

    public WeaponProficiency getBaseAxeLv() {
        return baseAxeLv;
    }

    public WeaponProficiency getBaseBowLv() {
        return baseBowLv;
    }

    public WeaponProficiency getBaseStaffLv() {
        return baseStaffLv;
    }

    public WeaponProficiency getBaseFireLv() {
        return baseFireLv;
    }

    public WeaponProficiency getBaseThunderLv() {
        return baseThunderLv;
    }

    public WeaponProficiency getBaseWindLv() {
        return baseWindLv;
    }

    public WeaponProficiency getBaseLightLv() {
        return baseLightLv;
    }

    public WeaponProficiency getBaseDarkLv() {
        return baseDarkLv;
    }

    public int getSkills1() {
        return skills1;
    }

    public int getSkills2() {
        return skills2;
    }

    public int getSkills3() {
        return skills3;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }
    
    public int getMapSprite() {
        return mapSprite;
    }
    
    public Map<String, Object> getOldValues() {
        return oldValues;
    }

    public boolean isPromoted() {
        return PROMOTED.contains(this);
    }
    
    public boolean isUnpromoted() {
        return UNPROMOTED.contains(this);
    }
    
    public boolean isThief() {
        return THIEVES.contains(this);
    }
    
    public boolean isHealer() {
        return HEALERS.contains(this);
    }
    
    public boolean isFemaleClass() {
        return FEMALE_CLASSES.contains(this);
    }

    public boolean isDismounted() {
        return DISMOUNTED.contains(this);
    }

    public boolean isMounted() {
        return MOUNTED.contains(this);
    }

    public boolean isPrimaryMagic() {
        return PRIMARY_MAGIC.contains(this);
    }
    
    public static ArrayList<CharacterClass> getThiefClasses() {
        return new ArrayList<>(THIEVES);
    }
    
    public static ArrayList<CharacterClass> getHealerClasses() {
        return new ArrayList<>(HEALERS);
    }
    
    public boolean canUseWeaponType(ItemType weaponType) {
        boolean canUse = false;
        final int MIN_SKILL_LV = 50;
        
        switch(weaponType) {
        case SWORD:
        case FIRE_SWORD:
        case THUNDER_SWORD:
        case WIND_SWORD:
        case LIGHT_SWORD:
            canUse = baseSwordLv.getAmount() >= MIN_SKILL_LV;
            break;
        case LANCE:
            canUse = baseLanceLv.getAmount() >= MIN_SKILL_LV;
            break;
        case AXE:
            canUse = baseAxeLv.getAmount() >= MIN_SKILL_LV;
            break;
        case BOW:
            canUse = baseBowLv.getAmount() >= MIN_SKILL_LV;
            break;
        case STAFF:
            canUse = baseStaffLv.getAmount() >= MIN_SKILL_LV;
            break;
        case FIRE:
            canUse = baseFireLv.getAmount() >= MIN_SKILL_LV;
            break;
        case THUNDER:
            canUse = baseThunderLv.getAmount() >= MIN_SKILL_LV;
            break;
        case WIND:
            canUse = baseWindLv.getAmount() >= MIN_SKILL_LV;
            break;
        case LIGHT:
            canUse = baseLightLv.getAmount() >= MIN_SKILL_LV;
            break;
        case DARK:
            canUse = baseDarkLv.getAmount() >= MIN_SKILL_LV;
            break;
        default:
            break;
        }
        
        return canUse;
    }
    
    public ArrayList<ItemType> getUsableWeaponTypes() {
        ArrayList<ItemType> weaponTypes = new ArrayList<>();
        
        for(ItemType itemType : ItemType.getWeaponTypes()) {
            if(canUseWeaponType(itemType)) {
                weaponTypes.add(itemType);
            }
        }
        
        return weaponTypes;
    }

    public static int getGenericPortrait(CharacterClass characterClass) {
        int portrait = 0;

        switch(characterClass) {
            case ARCH_KNIGHT:
            case ARCH_KNIGHT_DISMOUNTED:
            case ARCH_KNIGHT_F:
            case ARCH_KNIGHT_F_DISMOUNTED:
                portrait = 0xA5; break;
            case ARCHER:
                portrait = 0xF7; break;
            case AXE_ARMOR:
                portrait = 0xC0; break;
            case AXE_FIGHTER:
                portrait = 0xDC; break;
            case AXE_KNIGHT:
            case AXE_KNIGHT_DISMOUNTED:
                portrait = 0xA6; break;
            case BARD:
                portrait = 0xD2; break;
            case BERSERKER:
                portrait = 0xC3; break;
            case BISHOP:
                portrait = 0xD1; break;
            case BOW_ARMOR:
                portrait = 0xC1; break;
            case BOW_FIGHTER:
                portrait = 0xB7; break;
            case BOW_FIGHTER_F:
                portrait = 0xEF; break;
            case BOW_KNIGHT:
            case BOW_KNIGHT_DISMOUNTED:
            case BOW_KNIGHT_F:
            case BOW_KNIGHT_F_DISMOUNTED:
                portrait = 0xAE; break;
            case DANCER:
                portrait = 0xCA; break;
            case DARK_BISHOP:
                portrait = 0xD5; break;
            case DARK_MAGE:
                portrait = 0xD4; break;
            case DRAGON_KNIGHT:
            case DRAGON_KNIGHT_DISMOUNTED:
            case DRAGON_KNIGHT_F:
            case DRAGON_KNIGHT_F_DISMOUNTED:
                portrait = 0xB5; break;
            case DRAGON_RIDER:
            case DRAGON_RIDER_DISMOUNTED:
            case DRAGON_RIDER_F:
            case DRAGON_RIDER_F_DISMOUNTED:
                portrait = 0xB4; break;
            case DUKE_KNIGHT:
            case DUKE_KNIGHT_DISMOUNTED:
                portrait = 0xAA; break;
            case FORREST:
            case FORREST_F:
                portrait = 0xB9; break;
            case FORREST_KNIGHT:
            case FORREST_KNIGHT_DISMOUNTED:
            case FREE_KNIGHT:
            case FREE_KNIGHT_DISMOUNTED:
                portrait = 0xA7; break;
            case GENERAL:
            case BARON:
                portrait = 0xBC; break;
            case GREAT_KNIGHT:
            case GREAT_KNIGHT_DISMOUNTED:
                portrait = 0xB1; break;
            case HIGH_PRIEST:
            case HIGH_PRIEST_F:
                portrait = 0xCB; break;
            case HUNTER:
                portrait = 0xC7; break;
            case IRON_ARCH:
                portrait = 0xDA; break;
            case LANCE_ARMOR:
                portrait = 0xBF; break;
            case LANCE_KNIGHT:
            case LANCE_KNIGHT_DISMOUNTED:
                portrait = 0xA4; break;
            case LONG_ARCH:
                portrait = 0xD9; break;
            case LOPTO_MAGE:
            case LOPTO_MAGE_F:
                portrait = 0xD4; break;
            case LORD:
            case JUNIOR_LORD:
                portrait = 0xB9; break;
            case LORD_KNIGHT:
            case LORD_KNIGHT_DISMOUNTED:
                portrait = 0xA9; break;
            case MAGE:
            case MAGE_F:
                portrait = 0xCC; break;
            case MAGE_KNIGHT:
            case MAGE_KNIGHT_DISMOUNTED:
            case MAGE_KNIGHT_F:
            case MAGE_KNIGHT_F_DISMOUNTED:
                portrait = 0xB0; break;
            case MERCENARY:
                portrait = 0xF3; break;
            case MERCENARY_F:
                portrait = 0xF8; break;
            case MOUNTAIN_THIEF:
            case MOUNTAIN_THIEF2:
                portrait = 0xC4; break;
            case PALADIN:
            case PALADIN_DISMOUNTED:
            case PALADIN_F:
            case PALADIN_F_DISMOUNTED:
                portrait = 0xAC; break;
            case PEGASUS_RIDER:
            case PEGASUS_RIDER_DISMOUNTED:
            case PEGASUS_KNIGHT:
            case PEGASUS_KNIGHT_DISMOUNTED:
                portrait = 0xF5; break;
            case PIRATE:
                portrait = 0xC8; break;
            case POISON_ARCH:
                portrait = 0xE3; break;
            case PRIEST:
                portrait = 0xCB; break;
            case PRIEST_F:
                portrait = 0xEA; break;
            case PRINCE:
                portrait = 0xB9; break;
            case SAGE:
            case SAGE_F:
                portrait = 0xE9; break;
            case SISTER:
                portrait = 0xCB; break;
            case SNIPER:
                portrait = 0xBA; break;
            case SNIPER_F:
                portrait = 0xF0; break;
            case SOCIAL_KNIGHT:
            case SOCIALKNIGHT_DISMOUNTED:
                portrait = 0xA3; break;
            case SOLDIER:
                portrait = 0xF6; break;
            case SWORD_ARMOR:
                portrait = 0xC2; break;
            case SWORD_FIGHTER:
                portrait = 0xB8; break;
            case SWORD_FIGHTER_F:
                portrait = 0xEC; break;
            case SWORDMASTER:
            case SWORD_MASTER_F:
                portrait = 0xB9; break;
            case THIEF:
            case THIEF_F:
                portrait = 0xF4; break;
            case THIEF_FIGHTER:
            case THIEF_FIGHTER_F:
                portrait = 0xD7; break;
            case THUNDER_MAGE:
                portrait = 0xCC; break;
            case THUNDER_MAGE_F:
                portrait = 0xE5; break;
            case TROUBADOUR:
            case TROUBADOUR_DISMOUNTED:
                portrait = 0xA8; break;
            case WARRIOR:
                portrait = 0xC6; break;
            case WIND_MAGE:
            case WIND_MAGE_F:
                portrait = 0xCF; break;
        }

        if(portrait == 0) {
            System.out.println("Warning: No portrait for " + characterClass.name);
        }

        return portrait;
    }

    public static ArrayList<CharacterClass> getUnpromotedClasses() {
        return new ArrayList<>(UNPROMOTED);
    }
    
    public static ArrayList<CharacterClass> getPromotedClasses() {
        return new ArrayList<>(PROMOTED);
    }
    
    public static ArrayList<CharacterClass> getUnusedClasses() {
        return new ArrayList<>(UNUSED);
    }
    
    public static ArrayList<CharacterClass> getMountedClasses() {
        return new ArrayList<>(MOUNTED);
    }

    public static ArrayList<CharacterClass> getDismountedClasses() {
        return new ArrayList<>(DISMOUNTED);
    }

    public static ArrayList<CharacterClass> getFlyingClasses() {
        return new ArrayList<>(FLYING);
    }

    public static ArrayList<CharacterClass> getPromotedUnmountedSwordUsers() {
        return new ArrayList<>(PROMOTED_UNMOUNTED_SWORD_USERS);
    }
    
    public static ArrayList<CharacterClass> getCanTraverseWaterClasses() {
        ArrayList<CharacterClass> canTraverseWater = new ArrayList<>();
        canTraverseWater.add(PIRATE);
        
        return canTraverseWater;
    }

    public CharacterClass getPromotion() {
        CharacterClass promotion = null;
        
        if(this.promotion != -1) {
            promotion = CharacterClass.findById(this.promotion);
        }
        
        return promotion;
    }

    public static CharacterClass findById(int offset) {
        CharacterClass characterClass = null;
        
        for(CharacterClass charClass : CharacterClass.values()) {
            if(charClass.offset == offset) {
                characterClass = charClass;
                break;
            }
        }
        
        if(characterClass == null) {
            System.out.println(String.format("WARNING: Offset 0x%02X in CharacterClass was not found.", offset));
            characterClass = CharacterClass.POISON_ARCH;
        }
        
        return characterClass;
    }
    
    @Override
    public String toString() {
        String text = "[CharacterClass]";
        
        String skillsText = "";
        
        for(int i = 0; i < skills.size(); i++) {
            skillsText += skills.get(i).getName();
                    
            if(i < skills.size() - 1) {
                 skillsText += ", ";
            }
        }
        
        text += String.format("%s(0x%04X)", name, offset);
        text += String.format("Bases HP: %d, Str: %d, Mag: %d, Skl: %d, Spd: %d, Def: %d, Bld: %d, Mov: %d\n",
                baseHp, baseAtk, baseMag, baseSkl, baseSpd, baseDef, baseBld, baseMov);
        text += String.format("Base Wpn level Sword: %d, Lance: %d Axe: %d, Bow: %d, Staff: %d, Fire: %d, Thunder: %d, Wind: %d, Light: %d, Dark: %d\n",
                baseSwordLv.getAmount(), baseLanceLv.getAmount(), baseAxeLv.getAmount(), baseBowLv.getAmount(), baseStaffLv.getAmount(), baseFireLv.getAmount(), baseThunderLv.getAmount(), baseWindLv.getAmount(), baseLightLv.getAmount(), baseDarkLv.getAmount());
        text += String.format("Skill1: 0x%02X, Skill2: 0x%02X, Skill3: 0x%02X, (%s)\n",
                skills1, skills2, skills3, skillsText);
        text += String.format("Mounted complement: %s",
                mountedComplement != null ? mountedComplement.name : "--");
        
        return text;
    }
}
