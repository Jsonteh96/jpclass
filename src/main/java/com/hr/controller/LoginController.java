package com.hr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.model.Admin;
import com.hr.model.Login;
import com.hr.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping("/")
	public String viewLoginPage(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		
		Admin admin = new Admin();
		admin.setId("Admin001");
		admin.setName("Administrator");
		admin.setEmail("administrator@gmail.com");
		
		loginService.addAdminLogin(admin);
		
	    return "index";
	}
	
	@RequestMapping(value ="/changepassword", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute("login") Login login,Model model){
		loginService.addLogin(login);
		return "index";
	}
	
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public String Login(@ModelAttribute("login") Login login,Model model,HttpServletRequest request){
		
		String userId = login.getUserId();
		String password = login.getPassword();
		boolean userExist = loginService.getLogin(userId).isPresent();
		
		if(userExist) {
			
			String userPassword = loginService.getLogin(login.getUserId()).get().getPassword();
			String userRole = loginService.getLogin(login.getUserId()).get().getRole();
			boolean userStatus = loginService.getLogin(login.getUserId()).get().isLoggingFirstTime();
			
			if(passwordEncoder.matches(password, userPassword)) {
				
				HttpSession session =  request.getSession();
				session.setAttribute("userId", userId);
				session.setAttribute("userRole", userRole);
				
				if(userStatus) {
					Login newLogin = new Login();
					newLogin.setUserId(userId);
					newLogin.setRole(userRole);
					newLogin.setLoggingFirstTime(false);
					model.addAttribute("newLogin", newLogin);
					return "createPassword";
					
				}else {
					if(userRole.equals("student")) {
						return "adminSchedule";	
					}
					else if(userRole.equals("teacher")) {
						return "redirect:/home";	
					}
					else if(userRole.equals("admin")) {
						return "home2";	
					}else {
						return "index";
					}	
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
