package org.hexrobot.fe5randomizer.items;

import org.hexrobot.fe5randomizer.util.InvalidRomDataException;

public enum WeaponRange {
	R_1(0x11, "R 1"),
	R_1_2(0x21, "R 1-2"),
	R_2(0x22, "R 2"),
	R_3_10(0xA3, "R 3-10"),
	R_3_15(0xF3, "R 3-15"),
	R_Infinite(0xA1, "R INF");
	
	private int offset;
	private String name;
	
	private WeaponRange(int offset, String name) {
		this.offset = offset;
		this.name = name;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public String getName() {
		return name;
	}
	
	public static WeaponRange findById(int offset) throws InvalidRomDataException {
		WeaponRange weaponRange = null;
		
		for(WeaponRange wpnRange : WeaponRange.values()) {
			if(wpnRange.offset == offset) {
				weaponRange = wpnRange;
				break;
			}
		}
		
		if(weaponRange == null) {
			throw new InvalidRomDataException(String.format("Offset 0x%02X in WeaponRange was not found.%n", offset));
		}
		
		return weaponRange;
	}
}
