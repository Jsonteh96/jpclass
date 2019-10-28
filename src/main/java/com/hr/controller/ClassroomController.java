package com.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.model.Classroom;
import com.hr.service.ClassroomService;

@Controller
public class ClassroomController {
	@Autowired
	private ClassroomService classroomService;
	
	@RequestMapping("/classroom")
	public String viewHomePage(Model model) {
		Classroom classroom = new Classroom();
		List<Classroom> listClass = classroomService.getAllClass();
		model.addAttribute("classroom", classroom);
	    model.addAttribute("listClass", listClass);
	    return "classroom";
	}
	
	@RequestMapping(value = "/addClass", method = RequestMethod.POST)
	public String addClass(@ModelAttribute("classroom") Classroom classroom) {
		classroomService.addClass(classroom);
	    return "redirect:/classroom";
	}
	
	@RequestMapping(value = "/updateClass", method = RequestMethod.POST)
	public String updateClass(@ModelAttribute("classroom") Classroom classroom) {
		classroomService.updateClass(classroom);
	    return "redirect:/classroom";
	}
	
	@RequestMapping(value = "deleteClass/{cid}")
	public String deleteClass(@ModelAttribute("classroom") String cid) {
		classroomService.deleteClass(cid);
	    return "redirect:/classroom";
	}
	
}
