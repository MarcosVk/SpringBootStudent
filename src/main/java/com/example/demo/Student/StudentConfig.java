package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.CommandLinePropertySource;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args ->{
            Student vicky=new Student(
                    "Vicky",
                    23,
                    LocalDate.parse("2002-01-02"),
                    "vicky@email.com"
            );
            Student luffy=new Student(
                    "Luffy",
                    22,
                    LocalDate.parse("2002-05-01"),
                    "vicky@email.com"
            );
            studentRepository.saveAll(List.of(vicky,luffy));
        };
    }
}
