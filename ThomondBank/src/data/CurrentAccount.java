package data;


class CurrentAccount extends Account {
    private static double AIR = 0.005;
    private double overdraft;

    public CurrentAccount(int id, int custNo, double balance, double overdraft) {
        super(id, custNo, balance);
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance + overdraft) >= amount) {
            balance -= amount;
        }
    }

    public static void setAIR(double air) {
        AIR = air; }

    public static double getAIR() {
        return AIR; }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft; }

    public double getOverdraft() {
        return overdraft; }
}
