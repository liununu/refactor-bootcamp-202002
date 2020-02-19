package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class OrderReceipt {
    private static final String ORDERS_HEADERS = "===== 老王超市,值得信赖 ======\n";
    private static final DateTimeFormatter TODAY_DATE_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy年M月dd日,E\n", Locale.CHINA);
    private static final String TOTAL_AMOUNT_TITLE = "Total Amount\t";
    private static final String TOTAL_SALES_TAX_FORMATTER = "税额: %.2f\n";
    private static final String BLANK_LINE_SPACING = "\n";
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        printHeaders(output);

        printTodayDateInfo(output);

        printLineItems(output);

        printTotalSalesTax(output);

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

    private void printTotalSalesTax(StringBuilder output) {
        output.append(String.format(TOTAL_SALES_TAX_FORMATTER, order.getTotalSalesTax()));
    }

    private void printTodayDateInfo(StringBuilder output) {
        output.append(LocalDateTime.now().format(TODAY_DATE_FORMATTER)).append(BLANK_LINE_SPACING);
    }

    private void printHeaders(StringBuilder output) {
        output.append(ORDERS_HEADERS).append(BLANK_LINE_SPACING);
    }
}