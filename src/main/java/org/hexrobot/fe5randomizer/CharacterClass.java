package org.hexrobot.fe5randomizer;

public enum CharacterClass {
    NOTHING(0x00, "Nothing/Separator"),
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
    LANCE_ARMOUR(0x1D, "Lance Armour"),
    AXE_ARMOUR(0x1E, "Axe Armour"),
    BOW_ARMOUR(0x1F, "Bow Armour"),
    SWORD_ARMOUR(0x20, "Sword Armour"),
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
    
    private CharacterClass(int offset, String name) {
        this.offset = offset;
        this.name = name;
    }
    
    public String getName() {
        return name;
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
            characterClass = CharacterClass.NOTHING;
        }
        
        return characterClass;
    }
}
