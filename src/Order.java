public class Order extends Product {
    private int orderId;
    private MenuItem item;
    private int quantity;

    public Order(int orderId, MenuItem item, int quantity) {
        super(item.getName());
        if (quantity <= 0) {
            throw new IllegalArgumentException("квантити должно быть натуральным числом");
        }
        this.orderId = orderId;
        this.item = item;
        this.quantity = quantity;
    }

    public double getPrice() {
        return item.getPrice() * quantity;
    }

    public String toString() {
        return "Order #" + orderId +
                ", Item: " + item.getName() +
                ", Quantity: " + quantity +
                ", Total: $" + getPrice();
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Order order = (Order) obj;
        return orderId == order.orderId && item.equals(order.item) && quantity == order.quantity;
    }

    public int hashCode() {
        return super.hashCode() + Integer.hashCode(orderId) + item.hashCode() + Integer.hashCode(quantity);
    }
}
