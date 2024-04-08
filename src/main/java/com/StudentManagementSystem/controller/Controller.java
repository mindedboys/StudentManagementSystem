package com.StudentManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.service.StudentService;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private StudentService studentService;

	@GetMapping("/home")
	public String home() {

		return "home";// view page html file -> home.html
	}

	@GetMapping("/student") // get all student
	public String getAllStudents(Model model) {

		model.addAttribute("student", studentService.getAllStudents());

		return "student";

	}

	@GetMapping("student/new") // create student
	public String createStudentForm(Model model){
		
		Student student = new Student();
		model.addAttribute("student", student); // to hold student object
		
		return "create-student";
	} 
	
	@PostMapping("/student") //create
	public String saveStudent(@ModelAttribute("student") Student student){
		
		studentService.saveStudent(student);
		return "redirect:/student";
		
	}
	
	
	@GetMapping("student/edit/{id}") // edit details
	public String editStudentForm(@PathVariable int id, Model model){
		
		model.addAttribute("student", studentService.getById(id));
		
	return "edit_student";
	}
	
	
	@PostMapping("/student/edit/{id}") // update
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student){
		
	Student existingStudent= studentService.getById(id);
	 
	existingStudent.setFirstname(student.getFirstname());
	existingStudent.setLastname(student.getLastname());
	existingStudent.setEmail(student.getEmail());
	
	studentService.saveStudent(existingStudent);
	
	return "redirect:/student";
	 
	}
	
	@GetMapping("student/{id}")  // delete
	public String deleteById(@PathVariable int id){
		
		studentService.deleteByid(id);
	
		return "redirect:/student";
	}
}
