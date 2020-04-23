package org.hexrobot.fe5randomizer.items;

public enum WeaponSkill1 {
	NOTHING(0x00, "Nothing"),
	CHARISMA(0x02, "Charisma"),
	PRAYER(0x08, "Prayer"),
	WRATH(0x10, "Wrath"),
	AWARENESS(0x80, "Awareness"),
	GUNGNIR(0x90, "Gungnir?"), //TODO find Gungnir
	GAE_BOLG(0x92, "Gae Bolg?"); //TODO find Gae Bolg

	private int offset;
	private String name;
	
	private WeaponSkill1(int offset, String name) {
		this.offset = offset;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static WeaponSkill1 findById(int offset) {
		WeaponSkill1 weaponSkill1 = null;
		
		for(WeaponSkill1 wpnSkill : WeaponSkill1.values()) {
			if(wpnSkill.offset == offset) {
				weaponSkill1 = wpnSkill;
				break;
			}
		}
		
		if(weaponSkill1 == null) {
			System.out.println(String.format("WARNING: Offset 0x%02X in WeaponSkill1 was not found.", offset));
			weaponSkill1 = WeaponSkill1.NOTHING;
		}
		
		return weaponSkill1;
	}
}
