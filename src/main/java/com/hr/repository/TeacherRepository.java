package com.hr.repository;

import org.springframework.data.repository.CrudRepository;

import com.hr.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher,String> {

}
