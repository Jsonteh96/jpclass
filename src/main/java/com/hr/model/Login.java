package com.hr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table (name = "login")
public class Login {
	
	@Id
	@Column (name = "loginId")
	private String userId;
	@Column (name = "password")
	@Length(min = 2, message = "*Your password must have at least 2 characters")
    @NotEmpty(message = "*Please provide your password")
	private String password;
	@Column (name = "loginRole")
	private String role;
	@Column (name = "loginStatus")
	private boolean loggingFirstTime;
	
	public Login() {
		super();
	}
	
	
	public Login(String userId,String password) {
		super();
		this.userId = userId;
		this.password = password;
	}


	public Login(String userId, String password, String role, boolean loggingFirstTime) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.loggingFirstTime = loggingFirstTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isLoggingFirstTime() {
		return loggingFirstTime;
	}

	public void setLoggingFirstTime(boolean loggingFirstTime) {
		this.loggingFirstTime = loggingFirstTime;
	}
	
}
