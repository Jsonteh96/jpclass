package com.hr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "teacher")
public class Teacher {
	
	@Id
	@Column (name = "teacherId")
	private String id;
	@Column (name = "teacherName")
	private String name;
	@Column (name = "teacherEmail")
	private String email;
	
	public Teacher() {
		super();
	}

	public Teacher(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
