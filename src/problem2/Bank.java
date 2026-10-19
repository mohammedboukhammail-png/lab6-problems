package problem2;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;
    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }
    public boolean addCustomer(String customerName) {
        for (Customer c : customers) {
            if (c.getName().equals(customerName)) {
                System.out.println("Customer " + customerName + " already exists.");
                return false; 
            }
        }
        customers.add(new Customer(customerName));
        return true;
    }
    public void addTransaction(String customerName, double amount) {
        for (Customer c : customers) {
            if (c.getName().equals(customerName)) {
                c.addTransaction(amount);
                return;
            }
        }
        System.out.println("Transaction failed: Customer " + customerName + " not found.");
    }
    public void printStatement(String customerName) {
        for (Customer c : customers) {
            if (c.getName().equals(customerName)) {
                System.out.println("Statement for " + c.getName() + ":");
                ArrayList<Double> transactions = c.getTransactions();
                
                for (int i = 0; i < transactions.size(); i++) {
                    double amount = transactions.get(i); 
                    System.out.println("Transaction " + (i + 1) + ": " + amount);
                }
                return;
            }
        }
        System.out.println("Cannot print statement: Customer " + customerName + " not found.");
    }
}