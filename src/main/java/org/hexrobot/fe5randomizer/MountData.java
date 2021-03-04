package org.hexrobot.fe5randomizer;

import java.util.HashMap;
import java.util.Map;

import org.hexrobot.fe5randomizer.characters.CharacterClass;

public class MountData {
    private static final int MOUNT_TABLE_OFFSET = 0x40000;
    private static final int MOUNT_TABLE_SIZE = 28;
    private static final int UNMOUNTED_OFFSET = 0;
    private static final int MOUNTED_OFFSET = 0x1C;
    
    private Map<CharacterClass, CharacterClass> mountTable = new HashMap<>();

    public MountData(Rom rom) {
        for(int i = 0; i < MOUNT_TABLE_SIZE; i++) {
            int unmountOffset = MOUNT_TABLE_OFFSET + UNMOUNTED_OFFSET + i;
            int mountOffset = MOUNT_TABLE_OFFSET + MOUNTED_OFFSET + i;
            
            CharacterClass unmountedClass = CharacterClass.findById(rom.getValueAt(unmountOffset));
            CharacterClass mountedClass = CharacterClass.findById(rom.getValueAt(mountOffset));
            
            mountTable.put(unmountedClass, mountedClass);
        }
    }
    
    public CharacterClass getComplement(CharacterClass characterClass) {
        CharacterClass complement = null;
        
        if(mountTable.containsKey(characterClass)) {
            complement = mountTable.get(characterClass);
        } else {
            for (Map.Entry<CharacterClass, CharacterClass> entry : mountTable.entrySet()) {
                if(entry.getValue().equals(characterClass)) {
                    complement = entry.getKey();
                    break;
                }
            }
        }
        
        return complement;
    }
    
    @Override
    public String toString() {
        String text = "[MountData]\n";
        
        for (Map.Entry<CharacterClass, CharacterClass> entry : mountTable.entrySet()) {
            CharacterClass mounted = entry.getKey();
            CharacterClass unmounted = entry.getValue();
            
            text += String.format("%s(0x%02X) <---> %s(0x%02X)\n",
                    mounted.getName(), mounted.getOffset(), unmounted.getName(), unmounted.getOffset());
        }
        
        return text;
    }
}
