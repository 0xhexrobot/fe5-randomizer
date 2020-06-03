package org.hexrobot.fe5randomizer.items;

import java.util.ArrayList;
import java.util.List;

public enum ItemType {
	SWORD(0x00, "Sword"),
	LANCE(0x01, "Lance"),
	AXE(0x02, "Axe"),
	BOW(0x03, "Bow"),
	STAFF(0x04, "Staff"),
	FIRE(0x05, "Fire"),
	THUNDER(0x06, "Thunder"),
	WIND(0x07, "Wind"),
	LIGHT(0x08, "Light"),
	DARK(0x09, "Dark"),
	ITEM(0x0B, "Item"),
	FIRE_SWORD(0x50, "Fire sword"),
	THUNDER_SWORD(0x60, "Thunder sword"),
	WIND_SWORD(0x70, "Wind sword"),
	LIGHT_SWORD(0x80, "Light sword");
	
	private int offset;
	private String name;
	
	private static final ArrayList<ItemType> WEAPON_TYPES = new ArrayList<>(List.of(
	        SWORD, LANCE, AXE, BOW, STAFF, FIRE, THUNDER, WIND, LIGHT, DARK));
	
	private ItemType(int offset, String name) {
		this.offset = offset;
		this.name = name;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public String getName() {
		return name;
	}
	
	public static ArrayList<ItemType> getWeaponTypes() {
	    return new ArrayList<>(WEAPON_TYPES);
	}
	
	public static ItemType findById(int offset) {
		ItemType itemType = null;
		
		for(ItemType item : ItemType.values()) {
			if(item.offset == offset) {
				itemType = item;
				break;
			}
		}
		
		if(itemType == null) {
			System.out.println(String.format("WARNING: Offset 0x%02X in ItemType was not found.", offset));
			itemType = ItemType.ITEM;
		}
		
		return itemType;
	}
}
