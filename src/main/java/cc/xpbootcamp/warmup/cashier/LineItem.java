package cc.xpbootcamp.warmup.cashier;

public class LineItem {
    private static final double TAX_RATE = .10;
    private static final String PRINT_FORMATTER = "%s, %.2f x %d, %.2f\n";
    private String description;
    private double price;
    private int quantity;

    public LineItem(String description, double price, int quantity) {
        super();
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
        return String.format(PRINT_FORMATTER, description, price, quantity, calculateTotalAmount());
    }
}