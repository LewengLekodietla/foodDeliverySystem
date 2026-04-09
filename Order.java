import java.util.*;

//Contains the Order class that encapsulates all order details.
public class Order {

    String orderNumber;
    Customer customer;
    Restaurant restaurant;
    Map<String, Integer> meals; // Meal name and quantity
    Map<String, Double> mealPrices; // Meal name and price
    String specialInstructions;
    double totalAmount;

    // Constructor for the Order class.
    public Order(String orderNumber, Customer customer, Restaurant restaurant, Map<String, Integer> meals,
                 Map<String, Double> mealPrices, String specialInstructions) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.restaurant = restaurant;
        this.meals = meals;
        this.mealPrices = mealPrices;
        this.specialInstructions = specialInstructions;
        this.totalAmount = calculateTotalAmount();
    }
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Map<String, Integer> getMeals() {
        return meals;
    }

    public void setMeals(Map<String, Integer> meals) {
        this.meals = meals;
    }

    public Map<String, Double> getMealPrices() {
        return mealPrices;
    }

    public void setMealPrices(Map<String, Double> mealPrices) {
        this.mealPrices = mealPrices;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    // Method: Calculate the total amount of the order based on meal quantities and prices.
    private double calculateTotalAmount() {
        double total = 0;
        for (String meal : meals.keySet()) {
            total += meals.get(meal) * mealPrices.get(meal);
        }
        return total;
    }
}
