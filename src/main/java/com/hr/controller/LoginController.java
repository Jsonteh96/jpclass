package com.hr.controller;

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
	
	@RequestMapping(value ="/changepassword", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute("login") Login login,Model model){
		loginService.addLogin(login);
		return "index";
	}
	
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public String Login(@ModelAttribute("login") Login login,Model model){
		
		String userId = login.getUserId();
		String password = login.getPassword();
		boolean userExist = loginService.getLogin(userId).isPresent();
		//boolean firstTime = loginService.getLogin(login.getUserId()).get().isLoggingFirstTime();
		
		if(userExist) {
			
			String userPassword = loginService.getLogin(login.getUserId()).get().getPassword();
			String userRole = loginService.getLogin(login.getUserId()).get().getRole();
			boolean userStatus = loginService.getLogin(login.getUserId()).get().isLoggingFirstTime();	
			
			if(password.equals(userPassword)) {
				
				if(userStatus) {
					Login newLogin = new Login();
					newLogin.setUserId(userId);
					newLogin.setRole(userRole);
					newLogin.setLoggingFirstTime(false);
					model.addAttribute("newLogin", newLogin);
					return "createPassword";
					
				}else {
					return "index";	
				}
				
			}else {
				model.addAttribute("WrongPassword",true);
				return "index";	
			}
				
		}else {
			model.addAttribute("UserDoesntExist",true);
			return "index";
		}
		
	}

}
