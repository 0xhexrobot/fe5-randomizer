package org.hexrobot.fe5randomizer;

import java.util.*;

import org.hexrobot.fe5randomizer.chapters.ArmyUnit;
import org.hexrobot.fe5randomizer.characters.CharacterClass;
import org.hexrobot.fe5randomizer.characters.GameCharacter;
import org.hexrobot.fe5randomizer.characters.Gender;
import org.hexrobot.fe5randomizer.items.Item;
import org.hexrobot.fe5randomizer.items.ItemType;

public class RandomizationLogic {
    private Map<GameCharacter, List<CharacterClass>> bannedClasses = new HashMap<>();
    private Map<GameCharacter, List<CharacterClass>> limitedClassPool = new HashMap<>();
    private List<Item> uniqueRewards = new ArrayList<>();
    private Map<Item, Float> itemScarcity = new HashMap<>();
    private Map<Item, Integer> rewardFreq = new HashMap<>();
    private Map<CharacterClass, Integer> playerClassFreq = new HashMap<>();
    private Map<ItemType, Integer> playerWpnFreq = new HashMap<>();
    private ItemType[] weaponTypes = new ItemType[] {ItemType.SWORD, ItemType.LANCE, ItemType.AXE, ItemType.BOW,
            ItemType.STAFF, ItemType.FIRE, ItemType.THUNDER, ItemType.WIND, ItemType.LIGHT, ItemType.DARK};
    private Map<ItemType, Integer> wpnsTargetCount = new HashMap<>();
    private static final int DEFAULT_WPN_TARGET_COUNT = 10;
    private static final float DEFAULT_ITEM_RARENESS = 1.0f;
    private boolean dancerAssigned = false;
    
    public RandomizationLogic(RandomizationSummary summary) {
        setClassRescrictions(!summary.getExcludeThieves());
        setItemScarcity();
        populateUniqueRewards();
        setWpnTargetCount();
    }

    private void setClassRescrictions(boolean lifisClassRandomized) {
        List<CharacterClass> mountedClasses = CharacterClass.getMountedClasses();
        List<CharacterClass> flyingClasses = CharacterClass.getFlyingClasses();
        List<CharacterClass> canTraverseWaterClasses = CharacterClass.getCanTraverseWaterClasses();
        List<CharacterClass> healerClasses = CharacterClass.getHealerClasses();
        List<CharacterClass> mountedOrHealers = new ArrayList<>();
        mountedOrHealers.addAll(mountedClasses);
        mountedOrHealers.addAll(healerClasses);
        List<CharacterClass> promotedUnmountedSwordUsers = CharacterClass.getPromotedUnmountedSwordUsers();

        // exclude these classes for these characters
        bannedClasses.put(GameCharacter.GALZUS, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_SOLDIER, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_ARCHER, mountedClasses);
        bannedClasses.put(GameCharacter.MERCENARY_SWORD_FIGHTER, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_THUNDER_MAGE, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_MAGE, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_MAGE_F, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_BISHOP, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_BISHOP2, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_AXE_ARMOR, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_SWORD_ARMOR, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_BOW_ARMOR, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_LANCE_ARMOR, mountedClasses);
        bannedClasses.put(GameCharacter.ROBOS, mountedClasses);
        bannedClasses.put(GameCharacter.BANTOL_BOSS, mountedClasses);
        bannedClasses.put(GameCharacter.ROPUTO_DARK_MAGE, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_PRIEST, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_SNIPER, mountedClasses);
        bannedClasses.put(GameCharacter.LOPTO_DARK_BISHOP, mountedClasses);
        bannedClasses.put(GameCharacter.ASVEL, mountedClasses);
        bannedClasses.put(GameCharacter.MAREETA, mountedClasses);
        bannedClasses.put(GameCharacter.NANNA, mountedClasses);
        bannedClasses.put(GameCharacter.LINOAN, new ArrayList<>(List.of(CharacterClass.DANCER)));
        bannedClasses.put(GameCharacter.ENVOY_MERCENARY, mountedClasses);
        bannedClasses.put(GameCharacter.ENVOY_WARRIOR, mountedClasses);
        bannedClasses.put(GameCharacter.ENVOY_GENERAL, mountedClasses);
        bannedClasses.put(GameCharacter.ENVOY_SWORDMASTER, mountedClasses);
        bannedClasses.put(GameCharacter.ENVOY_BERSERKER, mountedClasses);
        bannedClasses.put(GameCharacter.MAGI_SQUAD_SWORD_FIGHTER_F, mountedClasses);
        bannedClasses.put(GameCharacter.MAGI_SQUAD_SWORD_FIGHTER, mountedClasses);
        bannedClasses.put(GameCharacter.MAGI_SQUAD_AXE_FIGHTER, mountedClasses);
        bannedClasses.put(GameCharacter.MAGI_SQUAD_BOW_FIGHTER, mountedClasses);
        bannedClasses.put(GameCharacter.LUMEI_BOSS, mountedClasses);
        bannedClasses.put(GameCharacter.BANDIT_HUNTER, mountedClasses);
        bannedClasses.put(GameCharacter.BANDIT_MOUNTAIN_THIEF, mountedOrHealers);
        bannedClasses.put(GameCharacter.THIEF_F, mountedClasses);
        bannedClasses.put(GameCharacter.FREEGE_MAGE, mountedClasses);
        bannedClasses.put(GameCharacter.FREEGE_SOLDIER, mountedClasses);
        bannedClasses.put(GameCharacter.FREEGE_AXE_ARMOR, mountedClasses);
        bannedClasses.put(GameCharacter.FREEGE_ARCHER, mountedClasses);
        bannedClasses.put(GameCharacter.FREEGE_SWORD_ARMOR2, mountedClasses);
        bannedClasses.put(GameCharacter.SEIRAM, mountedClasses);
        bannedClasses.put(GameCharacter.BOW_FIGHTER, mountedClasses);
        bannedClasses.put(GameCharacter.MERCENARY_SWORD_FIGHTER2, mountedClasses);
        bannedClasses.put(GameCharacter.DANCER, mountedClasses);
        bannedClasses.put(GameCharacter.TREWD, mountedClasses);
        bannedClasses.put(GameCharacter.THIEF2, mountedClasses);
        bannedClasses.put(GameCharacter.LENSTER_SOLDIER, mountedClasses);
        bannedClasses.put(GameCharacter.FREEGE_LANCE_ARMOR, mountedClasses);
        bannedClasses.put(GameCharacter.XAVIER_LENSTER_ARMOR1, mountedClasses);
        bannedClasses.put(GameCharacter.XAVIER_LENSTER_ARMOR2, mountedClasses);
        bannedClasses.put(GameCharacter.XAVIER_LENSTER_ARMOR3, mountedClasses);
        bannedClasses.put(GameCharacter.XAVIER_LENSTER_ARMOR4, mountedClasses);
        bannedClasses.put(GameCharacter.XAVIER_LENSTER_ARMOR5, mountedClasses);
        bannedClasses.put(GameCharacter.XAVIER_LENSTER_ARMOR6, mountedClasses);
        bannedClasses.put(GameCharacter.XAVIER_LENSTER_ARMOR7, mountedClasses);
        bannedClasses.put(GameCharacter.XAVIER_LENSTER_ARMOR8, mountedClasses);
        bannedClasses.put(GameCharacter.XAVIER, mountedClasses);
        bannedClasses.put(GameCharacter.FREEGE_PRIEST2, mountedClasses);
        bannedClasses.put(GameCharacter.LOPTO_DARK_MAGE, mountedClasses);
        bannedClasses.put(GameCharacter.MERCENARY, mountedClasses);
        bannedClasses.put(GameCharacter.MERCENARY3, mountedClasses);
        bannedClasses.put(GameCharacter.MERCENARY4, mountedClasses);
        bannedClasses.put(GameCharacter.SNIPER, mountedClasses);
        bannedClasses.put(GameCharacter.BERSERKER, mountedClasses);
        bannedClasses.put(GameCharacter.EINS, mountedClasses);
        bannedClasses.put(GameCharacter.LOPTO_AXE_ARMOR, mountedClasses);
        bannedClasses.put(GameCharacter.LOPTO_BOW_ARMOR, mountedClasses);
        bannedClasses.put(GameCharacter.LOPTO_LANCE_ARMOR, mountedClasses);
        bannedClasses.put(GameCharacter.DREI_DAGDA, mountedClasses);
        bannedClasses.put(GameCharacter.DREI, mountedClasses);
        bannedClasses.put(GameCharacter.ELF_SARA, mountedClasses);
        bannedClasses.put(GameCharacter.ELF, mountedClasses);
        bannedClasses.put(GameCharacter.ZWEI_GALZUS, mountedClasses);
        bannedClasses.put(GameCharacter.ZWEI, mountedClasses);
        bannedClasses.put(GameCharacter.ZWOLF_LIFIS, mountedClasses);
        bannedClasses.put(GameCharacter.ZWOLF, mountedClasses);
        bannedClasses.put(GameCharacter.FUNF_EYVEL, mountedClasses);
        bannedClasses.put(GameCharacter.FELGUS, mountedClasses);
        bannedClasses.put(GameCharacter.LARA, mountedClasses);
        bannedClasses.put(GameCharacter.KARIN, mountedClasses);
        bannedClasses.put(GameCharacter.DALSHEIN, mountedClasses);
        bannedClasses.put(GameCharacter.BRIGHTON, mountedClasses);
        bannedClasses.put(GameCharacter.MACHYUA, mountedClasses);
        bannedClasses.put(GameCharacter.LENSTER_LANCE_KNIGHT, healerClasses);
        bannedClasses.put(GameCharacter.LENSTER_ARCH_KNIGHT, healerClasses);
        bannedClasses.put(GameCharacter.GUSTAF_BOSS, mountedClasses);
        bannedClasses.put(GameCharacter.RIFIS_GANG_WARRIOR, mountedClasses);
        bannedClasses.put(GameCharacter.TINA, mountedClasses);

        if(lifisClassRandomized) {
            bannedClasses.put(GameCharacter.RIFIS, mountedClasses);
        }

        // only these classes are available for these characters
        limitedClassPool.put(GameCharacter.RIFIS_GANG_PIRATE, canTraverseWaterClasses);
        limitedClassPool.put(GameCharacter.TOBOLZARK_BOSS, flyingClasses);
        limitedClassPool.put(GameCharacter.SILESIA_PEGASUS_RIDER, flyingClasses);
        limitedClassPool.put(GameCharacter.PIRATE, flyingClasses);
        limitedClassPool.put(GameCharacter.MISHA, flyingClasses);
        limitedClassPool.put(GameCharacter.SILESIA_PEGASUS_RIDER1, flyingClasses);
        limitedClassPool.put(GameCharacter.THRACIA_DRAGON_KNIGHT2, flyingClasses);
        limitedClassPool.put(GameCharacter.SEMITOL_BOSS, flyingClasses);
        limitedClassPool.put(GameCharacter.KORUTA_BOSS, flyingClasses);
        limitedClassPool.put(GameCharacter.THRACIA_DRAGON_KNIGHT3, flyingClasses);
        limitedClassPool.put(GameCharacter.MALLOCK_BOSS, flyingClasses);
        limitedClassPool.put(GameCharacter.LEIDRICK_1, promotedUnmountedSwordUsers);
    }

    private void setWpnTargetCount() {
        wpnsTargetCount.put(ItemType.SWORD, 20);
        wpnsTargetCount.put(ItemType.LIGHT, 5);
        wpnsTargetCount.put(ItemType.DARK, 5);
    }

    public float assignItemWeight(ArmyUnit unit, Item item, List<Item> inventory, boolean treatAsUnmounted) {
        GameCharacter character = unit.getCharacter();
        CharacterClass chClass = character.getCharacterClass();

        if(character.isPlayableUnit() && item.isEnemyOnly()) {
            return 0;
        }

        if(character.isEnemyUnit() && item.isPlayerOnly()) {
            return 0;
        }

        if (!unit.canUseWeapon(item, treatAsUnmounted)) {
            return 0;
        }

        // relative item scarcity
        float value = itemScarcity.getOrDefault(item, DEFAULT_ITEM_RARENESS);

        // lower value to repeated items
        int countSameItems = Collections.frequency(inventory, item);
        value *= 1 / (float)(Math.pow(4, countSameItems));

        // weapon rank value
        float rankValue;
        if(character.hasRandomBases()) {
            int unitLevel = unit.getLevel();

            if(character.getCharacterClass().isPromoted()) {
                unitLevel += 20;
            }

            // lower ranked wpns for low level units, high ranked wpns for high level units
            switch(item.getWeaponRank()) {
                case A: rankValue = Math.max(unitLevel / 4.0f - 5.0f, 0); break;
                case B: rankValue = Math.max(4.0f * unitLevel / 25.0f - 12.0f / 5.0f, 0); break;
                case C: rankValue = Math.max(2.5f - 3.0f / (1 + (float)Math.exp(unitLevel / 3.0f - 4.0f)), 0); break;
                case D: rankValue = Math.max(4.0f - 3.0f * unitLevel / 40.0f, 0); break;
                case E: rankValue = Math.max(5.0f - 9.0f * unitLevel / 80.0f, 0); break;
                default: rankValue = 1.0f; break;
            }
        } else {
            // higher value to higher ranked weapons
            switch(item.getWeaponRank()) {
                case A: rankValue = 5.0f; break;
                case B: rankValue = 4.0f; break;
                case C: rankValue = 3.0f; break;
                case D: rankValue = 2.0f; break;
                default: rankValue = 1.0f; break;
            }
        }

        value *= rankValue;

        //biased to give weapon to healers if posible
        float healerSelfDef = 1.0f;

        if(chClass.isHealer() || chClass.canUseWeaponType(ItemType.STAFF)) {
            if(chClass.canUseWeaponType(ItemType.SWORD) || chClass.canUseWeaponType(ItemType.FIRE)
                || chClass.canUseWeaponType(ItemType.THUNDER) || chClass.canUseWeaponType(ItemType.WIND)
            || chClass.canUseWeaponType(ItemType.LIGHT) || chClass.canUseWeaponType(ItemType.DARK)) {
                if(!canHealerDefend(unit, inventory)) {
                    if(item.getItemType().equals(ItemType.STAFF)) {
                        if(character.isPlayableUnit()) {
                            healerSelfDef = 0;
                        } else {
                            healerSelfDef = 0.1f;
                        }
                    }
                }
            }
        }

        value *= healerSelfDef;
        
        return value;
    }

    private boolean canHealerDefend(ArmyUnit unit, List<Item> inventory) {
        boolean canDefend = false;

        for(Item item : inventory) {
            ItemType type = item.getItemType();

            // ignore normal items
            if(type.equals(ItemType.ITEM)) {
                continue;
            }

            if(unit.canUseWeapon(item) && !type.equals(ItemType.STAFF)) {
                canDefend = true;
                break;
            }
        }

        return canDefend;
    }

    public float assignRewardWeight(Item item, List<Item> inventory) {
        // don't allow duplicates
        if(inventory.contains(item)) {
            return 0;
        }

        float value = 1;

        // global frequency
        int itemFreq = rewardFreq.getOrDefault(item, 0);
        value *= 1 / (float)(Math.pow(4, itemFreq));

        // scarcity
        float itemScarcity = 1.0f;
        if(!item.isCommonItem()) {
            itemScarcity = 0.1f;
        }

        value *= itemScarcity;

        return value;
    }

    public void registerReward(Item item) {
        int occurrences = rewardFreq.getOrDefault(item, 0);
        rewardFreq.put(item, occurrences + 1);
    }

    public void registerPlayerClass(CharacterClass playerClass) {
        int occurrences = playerClassFreq.getOrDefault(playerClass, 0);
        playerClassFreq.put(playerClass, occurrences + 1);
        registerPlayerWeapon(playerClass);
    }

    public void registerDancer() {
        dancerAssigned = true;
    }

    private void registerPlayerWeapon(CharacterClass playerClass) {
        int occurrences;

        for (ItemType type : weaponTypes) {
            if(playerClass.canUseWeaponType(type)) {
                occurrences = playerWpnFreq.getOrDefault(type, 0);
                playerWpnFreq.put(type, occurrences + 1);
            }
        }
    }

    public float assignClassWeight(GameCharacter character, CharacterClass characterClass, boolean playerCharacter) {
        // don't allow trans classes
        if(character.getGender() == Gender.MALE && characterClass.isFemaleClass()) {
            return 0;
        } else if(character.getGender() == Gender.FEMALE && !characterClass.isFemaleClass()) {
            return 0;
        }

        // don't allow if banned class
        if(bannedClasses.containsKey(character)) {
            List<CharacterClass> banned = bannedClasses.get(character);

            if(banned.contains(characterClass)) {
                return 0;
            }
        }

        // don't allow if not in limited class list
        if(limitedClassPool.containsKey(character)) {
            List<CharacterClass> limitedTo = limitedClassPool.get(character);
            
            if(!limitedTo.contains(characterClass)) {
                return 0;
            }
        }

        // don't allow unmounted except for player if restricted to unmounted
        if(characterClass.isDismounted() && (!bannedClasses.containsKey(character) || !character.isPlayableUnit())) {
            return 0;
        }

        // don't allow more than 1 dancer for player
        if(characterClass.equals(CharacterClass.DANCER) && playerCharacter && dancerAssigned) {
            return 0;
        }

        float value = 1.0f;

        // same class
        if(character.getCharacterClass().equals(characterClass)) {
            value *= 0.1f;
        }

        if(playerCharacter) {
            // weapon frequency
            float wpnFreqValue = 0;
            int usableWpnsCount = 0;

            for(ItemType type : weaponTypes) {
                if(characterClass.canUseWeaponType(type)) {
                    int targetCount = wpnsTargetCount.getOrDefault(type, DEFAULT_WPN_TARGET_COUNT);
                    wpnFreqValue += Math.max(1.0f - playerWpnFreq.getOrDefault(type, 0) / (float)targetCount, 0);
                    usableWpnsCount++;
                }
            }

            wpnFreqValue = wpnFreqValue / usableWpnsCount;
            value *= wpnFreqValue;
        }

        return value;
    }

    private void setItemScarcity() {
        // swords
        itemScarcity.put(Item.DARKNESS_SWORD, 0.05f);
        itemScarcity.put(Item.MAREETAS_SWORD, 0.05f);
        itemScarcity.put(Item.BRAVE_SWORD, 0.1f);
        itemScarcity.put(Item.LIGHT_SWORD, 0.1f);
        itemScarcity.put(Item.EARTH_SWORD, 0.1f);
        itemScarcity.put(Item.BEOSWORD, 0.1f);
        itemScarcity.put(Item.HOLY_SWORD, 0.f);
        itemScarcity.put(Item.BLAGI_SWORD, 0.1f);
        itemScarcity.put(Item.ELITE_SWORD, 0.2f);
        itemScarcity.put(Item.KING_SWORD, 0.2f);
        itemScarcity.put(Item.SLEEP_SWORD, 0.2f);
        itemScarcity.put(Item.BERSERK_SWORD, 0.2f);
        // lances
        itemScarcity.put(Item.DRAGON_LANCE, 0.1f);
        itemScarcity.put(Item.BRAVE_LANCE, 0.1f);
        // axes
        itemScarcity.put(Item.PUGI, 0.25f);
        itemScarcity.put(Item.BRAVE_AXE, 0.1f);
        // bows
        itemScarcity.put(Item.BRAVE_BOW, 0.1f);
        // magic
        itemScarcity.put(Item.DAIM_THUNDER, 0.1f);
        itemScarcity.put(Item.GRAFCALIBUR, 0.1f);
        itemScarcity.put(Item.BLIZZARD, 0.1f);
        itemScarcity.put(Item.METEOR, 0.2f);
        itemScarcity.put(Item.FENRIR, 0.2f);
        itemScarcity.put(Item.POISON, 0.2f);
        itemScarcity.put(Item.HELL, 0.2f);
        // staves
        itemScarcity.put(Item.THIEF_STAFF, 0.1f);
        itemScarcity.put(Item.UNLOCK, 0.1f);
        itemScarcity.put(Item.SLEEP, 0.05f);
        itemScarcity.put(Item.BERSERK, 0.1f);
    }
    
    public void reset() {
        rewardFreq.clear();
        playerClassFreq.clear();
        playerWpnFreq.clear();
        dancerAssigned = false;
        populateUniqueRewards();
    }
    
    private void populateUniqueRewards() {
        uniqueRewards.clear();
        uniqueRewards.addAll(Item.getScrolls());
        
        // inventory scrolls
        // Hezul scroll Enemy lifis Ch2x
        // Sety scroll Sety Ch4x
        // Dain scroll Dean Ch14
        // Blaggi scroll Sleuf Ch16A / Enemy Amalda Ch17B
        // Tordo scroll Enemy Barat Ch20
        uniqueRewards.remove(Item.HEZUL_SCROLL);
        uniqueRewards.remove(Item.SETY_SCROLL);
        uniqueRewards.remove(Item.DAIN_SCROLL);
        uniqueRewards.remove(Item.BLAGI_SCROLL);
        uniqueRewards.remove(Item.TORDO_SCROLL);
    }
}
