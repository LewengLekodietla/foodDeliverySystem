// Contains the Driver class to represent drivers’ information.
public class Driver {

    String name;
    String city;
    int load;

    // Constructor for the Driver class.
    public Driver(String name, String city, int load) {
        this.name = name;
        this.city = city;
        this.load = load;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Method: Increments the driver's load count after the driver is assigned a new delivery
    public void incrementLoad() {
        this.load++; // Increase the current load by 1
    }
}