package org.hexrobot.fe5randomizer.characters;

import java.util.ArrayList;

public enum Skill {
    // skills1
    DANCE(0x01, "Dance"),
    STEAL(0x02, "Steal"),
    UNKNOWN_1A(0x04, "Unknown1"),
    BARGAIN(0x08, "Bargain"),
    LIFE(0x10, "Life"),
    MOUNT_DISMOUNT(0x20, "Mount/Dismount (Class skill)"),
    MOUNTED_MOV(0x40, "Mounted Mov/Outdoors Only (Class skill)"),
    UNKNOWN_1B(0x80, "Unknown1"),
    // skills2
    CONTINUE(0x01, "Continue"),
    CHARISMA(0x02, "Charisma"),
    UNKNOWN2(0x04, "Unknown2"),
    PRAYER(0x08, "Prayer"),
    AMBUSH(0x10, "Ambush"),
    DUEL(0x20, "Duel"),
    BIG_SHIELD(0x40, "Big Shield"),
    AWARENESS(0x80, "Awareness"),
    // skills3
    WRATH(0x01, "Wrath"),
    METEOR_SWORD(0x02, "Meteor Sword"),
    MOONLIGHT_SWORD(0x04, "Moonlight Sword"),
    SUNLIGHT_SWORD(0x08, "Sunlight Sword"),
    ELITE(0x10, "Elite"),
    UNKNOWN_3A(0x20, "Unknown3"),
    UNKNOWN_3B(0x40, "Unknown3"),
    UNKNOWN_3C(0x80, "Unknown3");

    private int offset;
    private String name;
    private static Skill[] skills1 = new Skill[] {DANCE, STEAL, BARGAIN, LIFE, MOUNT_DISMOUNT, MOUNTED_MOV, UNKNOWN_1A, UNKNOWN_1B};
    private static Skill[] skills2 = new Skill[] {CONTINUE, CHARISMA, PRAYER, AMBUSH, DUEL, BIG_SHIELD, AWARENESS, UNKNOWN2};
    private static Skill[] skills3 = new Skill[] {WRATH, METEOR_SWORD, MOONLIGHT_SWORD, SUNLIGHT_SWORD, ELITE, UNKNOWN_3A, UNKNOWN_3B, UNKNOWN_3C};
    
    private Skill(int offset, String name) {
        this.offset = offset;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public static ArrayList<Skill> getSkills(int skills1, int skills2, int skills3) {
        ArrayList<Skill> skills = new ArrayList<Skill>();
        
        if(skills1 > 0) {
            for(int i = 0; i < Skill.skills1.length; i++) {
                Skill skill = Skill.skills1[i];
                
                if((skills1 & skill.offset) == skill.offset) {
                    skills.add(skill);
                }
            }
        }
        
        if(skills2 > 0) {
            for(int i = 0; i < Skill.skills2.length; i++) {
                Skill skill = Skill.skills2[i];
                
                if((skills2 & skill.offset) == skill.offset) {
                    skills.add(skill);
                }
            }
        }
        
        if(skills3 > 0) {
            for(int i = 0; i < Skill.skills3.length; i++) {
                Skill skill = Skill.skills3[i];
                
                if((skills3 & skill.offset) == skill.offset) {
                    skills.add(skill);
                }
            }
        }
        
        return skills;
    }
}
