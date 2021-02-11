import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialTransaction) {
        if (findCustomer(customerName) != null) { // Will not add duplicate customer name
            return false;
        }
        return customers.add(new Customer(customerName, initialTransaction));
    }

    public boolean addCustomerTransaction(String customerName, double transaction) {
        Customer customer = findCustomer(customerName);
        if (customer == null) { // Cannot add transaction to a customer that doesn't exist
            return false;
        }
        customer.addTransaction(transaction);
        return true;
    }

    private Customer findCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

}