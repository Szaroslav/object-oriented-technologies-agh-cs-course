package pl.edu.agh.to.school.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    public Long id;

    public String name;
    @OneToMany
    public List<Student> students = new ArrayList<>();

    public void assignStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }
}
