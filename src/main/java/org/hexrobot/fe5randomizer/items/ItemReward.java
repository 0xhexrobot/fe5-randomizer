package org.hexrobot.fe5randomizer.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hexrobot.fe5randomizer.Rom;

public enum ItemReward{
    // event rewards
    CH2X_TORCHES(0xB836C,  Item.TORCH,  "Ch2x Torches"),
    CH4X_SETY_SCROLL(0x3E8E37,  Item.SETY_SCROLL,  "Ch4x Sety Scroll"),
    CH7_WARP_STAFF(0xCBD3B,  Item.WARP,  "Ch7 Warp Staff"),
    CH9_ELITE_SWORD(0x67190,  Item.ELITE_SWORD,  "Ch9 Elite Sword"),
    CH13_BRAVE_BOW(0xCEA94,  Item.BRAVE_BOW,  "Ch13 Brave Bow"),
    CH18_MEMBER_CARD(0x338B51,  Item.MEMBER_CARD,  "Ch18 Member Card"),
    CH14X_STAMINA1(0x3EA5E4,  Item.STAMINA_DRINK,  "Ch14x Stamina 1"),
    CH14X_STAMINA2(0x3EA606,  Item.STAMINA_DRINK,  "Ch14x Stamina 2"),
    CH14X_STAMINA3(0x3EA628,  Item.STAMINA_DRINK,  "Ch14x Stamina 3"),
    CH14X_STAMINA4(0x3EA64A,  Item.STAMINA_DRINK,  "Ch14x Stamina 4"),
    CH14X_STAMINA5(0x3EA66C,  Item.STAMINA_DRINK,  "Ch14x Stamina 5"),
    CH14X_STAMINA6(0x3EA68E,  Item.STAMINA_DRINK,  "Ch14x Stamina 6"),
    CH15_RESTORE_STAFF(0x3EB007,  Item.RESTORE,  "Ch15 Restore Staff"),
    CH17B_KNIGHT_PROOF(0x3ECB2F,  Item.KNIGHT_PROOF,  "Ch17B Knight Proof"),
    CH19_KNIGHT_PROOF(0x3ED8BF,  Item.KNIGHT_PROOF,  "Ch19 Knight Proof"),
    // chest rewards(0x200
    CH3_ARMORSLAYER(0x18F5D5,  Item.ARMORSLAYER,  "Ch3 Armorslayer"),
    CH3_METEOR(0x18F619,  Item.METEOR,  "Ch3 Meteor"),
    CH4X_IRON_BLADE(0x18EECB,  Item.IRON_BLADE,  "Ch4x Iron Blade"),
    CH4X_BRAVE_SWORD(0x18EF0F,  Item.BRAVE_SWORD,  "Ch4x Brave Sword"),
    CH4X_LIFE_RING(0x18EF53,  Item.LIFE_RING,  "Ch4x Life Ring"),
    CH5_SKILL_RING(0x18EA7E,  Item.SKILL_RING,  "Ch5 Skill Ring"),
    CH5_LOCKPICK(0x18EAC2,  Item.LOCKPICK,  "Ch5 Lockpick"),
    CH5_MAGIC_RING(0x18EB06,  Item.MAGIC_RING,  "Ch5 Magic Ring"),
    CH8X_LEG_RING(0x18DB70,  Item.LEG_RING,  "Ch8x Leg Ring"),
    CH8X_WRATH_MANUAL(0x18DBB4,  Item.WRATH_MANUAL,  "Ch8x Wrath Manual"),
    CH8X_DEVIL_AXE(0x18DBF8,  Item.DEVIL_AXE,  "Ch8x Devil Axe"),
    CH8X_HAMMER(0x18DC3C,  Item.HAMMER,  "Ch8x Hammer"),
    CH8X_NEIR_SCROLL(0x18DC80,  Item.NEIR_SCROLL,  "Ch8x Neir Scroll"),
    CH8X_HOLY_WATER(0x18DCC4,  Item.HOLY_WATER,  "Ch8x Holy Water"),
    CH11_TORCH_STAFF(0x18D1AD,  Item.TORCH_STAFF,  "Ch11 Torch Staff"),
    CH12X_CHARGE_MANUAL(0x18C636,  Item.CHARGE_MANUAL,  "Ch12x Charge Manual"),
    CH12X_SHIELD_RING(0x18C67A,  Item.SHIELD_RING,  "Ch12x Shield Ring"),
    CH12X_RESERVE_STAFF(0x18C6BE,  Item.RESERVE,  "Ch12x Reserve Staff"),
    CH12X_ARMORSLAYER(0x18C702,  Item.ARMORSLAYER,  "Ch12x Armorslayer"),
    CH12X_KNIGHT_PROOF(0x18C746,  Item.KNIGHT_PROOF,  "Ch12x Knight Proof"),
    CH18_NOBA_SCROLL(0x18A19B,  Item.NOBA_SCROLL,  "Ch18 Noba Scroll"),
    CH18_BODY_RING(0x18A1DF,  Item.BODY_RING,  "Ch18 Body Ring"),
    CH18_DOOR_KEY(0x18A223,  Item.DOOR_KEY,  "Ch18 Door Key"),
    CH18_SILVER_SWORD(0x18A267,  Item.SILVER_SWORD,  "Ch18 Silver Sword"),
    CH20_KNIGHT_PROOF(0x189847,  Item.KNIGHT_PROOF,  "Ch20 Knight Proof"),
    CH21X_VULNERARY(0x188C41,  Item.VULNERARY,  "Ch21x Vulnerary"),
    CH21X_KNIGHT_PROOF(0x188C85,  Item.KNIGHT_PROOF,  "Ch21x Knight Proof"),
    CH21X_UNLOCK_STAFF(0x188CC9,  Item.UNLOCK,  "Ch21x Unlock Staff"),
    CH21X_THUNDERSTORM(0x188D0D,  Item.THUNDERSTORM, "Ch21x Thunderstorm"),
    CH24_KIA_STAFF(0xCF75F,  Item.KIA_STAFF,  "Ch24 Kia Staff"),
    CH24X_KNIGHT_PROOF(0xCFA26,  Item.KNIGHT_PROOF, "Ch24x Knight Proof"),
    CH24X_POWER_RING(0xCFA6A,  Item.POWER_RING,  "Ch24x Power Ring"),
    CH24X_SHIELD_RING(0xCFAAE,  Item.SHIELD_RING,  "Ch24x Shield Ring"),
    // house rewards
    CH1_PUGI(0x3E8120,  Item.PUGI,  "Ch1 Pugi"),
    CH1_LIFE_RING(0x3E818C,  Item.LIFE_RING,  "Ch1 Life Ring"),
    CH1_VULNERARY(0x3E81EF,  Item.VULNERARY,  "Ch1 Vulnerary"),
    CH1_IRON_SWORD(0x3E8252,  Item.IRON_SWORD,  "Ch1 Iron Sword"),
    CH1_BRAVE_AXE(0x3E82BE,  Item.BRAVE_AXE,  "Ch1 Brave Axe"),
    CH2_SPEED_RING(0xC837C,  Item.SPEED_RING,  "Ch2 Speed Ring"),
    CH2_VULNERARY(0xC83E8,  Item.VULNERARY,  "Ch2 Vulnerary"),
    CH3_BALDO_SCROLL(0x6676D,  Item.BALDO_SCROLL,  "Ch3 Baldo Scroll"),
    CH3_SPEED_RING(0x667F2,  Item.SPEED_RING,  "Ch3 Speed Ring"),
    CH6_KNIGHT_PROOF(0xCA6DF,  Item.KNIGHT_PROOF,  "Ch6 Knight Proof"),
    CH6_RAPIER(0xCA81D,  Item.RAPIER,  "Ch6 Rapier"),
    CH6_ELITE_MANUAL(0xCA8CD,  Item.ELITE_MANUAL,  "Ch6 Elite Manual"),
    CH6_HOLY_WATER(0xCA97D,  Item.HOLY_WATER,  "Ch6 Holy Water"),
    CH6_ODO_SCROLL(0xCAA2D,  Item.ODO_SCROLL,  "Ch6 Odo Scroll"),
    CH7_HOLY_WATER(0xCBA26,  Item.HOLY_WATER,  "Ch7 Holy Water"),
    CH7_ANTIDOTE(0xCBAA2,  Item.ANTIDOTE,  "Ch7 Antidote"),
    CH7_KNIGHT_PROOF(0xCBAEC,  Item.KNIGHT_PROOF,  "Ch7 Knight Proof"),
    CH8_KNIGHT_PROOF(0xCC188,  Item.KNIGHT_PROOF,  "Ch8 Knight Proof"),
    CH8_LUCK_RING(0xCC1EB,  Item.LUCK_RING,  "Ch8 Luck Ring"),
    CH9_FALA_SCROLL(0x67384,  Item.FALA_SCROLL,  "Ch9 Fala Scroll"),
    CH9_STAMINA_DRINK(0x673E7,  Item.STAMINA_DRINK,  "Ch9 Stamina Drink"),
    CH10_RESCUE_STAFF(0xCC90B,  Item.RESCUE,  "Ch10 Rescue Staff"),
    CH10_MAGIC_UP(0xCC99D,  Item.MAGIC_UP,  "Ch10 Magic Up"),
    CH12_VULNERARY(0xCDF68,  Item.VULNERARY,  "Ch12 Vulnerary"),
    CH12_MAGIC_RING(0xCDFB1,  Item.MAGIC_RING,  "Ch12 Magic Ring"),
    CH12_HEIM_SCROLL(0xCE021,  Item.HEIM_SCROLL,  "Ch12 Heim Scroll"),
    CH12_SILENCE_STAFF(0xCE091,  Item.SILENCE,  "Ch12 Silence Staff"),
    CH13_KNIGHT_PROOF(0xCE948,  Item.KNIGHT_PROOF,  "Ch13 Knight Proof"),
    CH13_ARMORSLAYER(0xCE9AB,  Item.ARMORSLAYER,  "Ch13 Armorslayer"),
    CH13_HAMMER(0xCEA0E,  Item.HAMMER,  "Ch13 Hammer"),
    CH14_RESIRE(0x3E9C1A,  Item.RESIRE,  "Ch14 Resire"),
    CH14_DRAGON_LANCE(0x3E9C84,  Item.DRAGON_LANCE,  "Ch14 Dragon Lance"),
    CH15_ARMORSLAYER(0x3EAAAF,  Item.ARMORSLAYER,  "Ch15 Armorslayer"),
    CH15_SKILL_RING(0x3EAB12,  Item.SKILL_RING,  "Ch15 Skill Ring"),
    CH15_KILLER_LANCE(0x3EAB75,  Item.KILLER_LANCE,  "Ch15 Killer Lance"),
    CH15_ULIR_SCROLL(0x3EABD8,  Item.ULIR_SCROLL,  "Ch15 Ulir Scroll"),
    CH16A_BRIDGE_KEY(0x3EB6CB,  Item.BRIDGE_KEY,  "Ch16A Bridge Key"),
    CH16A_HOLY_WATER(0x3EB72E,  Item.HOLY_WATER,  "Ch16A Holy Water"),
    CH16A_KNIGHT_PROOF(0x3EB791,  Item.KNIGHT_PROOF,  "Ch16A Knight Proof"),
    CH17A_MAGIC_RING(0x3EC018,  Item.MAGIC_RING,  "Ch17A Magic Ring"),
    CH17A_HOLY_WATER(0x3EC07B,  Item.HOLY_WATER,  "Ch17A Holy Water"),
    CH17A_RESCUE_STAFF(0x3EC0DE,  Item.RESCUE,  "Ch17A Rescue Staff"),
    CH17A_WARP_STAFF(0x3EC141,  Item.WARP,  "Ch17A Warp Staff"),
    CH19_HOLY_WATER1(0x3ED20B,  Item.HOLY_WATER,  "Ch19 Holy Water"),
    CH19_SILVER_SWORD(0x3ED26E,  Item.SILVER_SWORD,  "Ch19 Silver Sword"),
    CH19_KILLER_LANCE(0x3ED2D1,  Item.KILLER_LANCE,  "Ch19 Killer Lance"),
    CH19_SPEED_RING(0x3ED334,  Item.SPEED_RING,  "Ch19 Speed Ring"),
    CH19_HOLY_WATER2(0x3ED397,  Item.HOLY_WATER,  "Ch19 Holy Water"),
    CH19_HEAL_STAFF1(0x3ED3FA,  Item.HEAL,  "Ch19 Heal Staff"),
    CH19_MAGIC_UP_STAFF(0x3ED45D,  Item.MAGIC_UP,  "Ch19 Magic Up Staff"),
    CH19_HEAL_STAFF2(0x3ED4C0,  Item.HEAL,  "Ch19 Heal Staff"),
    CH19_WIND(0x3ED523,  Item.WIND,  "Ch19 Wind"),
    CH20_SILENCE_STAFF(0x3EDC3D,  Item.SILENCE,  "Ch20 Silence Staff"),
    CH21_HOLY_WATER1(0x3EE66F,  Item.HOLY_WATER,  "Ch21 Holy Water 1"),
    CH21_HOLY_WATER2(0x3EE6D2,  Item.HOLY_WATER,  "Ch21 Holy Water 2"),
    CH21_SILVER_SWORD(0x3EE735,  Item.SILVER_SWORD,  "Ch21 Silver Sword"),
    CH22_WARP_STAFF(0x6782A,  Item.WARP,  "Ch22 Warp Staff"),
    CH22_HOLY_WATER(0x67965,  Item.HOLY_WATER,  "Ch22 Holy Water"),
    CH22_RESCUE_STAFF(0x67A2B,  Item.RESCUE,  "Ch22 Rescue Staff"),
    CH23_VULNERARY(0x3EF60D,  Item.VULNERARY,  "Ch23 Vulnerary"),
    CH23_HOLY_WATER(0x3EF670,  Item.HOLY_WATER,  "Ch23 Holy Water"),
    CH23_PHYSIC(0x3EF6D3,  Item.PHYSIC,  "Ch23 Physic"),
    CH23_BLAGI_SWORD(0x3EF8DC,  Item.BLAGI_SWORD,  "Ch23 Blagi Sword");

    private static final List<ItemReward> EVENT_REWARDS = new ArrayList<>(List.of(
            CH2X_TORCHES, CH4X_SETY_SCROLL, CH7_WARP_STAFF, CH9_ELITE_SWORD, CH13_BRAVE_BOW, CH18_MEMBER_CARD,
            CH14X_STAMINA1, CH14X_STAMINA2, CH14X_STAMINA3, CH14X_STAMINA4, CH14X_STAMINA5, CH14X_STAMINA6,
            CH15_RESTORE_STAFF, CH17B_KNIGHT_PROOF, CH19_KNIGHT_PROOF));
    private static final List<ItemReward> CHEST_REWARDS = new ArrayList<>(List.of(
            CH3_ARMORSLAYER, CH3_METEOR, CH4X_IRON_BLADE, CH4X_BRAVE_SWORD, CH4X_LIFE_RING, CH5_SKILL_RING,
            CH5_LOCKPICK, CH5_MAGIC_RING, CH8X_LEG_RING, CH8X_WRATH_MANUAL, CH8X_DEVIL_AXE, CH8X_HAMMER,
            CH8X_NEIR_SCROLL, CH8X_HOLY_WATER, CH11_TORCH_STAFF, CH12X_CHARGE_MANUAL, CH12X_SHIELD_RING,
            CH12X_RESERVE_STAFF, CH12X_ARMORSLAYER, CH12X_KNIGHT_PROOF, CH18_NOBA_SCROLL, CH18_BODY_RING, CH18_DOOR_KEY,
            CH18_SILVER_SWORD, CH20_KNIGHT_PROOF, CH21X_VULNERARY, CH21X_KNIGHT_PROOF, CH21X_UNLOCK_STAFF,
            CH21X_THUNDERSTORM, CH24_KIA_STAFF, CH24X_KNIGHT_PROOF, CH24X_POWER_RING, CH24X_SHIELD_RING));
    private static final List<ItemReward> HOUSE_REWARDS = new ArrayList<>(List.of(
            CH1_PUGI, CH1_LIFE_RING, CH1_VULNERARY, CH1_IRON_SWORD, CH1_BRAVE_AXE, CH2_SPEED_RING, CH2_VULNERARY,
            CH3_BALDO_SCROLL, CH3_SPEED_RING, CH6_KNIGHT_PROOF, CH6_RAPIER, CH6_ELITE_MANUAL, CH6_HOLY_WATER,
            CH6_ODO_SCROLL, CH7_HOLY_WATER, CH7_ANTIDOTE, CH7_KNIGHT_PROOF, CH8_KNIGHT_PROOF, CH8_LUCK_RING,
            CH9_FALA_SCROLL, CH9_STAMINA_DRINK, CH10_RESCUE_STAFF, CH10_MAGIC_UP, CH12_VULNERARY, CH12_MAGIC_RING,
            CH12_HEIM_SCROLL, CH12_SILENCE_STAFF, CH13_KNIGHT_PROOF, CH13_ARMORSLAYER, CH13_HAMMER, CH14_RESIRE,
            CH14_DRAGON_LANCE, CH15_ARMORSLAYER, CH15_SKILL_RING, CH15_KILLER_LANCE, CH15_ULIR_SCROLL, CH16A_BRIDGE_KEY,
            CH16A_HOLY_WATER, CH16A_KNIGHT_PROOF, CH17A_MAGIC_RING, CH17A_HOLY_WATER, CH17A_RESCUE_STAFF,
            CH17A_WARP_STAFF, CH19_HOLY_WATER1, CH19_SILVER_SWORD, CH19_KILLER_LANCE, CH19_SPEED_RING, CH19_HOLY_WATER2,
            CH19_HEAL_STAFF1, CH19_MAGIC_UP_STAFF, CH19_HEAL_STAFF2, CH19_WIND, CH20_SILENCE_STAFF, CH21_HOLY_WATER1,
            CH21_HOLY_WATER2, CH21_SILVER_SWORD, CH22_WARP_STAFF, CH22_HOLY_WATER, CH22_RESCUE_STAFF, CH23_VULNERARY,
            CH23_HOLY_WATER, CH23_PHYSIC, CH23_BLAGI_SWORD));
    private static final ArrayList<ItemReward> EXCLUDED_REWARDS = new ArrayList<>(List.of(
            ItemReward.CH2X_TORCHES, ItemReward.CH18_MEMBER_CARD, ItemReward.CH24_KIA_STAFF,
            ItemReward.CH23_BLAGI_SWORD));
    private static HashMap<ItemReward, Item> oldValues = new HashMap<>();
    private int offset;
    private Item item;
    private String name;

    private ItemReward(int offset, Item item, String name) {
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
    
    public static List<ItemReward> getEventRewards() {
        return new ArrayList<>(EVENT_REWARDS);
    }
    
    public static List<ItemReward> getChestRewards() {
        return new ArrayList<>(CHEST_REWARDS);
    }
    
    public static List<ItemReward> getHouseRewards() {
        return new ArrayList<>(HOUSE_REWARDS);
    }

    public static ArrayList<ItemReward> getExcludedRewards() {
        return new ArrayList<>(EXCLUDED_REWARDS);
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

    public static void writeItemRewards(Rom rom) {
        for(Map.Entry<ItemReward, Item> entry : oldValues.entrySet()) {
            ItemReward reward = entry.getKey();
            rom.setValueAt(reward.getOffset(), reward.getItem().getOffset() + 1);
        }
    }

    public static void reset() {
        for(Map.Entry<ItemReward, Item> entry : oldValues.entrySet()) {
            entry.getKey().item = entry.getValue();
        }

        oldValues.clear();
    }
    @Override
    public String toString() {
        return String.format("%s offset: 0x%04x, Item: %s", name, offset, item.getName());
    }
}
