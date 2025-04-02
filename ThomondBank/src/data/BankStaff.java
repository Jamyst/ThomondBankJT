package data;

import java.time.LocalDate;

public abstract class BankStaff extends Person {
    protected int empNo;

    public BankStaff(String firstName, String lastName, String address, LocalDate dob, int empNo) {
        super(firstName, lastName, address, dob);
        this.empNo = empNo;
    }
}
