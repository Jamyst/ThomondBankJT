package data;

import java.time.LocalDate;

public class Customer extends Person {
    private int custNo;

    public Customer(String firstName, String lastName, String address, LocalDate dob, int custNo) {
        super(firstName, lastName, address, dob);
        this.custNo = custNo;
    }

    public int getCustNo()
    {
        return custNo;
    }
}
