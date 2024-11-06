package SpringWithDB.SpringWithDB.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            StudentData thomas = new StudentData("Thomas", 21, LocalDate.of(2003, Month.SEPTEMBER, 19), "thomas@gmail.com");
            StudentData ben = new StudentData(2L, "Ben", 21, LocalDate.of(2003, Month.JULY, 31), "ben@gmail.com");

            studentRepository.saveAll(List.of(thomas, ben));
        };
    }
}
