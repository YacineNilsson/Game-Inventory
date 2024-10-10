package Weapon_Classes;

import Interfaces.MeleeAttack;
import Interfaces.RangedAttack;

public class MeleeWeapon extends Weapon implements MeleeAttack, RangedAttack {
    private String primaryDamageType;
    private String secondaryDamageType;

    public MeleeWeapon(String name, int value, int repairCost, String type, double weight, int meleeDamage, int rangedDamage, int durability, String effect, int range, double attackCooldown, double attackDuration, String primaryDamageType, String secondaryDamageType) {
        super(name, value, repairCost, type, weight, meleeDamage, rangedDamage, durability, effect, range, attackCooldown, attackDuration);
        this.primaryDamageType = primaryDamageType;
        this.secondaryDamageType = secondaryDamageType;
    }

    public String getPrimaryDamageType() {
        return primaryDamageType;
    }

    public String getSecondaryDamageType() {
        return secondaryDamageType;
    }

    public void setPrimaryDamageType(String primaryDamageType) {
        this.primaryDamageType = primaryDamageType;
    }

    public void setSecondaryDamageType(String secondaryDamageType) {
        this.secondaryDamageType = secondaryDamageType;
    }

    @Override
    public void meleeAttack() {
        System.out.println("Used " + getName() + " to strike enemy, causing " + getMeleeDamage() + " damage.");
    }

    @Override
    public void rangedAttack() {
        if (getDurability() > 0) {
            System.out.println("Throws " + getName() + " at enemy");
            durabilityDamage(); // Minska hållbarheten vid användning
        } else {
            System.out.println(getName() + " is broken and can't be used.");
        }
    }

    public static final MeleeWeapon shortSword = new MeleeWeapon("Short sword", 100, 5, "Weapon", 3.4, 10, 3, 100, "none", 3, 0.5, 0.5, "slash",  "throw" );
}
