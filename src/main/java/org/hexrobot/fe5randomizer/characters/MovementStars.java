package org.hexrobot.fe5randomizer.characters;

import org.hexrobot.fe5randomizer.util.InvalidRomDataException;

public enum MovementStars {
    MOV_STARS_0(0x00),
    MOV_STARS_1(0x05),
    MOV_STARS_2(0x0A),
    MOV_STARS_3(0x0F),
    MOV_STARS_4(0x14),
    MOV_STARS_5(0x19),
    MOV_STARS_6(0x1E),
    MOV_STARS_7(0x23),
    MOV_STARS_8(0x28),
    MOV_STARS_9(0x2D),
    MOV_STARS_10(0x32);
    
    private int offset;
    private int amount;
    
    private MovementStars(int offset) {
        this.offset = offset;
        amount = offset / 5;
    }
    
    public int getOffset() {
        return offset;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public static MovementStars findById(int offset) throws InvalidRomDataException {
        MovementStars movementStars = null;
        
        for(MovementStars movStars : MovementStars.values()) {
            if(movStars.offset == offset) {
                movementStars = movStars;
                break;
            }
        }
        
        if(movementStars == null) {
            throw new InvalidRomDataException(String.format("Offset 0x%02X in MovementStars was not found.", offset));
        }
        
        return movementStars;
    }
    
    public static MovementStars findByAmount(int amount) throws InvalidRomDataException {
        return MovementStars.findById(amount * 5);
    }
}
