package pl.edu.agh.to.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.to.school.model.Student;
import pl.edu.agh.to.school.service.StudentService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
}
