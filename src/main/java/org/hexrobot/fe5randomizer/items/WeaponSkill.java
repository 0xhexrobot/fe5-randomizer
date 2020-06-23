package org.hexrobot.fe5randomizer.items;

import java.util.ArrayList;
import java.util.List;

public enum WeaponSkill {
    NOTHING(0x00, "Nothing"),
    // skills1
    CHARISMA(0x02, "Charisma"),
    PRAYER(0x08, "Prayer"),
    AMBUSH(0x10, "Ambush"),
    AWARENESS(0x80, "Awareness"),
    // skills 2
    WRATH(0x01, "Wrath"),
    ELITE(0x10, "Elite"),
    SCROLL(0x20, "Scroll"),
    DOUBLE_ATTACK(0x40, "2x Attack");

    private int offset;
    private String name;
    private static final ArrayList<WeaponSkill> SKILLS1 = new ArrayList<WeaponSkill>(
            List.of(CHARISMA, PRAYER, AMBUSH, AWARENESS));
    private static final ArrayList<WeaponSkill> SKILLS2 = new ArrayList<WeaponSkill>(
            List.of(WRATH, ELITE, SCROLL, DOUBLE_ATTACK));
    private static final ArrayList<WeaponSkill> RANDOMIZABLE_SKILLS = new ArrayList<WeaponSkill>(
            List.of(CHARISMA, PRAYER, WRATH, AWARENESS, AMBUSH, ELITE, DOUBLE_ATTACK));
    
    private WeaponSkill(int offset, String name) {
        this.offset = offset;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public static ArrayList<WeaponSkill> getSkills(int skills1, int skills2) {
        ArrayList<WeaponSkill> skills = new ArrayList<WeaponSkill>();
        
        if(skills1 > 0) {
            for(int i = 0; i < WeaponSkill.SKILLS1.size(); i++) {
                WeaponSkill skill = WeaponSkill.SKILLS1.get(i);
                
                if((skills1 & skill.offset) == skill.offset) {
                    skills.add(skill);
                }
            }
        }
        
        if(skills2 > 0) {
            for(int i = 0; i < WeaponSkill.SKILLS2.size(); i++) {
                WeaponSkill skill = WeaponSkill.SKILLS2.get(i);
                
                if((skills2 & skill.offset) == skill.offset) {
                    skills.add(skill);
                }
            }
        }
                
        return skills;
    }
    
    public static int[] getSkills(ArrayList<WeaponSkill> list) {
        int[] skills = new int[2];
        
        for(WeaponSkill skill : list) {
            if(SKILLS1.contains(skill)) {
                skills[0] |= skill.offset;
            } else if(SKILLS2.contains(skill)) {
                skills[1] |= skill.offset;
            }
        }
        
        return skills;
    }
    
    public static ArrayList<WeaponSkill> getRandomizableSkills() {
        return new ArrayList<WeaponSkill>(RANDOMIZABLE_SKILLS);
    }
    
    public boolean isRandomizableSkill() {
        return RANDOMIZABLE_SKILLS.contains(this);
    }
}
