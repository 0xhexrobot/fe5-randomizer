package org.hexrobot.fe5randomizer;

import org.hexrobot.fe5randomizer.Character;
import org.hexrobot.fe5randomizer.items.ItemClassification;
import org.hexrobot.fe5randomizer.items.ItemType;
import org.hexrobot.fe5randomizer.items.ItemUseEffect;
import org.hexrobot.fe5randomizer.items.WeaponBladeEffect;
import org.hexrobot.fe5randomizer.items.WeaponEffectiveness;
import org.hexrobot.fe5randomizer.items.WeaponRange;
import org.hexrobot.fe5randomizer.items.WeaponRank;
import org.hexrobot.fe5randomizer.items.WeaponSkill1;
import org.hexrobot.fe5randomizer.items.WeaponSkill2;
import org.hexrobot.fe5randomizer.items.WeaponStatBonus;

public enum Character {
    LEAF(0x0001, "Leaf"),
    FINN(0x0002, "Finn"),
    OTHIN(0x0003, "Othin"),
    HALVAN(0x0004, "Halvan"),
    EYVEL(0x0005, "Eyvel"),
    DAGUDAR(0x0006, "Dagudar"),
    RALF(0x0007, "Ralf"),
    MARTY(0x0008, "Marty"),
    RONAN(0x0009, "Ronan"),
    MIRANDA(0x000A, "Miranda"),
    SAPHY(0x000B, "Saphy"),
    LARA(0x000C, "Lara"),
    BRIGHTON(0x000D, "Brighton"),
    FELGUS(0x000E, "Felgus"),
    EDA(0x000F, "Eda"),
    ASVEL(0x0010, "Asvel"),
    MACHYUA(0x0011, "Machyua"),
    HICKS(0x0012, "Hicks"),
    NANNA(0x0013, "Nanna"),
    SELFINA(0x0014, "Selfina"),
    DALSHEIN(0x0015, "Dalshein"),
    CARRION(0x0016, "Carrion"),
    SHIVA(0x0017, "Shiva"),
    PAHN(0x0018, "Pahn"),
    GLADE(0x0019, "Glade"),
    KEIN(0x001A, "Kein"),
    ALBA(0x001B, "Alba"),
    ROBERTO(0x001C, "Roberto"),
    FRED(0x001D, "Fred"),
    ORUEN(0x001E, "Oruen"),
    SETY_CH23(0x001F, "Sety (Chapter 23)"),
    RIFIS(0x0020, "Rifis"),
    KARIN(0x0021, "Karin"),
    DEAN(0x0022, "Dean"),
    SHANAM(0x0023, "Shanam"),
    TREWD(0x0024, "Trewd"),
    TANYA(0x0025, "Tanya"),
    LINONAN(0x0026, "Linonan"),
    MISHA(0x0027, "Misha"),
    SEIRAM(0x0028, "Seiram"),
    SLEUF(0x0029, "Sleuf"),
    MAREETA(0x002A, "Mareeta"),
    TINA(0x002B, "Tina"),
    GUNNA(0x002C, "Gunna_Bishop from dialogue)"),
    AMALDA(0x002D, "Amalda"),
    CONOMORE(0x002E, "Conomore"),
    HOMEROS(0x002F, "Homeros"),
    DELMUD(0x0030, "Delmud"),
    SARA(0x0031, "Sara"),
    CYAS(0x0032, "Cyas"),
    LEIDRICK(0x0033, "Leidrick"),
    YURIUS(0x0034, "Yurius (Dark Mage with Cyas portrait and Life...)"),
    BELDO(0x0035, "Beldo"),
    WEISSMAN(0x0036, "Weissman (Boss)"),
    MANSTER_ARCHER(0x0037, "Manster - Archer"),
    BUGS(0x0038, "Bugs (Boss)"),
    JABAL(0x0039, "Jabal"),
    RIFIS_GANG_PIRATE(0x003A, "Rifis' Gang - Pirate"),
    RIFIS_GANG_HUNTER(0x003B, "Rifis' Gang - Hunter"),
    RIFIS_GANG_WARRIOR(0x003C, "Rifis' Gang - Warrior"),
    ROBOS(0x003D, "Robos (Boss)"),
    MANSTER_BOW_ARMOR(0x003E, "Manster - Bow Armor"),
    MANSTER_THUNDER_MAGE(0x003F, "Manster - Thunder Mage"),
    MANSTER_BISHOP(0x0040, "Manster - Bishop"),
    ROMEO_NPC(0x0041, "Romeo (NPC)"),
    LUCHEA_NPC(0x0042, "Luchea (NPC)"),
    YUBEL_NPC(0x0043, "Yubel (NPC)"),
    CORPLE_NPC(0x0044, "Corple (NPC,FE4 cameo)"),
    SETY(0x0045, "Sety (Chapter 4G appearance)"),
    ISHTAR(0x0046, "Ishtar"),
    REINHART_WEAK_VERSION(0x0047, "Reinhart (Weak version,probably dialogue)"),
    RIFIS_GANG_SWORD_FIGHTER(0x0048, "Rifis' Gang - Sword Fighter"),
    EMILY_NPC(0x0049, "Emily (NPC)"),
    MURPHY_NPC(0x004A, "Murphy (NPC)"),
    BELLA_NPC(0x004B, "Bella (NPC)"),
    KRITH_NPC(0x004C, "Krith (NPC)"),
    BOEY_NPC(0x004D, "Boey (NPC)"),
    LEENA_NPC(0x004E, "Leena (NPC)"),
    MERCENARY_SWORD_FIGHTER(0x004F, "Mercenary - Sword Fighter"),
    GALZUS(0x0050, "Galzus"),
    MANSTER_SOCIAL_KNIGHT(0x0051, "Manster - Social Knight"),
    MANSTER_PALADIN(0x0052, "Manster - Paladin"),
    MANSTER_ARCH_KNIGHT(0x0053, "Manster - Arch Knight"),
    MANSTER_TROUBADOUR(0x0054, "Manster - Troubadour"),
    IZENAU_BOSS(0x0055, "Izenau (Boss)"),
    HANNIBAL_DIALOGUE(0x0056, "Hannibal (Dialogue,FE4 cameo)"),
    MANSTER_AXE_KNIGHT(0x0057, "Manster - Axe Knight"),
    BANDIT_MOUNTAIN_THIEF(0x0058, "Bandit - Mountain Thief"),
    BANDIT_HUNTER(0x0059, "Bandit - Hunter"),
    BANDIT_WARRIOR(0x005A, "Bandit - Warrior"),
    LUMEI_BOSS(0x005B, "Lumei (Boss)"),
    GOMEZ_BOSS(0x005C, "Gomez (Boss)"),
    MALLOCK_BOSS(0x005D, "Mallock (Boss)"),
    THRACIA_DRAGON_KNIGHT(0x005E, "Thracia - Dragon Knight"),
    THRACIA_SWORD_FIGHTER(0x005F, "Thracia - Sword Fighter"),
    THRACIA_AXE_FIGHTER(0x0060, "Thracia - Axe Fighter"),
    ALTHENNA_ENEMY_ONLY(0x0061, "Althenna (Enemy only,FE4 cameo)"),
    TORABANT_DIALOGUE(0x0062, "Torabant (Dialogue,FE4 cameo)"),
    RALGO_BOSS(0x0063, "Ralgo (Boss)"),
    MANSTER_LONG_ARCH(0x0064, "Manster - Long Arch"),
    MANSTER_AXE_ARMOR(0x0065, "Manster - Axe Armor"),
    KEMPF_BOSS(0x0066, "Kempf (Boss)"),
    OLTOV_BOSS(0x0067, "Oltov (Boss)"),
    ROSA_NPC(0x0068, "Rosa (NPC)"),
    SERRA_NPC(0x0069, "Serra (NPC)"),
    PETER_NPC(0x006A, "Peter (NPC)"),
    KOLHO_MINI_BOSS(0x006B, "Kolho (Mini-boss)"),
    RIST_BOSS(0x006C, "Rist (Boss)"),
    PALUCE_BOSS(0x006D, "Paluce (Boss)"),
    BALDACK_BOSS(0x006E, "Baldack (Boss)"),
    THRACIA_LANCE_ARMOR(0x006F, "Thracia - Lance Armor"),
    LENSTER_LANCE_KNIGHT(0x0070, "Lenster - Lance Knight"),
    LENSTER_ARCH_KNIGHT(0x0071, "Lenster - Arch Knight"),
    ARION_DIALOGUE(0x0072, "Arion (Dialogue,FE4 cameo)"),
    MAKROI_BOSS(0x0073, "Makroi (Boss)"),
    KODDA_BOSS(0x0074, "Kodda (Boss)"),
    ROPUTO_DARK_MAGE(0x0075, "Roputo - Dark Mage"),
    CIVILIAN(0x0076, "Civilian"),
    THIEF(0x0077, "Thief"),
    MANSTER_SNIPER(0x0078, "Manster - Sniper"),
    MERCENARY_SOCIAL_KNIGHT(0x0079, "Mercenary - Social Knight"),
    PRIEST(0x007A, "Priest"),
    MERCENARY_SWORD_FIGHTER2(0x007B, "Mercenary - Sword Fighter"),
    CH21_IRON_ARCH(0x007C, "21 - Iron Arch"),
    SHUPEL_BOSS(0x007D, "Shupel (Boss)"),
    BLUKE_BOSS(0x007E, "Bluke (Boss)"),
    SILESIA_PEGASUS_RIDER(0x007F, "Silesia - Pegasus Rider"),
    NIKOLAF_BOSS(0x0080, "Nikolaf (Boss)"),
    MUUA_BOSS(0x0081, "Muua (Boss)"),
    MYURA_BOSS(0x0082, "Myura (Boss)"),
    REINCOCK_BOSS(0x0083, "Reincock (Boss)"),
    PALMAN_BOSS(0x0084, "Palman (Boss)"),
    KANTO_BOSS(0x0085, "Kanto (Boss)"),
    GUSTAF_BOSS(0x0086, "Gustaf (Boss)"),
    DANCER(0x0087, "Dancer"),
    SISTER(0x0088, "Sister"),
    MANHEIM_BOSS(0x0089, "Manheim (Boss)"),
    PHLAUS_BOSS(0x008A, "Phlaus (Boss)"),
    SEMITOL_BOSS(0x008B, "Semitol (Boss)"),
    ZAOM_BOSS(0x008C, "Zaom (Boss)"),
    KOEN_BOSS(0x008D, "Koen (Boss)"),
    ALPHAN_BOSS(0x008E, "Alphan (Boss)"),
    OPISU_BOSS(0x008F, "Opisu (Boss?)"),
    FERDEN_BOSS(0x0090, "Ferden (Boss)"),
    KORUTA_BOSS(0x0091, "Koruta (Boss)"),
    REINHARDT(0x0092, "Reinhardt"),
    NANCY_NPC(0x0093, "Nancy (NPC)"),
    TAHRA_CIVILIAN1(0x0094, "Tahra Civilian"),
    TAHRA_CIVILIAN2(0x0095, "Tahra Civilian"),
    TAHRA_CIVILIAN3(0x0096, "Tahra Civilian"),
    TAHRA_CIVILIAN4(0x0097, "Tahra Civilian"),
    TAHRA_CIVILIAN5(0x0098, "Tahra Civilian"),
    TAHRA_CIVILIAN6(0x0099, "Tahra Civilian"),
    MERCENARY_SWORD_FIGHTER3(0x009A, "Mercenary - Sword Fighter"),
    FREEGE_LONG_ARCH(0x009B, "Freege - Long Arch"),
    FREEGE_SOCIAL_KNIGHT(0x009C, "Freege - Social Knight"),
    FREEGE_TROUBADOUR(0x009D, "Freege - Troubadour"),
    FREEGE_BOW_ARMOR(0x009E, "Freege - Bow Armor"),
    FREEGE_LANCE_ARMOR(0x009F, "Freege - Lance Armor"),
    FREEGE_AXE_ARMOR(0x00A0, "Freege - Axe Armor"),
    FREEGE_ARCHER(0x00A1, "Freege - Archer"),
    FREEGE_MAGE(0x00A2, "Freege - Mage"),
    RILKE_KEMPF_PORTRAIT(0x00A3, "Rilke (with Kempf portrait...)"),
    MANSTER_LANCE_ARMOR(0x00A4, "Manster - Lance Armor"),
    CIVILIAN_1(0x00A5, "Civilian"),
    CIVILIAN_2(0x00A6, "Civilian"),
    CIVILIAN_3(0x00A7, "Civilian"),
    CIVILIAN_4(0x00A8, "Civilian"),
    CIVILIAN_5(0x00A9, "Civilian"),
    CIVILIAN_6(0x00AA, "Civilian"),
    MANSTER_MAGE(0x00AB, "Manster - Mage"),
    MANSTER_PRIEST(0x00AC, "Manster - Priest"),
    YURIUS_YURIA_PORTRAIT(0x00AD, "Yurius (with Yuria portrait...)"),
    MANFROY_MACHYUA_PORTRAIT(0x00AE, "Manfroy (with Machyua portrait...)"),
    MANSTER_MAGE2(0x00AF, "Manster - Mage"),
    MANSTER_SWORD_FIGHTER(0x00B0, "Manster - Sword Fighter"),
    ENVOY_MERCENARY(0x00B1, "Envoy - Mercenary"),
    ENVOY_WARRIOR(0x00B2, "Envoy - Warrior"),
    ENVOY_GENERAL(0x00B3, "Envoy - General"),
    ENVOY_SWORDMASTER(0x00B4, "Envoy - Swordmaster"),
    ENVOY_BERSERKER(0x00B5, "Envoy - Berserker"),
    MANSTER_PRIEST2(0x00B6, "Manster - Priest"),
    BANTOL_BOSS(0x00B7, "Bantol (Boss)"),
    LOPTO_DARK_BISHOP(0x00B8, "Lopto - Dark Bishop"),
    TORMAN_BOSS(0x00B9, "Torman (Boss)"),
    MANSTER_SOLDIER2(0x00BA, "Manster - Soldier"),
    BANDIT_BERSERKER(0x00BB, "Bandit - Berserker"),
    MERCENARY_SWORD_FIGHTER4(0x00BC, "Mercenary - Sword Fighter"),
    MAGI_SQUAD_SWORD_FIGHTER(0x00BD, "Magi Squad - Sword Fighter"),
    MAGI_SQUAD_AXE_FIGHTER(0x00BE, "Magi Squad - Axe Fighter"),
    MAGI_SQUAD_BOW_FIGHTER(0x00BF, "Magi Squad - Bow Fighter"),
    MAGI_SQUAD_SWORD_FIGHTER2(0x00C0, "Magi Squad - Sword Fighter"),
    DRAGON_RIDER(0x00C1, "Dragon Rider"),
    BISHOP(0x00C2, "Bishop"),
    TOBOLZARK_BOSS(0x00C3, "Tobolzark (Boss)"),
    MANSTER_BISHOP2(0x00C4, "Manster - Bishop"),
    FREEGE_LONG_ARCH2(0x00C5, "Freege - Long Arch"),
    BANDIT_MOUNTAIN_THIEF_2(0x00C6, "Bandit - Mountain Thief 2"),
    THIEF2(0x00C7, "Thief"),
    BOW_FIGHTER(0x00C8, "Bow Fighter"),
    FREEGE_BISHOP(0x00C9, "Freege - Bishop"),
    FREEGE_LANCE_ARMOR2(0x00CA, "Freege - Lance Armor"),
    FREEGE_BOW_ARMOR2(0x00CB, "Freege - Bow Armor"),
    FREEGE_MAGE2(0x00CC, "Freege - Mage"),
    IRON_ARCH(0x00CD, "Iron Arch"),
    FREEGE_AXE_ARMOR2(0x00CE, "Freege - Axe Armor"),
    AIGHTMAN_BOSS(0x00CF, "Aightman (Boss)"),
    ZAIL_BOSS(0x00D0, "Zail (Boss)"),
    SWORD_ARMOR(0x00D1, "Sword Armor"),
    SOLDIER(0x00D2, "Soldier"),
    FREEGE_LONG_ARCH3(0x00D3, "Freege - Long Arch"),
    EYRIOS(0x00D4, "Eyrios"),
    SILESIA_PEGASUS_RIDER2(0x00D5, "Silesia - Pegasus Rider"),
    FREEGE_MAGE_KNIGHT1(0x00D6, "Freege - Mage Knight"),
    PALADIN(0x00D7, "Paladin"),
    FREEGE_GREAT_KNIGHT(0x00D8, "Freege - Great Knight"),
    BOW_KNIGHT(0x00D9, "Bow Knight"),
    SWORD_ARMOR2(0x00DA, "Sword Armor"),
    FREEGE_SOLDIER1(0x00DB, "Freege - Soldier"),
    FREEGE_ARCH_KNIGHT1(0x00DC, "Freege - Arch Knight"),
    FREEGE_TROUBADOUR2(0x00DD, "Freege - Troubadour"),
    FREEGE_LANCE_KNIGHT1(0x00DE, "Freege - Lance Knight"),
    FREEGE_SOCIALKNIGHT(0x00DF, "Freege - Socialknight"),
    CIVILIAN1(0x00E0, "Civilian"),
    MERCENARY1(0x00E1, "Mercenary"),
    SWORDMASTER(0x00E2, "Swordmaster"),
    BERSERKER(0x00E3, "Berserker"),
    BERSERKER1(0x00E4, "Berserker"),
    SILESIA_PEGASUS_RIDER1(0x00E5, "Silesia - Pegasus Rider"),
    FREEGE_AXE_ARMOR1(0x00E6, "Freege - Axe Armor"),
    FREEGE_SWORD_ARMOR1(0x00E7, "Freege - Sword Armor"),
    FREEGE_LANCE_ARMOR1(0x00E8, "Freege - Lance Armor"),
    FREEGE_LONG_ARCH1(0x00E9, "Freege - Long Arch"),
    BOW_FIGHTER1(0x00EA, "Bow Fighter"),
    SWORD_FIGHTER(0x00EB, "Sword Fighter"),
    MERCENARY2(0x00EC, "Mercenary"),
    XAVIER(0x00ED, "Xavier"),
    XAVIER_LENSTER_ARMOR1(0x00EE, "Xavier's Lenster Armor"),
    XAVIER_LENSTER_ARMOR2(0x00EF, "Xavier's Lenster Armor"),
    XAVIER_LENSTER_ARMOR3(0x00F0, "Xavier's Lenster Armor"),
    XAVIER_LENSTER_ARMOR4(0x00F1, "Xavier's Lenster Armor"),
    XAVIER_LENSTER_ARMOR5(0x00F2, "Xavier's Lenster Armor"),
    XAVIER_LENSTER_ARMOR6(0x00F3, "Xavier's Lenster Armor"),
    XAVIER_LENSTER_ARMOR7(0x00F4, "Xavier's Lenster Armor"),
    XAVIER_LENSTER_ARMOR8(0x00F5, "Xavier's Lenster Armor"),
    CIVILIAN_A(0x00F6, "Civilian"),
    CIVILIAN_B(0x00F7, "Civilian"),
    CIVILIAN_C(0x00F8, "Civilian"),
    CIVILIAN_D(0x00F9, "Civilian"),
    CIVILIAN_E(0x00FA, "Civilian"),
    CIVILIAN_F(0x00FB, "Civilian"),
    CIVILIAN_G(0x00FC, "Civilian"),
    CIVILIAN_H(0x00FD, "Civilian"),
    FREEGE_SOLDIER(0x00FE, "Freege - Soldier"),
    LENSTER_SOLDIER(0x00FF, "Lenster - Soldier"),
    AUGUST(0x0100, "August"),
    RESISTANCE_SWORD_FIGHTER1(0x0101, "Resistance - Sword Fighter"),
    BARRAT_BOSS(0x0102, "Barrat (Boss)"),
    FREEGE_GENERAL1(0x0103, "Freege - General"),
    FREEGE_SWORD_ARMOR2(0x0104, "Freege - Sword Armor"),
    FREEGE_PRIEST2(0x0105, "Freege - Priest"),
    FREEGE_POISON_ARCH(0x0106, "Freege - Poison Arch"),
    THRACIA_DRAGON_KNIGHT2(0x0107, "Thracia - Dragon Knight"),
    FREEGE_MAGE_KNIGHT2(0x0108, "Freege - Mage Knight"),
    FREEGE_AXE_KNIGHT(0x0109, "Freege - Axe Knight"),
    FREEGE_BOW_KNIGHT2(0x010A, "Freege - Bow Knight"),
    FREEGE_PALADIN2(0x010B, "Freege - Paladin"),
    FREEGE_LANCE_KNIGHT(0x010C, "Freege - Lance Knight"),
    FREEGE_SNIPER(0x010D, "Freege - Sniper"),
    FREEGE_MERCENARY(0x010E, "Freege - Mercenary"),
    FREEGE_BISHOP2(0x010F, "Freege - Bishop"),
    FREEGE_TROUBADOUR3(0x0110, "Freege - Troubadour"),
    FREEGE_MAGE_KNIGHT(0x0111, "Freege - Mage Knight"),
    ALSTER_SOCIALKNIGHT2(0x0112, "Alster - Socialknight"),
    ALSTER_ARCH_KNIGHT(0x0113, "Alster - Arch Knight"),
    ALSTER_BOW_KNIGHT(0x0114, "Alster - Bow Knight"),
    ALSTER_MAGE_KNIGHT(0x0115, "Alster - Mage Knight"),
    FREEGE_PRIEST(0x0116, "Freege - Priest"),
    FREEGE_BOW_KNIGHT(0x0117, "Freege - Bow Knight"),
    FREEGE_PALADIN(0x0118, "Freege - Paladin"),
    FREEGE_SWORD_ARMOR(0x0119, "Freege - Sword Armor"),
    FREEGE_ARCH_KNIGHT(0x011A, "Freege - Arch Knight"),
    GELB_RITTER(0x011B, "Gelb Ritter"),
    FREEGE_GENERAL(0x011C, "Freege - General"),
    MANSTER_DUKE_KNIGHT(0x011D, "Manster - Duke Knight"),
    MANSTER_BOW_KNIGHT(0x011E, "Manster - Bow Knight"),
    MANSTER_GREAT_KNIGHT(0x011F, "Manster - Great Knight"),
    THRACIA_DRAGON_KNIGHT3(0x0120, "Thracia - Dragon Knight"),
    CIVILIAN10(0x0121, "Civilian"),
    CIVILIAN11(0x0122, "Civilian"),
    CIVILIAN12(0x0123, "Civilian"),
    CIVILIAN13(0x0124, "Civilian"),
    CIVILIAN14(0x0125, "Civilian"),
    CIVILIAN15(0x0126, "Civilian"),
    CIVILIAN16(0x0127, "Civilian"),
    CIVILIAN17(0x0128, "Civilian"),
    CIVILIAN18(0x0129, "Civilian"),
    CIVILIAN19(0x012A, "Civilian"),
    CIVILIAN20(0x012B, "Civilian"),
    CIVILIAN21(0x012C, "Civilian"),
    CIVILIAN22(0x012D, "Civilian"),
    CIVILIAN23(0x012E, "Civilian"),
    MERCENARY(0x012F, "Mercenary"),
    MERCENARY3(0x0130, "Mercenary"),
    MERCENARY4(0x0131, "Mercenary"),
    SNIPER(0x0132, "Sniper"),
    EINS(0x0133, "Eins"),
    DREI_DAGUDAR(0x0134, "Drei (Dagudar)"),
    DREI(0x0135, "Drei"),
    ELF_SARA(0x0136, "Elf (Sara)"),
    ELF(0x0137, "Elf"),
    ZWEI_GALZUS(0x0138, "Zwei (Galzus)"),
    ZWEI(0x0139, "Zwei"),
    ZWÖLF_LIFIS(0x013A, "Zwölf (Lifis)"),
    ZWÖLF(0x013B, "Zwölf"),
    FÜNF_EYVEL(0x013C, "Fünf (Eyvel)"),
    FÜNF(0x013D, "Fünf"),
    LOPTO_DARK_MAGE2(0x013E, "Lopto - Dark Mage"),
    LOPTO_AXE_ARMOR(0x013F, "Lopto - Axe Armor"),
    LOPTO_BOW_ARMOR(0x0140, "Lopto - Bow Armor"),
    LOPTO_LANCE_ARMOR(0x0141, "Lopto - Lance Armor"),
    MANSTER_POISON_ARCH(0x0142, "Manster - Poison Arch"),
    LEIDRICK_AGAIN(0x0143, "Leidrick (again)"),
    MANSTER_SWORD_ARMOR(0x0144, "Manster - Sword Armor"),
    MANSTER_SOLDIER(0x0145, "Manster - Soldier"),
    FREEGE_IRON_ARCH(0x0146, "Freege - Iron Arch"),
    THRACIA_ARCHER(0x0147, "Thracia - Archer"),
    THRACIA_BISHOP(0x0148, "Thracia - Bishop"),
    THRACIA_DRAGON_RIDER(0x0149, "Thracia - Dragon Rider"),
    THRACIA_SOLDIER(0x014A, "Thracia - Soldier"),
    ALSTER_SOCIALKNIGHT(0x014B, "Alster - Socialknight"),
    PIRATE(0x014C, "Pirate"),
    RESISTANCE_BOW_FIGHTER(0x014D, "Resistance - Bow Fighter"),
    RESISTANCE_PRIEST(0x014E, "Resistance - Priest"),
    RESISTANCE_AXE_FIGHTER(0x014F, "Resistance - Axe Fighter"),
    RESISTANCE_BOW_FIGHTER2(0x0150, "Resistance - Bow Fighter"),
    RESISTANCE_SWORD_FIGHTER(0x0151, "Resistance - Sword Fighter"),
    RESISTANCE_MAGE(0x0152, "Resistance - Mage"),
    MANSTER_GENERAL(0x0153, "Manster - General"),
    LOPTO_DARK_MAGE(0x0154, "Lopto - Dark Mage"),
    THRACIA_SWORD_ARMOR(0x0155, "Thracia - Sword Armor"),
    WOLF_BOSS(0x0156, "Wolf (Boss)");
    
    private int offset;
    private String name;
    private int baseHp = -1;
    private int baseStr = -1;
    private int baseMag = -1;
    private int baseSkl = -1;
    private int baseSpd = -1;
    private int baseDef = -1;
    private int baseBld = -1;
    private int baseLck = -1;
    private int baseMov = -1;
    private int movStars = -1;
    private MovementStars movementStars = MovementStars.MOV_STARS_0;
    private int counterCritBoost = -1;
    private int hpGrowth = -1;
    private int strGrowth = -1;
    private int magGrowth = -1;
    private int sklGrowth = -1;
    private int spdGrowth = -1;
    private int defGrowth = -1;
    private int bldGrowth = -1;
    private int lckGrowth = -1;
    private int movGrowth = -1;
    private int baseSwordLv = -1;
    private int baseLanceLv = -1;
    private int baseAxeLv = -1;
    private int baseBowLv = -1;
    private int baseStaffLv = -1;
    private int baseFireLv = -1;
    private int baseThunderLv = -1;
    private int baseWindLv = -1;
    private int baseLightLv = -1;
    private int baseDarkLv = -1;
    private Gender gender = Gender.MALE;
    private CharacterSkill1 characterSkill1 = CharacterSkill1.NONE;
    private CharacterSkill2 characterSkill2 = CharacterSkill2.NONE;
    private CharacterSkill3 characterSkill3 = CharacterSkill3.NONE;
    private CharacterClass characterClass = CharacterClass.LORD;
    private int leadershipStars = -1;
    
    private static final int CHARACTER_DATA_SIZE = 48;
    private static final int BASE_HP_OFFSET = 0x0;
    private static final int BASE_STR_OFFSET = 0x01;
    private static final int BASE_MAG_OFFSET = 0x02;
    private static final int BASE_SKL_OFFSET = 0x03;
    private static final int BASE_SPD_OFFSET = 0x04;
    private static final int BASE_DEF_OFFSET = 0x05;
    private static final int BASE_BLD_OFFSET = 0x06;
    private static final int BASE_LCK_OFFSET = 0x07;
    private static final int BASE_MOV_OFFSET = 0x08;
    private static final int MOV_STARS_OFFSET = 0x09;
    private static final int COUNTER_CRIT_BOOST_OFFSET = 0x0A;
    private static final int HP_GROWTH_OFFSET = 0x0B;
    private static final int STR_GROWTH_OFFSET = 0x0C;
    private static final int MAG_GROWTH_OFFSET = 0x0D;
    private static final int SKL_GROWTH_OFFSET = 0x0E;
    private static final int SPD_GROWTH_OFFSET = 0x0F;
    private static final int DEF_GROWTH_OFFSET = 0x10;
    private static final int BLD_GROWTH_OFFSET = 0x11;
    private static final int LCK_GROWTH_OFFSET = 0x12;
    private static final int MOV_GROWTH_OFFSET = 0x13;
    private static final int BASE_SWORD_LV_OFFSET = 0x14;
    private static final int BASE_LANCE_LV_OFFSET = 0x15;
    private static final int BASE_AXE_LV_OFFSET = 0x16;
    private static final int BASE_BOW_LV_OFFSET = 0x17;
    private static final int BASE_STAFF_LV_OFFSET = 0x18;
    private static final int BASE_FIRE_LV_OFFSET = 0x19;
    private static final int BASE_THUNDER_LV_OFFSET = 0x1A;
    private static final int BASE_WIND_LV_OFFSET = 0x1B;
    private static final int BASE_LIGHT_LV_OFFSET = 0x1C;
    private static final int BASE_DARK_LV_OFFSET = 0x1D;
    private static final int GENDER_OFFSET = 0x28;
    private static final int SKILL1_OFFSET = 0x29;
    private static final int SKILL2_OFFSET = 0x2A;
    private static final int SKILL3_OFFSET = 0x2B;
    private static final int CLASS_OFFSET = 0x2C;
    private static final int LEADERSHIP_STARS_OFFSET = 0x2D;
    
    private Character(int offset, String name) {
        this.offset = offset;
        this.name = name;
    }
    
    public void readCharacter(Rom rom, int startingOffset) {
        int relOffset = startingOffset + (offset - 1) * CHARACTER_DATA_SIZE;
        baseHp = rom.getValueAt(relOffset + BASE_HP_OFFSET);
        baseStr = rom.getValueAt(relOffset + BASE_STR_OFFSET);
        baseMag = rom.getValueAt(relOffset + BASE_MAG_OFFSET);
        baseSkl = rom.getValueAt(relOffset + BASE_SKL_OFFSET);
        baseSpd = rom.getValueAt(relOffset + BASE_SPD_OFFSET);
        baseDef = rom.getValueAt(relOffset + BASE_DEF_OFFSET);
        baseBld = rom.getValueAt(relOffset + BASE_BLD_OFFSET);
        baseLck = rom.getValueAt(relOffset + BASE_LCK_OFFSET);
        baseMov = rom.getValueAt(relOffset + BASE_MOV_OFFSET);
        movementStars = MovementStars.findById(rom.getValueAt(relOffset + MOV_STARS_OFFSET));
        counterCritBoost = rom.getValueAt(relOffset + COUNTER_CRIT_BOOST_OFFSET);
        hpGrowth = rom.getValueAt(relOffset + HP_GROWTH_OFFSET);
        strGrowth = rom.getValueAt(relOffset + STR_GROWTH_OFFSET);
        magGrowth = rom.getValueAt(relOffset + MAG_GROWTH_OFFSET);
        sklGrowth = rom.getValueAt(relOffset + SKL_GROWTH_OFFSET);
        spdGrowth = rom.getValueAt(relOffset + SPD_GROWTH_OFFSET);
        defGrowth = rom.getValueAt(relOffset + DEF_GROWTH_OFFSET);
        bldGrowth = rom.getValueAt(relOffset + BLD_GROWTH_OFFSET);
        lckGrowth = rom.getValueAt(relOffset + LCK_GROWTH_OFFSET);
        movGrowth = rom.getValueAt(relOffset + MOV_GROWTH_OFFSET);
        baseSwordLv = rom.getValueAt(relOffset + BASE_SWORD_LV_OFFSET);
        baseLanceLv = rom.getValueAt(relOffset + BASE_LANCE_LV_OFFSET);
        baseAxeLv = rom.getValueAt(relOffset + BASE_AXE_LV_OFFSET);
        baseBowLv = rom.getValueAt(relOffset + BASE_BOW_LV_OFFSET);
        baseStaffLv = rom.getValueAt(relOffset + BASE_STAFF_LV_OFFSET);
        baseFireLv = rom.getValueAt(relOffset + BASE_FIRE_LV_OFFSET);
        baseThunderLv = rom.getValueAt(relOffset + BASE_THUNDER_LV_OFFSET);
        baseWindLv = rom.getValueAt(relOffset + BASE_WIND_LV_OFFSET);
        baseLightLv = rom.getValueAt(relOffset + BASE_LIGHT_LV_OFFSET);
        baseDarkLv = rom.getValueAt(relOffset + BASE_DARK_LV_OFFSET);
        /*private static final int BASE_SWORD_LV_OFFSET = 0x14;
        private static final int BASE_LANCE_LV_OFFSET = 0x15;
        private static final int BASE_AXE_LV_OFFSET = 0x16;
        private static final int BASE_BOW_LV_OFFSET = 0x17;
        private static final int BASE_STAFF_LV_OFFSET = 0x18;
        private static final int BASE_FIRE_LV_OFFSET = 0x19;
        private static final int BASE_THUNDER_LV_OFFSET = 0x1A;
        private static final int BASE_WIND_LV_OFFSET = 0x1B;
        private static final int BASE_LIGHT_LV_OFFSET = 0x1C;
        private static final int BASE_DARK_LV_OFFSET = 0x1D;
        private static final int GENDER_OFFSET = 0x28;
        private static final int SKILL1_OFFSET = 0x29;
        private static final int SKILL2_OFFSET = 0x2A;
        private static final int SKILL3_OFFSET = 0x2B;*/
        characterClass = CharacterClass.findById(rom.getValueAt(relOffset + CLASS_OFFSET));
        
        System.out.println(this);
    }
    
    public String getName() {
        return name;
    }
    
    public static Character findById(int offset) {
        Character actor = null;
        
        for(Character currentActor : Character.values()) {
            if(currentActor.offset == offset) {
                actor = currentActor;
                break;
            }
        }
        
        if(actor == null) {
            System.out.println(String.format("WARNING: Offset 0x%04X in Actor was not found.", offset));
            actor = Character.LEAF;
        }
        
        return actor;
    }
    
    @Override
    public String toString() {
        String text;
        
        text = String.format("[CHARACTER] Name: %s\n", name);
        text += String.format("Bases HP: %d, Str: %d, Mag: %d, Skl: %d, Spd: %d, Def: %d, Bld: %d, Lck: %d, Mov: %d\n",
                baseHp, baseStr, baseMag, baseSkl, baseSpd, baseDef, baseBld, baseLck, baseMov);
        text += String.format("Mov stars: %d, Counter crit bonus: %d\n",
                movementStars.getAmmount(), counterCritBoost);
        text += String.format("Growths HP: %d, Str: %d, Mag: %d, Skl: %d, Spd: %d, Def: %d, Bld: %d, Lck: %d, Mov: %d\n",
                hpGrowth, strGrowth, magGrowth, sklGrowth, spdGrowth, defGrowth, bldGrowth, lckGrowth, movGrowth);
        text += String.format("Base Wpn level Sword: %d, Lance: %d Axe: %d, Bow: %d, Staff: %d, Fire: %d, Thunder: %d, Wind: %d, Light: %d, Dark: %d\n",
                baseSwordLv, baseLanceLv, baseAxeLv, baseBowLv, baseStaffLv, baseFireLv, baseThunderLv, baseWindLv, baseLightLv, baseDarkLv);
        
        return text; 
    }
}