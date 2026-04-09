import java.io.*;
import java.util.*;

// DriverManager class: Manages driver-related operations
public class DriverManager {
    private List<Driver> drivers;

    // Constructor to load drivers from file
    public DriverManager(String filePath) throws IOException {
        this.drivers = loadDrivers(filePath);
    }

    // Loads drivers from the given file and ensures data is trimmed properly
    private List<Driver> loadDrivers(String filePath) throws IOException {
        List<Driver> driverList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(","); // Ensure proper splitting
            parts = Arrays.stream(parts).map(String::trim).toArray(String[]::new); // Trim each part
            if (parts.length == 3) {
                try {
                    String name = parts[0];
                    String city = parts[1];
                    int load = Integer.parseInt(parts[2]);
                    driverList.add(new Driver(name, city, load));
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid driver entry: " + Arrays.toString(parts));
                }
            }
        }
        br.close();
        return driverList;
    }

    // Finds and assigns the driver with the smallest load in the specified city
    public Driver assignDriver(String city) {
        city = city.trim(); // Trim input city for consistent comparison
        Driver assignedDriver = null;
        for (Driver driver : drivers) {
            if (driver.getCity().trim().equalsIgnoreCase(city) &&
                    (assignedDriver == null || driver.getLoad() < assignedDriver.getLoad())) {
                assignedDriver = driver;
            }
        }
        if (assignedDriver != null) {
            assignedDriver.incrementLoad();
        }
        return assignedDriver;
    }
}