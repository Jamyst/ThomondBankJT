package main;

import data.Account;
import data.BankStaff;
import data.CurrentAccount;
import data.DepositAccount;
import gui.Thomond_Bank_GUI;

import javax.swing.*;
import static gui.Thomond_Bank_GUI.thomondAccounts;

public class ThomondBank {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Thomand Bank ATM");
        frame.setContentPane(new Thomond_Bank_GUI().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        populateMyAccounts();

    }

    private static void populateMyAccounts() {

        thomondAccounts.add(new DepositAccount(1, 1, 0));
        thomondAccounts.get(0).deposit(100);
        thomondAccounts.add(new DepositAccount(2, 2, 0));
        thomondAccounts.get(1).deposit(500);
        thomondAccounts.add(new DepositAccount(3, 3, 0));
        thomondAccounts.get(2).deposit(300);
        thomondAccounts.add(new CurrentAccount(4, 4, 0));
        thomondAccounts.get(3).deposit(300);
    }

    public static Account getAccountById(int custNo) {
        return Account.findAccount(custNo, thomondAccounts);  // Call findAccount from Account class
    }


}