package data;

import java.time.LocalDateTime;

public class Transactions {
    private String type;
    private double amount;
    private LocalDateTime timestamp;


    public Transactions(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();

    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionDate() {
        return timestamp.toString();
    }


}
