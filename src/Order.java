import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order extends Product {
    private int orderId;
    private List<MenuItem> items;

    public Order(int orderId) {
        super("Order #" + orderId);
        this.orderId = orderId;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        this.items.add(item);
    }

    public double getPrice() {
        double sum = 0;
        for (MenuItem item : items) {
            sum += item.getPrice();
        }
        return sum;
    }
    public String toString() {
        return "Order #" + orderId + ", Items: " + items.size() + ", Total Price: $" + getPrice();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        return orderId == order.orderId && Objects.equals(items, order.items);
    }

    public int hashCode() {
        return Objects.hash(orderId, items);
    }
}