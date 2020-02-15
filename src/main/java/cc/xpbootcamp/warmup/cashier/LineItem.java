package cc.xpbootcamp.warmup.cashier;

public class LineItem {
    private static final double TAX_RATE = .10;
    private String description;
    private double price;
    private int quantity;

    public LineItem(String description, double price, int quantity) {
        super();
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    double totalAmount() {
        return price * quantity;
    }

    double totalSalesTax() {
        return totalAmount() * TAX_RATE;
    }

    @Override
    public String toString() {
        return description + "\t"
                + price + "\t"
                + quantity + "\t"
                + totalAmount() + "\n";
    }
}