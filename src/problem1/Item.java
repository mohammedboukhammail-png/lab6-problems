package problem1;

public class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String itemName, double itemPrice, int numPurchased) {
        this.name = itemName;
        this.price = itemPrice;
        this.quantity = numPurchased;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return name + " @ $" + price + " (Quantity: " + quantity + ")";
    }
}