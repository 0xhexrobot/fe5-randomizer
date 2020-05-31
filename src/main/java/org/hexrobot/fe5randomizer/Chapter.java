package org.hexrobot.fe5randomizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum Chapter {
    CHAPTER_1("Chapter 1"),
    CHAPTER_2("Chapter 2"),
    CHAPTER_2X("Chapter 2x"),
    CHAPTER_3("Chapter 3"),
    CHAPTER_4("Chapter 4"),
    CHAPTER_4X("Chapter 4x"),
    CHAPTER_5("Chapter 5"),
    CHAPTER_6("Chapter 6"),
    CHAPTER_7("Chapter 7"),
    CHAPTER_8("Chapter 8"),
    CHAPTER_8X("Chapter 8x"),
    CHAPTER_9("Chapter 9"),
    CHAPTER_10("Chapter 10"),
    CHAPTER_11("Chapter 11"),
    CHAPTER_11X("Chapter 11x"),
    CHAPTER_12("Chapter 12"),
    CHAPTER_12X("Chapter 12x"),
    CHAPTER_13("Chapter 13"),
    CHAPTER_14("Chapter 14"),
    CHAPTER_14X("Chapter 14x"),
    CHAPTER_15("Chapter 15"),
    CHAPTER_16A("Chapter 16A"),
    CHAPTER_16B("Chapter 16B"),
    CHAPTER_17A("Chapter 17A"),
    CHAPTER_17B("Chapter 17B"),
    CHAPTER_18("Chapter 18"),
    CHAPTER_19("Chapter 19"),
    CHAPTER_20("Chapter 20"),
    CHAPTER_21("Chapter 21"),
    CHAPTER_21X("Chapter 21x"),
    CHAPTER_22("Chapter 22"),
    CHAPTER_23("Chapter 23"),
    CHAPTER_24("Chapter 24"),
    CHAPTER_24X("Chapter 24x"),
    CHAPTER_25("Chapter 25");
    
    private String name;
    private String shortName;
    private static Map<String, ArrayList<ArmyUnit>> armyData = new HashMap<>();
    
    private Chapter(String name) {
        this.name = name;
        shortName = "Ch" + name.split(" ")[1];
    }
    
    public String getName() {
        return name;
    }
    
    public void addArmyData(ArrayList<ArmyUnit> armyData) {
        if(Chapter.armyData.containsKey(name)) {
            ArrayList<ArmyUnit> data = Chapter.armyData.get(name);
            data.addAll(armyData);
        } else {
            Chapter.armyData.put(name, armyData);
        }
    }
    
    public ArrayList<ArmyUnit> getArmyData() {
        if(armyData.containsKey(name)) {
            return armyData.get(name);
        } else {
            System.out.println("Warning: " + name + " is Empty!!");
            return new ArrayList<ArmyUnit>();
        }
    }
    
    public static Chapter findByShortName(String shortName) {
        Chapter chapter = null;

        for(Chapter currentChapter : Chapter.values()) {
            if(currentChapter.shortName.equals(shortName)) {
                chapter = currentChapter;
                break;
            }
        }

        if(chapter == null) {
            System.out.println(String.format("WARNING: shortName %s in Chapter was not found.", shortName));
            chapter = Chapter.CHAPTER_1;
        }

        return chapter;
    }
}
