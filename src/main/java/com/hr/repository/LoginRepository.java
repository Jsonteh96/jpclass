package com.hr.repository;

import org.springframework.data.repository.CrudRepository;
import com.hr.model.Login;


public interface LoginRepository extends CrudRepository<Login,String> {

}
