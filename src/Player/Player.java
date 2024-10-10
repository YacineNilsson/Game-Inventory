package Player;

import Inventory.Inventory;
import Item.Item;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private int maxHealth;
    private int gold;
    private Inventory inventory;
    private Inventory equippedInventory;



    public Player(String name, int health, int gold) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.gold = gold;
        this.inventory = new Inventory(this);
        this.equippedInventory = new Inventory(this);
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

    public Inventory getEquippedInventory() {
        return equippedInventory;
    }

    public void addGold(int amount) {
        this.gold += amount;
        System.out.println(amount + " gold has been added to " + name + "'s total. Gold: " + gold);
    }

    public void subtractGold(int amount) {
        if (this.gold >= amount) {
            this.gold -= amount;
            System.out.println(amount + " gold has been deducted from " + name + "'s total.");
        } else {
            System.out.println(name + " does not have enough gold.");
        }
    }

    public void heal(int amount) {
        this.health = Math.min(this.health + amount, this.maxHealth); // Kan inte gå över maxHealth
        System.out.println(name + " has been healed by " + amount + ". Current health: " + this.health + "/" + maxHealth);
    }

    public void takeDamage(int amount) {
        this.health = Math.max(this.health - amount, 0); // Minimum hälsa är 0
        System.out.println(name + " has taken " + amount + " damage. Current health: " + this.health);
    }

    public void equipItem(Item item) {
        if (item.isEquipped()) {
            inventory.removeItem(item);
            equippedInventory.addItem(item);
        }
    }

    public void unequipItem(Item item) {
        if (inventory.findItemByIsEquipped()==false) { // lägg till i main
            equippedInventory.removeItem(item);
            inventory.addItem(item);
        }
    }

    public static final Player player1 = new Player("Kratos", 100, 1000);
}
