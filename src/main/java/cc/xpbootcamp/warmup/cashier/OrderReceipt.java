package cc.xpbootcamp.warmup.cashier;

import static cc.xpbootcamp.warmup.cashier.constant.OrderReceiptStyleConstant.*;

public class OrderReceipt {

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        printHeaders(output);

        printOrderCreatedDateInfo(output);

        printLineItems(output);

        printTotalSalesTax(output);

        printTotalDiscount(output);

        printTotalAmount(output);

        return output.toString();
    }

    private void printLineItems(StringBuilder output) {
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem);
        }
        output.append(HYPHEN_LINE_SPACING);
    }

    private void printTotalDiscount(StringBuilder output) {
        if (order.isDiscounted()) {
            output.append(String.format(TOTAL_DISCOUNT_FORMATTER, order.getDiscount()));
        }
    }

    private void printTotalAmount(StringBuilder output) {
        output.append(String.format(TOTAL_AMOUNT_FORMATTER, order.getTotalAmount()));
    }

    private void printTotalSalesTax(StringBuilder output) {
        output.append(String.format(TOTAL_SALES_TAX_FORMATTER, order.getTotalSalesTax()));
    }

    private void printOrderCreatedDateInfo(StringBuilder output) {
        output.append(order.getCreatedDate().format(ORDER_CREATED_DATE_FORMATTER)).append(BLANK_LINE_SPACING);
    }

    private void printHeaders(StringBuilder output) {
        output.append(ORDERS_HEADERS).append(BLANK_LINE_SPACING);
    }
}