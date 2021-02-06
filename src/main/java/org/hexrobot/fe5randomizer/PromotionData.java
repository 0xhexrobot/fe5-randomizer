package org.hexrobot.fe5randomizer;

import java.util.HashMap;
import java.util.Map;

import org.hexrobot.fe5randomizer.characters.CharacterClass;
import org.hexrobot.fe5randomizer.characters.GameCharacter;

public class PromotionData {
    private static final int ENTRY_COUNT = 33;
    private static final int ENTRY_SIZE = 3;
    private static final int LEAF_PROMOTION_OFFSET = 0x338AE5 + 0x200; // Original: 0x2A
    private static final int LINOAN_PROMOTION_OFFSET = 0x3EE78A + 0x200; // Original: 0x67
    private Map<GameCharacter, CharacterClass> promotionsTable = new HashMap<>();
    private Map<GameCharacter, CharacterClass> oldValues = new HashMap<>();
    
    PromotionData(Rom rom, int startingOffset) {
        for(int i = 0; i < ENTRY_COUNT; i++) {
            int characterOffset = startingOffset + i * ENTRY_SIZE;
            int promotionOffset = characterOffset + 2;
            
            GameCharacter character = GameCharacter.findById(rom.getValueAt(characterOffset));
            CharacterClass promotion = CharacterClass.findById(rom.getValueAt(promotionOffset));
            
            promotionsTable.put(character, promotion);
        }
    }
    
    public void updatePromotions() {
        for(Map.Entry<GameCharacter, CharacterClass> entry : promotionsTable.entrySet()) {
            GameCharacter character = entry.getKey();
            
            if(character.getOldValues().containsKey("characterClass")) {
                CharacterClass charClass = character.getCharacterClass();
                CharacterClass promotedClass = charClass.getPromotion();
                
                oldValues.put(character, promotionsTable.get(character));
                
                if(promotedClass == null) {
                    promotionsTable.put(character, charClass);
                } else {
                    promotionsTable.put(character, promotedClass);
                }
            }
        }
    }
    
    public void writePromotions(Rom rom, int startingOffset) {
        for(int i = 0; i < ENTRY_COUNT; i++) {
            int characterOffset = startingOffset + i * ENTRY_SIZE;
            GameCharacter character = GameCharacter.findById(rom.getValueAt(characterOffset));
            
            if(promotionsTable.containsKey(character)) {
                CharacterClass newPromotion = promotionsTable.get(character);
                
                rom.setValueAt(characterOffset + 2, newPromotion.getOffset());
            } else {
                throw new IllegalArgumentException("Character " + characterOffset + " is not contained in promotions table!");
            }
        }
        
        // event promotions
        CharacterClass leafNewPromotion = GameCharacter.LEAF.getCharacterClass().getPromotion();
        rom.setValueAt(LEAF_PROMOTION_OFFSET, leafNewPromotion.getOffset());
        
        CharacterClass linoanNewPromotion = GameCharacter.LINONAN.getCharacterClass().getPromotion();
        rom.setValueAt(LINOAN_PROMOTION_OFFSET, linoanNewPromotion.getOffset());
    }
    
    public void reset() {
        for(Map.Entry<GameCharacter, CharacterClass> entry : oldValues.entrySet()) {
            GameCharacter character = entry.getKey();
            CharacterClass promotion = entry.getValue();
            
            promotionsTable.put(character, promotion);
        }
        
        oldValues.clear();
    }
    
    @Override
    public String toString() {
        String text = "[PromotionData]\n";
        
        for (Map.Entry<GameCharacter, CharacterClass> entry : promotionsTable.entrySet()) {
            GameCharacter character = entry.getKey();
            CharacterClass promotion = entry.getValue();
            
            text += String.format("%s(0x%02X), %s(0x%02X) -> %s(0x%02X)\n", character.getName(), character.getOffset(),
                    character.getCharacterClass().getName(), character.getCharacterClass().getOffset(),
                    promotion.getName(), promotion.getOffset());
        }
        
        return text;
    }
}
