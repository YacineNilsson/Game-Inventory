package Consumable_classes;

import Interfaces.RangedAttack;
import Interfaces.Usable;
import Player.Player;

public class OffensiveConsumable extends Consumable implements Usable, RangedAttack {
    private int damage;
    private String damageType;
    private String additionalEffect;

    public OffensiveConsumable(String name, int value, String type, double weight, int duration, boolean buff, int damage, String damageType, String additionalEffect) {
        super(name, value, type, weight, duration, buff);
        this.damage = damage;
        this.damageType = damageType;
        this.additionalEffect = additionalEffect;
    }

    public int getDamage() {
        return damage;
    }

    public String getDamageType() {
        return damageType;
    }

    public String getAdditionalEffect() {
        return additionalEffect;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public void setAdditionalEffect(String additionalEffect) {
        this.additionalEffect = additionalEffect;
    }

    @Override
    public void useItem(Player player) {

    }

    @Override
    public void rangedAttack() {

    }

}
