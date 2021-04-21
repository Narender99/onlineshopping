package com.cg.onlineshopping.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "customer_table")
public class Customer {

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="customer_seq")
	@SequenceGenerator(name = "customer_seq",sequenceName = "customer_seq", allocationSize=1)
	private int customerId;

	@Column(name = "full_name")
	@NotNull(message= "First Name can not be null")
	private String fullName;

	//@Column(name = "last_name")
	//@NotNull(message = "Last Name should not be null")
	//private String lastName;

	@Column(name = "mobile_number")
	@Size(min = 10, message="Mobile no should be in 10 digits")
	private String mobileNumber;

	@Column(name = "email")
	@Email(message = "Email should be valid")
	private String email;
	

	@Column(name = "password")
	@NotNull(message = "password should not be null")
	private String password;
	
	//@Column(name = "address")
	//@NotEmpty(message = "address cannot be empty")
	//private String address;

	//mapping
	@JsonIgnore
	@OneToOne(mappedBy="customerAdd")
	private Address addressCust;

	//@JsonIgnore
	//@OneToOne(mappedBy="customerUser")
	//private User user;

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customerOrder")
	private Set<Order> products = new HashSet<Order>();

	@JsonIgnore
	@OneToOne(mappedBy="customerCart")
	private Cart cart;



	public Customer() {
		super();
	}



	public Customer(int customerId, @NotNull(message = "First Name can not be null") String fullName,
			@Size(min = 10, message = "Mobile no should be in 10 digits") String mobileNumber,
			@Email(message = "Email should be valid") String email,
			@NotNull(message = "password should not be null") String password, Address addressCust, Set<Order> products,
			Cart cart) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.addressCust = addressCust;
		this.products = products;
		this.cart = cart;
	}



	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Address getAddressCust() {
		return addressCust;
	}



	public void setAddressCust(Address addressCust) {
		this.addressCust = addressCust;
	}



	public Set<Order> getProducts() {
		return products;
	}



	public void setProducts(Set<Order> products) {
		this.products = products;
	}



	public Cart getCart() {
		return cart;
	}



	public void setCart(Cart cart) {
		this.cart = cart;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fullName=" + fullName + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", password=" + password + ", addressCust=" + addressCust + ", products="
				+ products + ", cart=" + cart + "]";
	}

	
	
}
