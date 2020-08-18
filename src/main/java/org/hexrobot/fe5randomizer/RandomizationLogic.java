package org.hexrobot.fe5randomizer;

import java.util.List;

import org.hexrobot.fe5randomizer.chapters.ArmyUnit;
import org.hexrobot.fe5randomizer.characters.CharacterClass;
import org.hexrobot.fe5randomizer.characters.GameCharacter;
import org.hexrobot.fe5randomizer.characters.Gender;
import org.hexrobot.fe5randomizer.items.Item;

public class RandomizationLogic {
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
}
