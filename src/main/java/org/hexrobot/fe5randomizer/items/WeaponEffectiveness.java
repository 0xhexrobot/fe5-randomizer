package org.hexrobot.fe5randomizer.items;

public enum WeaponEffectiveness {
	NONE(0x80AA, "None"),
	ARMORS(0x807A, "Armors"),
	DRAGONS(0x8082, "Dragons"),
	FLYING(0x8086, "Flying"),
	ARMORS_KNIGHTS(0x808F, "Armor/Knights"),
	KNIGHTS(0x8096, "Knights");
	
	private int offset;
	private String name;
	
	private WeaponEffectiveness(int offset, String name) {
		this.offset = offset;
		this.name = name;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public String getName() {
		return name;
	}
	
	public static WeaponEffectiveness findById(int offset) {
		WeaponEffectiveness wpnEffectiveness = null;
		
		for(WeaponEffectiveness wpnRank : WeaponEffectiveness.values()) {
			if(wpnRank.offset == offset) {
				wpnEffectiveness = wpnRank;
				break;
			}
		}
		
		if(wpnEffectiveness == null) {
			System.out.println(String.format("WARNING: Offset 0x%04X in WeaponEffectiveness was not found.", offset));
			wpnEffectiveness = WeaponEffectiveness.NONE;
		}
		
		return wpnEffectiveness;
	}
}
