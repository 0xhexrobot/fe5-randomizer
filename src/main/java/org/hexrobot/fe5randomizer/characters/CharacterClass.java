package org.hexrobot.fe5randomizer.characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hexrobot.fe5randomizer.Rom;
import org.hexrobot.fe5randomizer.items.ItemType;

public enum CharacterClass {
    SOCIAL_KNIGHT(0x01, "Social Knight"),
    LANCE_KNIGHT(0x02, "Lance Knight"),
    ARCH_KNIGHT(0x03, "Arch Knight"),
    AXE_KNIGHT(0x04, "Axe Knight"),
    FREE_KNIGHT(0x05, "Free Knight"),
    TROUBADOUR(0x06, "Troubadour"),
    LORD_KNIGHT(0x07, "Lord Knight"),
    DUKE_KNIGHT(0x08, "Duke Knight"),
    MASTER_KNIGHT(0x09, "Master Knight"),
    PALADIN(0x0A, "Paladin"),
    PALADIN_F(0x0B, "Paladin (F)"),
    BOW_KNIGHT(0x0C, "Bow Knight"),
    FORREST_KNIGHT(0x0D, "Forrest Knight"),
    MAGE_KNIGHT(0x0E, "Mage Knight"),
    GREAT_KNIGHT(0x0F, "Great Knight"),
    PEGASUS_KNIGHT(0x10, "Pegasus Knight"),
    FALCON_KNIGHT(0x11, "Falcon Knight"),
    DRAGON_RIDER(0x12, "Dragon Rider"),
    DRAGON_KNIGHT(0x13, "Dragon Knight"),
    DRAGON_MASTER(0x14, "Dragon Master"),
    BOW_FIGHTER(0x15, "Bow Fighter"),
    SWORD_FIGHTER(0x16, "Sword Fighter"),
    SWORDMASTER(0x17, "Swordmaster"),
    SNIPER(0x18, "Sniper"),
    FORREST(0x19, "Forrest"),
    GENERAL(0x1A, "General"),
    EMPEROR(0x1B, "Emperor"),
    BARON(0x1C, "Baron"),
    LANCE_ARMOR(0x1D, "Lance Armor"),
    AXE_ARMOR(0x1E, "Axe Armor"),
    BOW_ARMOUR(0x1F, "Bow Armor"),
    SWORD_ARMOR(0x20, "Sword Armor"),
    BERSERKER(0x21, "Berserker"),
    MOUNTAIN_THIEF(0x22, "Mountain Thief"),
    MOUNTAIN_THIEF2(0x23, "Mountain Thief (2)"),
    WARRIOR(0x24, "Warrior"),
    HUNTER(0x25, "Hunter"),
    PIRATE(0x26, "Pirate"),
    JUNIOR_LORD(0x27, "Junior Lord"),
    MAGE_KNIGHT2(0x28, "Mage Knight"),
    LORD(0x29, "Lord"),
    PRINCE(0x2A, "Prince"),
    MAGE_KNIGHT_F(0x2B, "Mage Knight (F)"),
    BARON2(0x2C, "Baron (messed up battle sprite)"),
    DANCER(0x2D, "Dancer"),
    PRIEST(0x2E, "Priest"),
    MAGE(0x2F, "Mage"),
    LOPTO_MAGE(0x30, "Lopto Mage"),
    THUNDER_MAGE(0x31, "(Thunder) Mage"),
    WIND_MAGE(0x32, "(Wind) Mage"),
    HIGH_PRIEST(0x33, "High Priest"),
    BISHOP(0x34, "Bishop"),
    SAGE(0x35, "Sage"),
    BARD(0x36, "Bard"),
    SISTER(0x37, "Sister"),
    DARK_MAGE(0x38, "Dark Mage"),
    DARK_BISHOP(0x39, "Dark Bishop"),
    THIEF(0x3A, "Thief"),
    THIEF_FIGHTER(0x3B, "Thief Fighter"),
    CIVILIAN(0x3C, "Civilian"),
    LONG_ARCH(0x3D, "Long Arch"),
    IRON_ARCH(0x3E, "Iron Arch"),
    KILLER_ARCH(0x3F, "Killer Arch"),
    DARK_PRINCE(0x40, "Dark Prince"),
    AXE_FIGHTER(0x41, "Axe Fighter"),
    SOCIALKNIGHT_DISMOUNTED(0x42, "Socialknight (dismounted)"),
    LANCE_KNIGHT_DISMOUNTED(0x43, "Lance Knight (dismounted)"),
    ARCH_KNIGHT_DISMOUNTED(0x44, "Arch Knight (dismounted)"),
    AXE_KNIGHT_DISMOUNTED(0x45, "Axe Knight (dismounted)"),
    FREE_KNIGHT_DISMOUNTED(0x46, "Free Knight (dismounted)"),
    TROUBADOUR_DISMOUNTED(0x47, "Troubadour (dismounted)"),
    LORD_KNIGHT_DISMOUNTED(0x48, "Lord Knight (dismounted)"),
    DUKE_KNIGHT_DISMOUNTED(0x49, "Duke Knight (dismounted)"),
    MASTER_KNIGHT_DISMOUNTED(0x4A, "Master Knight (dismounted)"),
    PALADIN_DISMOUNTED(0x4B, "Paladin (dismounted)"),
    PALADIN_F_DISMOUNTED(0x4C, "Paladin (F) (dismounted)"),
    BOW_KNIGHT_DISMOUNTED(0x4D, "Bow Knight (dismounted)"),
    FORREST_KNIGHT_DISMOUNTED(0x4E, "Forrest Knight (dismounted)"),
    GREAT_KNIGHT_DISMOUNTED(0x4F, "Great Knight (dismounted)"),
    PEGASUS_KNIGHT_DISMOUNTED(0x50, "Pegasus Knight (dismounted)"),
    FALCON_KNIGHT_DISMOUNTED(0x51, "Falcon Knight (dismounted)"),
    DRAGON_RIDER_DISMOUNTED(0x52, "Dragon Rider (dismounted)"),
    DRAGON_KNIGHT_DISMOUNTED(0x53, "Dragon Knight (dismounted)"),
    DRAGON_MASTER_DISMOUNTED(0x54, "Dragon Master (dismounted)"),
    ARCH_KNIGHT_F(0x55, "Arch Knight (F)"),
    ARCH_KNIGHT_F_DISMOUNTED(0x56, "Arch Knight (F) (dismounted)"),
    BOW_KNIGHT_F(0x57, "Bow Knight (F)"),
    BOW_KNIGHT_F_DISMOUNTED(0x58, "Bow Knight (F) (dismounted)"),
    MASTER_KNIGHT_F(0x59, "Master Knight (F)"),
    MASTER_KNIGHT_F_DISMOUNTED(0x5A, "Master Knight (F) (dismounted)"),
    DRAGON_RIDER_F(0x5B, "Dragon Rider (F)"),
    DRAGON_RIDER_F_DISMOUNTED(0x5C, "Dragon Rider (F) (dismounted)"),
    DRAGON_KNIGHT_F(0x5D, "Dragon Knight (F)"),
    DRAGON_KNIGHT_F_DISMOUNTED(0x5E, "Dragon Knight (F) (dismounted)"),
    DRAGON_MASTER_F(0x5F, "Dragon Master (F)"),
    DRAGON_MASTER_F_DISMOUNTED(0x60, "Dragon Master (F) (dismounted)"),
    POISON_ARCH(0x61, "Poison Arch"),
    MAGE_F(0x62, "Mage (F)"),
    THUNDER_MAGE_F(0x63, "(Thunder) Mage (F)"),
    LOPTO_MAGE_F(0x64, "Lopto Mage (F)"),
    WIND_MAGE_F(0x65, "(Wind) Mage (F)"),
    MAGE_KNIGHT_F2(0x66, "Mage Knight (F)"),
    MAGE_KNIGHT_F_DISMOUNTED(0x67, "Mage Knight (F) (dismounted)"),
    PRIEST_F(0x68, "Priest (F)"),
    HIGH_PRIEST_F(0x69, "High Priest (F)"),
    SWORD_FIGHTER_F(0x6A, "Sword Fighter (F)"),
    FORREST_F(0x6B, "Forrest (F)"),
    SWORD_MASTER_F(0x6C, "Sword Master (F)"),
    BOW_FIGHTER_F(0x6D, "Bow Fighter (F)"),
    SNIPER_F(0x6E, "Sniper (F)"),
    THIEF_F(0x6F, "Thief (F)"),
    THIEF_FIGHTER_F(0x70, "Thief Fighter (F)"),
    MERCENARY(0x71, "Mercenary"),
    THIEF_FIGHTER_SPRITE(0x72, "Thief (Thief Fighter battle sprite)"),
    PEGASUS_RIDER(0x73, "Pegasus Rider"),
    PEGASUS_RIDER_DISMOUNTED(0x74, "Pegasus Rider (dismounted)"),
    SOLDIER(0x75, "Soldier"),
    ARCHER(0x76, "Archer"),
    MERCENARY_F(0x77, "Mercenary (F)");
    
    private int offset;
    private String name;
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
    
    private static final ArrayList<CharacterClass> THIEVES = new ArrayList<>(List.of(
            THIEF, THIEF_F, THIEF_FIGHTER, THIEF_FIGHTER_F));
    private static final ArrayList<CharacterClass> HEALERS = new ArrayList<>(List.of(
            TROUBADOUR, TROUBADOUR_DISMOUNTED, PALADIN, PALADIN_F, PRIEST, PRIEST_F, SISTER, SAGE, PALADIN_DISMOUNTED,
            PALADIN_F_DISMOUNTED, HIGH_PRIEST, HIGH_PRIEST_F, BISHOP, DARK_BISHOP, LOPTO_MAGE, LOPTO_MAGE_F,
            DARK_MAGE));
    private static final ArrayList<CharacterClass> UNPROMOTED = new ArrayList<>(List.of(
            SOCIAL_KNIGHT, LANCE_KNIGHT, ARCH_KNIGHT, AXE_KNIGHT, FREE_KNIGHT, TROUBADOUR, BOW_KNIGHT, PEGASUS_KNIGHT,
            DRAGON_RIDER, DRAGON_KNIGHT, BOW_FIGHTER, SWORD_FIGHTER, FORREST, LANCE_ARMOR, AXE_ARMOR, BOW_ARMOUR,
            SWORD_ARMOR, MOUNTAIN_THIEF, MOUNTAIN_THIEF2, HUNTER, PIRATE, MAGE_KNIGHT2, LORD, DANCER, PRIEST, MAGE,
            LOPTO_MAGE, THUNDER_MAGE, WIND_MAGE, BARD, SISTER, THIEF, AXE_FIGHTER, SOCIALKNIGHT_DISMOUNTED,
            LANCE_KNIGHT_DISMOUNTED, ARCH_KNIGHT_DISMOUNTED, AXE_KNIGHT_DISMOUNTED, FREE_KNIGHT_DISMOUNTED,
            TROUBADOUR_DISMOUNTED, BOW_KNIGHT_DISMOUNTED, PEGASUS_KNIGHT_DISMOUNTED, DRAGON_RIDER_DISMOUNTED,
            DRAGON_KNIGHT_DISMOUNTED, ARCH_KNIGHT_F, ARCH_KNIGHT_F_DISMOUNTED, BOW_KNIGHT_F, BOW_KNIGHT_F_DISMOUNTED,
            DRAGON_RIDER_F, DRAGON_RIDER_F_DISMOUNTED, DRAGON_KNIGHT_F, DRAGON_KNIGHT_F_DISMOUNTED, MAGE_F,
            THUNDER_MAGE_F, LOPTO_MAGE_F, WIND_MAGE_F, PRIEST_F, SWORD_FIGHTER_F, BOW_FIGHTER_F, THIEF_F, MERCENARY,
            PEGASUS_RIDER, PEGASUS_RIDER_DISMOUNTED, SOLDIER, ARCHER, MERCENARY_F));
    private static final ArrayList<CharacterClass> PROMOTED = new ArrayList<>(List.of(
            PALADIN, PALADIN_F, FORREST_KNIGHT, MAGE_KNIGHT, GREAT_KNIGHT, FALCON_KNIGHT, DRAGON_MASTER, SWORDMASTER,
            SNIPER, FORREST, GENERAL, EMPEROR, BARON, BERSERKER, WARRIOR, MAGE_KNIGHT2, PRINCE, MAGE_KNIGHT_F,
            BARON2, HIGH_PRIEST, BISHOP, SAGE, DARK_MAGE, DARK_BISHOP, THIEF_FIGHTER, DUKE_KNIGHT,
            DUKE_KNIGHT_DISMOUNTED, PALADIN_DISMOUNTED, PALADIN_F_DISMOUNTED, FORREST_KNIGHT_DISMOUNTED,
            GREAT_KNIGHT_DISMOUNTED, FALCON_KNIGHT_DISMOUNTED, DRAGON_MASTER_DISMOUNTED, DRAGON_MASTER_F,
            DRAGON_MASTER_F_DISMOUNTED, MAGE_KNIGHT_F2, MAGE_KNIGHT_F_DISMOUNTED, HIGH_PRIEST_F, FORREST_F,
            SWORD_MASTER_F, SNIPER_F, THIEF_FIGHTER_F));
    private static final ArrayList<CharacterClass> UNUSED_PROMOTED = new ArrayList<>(List.of(
            LORD_KNIGHT, MASTER_KNIGHT, GENERAL, EMPEROR, JUNIOR_LORD, BARON2, KILLER_ARCH,
            DARK_PRINCE, LORD_KNIGHT_DISMOUNTED, MASTER_KNIGHT_DISMOUNTED, MASTER_KNIGHT_F,
            MASTER_KNIGHT_F_DISMOUNTED));
    private static final ArrayList<CharacterClass> FEMALE_CLASSES = new ArrayList<>(List.of(
            TROUBADOUR, PALADIN_F, PEGASUS_KNIGHT, FALCON_KNIGHT, MAGE_KNIGHT_F, DANCER, SISTER, PALADIN_F_DISMOUNTED,
            ARCH_KNIGHT_F, ARCH_KNIGHT_F_DISMOUNTED, BOW_KNIGHT_F, BOW_KNIGHT_F_DISMOUNTED, MASTER_KNIGHT_F,
            MASTER_KNIGHT_F_DISMOUNTED, DRAGON_RIDER_F, DRAGON_RIDER_F_DISMOUNTED, DRAGON_KNIGHT_F,
            DRAGON_KNIGHT_F_DISMOUNTED, DRAGON_MASTER_F, DRAGON_MASTER_F_DISMOUNTED, MAGE_F, THUNDER_MAGE_F,
            LOPTO_MAGE_F, WIND_MAGE_F, PEGASUS_KNIGHT_DISMOUNTED, TROUBADOUR_DISMOUNTED, MAGE_KNIGHT_F2,
            MAGE_KNIGHT_F_DISMOUNTED, PRIEST_F, HIGH_PRIEST_F, SWORD_FIGHTER_F, FORREST_F, SWORD_MASTER_F,
            BOW_FIGHTER_F, SNIPER_F, THIEF_F, THIEF_FIGHTER_F, PEGASUS_RIDER, PEGASUS_RIDER_DISMOUNTED, MERCENARY_F));
    
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
    
    private CharacterClass(int offset, String name) {
        this.offset = offset;
        this.name = name;
    }
    
    public void readCharacterClass(Rom rom, int startingOffset) {
        int relOffset = startingOffset + (offset - 1) * CLASS_DATA_SIZE;
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

    public static ArrayList<CharacterClass> getUnpromotedClasses() {
        return new ArrayList<CharacterClass>(UNPROMOTED);
    }
    
    public static ArrayList<CharacterClass> getPromotedClasses() {
        return new ArrayList<CharacterClass>(PROMOTED);
    }
    
    public static ArrayList<CharacterClass> getUnusedPromotedClasses() {
        return new ArrayList<CharacterClass>(UNUSED_PROMOTED);
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
        text += String.format("Skill1: 0x%02X, Skill2: 0x%02X, Skill3: 0x%02X, (%s)",
                skills1, skills2, skills3, skillsText);
        
        return text;
    }
}
