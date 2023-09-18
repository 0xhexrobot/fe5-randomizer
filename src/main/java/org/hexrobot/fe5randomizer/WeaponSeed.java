package org.hexrobot.fe5randomizer;

public enum WeaponSeed {
    IRON_SWORD(0, "iron-sword.gif", "Iron Sword"),
    IRON_LANCE(1, "iron-lance.png", "Iron Lance"),
    IRON_AXE(2, "iron-axe.png", "Iron Axe"),
    IRON_BOW(3, "iron-bow.png", "Iron Bow"),
    RAPIER(4, "rapier.gif", "Rapier"),
    LIGHT_SWORD(5, "light-sword.gif", "Light Sword"),
    LOPTO_SWORD(6, "lopto-sword.gif", "Lopto Sword"),
    JAVELIN(7, "javelin.png", "Javelin"),
    HAMMER(8, "hammer.png", "Hammer"),
    DEVIL_AXE(9, "devil-axe.png", "Devil Axe"),
    HEAL_STAFF(10, "heal-staff.png", "Heal Staff"),
    FIRE_TOME(11, "fire-tome.png", "Fire Tome"),
    THUNDER_TOME(12, "thunder-tome.png", "Thunder Tome"),
    WIND_TOME(13, "wind-tome.png", "Wind Tome"),
    LIGHT_TOME(14, "light-tome.png", "Light Tome"),
    DARK_TOME(15, "dark-tome.png", "Dark Tome"),
    BALLISTA(16, "ballista.png", "Ballista"),
    BROKEN_SWORD(17, "broken-sword.gif", "Broken Sword"),
    BROKEN_LANCE(18, "broken-lance.png", "Broken Lance"),
    BROKEN_AXE(19, "broken-axe.png", "Broken Axe"),
    BROKEN_BOW(20, "broken-bow.png", "Broken Bow"),
    EMPTY_TOME(21, "empty-tome.png", "Empty Tome"),
    BROKEN_STAFF(22, "broken-staff.png", "Broken Staff"),
    KNIGHT_PROOF(23, "knight-proof.png", "Knight Proof"),
    LOCKPICK(24, "lockpick.png", "Lockpick"),
    MAGIC_RING(25, "magic-ring.png", "Magic Ring"),
    MEMBER_CARD(26, "member-card.png", "Member Card"),
    DOOR_KEY(27, "door-key.png", "Door Key"),
    HOLY_WATER(28, "holy-water.png", "Holy Water"),
    TORCH(29, "torch.png", "Torch"),
    VULNERARY(30, "vulnerary.png", "Vulnerary"),
    FALA_SCROLL(31, "fala-scroll.png", "Fala Scroll");

    private Integer seed;
    private String imgName;
    private String name;
    
    private WeaponSeed(int seed, String imgName, String name) {
        this.seed = seed;
        this.imgName = imgName;
        this.name = name;
    }

    public static WeaponSeed getBySeed(int seed) {
        WeaponSeed weaponSeed = null;

        for(WeaponSeed wpnSeed : values()) {
            if(wpnSeed.seed == seed) {
                weaponSeed = wpnSeed;
                break;
            }
        }

        if(weaponSeed == null) {
            throw new IllegalArgumentException(String.format("Seed %d doesn't exist!", seed));
        }

        return weaponSeed;
    }

    public String getImageName() {
        return imgName;
    }

    public String getName() {
        return name;
    }
}
