package cc.xpbootcamp.warmup.cashier;

public class LineItem {
    private String description;
    private double price;
    private int qty;

    public LineItem(String description, double price, int qty) {
        super();
        this.description = description;
        this.price = price;
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return qty;
    }

    double totalAmount() {
        return price * qty;
    }
}