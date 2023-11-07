package pl.edu.agh.to.school.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String firstName;
    private String lastName;

    private LocalDate birthDate;
    private String indexNumber;

    public Student(
        String firstName,
        String lastName,
        LocalDate birthDate,
        String indexNumber
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.indexNumber = indexNumber;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

}
