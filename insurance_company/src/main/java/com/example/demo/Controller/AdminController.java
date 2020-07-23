package com.example.demo.Controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Company;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/all")
	public Company get() {
	Company principal = (Company) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	return principal;
	}
}
