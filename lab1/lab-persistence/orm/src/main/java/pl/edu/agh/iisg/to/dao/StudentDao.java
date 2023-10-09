package pl.edu.agh.iisg.to.dao;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.hibernate.Session;
import pl.edu.agh.iisg.to.model.Course;
import pl.edu.agh.iisg.to.model.Student;

import javax.persistence.PersistenceException;

public class StudentDao extends GenericDao<Student> {

    public Optional<Student> create(final String firstName, final String lastName, final int indexNumber) {
        Student student = new Student(firstName, lastName, indexNumber);
        try {
            save(student);
            return Optional.of(student);
        }
        catch (PersistenceException e) {
            return Optional.empty();
        }
    }

    public Optional<Student> findByIndexNumber(final int indexNumber) {
        try (Session session = currentSession()) {
            Student student = (Student) session
                .createQuery("SELECT s FROM Student s WHERE s.indexNumber = :indexNumber")
                .setParameter("indexNumber", indexNumber)
                .getSingleResult();
            return Optional.of(student);
        }
        catch (PersistenceException e) {
            return Optional.empty();
        }
    }

    public Map<Course, Float> createReport(final Student student) {
        //TODO additional task
        return Collections.emptyMap();
    }

}
