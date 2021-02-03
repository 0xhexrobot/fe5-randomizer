package org.hexrobot.fe5randomizer.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hexrobot.fe5randomizer.Rom;

public enum Item {
	IRON_SWORD(0x00, "Iron Sword"),
	STEEL_SWORD(0x01, "Steel Sword"),
	SILVER_SWORD(0x02, "Silver Sword"),
	THIN_SWORD(0x03, "Thin Sword"),
	IRON_BLADE(0x04, "Iron Blade"),
	KILLER_SWORD(0x05, "Killer Sword"),
	POISON_SWORD(0x06, "Poison Sword"),
	BERSERK_SWORD(0x07, "Berserk Sword"),
	SLEEP_SWORD(0x08, "Sleep Sword"),
	BEOSWORD(0x09, "Beosword"),
	HOLY_SWORD(0x0A, "Holy Sword"),
	LOPUTOUS_SWORD(0x0B, "Loputous Sword"),
	BLAGI_SWORD(0x0C, "Blagi Sword"),
	LIGHT_SWORD(0x0D, "Light Sword"),
	BRAVE_SWORD(0x0E, "Brave Sword"),
	KING_SWORD(0x0F, "King Sword"),
	EARTH_SWORD(0x10, "Earth Sword"),
	WIND_SWORD(0x11, "Wind Sword"),
	FIRE_SWORD(0x12, "Fire Sword"),
	THUNDER_SWORD(0x13, "Thunder Sword"),
	ELITE_SWORD(0x14, "Elite Sword"),
	ARMORSLAYER(0x15, "Armorslayer"),
	RAPIER(0x16, "Rapier"),
	SHORT_SWORD(0x17, "Short Sword"),
	LONG_SWORD(0x18, "Long Sword"),
	GREAT_SWORD(0x19, "Great Sword"),
	MASTER_SWORD(0x1A, "Master Sword"),
	DARKNESS_SWORD(0x1B, "Darkness Sword"),
	MAREETAS_SWORD(0x1C, "Mareeta's Sword"),
	BROKEN_SWORD(0x1D, "Broken Sword"),
	IRON_LANCE(0x1E, "Iron Lance"),
	STEEL_LANCE(0x1F, "Steel Lance"),
	SILVER_LANCE(0x20, "Silver Lance"),
	THIN_LANCE(0x21, "Thin Lance"),
	POISON_LANCE(0x22, "Poison Lance"),
	DRAGON_LANCE(0x23, "Dragon Lance"),
	DARKNESS_LANCE(0x24, "Darkness Lance"),
	BRAVE_LANCE(0x25, "Brave Lance"),
	SHORT_LANCE(0x26, "Short Lance"),
	LONG_LANCE(0x27, "Long Lance"),
	GREAT_LANCE(0x28, "Great Lance"),
	JAVELIN(0x29, "Javelin"),
	MASTER_LANCE(0x2A, "Master Lance"),
	KNIGHT_KILLER(0x2B, "Knight Killer"),
	KILLER_LANCE(0x2C, "Killer Lance"),
	GAE_BOLG(0x2D, "Gae Bolg"),
	GUNGNIR(0x2E, "Gungnir"),
	BROKEN_LANCE(0x2F, "Broken Lance"),
	IRON_AXE(0x30, "Iron Axe"),
	POISON_AXE(0x31, "Poison Axe"),
	STEEL_AXE(0x32, "Steel Axe"),
	SILVER_AXE(0x33, "Silver Axe"),
	HAND_AXE(0x34, "Hand Axe"),
	HAMMER(0x35, "Hammer"),
	KILLER_AXE(0x36, "Killer Axe"),
	PUGI(0x37, "Pugi"),
	BRAVE_AXE(0x38, "Brave Axe"),
	DEVIL_AXE(0x39, "Devil Axe"),
	BATTLE_AXE(0x3A, "Battle Axe"),
	POLEAXE(0x3B, "Poleaxe"),
	MASTER_AXE(0x3C, "Master Axe"),
	BROKEN_AXE(0x3D, "Broken Axe"),
	IRON_BOW(0x3E, "Iron Bow"),
	STEEL_BOW(0x3F, "Steel Bow"),
	SILVER_BOW(0x40, "Silver Bow"),
	POISON_BOW(0x41, "Poison Bow"),
	KILLER_BOW(0x42, "Killer Bow"),
	BRAVE_BOW(0x43, "Brave Bow"),
	SHORT_BOW(0x44, "Short Bow"),
	LONG_BOW(0x45, "Long Bow"),
	GREAT_BOW(0x46, "Great Bow"),
	MASTER_BOW(0x47, "Master Bow"),
	LONG_ARCH(0x48, "Long Arch"),
	IRON_ARCH(0x49, "Iron Arch"),
	KILLER_ARCH(0x4A, "Killer Arch"),
	POISON_ARCH(0x4B, "Poison Arch"),
	BROKEN_BOW(0x4C, "Broken Bow"),
	FIRE(0x4D, "Fire"),
	ELFIRE(0x4E, "Elfire"),
	VOLCANNON(0x4F, "Volcannon"),
	FALAFLAME(0x50, "Falaflame"),
	THUNDER(0x51, "Thunder"),
	DAIM_THUNDER(0x52, "Daim Thunder"),
	TRON(0x53, "Tron"),
	TORHAMMER(0x54, "Torhammer"),
	WIND(0x55, "Wind"),
	GRAFUCALIBUR(0x56, "Grafucalibur"),
	TORNADO(0x57, "Tornado"),
	HOLSETY(0x58, "Holsety"),
	LIGHTNING(0x59, "Lightning"),
	RESIRE(0x5A, "Resire"),
	AURA(0x5B, "Aura"),
	YOTSMUNGAND(0x5C, "Yotsmungand"),
	FENRIR(0x5D, "Fenrir"),
	HELL(0x5E, "Hell"),
	LOPUTOUS(0x5F, "Loputous"),
	METEOR(0x60, "Meteor"),
	THUNDERSTORM(0x61, "Thunderstorm"),
	BLIZZARD(0x62, "Blizzard"),
	POISON(0x63, "Poison"),
	STONE(0x64, "Stone"),
	HOLSETY_UNLIMITED(0x65, "Holsety(Unlimited)"),
	BROKEN_BOOK(0x66, "Broken Book"),
	HEAL(0x67, "Heal"),
	MEND(0x68, "Mend"),
	RECOVER(0x69, "Recover"),
	PHYSIC(0x6A, "Physic"),
	RESERVE(0x6B, "Reserve"),
	RESCUE(0x6C, "Rescue"),
	WARP(0x6D, "Warp"),
	RESTORE(0x6E, "Restore"),
	SILENCE(0x6F, "Silence"),
	SLEEP(0x70, "Sleep"),
	TORCH_STAFF(0x71, "Torch staff"),
	RETURN(0x72, "Return"),
	REPAIR(0x73, "Repair"),
	THIEF_STAFF(0x74, "Thief staff"),
	WATCH(0x75, "Watch"),
	BERSERK(0x76, "Berserk"),
	UNLOCK(0x77, "Unlock"),
	MAGIC_UP(0x78, "Magic up"),
	REWARP(0x79, "Rewarp"),
	KIA_STAFF(0x7A, "Kia staff"),
	BROKEN_STAFF(0x7B, "Broken Staff"),
	LUCK_RING(0x7C, "Luck Ring"),
	LIFE_RING(0x7D, "Life Ring"),
	SPEED_RING(0x7E, "Speed Ring"),
	MAGIC_RING(0x7F, "Magic Ring"),
	POWER_RING(0x80, "Power Ring"),
	BODY_RING(0x81, "Body Ring"),
	SHIELD_RING(0x82, "Shield Ring"),
	SKILL_RING(0x83, "Skill Ring"),
	LEG_RING(0x84, "Leg Ring"),
	KNIGHT_PROOF(0x85, "Knight Proof"),
	MASTER_PROOF(0x86, "Master Proof"),
	TREASURE_KEY(0x87, "Treasure Key"),
	DOOR_KEY(0x88, "Door Key"),
	BRIDGE_KEY(0x89, "Bridge Key"),
	LOCKPICK(0x8A, "Lockpick"),
	STAMINA_DRINK(0x8B, "Stamina Drink"),
	VULNERARY(0x8C, "Vulnerary"),
	HOLY_WATER(0x8D, "Holy Water"),
	TORCH(0x8E, "Torch"),
	ANTIDOTE(0x8F, "Antidote"),
	MEMBER_CARD(0x90, "Member Card"),
	ODO_SCROLL(0x91, "Odo Scroll"),
	BALDO_SCROLL(0x92, "Baldo Scroll"),
	HEZUL_SCROLL(0x93, "Hezul Scroll"),
	DAIN_SCROLL(0x94, "Dain Scroll"),
	NOBA_SCROLL(0x95, "Noba Scroll"),
	NEIR_SCROLL(0x96, "Neir Scroll"),
	ULIR_SCROLL(0x97, "Ulir Scroll"),
	TORDO_SCROLL(0x98, "Tordo Scroll"),
	FALA_SCROLL(0x99, "Fala Scroll"),
	SETY_SCROLL(0x9A, "Sety Scroll"),
	BLAGI_SCROLL(0x9B, "Blagi Scroll"),
	HEIM_SCROLL(0x9C, "Heim Scroll"),
	ELITE_MANUAL(0x9D, "Elite Manual"),
	CHARGE_MANUAL(0x9E, "Charge Manual"),
	BARGAIN_MANUAL(0x9F, "Bargain Manual"),
	AMBUSH_MANUAL(0xA0, "Ambush Manual"),
	WRATH_MANUAL(0xA1, "Wrath Manual"),
	CONTINUE_MANUAL(0xA2, "Continue Manual"),
	PRAYER_MANUAL(0xA3, "Prayer Manual"),
	AWARENESS_MANUAL(0xA4, "Awareness Manual"),
	SUNLIGHT_MANUAL(0xA5, "Sunlight Manual"),
	MOONLIGHT_MANUAL(0xA6, "Moonlight Manual");
	
	private int offset;
	private String name = "UNNAMED";
	private ItemType itemType = ItemType.ITEM;
	private int power = -1;
	private int accuracy = -1;
	private int weight = -1;
	private int maxUses = -1;
	private int critical = -1;
    private WeaponRange weaponRange = WeaponRange.R_1;
    private WeaponRank weaponRank = WeaponRank.NOPE;
    private WeaponEffectiveness weaponEffectiveness = WeaponEffectiveness.NONE;
    private WeaponStatBonus weaponStatBonus = WeaponStatBonus.NONE;
    private int costPerUse = -1;
    private int descriptionPointer = -1;
    private ItemUseEffect itemUseEffect = ItemUseEffect.NOTHING;
    private WeaponBladeEffect weaponBladeEffect = WeaponBladeEffect.NOTHING;
    private int skills1 = -1;
    private int skills2 = -1;
    private ArrayList<WeaponSkill> skills = new ArrayList<>();
    private ItemClassification itemClassification = ItemClassification.ITEM;
    private Map<String, Object> oldValues = new HashMap<>();

    private static final int ITEM_DATA_SIZE = 23;
    private static final int ITEM_TYPE_OFFSET = 0x0;
    private static final int POWER_OFFSET = 0x01;
    private static final int ACCURACY_OFFSET = 0x02;
    private static final int WEIGHT_OFFSET = 0x03;
    private static final int MAX_USES_OFFSET = 0x04;
    private static final int CRITICAL_OFFSET = 0x05;
    private static final int RANGE_OFFSET = 0x06;
    private static final int WEAPON_RANK_OFFSET = 0x07;
    private static final int WPN_EFFECTIVENESS_OFFSET = 0x09;
    private static final int STAT_BONUSES_OFFSET = 0x0B;
    private static final int COST_PER_USE_OFFSET = 0x0D;
    private static final int DESCRIPTION_OFFSET = 0x0F;
    private static final int USE_EFFECT_OFFSET = 0x11;
    private static final int BLADE_EFFECT_OFFSET = 0x12;
    private static final int WEAPON_SKILL1_OFFSET = 0x13;
    private static final int WEAPON_SKILL2_OFFSET = 0x14;
    private static final int ITEM_CLASSIFICATION_OFFSET = 0x15;

    private static final ArrayList<Item> SWORDS = new ArrayList<Item>(List.of(IRON_SWORD, STEEL_SWORD, SILVER_SWORD,
            THIN_SWORD, IRON_BLADE, KILLER_SWORD, POISON_SWORD, BERSERK_SWORD, SLEEP_SWORD, BEOSWORD, HOLY_SWORD,
            LOPUTOUS_SWORD, BLAGI_SWORD, LIGHT_SWORD, BRAVE_SWORD, KING_SWORD, EARTH_SWORD, WIND_SWORD, FIRE_SWORD,
            THUNDER_SWORD, ELITE_SWORD, ARMORSLAYER, RAPIER, SHORT_SWORD, LONG_SWORD, GREAT_SWORD, MASTER_SWORD,
            DARKNESS_SWORD, MAREETAS_SWORD));
    private static final ArrayList<Item> LANCES = new ArrayList<Item>(List.of(IRON_LANCE, STEEL_LANCE, SILVER_LANCE,
            THIN_LANCE, POISON_LANCE, DRAGON_LANCE, DARKNESS_LANCE, BRAVE_LANCE, SHORT_LANCE, LONG_LANCE, GREAT_LANCE,
            JAVELIN, MASTER_LANCE, KNIGHT_KILLER, KILLER_LANCE, GAE_BOLG, GUNGNIR));
    private static final ArrayList<Item> AXES = new ArrayList<Item>(List.of(IRON_AXE, POISON_AXE, STEEL_AXE, SILVER_AXE,
            HAND_AXE, HAMMER, KILLER_AXE, PUGI, BRAVE_AXE, DEVIL_AXE, BATTLE_AXE, POLEAXE, MASTER_AXE));
    private static final ArrayList<Item> BOWS = new ArrayList<Item>(List.of(IRON_BOW, STEEL_BOW, SILVER_BOW, POISON_BOW,
            KILLER_BOW, BRAVE_BOW, SHORT_BOW, LONG_BOW, GREAT_BOW, MASTER_BOW));
    private static final ArrayList<Item> STAVES = new ArrayList<Item>(
            List.of(HEAL, MEND, RECOVER, PHYSIC, RESERVE, RESCUE, WARP, RESTORE, SILENCE, SLEEP, TORCH_STAFF, RETURN, REPAIR,
                    THIEF_STAFF, WATCH, BERSERK, UNLOCK, MAGIC_UP, REWARP, KIA_STAFF));
    private static final ArrayList<Item> FIRE_MAGIC = new ArrayList<Item>(
            List.of(FIRE, ELFIRE, VOLCANNON, FALAFLAME, METEOR));
    private static final ArrayList<Item> THUNDER_MAGIC = new ArrayList<Item>(
            List.of(THUNDER, DAIM_THUNDER, TRON, THUNDERSTORM, TORHAMMER));
    private static final ArrayList<Item> WIND_MAGIC = new ArrayList<Item>(
            List.of(WIND, GRAFUCALIBUR, TORNADO, HOLSETY, BLIZZARD));
    private static final ArrayList<Item> LIGHT_MAGIC = new ArrayList<Item>(List.of(LIGHTNING, RESIRE, AURA));
    private static final ArrayList<Item> DARK_MAGIC = new ArrayList<Item>(
            List.of(YOTSMUNGAND, FENRIR, HELL, LOPUTOUS, POISON, STONE));
    private static final ArrayList<Item> ITEMS = new ArrayList<Item>(
            List.of(LUCK_RING, LIFE_RING, SPEED_RING, MAGIC_RING, POWER_RING, BODY_RING, SHIELD_RING, SKILL_RING,
                    LEG_RING, KNIGHT_PROOF, MASTER_PROOF, TREASURE_KEY, DOOR_KEY, BRIDGE_KEY, LOCKPICK, STAMINA_DRINK,
                    VULNERARY, HOLY_WATER, TORCH, ANTIDOTE, MEMBER_CARD, ODO_SCROLL, BALDO_SCROLL, HEZUL_SCROLL,
                    DAIN_SCROLL, NOBA_SCROLL, NEIR_SCROLL, ULIR_SCROLL, TORDO_SCROLL, FALA_SCROLL, SETY_SCROLL,
                    BLAGI_SCROLL, HEIM_SCROLL, ELITE_MANUAL, CHARGE_MANUAL, BARGAIN_MANUAL, AMBUSH_MANUAL, WRATH_MANUAL,
                    CONTINUE_MANUAL, PRAYER_MANUAL, AWARENESS_MANUAL, SUNLIGHT_MANUAL, MOONLIGHT_MANUAL));
    private static final ArrayList<Item> SCROLLS = new ArrayList<Item>(
            List.of(ODO_SCROLL, BALDO_SCROLL, HEZUL_SCROLL, DAIN_SCROLL, NOBA_SCROLL, NEIR_SCROLL, ULIR_SCROLL,
                    TORDO_SCROLL, FALA_SCROLL, SETY_SCROLL, BLAGI_SCROLL, HEIM_SCROLL));
    private static final ArrayList<Item> UNUSED = new ArrayList<Item>(
            List.of(MASTER_PROOF, DARKNESS_LANCE, VOLCANNON, FALAFLAME, TORHAMMER, AURA, LOPUTOUS, WATCH, RETURN,
                    GUNGNIR, GAE_BOLG, KILLER_ARCH));
    private static final ArrayList<Item> ENEMY_ONLY = new ArrayList<Item>(
            List.of(POISON_SWORD, POISON_LANCE, POISON_AXE, POISON_BOW));
    private static final ArrayList<Item> PLAYER_ONLY = new ArrayList<Item>(
            List.of(THIEF_STAFF));
    private static final ArrayList<Item> BROKEN = new ArrayList<Item>(
            List.of(BROKEN_SWORD, BROKEN_LANCE, BROKEN_AXE, BROKEN_BOW, BROKEN_STAFF, BROKEN_BOOK));
    private static final ArrayList<Item> MANUALS = new ArrayList<>(
            List.of(ELITE_MANUAL, CHARGE_MANUAL, BARGAIN_MANUAL, AMBUSH_MANUAL, WRATH_MANUAL, CONTINUE_MANUAL,
                    PRAYER_MANUAL, AWARENESS_MANUAL, SUNLIGHT_MANUAL, MOONLIGHT_MANUAL));
    private static final ArrayList<Item> RINGS = new ArrayList<Item>(List.of(LUCK_RING, LIFE_RING, SPEED_RING,
            MAGIC_RING, POWER_RING, BODY_RING, SHIELD_RING, SKILL_RING, LEG_RING));
    private static final ArrayList<Item> COMMON_ITEMS = new ArrayList<>(
            List.of(TREASURE_KEY, DOOR_KEY, BRIDGE_KEY, LOCKPICK, STAMINA_DRINK, VULNERARY, HOLY_WATER, TORCH,
                    ANTIDOTE));
    private static final ArrayList<Item> NO_REWARD = new ArrayList<>(
            List.of(LONG_ARCH, IRON_ARCH, POISON_ARCH, LOPUTOUS_SWORD, HOLSETY, HOLSETY_UNLIMITED));
    
    private Item(int offset, String name) {
        this.offset = offset;
        this.name = name;
    }

    public int getOffset() {
        return offset;
    }

    public String getName() {
        return name;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getPower() {
        return power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaxUses() {
        return maxUses;
    }

    public int getCritical() {
        return critical;
    }

    public WeaponRange getWeaponRange() {
        return weaponRange;
    }

    public WeaponRank getWeaponRank() {
        return weaponRank;
    }

    public WeaponEffectiveness getWeaponEffectiveness() {
        return weaponEffectiveness;
    }

    public WeaponStatBonus getWeaponStatBonus() {
        return weaponStatBonus;
    }

    public int getCostPerUse() {
        return costPerUse;
    }
    
    public int getDescriptionPointer() {
        return descriptionPointer;
    }

    public ItemUseEffect getItemUseEffect() {
        return itemUseEffect;
    }

    public WeaponBladeEffect getWeaponBladeEffect() {
        return weaponBladeEffect;
    }

    public int getSkills1() {
        return skills1;
    }

    public int getSkills2() {
        return skills2;
    }
    
    public ArrayList<WeaponSkill> getSkills() {
        return new ArrayList<>(skills);
    }

    public ItemClassification getItemClassification() {
        return itemClassification;
    }

    public void setPower(int power) {
        if(!oldValues.containsKey("power") && this.power != power) {
            oldValues.put("power", this.power);
        }
        
        this.power = power;
    }

    public void setAccuracy(int accuracy) {
        if(!oldValues.containsKey("accuracy") && this.accuracy != accuracy) {
            oldValues.put("accuracy", this.accuracy);
        }
        
        this.accuracy = accuracy;
    }

    public void setWeight(int weight) {
        if(!oldValues.containsKey("weight") && this.weight != weight) {
            oldValues.put("weight", this.weight);
        }
        
        this.weight = weight;
    }

    public void setMaxUses(int maxUses) {
        if(!oldValues.containsKey("maxUses") && this.maxUses != maxUses) {
            oldValues.put("maxUses", this.maxUses);
        }
        
        this.maxUses = maxUses;
    }

    public void setCritical(int critical) {
        if(!oldValues.containsKey("critical") && this.critical != critical) {
            oldValues.put("critical", this.critical);
        }
        
        this.critical = critical;
    }

    public void setWeaponRank(WeaponRank weaponRank) {
        if(!oldValues.containsKey("weaponRank") && this.weaponRank != weaponRank) {
            oldValues.put("weaponRank", this.weaponRank);
        }
        
        this.weaponRank = weaponRank;
    }

    public void setWeaponEffectiveness(WeaponEffectiveness weaponEffectiveness) {
        if(!oldValues.containsKey("weaponEffectiveness") && this.weaponEffectiveness != weaponEffectiveness) {
            oldValues.put("weaponEffectiveness", this.weaponEffectiveness);
        }
        
        this.weaponEffectiveness = weaponEffectiveness;
    }

    public void setWeaponStatBonus(WeaponStatBonus weaponStatBonus) {
        if(!oldValues.containsKey("weaponStatBonus") && this.weaponStatBonus != weaponStatBonus) {
            oldValues.put("weaponStatBonus", this.weaponStatBonus);
        }
        
        this.weaponStatBonus = weaponStatBonus;
    }

    public void setCostPerUse(int costPerUse) {
        if(!oldValues.containsKey("costPerUse") && this.costPerUse != costPerUse) {
            oldValues.put("costPerUse", this.costPerUse);
        }
        
        this.costPerUse = costPerUse;
    }

    public void setItemUseEffect(ItemUseEffect itemUseEffect) {
        if(!oldValues.containsKey("itemUseEffect") && this.itemUseEffect != itemUseEffect) {
            oldValues.put("itemUseEffect", this.itemUseEffect);
        }
        
        this.itemUseEffect = itemUseEffect;
    }

    public void setWeaponBladeEffect(WeaponBladeEffect weaponBladeEffect) {
        if(!oldValues.containsKey("weaponBladeEffect") && this.weaponBladeEffect != weaponBladeEffect) {
            oldValues.put("weaponBladeEffect", this.weaponBladeEffect);
        }
        
        this.weaponBladeEffect = weaponBladeEffect;
    }
    
    public void setSkills(ArrayList<WeaponSkill> skills) {
        int[] newSkills = WeaponSkill.getSkills(skills);
        
        if(!oldValues.containsKey("skills1") && skills1 != newSkills[0]) {
            int oldSkills1 = this.skills1;
            oldValues.put("skills1", oldSkills1);
        }
        
        if(!oldValues.containsKey("skills2") && skills2 != newSkills[1]) {
            int oldSkills2 = this.skills2;
            oldValues.put("skills2", oldSkills2);
        }
        
        this.skills1 = newSkills[0];
        this.skills2 = newSkills[1];
        this.skills = skills;
    }

    public boolean isSword() {
        return SWORDS.contains(this);
    }

    public boolean isLance() {
        return LANCES.contains(this);
    }

    public boolean isAxe() {
        return AXES.contains(this);
    }

    public boolean isBow() {
        return BOWS.contains(this);
    }

    public boolean isStaff() {
        return STAVES.contains(this);
    }

    public boolean isFireMagic() {
        return FIRE_MAGIC.contains(this);
    }

    public boolean isThunderMagic() {
        return THUNDER_MAGIC.contains(this);
    }

    public boolean isWindMagic() {
        return WIND_MAGIC.contains(this);
    }

    public boolean isLightMagic() {
        return LIGHT_MAGIC.contains(this);
    }

    public boolean isDarkMagic() {
        return DARK_MAGIC.contains(this);
    }

    public boolean isItem() {
        return ITEMS.contains(this);
    }

    public boolean isScroll() {
        return SCROLLS.contains(this);
    }
    
    public boolean isManual() {
        return MANUALS.contains(this);
    }
    
    public boolean isRing() {
        return RINGS.contains(this);
    }
    
    public boolean isCommonItem() {
        return COMMON_ITEMS.contains(this);
    }

    public boolean isUnused() {
        return UNUSED.contains(this);
    }

    public boolean isEnemyOnly() {
        return ENEMY_ONLY.contains(this);
    }
    
    public boolean isPlayerOnly() {
        return PLAYER_ONLY.contains(this);
    }
    
    public static ArrayList<Item> getUnusedItems() {
        return new ArrayList<Item>(UNUSED);
    }
    
    public static ArrayList<Item> getBrokenItems() {
        return new ArrayList<Item>(BROKEN);
    }
    
    public static ArrayList<Item> getNonWeaponItems() {
        return new ArrayList<Item>(ITEMS);
    }
    
    public static ArrayList<Item> getItems(boolean excludeUnused, boolean excludeEnemyWeapons) {
        ArrayList<Item> items = new ArrayList<>(Arrays.asList(Item.values()));
        
        items.removeAll(BROKEN);
        items.removeAll(NO_REWARD);
        
        if(excludeUnused) {
            items.removeAll(UNUSED);
        }
        
        if(excludeEnemyWeapons) {
            items.removeAll(ENEMY_ONLY);
        }
        
        return new ArrayList<Item>(items);
    }
    
    public static ArrayList<Item> getWeapons(boolean excludeUnused) {
        ArrayList<Item> weapons = new ArrayList<>();
        
        weapons.addAll(SWORDS);
        weapons.addAll(LANCES);
        weapons.addAll(AXES);
        weapons.addAll(BOWS);
        weapons.addAll(STAVES);
        weapons.addAll(FIRE_MAGIC);
        weapons.addAll(THUNDER_MAGIC);
        weapons.addAll(WIND_MAGIC);
        weapons.addAll(LIGHT_MAGIC);
        weapons.addAll(DARK_MAGIC);
        
        if(excludeUnused) {
            weapons.removeAll(UNUSED);
        }
        
        return weapons;
    }
    
    public static ArrayList<Item> getScrolls() {
        ArrayList<Item> scrolls = new ArrayList<>();
        scrolls.addAll(SCROLLS);
        
        return scrolls;
    }

    public void readItem(Rom rom, int startingOffset) {
        int relOffset = startingOffset + offset * ITEM_DATA_SIZE;

        itemType = ItemType.findById(rom.getValueAt(relOffset + ITEM_TYPE_OFFSET));
        power = rom.getValueAt(relOffset + POWER_OFFSET);
        accuracy = rom.getValueAt(relOffset + ACCURACY_OFFSET);
        weight = rom.getValueAt(relOffset + WEIGHT_OFFSET);
        maxUses = rom.getValueAt(relOffset + MAX_USES_OFFSET);
        critical = rom.getValueAt(relOffset + CRITICAL_OFFSET);
        weaponRange = WeaponRange.findById(rom.getValueAt(relOffset + RANGE_OFFSET));
        weaponRank = WeaponRank.findById(rom.getValueAt(relOffset + WEAPON_RANK_OFFSET, 2));
        weaponEffectiveness = WeaponEffectiveness.findById(rom.getValueAt(relOffset + WPN_EFFECTIVENESS_OFFSET, 2));
        weaponStatBonus = WeaponStatBonus.findById(rom.getValueAt(relOffset + STAT_BONUSES_OFFSET, 2));
        costPerUse = rom.getValueAt(relOffset + COST_PER_USE_OFFSET, 2);
        descriptionPointer = rom.getValueAt(relOffset + DESCRIPTION_OFFSET, 2);
        itemUseEffect = ItemUseEffect.findById(rom.getValueAt(relOffset + USE_EFFECT_OFFSET));
        weaponBladeEffect = WeaponBladeEffect.findById(rom.getValueAt(relOffset + BLADE_EFFECT_OFFSET));
        skills1 = rom.getValueAt(relOffset + WEAPON_SKILL1_OFFSET);
        skills2 = rom.getValueAt(relOffset + WEAPON_SKILL2_OFFSET);
        skills = WeaponSkill.getSkills(skills1, skills2);
        itemClassification = ItemClassification.findById(rom.getValueAt(relOffset + ITEM_CLASSIFICATION_OFFSET));
    }
    
    public void writeItem(Rom rom, int startingOffset) {
        int relOffset = startingOffset + offset * ITEM_DATA_SIZE;

        if(oldValues.containsKey("power")) {
            rom.setValueAt(relOffset + POWER_OFFSET, power);
        }

        if(oldValues.containsKey("accuracy")) {
            rom.setValueAt(relOffset + ACCURACY_OFFSET, accuracy);
        }

        if(oldValues.containsKey("weight")) {
            rom.setValueAt(relOffset + WEIGHT_OFFSET, weight);
        }

        if(oldValues.containsKey("maxUses")) {
            rom.setValueAt(relOffset + MAX_USES_OFFSET, maxUses);
        }

        if(oldValues.containsKey("critical")) {
            rom.setValueAt(relOffset + CRITICAL_OFFSET, critical);
        }

        if(oldValues.containsKey("weaponRank")) {
            rom.set2ByteValueAt(relOffset + WEAPON_RANK_OFFSET, weaponRank.getOffset());
        }

        if(oldValues.containsKey("weaponEffectiveness")) {
            rom.set2ByteValueAt(relOffset + WPN_EFFECTIVENESS_OFFSET, weaponEffectiveness.getOffset());
        }

        if(oldValues.containsKey("weaponStatBonus")) {
            rom.set2ByteValueAt(relOffset + STAT_BONUSES_OFFSET, weaponStatBonus.getOffset());
        }

        if(oldValues.containsKey("costPerUse")) {
            rom.set2ByteValueAt(relOffset + COST_PER_USE_OFFSET, costPerUse);
        }

        if(oldValues.containsKey("weaponBladeEffect")) {
            rom.setValueAt(relOffset + BLADE_EFFECT_OFFSET, weaponBladeEffect.getOffset());
        }

        if(oldValues.containsKey("skills1")) {
            rom.setValueAt(relOffset + WEAPON_SKILL1_OFFSET, skills1);
        }

        if(oldValues.containsKey("skills2")) {
            rom.setValueAt(relOffset + WEAPON_SKILL2_OFFSET, skills2);
        }

        if(oldValues.containsKey("itemClassification")) {
            rom.setValueAt(relOffset + ITEM_CLASSIFICATION_OFFSET, itemClassification.getOffset());
        }
    }
    
    public void reset() {
        if(oldValues.containsKey("power")) {
            power = (int)oldValues.get("power");
        }
        
        if(oldValues.containsKey("accuracy")) {
            accuracy = (int)oldValues.get("accuracy");
        }
        
        if(oldValues.containsKey("weight")) {
            weight = (int)oldValues.get("weight");
        }
        
        if(oldValues.containsKey("critical")) {
            critical = (int)oldValues.get("critical");
        }
        
        if(oldValues.containsKey("weaponRange")) {
            weaponRange = (WeaponRange)oldValues.get("weaponRange");
        }
        
        if(oldValues.containsKey("weaponRank")) {
            weaponRank = (WeaponRank)oldValues.get("weaponRank");
        }
        
        if(oldValues.containsKey("weaponEffectiveness")) {
            weaponEffectiveness = (WeaponEffectiveness)oldValues.get("weaponEffectiveness");
        }
        
        if(oldValues.containsKey("costPerUse")) {
            costPerUse = (int)oldValues.get("costPerUse");
        }
        
        if(oldValues.containsKey("weaponBladeEffect")) {
            weaponBladeEffect = (WeaponBladeEffect)oldValues.get("weaponBladeEffect");
        }
        
        if(oldValues.containsKey("skills1")) {
            skills1 = (int)oldValues.get("skills1");
        }
        
        if(oldValues.containsKey("skills2")) {
            skills2 = (int)oldValues.get("skills2");
        }
        
        skills = WeaponSkill.getSkills(skills1, skills2);
        
        oldValues.clear();
    }

    public static Item findById(int offset) {
        Item item = null;

        for(Item currentItem : Item.values()) {
            if(currentItem.offset == offset) {
                item = currentItem;
                break;
            }
        }

        if(item == null) {
            System.out.println(String.format("WARNING: Offset 0x%02X in Item was not found.", offset));
            item = Item.IRON_SWORD;
        }

        return item;
    }
    
    public Map<String, Object> getOldValues() {
        return oldValues;
    }

    @Override
    public String toString() {
        String itemData = "";

        itemData += String.format(
                "[Item] Name: %s, Item type: %s, Power: %d, Acc: %d, Weight: %d, Max uses: %d, Crit: %d, Wpn Rng: %s, Wpn Rank: %s, Wpn Effectiveness: %s, Wpn stat bonus: %s, Cost x use: %d, Desc pointer: %04X, Use effect: %s, Blade eff: %s, Skills1: %d, Skills2: %d, Item class: %s",
                name, itemType.getName(), power, accuracy, weight, maxUses, critical, weaponRange.getName(),
                weaponRank.getName(), weaponEffectiveness.getName(), weaponStatBonus.getName(), costPerUse, descriptionPointer,
                itemUseEffect.getName(), weaponBladeEffect.getName(), skills1, skills2,
                itemClassification.getName());

        return itemData;
    }
}
