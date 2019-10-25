package com.hr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.model.Student;
import com.hr.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/student")
	public String viewHomePage(Model model) {
		Student student = new Student();
		List<Student> listStudents = studentService.getAllStudents();
		model.addAttribute("student", student);
	    model.addAttribute("listStudents", listStudents);
	    return "student";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student) {
		studentService.addStudent(student);
	    return "redirect:/student";
	}
	
	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute("student") Student student) {
		studentService.updateStudent(student);
	    return "redirect:/student";
	}
	
	@RequestMapping(value = "deleteStudent/{id}")
	public String deleteStudent(@ModelAttribute("id") String id) {
		System.out.println("jjj");
		studentService.deleteStudent(id);
	    return "redirect:/student";
	}
	
	
}
