package org.hexrobot.fe5randomizer;

public enum CharacterSkill3 {
    NONE(0x00, "None"),
    WRATH(0x01, "Wrath"),
    METEOR_SWORD(0x02, "Meteor Sword"),
    MOONLIGHT_SWORD(0x04, "Moonlight Sword"),
    SUNLIGHT_SWORD(0x08, "Sunlight Sword"),
    ELITE(0x10, "Elite");
    
    private int offset;
    private String name;
    
    private CharacterSkill3(int offset, String name) {
        this.offset = offset;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public static CharacterSkill3 findById(int offset) {
        CharacterSkill3 characterSkill3 = null;
        
        for(CharacterSkill3 charSkill : CharacterSkill3.values()) {
            if(charSkill.offset == offset) {
                characterSkill3 = charSkill;
                break;
            }
        }
        
        if(characterSkill3 == null) {
            System.out.println(String.format("WARNING: Offset 0x%02X in CharacterSkill3 was not found.", offset));
            characterSkill3 = CharacterSkill3.NONE;
        }
        
        return characterSkill3;
    }
}
