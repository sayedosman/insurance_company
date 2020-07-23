package com.example.demo.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Repository.ServiceProviderRepository;

import com.example.demo.model.ServiceProvider;
@Service
public class ServiceProviderService {
	@Autowired
	private ServiceProviderRepository ServiceProviderRepository;
	public ServiceProvider getServiceProvider(String name) {
		return ServiceProviderRepository.findByName(name);
	}
}
