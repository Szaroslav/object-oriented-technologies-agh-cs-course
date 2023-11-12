package pl.edu.agh.to.school.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Grade {
    @Id
    @GeneratedValue
    public Long id;
    public int gradeValue;
    @OneToOne
    public Course course;

    public Grade() { }
}
