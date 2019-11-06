package com.hr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.model.Login;
import com.hr.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/")
	public String viewLoginPage(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
	    return "index";
	}
	
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public String Login(@ModelAttribute("login") Login login){
		String userId = loginService.getLogin(login.getUserId()).get().getUserId();
		String password = loginService.getLogin(login.getUserId()).get().getPassword();
		String role = loginService.getLogin(login.getUserId()).get().getRole();
		boolean status = loginService.getLogin(login.getUserId()).get().isLoggingFirstTime();
		System.out.println(userId);
		System.out.println(password);
		System.out.println(role);
		System.out.println(status);
		return "redirect:/home";
	}

}
