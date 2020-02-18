package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk\t10.0\t2\t20.0\n"));
        assertThat(output, containsString("biscuits\t5.0\t5\t25.0\n"));
        assertThat(output, containsString("chocolate\t20.0\t1\t20.0\n"));
        assertThat(output, containsString("Sales Tax\t6.5"));
        assertThat(output, containsString("Total Amount\t71.5"));
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
}