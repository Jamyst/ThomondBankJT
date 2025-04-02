package data;

import java.time.LocalDate;

abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String address;
    protected LocalDate dob;

    public Person(String firstName, String lastName, String address, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dob = dob;
    }
}
