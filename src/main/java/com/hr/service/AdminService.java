package com.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.model.Admin;
import com.hr.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public void addAdmin(Admin admin) {
		adminRepository.save(admin);	
	}

}
