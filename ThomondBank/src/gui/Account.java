package gui;

import java.time.LocalDate;

// Abstract Account class
abstract class Account {
    protected int id;
    protected int custNo;
    protected double balance;
    protected LocalDate dateCreated;

    public Account(int id, int custNo, double balance) {
        this.id = id;
        this.custNo = custNo;
        this.balance = balance;
        this.dateCreated = LocalDate.now();
    }

    public Account(int id, int custNo) {
    }


    public abstract void withdraw(double amount);
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public int getId() { return id; }
    public int getCustNo() { return custNo; }
    public double getBalance() { return balance; }
    public LocalDate getDateCreated() { return dateCreated; }
}
