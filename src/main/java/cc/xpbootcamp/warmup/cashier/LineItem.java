package cc.xpbootcamp.warmup.cashier;

public class LineItem {

    private static final String LINE_ITEM_FORMATTER = "%s, %.2f x %d, %.2f\n";
    private static final double TAX_RATE = .10;

    private String description;
    private double price;
    private int quantity;

    public LineItem(String description, double price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    double calculateTotalAmount() {
        return price * quantity;
    }

    double calculateTotalSalesTax() {
        return calculateTotalAmount() * TAX_RATE;
    }

    @Override
    public String toString() {
        return String.format(LINE_ITEM_FORMATTER, description, price, quantity, calculateTotalAmount());
    }
}