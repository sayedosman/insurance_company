package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


/**
 * The persistent class for the service_type database table.
 * 
 */
@Entity
@Table(name="service_type")
@NamedQuery(name="ServiceType.findAll", query="SELECT s FROM ServiceType s")
public class ServiceType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private List<ServiceProvider> serviceProviders;
	private List<Company> companies;

	public ServiceType() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to ServiceProvider
	@OneToMany(mappedBy="serviceType", fetch=FetchType.EAGER)
	public List<ServiceProvider> getServiceProviders() {
		return this.serviceProviders;
	}

	public void setServiceProviders(List<ServiceProvider> serviceProviders) {
		this.serviceProviders = serviceProviders;
	}

	public ServiceProvider addServiceProvider(ServiceProvider serviceProvider) {
		getServiceProviders().add(serviceProvider);
		serviceProvider.setServiceType(this);

		return serviceProvider;
	}

	public ServiceProvider removeServiceProvider(ServiceProvider serviceProvider) {
		getServiceProviders().remove(serviceProvider);
		serviceProvider.setServiceType(null);

		return serviceProvider;
	}


	//bi-directional many-to-many association to Company
	@ManyToMany
	@JoinTable(
		name="company_services"
		, joinColumns={
			@JoinColumn(name="service_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="company_id")
			}
		)
	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

}