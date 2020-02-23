package cc.xpbootcamp.warmup.cashier;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class OrderReceipt {

    private static final String ORDERS_HEADERS = "===== 老王超市,值得信赖 ======\n";
    private static final String BLANK_LINE_SPACING = "\n";
    private static final DateTimeFormatter ORDER_CREATED_DATE_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy年M月dd日,E\n", Locale.CHINA);
    private static final String HYPHEN_LINE_SPACING = "-----------------------------------\n";
    private static final String TOTAL_SALES_TAX_FORMATTER = "税额: %.2f\n";
    private static final String TOTAL_DISCOUNT_FORMATTER = "折扣: %.2f\n";
    private static final String TOTAL_AMOUNT_FORMATTER = "总价: %.2f\n";

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