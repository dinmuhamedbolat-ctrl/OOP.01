public class Order {
    private int orderId;
    private MenuItem item;
    private int quantity;

    public Order(int orderId, MenuItem item, int quantity) {
        this.orderId = orderId;
        this.item = item;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }

    public String toString() {
        return "Order #" + orderId +
                ", Item: " + item.getName() +
                ", Quantity: " + quantity +
                ", Total: $" + getTotalPrice();
    }
}
