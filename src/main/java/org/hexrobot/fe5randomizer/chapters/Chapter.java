package org.hexrobot.fe5randomizer.chapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum Chapter {
    CHAPTER_1("Chapter 1", 23, 21),
    CHAPTER_2("Chapter 2", 24, 32),
    CHAPTER_2X("Chapter 2x", 32, 32),
    CHAPTER_3("Chapter 3", 25, 32),
    CHAPTER_4("Chapter 4", 24, 30),
    CHAPTER_4X("Chapter 4x", 16, 24),
    CHAPTER_5("Chapter 5", 30, 32),
    CHAPTER_6("Chapter 6", 32, 32),
    CHAPTER_7("Chapter 7", 16, 52),
    CHAPTER_8("Chapter 8", 32, 22),
    CHAPTER_8X("Chapter 8x", 22, 23),
    CHAPTER_9("Chapter 9", 32, 32),
    CHAPTER_10("Chapter 10", 32, 22),
    CHAPTER_11("Chapter 11", 16, 32),
    CHAPTER_11X("Chapter 11x", 16, 25),
    CHAPTER_12("Chapter 12", 32, 20),
    CHAPTER_12X("Chapter 12x", 25, 16),
    CHAPTER_13("Chapter 13", 40, 24),
    CHAPTER_14("Chapter 14", 32, 26),
    CHAPTER_14X("Chapter 14x", 16, 32),
    CHAPTER_15("Chapter 15", 32, 28),
    CHAPTER_16A("Chapter 16A", 60, 22),
    CHAPTER_16B("Chapter 16B", 20, 20),
    CHAPTER_17A("Chapter 17A", 32, 28),
    CHAPTER_17B("Chapter 17B", 28, 32),
    CHAPTER_18("Chapter 18", 44, 22),
    CHAPTER_19("Chapter 19", 24, 64),
    CHAPTER_20("Chapter 20", 32, 32),
    CHAPTER_21("Chapter 21", 32, 32),
    CHAPTER_21X("Chapter 21x", 30, 30),
    CHAPTER_22("Chapter 22", 32, 30),
    CHAPTER_23("Chapter 23", 32, 30),
    CHAPTER_24("Chapter 24", 24, 44),
    CHAPTER_24X("Chapter 24x", 26, 40),
    CHAPTER_25("Chapter 25", 32, 32);
    
    private String name;
    private int width;
    private int height;
    private String shortName;
    private static Map<String, ArrayList<ArmyUnit>> armyData = new HashMap<>();
    
    private Chapter(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
        shortName = "Ch" + name.split(" ")[1];
    }
    
    public String getName() {
        return name;
    }
    
    public String getShortName() {
        return shortName;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
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
