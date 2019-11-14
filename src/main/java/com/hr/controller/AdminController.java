package com.hr.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminController {
	 
	
	@RequestMapping({"/home","/home.html"})
	public String viewHomePage(Model model,HttpServletRequest request) {
		HttpSession session =  request.getSession();
		String userId = (String) session.getAttribute("userId");
		String userRole = (String) session.getAttribute("userRole");
		System.out.println("session "+userId);
		System.out.println("session "+userRole);
	    return "home";
	}
	
	@RequestMapping({"/home2","/home2.html"})
	public String viewHomePage2(Model model) {
	    return "home2";
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
