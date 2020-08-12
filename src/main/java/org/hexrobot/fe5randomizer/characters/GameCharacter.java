package org.hexrobot.fe5randomizer.characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hexrobot.fe5randomizer.MountData;
import org.hexrobot.fe5randomizer.Rom;
import org.hexrobot.fe5randomizer.characters.GameCharacter;
import org.hexrobot.fe5randomizer.items.ItemType;

public enum GameCharacter {
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
    SETY_CH23(0x001F, "Sety Ch23"),
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
    GUNNA(0x002C, "Gunna (Bishop from dialogue)"),
    AMALDA(0x002D, "Amalda"),
    CONOMORE(0x002E, "Conomore"),
    HOMEROS(0x002F, "Homeros"),
    DELMUD(0x0030, "Delmud"),
    SARA(0x0031, "Sara"),
    CYAS(0x0032, "Cyas"),
    LEIDRICK_1(0x0033, "Leidrick 1"),
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
    SETY_CH4X(0x0045, "Sety Ch4x"),
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
    ZWOLF_LIFIS(0x013A, "Zwolf (Lifis)"),
    ZWOLF(0x013B, "Zwolf"),
    FUNF_EYVEL(0x013C, "Funf (Eyvel)"),
    FUNF(0x013D, "Funf"),
    LOPTO_DARK_MAGE2(0x013E, "Lopto - Dark Mage"),
    LOPTO_AXE_ARMOR(0x013F, "Lopto - Axe Armor"),
    LOPTO_BOW_ARMOR(0x0140, "Lopto - Bow Armor"),
    LOPTO_LANCE_ARMOR(0x0141, "Lopto - Lance Armor"),
    MANSTER_POISON_ARCH(0x0142, "Manster - Poison Arch"),
    LEIDRICK_2(0x0143, "Leidrick 2"),
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
    private int baseAtk = -1;
    private int baseMag = -1;
    private int baseSkl = -1;
    private int baseSpd = -1;
    private int baseDef = -1;
    private int baseBld = -1;
    private int baseLck = -1;
    private int baseMov = -1;
    private MovementStars movementStars = MovementStars.MOV_STARS_0;
    private int counterCritBoost = -1;
    private int hpGrowth = -1;
    private int atkGrowth = -1;
    private int magGrowth = -1;
    private int sklGrowth = -1;
    private int spdGrowth = -1;
    private int defGrowth = -1;
    private int bldGrowth = -1;
    private int lckGrowth = -1;
    private int movGrowth = -1;
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
    private Gender gender = Gender.MALE;
    private int skills1 = -1;
    private int skills2 = -1;
    private int skills3 = -1;
    private ArrayList<Skill> skills = new ArrayList<Skill>();
    private CharacterClass characterClass = CharacterClass.LORD;
    private int leadershipStars = -1;
    private int mapSprite = -1;
    private boolean randomBases = false;
    
    private static final int CHARACTER_DATA_SIZE = 48;
    private static final int BASE_HP_OFFSET = 0x0;
    private static final int BASE_ATK_OFFSET = 0x01;
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
    private static final int ATK_GROWTH_OFFSET = 0x0C;
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
    private static final int MAP_SPRITE_OFFSET = 0x2E;
    private Map<String, Object> oldValues = new HashMap<>();
    private static MountData mountData = null;
    
    private static final ArrayList<GameCharacter> PLAYABLE_UNITS = new ArrayList<>(List.of(
            LEAF, FINN, OTHIN, HALVAN, EYVEL, DAGUDAR, RALF, MARTY, RONAN, MIRANDA, SAPHY, LARA, BRIGHTON, FELGUS, EDA,
            ASVEL, MACHYUA, HICKS, NANNA, SELFINA, DALSHEIN, CARRION, SHIVA, PAHN, GLADE, KEIN, ALBA, ROBERTO, FRED,
            ORUEN, SETY_CH23, RIFIS, KARIN, DEAN, SHANAM, TREWD, TANYA, LINONAN, MISHA, SEIRAM, SLEUF, MAREETA, TINA,
            AMALDA, CONOMORE, HOMEROS, DELMUD, SARA, CYAS, EYRIOS, XAVIER));
    private static final ArrayList<GameCharacter> ENEMY_UNITS = new ArrayList<>(List.of(
            LEIDRICK_1, BELDO, WEISSMAN, MANSTER_ARCHER, BUGS, JABAL, RIFIS_GANG_PIRATE, RIFIS_GANG_HUNTER,
            RIFIS_GANG_WARRIOR, ROBOS, MANSTER_BOW_ARMOR, MANSTER_THUNDER_MAGE, MANSTER_BISHOP,
            RIFIS_GANG_SWORD_FIGHTER, MERCENARY_SWORD_FIGHTER, GALZUS, MANSTER_SOCIAL_KNIGHT, MANSTER_PALADIN,
            MANSTER_ARCH_KNIGHT, MANSTER_TROUBADOUR, IZENAU_BOSS, MANSTER_AXE_KNIGHT, BANDIT_MOUNTAIN_THIEF,
            BANDIT_HUNTER, BANDIT_WARRIOR, LUMEI_BOSS, GOMEZ_BOSS, MALLOCK_BOSS, THRACIA_DRAGON_KNIGHT,
            THRACIA_SWORD_FIGHTER, THRACIA_AXE_FIGHTER, RALGO_BOSS, MANSTER_LONG_ARCH, MANSTER_AXE_ARMOR, KEMPF_BOSS,
            OLTOV_BOSS, KOLHO_MINI_BOSS, RIST_BOSS, PALUCE_BOSS, BALDACK_BOSS, THRACIA_LANCE_ARMOR,
            LENSTER_LANCE_KNIGHT, LENSTER_ARCH_KNIGHT, MAKROI_BOSS, KODDA_BOSS, ROPUTO_DARK_MAGE, THIEF, MANSTER_SNIPER,
            MERCENARY_SOCIAL_KNIGHT, PRIEST, MERCENARY_SWORD_FIGHTER2, CH21_IRON_ARCH, SHUPEL_BOSS, BLUKE_BOSS,
            SILESIA_PEGASUS_RIDER, NIKOLAF_BOSS, MUUA_BOSS, MYURA_BOSS, REINCOCK_BOSS, PALMAN_BOSS, KANTO_BOSS,
            GUSTAF_BOSS, DANCER, SISTER, MANHEIM_BOSS, PHLAUS_BOSS, SEMITOL_BOSS, ZAOM_BOSS, KOEN_BOSS, ALPHAN_BOSS,
            OPISU_BOSS, FERDEN_BOSS, KORUTA_BOSS, REINHARDT, MERCENARY_SWORD_FIGHTER3, FREEGE_LONG_ARCH,
            FREEGE_SOCIAL_KNIGHT, FREEGE_TROUBADOUR, FREEGE_BOW_ARMOR, FREEGE_LANCE_ARMOR, FREEGE_AXE_ARMOR,
            FREEGE_ARCHER, FREEGE_MAGE, RILKE_KEMPF_PORTRAIT, MANSTER_LANCE_ARMOR, MANSTER_MAGE, MANSTER_PRIEST,
            MANSTER_MAGE2, MANSTER_SWORD_FIGHTER, ENVOY_MERCENARY, ENVOY_WARRIOR, ENVOY_GENERAL, ENVOY_SWORDMASTER,
            ENVOY_BERSERKER, MANSTER_PRIEST2, BANTOL_BOSS, LOPTO_DARK_BISHOP, TORMAN_BOSS, MANSTER_SOLDIER2,
            BANDIT_BERSERKER, MERCENARY_SWORD_FIGHTER4, MAGI_SQUAD_SWORD_FIGHTER, MAGI_SQUAD_AXE_FIGHTER,
            MAGI_SQUAD_BOW_FIGHTER, MAGI_SQUAD_SWORD_FIGHTER2, DRAGON_RIDER, BISHOP, TOBOLZARK_BOSS, MANSTER_BISHOP2,
            FREEGE_LONG_ARCH2, BANDIT_MOUNTAIN_THIEF_2, THIEF2, BOW_FIGHTER, FREEGE_BISHOP, FREEGE_LANCE_ARMOR2,
            FREEGE_BOW_ARMOR2, FREEGE_MAGE2, IRON_ARCH, FREEGE_AXE_ARMOR2, AIGHTMAN_BOSS, ZAIL_BOSS, SWORD_ARMOR,
            SOLDIER, FREEGE_LONG_ARCH3, SILESIA_PEGASUS_RIDER2, FREEGE_MAGE_KNIGHT1, PALADIN, FREEGE_GREAT_KNIGHT,
            BOW_KNIGHT, SWORD_ARMOR2, FREEGE_SOLDIER1, FREEGE_ARCH_KNIGHT1, FREEGE_TROUBADOUR2, FREEGE_LANCE_KNIGHT1,
            FREEGE_SOCIALKNIGHT, MERCENARY1, SWORDMASTER, BERSERKER, BERSERKER1, SILESIA_PEGASUS_RIDER1,
            FREEGE_AXE_ARMOR1, FREEGE_SWORD_ARMOR1, FREEGE_LANCE_ARMOR1, FREEGE_LONG_ARCH1, BOW_FIGHTER1, SWORD_FIGHTER,
            MERCENARY2, XAVIER_LENSTER_ARMOR1, XAVIER_LENSTER_ARMOR2, XAVIER_LENSTER_ARMOR3, XAVIER_LENSTER_ARMOR4,
            XAVIER_LENSTER_ARMOR5, XAVIER_LENSTER_ARMOR6, XAVIER_LENSTER_ARMOR7, XAVIER_LENSTER_ARMOR8, FREEGE_SOLDIER,
            LENSTER_SOLDIER, AUGUST, RESISTANCE_SWORD_FIGHTER1, BARRAT_BOSS, FREEGE_GENERAL1, FREEGE_SWORD_ARMOR2,
            FREEGE_PRIEST2, FREEGE_POISON_ARCH, THRACIA_DRAGON_KNIGHT2, FREEGE_MAGE_KNIGHT2, FREEGE_AXE_KNIGHT,
            FREEGE_BOW_KNIGHT2, FREEGE_PALADIN2, FREEGE_LANCE_KNIGHT, FREEGE_SNIPER, FREEGE_MERCENARY, FREEGE_BISHOP2,
            FREEGE_TROUBADOUR3, FREEGE_MAGE_KNIGHT, ALSTER_SOCIALKNIGHT2, ALSTER_ARCH_KNIGHT, ALSTER_BOW_KNIGHT,
            ALSTER_MAGE_KNIGHT, FREEGE_PRIEST, FREEGE_BOW_KNIGHT, FREEGE_PALADIN, FREEGE_SWORD_ARMOR,
            FREEGE_ARCH_KNIGHT, GELB_RITTER, FREEGE_GENERAL, MANSTER_DUKE_KNIGHT, MANSTER_BOW_KNIGHT,
            MANSTER_GREAT_KNIGHT, THRACIA_DRAGON_KNIGHT3, MERCENARY, MERCENARY3, MERCENARY4, SNIPER, EINS, DREI_DAGUDAR,
            DREI, ELF_SARA, ELF, ZWEI_GALZUS, ZWEI, ZWOLF_LIFIS, ZWOLF, FUNF_EYVEL, FUNF, LOPTO_DARK_MAGE2,
            LOPTO_AXE_ARMOR, LOPTO_BOW_ARMOR, LOPTO_LANCE_ARMOR, MANSTER_POISON_ARCH, LEIDRICK_2, MANSTER_SWORD_ARMOR,
            MANSTER_SOLDIER, FREEGE_IRON_ARCH, THRACIA_ARCHER, THRACIA_BISHOP, THRACIA_DRAGON_RIDER, THRACIA_SOLDIER,
            ALSTER_SOCIALKNIGHT, PIRATE, RESISTANCE_BOW_FIGHTER, RESISTANCE_PRIEST, RESISTANCE_AXE_FIGHTER,
            RESISTANCE_BOW_FIGHTER2, RESISTANCE_SWORD_FIGHTER, RESISTANCE_MAGE, MANSTER_GENERAL, LOPTO_DARK_MAGE,
            THRACIA_SWORD_ARMOR, WOLF_BOSS));
    private static final ArrayList<GameCharacter> BOSSES = new ArrayList<>(List.of(
            LEIDRICK_1, BELDO, WEISSMAN, BUGS, JABAL, ROBOS, ISHTAR, IZENAU_BOSS, LUMEI_BOSS, GOMEZ_BOSS, MALLOCK_BOSS,
            RALGO_BOSS, KEMPF_BOSS, OLTOV_BOSS, KOLHO_MINI_BOSS, RIST_BOSS, PALUCE_BOSS, BALDACK_BOSS, MAKROI_BOSS,
            KODDA_BOSS, SHUPEL_BOSS, BLUKE_BOSS, NIKOLAF_BOSS, MUUA_BOSS, MYURA_BOSS, REINCOCK_BOSS, PALMAN_BOSS,
            KANTO_BOSS, GUSTAF_BOSS, MANHEIM_BOSS, PHLAUS_BOSS, SEMITOL_BOSS, ZAOM_BOSS, KOEN_BOSS, ALPHAN_BOSS,
            OPISU_BOSS, FERDEN_BOSS, KORUTA_BOSS, REINHARDT, BANTOL_BOSS, TORMAN_BOSS, TOBOLZARK_BOSS, AIGHTMAN_BOSS,
            BARRAT_BOSS, EINS, DREI_DAGUDAR, DREI, ELF_SARA, ELF, ZWEI_GALZUS, ZWEI, ZWOLF_LIFIS, ZWOLF, FUNF_EYVEL,
            FUNF, LEIDRICK_2, WOLF_BOSS));
    
    private GameCharacter(int offset, String name) {
        this.offset = offset;
        this.name = name;
    }
    
    public void readCharacter(Rom rom, int startingOffset) {
        if(mountData == null) {
            mountData = rom.getMountData();
        }

        int relOffset = startingOffset + (offset - 1) * CHARACTER_DATA_SIZE;
        baseHp = rom.getValueAt(relOffset + BASE_HP_OFFSET);
        baseAtk = rom.getValueAt(relOffset + BASE_ATK_OFFSET);
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
        atkGrowth = rom.getValueAt(relOffset + ATK_GROWTH_OFFSET);
        magGrowth = rom.getValueAt(relOffset + MAG_GROWTH_OFFSET);
        sklGrowth = rom.getValueAt(relOffset + SKL_GROWTH_OFFSET);
        spdGrowth = rom.getValueAt(relOffset + SPD_GROWTH_OFFSET);
        defGrowth = rom.getValueAt(relOffset + DEF_GROWTH_OFFSET);
        bldGrowth = rom.getValueAt(relOffset + BLD_GROWTH_OFFSET);
        lckGrowth = rom.getValueAt(relOffset + LCK_GROWTH_OFFSET);
        movGrowth = rom.getValueAt(relOffset + MOV_GROWTH_OFFSET);
        gender = Gender.findById(rom.getValueAt(relOffset + GENDER_OFFSET));
        skills1 = rom.getValueAt(relOffset + SKILL1_OFFSET);
        skills2 = rom.getValueAt(relOffset + SKILL2_OFFSET);
        skills3 = rom.getValueAt(relOffset + SKILL3_OFFSET);
        skills = Skill.getSkills(skills1, skills2, skills3);
        characterClass = CharacterClass.findById(rom.getValueAt(relOffset + CLASS_OFFSET));
        leadershipStars = rom.getValueAt(relOffset + LEADERSHIP_STARS_OFFSET);
        mapSprite = rom.getValueAt(relOffset + MAP_SPRITE_OFFSET);
        randomBases = baseHp > 0x7F;
        
        if(!randomBases) {
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
        }
    }
    
    public void writeCharacter(Rom rom, int startingOffset) {
        int relOffset = startingOffset + (offset - 1) * CHARACTER_DATA_SIZE;
        
        if(oldValues.containsKey("baseHp")) {
            rom.setValueAt(relOffset + BASE_HP_OFFSET, baseHp);
        }
        
        if(oldValues.containsKey("baseAtk")) {
            rom.setValueAt(relOffset + BASE_ATK_OFFSET, baseAtk);
        }
        
        if(oldValues.containsKey("baseMag")) {
            rom.setValueAt(relOffset + BASE_MAG_OFFSET, baseMag);
        }
        
        if(oldValues.containsKey("baseSkl")) {
            rom.setValueAt(relOffset + BASE_SKL_OFFSET, baseSkl);
        }
        
        if(oldValues.containsKey("baseSpd")) {
            rom.setValueAt(relOffset + BASE_SPD_OFFSET, baseSpd);
        }
        
        if(oldValues.containsKey("baseDef")) {
            rom.setValueAt(relOffset + BASE_DEF_OFFSET, baseDef);
        }
        
        if(oldValues.containsKey("baseBld")) {
            rom.setValueAt(relOffset + BASE_BLD_OFFSET, baseBld);
        }
        
        if(oldValues.containsKey("baseLck")) {
            rom.setValueAt(relOffset + BASE_LCK_OFFSET, baseLck);
        }
        
        if(oldValues.containsKey("baseMov")) {
            rom.setValueAt(relOffset + BASE_MOV_OFFSET, baseMov);
        }
        
        if(oldValues.containsKey("movementStars")) {
            rom.setValueAt(relOffset + MOV_STARS_OFFSET, movementStars.getOffset());
        }
        
        if(oldValues.containsKey("counterCritBoost")) {
            rom.setValueAt(relOffset + MOV_STARS_OFFSET, counterCritBoost);
        }
        
        if(oldValues.containsKey("hpGrowth")) {
            rom.setValueAt(relOffset + HP_GROWTH_OFFSET, hpGrowth);
        }
        
        if(oldValues.containsKey("atkGrowth")) {
            rom.setValueAt(relOffset + ATK_GROWTH_OFFSET, atkGrowth);
        }
        
        if(oldValues.containsKey("magGrowth")) {
            rom.setValueAt(relOffset + MAG_GROWTH_OFFSET, magGrowth);
        }
        
        if(oldValues.containsKey("sklGrowth")) {
            rom.setValueAt(relOffset + SKL_GROWTH_OFFSET, sklGrowth);
        }
        
        if(oldValues.containsKey("spdGrowth")) {
            rom.setValueAt(relOffset + SPD_GROWTH_OFFSET, spdGrowth);
        }
        
        if(oldValues.containsKey("defGrowth")) {
            rom.setValueAt(relOffset + DEF_GROWTH_OFFSET, defGrowth);
        }
        
        if(oldValues.containsKey("bldGrowth")) {
            rom.setValueAt(relOffset + BLD_GROWTH_OFFSET, bldGrowth);
        }
        
        if(oldValues.containsKey("lckGrowth")) {
            rom.setValueAt(relOffset + LCK_GROWTH_OFFSET, lckGrowth);
        }
        
        if(oldValues.containsKey("movGrowth")) {
            rom.setValueAt(relOffset + MOV_GROWTH_OFFSET, movGrowth);
        }

        if(oldValues.containsKey("baseSwordLv")) {
            rom.setValueAt(relOffset + BASE_SWORD_LV_OFFSET, baseSwordLv.getAmount());
        }

        if(oldValues.containsKey("baseLanceLv")) {
            rom.setValueAt(relOffset + BASE_LANCE_LV_OFFSET, baseLanceLv.getAmount());
        }
        
        if(oldValues.containsKey("baseAxeLv")) {
            rom.setValueAt(relOffset + BASE_AXE_LV_OFFSET, baseAxeLv.getAmount());
        }
        
        if(oldValues.containsKey("baseBowLv")) {
            rom.setValueAt(relOffset + BASE_BOW_LV_OFFSET, baseBowLv.getAmount());
        }
        
        if(oldValues.containsKey("baseStaffLv")) {
            rom.setValueAt(relOffset + BASE_STAFF_LV_OFFSET, baseStaffLv.getAmount());
        }
        
        if(oldValues.containsKey("baseFireLv")) {
            rom.setValueAt(relOffset + BASE_FIRE_LV_OFFSET, baseFireLv.getAmount());
        }
        
        if(oldValues.containsKey("baseThunderLv")) {
            rom.setValueAt(relOffset + BASE_THUNDER_LV_OFFSET, baseThunderLv.getAmount());
        }
        
        if(oldValues.containsKey("baseWindLv")) {
            rom.setValueAt(relOffset + BASE_WIND_LV_OFFSET, baseWindLv.getAmount());
        }
        
        if(oldValues.containsKey("baseLightLv")) {
            rom.setValueAt(relOffset + BASE_LIGHT_LV_OFFSET, baseLightLv.getAmount());
        }
        
        if(oldValues.containsKey("baseDarkLv")) {
            rom.setValueAt(relOffset + BASE_DARK_LV_OFFSET, baseDarkLv.getAmount());
        }

        if(oldValues.containsKey("skills1")) {
            rom.setValueAt(relOffset + SKILL1_OFFSET, skills1);
        }
        
        if(oldValues.containsKey("skills2")) {
            rom.setValueAt(relOffset + SKILL2_OFFSET, skills2);
        }
        
        if(oldValues.containsKey("skills3")) {
            rom.setValueAt(relOffset + SKILL3_OFFSET, skills3);
        }

        if(oldValues.containsKey("characterClass")) {
            rom.setValueAt(relOffset + CLASS_OFFSET, characterClass.getOffset());
        }
        
        if(oldValues.containsKey("leadershipStars")) {
            rom.setValueAt(relOffset + LEADERSHIP_STARS_OFFSET, leadershipStars);
        }
        
        if(oldValues.containsKey("mapSprite")) {
            rom.setValueAt(relOffset + MAP_SPRITE_OFFSET, mapSprite);
        }
    }
    
    public int getOffset() {
        return offset;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean hasRandomBases() {
        return randomBases;
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

    public int getBaseLck() {
        return baseLck;
    }

    public int getBaseMov() {
        return baseMov;
    }

    public MovementStars getMovementStars() {
        return movementStars;
    }

    public int getCounterCritBoost() {
        return counterCritBoost;
    }

    public int getHpGrowth() {
        return hpGrowth;
    }

    public int getAtkGrowth() {
        return atkGrowth;
    }

    public int getMagGrowth() {
        return magGrowth;
    }

    public int getSklGrowth() {
        return sklGrowth;
    }

    public int getSpdGrowth() {
        return spdGrowth;
    }

    public int getDefGrowth() {
        return defGrowth;
    }

    public int getBldGrowth() {
        return bldGrowth;
    }

    public int getLckGrowth() {
        return lckGrowth;
    }

    public int getMovGrowth() {
        return movGrowth;
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

    public Gender getGender() {
        return gender;
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
        return new ArrayList<Skill>(skills);
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public int getLeadershipStars() {
        return leadershipStars;
    }
    
    public int getMapSprite() {
        return mapSprite;
    }
    
    public Map<String, Object> getOldValues() {
        return oldValues;
    }

    public void setBaseHp(int baseHp) {
        if(!oldValues.containsKey("baseHp") && this.baseHp != baseHp) {
            int oldValue = this.baseHp;
            oldValues.put("baseHp", oldValue);            
        }
        
        this.baseHp = baseHp;
    }
    
    public void setBaseAtk(int baseAtk) {
        if(!oldValues.containsKey("baseAtk") && this.baseAtk != baseAtk) {
            int oldValue = this.baseAtk;
            oldValues.put("baseAtk", oldValue);    
        }
        
        this.baseAtk = baseAtk;
    }

    public void setBaseMag(int baseMag) {
        if(!oldValues.containsKey("baseMag") && this.baseMag != baseMag) {
            int oldValue = this.baseMag;
            oldValues.put("baseMag", oldValue);
        }
        
        this.baseMag = baseMag;
    }

    public void setBaseSkl(int baseSkl) {
        if(!oldValues.containsKey("baseSkl") && this.baseSkl != baseSkl) {
            int oldValue = this.baseSkl;
            oldValues.put("baseSkl", oldValue);            
        }
        
        this.baseSkl = baseSkl;
    }

    public void setBaseSpd(int baseSpd) {
        if(!oldValues.containsKey("baseSpd") && this.baseSpd != baseSpd) {
            int oldValue = this.baseSpd;
            oldValues.put("baseSpd", oldValue);            
        }
        
        this.baseSpd = baseSpd;
    }

    public void setBaseDef(int baseDef) {
        if(!oldValues.containsKey("baseDef") && this.baseDef != baseDef) {
            int oldValue = this.baseDef;
            oldValues.put("baseDef", oldValue);    
        }
        
        this.baseDef = baseDef;
    }

    public void setBaseBld(int baseBld) {
        if(!oldValues.containsKey("baseBld") && this.baseBld != baseBld) {
            int oldValue = this.baseBld;
            oldValues.put("baseBld", oldValue);            
        }
        
        this.baseBld = baseBld;
    }

    public void setBaseLck(int baseLck) {
        if(!oldValues.containsKey("baseLck") && this.baseLck != baseLck) {
            int oldValue = this.baseLck;
            oldValues.put("baseLck", oldValue);    
        }
        
        this.baseLck = baseLck;
    }

    public void setBaseMov(int baseMov) {
        if(!oldValues.containsKey("baseMov") && this.baseMov != baseMov) {
            int oldValue = this.baseMov;
            oldValues.put("baseMov", oldValue);            
        }
        
        this.baseMov = baseMov;
    }

    public void setMovementStars(MovementStars movementStars) {
        if(!oldValues.containsKey("movementStars") && !this.movementStars.equals(movementStars)) {
            MovementStars oldValue = this.movementStars;
            oldValues.put("movementStars", oldValue);    
        }
        
        this.movementStars = movementStars;
    }

    public void setCounterCritBoost(int counterCritBoost) {
        if(!oldValues.containsKey("counterCritBoost") && this.counterCritBoost != counterCritBoost) {
            int oldValue = this.counterCritBoost;
            oldValues.put("counterCritBoost", oldValue);    
        }
        
        this.counterCritBoost = counterCritBoost;
    }

    public void setHpGrowth(int hpGrowth) {
        if(!oldValues.containsKey("hpGrowth") && this.hpGrowth != hpGrowth) {
            int oldValue = this.hpGrowth;
            oldValues.put("hpGrowth", oldValue);    
        }
        
        this.hpGrowth = hpGrowth;
    }

    public void setAtkGrowth(int atkGrowth) {
        if(!oldValues.containsKey("atkGrowth") && this.atkGrowth != atkGrowth) {
            int oldValue = this.atkGrowth;
            oldValues.put("atkGrowth", oldValue);            
        }
        
        this.atkGrowth = atkGrowth;
    }

    public void setMagGrowth(int magGrowth) {
        if(!oldValues.containsKey("magGrowth") && this.magGrowth != magGrowth) {
            int oldValue = this.magGrowth;
            oldValues.put("magGrowth", oldValue);            
        }
        
        this.magGrowth = magGrowth;
    }

    public void setSklGrowth(int sklGrowth) {
        if(!oldValues.containsKey("sklGrowth") && this.sklGrowth != sklGrowth) {
            int oldValue = this.sklGrowth;
            oldValues.put("sklGrowth", oldValue);
        }
        
        this.sklGrowth = sklGrowth;
    }

    public void setSpdGrowth(int spdGrowth) {
        if(!oldValues.containsKey("spdGrowth") && this.spdGrowth != spdGrowth) {
            int oldValue = this.spdGrowth;
            oldValues.put("spdGrowth", oldValue);
        }
        
        this.spdGrowth = spdGrowth;
    }

    public void setDefGrowth(int defGrowth) {
        if(!oldValues.containsKey("defGrowth") && this.defGrowth != defGrowth) {
            int oldValue = this.defGrowth;
            oldValues.put("defGrowth", oldValue);
        }
        
        this.defGrowth = defGrowth;
    }

    public void setBldGrowth(int bldGrowth) {
        if(!oldValues.containsKey("bldGrowth") && this.bldGrowth != bldGrowth) {
            int oldValue = this.bldGrowth;
            oldValues.put("bldGrowth", oldValue);    
        }
        
        this.bldGrowth = bldGrowth;
    }

    public void setLckGrowth(int lckGrowth) {
        if(!oldValues.containsKey("lckGrowth") && this.lckGrowth != lckGrowth) {
            int oldValue = this.lckGrowth;
            oldValues.put("lckGrowth", oldValue);    
        }
        
        this.lckGrowth = lckGrowth;
    }

    public void setMovGrowth(int movGrowth) {
        if(!oldValues.containsKey("movGrowth") && this.movGrowth != movGrowth) {
            int oldValue = this.movGrowth;
            oldValues.put("movGrowth", oldValue);
        }
        
        this.movGrowth = movGrowth;
    }

    public void setBaseSwordLv(int baseSwordLv) {
        if(!oldValues.containsKey("baseSwordLv") && this.baseSwordLv.getAmount() != baseSwordLv) {
            oldValues.put("baseSwordLv", this.baseSwordLv.getAmount());
        }
        
        this.baseSwordLv.setAmount(baseSwordLv);
    }

    public void setBaseLanceLv(int baseLanceLv) {
        if(!oldValues.containsKey("baseLanceLv") && this.baseLanceLv.getAmount() != baseLanceLv) {
            oldValues.put("baseLanceLv", this.baseLanceLv.getAmount());
        }
        
        this.baseLanceLv.setAmount(baseLanceLv);
    }

    public void setBaseAxeLv(int baseAxeLv) {
        if(!oldValues.containsKey("baseAxeLv") && this.baseAxeLv.getAmount() != baseAxeLv) {
            oldValues.put("baseAxeLv", this.baseAxeLv.getAmount());
        }
        
        this.baseAxeLv.setAmount(baseAxeLv);
    }

    public void setBaseBowLv(int baseBowLv) {
        if(!oldValues.containsKey("baseBowLv") && this.baseBowLv.getAmount() != baseBowLv) {
            oldValues.put("baseBowLv", this.baseBowLv.getAmount());
        }
        
        this.baseBowLv.setAmount(baseBowLv);
    }

    public void setBaseStaffLv(int baseStaffLv) {
        if(!oldValues.containsKey("baseStaffLv") && this.baseStaffLv.getAmount() != baseStaffLv) {
            oldValues.put("baseStaffLv", this.baseStaffLv.getAmount());
        }
        
        this.baseStaffLv.setAmount(baseStaffLv);
    }

    public void setBaseFireLv(int baseFireLv) {
        if(!oldValues.containsKey("baseFireLv") && this.baseFireLv.getAmount() != baseFireLv) {
            oldValues.put("baseFireLv", this.baseFireLv.getAmount());
        }
        
        this.baseFireLv.setAmount(baseFireLv);
    }

    public void setBaseThunderLv(int baseThunderLv) {
        if(!oldValues.containsKey("baseThunderLv") && this.baseThunderLv.getAmount() != baseThunderLv) {
            oldValues.put("baseThunderLv", this.baseThunderLv.getAmount());
        }
        
        this.baseThunderLv.setAmount(baseThunderLv);
    }

    public void setBaseWindLv(int baseWindLv) {
        if(!oldValues.containsKey("baseWindLv") && this.baseWindLv.getAmount() != baseWindLv) {
            oldValues.put("baseWindLv", this.baseWindLv.getAmount());
        }
        
        this.baseWindLv.setAmount(baseWindLv);
    }

    public void setBaseLightLv(int baseLightLv) {
        if(!oldValues.containsKey("baseLightLv") && this.baseLightLv.getAmount() != baseLightLv) {
            oldValues.put("baseLightLv", this.baseLightLv.getAmount());
        }
        
        this.baseLightLv.setAmount(baseLightLv);
    }

    public void setBaseDarkLv(int baseDarkLv) {
        if(!oldValues.containsKey("baseDarkLv") && this.baseDarkLv.getAmount() != baseDarkLv) {
            oldValues.put("baseDarkLv", this.baseDarkLv.getAmount());
        }
        
        this.baseDarkLv.setAmount(baseDarkLv);
    }

    public void setGender(Gender gender) {
        if(!oldValues.containsKey("gender") && !this.gender.equals(gender)) {
            Gender oldValue = this.gender;
            oldValues.put("gender", oldValue);
        }
        
        this.gender = gender;
    }

    public void setSkills(ArrayList<Skill> skills) {
        int[] newSkills = Skill.getSkills(skills);
        
        if(!oldValues.containsKey("skills1") && skills1 != newSkills[0]) {
            int oldSkills1 = this.skills1;
            oldValues.put("skills1", oldSkills1);
        }
        
        if(!oldValues.containsKey("skills2") && skills2 != newSkills[1]) {
            int oldSkills2 = this.skills2;
            oldValues.put("skills2", oldSkills2);
        }
        
        if(!oldValues.containsKey("skills3") && skills3 != newSkills[2]) {
            int oldSkills3 = this.skills3;
            oldValues.put("skills3", oldSkills3);
        }
        
        this.skills1 = newSkills[0];
        this.skills2 = newSkills[1];
        this.skills3 = newSkills[2];
        
        this.skills = skills;
    }

    public void setCharacterClass(CharacterClass characterClass, Random random) {
        if(!oldValues.containsKey("characterClass") && !this.characterClass.equals(characterClass)) {
            CharacterClass oldValue = this.characterClass;
            oldValues.put("characterClass", oldValue);
        }
        
        reassignWeaponLevels(characterClass, random);
        this.characterClass = characterClass;
        
        setMapSprite(characterClass.getMapSprite());
    }
    
    private void reassignWeaponLevels(CharacterClass newClass, Random random) {
        if(randomBases) {
            setBaseSwordLv(0);
            setBaseLanceLv(0);
            setBaseAxeLv(0);
            setBaseBowLv(0);
            setBaseStaffLv(0);
            setBaseFireLv(0);
            setBaseThunderLv(0);
            setBaseWindLv(0);
            setBaseLightLv(0);
            setBaseDarkLv(0);
            
            return;
        }
        
        ArrayList<ItemType> usableWeapons = newClass.getUsableWeaponTypes();
        CharacterClass mountComplement = mountData.getComplement(newClass);
        
        if(mountComplement != null) {
            ArrayList<ItemType> complementWeapons = mountComplement.getUsableWeaponTypes();
            
            for(ItemType currentItem : complementWeapons) {
                if(!usableWeapons.contains(currentItem)) {
                    usableWeapons.add(currentItem);
                }
            }
        }

        int totalWpnLv = 0;
        Map<ItemType, Integer> newWpnLevels = new HashMap<>();
        
        for(ItemType itemType : ItemType.getWeaponTypes()) {
            newWpnLevels.put(itemType, 0);
        }
        
        totalWpnLv += baseSwordLv.getAmount();
        totalWpnLv += baseLanceLv.getAmount();
        totalWpnLv += baseAxeLv.getAmount();
        totalWpnLv += baseBowLv.getAmount();
        totalWpnLv += baseStaffLv.getAmount();
        totalWpnLv += baseFireLv.getAmount();
        totalWpnLv += baseThunderLv.getAmount();
        totalWpnLv += baseWindLv.getAmount();
        totalWpnLv += baseLightLv.getAmount();
        totalWpnLv += baseDarkLv.getAmount();
                
        while(totalWpnLv > 0 && usableWeapons.size() > 0) {
            ItemType wpnType = usableWeapons.get(random.nextInt(usableWeapons.size()));
            int amount;
            
            if(totalWpnLv >= 50) {
                amount = 50;
                totalWpnLv -= 50;
            } else {
                amount = totalWpnLv;
                totalWpnLv = 0;
            }
            
            int prevValue = newWpnLevels.get(wpnType);
            prevValue += amount;
            
            if(prevValue >= 250) {
                prevValue = 250;
                usableWeapons.remove(wpnType);
            }
            
            newWpnLevels.put(wpnType, prevValue);
        }
         
        setBaseSwordLv(newWpnLevels.get(ItemType.SWORD));
        setBaseLanceLv(newWpnLevels.get(ItemType.LANCE));
        setBaseAxeLv(newWpnLevels.get(ItemType.AXE));
        setBaseBowLv(newWpnLevels.get(ItemType.BOW));
        setBaseStaffLv(newWpnLevels.get(ItemType.STAFF));
        setBaseFireLv(newWpnLevels.get(ItemType.FIRE));
        setBaseThunderLv(newWpnLevels.get(ItemType.THUNDER));
        setBaseWindLv(newWpnLevels.get(ItemType.WIND));
        setBaseLightLv(newWpnLevels.get(ItemType.LIGHT));
        setBaseDarkLv(newWpnLevels.get(ItemType.DARK));
    }

    public void setLeadershipStars(int leadershipStars) {
        if(!oldValues.containsKey("leadershipStars") && this.leadershipStars != leadershipStars) {
            int oldValue = this.leadershipStars;
            oldValues.put("leadershipStars", oldValue);
        }
        
        this.leadershipStars = leadershipStars;
    }
    
    public void setMapSprite(int mapSprite) {
        if(!oldValues.containsKey("mapSprite") && this.mapSprite != mapSprite) {
            int oldValue = this.mapSprite;
            oldValues.put("mapSprite", oldValue);
        }
        
        this.mapSprite = mapSprite;
    }
    
    public void reset() {
        if(isModified()) {
            if(oldValues.containsKey("baseHP")) {
                baseHp = (int)oldValues.get("baseHp");
            }
            
            if(oldValues.containsKey("baseAtk")) {
                baseAtk = (int)oldValues.get("baseAtk");
            }
            
            if(oldValues.containsKey("baseMag")) {
                baseMag = (int)oldValues.get("baseMag");
            }
            
            if(oldValues.containsKey("baseSkl")) {
                baseSkl = (int)oldValues.get("baseSkl");
            }
            
            if(oldValues.containsKey("baseSpd")) {
                baseSpd = (int)oldValues.get("baseSpd");
            }
            
            if(oldValues.containsKey("baseDef")) {
                baseDef = (int)oldValues.get("baseDef");
            }
            
            if(oldValues.containsKey("baseBld")) {
                baseBld = (int)oldValues.get("baseBld");
            }
            
            if(oldValues.containsKey("baseLck")) {
                baseLck = (int)oldValues.get("baseLck");
            }
            
            if(oldValues.containsKey("baseMov")) {
                baseMov = (int)oldValues.get("baseMov");
            }
            
            if(oldValues.containsKey("movementStars")) {
                movementStars = (MovementStars)oldValues.get("movementStars");
            }
            
            if(oldValues.containsKey("counterCritBoost")) {
                counterCritBoost = (int)oldValues.get("counterCritBoost");
            }
            
            if(oldValues.containsKey("hpGrowth")) {
                hpGrowth = (int)oldValues.get("hpGrowth");
            }
            
            if(oldValues.containsKey("atkGrowth")) {
                atkGrowth = (int)oldValues.get("atkGrowth");
            }
            
            if(oldValues.containsKey("magGrowth")) {
                magGrowth = (int)oldValues.get("magGrowth");
            }
            
            if(oldValues.containsKey("sklGrowth")) {
                sklGrowth = (int)oldValues.get("sklGrowth");
            }
            
            if(oldValues.containsKey("spdGrowth")) {
                spdGrowth = (int)oldValues.get("spdGrowth");
            }
            
            if(oldValues.containsKey("defGrowth")) {
                defGrowth = (int)oldValues.get("defGrowth");
            }
            
            if(oldValues.containsKey("bldGrowth")) {
                bldGrowth = (int)oldValues.get("bldGrowth");
            }
            
            if(oldValues.containsKey("lckGrowth")) {
                lckGrowth = (int)oldValues.get("lckGrowth");
            }
            
            if(oldValues.containsKey("movGrowth")) {
                movGrowth = (int)oldValues.get("movGrowth");
            }
            
            if(oldValues.containsKey("baseSwordLv")) {
                baseSwordLv.setAmount((int)oldValues.get("baseSwordLv"));
            }
            
            if(oldValues.containsKey("baseLanceLv")) {
                baseLanceLv.setAmount((int)oldValues.get("baseLanceLv"));
            }
            
            if(oldValues.containsKey("baseAxeLv")) {
                baseAxeLv.setAmount((int)oldValues.get("baseAxeLv"));
            }
            
            if(oldValues.containsKey("baseBowLv")) {
                baseBowLv.setAmount((int)oldValues.get("baseBowLv"));
            }
            
            if(oldValues.containsKey("baseStaffLv")) {
                baseStaffLv.setAmount((int)oldValues.get("baseStaffLv"));
            }
            
            if(oldValues.containsKey("baseFireLv")) {
                baseFireLv.setAmount((int)oldValues.get("baseFireLv"));
            }
            
            if(oldValues.containsKey("baseThunderLv")) {
                baseThunderLv.setAmount((int)oldValues.get("baseThunderLv"));
            }
            
            if(oldValues.containsKey("baseWindLv")) {
                baseWindLv.setAmount((int)oldValues.get("baseWindLv"));
            }
            
            if(oldValues.containsKey("baseLightLv")) {
                baseLightLv.setAmount((int)oldValues.get("baseLightLv"));
            }
            
            if(oldValues.containsKey("baseDarkLv")) {
                baseDarkLv.setAmount((int)oldValues.get("baseDarkLv"));
            }
            
            if(oldValues.containsKey("skills1")) {
                skills1 = (int)oldValues.get("skills1");
            }
            
            if(oldValues.containsKey("skills2")) {
                skills2 = (int)oldValues.get("skills2");
            }
            
            if(oldValues.containsKey("skills3")) {
                skills3 = (int)oldValues.get("skills3");
            }
            
            skills = Skill.getSkills(skills1, skills2, skills3);
            
            if(oldValues.containsKey("characterClass")) {
                characterClass = (CharacterClass)oldValues.get("characterClass");
            }
            
            if(oldValues.containsKey("leadershipStars")) {
                leadershipStars = (int)oldValues.get("leadershipStars");
            }
            
            if(oldValues.containsKey("mapSprite")) {
                mapSprite = (int)oldValues.get("mapSprite");
            }
            
            oldValues.clear();
        }
    }
    
    public boolean isModified() {
        return !oldValues.isEmpty();
    }
    
    public boolean isPlayableUnit() {
        return PLAYABLE_UNITS.contains(this);
    }
    
    public boolean isEnemyUnit() {
        return ENEMY_UNITS.contains(this);
    }
    
    public boolean isBoss() {
        return BOSSES.contains(this);
    }

    public static GameCharacter findById(int offset) {
        GameCharacter character = null;
        
        for(GameCharacter currentCharacter : GameCharacter.values()) {
            if(currentCharacter.offset == offset) {
                character = currentCharacter;
                break;
            }
        }
        
        if(character == null) {
            System.out.println(String.format("WARNING: Offset 0x%04X in GameCharacter was not found.", offset));
            character = GameCharacter.LEAF;
        }
        
        return character;
    }
    
    public static ArrayList<GameCharacter> getPlayableUnits() {
        return new ArrayList<GameCharacter>(PLAYABLE_UNITS);
    }
    
    public static ArrayList<GameCharacter> getEnemyUnits() {
        return new ArrayList<GameCharacter>(ENEMY_UNITS);
    }
    
    public static ArrayList<GameCharacter> getBossUnits() {
        return new ArrayList<GameCharacter>(BOSSES);
    }
    
    @Override
    public String toString() {
        String text;
        String skillsText = "";
        
        for(int i = 0; i < skills.size(); i++) {
            skillsText += skills.get(i).getName();
                    
            if(i < skills.size() - 1) {
                 skillsText += ", ";
            }
        }
        
        text = String.format("[CHARACTER] Name: %s, Class: %s, Gender: %s\n", name, characterClass.getName(), gender.getName());
        text += String.format("Bases Rnd bases: %b, HP: %d, Str: %d, Mag: %d, Skl: %d, Spd: %d, Def: %d, Bld: %d, Lck: %d, Mov: %d\n",
                randomBases, baseHp, baseAtk, baseMag, baseSkl, baseSpd, baseDef, baseBld, baseLck, baseMov);
        text += String.format("Mov stars: %d, Counter crit bonus: %d, Leadership stars: %d\n",
                movementStars.getAmount(), counterCritBoost, leadershipStars);
        text += String.format("Growths HP: %d, Str: %d, Mag: %d, Skl: %d, Spd: %d, Def: %d, Bld: %d, Lck: %d, Mov: %d\n",
                hpGrowth, atkGrowth, magGrowth, sklGrowth, spdGrowth, defGrowth, bldGrowth, lckGrowth, movGrowth);
        text += String.format("Base Wpn level Sword: %d, Lance: %d Axe: %d, Bow: %d, Staff: %d, Fire: %d, Thunder: %d, Wind: %d, Light: %d, Dark: %d\n",
                baseSwordLv.getAmount(), baseLanceLv.getAmount(), baseAxeLv.getAmount(), baseBowLv.getAmount(), baseStaffLv.getAmount(), baseFireLv.getAmount(), baseThunderLv.getAmount(), baseWindLv.getAmount(), baseLightLv.getAmount(), baseDarkLv.getAmount());
        text += String.format("Skill1: 0x%02X, Skill2: 0x%02X, Skill3: 0x%02X, (%s)",
                skills1, skills2, skills3, skillsText);
        
        return text; 
    }
}
