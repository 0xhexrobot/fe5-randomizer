package org.hexrobot.fe5randomizer.characters;

public enum MovementStars implements Cloneable {
    MOV_STARS_0(0x00, 0),
    MOV_STARS_1(0x05, 1),
    MOV_STARS_2(0x0A, 2),
    MOV_STARS_3(0x0F, 3),
    MOV_STARS_4(0x14, 4),
    MOV_STARS_5(0x19, 5),
    MOV_STARS_6(0x1E, 6),
    MOV_STARS_7(0x23, 7),
    MOV_STARS_8(0x28, 8),
    MOV_STARS_9(0x2D, 9),
    MOV_STARS_10(0x32, 10);
    
    private int offset;
    private int ammount;
    
    private MovementStars(int offset, int ammount) {
        this.offset = offset;
    }
    
    public int getAmmount() {
        return ammount;
    }
    
    public static MovementStars findById(int offset) {
        MovementStars movementStars = null;
        
        for(MovementStars movStars : MovementStars.values()) {
            if(movStars.offset == offset) {
                movementStars = movStars;
                break;
            }
        }
        
        if(movementStars == null) {
            System.out.println(String.format("WARNING: Offset 0x%02X in MovementStars was not found.", offset));
            movementStars = MovementStars.MOV_STARS_0;
        }
        
        return movementStars;
    }
}
