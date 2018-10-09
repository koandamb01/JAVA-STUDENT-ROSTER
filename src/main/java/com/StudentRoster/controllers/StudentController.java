package com.StudentRoster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.StudentRoster.models.Student;
import com.StudentRoster.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {this.studentService = studentService; }
	
	
	@RequestMapping("")
	public String index(Model model) {
		List<Student> students = this.studentService.findAllStudents();
		model.addAttribute("students", students);
		return "student/students.jsp";
	}
	
	@RequestMapping("new")
	public String newForm(@ModelAttribute("student") Student student) {
		return "student/new.jsp";
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "student/new.jsp";
		}
		else {
			this.studentService.createStudent(student);
		}
		return "redirect:/contact/new";
	}
}
