package gui;

import java.time.LocalDate;

// Customer class
class Customer extends Person {
    private int custNo;

    public Customer(String firstName, String lastName, String address, LocalDate dob, int custNo) {
        super(firstName, lastName, address, dob);
        this.custNo = custNo;
    }

    public int getCustNo() { return custNo; }
}
