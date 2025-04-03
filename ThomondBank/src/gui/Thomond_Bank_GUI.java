package gui;

import data.Account;
import data.BankStaff;
import data.CurrentAccount;
import data.DepositAccount;
import main.ThomondBank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Thomond_Bank_GUI {
    public JPanel rootPanel;
    private JPanel userInfoPnl;
    private JTabbedPane userMenuTabPane;
    private JPanel bankOfficerPnl;
    private JPanel userInfoManagerPnl;
    private JPanel atmUserPnl;
    private JTextField ATMAccountIdTxt;
    private JRadioButton depositAccountRadioButton;
    private JRadioButton currentAccountRadioButton;
    private JPanel radioButtonPnl;
    private JPanel ButtonsPnl;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton checkBalanceButton;
    private JButton logoutButton;
    private JPanel OfficerbuttonsPnl;
    private JButton createNewAccountButton;
    private JButton changeAIRButton;
    private JButton changeOverdraftLimitButton;
    private JTabbedPane accountCreationTabPane;
    private JPanel NewAccountPnl;
    private JRadioButton depositRadioButton;
    private JRadioButton currentRadioButton;
    private JLabel accountTypeLbl;
    private JTextField accountIdTxt;
    private JLabel accountIdLbl;
    private JButton addNewAccountButton;
    private JTextField overdraftTxt;
    private JLabel overdraftLbl;
    private JTabbedPane changeAIRTabPane;
    private JPanel changeAirPnl;
    private JRadioButton AIRDepositBtn;
    private JRadioButton AIRCurrentBtn;
    private JLabel AIRAccTypeLbl;
    private JLabel AIRLbl;
    private JLabel NewAIRLbl;
    private JTextField AIRTxt;
    private JTextField newAIRTxt;
    private JButton changeAIRBtn;
    private JTabbedPane overDraftTabPane;
    private JTextField overdraftAccIdTxt;
    private JPanel overdraftDetailsPnl;
    private JTextField overdraftLimitTxt;
    private JTextField newOverdraftLimitTxt;
    private JButton changeOverdraftLimitButton1;
    private JPanel ChangeOverdraftPnl;
    private JLabel overdraftAccIdLbl;
    private JLabel overdraftLimitLbl;
    private JLabel newOverdraftLimitLbl;
    private JLabel ATMAccountIdLbl;
    private JPanel bankManagerPnl;
    private JButton createBankOfficerButton;
    private JButton listAllStaffButton;

    public static ArrayList<Account> thomondAccounts = new ArrayList<>();
    static ArrayList<BankStaff> thomondStaff = new ArrayList<>();


    public Thomond_Bank_GUI() {

        ButtonsPnl.setVisible(false);
        radioButtonPnl.setVisible(false);
        accountCreationTabPane.setVisible(false);
        changeAIRTabPane.setVisible(false);
        overDraftTabPane.setVisible(false);

        setUpListeners();


    }

    //Method for action listeners

    private void setUpListeners() {

        //Customer Actions:

        //Customer Account Verification

        ATMAccountIdTxt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                validateAccount();
            }

            public void validateAccount() {
                String input = ATMAccountIdTxt.getText().trim();

                try {

                    int accountId = Integer.parseInt(input);

                    Account account = ThomondBank.getAccountById(accountId);

                    if (account != null) {
                        ATMAccountIdTxt.setEditable(false);
                        radioButtonPnl.setVisible(true);
                        ButtonsPnl.setVisible(true);

                        if (account instanceof DepositAccount) {
                            depositAccountRadioButton.setSelected(true);

                        } else{
                            currentAccountRadioButton.setSelected(true);
                        }
                    }

                    else{
                        JOptionPane.showMessageDialog(rootPanel, "Account not found");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPanel, "Error: Enter a valid numeric Account ID!");
                }


            }
        });


        //Customer Deposit Button

        depositButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                depositMoney();
            }

            public void depositMoney() {
                int accountId = Integer.parseInt(ATMAccountIdTxt.getText().trim());
                String amountInput = JOptionPane.showInputDialog("Enter deposit amount:");

                try {

                    if (amountInput.isEmpty()) {
                        JOptionPane.showMessageDialog(rootPanel,
                                "Error: Deposit amount cannot be empty!");
                        return;
                    }

                    double amount = Double.parseDouble(amountInput);

                    Account account = ThomondBank.getAccountById(accountId);

                    if (account != null) {
                        if (amount > 0) {
                            account.deposit(amount);
                            JOptionPane.showMessageDialog(rootPanel,
                                    "Updated Balance: €" + account.getBalance());

                        } else {
                            JOptionPane.showMessageDialog(rootPanel,
                                    "Error: Enter a positive deposit amount!");
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPanel,
                            "Error: Enter a valid numeric amount to deposit!");
                }
            }
        });


        //Customer Check Balance Button

        checkBalanceButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                checkBalance();
            }

            public void checkBalance() {
                int accountId = Integer.parseInt(ATMAccountIdTxt.getText().trim());

                    Account account = ThomondBank.getAccountById(accountId);

                    if (account != null) {
                        JOptionPane.showMessageDialog(rootPanel,
                                "Account ID: " + accountId + " | Balance: €" + account.getBalance());
                    }
                }
        });

        //Customer Withdraw Button

        withdrawButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                withdrawMoney();
            }

            public void withdrawMoney() {


                try {


                    String input = ATMAccountIdTxt.getText().trim();

                    int accountId = Integer.parseInt(input);
                    Account account = ThomondBank.getAccountById(accountId);

                    double amount = Double.parseDouble(JOptionPane.showInputDialog
                            ("Balance: €" + account.getBalance() + " | Enter withdrawal amount"));

                        if (account instanceof DepositAccount) {

                            if (amount <= account.getBalance()) {
                                account.withdraw(amount);
                            } else {
                                JOptionPane.showMessageDialog(rootPanel,
                                        "Error: Amount exceeds available balance!");
                            }

                        }

                        else if(account instanceof CurrentAccount) {
                            CurrentAccount currentAcc = (CurrentAccount) account;
                            double maxWithdrawable = account.getBalance() + currentAcc.getOverdraft();

                            if (amount <= maxWithdrawable) {
                                account.withdraw(amount);
                            } else {
                                JOptionPane.showMessageDialog(rootPanel,
                                        "Error: Amount exceeds available balance!");
                            }

                        }


                    if(amount > 0) {
                        JOptionPane.showMessageDialog(rootPanel,
                                "Updated balance: €" + account.getBalance());

                    }
                    else {
                    JOptionPane.showMessageDialog(rootPanel,
                            "Error: Enter a positive withdrawal amount!");
                    }


                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPanel,
                            "Error: Enter a valid numeric withdrawal amount!");
                }
            }
        });


        //Customer Log out button

        logoutButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }

            public void logout() {

                int confirm = JOptionPane.showConfirmDialog(rootPanel, "Are you sure you want to log out?",
                        "Logout Confirmation", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    ATMAccountIdTxt.setText("");

                    ATMAccountIdTxt.setEditable(true);

                    radioButtonPnl.setVisible(false);
                    ButtonsPnl.setVisible(false);

                    JOptionPane.showMessageDialog(rootPanel,
                            "You have been logged out successfully.");
                }
            }
        });





        //BANK OFFICER EVENTS

        //Bank Officer 'Create Account' Panel Button

        createNewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                accountCreationTabPane.setVisible(true);
                changeAIRTabPane.setVisible(false);
                overDraftTabPane.setVisible(false);
                overdraftLbl.setVisible(false);
                overdraftTxt.setVisible(false);
                currentRadioButton.setSelected(false);
                depositRadioButton.setSelected(false);


            }
        });

        currentRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                overdraftLbl.setVisible(true);
                overdraftTxt.setVisible(true);

            }
        });


        //Bank Officer Add Account Button

        addNewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewAccount();
            }

            public void createNewAccount() {
                String accountIdInput = accountIdTxt.getText().trim();
                String overdraftInput = overdraftTxt.getText().trim();

                try {

                    int accountId = Integer.parseInt(accountIdInput);

                    for (Account acc : Thomond_Bank_GUI.thomondAccounts) {
                        if (acc.getId() == accountId) {
                            JOptionPane.showMessageDialog(rootPanel,
                                    "Error: Account ID already exists!");
                        }
                    }


                    if (depositRadioButton.isSelected()) {
                        overdraftLbl.setVisible(false);
                        overdraftTxt.setVisible(false);

                        DepositAccount newAccount = new DepositAccount(accountId, accountId, 0.0);
                        Thomond_Bank_GUI.thomondAccounts.add(newAccount);
                        JOptionPane.showMessageDialog(rootPanel,
                                "Deposit Account created successfully!");

                    } else if (currentRadioButton.isSelected()) {

                        if (overdraftInput.isEmpty()) {
                            JOptionPane.showMessageDialog(rootPanel,
                                    "Error: Please enter an overdraft limit for Current Account!");
                        }

                        try {

                            double overdraftLimit = Double.parseDouble(overdraftInput);

                            if (overdraftLimit < 0) {
                                JOptionPane.showMessageDialog(rootPanel,
                                        "Error: Overdraft limit cannot be negative!");
                            }

                            // Create a Current Account
                            CurrentAccount newAccount = new CurrentAccount(accountId, accountId,
                                    0.0, overdraftLimit);
                            Thomond_Bank_GUI.thomondAccounts.add(newAccount);
                            JOptionPane.showMessageDialog(rootPanel,
                                    "Current Account created successfully!");

                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(rootPanel,
                                    "Error: Enter a valid numeric overdraft limit!");
                        }

                    } else {
                        JOptionPane.showMessageDialog(rootPanel, "Error: Please select an account type!");
                    }

                    accountIdTxt.setText("");
                    overdraftTxt.setText("");
                    currentRadioButton.setSelected(false);
                    depositRadioButton.setSelected(false);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPanel, "Error: Enter a valid numeric Account ID!");
                }
            }
        });



        changeAIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                accountCreationTabPane.setVisible(false);
                changeAIRTabPane.setVisible(true);
                overDraftTabPane.setVisible(false);

            }
        });

        changeOverdraftLimitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                accountCreationTabPane.setVisible(false);
                changeAIRTabPane.setVisible(false);
                overDraftTabPane.setVisible(true);

            }
        });

    }


}




