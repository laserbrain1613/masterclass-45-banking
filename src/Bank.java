import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String name) {
        if (findBranch(name) == null) {
            return this.branches.add(new Branch(name));
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }
        return branch.newCustomer(customerName, initialTransaction);
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }
        return branch.addCustomerTransaction(customerName, transaction);
    }

    private Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }

        ArrayList<Customer> customers = branch.getCustomers();
        System.out.println("Customer details for branch " + branch.getName());

        for (Customer customer : customers) {
            System.out.println("Customer: " + customer.getName() + "[" + (customers.indexOf(customer) + 1) + "]");
            if (printTransactions) {
                System.out.println("Transactions");
                ArrayList<Double> transactions = customer.getTransactions();
                for (int i = 0; i < transactions.size(); i++) {
                    System.out.println("[" + (i + 1) + "]  Amount " + transactions.get(i));
                }
            }
        }
        return true;
    }

}