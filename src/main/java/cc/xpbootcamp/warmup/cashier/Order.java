package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.DayOfWeek.WEDNESDAY;

public class Order {
    private static final double WEDNESDAY_DISCOUNT_RATE = .02;
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
        return LocalDateTime.now().getDayOfWeek() == WEDNESDAY
                ? getWednesdayTotalAmount()
                : getOriginalTotalAmount();
    }

    private double getOriginalTotalAmount() {
        return lineItems.stream()
                .mapToDouble(lineItem -> lineItem.calculateTotalAmount() + lineItem.calculateTotalSalesTax())
                .sum();
    }

    private double getWednesdayTotalAmount() {
        return getOriginalTotalAmount() - getWednesdayDiscount();
    }

    public double getWednesdayDiscount() {
        return getOriginalTotalAmount() * WEDNESDAY_DISCOUNT_RATE;
    }
}
