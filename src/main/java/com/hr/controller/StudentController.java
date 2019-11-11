package com.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.model.Login;
import com.hr.model.Student;
import com.hr.service.LoginService;
import com.hr.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/student")
	public String viewStudentPage(Model model) {
		Student student = new Student();
		List<Student> listStudents = studentService.getAllStudents();
		model.addAttribute("student", student);
	    model.addAttribute("listStudents", listStudents);
	    return "student";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student) {
		studentService.addStudent(student);
		loginService.addStudentLogin(student);
	    return "redirect:/student";
	}
	
	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute("student") Student student) {
		studentService.updateStudent(student);
	    return "redirect:/student";
	}
	
	//@RequestMapping(path = "/student/{id}", method = RequestMethod.DELETE)
	//String destory(Model model, @PathVariable("id") int id) {
	//	jdbcTemplate.update("delete from user where id = ? ", id);
	//    return "redirect:/sample";
	//}
	
	@RequestMapping(value = "/deleteStudent/{id}") //@{/deleteStudent/{id}(id=${student.id})}
	public String deleteStudent(@ModelAttribute("id") String id) {
		System.out.println("Hello World!");
		studentService.deleteStudent(id);
	    return "redirect:/student";
	}
	
	
}
