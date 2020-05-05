package org.hexrobot.fe5randomizer;

import java.util.zip.CRC32;

import org.hexrobot.fe5randomizer.characters.Character;
import org.hexrobot.fe5randomizer.items.Item;

public class Rom {
    private static final long FE5_HEADERED_CRC32_CHK = 2514651613L;
    private static final long FE5_UNHEADERED_CRC32_CHK = 4233206098L;
    private static final int MIN_FILE_SIZE = 4194304;
    private static final int HEADER_SIZE = 0x200;
    private static final int GAME_TITLE_OFFSET = 0x81C0;
    private static final int ITEMS_OFFSET = 0x1802C2;
    private static final int CHARACTERS_OFFSET = 0x31C2D;
    private byte[] bytes;
    private String name = "Fire Emblem 5 (Unknown)";
    private boolean headered;
    private boolean validFileSize;
    private long crc32Checksum;
    private boolean fireEmblem5;

    public Rom(byte[] bytes) {
        this.bytes = bytes;

        headered = bytes.length % 1024 == 512;
        validFileSize = bytes.length % 1024 == 0 && bytes.length >= MIN_FILE_SIZE;

        CRC32 crc32 = new CRC32();
        crc32.update(bytes);
        crc32Checksum = crc32.getValue();

        if(crc32Checksum == FE5_HEADERED_CRC32_CHK || crc32Checksum == FE5_UNHEADERED_CRC32_CHK) {
            name = "Fire Emblem 5";
            fireEmblem5 = true;
        }

        if(!fireEmblem5) {
            String gameTitle = "";
            for(int i = 0; i < 11; i++) {
                char currentChar = (char) getValueAt(GAME_TITLE_OFFSET + i);
                gameTitle += currentChar;
            }
                        
            fireEmblem5 = gameTitle.equalsIgnoreCase("FIREEMBLEM5");
        }
    }

    public int getValueAt(int offset) {
        if(!headered) {
            offset -= HEADER_SIZE;
        }

        return bytes[offset] & 0xFF;
    }

    public int getValueAt(int offset, int length) {
        if(Math.abs(length) != 2) {
            throw new IllegalArgumentException("Only retrieving 2 bytes are supported.");
        }

        if(!headered) {
            offset -= HEADER_SIZE;
        }

        int value = 0;

        if(length == 2) {
            value = (bytes[offset] & 0xFF) << 8 | (bytes[offset + 1] & 0xFF);
        } else if(length == -2) {
            value = (bytes[offset + 1] & 0xFF) << 8 | (bytes[offset] & 0xFF);
        }

        return value;
    }

    public boolean isHeadered() {
        return headered;
    }

    public String getName() {
        return name;
    }

    public boolean isFireEmblem5() {
        return fireEmblem5;
    }

    public long getCrc32Checksum() {
        return crc32Checksum;
    }
    
    public int getSize() {
        return bytes.length;
    }

    public void initializeItems() {
        for(Item item : Item.values()) {
            item.readItem(this, ITEMS_OFFSET);
        }
    }

    public void initializeCharacters() {
        for(Character character : Character.values()) {
            character.readCharacter(this, CHARACTERS_OFFSET);
        }
    }

    @Override
    public String toString() {
        String text = String.format(
                "[ROM] Name: %s, FE5: %b, Header: %b, CRC32Chk: %d, File Size: %d bytes, Valid file size: %b", name,
                fireEmblem5, headered, crc32Checksum, bytes.length, validFileSize);

        return text;
    }
}
