package main;

import data.*;
import gui.Thomond_Bank_GUI;

import javax.swing.*;
import java.time.LocalDate;

import static gui.Thomond_Bank_GUI.thomondAccounts;
import static gui.Thomond_Bank_GUI.thomondStaff;

public class ThomondBank {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Thomand Bank ATM");
        frame.setContentPane(new Thomond_Bank_GUI().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        populateMyAccounts();
        populateThomondStaff();

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


    private static void populateThomondStaff() {

        thomondStaff.add(new BankOfficer
                ("Alice", "Johnson", "123 St",
                        LocalDate.of(1985, 5, 12), 101, "Loan Officer"));

        thomondStaff.add(new BankOfficer
                ("Bob", "Smith", "456 St",
                        LocalDate.of(1990, 8, 23), 102, "Financial Advisor"));

        thomondStaff.add(new BankOfficer
                ("Charlie", "Brown", "789 St",
                        LocalDate.of(1982, 11, 5), 103, "Account Manager"));

        thomondStaff.add(new BankManager
                ("David", "White", "321 St",
                        LocalDate.of(1975, 3, 17), 201));

        thomondStaff.add(new BankManager
                ("Emma", "Davis", "654 St",
                        LocalDate.of(1980, 7, 30), 202));
    }


    public static Account getAccountById(int custNo) {
        return Account.findAccount(custNo, thomondAccounts);
    }


}