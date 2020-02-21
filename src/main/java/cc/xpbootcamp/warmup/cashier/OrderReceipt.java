package cc.xpbootcamp.warmup.cashier;

import static cc.xpbootcamp.warmup.cashier.constant.OrderReceiptStyleConstant.*;

public class OrderReceipt {

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        return generateHeaders()
                .append(generateOrderCreatedDateInfo())
                .append(generateLineItems())
                .append(generateTotalSalesTax())
                .append(generateTotalDiscount())
                .append(generateTotalAmount())
                .toString();
    }

    private StringBuilder generateLineItems() {
        StringBuilder builder = new StringBuilder();
        order.getLineItems().forEach(builder::append);
        builder.append(HYPHEN_LINE_SPACING);
        return builder;
    }

    private StringBuilder generateTotalDiscount() {
        StringBuilder builder = new StringBuilder();
        if (order.isDiscounted()) {
            builder.append(String.format(TOTAL_DISCOUNT_FORMATTER, order.getDiscount()));
        }
        return builder;
    }

    private StringBuilder generateTotalAmount() {
        return new StringBuilder()
                .append(String.format(TOTAL_AMOUNT_FORMATTER, order.getTotalAmount()));
    }

    private StringBuilder generateTotalSalesTax() {
        return new StringBuilder()
                .append(String.format(TOTAL_SALES_TAX_FORMATTER, order.getTotalSalesTax()));
    }

    private StringBuilder generateOrderCreatedDateInfo() {
        return new StringBuilder()
                .append(order.getCreatedDate().format(ORDER_CREATED_DATE_FORMATTER))
                .append(BLANK_LINE_SPACING);
    }

    private StringBuilder generateHeaders() {
        return new StringBuilder().append(ORDERS_HEADERS).append(BLANK_LINE_SPACING);
    }
}