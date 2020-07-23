package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Table(name="company")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String address;
	private String name;
	private String phone;
	private List<Employee> employees;
	private List<ServiceType> serviceTypes;

	public Company() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	


	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="company", fetch=FetchType.EAGER)
	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setCompany(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setCompany(null);

		return employee;
	}


	//bi-directional many-to-many association to ServiceType
	@ManyToMany(mappedBy="companies")
	public List<ServiceType> getServiceTypes() {
		return this.serviceTypes;
	}

	public void setServiceTypes(List<ServiceType> serviceTypes) {
		this.serviceTypes = serviceTypes;
	}

}