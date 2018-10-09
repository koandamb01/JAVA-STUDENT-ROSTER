package com.StudentRoster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.StudentRoster.models.Contact;
import com.StudentRoster.models.Student;
import com.StudentRoster.services.ContactService;
import com.StudentRoster.services.StudentService;

@Controller
@RequestMapping("/contact")
public class ContactController {
	private final ContactService contactService;
	private final StudentService studentSerice;
	
	public ContactController(ContactService contactService, StudentService studentSerice ) {
		this.contactService = contactService;
		this.studentSerice = studentSerice;
	}
	
	
	@RequestMapping("new")
	public String index(@ModelAttribute("contact") Contact contact, Model model) {
		// get all the students
		List<Student> students = this.studentSerice.findAllStudents();
		model.addAttribute("students", students);
		return "contact/new.jsp";
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String index(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Student> students = this.studentSerice.findAllStudents();
			model.addAttribute("students", students);
			return "contact/new.jsp"; 
		}
		else {
			this.contactService.createContact(contact);
		}
		return "redirect:/students";
	}
	
}
