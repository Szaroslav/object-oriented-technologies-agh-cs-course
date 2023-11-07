package pl.edu.agh.to.school.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @GeneratedValue
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

    public Student() { }

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
