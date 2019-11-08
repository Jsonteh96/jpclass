package com.hr.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.model.Login;
import com.hr.model.Student;
import com.hr.model.Teacher;
import com.hr.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	public  Optional<Login> getLogin(String id) {
		return loginRepository.findById(id);
	}
	
	public void addLogin(Login login) {
		loginRepository.save(login);	
	}
	
	public void addStudentLogin(Student student) {
		Login login = new Login();
		login.setUserId(student.getId());
		login.setPassword("HRC");
		login.setRole("student");
		login.setLoggingFirstTime(true);
		loginRepository.save(login);	
	}
	
	public void addTeacherLogin(Teacher teacher) {
		Login login = new Login();
		login.setUserId(teacher.getId());
		login.setPassword("HRC");
		login.setRole("teacher");
		login.setLoggingFirstTime(true);
		loginRepository.save(login);	
	}
	
}
