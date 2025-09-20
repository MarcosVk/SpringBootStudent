package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args ->{
            List<Student> students=new ArrayList<>();
            if(!studentRepository.existsByEmail("vicky@email.com")){
                Student vicky=new Student(
                        "Vicky",
                        LocalDate.parse("2002-01-02"),
                        "vicky@email.com",
                        "vicky",
                        "vicky123"
                );
                students.add(vicky);
            }
            if(!studentRepository.existsByEmail("luffy@email.com")){
                Student luffy=new Student(
                        "Luffy",
                        LocalDate.parse("2002-05-01"),
                        "luffy@email.com",
                        "luffy",
                        "luffy123"
                );
                students.add(luffy);
            }
            studentRepository.saveAll(students);
        };
    }
}
