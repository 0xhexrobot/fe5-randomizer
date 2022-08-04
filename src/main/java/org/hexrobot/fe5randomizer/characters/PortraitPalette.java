package org.hexrobot.fe5randomizer.characters;

import org.hexrobot.fe5randomizer.ColorBGR555;
import org.hexrobot.fe5randomizer.ColorHSV;
import org.hexrobot.fe5randomizer.Rom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum PortraitPalette {
    LEAF(0x0, "Leaf", HairType.HAIR_1E0),
    FINN(0x01, "Finn", HairType.HAIR_1E0),
    NANNA(0x02, "Nanna", HairType.HAIR_1E0),
    HANNIBAL(0x03, "Hannibal", HairType.HAIR_1E0),
    YURIUS(0x04, "Yurius", HairType.HAIR_1E0),
    ISHTAR(0x05, "Ishtar", HairType.HAIR_E3),
    ARION(0x06, "Arion", HairType.HAIR_1E0),
    TRABANT(0x07, "Trabant", HairType.HAIR_1E0),
    CORPLE(0x08, "Corple", HairType.HAIR_1E0),
    CELICE(0x09, "Celice", HairType.HAIR_E0),
    LEAF_2(0x0A, "Leaf 2", HairType.HAIR_1E0),
    DELMUD(0x0B, "Delmud", HairType.HAIR_1E0),
    DAISY(0x0C, "Daisy", HairType.HAIR_1C0),
    ASAELLO(0x0D, "Asaello", HairType.HAIR_1C1),
    LEVIN(0x0E, "Levin", HairType.HAIR_1C1),
    YURIA(0x0F, "Yuria", HairType.HAIR_1E0),
    LARA(0x10, "Lara", HairType.HAIR_1C0),
    MIRANDA(0x11, "Miranda", HairType.HAIR_E0),
    RONAN(0x12, "Ronan", HairType.HAIR_E1),
    OTHIN(0x13, "Othin", HairType.HAIR_1E0),
    HALVAN(0x14, "Halvan", HairType.HAIR_1E0),
    DAGDA(0x15, "Dagda", HairType.HAIR_1C0),
    RALF(0x16, "Ralf", HairType.HAIR_1E0),
    EYVEL(0x17, "Eyvel", HairType.HAIR_1E0),
    MARTY(0x18, "Marty", HairType.HAIR_1E0),
    GALZUS(0x19, "Galzus", HairType.HAIR_1E0),
    ALVA(0x1A, "Alva", HairType.HAIR_1E0),
    XAVIER_GUARD_4(0x1B, "Xavier Guard 4", HairType.HAIR_E0),
    SELFINA(0x1C, "Selfina", HairType.HAIR_E1),
    HICKS(0x1D, "Hicks", HairType.HAIR_1E0),
    DALSHEIN(0x1E, "Dalshein", HairType.HAIR_E0),
    OLWEN(0x1F, "Olwen", HairType.HAIR_E1),
    PAHN(0x20, "Pahn", HairType.HAIR_E1),
    CARRION(0x21, "Carrion", HairType.HAIR_1E0),
    MAREETA(0x22, "Mareeta", HairType.HAIR_E1),
    ASVEL(0x24, "Asvel", HairType.HAIR_1E0),
    MACHYUA(0x25, "Machyua", HairType.HAIR_E1),
    SAPHY(0x26, "Saphy", HairType.HAIR_E0),
    MISHA(0x27, "Misha", HairType.HAIR_E1),
    SEIRAM(0x28, "Seiram", HairType.HAIR_1E0),
    SLEUF(0x29, "Sleuf", HairType.HAIR_1E0),
    FELGUS(0x2A, "Felgus", HairType.HAIR_1E0),
    BRIGHTON(0x2B, "Brighton", HairType.HAIR_E0),
    SARA(0x2C, "Sara", HairType.HAIR_F0),
    TANYA(0x2D, "Tanya", HairType.HAIR_E0),
    TREWD(0x2E, "Trewd", HairType.HAIR_E1),
    SHANAM(0x2F, "Shanam", HairType.HAIR_E1),
    TINA(0x30, "Tina", HairType.HAIR_E1),
    LINOAN(0x31, "Linoan", HairType.HAIR_E1),
    CYAS(0x32, "Cyas", HairType.HAIR_1E0),
    AMALDA(0x33, "Amalda", HairType.HAIR_E1),
    EDA(0x34, "Eda", HairType.HAIR_E1),
    REINHART(0x35, "Reinhart", HairType.HAIR_E0),
    GUNNA(0x36, "Gunna", HairType.HAIR_E2),
    FRED(0x37, "Fred", HairType.HAIR_1E0),
    KEIN(0x38, "Kein", HairType.HAIR_E1),
    ROBERTO(0x39, "Roberto", HairType.HAIR_1E1),
    KARIN(0x3A, "Karin", HairType.HAIR_E1),
    DEAN(0x3B, "Dean", HairType.HAIR_E1),
    LIFIS(0x3C, "Lifis", HairType.HAIR_E0),
    SETY(0x3D, "Sety", HairType.HAIR_1E0),
    ALTHENNA(0x3E, "Althenna", HairType.HAIR_1E0),
    HOMEROS(0x3F, "Homeros", HairType.HAIR_1E0),
    ARTHUR(0x40, "Arthur", HairType.HAIR_1E1),
    JANNE(0x41, "Janne", HairType.HAIR_1E0),
    XAVIER_GUARD_1(0x42, "Xavier Guard 1", HairType.HAIR_E0),
    XAVIER_GUARD_2(0x42, "Xavier Guard 2", HairType.HAIR_E0),
    EYRIOS(0x43, "Eyrios", HairType.HAIR_E1),
    XAVIER_GUARD_3(0x44, "Xavier Guard 3", HairType.HAIR_1E0),
    XAVIER(0x50, "Xavier", HairType.HAIR_E2),
    ZAOM_BOSS(0x51, "Zaom Boss", HairType.HAIR_1E0),
    GUSTAF_BOSS(0x52, "Gustaf Boss", HairType.HAIR_E2),
    DORIAS(0x53, "Dorias", HairType.HAIR_E0),
    ROBOS_BOSS(0x54, "Robos Boss", HairType.HAIR_E2),
    GLADE(0x55, "Glade", HairType.HAIR_1E1),
    XAVIER_GUARD_5(0x56, "Xavier Guard 5", HairType.HAIR_E0),
    AIGHTMAN_BOSS(0x57, "Aightman Boss", HairType.HAIR_E1),
    FERDEN_BOSS(0x58, "Ferden Boss", HairType.HAIR_E0),
    AUGUST(0x59, "August", HairType.HAIR_E0),
    WEISSMAN_BOSS(0x5A, "Weissman Boss", HairType.HAIR_E0),
    LUMEI_BOSS(0x5B, "Lumei Boss", HairType.HAIR_E1),
    OLTOV_BOSS(0x5C, "Oltov Boss", HairType.HAIR_E0),
    KODDA_BOSS(0x5D, "Kodda Boss", HairType.HAIR_1E0),
    XAVIER_GUARD_6(0x5E, "Xavier Guard 6", HairType.HAIR_E0),
    IZENAU_BOSS(0x5F, "Izenau Boss", HairType.HAIR_E2),
    JABAL(0x60, "Jabal", HairType.HAIR_E0),
    ZAIL_BOSS(0x61, "Zail Boss", HairType.HAIR_1E0),
    KOLHO_BOSS(0x62, "Kolho Boss", HairType.HAIR_1E0),
    GOMEZ_BOSS(0x63, "Gomez Boss", HairType.HAIR_1E0),
    BUGS(0x64, "Bugs", HairType.HAIR_1E0),
    SHIVA(0x65, "Shiva", HairType.HAIR_1E0),
    LEIDRICK(0x66, "Leidrick", HairType.HAIR_E0),
    TORMAN_BOSS(0x67, "Torman Boss", HairType.HAIR_E2),
    BLUME(0x68, "Blume", HairType.HAIR_E3),
    MANFROY(0x69, "Manfroy", HairType.HAIR_E0),
    BARRAT_BOSS(0x6A, "Barrat Boss", HairType.HAIR_1E0),
    CONOMORE(0x6B, "Conomore", HairType.HAIR_E0),
    KEMPF(0x6C, "Kempf", HairType.HAIR_1E0),
    BELDO(0x6D, "Beldo", HairType.HAIR_1E0),
    VENDOR(0x70, "Vendor", HairType.HAIR_E0),
    ARENA(0x71, "Arena", HairType.HAIR_E0),
    VILLAGE_MAN_1A(0x72, "Village Man 1A", HairType.HAIR_1E0),
    BLACKSMITH(0x73, "Blacksmith", HairType.HAIR_E0),
    ANNA(0x74, "Anna", HairType.HAIR_1C1),
    OLD_WOMAN_1(0x75, "Old Woman 1", HairType.HAIR_E2),
    VILLAGE_MAN_2(0x76, "Village Man 2", HairType.HAIR_E0),
    OLD_WOMAN_2(0x77, "Old Woman 2", HairType.HAIR_E2),
    VILLAGE_GIRL_1(0x78, "Village Girl 1", HairType.HAIR_1E0),
    OLD_MAN_1(0x79, "Old Man 1", HairType.HAIR_E2),
    VILLAGE_GIRL_2A(0x7A, "Village Girl 2A", HairType.HAIR_1E0),
    VILLAGE_BOY_1(0x7B, "Village Boy 1", HairType.HAIR_1E0),
    OLD_MAN_2(0x7C, "Old Man 2", HairType.HAIR_E2),
    VILLAGE_GIRL_3(0x7D, "Village Girl 3", HairType.HAIR_1E0),
    VILLAGE_GIRL_4(0x7E, "Village Girl 4", HairType.HAIR_1E0),
    VILLAGE_BOY_2(0x7F, "Village Boy 2", HairType.HAIR_1E0),
    VILLAGE_BOY_3(0x80, "Village Boy 3", HairType.HAIR_E0),
    VILLAGE_MAN_3(0x81, "Village Man 3", HairType.HAIR_E0),
    VILLAGE_MAN_4(0x82, "Village Man 4", HairType.HAIR_1E0),
    KORUTA_BOSS(0xC0, "Koruta Boss", HairType.HAIR_1E0),
    UNUSED_BOSS_1(0xC1, "Unused Boss 1", HairType.HAIR_1E0),
    MACLOY_BOSS(0xC2, "Macloy Boss", HairType.HAIR_E2),
    UNUSED_BOSS_2(0xC3, "Unused Boss 2", HairType.HAIR_E2),
    MYURA_BOSS(0xC4, "Myura Boss", HairType.HAIR_E1),
    SEMITOL_BOSS(0xC5, "Semitol Boss", HairType.HAIR_E1),
    UNUSED_BOSS_4(0xC6, "Unused Boss 4", HairType.HAIR_E1),
    UNUSED_BOSS_5(0xC7, "Unused Boss 5", HairType.HAIR_E0),
    UNUSED_BOSS_6(0xC8, "Unused Boss 6", HairType.HAIR_E0),
    MALLOC_BOSS(0xC9, "Malloc Boss", HairType.HAIR_E0),
    PHLAUS_BOSS(0xCA, "Phlaus Boss", HairType.HAIR_E0),
    UNUSED_BOSS_3(0xCB, "Unused Boss 3", HairType.HAIR_E0),
    MUUA_BOSS(0xCC, "Muua Boss", HairType.HAIR_1E0),
    REINCOCK_BOSS(0xCD, "Reincock Boss", HairType.HAIR_1E0),
    ALPHAN_BOSS(0xCE, "Alphan Boss", HairType.HAIR_1E0),
    UNUSED_BOSS_7(0xCF, "Unused Boss 7", HairType.HAIR_E0),
    RIST_BOSS(0xD0, "Rist Boss", HairType.HAIR_E0),
    WOLF_BOSS(0xD1, "Wolf Boss", HairType.HAIR_E0),
    PALUCE_BOSS(0xD2, "Paluce Boss", HairType.HAIR_E2),
    PALMAN_BOSS(0xD3, "Palman Boss", HairType.HAIR_E2),
    UNUSED_BOSS_8(0xD4, "Unused Boss 8", HairType.HAIR_E2),
    BALDACK_BOSS(0xD5, "Baldack Boss", HairType.HAIR_E2),
    BLUKE_BOSS(0xD6, "Bluke Boss", HairType.HAIR_E2),
    VILLAGE_MAN_1B(0xD7, "Village Man 1B", HairType.HAIR_1E0),
    VILLAGE_MAN_1C(0xD8, "Village Man 1C", HairType.HAIR_1E0),
    VILLAGE_MAN_1D(0xD9, "Village Man 1D", HairType.HAIR_1E0),
    VILLAGE_MAN_1E(0xDA, "Village Man 1E", HairType.HAIR_1E0),
    VILLAGE_GIRL_2B(0xE5, "Village Girl 2B", HairType.HAIR_1E0),
    VILLAGE_GIRL_2C(0xE6, "Village Girl 2C", HairType.HAIR_1E0),
    VILLAGE_GIRL_2D(0xE7, "Village Girl 2D", HairType.HAIR_1E0),
    VILLAGE_GIRL_2E(0xE8, "Village Girl 2E", HairType.HAIR_1E0),
    FUNF_EYVEL(0xED, "Funf Eyvel", HairType.HAIR_1E0),
    DREI_DAGDA(0xEE, "Drei Dagda", HairType.HAIR_1C0),
    ELF_SARA(0xEF, "Elf Sara", HairType.HAIR_F0),
    ZWOLF_LIFIS(0xF0, "Zwolf Lifis", HairType.HAIR_E0),
    ZWEI_GALZUS(0xF1, "Zwei Galzus", HairType.HAIR_1E0),
    EINS_LEIDRICK(0xF2, "Eins Leidrick", HairType.HAIR_E0);

    private static final int PALETTE_OFFSET = 0x354000;
    private static final int PALETTE_SIZE = 32;
    private int offset;
    private String label;
    private HairType hairType;
    private ColorBGR555[] palette = new ColorBGR555[PALETTE_SIZE / 2];
    private ColorBGR555[] oldPalette = new ColorBGR555[0];
    private static ArrayList<PortraitPalette> excluded = new ArrayList<>(List.of(JABAL, VILLAGE_MAN_1A,
            VILLAGE_MAN_1B, VILLAGE_MAN_1C, VILLAGE_MAN_1D, VILLAGE_MAN_1E, FUNF_EYVEL, DREI_DAGDA,
            ELF_SARA, ZWOLF_LIFIS, ZWEI_GALZUS, EINS_LEIDRICK));

    private PortraitPalette(int offset, String label, HairType hairType) {
        this.offset = offset;
        this.label = label;
        this.hairType = hairType;
    }

    public int getOffset() {
        return offset;
    }

    public String getLabel() {
        return label;
    }

    public HairType getHairType() {
        return hairType;
    }

    public ColorBGR555[] getPalette() {
        return palette;
    }

    public ColorBGR555[] getOldPalette() {
        return oldPalette;
    }

    public void setPalette(ColorBGR555 palette[]) {
        if(oldPalette.length == 0) {
            oldPalette = this.palette;
        }

        this.palette = palette;
    }

    public static void readAll(Rom rom) {
        for (PortraitPalette portrait : values()) {
            portrait.readPalette(rom, PALETTE_OFFSET);
        }
    }

    public static void writeAll(Rom rom) {
        for (PortraitPalette portrait : values()) {
            portrait.writePalette(rom, PALETTE_OFFSET);
        }
    }

    public static void resetAll() {
        for (PortraitPalette portrait : values()) {
            portrait.reset();
        }
    }

    public boolean isModified() {
        return oldPalette.length > 0;
    }

    private void reset() {
        if(oldPalette.length > 0) {
            palette = oldPalette;
            oldPalette = new ColorBGR555[0];
        }
    }

    private void readPalette(Rom rom, int startingOffset) {
        int relOffset = startingOffset + offset * PALETTE_SIZE;

        for (int i = 0; i < PALETTE_SIZE / 2; i++) {
            int rawColor = rom.get2ByteValueAt(relOffset + i * 2);
            palette[i] = new ColorBGR555(rawColor);
        }

        fixLastGreen();
    }

    private void writePalette(Rom rom, int startingOffset) {
        int relOffset = startingOffset + offset * PALETTE_SIZE;

        if(oldPalette.length > 0) {
            for (int i = 0; i < PALETTE_SIZE / 2; i++) {
                rom.set2ByteValueAt(relOffset + i * 2, palette[i].toRawInt());
            }
        }
    }

    // fixes last color
    private void fixLastGreen() {
        ArrayList<PortraitPalette> lastGreen = new ArrayList<>(List.of(
                YURIUS, YURIA, HICKS, GUNNA, JABAL, KOLHO_BOSS, LEIDRICK, MANFROY, BARRAT_BOSS, BELDO,
                VENDOR, ARENA, BLACKSMITH, EINS_LEIDRICK));

        for(PortraitPalette pal : lastGreen) {
            pal.palette[15] = pal.palette[5];
        }
    }

    public enum HairType {
        HAIR_1E0, HAIR_E0, HAIR_1C0, HAIR_1C1, HAIR_1E1, HAIR_F0, HAIR_E1, HAIR_E2, HAIR_E3
    }

    public HairType getPaletteHairType() {
        return hairType;
    }

    public static ArrayList<PortraitPalette> getAvailablePalettes() {
        ArrayList<PortraitPalette> availablePalettes = new ArrayList<>(Arrays.asList(values()));
        availablePalettes.removeAll(excluded);

        return availablePalettes;
    }
    
    public ColorBGR555[] getPaletteDeadified() {
        ColorBGR555[] pal = palette.clone();

        for (int i = 0; i < pal.length; i++) {
            pal[i] = ColorBGR555.deadify(pal[i]);
        }

        return pal;
    }

    public static ColorBGR555[] getPaletteConverted(HairType inputType, ColorBGR555[] inputPalette,
                                                    HairType outputType) {
        ColorBGR555[] pal = inputPalette.clone();

        if(inputType.equals(outputType)) {
            return pal;
        }

        switch(inputType) {
            case HAIR_1E0: {
                switch(outputType) {
                    case HAIR_E0:
                        pal = convertHair1E0ToE0(pal); break;
                    case HAIR_F0:
                        pal = convertHair1E0ToF0(pal); break;
                    case HAIR_1C0:
                        pal = convertHair1E0To1C0(pal); break;
                    case HAIR_E1:
                        pal = convertHair1E0ToE1(pal); break;
                    case HAIR_E2:
                        pal = convertHair1E0ToE2(pal); break;
                    case HAIR_1C1:
                        pal = convertHair1E0To1C1(pal); break;
                    case HAIR_1E1:
                        pal = convertHair1E0To1E1(pal); break;
                    case HAIR_E3:
                        pal = convertHair1E0ToE3(pal); break;
                }
            } break;
            case HAIR_E0: {
                switch(outputType) {
                    case HAIR_1E0:
                        pal = convertHairE0To1E0(pal); break;
                    case HAIR_F0:
                        pal = convertHairE0To1E0(pal);
                        pal = convertHair1E0ToF0(pal); break;
                    case HAIR_1C0:
                        pal = convertHairE0To1C0(pal); break;
                    case HAIR_E1:
                        pal = convertHairE0ToE1(pal); break;
                    case HAIR_E2:
                        pal = convertHairE0To1E0(pal);
                        pal = convertHair1E0ToE2(pal); break;
                    case HAIR_1C1:
                        pal = convertHairE0To1E0(pal);
                        pal = convertHair1E0To1C1(pal); break;
                    case HAIR_1E1:
                        pal = convertHairE0To1E0(pal);
                        pal = convertHair1E0To1E1(pal); break;
                    case HAIR_E3:
                        pal = convertHairE0To1E0(pal);
                        pal = convertHair1E0ToE3(pal); break;
                }
            } break;
            case HAIR_E1: {
                switch(outputType) {
                    case HAIR_1E0:
                        pal = convertHairE1To1E0(pal); break;
                    case HAIR_F0:
                        pal = convertHairE1To1E0(pal);
                        pal = convertHair1E0ToF0(pal); break;
                    case HAIR_1C0:
                        pal = convertHairE1ToE0(pal);
                        pal = convertHairE0To1C0(pal); break;
                    case HAIR_E0:
                        pal = convertHairE1ToE0(pal); break;
                    case HAIR_E2:
                        pal = convertHairE1ToE0(pal);
                        pal = convertHairE0ToE2(pal); break;
                    case HAIR_1C1:
                        pal = convertHairE1To1E0(pal);
                        pal = convertHair1E0To1C1(pal); break;
                    case HAIR_1E1:
                        pal = convertHairE1To1E0(pal);
                        pal = convertHair1E0To1E1(pal); break;
                    case HAIR_E3:
                        pal = convertHairE1To1E0(pal);
                        pal = convertHair1E0ToE3(pal); break;
                }
            } break;
            case HAIR_F0: {
                switch(outputType) {
                    case HAIR_1E0:
                        pal = convertHairF0To1E0(pal); break;
                    case HAIR_E0:
                        pal = convertHairF0To1E0(pal);
                        pal = convertHair1E0ToE0(pal); break;
                    case HAIR_1C0:
                        pal = convertHairF0To1E0(pal);
                        pal = convertHair1E0To1C0(pal); break;
                    case HAIR_E1:
                        pal = convertHairF0To1E0(pal);
                        pal = convertHair1E0ToE1(pal); break;
                    case HAIR_E2:
                        pal = convertHairF0To1E0(pal);
                        pal = convertHair1E0ToE0(pal);
                        pal = convertHairE0ToE2(pal); break;
                    case HAIR_1C1:
                        pal = convertHairF0To1E0(pal);
                        pal = convertHair1E0To1C1(pal); break;
                    case HAIR_1E1:
                        pal = convertHairF0To1E0(pal);
                        pal = convertHair1E0To1E1(pal); break;
                    case HAIR_E3:
                        pal = convertHairF0To1E0(pal);
                        pal = convertHair1E0ToE3(pal); break;
                }
            } break;
            case HAIR_1C0: {
                switch(outputType) {
                    case HAIR_1E0:
                        pal = convertHair1C0To1E0(pal); break;
                    case HAIR_E0:
                        pal = convertHair1C0ToE0(pal); break;
                    case HAIR_F0:
                        pal = convertHair1C0To1E0(pal);
                        pal = convertHair1E0ToF0(pal); break;
                    case HAIR_E1:
                        pal = convertHair1C0ToE0(pal);
                        pal = convertHairE0ToE1(pal); break;
                    case HAIR_E2:
                        pal = convertHair1C0To1E0(pal);
                        pal = convertHair1E0ToE2(pal); break;
                    case HAIR_1C1:
                        pal = convertHair1C0To1E0(pal);
                        pal = convertHair1E0To1C1(pal); break;
                    case HAIR_1E1:
                        pal = convertHair1C0To1E0(pal);
                        pal = convertHair1E0To1E1(pal); break;
                    case HAIR_E3:
                        pal = convertHair1C0To1E0(pal);
                        pal = convertHair1E0ToE3(pal); break;
                }
            } break;
            case HAIR_E2: {
                switch(outputType) {
                    case HAIR_1E0:
                        pal = convertHairE2To1E0(pal); break;
                    case HAIR_E0:
                        pal = convertHairE2ToE0(pal); break;
                    case HAIR_F0:
                        pal = convertHairE2To1E0(pal);
                        pal = convertHair1E0ToF0(pal); break;
                    case HAIR_1C0:
                        pal = convertHairE2To1E0(pal);
                        pal = convertHair1E0To1C0(pal); break;
                    case HAIR_E1:
                        pal = convertHairE2ToE0(pal);
                        pal = convertHairE0ToE1(pal); break;
                    case HAIR_1C1:
                        pal = convertHairE2To1E0(pal);
                        pal = convertHair1E0To1C1(pal); break;
                    case HAIR_1E1:
                        pal = convertHairE2To1E0(pal);
                        pal = convertHair1E0To1E1(pal); break;
                    case HAIR_E3:
                        pal = convertHairE2To1E0(pal);
                        pal = convertHair1E0ToE3(pal); break;
                }
            } break;
            case HAIR_1C1: {
                switch(outputType) {
                    case HAIR_E0:
                        pal = convertHair1C1To1E0(pal);
                        pal = convertHair1E0ToE0(pal); break;
                    case HAIR_F0:
                        pal = convertHair1C1To1E0(pal);
                        pal = convertHair1E0ToF0(pal); break;
                    case HAIR_1C0:
                        pal = convertHair1C1To1E0(pal);
                        pal = convertHair1E0To1C0(pal); break;
                    case HAIR_E1:
                        pal = convertHair1C1To1E0(pal);
                        pal = convertHair1E0ToE1(pal); break;
                    case HAIR_E2:
                        pal = convertHair1C1To1E0(pal);
                        pal = convertHair1E0ToE2(pal); break;
                    case HAIR_1E0:
                        pal = convertHair1C1To1E0(pal); break;
                    case HAIR_1E1:
                        pal = convertHair1C1To1E0(pal);
                        pal = convertHair1E0To1E1(pal); break;
                    case HAIR_E3:
                        pal = convertHair1C1To1E0(pal);
                        pal = convertHair1E0ToE3(pal); break;
                }
            } break;
            case HAIR_1E1: {
                switch(outputType) {
                    case HAIR_E0:
                        pal = convertHair1E1To1E0(pal);
                        pal = convertHair1E0ToE0(pal); break;
                    case HAIR_F0:
                        pal = convertHair1E1To1E0(pal);
                        pal = convertHair1E0ToF0(pal); break;
                    case HAIR_1C0:
                        pal = convertHair1E1To1E0(pal);
                        pal = convertHair1E0To1C0(pal); break;
                    case HAIR_E1:
                        pal = convertHair1E1To1E0(pal);
                        pal = convertHair1E0ToE1(pal); break;
                    case HAIR_E2:
                        pal = convertHair1E1To1E0(pal);
                        pal = convertHair1E0ToE2(pal); break;
                    case HAIR_1C1:
                        pal = convertHair1E1To1E0(pal);
                        pal = convertHair1E0To1C1(pal); break;
                    case HAIR_1E0:
                        pal = convertHair1E1To1E0(pal); break;
                    case HAIR_E3:
                        pal = convertHair1E1To1E0(pal);
                        pal = convertHair1E0ToE3(pal); break;
                }
            } break;
            case HAIR_E3: {
                switch(outputType) {
                    case HAIR_E0:
                        pal = convertHairE3To1E0(pal);
                        pal = convertHair1E0ToE0(pal); break;
                    case HAIR_F0:
                        pal = convertHairE3To1E0(pal);
                        pal = convertHair1E0ToF0(pal); break;
                    case HAIR_1C0:
                        pal = convertHairE3To1E0(pal);
                        pal = convertHair1E0To1C0(pal); break;
                    case HAIR_E1:
                        pal = convertHairE3To1E0(pal);
                        pal = convertHair1E0ToE1(pal); break;
                    case HAIR_E2:
                        pal = convertHairE3To1E0(pal);
                        pal = convertHair1E0ToE2(pal); break;
                    case HAIR_1C1:
                        pal = convertHairE3To1E0(pal);
                        pal = convertHair1E0To1C1(pal); break;
                    case HAIR_1E1:
                        pal = convertHairE3To1E0(pal);
                        pal = convertHair1E0To1E1(pal); break;
                    case HAIR_1E0:
                        pal = convertHairE3To1E0(pal); break;
                }
            } break;
        }

        return pal;
    }

    private static ColorBGR555[] convertHair1E0ToE0(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();

        pal[10] = pal[9];
        pal[9] = pal[8];
        pal[8] = pal[7];
        pal[7] = ColorBGR555.lighten(pal[15], 0.2f);

        return pal;
    }

    private static ColorBGR555[] convertHairE0To1E0(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();

        pal[7] = ColorBGR555.lighten(pal[8], 0.15f);
        pal[9] = ColorBGR555.darken(pal[9], 0.1f);
        pal[10] = ColorBGR555.darken(pal[10], 0.15f);

        return pal;
    }

    private static ColorBGR555[] convertHair1E0ToF0(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();

        ColorBGR555 temp = pal[11];
        pal[11] = pal[10];
        pal[10] = pal[9];
        pal[9] = pal[8];
        pal[8] = pal[7];
        pal[7] = temp;

        return pal;
    }

    private static ColorBGR555[] convertHairF0To1E0(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();

        ColorBGR555 temp = pal[7];
        pal[7] = pal[8];
        pal[8] = pal[9];
        pal[9] = pal[10];
        pal[10] = pal[11];
        pal[11] = temp;

        return pal;
    }

    private static ColorBGR555[] convertHair1C0ToE0(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();

        ColorBGR555 temp = pal[10];
        pal[10] = pal[9];
        pal[9] = pal[8];
        pal[8] = pal[7];
        pal[7] = temp;

        return pal;
    }

    private static ColorBGR555[] convertHairE0To1C0(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();

        pal[7] = pal[8];
        pal[8] = pal[9];
        pal[9] = pal[10];
        pal[10] = ColorBGR555.darken(pal[11], 0.15f);

        return pal;
    }

    private static ColorBGR555[] convertHair1C0To1E0(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();

        pal[10] = pal[9];
        pal[9] = pal[8];
        pal[8] = pal[7];
        pal[7] = ColorBGR555.lighten(pal[8], 0.1f);

        return pal;
    }

    private static ColorBGR555[] convertHair1E0To1C0(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();

        pal[7] = pal[8];
        pal[8] = pal[9];
        pal[9] = pal[10];
        pal[10] = ColorBGR555.darken(pal[11], 0.2f);

        return pal;
    }

    public static ColorBGR555[] convertHairE1ToE0(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();
        pal[15] = ColorBGR555.darken(pal[7], 0.1f);

        return pal;
    }

    public static ColorBGR555[] convertHairE0ToE1(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();
        pal[15] = ColorBGR555.darken(pal[9], 0.1f);

        return pal;
    }

    public static ColorBGR555[] convertHair1E0ToE2(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();
        pal[15] = pal[12];
        pal[14] = ColorBGR555.lighten(pal[7], 0.1f);

        ColorHSV col = new ColorHSV(pal[11]);
        col.shiftHue(-50.0f);
        col.shiftValue(-0.15f);
        pal[7] =  col.getAsColorBGR555();

        return pal;
    }

    public static ColorBGR555[] convertHairE2To1E0(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();
        pal[7] = pal[14];

        return pal;
    }

    public static ColorBGR555[] convertHairE2ToE0(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();
        // do nothing?
        return pal;
    }

    public static ColorBGR555[] convertHairE0ToE2(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();
        pal[14] = ColorBGR555.lighten(pal[8], 0.2f);

        return pal;
    }

    public static ColorBGR555[] convertHair1E0To1C1(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();
        pal[15] = ColorBGR555.darken(pal[9], 0.1f);
        pal[7] = pal[8];
        pal[8] = pal[9];
        pal[9] = pal[10];
        pal[10] = pal[11];
        pal[11] = ColorBGR555.darken(pal[12], 0.1f);

        return pal;
    }

    public static ColorBGR555[] convertHair1C1To1E0(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();
        ColorBGR555 temp = pal[15];
        pal[15] = pal[10];
        pal[10] = temp;

        return pal;
    }

    public static ColorBGR555[] convertHair1E0To1E1(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();
        pal[15] = ColorBGR555.lighten(pal[10], 0.1f);

        return pal;
    }

    public static ColorBGR555[] convertHair1E1To1E0(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();
        pal[15] = ColorBGR555.darken(pal[11], 0.1f);

        return pal;
    }

    public static ColorBGR555[] convertHair1E0ToE3(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();
        pal[14] = pal[7];
        pal[7] = pal[15];
        pal[15] = ColorBGR555.darken(pal[9], 0.1f);

        return pal;
    }

    public static ColorBGR555[] convertHairE3To1E0(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();
        pal[7] = pal[14];

        return pal;
    }

    public static ColorBGR555[] convertHair1E0ToE1(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();

        pal[15] = pal[10];
        pal[10] = pal[9];
        pal[9] = pal[8];
        pal[8] = pal[7];

        ColorHSV col = new ColorHSV(pal[11]);
        col.shiftHue(-30.0f);
        col.shiftValue(-0.1f);
        pal[7] = col.getAsColorBGR555();

        return pal;
    }

    public static ColorBGR555[] convertHairE1To1E0(ColorBGR555[] inputPalette) {
        ColorBGR555[] pal = inputPalette.clone();
        pal[15] = ColorBGR555.darken(pal[11], 0.2f);
        pal[7] = ColorBGR555.lighten(pal[8], 0.15f);

        return pal;
    }
}
