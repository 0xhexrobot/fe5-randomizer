package org.hexrobot.fe5randomizer.characters;

import org.hexrobot.fe5randomizer.util.InvalidRomDataException;

public enum Gender {
    MALE(0x00, "Male"),
    FEMALE(0x01, "Female");
    
    private int offset;
    private String name;
    
    private Gender(int offset, String name) {
        this.offset = offset;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public static Gender findById(int offset) throws InvalidRomDataException {
        Gender gender = null;
        
        for(Gender g : Gender.values()) {
            if(g.offset == offset) {
                gender = g;
                break;
            }
        }
        
        if(gender == null) {
            throw new InvalidRomDataException(String.format(
                    "Offset 0x%02X in Gender was not found.", offset));
        }
        
        return gender;
    }
}
