package com.hr.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminController {
	 
	
	@RequestMapping({"/home","/home.html"})
	public String viewHomePage(Model model) {
	    return "home";
	}
	
	@RequestMapping({"/schedule","/schedule.html"})
	public String viewSchedulePage(Model model) {
	    return "schedule";
	}
	
	/*@RequestMapping({"/classroom","/classroom.html"})
	public String viewClassRoomPage(Model model) {
	    return "classroom";
	}*/
	
	@RequestMapping({"/tableview","/tableview.html"})
	public String viewTableViewPage(Model model) {
	    return "schedule";
	}

}
