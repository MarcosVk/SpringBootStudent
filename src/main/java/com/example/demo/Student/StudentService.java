package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService{
	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
public List<Student> getStudents(){
   return studentRepository.findAll();
}
public void addStudent(Student student){
	Optional<Student> optionalString=studentRepository.findByEmail(student.getEmail());
	if(optionalString.isPresent()){
		throw new IllegalArgumentException("Student already exists");
	}
	studentRepository.save(student);
}
public void removeStudent(Long studentId){
		boolean exists=studentRepository.existsById(studentId);
		if(!exists){
			throw new IllegalArgumentException("Student does not exist");
		}
		studentRepository.deleteById(studentId);
}
@Transactional
public void editStudent(Long StudentId,String name,String email){
	Student student=studentRepository.findById(StudentId)
			.orElseThrow(()->new IllegalArgumentException("Student not found"));

	if(name!=null && name.length()>0 && !Objects.equals(student.getName(),name)){
		student.setName(name);
	}
	if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
		Optional<Student> optionalStudent=studentRepository.findByEmail(email);
		if(optionalStudent.isPresent()){
			throw new IllegalArgumentException("Student already exists");
		}
		student.setEmail(email);
	}
}
}