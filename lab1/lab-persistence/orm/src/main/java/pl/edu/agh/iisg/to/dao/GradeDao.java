package pl.edu.agh.iisg.to.dao;

import pl.edu.agh.iisg.to.model.Course;
import pl.edu.agh.iisg.to.model.Grade;
import pl.edu.agh.iisg.to.model.Student;

import javax.persistence.PersistenceException;

public class GradeDao extends GenericDao<Grade> {

    public boolean gradeStudent(final Student student, final Course course, final float grade) {
        try {
            Grade g = new Grade(student, course, grade);
            if (student.gradeSet().contains(g) || course.gradeSet().contains(g))
                return false;

            student.gradeSet().add(g);
            course.gradeSet().add(g);
            save(g);

            return true;
        }
        catch (PersistenceException e) {
            return false;
        }
    }

}
