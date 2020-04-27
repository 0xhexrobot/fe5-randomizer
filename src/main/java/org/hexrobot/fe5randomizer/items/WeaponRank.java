package org.hexrobot.fe5randomizer.items;

public enum WeaponRank {
	NOPE(0x0000, "-"),
	E(0x0032, "E"),
	D(0x0064, "D"),
	C(0x0096, "C"),
	B(0x00C8, "B"),
	A(0x00FA, "A"),
	NANNA(0x99DA, "Nanna"),
	ASVEL(0x99DE, "Asvel"),
	SARA(0x99EC, "Sara"),
	SETY(0x99F0, "Sety"),
	NANNA_DELMUD_FERGUS_LEAF(0x99FA, "Nanna/Delmud/Fergus/Leaf"),
	LEIDRICK_AINS(0x9A64, "Leidrick/Ains"),
	FERGUS_DELMUD(0x9A3A, "Fergus/Delmud"),
	OLWEN_REINHARDT(0x9A52, "Olwen/Reinhardt"),
	LEAF(0x9A00, "Leaf"),
	MAREETA(0x9A4E, "Mareeta"),
	ALTHENNA_DEAN(0x9A44, "Althenna/Dean"),
	FINN(0x9A40, "Finn"),
	OTHIN_BERSERKER(0x9A04, "Othin/Berserker"),
	MANSTER_FREEGE(0x9A0E, "Manster/Freege"),
	IRON_ARCH_FREEGE(0x9A22, "Iron Arch/Freege"),
	NOBODY(0x9A1A, "Nobody"),
	FREEGE_MANSTER(0x9A1C, "Freege/Manster"),
	NOBODY2(0x9A76, "Nobody"),
	ISHTAR(0x9A0A, "Ishtar"),
	ARAPHEN_LOPUTO_BELDO(0x9A6C, "Araphen/Loputo/Beldo"),
	NOBODY3(0x9A76, "Nobody"),
	NOBODY4(0x9A78, "Nobody"),
	SAPHY(0x9A36, "Saphy"),
	TINA_LOPUTO(0x9A28, "Tina/Loputo"),
	TINA_FREEGE_LOPUTO(0x9A2E, "Tina/Freege/Loputo");

	private int offset;
	private String name;
	
	private WeaponRank(int offset, String name) {
		this.offset = offset;
		this.name = name;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public String getName() {
		return name;
	}
	
	public static WeaponRank findById(int offset) {
		WeaponRank weaponRank = null;
		
		for(WeaponRank wpnRank : WeaponRank.values()) {
			if(wpnRank.offset == offset) {
				weaponRank = wpnRank;
				break;
			}
		}
		
		if(weaponRank == null) {
			System.out.println(String.format("WARNING: Offset 0x%04X in WeaponRank was not found.", offset));
			weaponRank = WeaponRank.NOPE;
		}
		
		return weaponRank;
	}
}
