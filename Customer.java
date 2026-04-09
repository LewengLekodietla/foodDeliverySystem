//Customer class: Represents the customer entity in the system.
public class Customer {

    String customerName;
    String customerContactNumber;
    String customerAddress;
    String customerCity;
    String customerEmail;

    //Constructor for the Customer class.
    public Customer(String customerName, String customerContactNumber, String customerAddress, String customerCity, String customerEmail) {
        this.customerName = customerName;
        this.customerContactNumber = customerContactNumber;
        this.customerAddress = customerAddress;
        this.customerCity = customerCity;
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(String customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }


}
