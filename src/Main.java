public class Main {
    public static void main(String[] args) {
        MenuItem beshbarmak = new MenuItem("Бешбармак", 6);
        MenuItem quirdaq = new MenuItem("Куырдак", 9);
        MenuItem sprite = new MenuItem("Спрайт 0,5", 2);
        MenuItem greeceSalad = new MenuItem("Греческий салат", 5);
        MenuItem moroccoTea = new MenuItem("Марроканский чай", 3);
        MenuItem bread = new MenuItem("Лепешка свежая", 1);

        Order order1 = new Order(1);
        order1.addItem(beshbarmak);
        order1.addItem(greeceSalad);
        order1.addItem(sprite);

        Order order2 = new Order(2);
        order2.addItem(quirdaq);
        order2.addItem(bread);
        order2.addItem(moroccoTea);

        Product[] products = new Product[] {
                beshbarmak, quirdaq, greeceSalad, sprite,
                order1, order2
        };

        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("Заказы одиннаковы?:" + order1.equals(order2));
    }
}