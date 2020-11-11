package org.hexrobot.fe5randomizer.items;

import java.util.HashMap;
import java.util.Map;

import org.hexrobot.fe5randomizer.Rom;

public enum ChestReward {
    CH3_ARMORSLAYER_(0X18F5D5, Item.ARMORSLAYER, "Ch3 Armorslayer"),
    CH3_METEOR(0X18F619, Item.METEOR, "Ch3 Meteor"),
    CH4X_IRON_BLADE(0X18EECB, Item.IRON_BLADE, "Ch4x Iron Blade"),
    CH4X_BRAVE_SWORD(0X18EF0F, Item.BRAVE_SWORD, "Ch4x Brave Sword"),
    CH4X_LIFE_RING(0X18EF53, Item.LIFE_RING, "Ch4x Life Ring"),
    CH5_SKILL_RING(0X18EA7E, Item.SKILL_RING, "Ch5 Skill Ring"),
    CH5_LOCKPICK(0X18EAC2, Item.LOCKPICK, "Ch5 Lockpick"),
    CH5_MAGIC_RING(0X18EB06, Item.MAGIC_RING, "Ch5 Magic Ring"),
    CH8X_LEG_RING(0X18DB70, Item.LEG_RING, "Ch8x Leg Ring"),
    CH8X_WRATH_MANUAL(0X18DBB4, Item.WRATH_MANUAL, "Ch8x Wrath Manual"),
    CH8X_DEVIL_AXE(0X18DBF8, Item.DEVIL_AXE, "Ch8x Devil Axe"),
    CH8X_HAMMER(0X18DC3C, Item.HAMMER, "Ch8x Hammer"),
    CH8X_NEIR_SCROLL(0X18DC80, Item.NEIR_SCROLL, "Ch8x Neir Scroll"),
    CH8X_HOLY_WATER(0X18DCC4, Item.HOLY_WATER, "Ch8x Holy Water"),
    CH11_TORCH_STAFF(0X18D1AD, Item.TORCH_STAFF, "Ch11 Torch Staff"),
    CH12X_CHARGE_MANUAL(0X18C636, Item.CHARGE_MANUAL, "Ch12x Charge Manual"),
    CH12X_SHIELD_RING(0X18C67A, Item.SHIELD_RING, "Ch12x Shield Ring"),
    CH12X_RESERVE_STAFF(0X18C6BE, Item.RESERVE, "Ch12x Reserve Staff"),
    CH12X_ARMORSLAYER(0X18C702, Item.ARMORSLAYER, "Ch12x Armorslayer"),
    CH12X_KNIGHT_PROOF(0X18C746, Item.KNIGHT_PROOF, "Ch12x Knight Proof"),
    CH18_NOBA_SCROLL(0X18A19B, Item.NOBA_SCROLL, "Ch18 Noba Scroll"),
    CH18_BODY_RING(0X18A1DF, Item.BODY_RING, "Ch18 Body Ring"),
    CH18_DOOR_KEY(0X18A223, Item.DOOR_KEY, "Ch18 Door Key"),
    CH18_SILVER_SWORD(0X18A267, Item.SILVER_SWORD, "Ch18 Silver Sword"),
    CH20_KNIGHT_PROOF(0X189847, Item.KNIGHT_PROOF, "Ch20 Knight Proof"),
    CH21X_VULNERARY(0X188C41, Item.VULNERARY, "Ch21x Vulnerary"),
    CH21X_KNIGHT_PROOF(0X188C85, Item.KNIGHT_PROOF, "Ch21x Knight Proof"),
    CH21X_UNLOCK_STAFF(0X188CC9, Item.UNLOCK, "Ch21x Unlock Staff"),
    CH21X_THUNDERSTORM(0X188D0D, Item.THUNDERSTORM,"Ch21x Thunderstorm"),
    CH24_KIA_STAFF(0XCF75F, Item.KIA_STAFF, "Ch24 Kia Staff"),
    CH24X_KNIGHT_PROOF(0XCFA26, Item.KNIGHT_PROOF,"Ch24x Knight Proof"),
    CH24X_POWER_RING(0XCFA6A, Item.POWER_RING, "Ch24x Power Ring"),
    CH24X_SHIELD_RING(0XCFAAE, Item.SHIELD_RING, "Ch24x Shield Ring");

    private static HashMap<ChestReward, Item> oldValues = new HashMap<>();
    private int offset;
    private Item item;
    private String name; 
    
    private ChestReward(int offset, Item item, String name) {
        this.offset = offset;
        this.item = item;
        this.name = name;
    }
    
    public int getOffset() {
        return offset;
    }
    
    public Item getItem() {
        return item;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isModified() {
        return oldValues.containsKey(this);
    }
    
    public void setItem(Item newItem) {
        if(!item.equals(newItem)) {
            oldValues.put(this, item);
        }
        
        item = newItem;
    }
    
    public static void write(Rom rom) {
        for(Map.Entry<ChestReward, Item> entry : oldValues.entrySet()) {
            ChestReward chest = entry.getKey();
            rom.setValueAt(chest.getOffset(), chest.getItem().getOffset());
        }
    }
    
    public static void reset() {
        for(Map.Entry<ChestReward, Item> entry : oldValues.entrySet()) {
            entry.getKey().item = entry.getValue();
        }
        
        oldValues.clear();
    }
}
