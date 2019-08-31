package arrays.autoboxing_unboxing.banking_app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Bank {
    private String name;
    private List<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        return branches.stream()
                .filter(branch -> branchName.equals(branch.getName()))
                .findAny()
                .orElse(null);
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        AtomicInteger customerIndex = new AtomicInteger();
        if (branch != null) {
            System.out.println("Customer details for branch: " + branch.getName());
            branch.getCustomers().forEach(customer -> {
                System.out.println("\tCustomer: " + customer.getName() + " [" + customerIndex.incrementAndGet() + "]");
                if (showTransactions) {
                    AtomicInteger transactionIndex = new AtomicInteger();
                    System.out.println("\t  Transactions:");
                    customer.getTransactions().forEach(transaction -> {
                        System.out.println("\t\t[" + transactionIndex.incrementAndGet() + "] Amount: " + transaction);
                    });
                }
            });
            return true;
        }
        return false;
    }
}
