package Enemy;

import Inventory.Inventory;
import Item.Item;
import Player.Player;

import java.util.Random;

public class Enemy {
    private String name;
    private int health;
    private int maxHealth;
    private int damage;
    private int gold;
    private Inventory inventory;

    public Enemy(String name, int health, int damage, int gold) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        this.gold = gold;
        this.inventory = new Inventory(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


    public boolean takeDamage(int amount) {
        this.health = Math.max(this.health - amount, 0); // Minimum hälsa är 0
        System.out.println(name + " has taken " + amount + " damage. Current health: " + this.health + "/" + this.maxHealth);
        return this.health == 0;
    }

    public void dropLoot(Player player) {
        if (health == 0) {
            Random random = new Random();
            int randomIndex = random.nextInt(inventory.getItems().size());
            Item lootItem = inventory.getItems().get(randomIndex);
            System.out.println(name + " dropped some gold and an item: " + lootItem.getName());
            player.getInventory().addItem(lootItem);
            player.addGold(this.gold);
        }
        else {
            System.out.println(name + " is still alive! Health: " + this.health + "/" + this.maxHealth);
        }
    }



    public static final Enemy goblin = new Enemy("Goblin", 20, 20, 10);
}
