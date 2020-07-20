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
		Admin a=new Admin();
		a.setAddress("kljdfjlkf");
		a.setEmail("fjkjfdkjk");
		a.setFirstname("dfkjkjd");
		a.setLastname("jkjkkj");
		a.setPass("kjdfdjkfjk");
		a.setPhone(77265858);
		adminRepository.save(a);
	}

}
