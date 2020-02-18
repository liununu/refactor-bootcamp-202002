package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private static final String ORDERS_HEADERS = "===== 老王超市,值得信赖 ======\n";
    private static final DateTimeFormatter TODAY_DATE_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy年M月dd日,E\n", Locale.CHINA);
    private static final String TOTAL_AMOUNT_TITLE = "Total Amount\t";
    private static final String SALES_TAX_TITLE = "Sales Tax\t";
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        printHeaders(output);

        printTodayDateInfo(output);

        printCustomerInfo(output);

        printLineItems(output);

        printSalesTax(output);

        printTotalAmount(output);

        return output.toString();
    }

    private void printLineItems(StringBuilder output) {
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem);
        }
    }

    private void printTotalAmount(StringBuilder output) {
        output.append(TOTAL_AMOUNT_TITLE).append(order.getTotalAmount());
    }

    private void printSalesTax(StringBuilder output) {
        output.append(SALES_TAX_TITLE).append(order.getTotalSalesTax());
    }

    private void printCustomerInfo(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

    private void printTodayDateInfo(StringBuilder output) {
        output.append(LocalDateTime.now().format(TODAY_DATE_FORMATTER));
    }

    private void printHeaders(StringBuilder output) {
        output.append(ORDERS_HEADERS);
    }
}