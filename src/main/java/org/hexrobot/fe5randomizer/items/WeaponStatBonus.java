package org.hexrobot.fe5randomizer.items;

public enum WeaponStatBonus {
	NONE(0x8000, "None"),
	PLUS_10MGC(0x800A, "+10 Mag"),
	PLUS_10LUK(0x8012, "+10 Lck"),
	PLUS_5SPD(0x801A, "+5 Spd"),
	PLUS_5MGC(0x8022, "+ 5 Mag"),
	PLUS_5SKL(0x802A, "+5 Skl"),
	PLUS_5DEF(0x8032, "+5 Def"),
	PLUS_20MGC(0x803A, "+20 Mag"),
	PLUS_10LUK2(0x8042, "+10 Lck"),
	PLUS_20SKL_20SPD(0x804A, "+20Skl +20Spd"),
	NONE2(0x8052, "None"),
	PLUS_10DEF(0x806A, "+10 Def"),
	PLUS_10STR(0x8072, "+10 Str");

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
