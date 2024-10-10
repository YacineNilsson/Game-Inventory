package Armour_classes;

import Interfaces.Durability;
import Interfaces.Equippable;
import Inventory.Inventory;
import Item.Item;
import Player.Player;



public class Armour extends Item implements Equippable, Durability {
    private int defense;
    private int durability;
    private int maxDurability;
    private String typeOfArmour;
    private String effect;
    private int resistance;
    private String resistanceType;

    public Armour(String name, int value, int repairCost, String type, double weight, int defense, String resistanceType, int resistance, String effect, String typeOfArmour, int durability) {
        super(name, value, repairCost, type, weight);
        this.defense = defense;
        this.resistanceType = resistanceType;
        this.resistance = resistance;
        this.effect = effect;
        this.typeOfArmour = typeOfArmour;
        this.maxDurability = durability;
        this.durability = durability;
    }

    public int getDefense() {
        return defense;
    }

    public int getDurability() {
        return durability;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public String getTypeOfArmour() {
        return typeOfArmour;
    }

    public String getEffect() {
        return effect;
    }

    public int getResistance() {
        return resistance;
    }

    public String getResistanceType() {
        return resistanceType;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void setMaxDurability(int maxDurability) {
        this.maxDurability = maxDurability;
    }

    public void setTypeOfArmour(String typeOfArmour) {
        this.typeOfArmour = typeOfArmour;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public void setResistanceType(String resistanceType) {
        this.resistanceType = resistanceType;
    }

    @Override
    public void equip() {
        if (isEquipped()==false) {
            setEquipped(true); // Markera armour som utrustat
            System.out.println(getName() + " has been equipped.");

        } else {
            System.out.println(getName() + " is already equipped.");
        }
    }

    @Override
    public void unequip() {
        if (isEquipped()==true) {
            setEquipped(false); // Markera armour som inte längre utrustat
            System.out.println(getName() + " has been unequipped.");

        } else {
            System.out.println(getName() + " is not equipped.");
        }
    }

    @Override
    public void durabilityDamage() {
        if (durability > 0) {
            durability--; // Minska hållbarheten med 1
            System.out.println(getName() + " took durability damage. Current durability: " + durability);
        } else {
            System.out.println(getName() + " is broken and cannot be used.");
        }
    }

    @Override
    public void durabilityRepair() {
        if (durability < maxDurability) {
            durability = maxDurability;
            System.out.println(getName() + " has been repaired. Durability restored to: " + durability);
        } else {
            System.out.println(getName() + " is already at full durability.");
        }
    }

    public static final Armour chestArmour = new Armour("Chest armour", 100, 5, "armour", 3.3, 10, "none", 0, "none", "body armour", 100 );
    public static final Armour lightHelmet = new Armour("Light helmet", 100, 5, "armour", 0.5, 5, "none", 0, "none", "helmet", 50);
}
