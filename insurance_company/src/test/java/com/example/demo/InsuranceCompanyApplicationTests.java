package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repository.AdminRepository;
import com.example.demo.model.Admin;


@SpringBootTest
class InsuranceCompanyApplicationTests {

	@Autowired
	private AdminRepository adminRepository;
	@Test
	void contextLoads() {
		
	}

}
