package gui;

import data.Account;
import data.BankStaff;
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

    private void setUpListeners() {

        //CUSTOMER EVENTS

        ATMAccountIdTxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateAccount();
            }

            private void validateAccount() {

                String input = ATMAccountIdTxt.getText().trim();

                // Check if input is empty
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPanel, "Error: Account ID cannot be empty!");
                    return;
                }

                try {

                    int accountId = Integer.parseInt(input);

                    // Check if account exists
                    Account account = findAccount(accountId);
                    if (account != null) {
                        ATMAccountIdTxt.setEditable(false); // Disable text field after validation
                        radioButtonPnl.setVisible(true);
                        depositAccountRadioButton.setSelected(true);

                        ButtonsPnl.setVisible(true);

                    } else {

                        JOptionPane.showMessageDialog(rootPanel, "Error: Account not found!");
                    }
                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(rootPanel, "Error: Enter a valid numeric Account ID!");
                }

            }

            private Account findAccount(int accountId) {

                for (Account acc : thomondAccounts) {
                    if (acc.getId() == accountId) {
                        return acc; // Account found
                    }
                }

                return null;
            }
        });

        //BANK OFFICER EVENTS

        createNewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                accountCreationTabPane.setVisible(true);
                changeAIRTabPane.setVisible(false);
                overDraftTabPane.setVisible(false);

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

    //
//    // Main class to manage the application
//    public class ThomondBank {
//        static ArrayList<Account> thomondAccounts = new ArrayList<>();
//        static ArrayList<BankStaff> thomondStaff = new ArrayList<>();
//
//        public static void main(String[] args) {
//            SwingUtilities.invokeLater(() -> new Thomond_Bank());
//        }
//    }
//
//    // GUI Class
//    public class Thomand_Bank extends JFrame {
//        private JPanel rootPanel;
//        private JTextField ATMAccountIdTxt, amountField;
//        private JTextArea displayArea;
//
//        public Thomond_Bank() {
//            setTitle("Thomond Bank GUI");
//            setSize(500, 400);
//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            setLayout(new FlowLayout());
//
//            add(new JLabel("Customer No:"));
//            ATMAccountIdTxt = new JTextField(10);
//            add(ATMAccountIdTxt);
//
//            add(new JLabel("Amount:"));
//            amountField = new JTextField(10);
//            add(amountField);
//
//            JButton depositButton = new JButton("Deposit");
//            JButton withdrawButton = new JButton("Withdraw");
//            JButton checkBalanceButton = new JButton("Check Balance");
//
//            add(depositButton);
//            add(withdrawButton);
//            add(checkBalanceButton);
//
//            displayArea = new JTextArea(5, 30);
//            add(new JScrollPane(displayArea));
//
//            depositButton.addActionListener(e -> depositMoney());
//            withdrawButton.addActionListener(e -> withdrawMoney());
//            checkBalanceButton.addActionListener(e -> checkBalance());
//
//            setVisible(true);
//        }

//        private Account findAccount(int custNo) {
//            for (Account acc : ThomondBank.thomondAccounts) {
//                if (acc.getCustNo() == custNo) {
//                    return acc;
//                }
//            }
//            return null;
//        }
//
//        private void depositMoney() {
//            int custNo = Integer.parseInt(ATMAccountIdTxt.getText());
//            double amount = Double.parseDouble(amountField.getText());
//            Account account = findAccount(custNo);
//            if (account != null) {
//                account.deposit(amount);
//                displayArea.setText("Deposit successful. New Balance: " + account.getBalance());
//            }
//        }
//
//        private void withdrawMoney() {
//            int custNo = Integer.parseInt(ATMAccountIdTxt.getText());
//            double amount = Double.parseDouble(amountField.getText());
//            Account account = findAccount(custNo);
//            if (account != null) {
//                account.withdraw(amount);
//                displayArea.setText("Withdrawal successful. New Balance: " + account.getBalance());
//            }
//        }
//
//        private void checkBalance() {
//            int custNo = Integer.parseInt(ATMAccountIdTxt.getText());
//            Account account = findAccount(custNo);
//            if (account != null) {
//                displayArea.setText("Balance: " + account.getBalance());
//            }
//        }
//    }



}




