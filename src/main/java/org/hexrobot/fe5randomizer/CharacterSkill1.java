package org.hexrobot.fe5randomizer;

public enum CharacterSkill1 {
    NONE(0x00, "None"),
    DANCE(0x01, "Dance"),
    STEAL(0x02, "Steal"),
    BARGAIN(0x08, "Bargain"),
    LIFE(0x10, "Life"),
    MOUNT_DISMOUNT(0x20, "Mount/Dismount(crash if not a knight)"),
    MOUNTED_MOV(0x40, "Mounted Movement/Outdoors Only");

    private int offset;
    private String name;
    
    private CharacterSkill1(int offset, String name) {
        this.offset = offset;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public static CharacterSkill1 findById(int offset) {
        CharacterSkill1 characterSkill1 = null;
        
        for(CharacterSkill1 charSkill : CharacterSkill1.values()) {
            if(charSkill.offset == offset) {
                characterSkill1 = charSkill;
                break;
            }
        }
        
        if(characterSkill1 == null) {
            System.out.println(String.format("WARNING: Offset 0x%02X in CharacterSkill1 was not found.", offset));
            characterSkill1 = CharacterSkill1.NONE;
        }
        
        return characterSkill1;
    }
}
