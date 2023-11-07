package pl.edu.agh.to.school.configurator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.agh.to.school.model.Student;
import pl.edu.agh.to.school.repository.StudentRepository;

import java.time.LocalDate;

@Configuration
public class StudentConfigurator {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            if (studentRepository.count() == 0) {
                Student student = new Student("Jan", "Kowalski", LocalDate.now(), "123456");
                studentRepository.save(student);
            }
        };
    }
}
