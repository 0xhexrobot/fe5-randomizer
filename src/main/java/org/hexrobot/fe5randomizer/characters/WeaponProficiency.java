package org.hexrobot.fe5randomizer.characters;

public class WeaponProficiency {
    private int proficiency = 0;
    
    public void setAmount(int proficiency) {
        this.proficiency = proficiency;
    }
    
    public int getAmount() {
        return proficiency;
    }
    
    public String getName() {
        String name;
        
        if(proficiency > 249) {
            name = "+5 Rank";
        } else if(proficiency > 199) {
            name = "+4 Rank";
        } else if(proficiency > 149) {
            name = "+3 Rank";
        } else if(proficiency > 99) {
            name = "+2 Rank";
        } else if(proficiency > 49) {
            name = "+1 Rank";
        } else {
            name = "+0 Rank";
        }
        
        return name;
    }
}
