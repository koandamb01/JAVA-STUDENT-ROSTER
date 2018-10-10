package com.StudentRoster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.StudentRoster.models.Dorm;
import com.StudentRoster.models.Student;
import com.StudentRoster.services.DormService;
import com.StudentRoster.services.StudentService;

@Controller
@RequestMapping("/dorms")
public class DormController {
	private final DormService dormService;
	private final StudentService studentService;
	
	public DormController(DormService dormService, StudentService studentService) {
		this.dormService = dormService;
		this.studentService = studentService;
	}
	
	@RequestMapping("new")
	public String newForm(@ModelAttribute("dorm") Dorm dorm) {
		return "dorm/new.jsp";
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
		if(result.hasErrors()) {
			return "dorm/new.jsp";
		}else {
			Dorm newDorm = this.dormService.createDorm(dorm);
			return "redirect:/dorms/" + newDorm.getId();
		}
	}
	
	
	@RequestMapping("{id}")
	public String newForm(@PathVariable("id") Long id, Model model) {
		// get the dorm
		Dorm dorm = this.dormService.findDormById(id);
		
		// get all the students
		List<Student> students = this.studentService.findAllStudents();
		model.addAttribute("students", students);
		model.addAttribute("dorm", dorm);
		return "dorm/dorms.jsp";
	}
	
	
	@RequestMapping(value="{id}/add")
	public String addStudent(@PathVariable("id") Long dorm_id, @RequestParam(value="student_id") Long student_id, Model model) {
		// get the dorm
		Dorm dorm = this.dormService.findDormById(dorm_id);
		
		// get student
		Student student = this.studentService.findStudentById(student_id);
		
		// add student dorm
		this.dormService.addStudentToDorm(dorm, student);
		
		// redirect back to dorms
		return "redirect:/dorms/" + dorm_id;
	}
	
	
	
}
