package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDateTime;
import java.util.List;

import static cc.xpbootcamp.warmup.cashier.constant.CalculateRateConstant.WEDNESDAY_DISCOUNT_RATE;
import static java.time.DayOfWeek.WEDNESDAY;

public class Order {

    private static final int NO_DISCOUNT = 0;
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
        return isTodayWednesday() ? getWednesdayTotalAmount() : getOriginalTotalAmount();
    }

    private double getOriginalTotalAmount() {
        return lineItems.stream()
                .mapToDouble(lineItem -> lineItem.calculateTotalAmount() + lineItem.calculateTotalSalesTax())
                .sum();
    }

    private double getWednesdayTotalAmount() {
        return getOriginalTotalAmount() - getWednesdayDiscount();
    }

    public double getDiscount() {
        return isTodayWednesday() ? getWednesdayDiscount() : NO_DISCOUNT;
    }

    private double getWednesdayDiscount() {
        return getOriginalTotalAmount() * WEDNESDAY_DISCOUNT_RATE;
    }

    public boolean isDiscounted() {
        return getDiscount() != NO_DISCOUNT;
    }

    private boolean isTodayWednesday() {
        return LocalDateTime.now().getDayOfWeek() == WEDNESDAY;
    }
}
