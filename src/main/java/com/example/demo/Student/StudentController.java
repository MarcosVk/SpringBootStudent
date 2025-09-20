package com.example.demo.Student;

import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@RestController
@RequestMapping(path="api/v1/student")
public class StudentController{
private final StudentService studentservice;

@Autowired
public StudentController(StudentService studentservice){
this.studentservice=studentservice;
}
@Autowired
private PasswordEncoder passwordEncoder;
@GetMapping
public List<Student> getStudents(){
return studentservice.getStudents();
}
@PostMapping
public void postStudent(@RequestBody Student student){
    student.setPassword(passwordEncoder.encode(student.getPassword()));
    studentservice.addStudent(student);
}
@DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long StudentId){
        studentservice.removeStudent(StudentId);}
   @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long StudentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
    studentservice.editStudent(StudentId,name,email);

    }
}
