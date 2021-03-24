package com.cg.onlineshopping.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.exception.CustomerNotFoundException;
import com.cg.onlineshopping.repository.CustomerRepository;

import ch.qos.logback.classic.Logger;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository custRepo;
	
	//ogger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Override
	public Customer addCustomer(Customer cust) {
		//Logger.info("Customer addCustomer()");
		if(cust == null)
			throw new CustomerNotFoundException("No CustomerFound");
		custRepo.save(cust);
		return cust;
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		if(cust == null)
			throw new CustomerNotFoundException("No Customer Found");
		else {
		custRepo.save(cust);
		return cust;
	}
	}

	@Override
	public Customer removeCustomer(Integer custId) {
		Optional<Customer> cust = custRepo.findById(custId);
		if(!cust.isPresent())
			throw new CustomerNotFoundException("No Customer Found");
		else {
		custRepo.deleteById(custId);
		return cust.get();
		}
	}

	@Override
	public Customer viewCustomer(Integer custId) {
		Optional<Customer> cust =  custRepo.findById(custId);
		if(!cust.isPresent())
			throw new CustomerNotFoundException("No Customer Found");
		else 
			return cust.get();
	}

	@Override
	public List<Customer> ViewAllCustomers(String location) {
		 List<Customer> cust= custRepo.viewAllCustomer(location);
	        if(cust.isEmpty())
	            throw new CustomerNotFoundException("No Customer Found");
	        return cust;
	}

	@Override
	public List<Customer> viewAllCustomer() {

		 List<Customer> customers= custRepo.findAll();
	        if(customers.isEmpty())
	            throw new CustomerNotFoundException("No Customer Found");
	        return customers;
	}

}
