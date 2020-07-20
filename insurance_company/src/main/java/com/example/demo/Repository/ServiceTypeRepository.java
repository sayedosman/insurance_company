package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.ServiceType;
@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {

}
