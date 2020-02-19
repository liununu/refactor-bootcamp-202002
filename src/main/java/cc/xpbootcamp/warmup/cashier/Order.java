package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private List<LineItem> lineItems;

    public Order(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public double getTotalSalesTax() {
        return lineItems.stream().mapToDouble(LineItem::calculateTotalSalesTax).sum();
    }

    public double getTotalAmount() {
        return lineItems.stream()
                .mapToDouble(lineItem -> lineItem.calculateTotalAmount() + lineItem.calculateTotalSalesTax())
                .sum();
    }
}
