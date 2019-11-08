package com.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.model.Teacher;
import com.hr.service.LoginService;
import com.hr.service.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/teacher")
	public String viewTeacherPage(Model model) {
		Teacher teacher = new Teacher();
		List<Teacher> listTeachers = teacherService.getAllTeachers();
		model.addAttribute("teacher", teacher);
	    model.addAttribute("listTeachers", listTeachers);
	    return "adminTeacher";
	}
	
	@RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
	public String addTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teacherService.addTeacher(teacher);
		loginService.addTeacherLogin(teacher);
	    return "redirect:/teacher";
	}
	
	@RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
	public String updateTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teacherService.updateTeacher(teacher);
	    return "redirect:/teacher";
	}
	
	@RequestMapping(value = "deleteTeacher/{id}")
	public String deleteTeacher(@ModelAttribute("id") String id) {
		teacherService.deleteTeacher(id);
	    return "redirect:/teacher";
	}

}
