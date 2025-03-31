package gui;

import java.time.LocalDate;

// Abstract BankStaff class
abstract class BankStaff extends Person {
    protected int empNo;

    public BankStaff(String firstName, String lastName, String address, LocalDate dob, int empNo) {
        super(firstName, lastName, address, dob);
        this.empNo = empNo;
    }
}
