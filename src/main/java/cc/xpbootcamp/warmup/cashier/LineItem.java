package cc.xpbootcamp.warmup.cashier;

import static cc.xpbootcamp.warmup.cashier.constant.CalculateRateConstant.TAX_RATE;
import static cc.xpbootcamp.warmup.cashier.constant.OrderReceiptStyleConstant.LINE_ITEM_FORMATTER;

public class LineItem {

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