package Inventory;

import Armour_classes.Armour;
import Enemy.Enemy;
import Item.Item;
import Player.Player;
import Shop.Shop;
import Weapon_Classes.Weapon;


import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private ArrayList<Item> equippedItems;
    private Player player;
    private Shop shop;
    private Enemy enemy;

    public Inventory(Player player) {
        this.items = new ArrayList<>();
        this.equippedItems = new ArrayList<>();
        this.player = player;
    }

    public Inventory(Shop shop) {
        this.items = new ArrayList<>();
        this.shop = shop;
    }

    public Inventory(Enemy enemy) {
        this.items = new ArrayList<>();
        this.enemy = enemy;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Item> getEquippedItems() {
        return equippedItems;
    }

    public void addItem(Item item) {
        items.add(item);
        if (item.isEquipped()) {
            System.out.println(item.getName() + "is now on you");
        }
        else {
            System.out.println(item.getName() + " added to inventory");
        }
    }


    public void removeItem(Item item) {
        if (items.remove(item)) { // Försöker ta bort objektet från listan
            System.out.println(item.getName() + " has been removed from the inventory.");
        } else {
            System.out.println(item.getName() + " was not found in the inventory.");
        }
    }

    public void sellItem(Item item) {
        if (items.remove(item)) { // Försöker ta bort objektet från listan
            System.out.println(item.getName() + " has been sold.");
            player.setGold(player.getGold() + item.getValue()); // Lägg till itemets värde till spelarens guld
            System.out.println(player.getName() + " has received " + item.getValue() + " gold. Total gold: " + player.getGold());
        } else {
            System.out.println(item.getName() + " was not found in the inventory.");
        }
    }

    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Item item : items) {
                System.out.println("- " + item.getName() + " (Type: " + item.getType() + ", Value: " + item.getValue() + " gold)");
            }
        }
    }

    public void showItemsByType(String type) {
        for (Item item : items) {  // Antar att 'items' är din lista över föremål
            if (item.getType().equals(type)) {  // Filtrera baserat på typ
                System.out.println("Name: " + item.getName() + ", Value: " + item.getValue() + ", Type: " + item.getType());
            }

        }
    }

    public Item findItemByName(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void showItemsWithLessDurability() {
        for (Item item : equippedItems) {
            if (item instanceof Weapon) {
                if (((Weapon) item).getDurability() < ((Weapon) item).getMaxDurability()) {
                    System.out.println(item.getName() + " - Durability: " + ((Weapon) item).getDurability());
                }
            } else if (item instanceof Armour) {
                if (((Armour) item).getDurability() < ((Armour) item).getMaxDurability()) {
                    System.out.println(item.getName() + " - Durability: " + ((Armour) item).getDurability());
                }
            }
        }
    }


}
