package com.cg.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository custRepo;
	
	@Override
	public Customer addCustomer(Customer cust) {
		custRepo.save(cust);
		return cust;
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		custRepo.save(cust);
		return cust;
	}

	@Override
	public Customer removeCustomer(int custId) {
		Customer cust = custRepo.findById(custId).get();
		custRepo.deleteById(custId);
		return cust;
	}

	@Override
	public Customer viewCustomer(int custId) {
		return custRepo.findById(custId).get();
	}

	@Override
	public List<Customer> ViewAllCustomers(String location) {
		return custRepo.viewAllCustomer(location);
	}

	@Override
	public List<Customer> viewAllCustomer() {

		return custRepo.findAll();
	}

}
