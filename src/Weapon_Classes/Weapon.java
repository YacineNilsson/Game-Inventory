package Weapon_Classes;

import Interfaces.Durability;
import Interfaces.Equippable;
import Item.Item;

public class Weapon extends Item implements Equippable, Durability {
    private int meleeDamage;
    private int rangedDamage;
    private int durability;
    private final int maxDurability;
    private String effect;
    private int range;
    private double attackCooldown;
    private double attackDuration;


    public Weapon(String name, int value, int repairCost, String type, double weight,
                  int meleeDamage, int rangedDamage, int durability, String effect,
                  int range, double attackCooldown, double attackDuration) {
        super(name, value, repairCost, type, weight); // Anrop av basklassens konstruktor
        this.meleeDamage = meleeDamage;
        this.rangedDamage = rangedDamage;
        this.durability = durability;
        this.maxDurability = durability;
        this.effect = effect;
        this.range = range;
        this.attackCooldown = attackCooldown;
        this.attackDuration = attackDuration;
    }

    // Getters och Setters
    public int getMeleeDamage() {
        return meleeDamage;
    }

    public void setMeleeDamage(int meleeDamage) {
        this.meleeDamage = meleeDamage;
    }

    public int getRangedDamage() {
        return rangedDamage;
    }

    public void setRangedDamage(int rangedDamage) {
        this.rangedDamage = rangedDamage;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public double getAttackCooldown() {
        return attackCooldown;
    }

    public void setAttackCooldown(double attackCooldown) {
        this.attackCooldown = attackCooldown;
    }

    public double getAttackDuration() {
        return attackDuration;
    }

    public void setAttackDuration(double attackDuration) {
        this.attackDuration = attackDuration;
    }

    @Override
    public void equip() {
        if (!isEquipped()) {
            setEquipped(true);
            System.out.println(getName() + " has been equipped.");
        } else {
            System.out.println(getName() + " is already equipped.");
        }
    }

    @Override
    public void unequip() {
        if (isEquipped()) {
            setEquipped(false);
            System.out.println(getName() + " has been unequipped.");
        } else {
            System.out.println(getName() + " is not equipped.");
        }
    }

    @Override
    public void durabilityDamage() {
        if (durability > 0) {
            durability--;
            System.out.println(getName() + " took durability damage. Current durability: " + durability);
        } else {
            System.out.println(getName() + " is broken and cannot be used.");
        }
    }

    @Override
    public void durabilityRepair() {
        if (durability < maxDurability) {
            durability = maxDurability; // Reparera till max hållbarhet
            System.out.println(getName() + " has been repaired. Durability restored to: " + durability);
        } else {
            System.out.println(getName() + " is already at full durability.");
        }
    }

}
