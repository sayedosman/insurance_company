package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the service_provider database table.
 * 
 */
@Entity
@Table(name="service_provider")
@NamedQuery(name="ServiceProvider.findAll", query="SELECT s FROM ServiceProvider s")
public class ServiceProvider implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String address;
	private String name;
	private String pass;
	private int phone;
	private String username;
	private List<Invoice> invoices;
	private ServiceType serviceType;

	public ServiceProvider() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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


	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="serviceProvider", fetch=FetchType.EAGER)
	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setServiceProvider(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setServiceProvider(null);

		return invoice;
	}


	//bi-directional many-to-one association to ServiceType
	@ManyToOne
	@JoinColumn(name="service_type_id")
	public ServiceType getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

}