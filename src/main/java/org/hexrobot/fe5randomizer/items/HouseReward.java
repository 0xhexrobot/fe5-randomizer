package org.hexrobot.fe5randomizer.items;

import java.util.HashMap;
import java.util.Map;

import org.hexrobot.fe5randomizer.Rom;

public enum HouseReward {
    CH1_PUGI(0X3E8120, Item.PUGI, "Ch1 Pugi"),
    CH1_LIFE_RING(0X3E818C, Item.LIFE_RING, "Ch1 Life Ring"),
    CH1_VULNERARY(0X3E81EF, Item.VULNERARY, "Ch1 Vulnerary"),
    CH1_IRON_SWORD(0X3E8252, Item.IRON_SWORD, "Ch1 Iron Sword"),
    CH1_BRAVE_AXE(0X3E82BE, Item.BRAVE_AXE, "Ch1 Brave Axe"),
    CH2_SPEED_RING(0XC837C, Item.SPEED_RING, "Ch2 Speed Ring"),
    CH2_VULNERARY(0XC83E8, Item.VULNERARY, "Ch2 Vulnerary"),
    CH3_BALDO_SCROLL(0X6676D, Item.BALDO_SCROLL, "Ch3 Baldo Scroll"),
    CH3_SPEED_RING(0X667F2, Item.SPEED_RING, "Ch3 Speed Ring"),
    CH6_KNIGHT_PROOF(0XCA6DF, Item.KNIGHT_PROOF, "Ch6 Knight Proof"),
    CH6_RAPIER(0XCA81D, Item.RAPIER, "Ch6 Rapier"),
    CH6_ELITE_MANUAL(0XCA8CD, Item.ELITE_MANUAL, "Ch6 Elite Manual"),
    CH6_HOLY_WATER(0XCA97D, Item.HOLY_WATER, "Ch6 Holy Water"),
    CH6_ODO_SCROLL(0XCAA2D, Item.ODO_SCROLL, "Ch6 Odo Scroll"),
    CH7_HOLY_WATER(0XCBA26, Item.HOLY_WATER, "Ch7 Holy Water"),
    CH7_ANTIDOTE(0XCBAA2, Item.ANTIDOTE, "Ch7 Antidote"),
    CH7_KNIGHT_PROOF(0XCBAEC, Item.KNIGHT_PROOF, "Ch7 Knight Proof"),
    CH8_KNIGHT_PROOF(0XCC188, Item.KNIGHT_PROOF, "Ch8 Knight Proof"),
    CH8_LUCK_RING(0XCC1EB, Item.LUCK_RING, "Ch8 Luck Ring"),
    CH9_FALA_SCROLL(0X67384, Item.FALA_SCROLL, "Ch9 Fala Scroll"),
    CH9_STAMINA_DRINK(0X673E7, Item.STAMINA_DRINK, "Ch9 Stamina Drink"),
    CH10_RESCUE_STAFF(0XCC90B, Item.RESCUE, "Ch10 Rescue Staff"),
    CH10_MAGIC_UP(0XCC99D, Item.MAGIC_UP, "Ch10 Magic Up"),
    CH12_VULNERARY(0XCDF68, Item.VULNERARY, "Ch12 Vulnerary"),
    CH12_MAGIC_RING(0XCDFB1, Item.MAGIC_RING, "Ch12 Magic Ring"),
    CH12_HEIM_SCROLL(0XCE021, Item.HEIM_SCROLL, "Ch12 Heim Scroll"),
    CH12_SILENCE_STAFF(0XCE091, Item.SILENCE, "Ch12 Silence Staff"),
    CH13_KNIGHT_PROOF(0XCE948, Item.KNIGHT_PROOF, "Ch13 Knight Proof"),
    CH13_ARMORSLAYER(0XCE9AB, Item.ARMORSLAYER, "Ch13 Armorslayer"),
    CH13_HAMMER(0XCEA0E, Item.HAMMER, "Ch13 Hammer"),
    CH14_RESIRE(0X3E9C1A, Item.RESIRE, "Ch14 Resire"),
    CH14_DRAGON_LANCE(0X3E9C84, Item.DRAGON_LANCE, "Ch14 Dragon Lance"),
    CH15_ARMORSLAYER(0X3EAAAF, Item.ARMORSLAYER, "Ch15 Armorslayer"),
    CH15_SKILL_RING(0X3EAB12, Item.SKILL_RING, "Ch15 Skill Ring"),
    CH15_KILLER_LANCE(0X3EAB75, Item.KILLER_LANCE, "Ch15 Killer Lance"),
    CH15_ULIR_SCROLL(0X3EABD8, Item.ULIR_SCROLL, "Ch15 Ulir Scroll"),
    CH16A_BRIDGE_KEY(0X3EB6CB, Item.BRIDGE_KEY, "Ch16A Bridge Key"),
    CH16A_HOLY_WATER(0X3EB72E, Item.HOLY_WATER, "Ch16A Holy Water"),
    CH16A_KNIGHT_PROOF(0X3EB791, Item.KNIGHT_PROOF, "Ch16A Knight Proof"),
    CH17A_MAGIC_RING(0X3EC018, Item.MAGIC_RING, "Ch17A Magic Ring"),
    CH17A_HOLY_WATER(0X3EC07B, Item.HOLY_WATER, "Ch17A Holy Water"),
    CH17A_RESCUE_STAFF(0X3EC0DE, Item.RESCUE, "Ch17A Rescue Staff"),
    CH17A_WARP_STAFF(0X3EC141, Item.WARP, "Ch17A Warp Staff"),
    CH19_HOLY_WATER1(0X3ED20B, Item.HOLY_WATER, "Ch19 Holy Water"),
    CH19_SILVER_SWORD(0X3ED26E, Item.SILVER_SWORD, "Ch19 Silver Sword"),
    CH19_KILLER_LANCE(0X3ED2D1, Item.KILLER_LANCE, "Ch19 Killer Lance"),
    CH19_SPEED_RING(0X3ED334, Item.SPEED_RING, "Ch19 Speed Ring"),
    CH19_HOLY_WATER2(0X3ED397, Item.HOLY_WATER, "Ch19 Holy Water"),
    CH19_HEAL_STAFF1(0X3ED3FA, Item.HEAL, "Ch19 Heal Staff"),
    CH19_MAGIC_UP_STAFF(0X3ED45D, Item.MAGIC_UP, "Ch19 Magic Up Staff"),
    CH19_HEAL_STAFF2(0X3ED4C0, Item.HEAL, "Ch19 Heal Staff"),
    CH19_WIND(0X3ED523, Item.WIND, "Ch19 Wind"),
    CH20_SILENCE_STAFF(0X3EDC3D, Item.SILENCE, "Ch20 Silence Staff"),
    CH21_HOLY_WATER1(0X3EE66F, Item.HOLY_WATER, "Ch21 Holy Water 1"),
    CH21_HOLY_WATER2(0X3EE6D2, Item.HOLY_WATER, "Ch21 Holy Water 2"),
    CH21_SILVER_SWORD(0X3EE735, Item.SILVER_SWORD, "Ch21 Silver Sword"),
    CH22_WARP_STAFF(0X6782A, Item.WARP, "Ch22 Warp Staff"),
    CH22_HOLY_WATER(0X67965, Item.HOLY_WATER, "Ch22 Holy Water"),
    CH22_RESCUE_STAFF(0X67A2B, Item.RESCUE, "Ch22 Rescue Staff"),
    CH23_VULNERARY(0X3EF60D, Item.VULNERARY, "Ch23 Vulnerary"),
    CH23_HOLY_WATER(0X3EF670, Item.HOLY_WATER, "Ch23 Holy Water"),
    CH23_PHYSIC(0X3EF6D3, Item.PHYSIC, "Ch23 Physic"),
    CH23_BLAGI_SWORD(0X3EF8DC, Item.BLAGI_SWORD, "Ch23 Blagi Sword");

    private static HashMap<HouseReward, Item> oldValues = new HashMap<>();
    private int offset;
    private Item item;
    private String name;

    private HouseReward(int offset, Item item, String name) {
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
        int header = 0x200;
        
        for(Map.Entry<HouseReward, Item> entry : oldValues.entrySet()) {
            HouseReward house = entry.getKey();
            rom.setValueAt(house.getOffset() + header, house.getItem().getOffset() + 1);
        }
    }
    
    public static void reset() {
        for(Map.Entry<HouseReward, Item> entry : oldValues.entrySet()) {
            entry.getKey().item = entry.getValue();
        }
        
        oldValues.clear();
    }
}
