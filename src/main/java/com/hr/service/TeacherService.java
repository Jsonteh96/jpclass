package com.hr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.model.Teacher;
import com.hr.repository.TeacherRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	public List<Teacher> getAllTeachers(){
		List<Teacher> teachers = new ArrayList<>();
		teacherRepository.findAll().forEach(teachers::add);
		return teachers;
	}
	
	public Optional<Teacher> getTeacher(String id) {
		return teacherRepository.findById(id);
	}
	
	public void addTeacher(Teacher teacher) {
		teacherRepository.save(teacher);	
	}
	
	public void updateTeacher(Teacher teacher) {
		teacherRepository.save(teacher);	
	}

	public void deleteTeacher(String id) {
		teacherRepository.deleteById(id);
	}

}
