package com.example.student_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_system.model.Student;
import com.example.student_system.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService studservice;
	
	public StudentController(StudentService studservice)
	{
		this.studservice=studservice;
	}
	
	@PostMapping
	public Student saveStudent(@RequestBody Student student)
	{
		return studservice.createStudent(student);
	}
	
	@GetMapping
	public List<Student> getStudents()
	{
		  return studservice.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student findStud(@PathVariable int id)
	{
		  return studservice.findById(id);
	}
	
	@PutMapping("/{id}")
	public Student UpdateStudeId(@PathVariable int id,@RequestBody Student student)
	{
		  return studservice.updateStudent(id, student);
	}
	
	@DeleteMapping("/{id}")
	public Student deleteStudId(@PathVariable int id)
	{
		  return studservice.deleteStudent(id);
	}
	
}
