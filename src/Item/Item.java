package Item;

public class Item {
    private String name;
    private int value;
    private int repairCost;
    private String type;
    private double weight;
    private boolean isEquipped;

    public Item(String name, int value, int repairCost, String type, double weight) {
        this.name = name;
        this.value = value;
        this.repairCost = repairCost;
        this.type = type;
        this.weight = weight;
        this.isEquipped = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(int repairCost) {
        this.repairCost = repairCost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isEquipped() {
        return isEquipped;
    }

    public void setEquipped(boolean equipped) {
        isEquipped = equipped;
    }
}



