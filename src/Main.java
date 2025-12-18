public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Dinmukhamed's Restaraunt");

        MenuItem Beshbarmak = new MenuItem("Баыурсак", 5.99);
        MenuItem Quirdaq = new MenuItem("Quirdaq", 8.99);

        Order order1 = new Order(1, Beshbarmak, 2);
        Order order2 = new Order(2, Quirdaq, 1);

        restaurant.printRestaurant();

        System.out.println(Beshbarmak);
        System.out.println(Quirdaq);

        System.out.println(order1);
        System.out.println(order2);
        System.out.println(
                Beshbarmak.getPrice() > Quirdaq.getPrice()
                        ? "Quirdaq is cheaper"
                        : "Beshbarmak is cheaper"
        );


    }
}
