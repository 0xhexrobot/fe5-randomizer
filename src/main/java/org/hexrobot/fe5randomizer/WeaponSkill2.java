package org.hexrobot.fe5randomizer;

public enum WeaponSkill2 {
	NOTHING(0x00, "Nothing"),
	AMBUSH(0x01, "Ambush"),
	ELITE(0x10, "Elite"),
	SCROLL(0x20, "Scroll"),
	DOUBLE_ATTACK(0x40, "2x Attack"),
	GAE_BOLG(0x41, "Gae Bolg?"), //TODO find Gae Bolg
	GUNGNIR(0x51, "Gungnir?"); //TODO find Gungnir

	private int offset;
	private String name;
	
	private WeaponSkill2(int offset, String name) {
		this.offset = offset;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static WeaponSkill2 findById(int offset) {
		WeaponSkill2 weaponSkill2 = null;
		
		for(WeaponSkill2 wpnSkill : WeaponSkill2.values()) {
			if(wpnSkill.offset == offset) {
				weaponSkill2 = wpnSkill;
				break;
			}
		}
		
		if(weaponSkill2 == null) {
			System.out.println(String.format("WARNING: Offset 0x%02X in WeaponSkill2 was not found.", offset));
			weaponSkill2 = WeaponSkill2.NOTHING;
		}
		
		return weaponSkill2;
	}
}
