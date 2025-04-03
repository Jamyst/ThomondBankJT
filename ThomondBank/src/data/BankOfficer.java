package data;

import java.time.LocalDate;


public class BankOfficer extends BankStaff {
    private String jobTitle;

    public BankOfficer(String firstName, String lastName, String address, LocalDate dob, int empNo, String jobTitle) {
        super(firstName, lastName, address, dob, empNo);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle; }
}
