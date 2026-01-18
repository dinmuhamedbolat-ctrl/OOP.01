import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "0000";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        int totalSum = 0;
        HashMap<String, Integer> orderMap = new HashMap<>();

        while (true) {
            System.out.println("\n--- МЕНЮ ---");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM restaraunt ORDER BY id ASC");

            while (result.next()) {
                System.out.println(result.getInt("id") + ". " + result.getString("name") + " — " + result.getInt("price") + "$");
            }

            System.out.println("\nВведите номер блюда чтобы добавть в ваш заказ (или 0 для завершения заказа):");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("\nВаш чек");

                if (orderMap.isEmpty()) {
                    System.out.println(" ");
                } else {
                    for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
                        System.out.println(entry.getKey() + " - " + entry.getValue() + " шт.");
                    }
                }

                System.out.println("Общая сумма  " + totalSum + "$");
                connection.close();
                break;
            } else {
                PreparedStatement ps = connection.prepareStatement("SELECT name, price FROM restaraunt WHERE id = ?");
                ps.setInt(1, choice);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String name = rs.getString("name");
                    int price = rs.getInt("price");

                    totalSum += price;
                    orderMap.put(name, orderMap.getOrDefault(name, 0) + 1);

                    System.out.println(name + " добавлен. Текущая сумма: " + totalSum + "$");
                } else {
                    System.err.println("такого блюда " + choice + " не существует.");
                }
            }
        }
    }
}