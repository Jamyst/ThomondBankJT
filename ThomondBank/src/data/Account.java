package data;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected int id;
    protected int custNo;
    protected double balance;
    protected LocalDate dateCreated;
    private final List<Transactions> transactionHistory = new ArrayList<>();

    public Account(int id, int custNo, double balance) {
        this.id = id;
        this.custNo = custNo;
        this.balance = balance;
        this.dateCreated = LocalDate.now();
    }


    public static Account findAccount(int custNo, ArrayList<Account> accounts) {
        for (Account acc : accounts) {
            if (acc.getCustNo() == custNo) {
                return acc;
            }
        }
        return null;
    }


    public abstract void withdraw(double amount);

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }

    }

    public int getId() {
        return id; }

    public int getCustNo() {
        return custNo; }

    public double getBalance() {
        return balance; }

    public LocalDate getDateCreated() {
        return dateCreated; }

    public void addTransaction(String type, double amount) {
        Transactions transaction = new Transactions(type, amount);
        transactionHistory.add(transaction);
    }
    public List<Transactions> getTransactionHistory() {
        return transactionHistory;
    }
}


