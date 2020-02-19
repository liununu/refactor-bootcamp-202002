package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {

    @Test
    public void shouldPrintLineItemInfo() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.00, 2));
            add(new LineItem("biscuits", 5.00, 5));
            add(new LineItem("chocolate", 20.00, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk, 10.00 x 2, 20.00\n"));
        assertThat(output, containsString("biscuits, 5.00 x 5, 25.00\n"));
        assertThat(output, containsString("chocolate, 20.00 x 1, 20.00\n"));
    }

    @Test
    void shouldPrintHeader() {
        OrderReceipt receipt = new OrderReceipt(new Order(emptyList()));

        String output = receipt.printReceipt();

        assertThat(output, containsString("===== 老王超市,值得信赖 ======\n"));
    }

    @Test
    void shouldPrintTodayDateInfo() {
        OrderReceipt receipt = new OrderReceipt(new Order(emptyList()));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月dd日,E", Locale.CHINA);

        String output = receipt.printReceipt();

        assertThat(output, containsString(String.format("%s\n", LocalDateTime.now().format(formatter))));
    }

    @Test
    void shouldPrintBlankLineSpacingBetweenHeaderAndTodayDateInfo() {
        OrderReceipt receipt = new OrderReceipt(new Order(emptyList()));
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月dd日,E", Locale.CHINA);

        String output = receipt.printReceipt();

        assertThat(output,
                containsString(
                        "===== 老王超市,值得信赖 ======\n"
                                + "\n"
                                + String.format("%s\n", now.format(formatter))
                )
        );
    }

    @Test
    void shouldPrintBlankLineSpacingBetweenTodayDateInfoAndListItemInfo() {
        OrderReceipt receipt = new OrderReceipt(
                new Order(singletonList(new LineItem("巧克力", 21.50, 2)))
        );
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月dd日,E", Locale.CHINA);

        String output = receipt.printReceipt();

        assertThat(output,
                containsString(
                        String.format("%s\n", now.format(formatter))
                                + "\n"
                                + "巧克力, 21.50 x 2, 43.00\n"
                )
        );
    }

    @Test
    void shouldPrintTotalSalesTax() {
        OrderReceipt receipt = new OrderReceipt(
                new Order(
                        asList(new LineItem("巧克力", 21.50, 2),
                                new LineItem("小白菜", 10.00, 1)))
        );

        String output = receipt.printReceipt();

        assertThat(output, containsString("税额: 5.30\n"));
    }
}