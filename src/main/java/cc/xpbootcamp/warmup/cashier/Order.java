package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private String customerName;
    private String customerAddress;
    private List<LineItem> lineItems;

    public Order(String customerName, String customerAddress, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public double getTotalSalesTax() {
        return lineItems.stream().mapToDouble(LineItem::totalSalesTax).sum();
    }

    public double getTotalAmount() {
        return lineItems.stream().mapToDouble(lineItem -> lineItem.totalAmount() + lineItem.totalSalesTax()).sum();
    }
}
