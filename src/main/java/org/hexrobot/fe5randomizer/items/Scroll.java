package org.hexrobot.fe5randomizer.items;

import java.util.HashMap;
import java.util.Map;

import org.hexrobot.fe5randomizer.Rom;

public enum Scroll {
    ODO_SCROLL(0x0, "Odo Scroll"),
    BALDO_SCROLL(0x1, "Baldo Scroll"),
    HEZUL_SCROLL(0x2, "Hezul Scroll"),
    DAIN_SCROLL(0x3, "Dain Scroll"),
    NOBA_SCROLL(0x4, "Noba Scroll"),
    NEIR_SCROLL(0x5, "Neir Scroll"),
    ULIR_SCROLL(0x6, "Ulir Scroll"),
    TORDO_SCROLL(0x7, "Tordo Scroll"),
    FALA_SCROLL(0x8, "Fala Scroll"),
    SETY_SCROLL(0x9, "Sety Scroll"),
    BLAGGI_SCROLL(0xA, "Blaggi Scroll"),
    HEIM_SCROLL(0xB, "Heim Scroll");
    
    private static final int SCROLLS_OFFSET = 0x40054;
    private static final int SCROLLS_DATA_SIZE = 10;
    private static final int HP_OFFSET = 0x1;
    private static final int ATK_OFFSET = 0x2;
    private static final int MAG_OFFSET = 0x3;
    private static final int SKL_OFFSET = 0x4;
    private static final int SPD_OFFSET = 0x5;
    private static final int LCK_OFFSET = 0x6;
    private static final int DEF_OFFSET = 0x7;
    private static final int BLD_OFFSET = 0x8;
    private static final int MOV_OFFSET = 0x9;
    private int offset;
    private String name;
    private int hp = -1;
    private int atk = -1;
    private int mag = -1;
    private int skl = -1;
    private int spd = -1;
    private int lck = -1;
    private int def = -1;
    private int bld = -1;
    private int mov = -1;
    private Map<String, Object> oldValues = new HashMap<>();
    
    private Scroll(int offset, String name) {
        this.offset = offset;
        this.name = name;
    }
    
    public int getOffset() {
        return offset;
    }
    
    public String getName() {
        return name;
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

    public void setHp(int hp) {
        if(oldValues.containsKey("hp")) {
            if((int)oldValues.get("hp") == hp) {
                oldValues.remove("hp");
            }
        } else {
            if(this.hp != hp) {
                oldValues.put("hp", this.hp);
            }
        }
        
        this.hp = hp;
    }

    public void setAtk(int atk) {
        if(!oldValues.containsKey("atk") && this.atk != atk) {
            oldValues.put("atk", this.atk);
        } else if(oldValues.containsKey("atk") && (int)oldValues.get("atk") == atk) {
            oldValues.remove("atk");
        }
        
        this.atk = atk;
    }

    public void setMag(int mag) {
        if(!oldValues.containsKey("mag") && this.mag != mag) {
            oldValues.put("mag", this.mag);
        } else if(oldValues.containsKey("mag") && (int)oldValues.get("mag") == mag) {
            oldValues.remove("mag");
        }
        
        this.mag = mag;
    }

    public void setSkl(int skl) {
        if(!oldValues.containsKey("skl") && this.skl != skl) {
            oldValues.put("skl", this.skl);
        } else if(oldValues.containsKey("skl") && (int)oldValues.get("skl") == skl) {
            oldValues.remove("skl");
        }
        
        this.skl = skl;
    }

    public void setSpd(int spd) {
        if(!oldValues.containsKey("spd") && this.spd != spd) {
            oldValues.put("spd", this.spd);
        } else if(oldValues.containsKey("spd") && (int)oldValues.get("spd") == spd) {
            oldValues.remove("spd");
        }
        
        this.spd = spd;
    }

    public void setLck(int lck) {
        if(!oldValues.containsKey("lck") && this.lck != lck) {
            oldValues.put("lck", this.lck);
        } else if(oldValues.containsKey("lck") && (int)oldValues.get("lck") == lck) {
            oldValues.remove("lck");
        }
        
        this.lck = lck;
    }

    public void setDef(int def) {
        if(!oldValues.containsKey("def") && this.def != def) {
            oldValues.put("def", this.def);
        } else if(oldValues.containsKey("def") && (int)oldValues.get("def") == def) {
            oldValues.remove("def");
        }
        
        this.def = def;
    }

    public void setBld(int bld) {
        if(!oldValues.containsKey("bld") && this.bld != bld) {
            oldValues.put("bld", this.bld);
        } else if(oldValues.containsKey("bld") && (int)oldValues.get("bld") == bld) {
            oldValues.remove("bld");
        }
        
        this.bld = bld;
    }

    public void setMov(int mov) {
        if(!oldValues.containsKey("mov") && this.mov != mov) {
            oldValues.put("mov", this.mov);
        } else if(oldValues.containsKey("mov") && (int)oldValues.get("mov") == mov) {
            oldValues.remove("mov");
        }
        
        this.mov = mov;
    }
    
    public boolean isModified() {
        return !oldValues.isEmpty();
    }

    private void readScroll(Rom rom) {
        int relOffset = SCROLLS_OFFSET + offset * SCROLLS_DATA_SIZE;
        
        hp = (byte)rom.getValueAt(relOffset + HP_OFFSET);
        atk = (byte)rom.getValueAt(relOffset + ATK_OFFSET);
        mag = (byte)rom.getValueAt(relOffset + MAG_OFFSET);
        skl = (byte)rom.getValueAt(relOffset + SKL_OFFSET);
        spd = (byte)rom.getValueAt(relOffset + SPD_OFFSET);
        lck = (byte)rom.getValueAt(relOffset + LCK_OFFSET);
        def = (byte)rom.getValueAt(relOffset + DEF_OFFSET);
        bld = (byte)rom.getValueAt(relOffset + BLD_OFFSET);
        mov = (byte)rom.getValueAt(relOffset + MOV_OFFSET);
    }
    
    private void writeScroll(Rom rom) {
        int relOffset = SCROLLS_OFFSET + offset * SCROLLS_DATA_SIZE;
        
        rom.setValueAt(relOffset + HP_OFFSET, hp & 0xFF);
        rom.setValueAt(relOffset + ATK_OFFSET, atk & 0xFF);
        rom.setValueAt(relOffset + MAG_OFFSET, mag & 0xFF);
        rom.setValueAt(relOffset + SKL_OFFSET, skl & 0xFF);
        rom.setValueAt(relOffset + SPD_OFFSET, spd & 0xFF);
        rom.setValueAt(relOffset + LCK_OFFSET, lck & 0xFF);
        rom.setValueAt(relOffset + DEF_OFFSET, def & 0xFF);
        rom.setValueAt(relOffset + BLD_OFFSET, bld & 0xFF);
        rom.setValueAt(relOffset + MOV_OFFSET, mov & 0xFF);
    }
    
    private void reset() {
        if(oldValues.containsKey("hp")) {
            this.hp = (int)oldValues.get("hp");
        }
        
        if(oldValues.containsKey("atk")) {
            this.atk = (int)oldValues.get("atk");
        }
        
        if(oldValues.containsKey("mag")) {
            this.mag = (int)oldValues.get("mag");
        }
        
        if(oldValues.containsKey("skl")) {
            this.skl = (int)oldValues.get("skl");
        }
        
        if(oldValues.containsKey("spd")) {
            this.spd = (int)oldValues.get("spd");
        }
        
        if(oldValues.containsKey("lck")) {
            this.lck = (int)oldValues.get("lck");
        }
        
        if(oldValues.containsKey("def")) {
            this.def = (int)oldValues.get("def");
        }
        
        if(oldValues.containsKey("bld")) {
            this.bld = (int)oldValues.get("bld");
        }
        
        if(oldValues.containsKey("mov")) {
            this.mov = (int)oldValues.get("mov");
        }
        
        oldValues.clear();
    }
    
    public Map<String, Object> getOldValues() {
        return oldValues;
    }
    
    public void setToZero() {
        setHp(0);
        setAtk(0);
        setMag(0);
        setSkl(0);
        setSpd(0);
        setLck(0);
        setDef(0);
        setBld(0);
        setMov(0);
    }
    
    public static void initializeScrolls(Rom rom) {
        for(Scroll scroll : values()) {
            scroll.readScroll(rom);
        }
    }
    
    public static void writeScrolls(Rom rom) {
        for(Scroll scroll : values()) {
            scroll.writeScroll(rom);
        }
    }
    
    public static void resetScrolls() {
        for(Scroll scroll : values()) {
            scroll.reset();
        }
    }
    
    @Override
    public String toString() {
        String text = String.format("[SCROLL] %s Hp: %d, Atk: %d, Skl: %d, Spd: %d, Lck: %d, Def %d, Bld: %d, Mov: %d",
                name, hp, atk, mag, skl, spd, lck, def, bld, mov);
        
        return text;
    }
}
