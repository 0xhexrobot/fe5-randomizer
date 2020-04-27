package org.hexrobot.fe5randomizer.characters;

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
    
    public static Gender findById(int offset) {
        Gender gender = null;
        
        for(Gender g : Gender.values()) {
            if(g.offset == offset) {
                gender = g;
                break;
            }
        }
        
        if(gender == null) {
            System.out.println(String.format("WARNING: Offset 0x%02X in Gender was not found.", offset));
            gender = Gender.MALE;
        }
        
        return gender;
    }
}
