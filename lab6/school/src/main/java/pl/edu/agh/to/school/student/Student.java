package pl.edu.agh.to.school.student;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @GeneratedValue
    public long id;
    public String firstName;
    public String lastName;

    public LocalDate birthDate;
    public String indexNumber;

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
}
