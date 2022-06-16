package org.hexrobot.fe5randomizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hexrobot.fe5randomizer.chapters.ArmyUnit;
import org.hexrobot.fe5randomizer.characters.CharacterClass;
import org.hexrobot.fe5randomizer.characters.GameCharacter;
import org.hexrobot.fe5randomizer.characters.Gender;
import org.hexrobot.fe5randomizer.items.Item;

public class RandomizationLogic {
    private Map<GameCharacter, List<CharacterClass>> bannedClasses = new HashMap<>();
    private Map<GameCharacter, List<CharacterClass>> limitedClassPool = new HashMap<>();
    private List<Item> uniqueRewards = new ArrayList<>();
    
    public RandomizationLogic(RandomizationSummary summary) {
        List<CharacterClass> mountedClasses = CharacterClass.getMountedClasses();
        List<CharacterClass> flyingClasses = CharacterClass.getFlyingClasses();
        List<CharacterClass> canTraverseWaterClasses = CharacterClass.getCanTraverseWaterClasses();
        
        // exclude these classes for these characters
        bannedClasses.put(GameCharacter.GALZUS, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_SOLDIER, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_ARCHER, mountedClasses);
        bannedClasses.put(GameCharacter.MERCENARY_SWORD_FIGHTER, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_THUNDER_MAGE, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_MAGE_F, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_BISHOP, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_AXE_ARMOR, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_SWORD_ARMOR, mountedClasses);
        bannedClasses.put(GameCharacter.ROBOS, mountedClasses);
        bannedClasses.put(GameCharacter.LEIDRICK_1, mountedClasses);
        bannedClasses.put(GameCharacter.LEIDRICK_2, mountedClasses);
        bannedClasses.put(GameCharacter.BANTOL_BOSS, mountedClasses);
        bannedClasses.put(GameCharacter.ROPUTO_DARK_MAGE, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_PRIEST, mountedClasses);
        bannedClasses.put(GameCharacter.MANSTER_SNIPER, mountedClasses);
        bannedClasses.put(GameCharacter.LOPTO_DARK_BISHOP, mountedClasses);
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
        bannedClasses.put(GameCharacter.BANDIT_MOUNTAIN_THIEF, mountedClasses);
        bannedClasses.put(GameCharacter.THIEF, mountedClasses);
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
        bannedClasses.put(GameCharacter.DREI_DAGUDAR, mountedClasses);
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
        
        if(!summary.getExcludeThieves()) {
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
        
        populateUniqueRewards();
    }
    
    public float assignItemWeight(ArmyUnit unit, Item item, List<Item> inventory) {
        if(unit.getCharacter().isPlayableUnit() && item.isEnemyOnly()) {
            return 0;
        }
        
        if(unit.getCharacter().isEnemyUnit() && item.isPlayerOnly()) {
            return 0;
        }
        
        float value = 0;
        
        if(unit.canUseWeapon(item)) {
            int countSameItems = 0;
            
            for(Item invItem : inventory) {
                if(invItem.equals(item)) {
                    countSameItems++;
                }
            }
            
            value = 1 / (float)(Math.pow(4, countSameItems));
        }
        
        return value;
    }

    public float assignClassWeight(GameCharacter character, CharacterClass characterClass) {
        if(bannedClasses.containsKey(character)) {
            List<CharacterClass> banned = bannedClasses.get(character);
            
            if(banned.contains(characterClass)) {
                return 0;
            }
        }
        
        if(limitedClassPool.containsKey(character)) {
            List<CharacterClass> limitedTo = limitedClassPool.get(character);
            
            if(!limitedTo.contains(characterClass)) {
                return 0;
            }
        }
        
        float value = 1.0f;
        
        if(character.getCharacterClass().equals(characterClass)) {
            value *= 0.25f;
        }

        if(character.getGender() == Gender.MALE) {
            if(characterClass.isFemaleClass()) {
                value = 0;
            }
        } else if(character.getGender() == Gender.FEMALE) {
            if(!characterClass.isFemaleClass()) {
                value = 0;
            }
        }

        return value;
    }
    
    public void reset() {
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
    
    public void shuffleRewards() {
        
    }
    
    public void randomizeRewards() {
        
    }
}
