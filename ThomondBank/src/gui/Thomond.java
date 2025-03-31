package gui;

import java.util.ArrayList;

public class Thomond extends javax.swing.JFrame {
    public static ArrayList<Account> thomondAccounts = new ArrayList<>();

    public Thomond() {
        populateMyAccounts();

    }

    private void populateMyAccounts() {
        // used to populate myAccounts ArrayList with test data
        thomondAccounts.add(new DepositAccount(1, 1));
        thomondAccounts.get(0).deposit(100);
        thomondAccounts.add(new DepositAccount(2, 2));
        thomondAccounts.get(1).deposit(500);
        thomondAccounts.add(new DepositAccount(3, 3));
        thomondAccounts.get(2).deposit(300);
        thomondAccounts.add(new DepositAccount(4, 4));
        thomondAccounts.get(3).deposit(300);
    }

}
