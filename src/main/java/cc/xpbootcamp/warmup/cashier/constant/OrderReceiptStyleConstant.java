package cc.xpbootcamp.warmup.cashier.constant;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class OrderReceiptStyleConstant {
    public static final String ORDERS_HEADERS = "===== 老王超市,值得信赖 ======\n";
    public static final String BLANK_LINE_SPACING = "\n";
    public static final DateTimeFormatter TODAY_DATE_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy年M月dd日,E\n", Locale.CHINA);
    public static final String LINE_ITEM_FORMATTER = "%s, %.2f x %d, %.2f\n";
    public static final String HYPHEN_LINE_SPACING = "-----------------------------------\n";
    public static final String TOTAL_SALES_TAX_FORMATTER = "税额: %.2f\n";
    public static final String TOTAL_DISCOUNT_FORMATTER = "折扣: %.2f\n";
    public static final String TOTAL_AMOUNT_FORMATTER = "总价: %.2f\n";
}
