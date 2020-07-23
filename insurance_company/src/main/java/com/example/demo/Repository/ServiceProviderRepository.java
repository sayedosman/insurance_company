package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Admin;
import com.example.demo.model.ServiceProvider;
@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

	public ServiceProvider findByName(String name);
}
