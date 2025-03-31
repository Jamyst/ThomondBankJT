package gui;

// Deposit Account class
class DepositAccount extends Account {
    private static double AIR = 0.02;

    public DepositAccount(int id, int custNo, double balance) {
        super(id, custNo, balance);
    }

    public DepositAccount(int id, int custNo) {
        super(id, custNo);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public static void setAIR(double air) { AIR = air; }
    public static double getAIR() { return AIR; }
}
