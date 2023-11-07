package pl.edu.agh.to.school.service;

import org.springframework.stereotype.Service;
import pl.edu.agh.to.school.model.Student;
import pl.edu.agh.to.school.repository.StudentRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
