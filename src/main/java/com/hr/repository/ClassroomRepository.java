package com.hr.repository;

import org.springframework.data.repository.CrudRepository;

import com.hr.model.Classroom;


public interface ClassroomRepository extends CrudRepository<Classroom,String> {

}