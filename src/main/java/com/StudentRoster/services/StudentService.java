package com.StudentRoster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.StudentRoster.models.Student;
import com.StudentRoster.repositories.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepo;
	
	public StudentService(StudentRepository studentRepo) { this.studentRepo = studentRepo; }
	
	// Create a new Student
	public Student createStudent(Student student) { return this.studentRepo.save(student); }
		
	// get all students
	public List<Student> findAllStudents(){ return this.studentRepo.findAll(); }
	
	// get a student by ID
	public Student findStudentById(Long id) {
		Optional<Student> response = this.studentRepo.findById(id);
		if(response.isPresent()) {
			return response.get();
		}
		else {
			return null;
		}
	}
}
