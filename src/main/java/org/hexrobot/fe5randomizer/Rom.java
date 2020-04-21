package org.hexrobot.fe5randomizer;

import java.util.zip.CRC32;

public class Rom {
	private byte[] bytes;
	private boolean headered;
	
	public Rom(byte[] bytes) {
		this.bytes = bytes;
		headered = bytes.length % 1024 == 512;
	}
	
	public boolean isHeadered() {
		return headered;
	}
	
	public int getValueAt(int offset) {
		return bytes[offset] & 0xFF;
	}
	
	public int getValueAt(int offset, int length) {
		if(Math.abs(length) != 2) {
			throw new IllegalArgumentException("Only retrieving 2 bytes are supported.");
		}
		
		int value = 0;
		
		if(length == 2) {
			value = (bytes[offset] & 0xFF) << 8 | (bytes[offset + 1] & 0xFF);
		} else if(length == -2) {
			value = (bytes[offset + 1] & 0xFF) << 8 | (bytes[offset] & 0xFF);
		}
		
		return value;
	}
	
	public RomValidity getRomValidity() {
		RomValidity romValidity = RomValidity.ERROR;
		CRC32 crc32 = new CRC32();
		crc32.update(bytes);
		Long fileCrc32Checksum = crc32.getValue();

		System.out.println("Length: " + bytes.length + " bytes");
		System.out.println("CRC32 checksum: " + fileCrc32Checksum);

		if(fileCrc32Checksum.equals(Constants.FE5_HEADERED_CRC32_CHK)) {
			System.out.println("Fire Emblem 5 headered");
			romValidity = RomValidity.FE5_HEADERED;
		} else if(fileCrc32Checksum.equals(Constants.FE5_UNHEADERED_CRC32_CHK)) {
			System.out.println("Fire Emblem 5 unheadered");
			romValidity = RomValidity.FE5_UNHEADERED;
		}
		
		return romValidity;
	}
}
