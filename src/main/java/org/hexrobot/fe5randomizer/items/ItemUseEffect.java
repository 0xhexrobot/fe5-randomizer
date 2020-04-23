package org.hexrobot.fe5randomizer.items;

public enum ItemUseEffect {
	NOTHING(0x00, "Nothing"),
	LUCK_RING_EFFECT(0x02, "Luck Ring effect"),
	LIVE_RING_EFFECT(0x04, "Life Ring effect"),
	SPEED_RING_EFFECT(0x06, "Speed Ring effect"),
	MAGIC_RING_EFFECT(0x08, "Magic Ring effect"),
	POWER_RING_EFFECT(0x0A, "Power Ring effect"),
	BODY_RING_EFFECT(0x0C, "Body Ring effect"),
	SHIELD_RING_EFFECT(0x0E, "Shield Ring effect"),
	SKILL_RING_EFFECT(0x10, "Skill Ring effect"),
	LEG_RING_EFFECT(0x12, "Leg Ring effect"),
	KNIGHT_PROOF_EFFECT(0x14, "Knight Proof effect"),
	MASTER_PROOF_EFFECT(0x16, "Master Proof effect"),
	TREASURE_KEY_EFFECT(0x18, "Treasure Key effect"),
	DOOR_KEY_EFFECT(0x1A, "Door Key effect"),
	BRIDGE_KEY_EFFECT(0x1C, "Bridge Key effect"),
	THIEF_KEY_EFFECT(0x1E, "Thief Key effect"),
	MEDICINE_EFFECT(0x20, "Medicine effect"),
	HOLY_WATER_EFFECT(0x22, "Holy Water effect"),
	TORCH_EFFECT(0x24, "Torch effect"),
	ANTIDOTE_EFFECT(0x26, "Antidote effect"),
	ELITE_SKILL(0x28, "Elite Skill"),
	DUEL_SKILL(0x2A, "Duel Skill"),
	BARGAIN_SKILL(0x2C, "Bargain Skill"),
	AMBUSH_SKILL(0x2E, "Ambush Skill"),
	WRATH_SKILL(0x30, "Wrath Skill"),
	CONTINUE_SKILL(0x32, "Continue Skill"),
	PRAYER_SKILL(0x34, "Prayer Skill"),
	AWARENESS_SKILL(0x36, "Awareness Skill"),
	SUNLIGHT_SKILL(0x38, "Sunlight Skill"),
	MOONLIGHT_SKILL(0x3A, "Moonlight Skill"),
	LIVE_STAFF_EFFECT(0x3C, "Live Staff effect"),
	RELIVE_STAFF_EFFECT(0x3E, "Relive Staff effect"),
	RECOVER_STAFF_EFFECT(0x40, "Recover Staff effect"),
	LIBRO_STAFF_EFFECT(0x42, "Libro Staff effect"),
	RESERVE_STAFF_EFFECT(0x44, "Reserve Staff effect"),
	RESCUE_STAFF_EFFECT(0x46, "Rescue Staff effect"),
	WARP_STAFF_EFFECT(0x48, "Warp Staff effect"),
	REST_STAFF_EFFECT(0x4A, "Rest Staff effect"),
	SILENCE_STAFF_EFFECT(0x4C, "Silence Staff effect"),
	SLEEP_STAFF_EFFECT(0x4E, "Sleep Staff effect"),
	TORCH_STAFF_EFFECT(0x50, "Torch Staff effect"),
	RETURN_STAFF_EFFECT(0x52, "Return Staff effect"),
	REPAIR_STAFF_EFFECT(0x54, "Repair Staff effect"),
	THIEF_STAFF_EFFECT(0x56, "Thief Staff effect"),
	WATCH_STAFF_EFFECT(0x58, "Watch Staff effect"),
	BERSERK_STAFF_EFFECT(0x5A, "Berserk Staff effect"),
	UNLOCK_STAFF_EFFECT(0x5C, "Unlock Staff effect"),
	MAGIC_SHIELD_EFFECT(0x5E, "Magic Shield effect"),
	REWARP_EFFECT(0x60, "Rewarp effect"),
	S_DRINK_EFFECT(0x66, "S Drink effect"),
	CURE_STAFF_EFFECT(0x68, "Cure Staff effect");
	
	private int offset;
	private String name;
	
	private ItemUseEffect(int offset, String name) {
		this.offset = offset;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static ItemUseEffect findById(int offset) {
		ItemUseEffect itemUseEffect = null;
		
		for(ItemUseEffect itemUseEff : ItemUseEffect.values()) {
			if(itemUseEff.offset == offset) {
				itemUseEffect = itemUseEff;
				break;
			}
		}
		
		if(itemUseEffect == null) {
			System.out.println(String.format("WARNING: Offset 0x%02X in ItemUseEffect was not found.", offset));
			itemUseEffect = ItemUseEffect.NOTHING;
		}
		
		return itemUseEffect;
	}
}
