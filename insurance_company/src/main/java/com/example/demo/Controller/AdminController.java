package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.CompanyRepository;
import com.example.demo.model.Company;


@RestController
@RequestMapping("/admin")
public class AdminController {
 @Autowired
 private CompanyRepository companyRepository;
	@GetMapping("/all")
	public void get() {
	/*Company principal = (Company) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	return principal;*/
	}
	
}
