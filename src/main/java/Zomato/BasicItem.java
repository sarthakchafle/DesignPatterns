package Zomato;

public class BasicItem implements MenuItem {
    private final String itemName;
    private final double itemPrice;

    public BasicItem(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    @Override
    public String getDescription() {
        return itemName;
    }

    @Override
    public double getPrice() {
        return itemPrice;
    }
}
