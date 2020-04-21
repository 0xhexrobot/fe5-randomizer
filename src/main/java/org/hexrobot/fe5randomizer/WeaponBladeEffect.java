package org.hexrobot.fe5randomizer;

public enum WeaponBladeEffect {
	NOTHING(0x00, "Nothing"),
	POISON(0x02, "Poison"),
	DEVIL(0x04, "Devil"),
	STEAL_HP(0x06, "Steal HP"),
	STONE(0x08, "Stone"),
	HELL(0x0A, "Hell"),
	BERSERK(0x0C, "Berserk"),
	SLEEP(0x0E, "Sleep");
	
	private int offset;
	private String name;
	
	private WeaponBladeEffect(int offset, String name) {
		this.offset = offset;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static WeaponBladeEffect findById(int offset) {
		WeaponBladeEffect weaponBladeEffect = null;
		
		for(WeaponBladeEffect wpnBladeEff : WeaponBladeEffect.values()) {
			if(wpnBladeEff.offset == offset) {
				weaponBladeEffect = wpnBladeEff;
				break;
			}
		}
		
		if(weaponBladeEffect == null) {
			System.out.println(String.format("WARNING: Offset 0x%02X in WeaponBladeEffect was not found.", offset));
			weaponBladeEffect = WeaponBladeEffect.NOTHING;
		}
		
		return weaponBladeEffect;
	}
}
