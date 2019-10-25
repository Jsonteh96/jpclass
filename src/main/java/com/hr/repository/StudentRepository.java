package com.hr.repository;

import org.springframework.data.repository.CrudRepository;
import com.hr.model.Student;


public interface StudentRepository extends CrudRepository<Student,String> {

}
