package com.cg.onlineshopping.service;

import java.util.List;

import com.cg.onlineshopping.entities.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer cust);
	public Customer updateCustomer(Customer cust);
	public Customer removeCustomer(int custId);
	public Customer viewCustomer(int custId);
	public List<Customer> ViewAllCustomers(String location);
	public List<Customer> viewAllCustomer();

}
