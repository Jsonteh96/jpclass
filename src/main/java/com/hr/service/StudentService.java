package com.hr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hr.model.Student;
import com.hr.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		return students;
	}
	
	public Optional<Student> getStudent(String id) {
		return studentRepository.findById(id);
	}
	
	public void addStudent(Student student) {
		studentRepository.save(student);	
	}
	
	public void updateStudent(Student student) {
		studentRepository.save(student);	
	}

	public void deleteStudent(String id) {
		studentRepository.deleteById(id);
	}
	
	
	

}
