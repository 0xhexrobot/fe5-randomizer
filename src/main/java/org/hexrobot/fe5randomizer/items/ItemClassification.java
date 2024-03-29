package org.hexrobot.fe5randomizer.items;

import org.hexrobot.fe5randomizer.util.InvalidRomDataException;

public enum ItemClassification {
	ITEM(0x00, "Item"),
	WEAPON(0x04, "Weapon"),
	BALLISTA(0x05, "Ballista"),
	MAGIC_WEAPON(0x06, "Magic Weapon"),
	MAGIC(0x0C, "Magic"),
	STAFF(0x10, "Staff"),
	INFINITE_USE_ITEM(0x20, "Infinite use Item"),
	INFINITE_USE_WEAPON(0x24, "Infinite use Weapon"),
	INFINITE_USE_MAGIC_WEAPON(0x26, "Infinite use Magic Weapon"),
	INFINITE_USE_MAGIC(0x2C, "Infinite use Magic"),
	INFINITE_USE_STAFF(0x30, "Infinite use Staff"),
	TREASURE_ITEM(0x40, "Treasure Item"),
	TREASURE_WEAPON(0x44, "Treasure Weapon"),
	TREASURE_MAGIC_WEAPON(0x46, "Treasure Magic Weapon"),
	TREASURE_MAGIC(0x4C, "Treasure Magic"),
	TREASURE_STAFF(0x50, "Treasure Staff"),
	INFINITE_USE_TREASURE_ITEM(0x60, "Infinite use Treasure Item"),
	INFINITE_USE_TREASURE_WEAPON(0x64, "Infinite use Treasure Weapon"),
	INFINITE_USE_TREASURE_MAGIC_WEAPON(0x66, "Infinite use Treasure Magic Weapon"),
	INFINITE_USE_TREASURE_MAGIC(0x6C, "Infinite use Treasure Magic"),
	INFINITE_USE_TREASURE_STAFF(0x70, "Infinite use Treasure Staff"),
	BROKEN_ITEM(0xA0, "Broken Item"),
	BROKEN_WEAPON(0xA4, "Broken Weapon");
	
	private int offset;
	private String name;
	
	private ItemClassification(int offset, String name) {
		this.offset = offset;
		this.name = name;
	}
	
	public int getOffset() {
	    return offset;
	}
	
	public String getName() {
		return name;
	}
	
	public static ItemClassification findById(int offset) throws InvalidRomDataException {
		ItemClassification weaponClassification = null;
		
		for(ItemClassification wpnClassification : ItemClassification.values()) {
			if(wpnClassification.offset == offset) {
				weaponClassification = wpnClassification;
				break;
			}
		}
		
		if(weaponClassification == null) {
			throw new InvalidRomDataException(String.format(
					"Offset 0x%02X in ItemClassification was not found.", offset));
		}
		
		return weaponClassification;
	}
}
