package data;

import java.time.LocalDate;

public abstract class Person {
    public String firstName;
    public String lastName;
    public String address;
    public LocalDate dob;

    public Person(String firstName, String lastName, String address, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dob = dob;
    }
}
