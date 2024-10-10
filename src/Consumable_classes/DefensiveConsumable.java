package Consumable_classes;

import Interfaces.Usable;
import Player.Player;

public class DefensiveConsumable extends Consumable implements Usable {
    public int healingAmount;
    public String buffEffect;
    private Player player;

    public DefensiveConsumable(String name, int value, String type, double weight, int duration, boolean buff, int healingAmount, String buffEffect) {
        super(name, value, type, weight, duration, buff);
        this.healingAmount = healingAmount;
        this.buffEffect = buffEffect;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }

    public String getBuffEffect() {
        return buffEffect;
    }

    public void setBuffEffect(String buffEffect) {
        this.buffEffect = buffEffect;
    }

    @Override
    public void useItem(Player player) {
        System.out.println("You have used " + getName());
        player.heal(healingAmount);
        player.getInventory().removeItem(this);
    }

    public static final DefensiveConsumable healingPotion = new DefensiveConsumable("Healing potion", 20, "Consumable potion", 0.1, 0, false, 20, "none");
}
