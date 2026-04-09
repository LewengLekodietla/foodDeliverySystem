import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Initialize DriverManager
            DriverManager driverManager = new DriverManager("drivers.txt");

            // Capture Customer Details
            System.out.println("Enter Customer Details:");
            System.out.print("Name: ");
            String customerName = scanner.nextLine();
            System.out.print("Contact Number: ");
            String customerContactNumber = scanner.nextLine();
            System.out.print("Address: ");
            String customerAddress = scanner.nextLine();
            System.out.print("City: ");
            String customerCity = scanner.nextLine();
            System.out.print("Email: ");
            String customerEmail = scanner.nextLine();
            Customer customer = new Customer(customerName, customerContactNumber, customerAddress, customerCity, customerEmail);

            // Capture Restaurant Details
            System.out.println("\nEnter Restaurant Details:");
            System.out.print("Name: ");
            String restaurantName = scanner.nextLine();
            System.out.print("Location: ");
            String restaurantLocation = scanner.nextLine();
            System.out.print("Contact Number: ");
            String restaurantContactNumber = scanner.nextLine();
            Restaurant restaurant = new Restaurant(restaurantName, restaurantLocation, restaurantContactNumber);

            // Capture Order Details
            System.out.println("\nEnter Order Details:");
            Map<String, Integer> meals = new HashMap<>();
            Map<String, Double> mealPrices = new HashMap<>();

            while (true) {
                System.out.print("Enter meal name (or type 'done' to finish): ");
                String mealName = scanner.nextLine();
                if (mealName.equalsIgnoreCase("done")) {
                    break;
                }

                System.out.print("Enter quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                System.out.print("Enter price per meal: ");
                double price = Double.parseDouble(scanner.nextLine());

                meals.put(mealName, quantity);
                mealPrices.put(mealName, price);
            }

            System.out.print("Special Instructions: ");
            String specialInstructions = scanner.nextLine();

            System.out.print("Order Number: ");
            String orderNumber = scanner.nextLine();

            Order order = new Order(orderNumber, customer, restaurant, meals, mealPrices, specialInstructions);

            // Assign Driver
            Driver assignedDriver = driverManager.assignDriver(customer.customerCity);

            // Generate Invoice
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            if (assignedDriver == null) {
                System.out.println("Sorry! Our drivers are too far away from you to be able to deliver to your location.");
                invoiceGenerator.generateInvoice(order, null);
            } else {
                invoiceGenerator.generateInvoice(order, assignedDriver);
                System.out.println("\nInvoice generated successfully.");
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}