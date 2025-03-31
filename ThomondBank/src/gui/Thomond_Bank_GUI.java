package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Thomond_Bank_GUI {
    private JPanel rootPanel;
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

    static ArrayList<Account> thomondAccounts = new ArrayList<>();
    static ArrayList<BankStaff> thomondStaff = new ArrayList<>();


    public static void main(String[] args) {
        JFrame frame = new JFrame("Thomand Bank ATM");
        frame.setContentPane(new Thomond_Bank_GUI().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Thomond_Bank_GUI() {
        ButtonsPnl.setVisible(false);
        accountCreationTabPane.setVisible(false);
        changeAIRTabPane.setVisible(false);
        overDraftTabPane.setVisible(false);




        setUpListeners();



    }

    private void setUpListeners() {

        depositAccountRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ButtonsPnl.setVisible(true);

            }
        });

        currentAccountRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ButtonsPnl.setVisible(true);

            }
        });

        //Bank Officer

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


}




