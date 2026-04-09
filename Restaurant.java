// Restaurant class: Represents the restaurant entity in the system.
public class Restaurant {

    String restaurantName;
    String restaurantLocation;
    String restaurantContactNumber;

    // Constructor for the Restaurant class.
    public Restaurant(String restaurantName, String restaurantLocation, String restaurantContactNumber) {
        this.restaurantName = restaurantName;
        this.restaurantLocation = restaurantLocation;
        this.restaurantContactNumber = restaurantContactNumber;
    }
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public String getRestaurantContactNumber() {
        return restaurantContactNumber;
    }

    public void setRestaurantContactNumber(String restaurantContactNumber) {
        this.restaurantContactNumber = restaurantContactNumber;
    }
}
