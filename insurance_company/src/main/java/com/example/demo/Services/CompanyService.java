package com.example.demo.Services;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.Company;
import com.example.demo.Repository.CompanyRepository;
@Service
public class CompanyService  {

	@Autowired
	private CompanyRepository companyRepository;
	public Company getCompany(String name) {
		return companyRepository.findByName(name);
	}
}
