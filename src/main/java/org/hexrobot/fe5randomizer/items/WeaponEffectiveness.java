package org.hexrobot.fe5randomizer.items;

public enum WeaponEffectiveness {
	NONE(0xAA80, "None"),
	ARMORS(0x7A80, "Armors"),
	DRAGONS(0x8280, "Dragons"),
	FLYING(0x8680, "Flying"),
	ARMORS_KNIGHTS(0x8F80, "Armor/Knights"),
	KNIGHTS(0x9680, "Knights");
	
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
