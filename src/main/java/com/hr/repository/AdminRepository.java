package com.hr.repository;

import org.springframework.data.repository.CrudRepository;

import com.hr.model.Admin;

public interface AdminRepository extends CrudRepository<Admin,String>{
	
}
