public class MenuItem extends Product {
    private double price;

    public MenuItem(String name, double price) {
        super(name);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return getName() + " - $" + price;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        MenuItem menuItem = (MenuItem) obj;
        return Double.compare(menuItem.price, price) == 0;
    }

    public int hashCode() {
        return super.hashCode() + Double.hashCode(price);
    }
}
