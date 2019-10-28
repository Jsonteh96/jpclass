package com.hr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hr.model.Classroom;
import com.hr.repository.ClassroomRepository;

@Service
public class ClassroomService {
	
	@Autowired
	private ClassroomRepository classroomRepository;
	
	public List<Classroom> getAllClass(){
		List<Classroom> classrooms = new ArrayList<>();
		classroomRepository.findAll().forEach(classrooms::add);
		return classrooms;
	}
	
	public Optional<Classroom> getClass(String cid) {
		return classroomRepository.findById(cid);
	}
	
	public void addClass(Classroom classrooms) {
		classroomRepository.save(classrooms);	
	}
	
	public void updateClass(Classroom classrooms) {
		classroomRepository.save(classrooms);	
	}

	public void deleteClass(String cid) {
		classroomRepository.deleteById(cid);
	}
	
	
	

}
