package Consumable_classes;

import Interfaces.Equippable;
import Interfaces.Usable;
import Item.Item;

public class Consumable extends Item implements Equippable {
    private int duration;
    private boolean buff;
    private static int equippedConsumables = 0;
    private static final int maxEquippedConsumables = 5;

    public Consumable(String name, int value, String type, double weight, int duration, boolean buff) {
        super(name, value, 0, type, weight); // Ignorerar repairCost i denna klassen
        this.duration = duration;
        this.buff = buff;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isBuff() {
        return buff;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setBuff(boolean buff) {
        this.buff = buff;
    }


    @Override
    public void equip() {
        if (!isEquipped()) {
            if(equippedConsumables < maxEquippedConsumables) {
                setEquipped(true);
                equippedConsumables++;
                System.out.println(getName() + " has been equipped.");
            } else {
                System.out.println("You can't equip more than " + maxEquippedConsumables + " consumables.");
            }
        } else {
            System.out.println(getName() + " is already equipped.");
        }
    }

    @Override
    public void unequip() {
        if (isEquipped()) {
            setEquipped(false); // Markera consumable som inte längre utrustat
            equippedConsumables--; // Minska räknaren
            System.out.println(getName() + " has been unequipped. Total equipped consumables: " + equippedConsumables);
        } else {
            System.out.println(getName() + " is not equipped.");
        }
    }
}
