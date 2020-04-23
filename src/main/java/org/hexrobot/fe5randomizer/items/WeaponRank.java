package org.hexrobot.fe5randomizer.items;

public enum WeaponRank {
	NOPE(0x0000, "-"),
	E(0x3200, "E"),
	D(0x6400, "D"),
	C(0x9600, "C"),
	B(0xC800, "B"),
	A(0xFA00, "A"),
	NANNA(0xDA99, "Nanna"),
	ASVEL(0xDE99, "Asvel"),
	SARA(0xEC99, "Sara"),
	SETY(0xF099, "Sety"),
	NANNA_DELMUD_FERGUS_LEAF(0xFA99, "Nanna/Delmud/Fergus/Leaf"),
	LEIDRICK_AINS(0x649A, "Leidrick/Ains"),
	FERGUS_DELMUD(0x3A9A, "Fergus/Delmud"),
	OLWEN_REINHARDT(0x529A, "Olwen/Reinhardt"),
	LEAF(0x009A, "Leaf"),
	MAREETA(0x4E9A, "Mareeta"),
	ALTHENNA_DEAN(0x449A, "Althenna/Dean"),
	FINN(0x409A, "Finn"),
	OTHIN_BERSERKER(0x049A, "Othin/(Berserker)"),
	MANSTER_FREEGE(0x0E9A, "Manster/Freege"),
	IRON_ARCH_FREEGE(0x229A, "(Iron Arch)/Freege"),
	NOBODY(0x1A9A, "Nobody"),
	FREEGE_MANSTER(0x1C9A, "Freege/Manster"),
	NOBODY2(0x769A, "Nobody"),
	ISHTAR(0x0A9A, "Ishtar"),
	ARAPHEN_LOPUTO_BELDO(0x6C9A, "Araphen/Loputo/Beldo"),
	NOBODY3(0x769A, "Nobody"),
	NOBODY4(0x789A, "Nobody"),
	SAPHY(0x369A, "Saphy"),
	TINA_LOPUTO(0x289A, "Tina/Loputo"),
	TINA_FREEGE_LOPUTO(0x2E9A, "Tina/Freege/Loputo");

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
