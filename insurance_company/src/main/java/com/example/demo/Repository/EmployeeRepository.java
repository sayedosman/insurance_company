package com.example.demo.Repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Admin;
import com.example.demo.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
