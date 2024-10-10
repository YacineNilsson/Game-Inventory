import Armour_classes.Armour;
import Consumable_classes.DefensiveConsumable;
import Enemy.Enemy;
import Player.Player;
import Shop.Shop;
import Weapon_Classes.MeleeWeapon;
import Weapon_Classes.RangedWeapon;
import Item.Item;
import Consumable_classes.Consumable;
import Weapon_Classes.Weapon;


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        Player player = Player.player1;
        MeleeWeapon shortSword = MeleeWeapon.shortSword;
        RangedWeapon smallBow = RangedWeapon.smallBow;
        Armour lightHelmet = Armour.lightHelmet;
        Armour chestArmour = Armour.chestArmour;
        DefensiveConsumable healingPotion = DefensiveConsumable.healingPotion;
        Enemy enemy = Enemy.goblin;
        Shop shop = Shop.shop;

        player.getInventory().addItem(shortSword);
        player.getInventory().addItem(smallBow);
        player.getInventory().addItem(lightHelmet);
        player.getInventory().addItem(chestArmour);
        player.getInventory().addItem(healingPotion);
        enemy.getInventory().addItem(healingPotion);
        enemy.getInventory().addItem(healingPotion);
        enemy.getInventory().addItem(healingPotion);
        enemy.getInventory().addItem(lightHelmet);
        shop.getInventory().addItem(shortSword);
        shop.getInventory().addItem(smallBow);
        shop.getInventory().addItem(lightHelmet);
        shop.getInventory().addItem(chestArmour);
        shop.getInventory().addItem(healingPotion);


        // Första menyn
        while (true) {
            System.out.println("\n--- Game Menu ---");
            System.out.println("1. Go on adventure");
            System.out.println("2. Inventory");
            System.out.println("3. Player");
            System.out.println("4. Visit shop");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nDetta är endast ett grovt simplifierat exempel på hur en strid kan se ut!\nDet är inte dina vapen som används men du får looten");
                    System.out.println("\nYou are going on an adventure!");
                    System.out.println("You encountered an enemy: " + enemy.getName());
                    enemy.takeDamage(smallBow.getMeleeDamage());
                    smallBow.meleeAttack();
                    player.takeDamage(enemy.getDamage());
                    enemy.takeDamage(shortSword.getMeleeDamage());
                    shortSword.meleeAttack();
                    player.takeDamage(enemy.getDamage());
                    enemy.takeDamage(smallBow.getMeleeDamage());
                    smallBow.meleeAttack();
                    enemy.dropLoot(player);
                    break;
                case 2:
                    openInventory(player, scanner);
                    break;
                case 3:
                    System.out.println("\nPlayer Stats:");
                    System.out.println("Name: " + player.getName());
                    System.out.println("Health: " + player.getHealth() + "/" + player.getMaxHealth());
                    System.out.println("Gold: " + player.getGold());
                    System.out.println("Equipped items: ");
                    player.getEquippedInventory().showItems();
                    playerOption(player, scanner);
                    break;
                case 4:
                    openShop(player, shop, scanner);
                    break;
                case 5:
                    System.out.println("Exiting game...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Not valid. Try again.");
            }

        }
    }


    // Inventory menyn
    public static void openInventory(Player player, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Show items");
            System.out.println("2. Use item");
            System.out.println("3. Remove item");
            System.out.println("4. Equip item");
            System.out.println("5. Return to game menu");
            System.out.print("Choose an option: ");

            int inventoryChoice = scanner.nextInt();
            scanner.nextLine(); // Som ovan viktig av någon anledning - fråga lärare

            switch (inventoryChoice) {
                case 1:
                    System.out.println("\nYour Inventory:");
                    player.getInventory().showItems();
                    break;
                case 2:
                    useOption(player, scanner);
                    // useItem för Usable items, annat "can't be used right now"
                    break;
                case 3:
                    System.out.println("\nItems here will be removed. If you want to sell an item you'll have to visit shop");
                    removeOption(player, scanner);
                    break;
                case 4:
                    equipOption(player, scanner);
                    break;
                    case 5:
                        return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Använda ett useble-objekt
    public static void useOption(Player player, Scanner scanner) {
        while (true) {
            player.getInventory().showItemsByType("Consumable potion");

            System.out.println("\nDo you want to use a potion? (y/n)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("n")) {
                break;
            }

            if (choice.equalsIgnoreCase("y")) {
                System.out.println("Enter the name of the potion you want to use: ");
                String itemName = scanner.nextLine();

                Item itemToUse = player.getInventory().findItemByName(itemName);

                //nu kan vi bara annvända defensive consumables. lös så att du också kan använda andra
                if (itemToUse != null && itemToUse instanceof DefensiveConsumable) {
                    ((DefensiveConsumable) itemToUse).useItem(player); // Plugga in detta och förstå vad du har skrivit

                } else {
                    System.out.println("Potion not found in inventory.");
                }
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void removeOption(Player player, Scanner scanner) {
        while (true) {
            player.getInventory().showItems();

            System.out.println("\nDo you want to remove an item (y/n)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("n")) {
            break;
            }
            if (choice.equalsIgnoreCase("y")) {
                System.out.println("Enter the name of the item you want to remove: ");
                String itemName = scanner.nextLine();
                Item itemToRemove = player.getInventory().findItemByName(itemName);
                if (itemToRemove != null) {
                   player.getInventory().removeItem(itemToRemove);
                }
            }
        }
    }

    public static void equipOption(Player player, Scanner scanner) { //Item item
        while (true) {
            player.getInventory().showItems();

            System.out.println("\nDo you want to equip an item? (y/n)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("n")) {
                break;
            }

            if (choice.equalsIgnoreCase("y")) {
                System.out.println("Enter the name of the item you want to equip: ");
                String itemName = scanner.nextLine();
                //if (itemToEquip.isEquipped())
                Item itemToEquip = player.getInventory().findItemByName(itemName);
                if (itemToEquip != null && itemToEquip instanceof Armour) {
                    ((Armour) itemToEquip).equip();
                    player.equipItem(itemToEquip);
                } else if (itemToEquip != null && itemToEquip instanceof Weapon) {
                    ((Weapon) itemToEquip).equip();
                    player.equipItem(itemToEquip);
                } else if (itemToEquip != null && itemToEquip instanceof Consumable) {
                    ((Consumable) itemToEquip).equip();
                    player.equipItem(itemToEquip);
                } else {
                    System.out.println("Item not found in inventory.");
                }
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }


    public static void playerOption(Player player, Scanner scanner) {
        while (true) {

            System.out.println("\nDo you want to unequip an item? (y/n)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("n")) {
                break;
            }

            if (choice.equalsIgnoreCase("y")) {
                System.out.println("Enter the name of the item you want to unequip: ");
                String itemName = scanner.nextLine();

                Item itemToUnEquip = player.getEquippedInventory().findItemByName(itemName);
                if (itemToUnEquip != null && itemToUnEquip instanceof Armour) {
                    ((Armour) itemToUnEquip).unequip();
                    player.unequipItem(itemToUnEquip);
                } else if (itemToUnEquip != null && itemToUnEquip instanceof Weapon) {
                    ((Weapon) itemToUnEquip).unequip();
                    player.unequipItem(itemToUnEquip);
                } else if (itemToUnEquip != null && itemToUnEquip instanceof Consumable) {
                    ((Consumable) itemToUnEquip).unequip();
                    player.unequipItem(itemToUnEquip);
                } else {
                    System.out.println("Item not found in inventory.");
                }
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Shop menyn
    public static void openShop(Player player, Shop shop, Scanner scanner) {
        while (true) {
            System.out.println("\n--- Shop Menu ---");
            System.out.println("1. Buy");
            System.out.println("2. Sell");
            System.out.println("3. Repair");
            System.out.println("4. Return to game menu");
            System.out.print("Choose an option: ");

            int switchChoice = scanner.nextInt();
            scanner.nextLine();

            switch (switchChoice) {
                case 1:
                    buyOption(player, shop, scanner);
                    break;
                case 2:
                    sellOption(player, scanner);
                    break;
                case 3:
                    System.out.println("\nUNDER CONSTRUCTION! Just nu kan du inte strida så därför dina vapen kan inte skadas");
                    repairOption(player, scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void buyOption(Player player, Shop shop, Scanner scanner) {
        while (true) {
            System.out.println("\nShop inventory:");
            shop.getInventory().showItems();
            System.out.println("\nDo you want to buy an item? (y/n)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("n")) {
                break;
            }
            if (choice.equalsIgnoreCase("y")) {
                System.out.println("Enter the name of the item you want to buy: ");
                String itemName = scanner.nextLine();
                Item itemToBuy = shop.getInventory().findItemByName(itemName);
                if (itemToBuy != null) {
                    player.getInventory().addItem(itemToBuy);
                    player.subtractGold(itemToBuy.getValue());
                    System.out.println(player.getName() + " has spent " + itemToBuy.getValue() + " gold. Total gold: " + player.getGold());
                } else {
                    System.out.println("Item not found in inventory.");
                }
            }
        }
    }

    public static void sellOption(Player player, Scanner scanner) {
        while (true) {
            System.out.println("\nItems you can sell:");
            player.getInventory().showItems();
            System.out.println("\nDo you want to sell an item? (y/n)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("n")) {
                break;
            }
            if (choice.equalsIgnoreCase("y")) {
                System.out.println("Enter the name of the item you want to sell: ");
                String itemName = scanner.nextLine();
                Item itemToSell = player.getInventory().findItemByName(itemName);
                if (itemToSell != null) {
                    player.getInventory().sellItem(itemToSell);
                } else {
                    System.out.println("Item not found in inventory.");
                }
            }
        }
    }

    public static void repairOption(Player player, Scanner scanner) {
        while (true) {

            player.getEquippedInventory().showItemsWithLessDurability();
            System.out.println("Items to repair:");
            System.out.println("\nDo you want to repair an item? (y/n)");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("n")) {
                break;
            }

            if (choice.equalsIgnoreCase("y")) {
                System.out.println("Enter the name of the item you want to repair: ");
                String itemName = scanner.nextLine();

                Item itemToRepair = player.getEquippedInventory().findItemByName(itemName);
                if (itemToRepair != null) {
                    if (itemToRepair instanceof Armour) {
                        ((Armour) itemToRepair).durabilityRepair();
                        if (((Armour) itemToRepair).getDurability() < ((Armour) itemToRepair).getMaxDurability()) {
                            player.subtractGold(itemToRepair.getRepairCost());
                        }
                    } else if (itemToRepair instanceof Weapon) {
                        ((Weapon) itemToRepair).durabilityRepair();
                        if (((Weapon) itemToRepair).getDurability() < ((Weapon) itemToRepair).getMaxDurability()) {
                            player.subtractGold(itemToRepair.getRepairCost());
                        }
                    }
                } else {
                    System.out.println("Item not found in inventory.");
                }
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

}



//    private static void playerAttack(Player player, Enemy enemy, MeleeWeapon meleeWeapon, RangedWeapon rangedWeapon) {
//        int damage = 0;
//
//        if (meleeWeapon != null) {
//            damage += meleeWeapon.getMeleeDamage(); // Använder närstridsskada från närstridsvapen
//
//        } else if (meleeWeapon != null) {
//            damage += meleeWeapon.getRangedDamage();// Använder distansskada från närstridsvapen (kastar svärdet t.ex.)
//        }
//
//        if (rangedWeapon != null) {
//            damage += rangedWeapon.getMeleeDamage(); // Använder närstridsskada från distansvapen (slår med pilbågen t.ex.)
//            damage += rangedWeapon.getRangedDamage(); // Använder distansskada från distansvapen
//        }
//
//        System.out.println(player.getName() + " attacks " + enemy.getName());
//        boolean enemyDefeated = enemy.takeDamage(damage); // Skada på fienden
//        if (enemyDefeated) {
//            System.out.println(enemy.getName() + " has been defeated!");
//        }
//    }
//
//    public static void battle(Player player, Enemy enemy, Scanner scanner) {
//
//    }