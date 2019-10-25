package com.hr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "student")
public class Student {
	
	@Id
	@Column (name = "studentId")
	private String id;
	@Column (name = "studentName")
	private String name;
	@Column (name = "studentGroup")
	private String group;
	@Column (name = "studentNationality")
	private String nationality;
	
	public Student() {
		
	}
	
	public Student(String id, String name, String group, String nationality) {
		super();
		this.id = id;
		this.name = name;
		this.group = group;
		this.nationality = nationality;
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

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
}
