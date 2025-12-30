public class Main {
    public static void main(String[] args) {
        MenuItem Beshbarmak = new MenuItem("Beshbarmak", 6);
        MenuItem Quirdaq = new MenuItem("Quirdaq", 9);

        Order order1 = new Order(1, Beshbarmak, 2);
        Order order2 = new Order(2, Quirdaq, 1);

        Product[] products = new Product[] { Beshbarmak, Quirdaq, order1, order2 };

        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println(order1.equals(order2));
    }
}
