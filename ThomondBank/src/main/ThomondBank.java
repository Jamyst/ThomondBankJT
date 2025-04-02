package main;

import data.Account;
import data.BankStaff;
import data.DepositAccount;
import gui.Thomond_Bank_GUI;

import javax.swing.*;
import java.util.ArrayList;

import static gui.Thomond_Bank_GUI.thomondAccounts;

//public class Thomond extends javax.swing.JFrame {
//    public static ArrayList<Account> thomondAccounts = new ArrayList<>();
//
//    public Thomond() {
////        populateMyAccounts();
//
//    }
//
////    private void populateMyAccounts() {
////        // used to populate myAccounts ArrayList with test data
////        thomondAccounts.add(new DepositAccount(1, 1));
////        thomondAccounts.get(0).deposit(100);
////        thomondAccounts.add(new DepositAccount(2, 2));
////        thomondAccounts.get(1).deposit(500);
////        thomondAccounts.add(new DepositAccount(3, 3));
////        thomondAccounts.get(2).deposit(300);
////        thomondAccounts.add(new DepositAccount(4, 4));
////        thomondAccounts.get(3).deposit(300);
////    }
//
//}

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
        thomondAccounts.add(new DepositAccount(4, 4, 0));
        thomondAccounts.get(3).deposit(300);
    }


}