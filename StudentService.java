package com.example.student_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.student_system.model.Student;
import com.example.student_system.repository.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository studentrepo;
	
	public StudentService(StudentRepository studentrepo)
	{
		this.studentrepo=studentrepo;
	}
	
	public Student createStudent(Student student)
	{
		  return studentrepo.save(student); 
	}
	
	public List<Student> getAllStudents()
	{
		   return studentrepo.findAll();
	}
	
	public Student findById(int id)
	{
           return studentrepo.findById(id).orElseThrow(()->new RuntimeException("Student not found"));		    
	}
	
	public Student updateStudent(int id,Student student)
	{
		   Student student1 =studentrepo.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
		   
		   student1.setName(student.getName());
		   student1.setMarks(student.getMarks());
		  
		   return studentrepo.save(student1);
	}
	
	public Student deleteStudent(int id)
	{
		    Student student1=studentrepo.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
		    studentrepo.delete(student1);
			return student1;
	}
}
