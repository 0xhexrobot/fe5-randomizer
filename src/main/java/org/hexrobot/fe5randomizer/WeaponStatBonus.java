package org.hexrobot.fe5randomizer;

public enum WeaponStatBonus {
	NONE(0x0080, "None"),
	PLUS_10MGC(0x0A80, "+10 Mag"),
	PLUS_10LUK(0x1280, "+10 Lck"),
	PLUS_5SPD(0x1A80, "+5 Spd"),
	PLUS_5MGC(0x2280, "+ 5 Mag"),
	PLUS_5SKL(0x2A80, "+5 Skl"),
	PLUS_5DEF(0x3280, "+5 Def"),
	PLUS_20MGC(0x3A80, "+20 Mag"),
	PLUS_10LUK2(0x4280, "+10 Lck"),
	PLUS_20SKL_20SPD(0x4A80, "+20Skl +20Spd"),
	NONE2(0x5280, "None"),
	PLUS_10DEF(0x6A80, "+10 Def"),
	PLUS_10STR(0x7280, "+10 Str");

	private int offset;
	private String name;
	
	private WeaponStatBonus(int offset, String name) {
		this.offset = offset;
		this.name = name;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public String getName() {
		return name;
	}
	
	public static WeaponStatBonus findById(int offset) {
		WeaponStatBonus weaponStatBonus = null;
		
		for(WeaponStatBonus wpnStatBonus : WeaponStatBonus.values()) {
			if(wpnStatBonus.offset == offset) {
				weaponStatBonus = wpnStatBonus;
				break;
			}
		}
		
		if(weaponStatBonus == null) {
			System.out.println(String.format("WARNING: Offset 0x%04X in WeaponStatBonus was not found.", offset));
			weaponStatBonus = WeaponStatBonus.NONE;
		}
		
		return weaponStatBonus;
	}
}
