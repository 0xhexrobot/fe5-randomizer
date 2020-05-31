package org.hexrobot.fe5randomizer;

import org.hexrobot.fe5randomizer.characters.CharacterClass;
import org.hexrobot.fe5randomizer.characters.GameCharacter;
import org.hexrobot.fe5randomizer.characters.Gender;
import org.hexrobot.fe5randomizer.items.Item;

public class RandomizationLogic {
    public float assignItemWeight(ArmyUnit unit, Item item) {
        float value = 0;

        if(unit.canUseWeapon(item)) {
            value = 1.0f;
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
