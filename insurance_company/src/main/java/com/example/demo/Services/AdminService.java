package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AdminRepository;
import com.example.demo.model.Admin;
@Service
public class AdminService  {
	@Autowired
	private AdminRepository adminRepository;
	public Admin getAdminByname(String name) {
		return adminRepository.findByFirstname(name);
	}

}
