package com.example.demo.Student;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.Period;

@Entity(name="Student")
@Table(
		name="student",
		uniqueConstraints = {
				@UniqueConstraint(name="student_email_unique",columnNames = "email")
		}
)
public class Student{

@Id


















@SequenceGenerator(
	name="student_sequence",
	sequenceName="student_sequence",
	allocationSize=1
)
@GeneratedValue(
	strategy=GenerationType.SEQUENCE,
	generator="student_sequence"
)
@Column(
		name = "id",
		updatable = false,
		nullable = false
)
private Long id;
@Column(
		name = "name",
		columnDefinition = "TEXT",
		nullable = false
)
private String name;
	@Column(
			name = "date",
			nullable = false,
			columnDefinition = "TEXT"
	)
private LocalDate date;
	@Column(
			name = "email",
			nullable = false,
			unique = true
	)
private String email;
@Transient
private Integer age;


public Student(){
}
public Student(Long id,String name,LocalDate date,String email){
	this.id=id;
	this.name=name;
	this.date=date;
	this.email=email;
}
public Student(String name,LocalDate date,String email){
this.name=name;
this.date=date;
this.email=email;
}
public Long getId() {
	return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

public String getName(){
return name;
}
public void setName(String name){
this.name=name;
}
public Integer getAge() {
	return Period.between(this.date, LocalDate.now()).getYears();
}
public void setAge(Integer age){
	this.age=age;
}
public LocalDate getDate(){
return date;
}
public void setDate(LocalDate date){
this.date=date;
}
public String getEmail(){
return email;
}
public void setEmail(String email){
this.email=email;
}

@Override
public String toString(){
	return "Student{"+
		     "name: '"+name+'\''+
		     ", age: "+age+
		     ", date: "+date+
		     ", email: '"+email+'\''+
		       '}';
}
}