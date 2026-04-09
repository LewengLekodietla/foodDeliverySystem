import java.io.*;

// InvoiceGenerator class: Responsible for generating invoices for customers.
public class InvoiceGenerator {
    // Method: Generates an invoice for the given order and driver.
    public void generateInvoice(Order order, Driver driver) throws IOException {
        String fileName = "invoice.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            if (driver == null) {
                // If no driver is available for the customer's location.
                writer.write("Sorry! Our drivers are too far away from you to be able to deliver to your location.\n");
            } else {
                // Formatting invoice with blank lines for readability
                writer.write("\nOrder number: " + order.getOrderNumber() + "\n\n");
                writer.write("Customer: " + order.getCustomer().getCustomerName() + "\n");
                writer.write("Email: " + order.getCustomer().getCustomerEmail() + "\n");
                writer.write("Phone number: " + order.getCustomer().getCustomerContactNumber() + "\n\n");

                // Normalize the city name to Title Case before writing
                String normalizedCity = toTitleCase(order.getCustomer().getCustomerCity());
                writer.write("Location: " + normalizedCity + "\n\n");

                writer.write("You have ordered the following from " + order.getRestaurant().getRestaurantName() +
                        " in " + toTitleCase(order.getRestaurant().getRestaurantLocation()) + ":\n\n");

                for (String meal : order.getMeals().keySet()) {
                    writer.write(order.getMeals().get(meal) + " x " + meal + " (R" + order.getMealPrices().get(meal) + ")\n");
                }

                writer.write("\nSpecial instructions: " + order.getSpecialInstructions() + "\n\n");
                writer.write("Total: R" + order.getTotalAmount() + "\n\n");

                writer.write(driver.getName() + " is nearest to the restaurant and so he will be delivering your order to you at:\n\n");
                writer.write(order.getCustomer().getCustomerAddress() + "\n\n");

                writer.write("If you need to contact the restaurant, their number is " +
                        order.getRestaurant().getRestaurantContactNumber() + ".\n");
            }
        }
    }

    // Helper method: Convert string to Title Case
    private String toTitleCase(String input) {
        if (input == null || input.isEmpty()) return input;
        String[] words = input.toLowerCase().split(" ");
        StringBuilder titleCase = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                titleCase.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
        }
        return titleCase.toString().trim();
    }
}