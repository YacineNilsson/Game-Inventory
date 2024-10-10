package Shop;

import Inventory.Inventory;
import Item.Item;

public class Shop {
    private String name;
    private Inventory inventory;

    public Shop(String name) {
        this.name = name;
        this.inventory = new Inventory(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public static final Shop shop = new Shop("Ye old shoppe");
}
