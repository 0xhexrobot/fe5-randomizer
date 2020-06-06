package org.hexrobot.fe5randomizer.characters;

import java.util.ArrayList;
import java.util.List;

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
    private static final ArrayList<Skill> SKILLS1 = new ArrayList<Skill>(
            List.of(DANCE, STEAL, BARGAIN, LIFE, MOUNT_DISMOUNT, MOUNTED_MOV, UNKNOWN_1A, UNKNOWN_1B));
    private static final ArrayList<Skill> SKILLS2 = new ArrayList<Skill>(
            List.of(CONTINUE, CHARISMA, PRAYER, AMBUSH, DUEL, BIG_SHIELD, AWARENESS, UNKNOWN2));
    private static final ArrayList<Skill> SKILLS3 = new ArrayList<Skill>(
            List.of(WRATH, METEOR_SWORD, MOONLIGHT_SWORD, SUNLIGHT_SWORD, ELITE, UNKNOWN_3A, UNKNOWN_3B, UNKNOWN_3C));
    private static final ArrayList<Skill> RANDOMIZABLE_SKILLS = new ArrayList<Skill>(
            List.of(BARGAIN, LIFE, CONTINUE, CHARISMA, PRAYER, AMBUSH, DUEL, BIG_SHIELD, AWARENESS, WRATH, METEOR_SWORD,
                    MOONLIGHT_SWORD, SUNLIGHT_SWORD, ELITE));
    
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
            for(int i = 0; i < Skill.SKILLS1.size(); i++) {
                Skill skill = Skill.SKILLS1.get(i);
                
                if((skills1 & skill.offset) == skill.offset) {
                    skills.add(skill);
                }
            }
        }
        
        if(skills2 > 0) {
            for(int i = 0; i < Skill.SKILLS2.size(); i++) {
                Skill skill = Skill.SKILLS2.get(i);
                
                if((skills2 & skill.offset) == skill.offset) {
                    skills.add(skill);
                }
            }
        }
        
        if(skills3 > 0) {
            for(int i = 0; i < Skill.SKILLS3.size(); i++) {
                Skill skill = Skill.SKILLS3.get(i);
                
                if((skills3 & skill.offset) == skill.offset) {
                    skills.add(skill);
                }
            }
        }
        
        return skills;
    }
    
    public static int[] getSkills(ArrayList<Skill> list) {
        int[] skills = new int[3];
        
        for(Skill skill : list) {
            if(SKILLS1.contains(skill)) {
                skills[0] |= skill.offset;
            } else if(SKILLS2.contains(skill)) {
                skills[1] |= skill.offset;
            } else if(SKILLS3.contains(skill)) {
                skills[2] |= skill.offset;
            }
        }
        
        return skills;
    }
    
    public static ArrayList<Skill> getRandomizableSkills() {
        return new ArrayList<Skill>(RANDOMIZABLE_SKILLS);
    }
    
    public boolean isRandomizableSkill() {
        return RANDOMIZABLE_SKILLS.contains(this);
    }
}
