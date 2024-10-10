package Weapon_Classes;

import Interfaces.MeleeAttack;
import Interfaces.RangedAttack;

public class RangedWeapon extends Weapon implements MeleeAttack, RangedAttack {
    private String primaryDamageType;
    private String secondaryDamageType;
    private int ammunition;

    public RangedWeapon(String name, int value, int repairCost, String type, double weight, int meleeDamage, int rangedDamage, int durability, String effect, int range, double attackCooldown, double attackDuration, String primaryDamageType, String secondaryDamageType, int ammunition) {
        super(name, value, repairCost, type, weight, meleeDamage, rangedDamage, durability, effect, range, attackCooldown, attackDuration);
        this.primaryDamageType = primaryDamageType;
        this.secondaryDamageType = secondaryDamageType;
        this.ammunition = ammunition;
    }

    public String getPrimaryDamageType() {
        return primaryDamageType;
    }

    public String getSecondaryDamageType() {
        return secondaryDamageType;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public void setPrimaryDamageType(String primaryDamageType) {
        this.primaryDamageType = primaryDamageType;
    }

    public void setSecondaryDamageType(String secondaryDamageType) {
        this.secondaryDamageType = secondaryDamageType;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    @Override
    public void meleeAttack() {
        if (getDurability() > 0) {
            System.out.println("Used " + getName() + " to strike enemy");
            durabilityDamage();
        } else {
            System.out.println(getName() + " is broken and can't be used.");
        }
    }

    @Override
    public void rangedAttack() {
        if (ammunition > 0) {
            System.out.println("Shooting with " + getName());
            ammunition--;
        } else {
            System.out.println("Out of ammunition!");
        }
    }

    public static final RangedWeapon smallBow = new RangedWeapon("Small bow", 100, 5, "Weapon", 2.3, 5, 15, 100, "none", 120, 1.0, 1.0, "arrow shot", "strike",  100);
}
