package com.hr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping("/student")
	public String viewStudentPage(Model model) {
		Student student = new Student();
		List<Student> listStudents = studentService.getAllStudents();
		model.addAttribute("student", student);
	    model.addAttribute("listStudents", listStudents);
	    return "student";
	}
	
	
	
	@RequestMapping("/group")
	public String viewGroupPage(Model model,HttpServletRequest request) {
		
		Student stdlist = new Student();
		List<Student> listStudents = studentService.getAllStudents();
		model.addAttribute("student", stdlist);
	    model.addAttribute("listStudents", listStudents);
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		System.out.println("Current User: "+userId);
		boolean userExist = loginService.getLogin(userId).isPresent();
		
		if (userExist){
			String userName = studentService.getStudent(userId).get().getName();
			String userGroup = studentService.getStudent(userId).get().getGroup();
			Student student = new Student();
			student.setId(userId);
			student.setName(userName);
			student.setGroup(userGroup);
			model.addAttribute("getCurrentUser", student);
			
		}
		
		    return "group";
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
	
	@RequestMapping(value = "/deleteStudent/{id}") //@{/deleteStudent/{id}(id=${student.id})}
	public String deleteStudent(@ModelAttribute("id") String id) {
		System.out.println("Hello World!");
		studentService.deleteStudent(id);
	    return "redirect:/student";
	}
	
	
}
