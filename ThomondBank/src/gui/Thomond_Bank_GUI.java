package gui;

import data.*;
import main.ThomondBank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

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
    private JPanel createBankOfficerPnl;
    private JTextField employeeFirstNameTxt;
    private JTextField employeeLastNameTxt;
    private JTextField employeeAddressTxt;
    private JTextField employeeDobTxt;
    private JTextField employeeIdTxt;
    private JTextField jobTitleTxt;
    private JLabel employeeFirstNameLbl;
    private JLabel employeeLastNameLbl;
    private JLabel employeeAddressLbl;
    private JLabel employeeDobLbl;
    private JLabel employeeIdLbl;
    private JLabel jobTitleLbl;
    private JButton createStaffAccountButton;
    private JButton createCustomerButton;
    private JTextField custFirstNameTxt;
    private JTextField custLastNameTxt;
    private JTextField custAddressTxt;
    private JTextField custDobTxt;
    private JTextField custIdTxt;
    private JLabel custFirstNameLbl;
    private JLabel custLastNameLbl;
    private JLabel custAddressLbl;
    private JLabel custDobLbl;
    private JLabel custIdLbl;
    private JPanel createCustomerPnl;
    private JButton customerCreateButton;
    private JButton listAllCustomersButton;
    private JButton allTransactionsButton;
    private JTextField transactionAccountTxt;
    private JLabel transactionAccountIdLbl;
    private JPanel transactionPnl;
    private JButton showTransactionBtn;

    public static ArrayList<Account> thomondAccounts = new ArrayList<>();
    public static ArrayList<BankStaff> thomondStaff = new ArrayList<>();
    public static ArrayList<Customer> thomondCustomers = new ArrayList<>();


    public Thomond_Bank_GUI() {

        ButtonsPnl.setVisible(false);
        radioButtonPnl.setVisible(false);
        accountCreationTabPane.setVisible(false);
        changeAIRTabPane.setVisible(false);
        overDraftTabPane.setVisible(false);
        createBankOfficerPnl.setVisible(false);
        createCustomerPnl.setVisible(false);
        transactionPnl.setVisible(false);

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
                                account.addTransaction("Deposit", amount);

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
                                return;
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
                                return;
                            }

                        }


                    if(amount > 0) {
                        JOptionPane.showMessageDialog(rootPanel,
                                "Updated balance: €" + account.getBalance());
                                account.addTransaction("Withdrawal", amount);

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
                createCustomerPnl.setVisible(false);
                transactionPnl.setVisible(false);


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
                            return;
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
                                return;
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
                        JOptionPane.showMessageDialog(rootPanel,
                                "Error: Please select an account type!");
                        return;
                    }

                    accountIdTxt.setText("");
                    overdraftTxt.setText("");
                    currentRadioButton.setSelected(false);
                    depositRadioButton.setSelected(false);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPanel,
                            "Error: Enter a valid numeric Account ID!");
                }
            }
        });


        //Bank Officer 'Change AIR' Panel Button

        changeAIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                accountCreationTabPane.setVisible(false);
                changeAIRTabPane.setVisible(true);
                overDraftTabPane.setVisible(false);
                createCustomerPnl.setVisible(false);
                transactionPnl.setVisible(false);

            }
        });
        

        AIRDepositBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (AIRDepositBtn.isSelected()) {

                    AIRTxt.setText(String.valueOf(DepositAccount.getAIR()));
                }
            }
        });


        AIRCurrentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (AIRCurrentBtn.isSelected()) {

                    AIRTxt.setText(String.valueOf(CurrentAccount.getAIR()));

                }
            }
        });



        //Bank Officer Change AIR Button

        changeAIRBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String newAirInput = newAIRTxt.getText().trim();


                try {

                    if (newAirInput.isEmpty()) {
                        JOptionPane.showMessageDialog(rootPanel,
                                "Error: AIR cannot be empty!");
                        return;
                    }

                    double newAIR = Double.parseDouble(newAirInput);

                    if (newAIR <= 0) {
                        JOptionPane.showMessageDialog(rootPanel,
                                "Error: Enter a valid positive AIR value!");
                        return;
                    }


                    if (AIRDepositBtn.isSelected()) {
                        DepositAccount.setAIR(newAIR);
                        JOptionPane.showMessageDialog(rootPanel,
                                "Deposit Account AIR updated to " + DepositAccount.getAIR());

                    } else if (AIRCurrentBtn.isSelected()) {
                        CurrentAccount.setAIR(newAIR);
                        JOptionPane.showMessageDialog(rootPanel,
                                "Current Account AIR updated to " + newAIR);
                    }

                    AIRTxt.setText("");
                    newAIRTxt.setText("");
                    AIRDepositBtn.setSelected(false);
                    AIRCurrentBtn.setSelected(false);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPanel,
                            "Error: Enter a valid numeric AIR value!");
                }
            }
        });


        //Bank Officer 'Change Overdraft Limit' Panel Button

        changeOverdraftLimitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                accountCreationTabPane.setVisible(false);
                changeAIRTabPane.setVisible(false);
                overDraftTabPane.setVisible(true);
                createCustomerPnl.setVisible(false);
                overdraftLimitTxt.setVisible(false);
                newOverdraftLimitTxt.setVisible(false);
                changeOverdraftLimitButton1.setVisible(false);
                overdraftLimitLbl.setVisible(false);
                newOverdraftLimitLbl.setVisible(false);
                transactionPnl.setVisible(false);

            }
        });


        //Bank Officer Change Overdraft Limit Account Verification

        overdraftAccIdTxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountIdInput = overdraftAccIdTxt.getText().trim();

                if (accountIdInput.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPanel, "Error: Account ID cannot be empty!");
                    return;
                }

                try {
                    int accountId = Integer.parseInt(accountIdInput);
                    Account account = ThomondBank.getAccountById(accountId);


                    if (account == null) {
                        JOptionPane.showMessageDialog(rootPanel, "Error: Account not found!");

                        return;
                    }


                    if (account instanceof CurrentAccount) {
                        CurrentAccount currentAccount = (CurrentAccount) account;

                        overdraftLimitTxt.setVisible(true);
                        newOverdraftLimitTxt.setVisible(true);
                        changeOverdraftLimitButton1.setVisible(true);
                        overdraftLimitLbl.setVisible(true);
                        newOverdraftLimitLbl.setVisible(true);

                        overdraftLimitTxt.setText(String.valueOf(currentAccount.getOverdraft()));

                    } else {

                        JOptionPane.showMessageDialog(rootPanel,
                                "Error: Overdraft applies only to Current Accounts!");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPanel, "Error: Enter a valid numeric Account ID!");
                }
            }
        });


        //Bank Officer Change Overdraft Limit Button

        changeOverdraftLimitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String accountIdInput = overdraftAccIdTxt.getText().trim();

                try {

                    int accountId = Integer.parseInt(accountIdInput);
                    Account account = ThomondBank.getAccountById(accountId);

                    CurrentAccount currentAccount;
                    currentAccount = (CurrentAccount) account;

                    overdraftLimitTxt.setText(String.valueOf(currentAccount.getOverdraft()));

                    String newOverdraftInput = newOverdraftLimitTxt.getText().trim();
                    if (newOverdraftInput.isEmpty()) {
                        JOptionPane.showMessageDialog(rootPanel,
                                "Error: New overdraft limit cannot be empty!");
                        return;
                    }

                    double newOverdraftLimit = Double.parseDouble(newOverdraftInput);
                    if (newOverdraftLimit < 0) {
                        JOptionPane.showMessageDialog(rootPanel,
                                "Error: Overdraft limit cannot be negative!");
                        return;
                    }

                    currentAccount.setOverdraft(newOverdraftLimit);
                    JOptionPane.showMessageDialog(rootPanel,
                            "Overdraft limit updated successfully!");

                    overdraftAccIdTxt.setText("");
                    overdraftLimitTxt.setText("");
                    newOverdraftLimitTxt.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPanel,
                            "Error: Enter a valid numeric Account ID and Overdraft Limit!");
                }
            }
        });

        //Bank Officer 'Create Customer' Panel Button

        createCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                createCustomerPnl.setVisible(true);
                accountCreationTabPane.setVisible(false);
                changeAIRTabPane.setVisible(false);
                overDraftTabPane.setVisible(false);
                transactionPnl.setVisible(false);

            }
        });

        //Bank Officer Finalize Create Customer Button

        customerCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String firstName = custFirstNameTxt.getText().trim();
                String lastName = custLastNameTxt.getText().trim();
                String address = custAddressTxt.getText().trim();
                String dobInput = custDobTxt.getText().trim();
                String customerIdInput = custIdTxt.getText().trim();

                if (firstName.isEmpty()){
                    JOptionPane.showMessageDialog(rootPanel, "First name cannot be empty!");
                    return;
                }

                else if (lastName.isEmpty()){
                    JOptionPane.showMessageDialog(rootPanel, "Last name cannot be empty!");
                    return;
                }

                else if (address.isEmpty()){
                    JOptionPane.showMessageDialog(rootPanel, "Address cannot be empty!");
                    return;
                }

                else if (dobInput.isEmpty()){
                    JOptionPane.showMessageDialog(rootPanel, "DOB cannot be empty!");
                    return;
                }

                else if (customerIdInput.isEmpty()){
                    JOptionPane.showMessageDialog(rootPanel, "Customer ID cannot be empty!");
                    return;
                }

                try {

                    LocalDate dob = LocalDate.parse(dobInput);
                    int customerId = Integer.parseInt(customerIdInput);

                    for (Customer existingCustomer : Thomond_Bank_GUI.thomondCustomers) {

                        if (existingCustomer.getCustNo() == customerId) {

                            JOptionPane.showMessageDialog(rootPanel,
                                    "Customer ID already exists. Please choose a different ID.");
                            return;
                        }
                    }

                    Customer newCustomer = new Customer(firstName, lastName, address, dob, customerId);

                    Thomond_Bank_GUI.thomondCustomers.add(newCustomer);


                    JOptionPane.showMessageDialog(rootPanel, "Customer created successfully!");

                    custFirstNameTxt.setText("");
                    custLastNameTxt.setText("");
                    custAddressTxt.setText("");
                    custDobTxt.setText("");
                    custIdTxt.setText("");

                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(rootPanel,
                            "Invalid date format. Please use YYYY-MM-DD.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPanel,
                            "Invalid customer ID format. Please enter a valid number.");
                }

            }
        });


        //Bank Officer List all Customers Button

        listAllCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Thomond_Bank_GUI.thomondCustomers.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPanel, "No customers found!");
                    return;
                }

                for (Customer customer : Thomond_Bank_GUI.thomondCustomers) {

                    System.out.println("---- Customers ----" +
                            "\nFirst Name: " + customer.firstName +
                            "\nLast Name: " + customer.lastName +
                            "\nAddress: " + customer.address +
                            "\nDate of Birth: " + customer.dob +
                            "\nCustomer ID: " + customer.getCustNo() +
                            "\n------------------------\n");
                }
            }
        });


        //ADDITIONAL FEATURE
        //Bank Officer Show Transactions Button

        allTransactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                accountCreationTabPane.setVisible(false);
                changeAIRTabPane.setVisible(false);
                overDraftTabPane.setVisible(false);
                createCustomerPnl.setVisible(false);
                transactionPnl.setVisible(true);

            }
        });


        //Bank Officer Show Transaction Button

        showTransactionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String accountIdInput = transactionAccountTxt.getText().trim();

                if (accountIdInput.isEmpty()) {
                    JOptionPane.showMessageDialog(transactionPnl,
                            "Please enter an Account ID.");
                    return;
                }

                int accountId=-1;

                try {

                    accountId = Integer.parseInt(accountIdInput);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(transactionPnl,
                            "Invalid Account ID format. Please enter a valid numeric value.");
                    return;
                }

                Account account = ThomondBank.getAccountById(accountId);

                if (account == null) {
                    System.out.println("Error: Account not found.");
                } else {

                    List<Transactions> transactionHistory = account.getTransactionHistory();

                    if (transactionHistory.isEmpty()) {
                        System.out.println("No transactions found for Account ID: " + accountId);
                    } else {

                        for (Transactions transaction : transactionHistory) {
                            System.out.println("Account ID: " + accountId);
                            System.out.println("Type: " + transaction.getType());
                            System.out.println("Amount: " + transaction.getAmount());
                            System.out.println("Date: " + transaction.getTransactionDate());

                            System.out.println("---------");
                        }

                        transactionAccountTxt.setText("");
                    }
                }
            }
        });


        //BANK MANAGER EVENTS

        //Bank Manager 'Create Bank Officer' Panel Button

        createBankOfficerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                createBankOfficerPnl.setVisible(true);

            }


        });



        //Bank Manager Finalize Create Bank Officer Button

        createStaffAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String firstName = employeeFirstNameTxt.getText().trim();
                String lastName = employeeLastNameTxt.getText().trim();
                String address = employeeAddressTxt.getText().trim();
                String dobInput = employeeDobTxt.getText().trim();
                String empNoInput = employeeIdTxt.getText().trim();
                String jobTitle = jobTitleTxt.getText().trim();


                if (firstName.isEmpty()){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Error: First name cannot be empty!");
                    return;
                }

                else if (lastName.isEmpty()){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Error: Last name cannot be empty!");
                    return;
                }

                else if (address.isEmpty()){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Error: Address cannot be empty!");
                    return;
                }

                else if (dobInput.isEmpty()){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Error: Date of Birth cannot be empty!");
                    return;
                }

                else if (empNoInput.isEmpty()){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Error: Employee No cannot be empty!");
                    return;
                }

                else if (jobTitle.isEmpty()){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Error: Job Title cannot be empty!");
                    return;
                }

                LocalDate dob;
                try {
                    dob = LocalDate.parse(dobInput);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPanel, "Error: Invalid Date Format (Use YYYY-MM-DD)!");
                    return;
                }

                int empNo;
                try {
                    empNo = Integer.parseInt(empNoInput);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPanel, "Error: Employee Number must be an integer!");
                    return;
                }


                for (BankStaff staff : Thomond_Bank_GUI.thomondStaff) {
                    if (staff instanceof BankOfficer && staff.empNo == empNo) {
                        JOptionPane.showMessageDialog(rootPanel, "Error: Employee ID already exists! Choose another.");
                        return;
                    }
                }


                BankOfficer newOfficer = new BankOfficer(firstName, lastName, address, dob, empNo, jobTitle);

                Thomond_Bank_GUI.thomondStaff.add(newOfficer);

                JOptionPane.showMessageDialog(rootPanel, "Bank Officer Created Successfully!");

                employeeFirstNameTxt.setText("");
                employeeLastNameTxt.setText("");
                employeeAddressTxt.setText("");
                employeeDobTxt.setText("");
                employeeIdTxt.setText("");
                jobTitleTxt.setText("");

            }

        });


        //Bank Manager List All Staff button

        listAllStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("---- Thomond Bank Staff ----");

                if (Thomond_Bank_GUI.thomondStaff.isEmpty()) {
                    System.out.println("No staff members found.");

                } else {

                    for (BankStaff staff : Thomond_Bank_GUI.thomondStaff) {

                        String jobTitle;

                        if (staff instanceof BankOfficer) {
                            jobTitle = ((BankOfficer) staff).getJobTitle();
                        } else {
                            jobTitle = "Bank Manager";
                        }

                        System.out.println
                                ("\nFirst Name: " + staff.firstName +
                                "\nLast Name: " + staff.lastName +
                                "\nAddress: " + staff.address +
                                "\nDate of Birth: " + staff.dob +
                                "\nJob Title: " + jobTitle +
                                "\nEmployee ID: " + staff.empNo +
                                "\n------------------------\n");
                    }
                }
            }
        });



    }


}