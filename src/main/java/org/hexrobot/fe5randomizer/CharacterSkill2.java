package org.hexrobot.fe5randomizer;

public enum CharacterSkill2 {
    NONE(0x00, "None"),
    CONTINUE(0x01, "Continue"),
    CHARISMA(0x02, "Charisma"),
    PRAYER(0x08, "Prayer"),
    AMBUSH(0x10, "Ambush"),
    DUEL(0x20, "Duel"),
    BIG_SHIELD(0x40, "Big Shield"),
    AWARENESS(0x80, "Awareness");

    private int offset;
    private String name;
    
    private CharacterSkill2(int offset, String name) {
        this.offset = offset;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public static CharacterSkill2 findById(int offset) {
        CharacterSkill2 characterSkill2 = null;
        
        for(CharacterSkill2 charSkill : CharacterSkill2.values()) {
            if(charSkill.offset == offset) {
                characterSkill2 = charSkill;
                break;
            }
        }
        
        if(characterSkill2 == null) {
            System.out.println(String.format("WARNING: Offset 0x%02X in CharacterSkill2 was not found.", offset));
            characterSkill2 = CharacterSkill2.NONE;
        }
        
        return characterSkill2;
    }
}
