package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.CompanyRepository;
import com.example.demo.model.Company;

@RestController
@RequestMapping("/company")
public class CompanyController {
@Autowired
private CompanyRepository companyRepository;

  @GetMapping("/all")
  public List<Company>getAllCompanys(){
	  return companyRepository.findAll();
  }
}
