package data;

import java.time.LocalDate;


public class BankManager extends BankStaff {
    public BankManager(String firstName, String lastName, String address, LocalDate dob, int empNo) {
        super(firstName, lastName, address, dob, empNo);
    }
}
