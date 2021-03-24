package com.cg.onlineshopping.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.service.CustomerService;

@RestController
@RequestMapping("/onlineshopping/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	

	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer cust){
		Customer customers = customerService.addCustomer(cust);
		return customers;
	}	
	
	
	@GetMapping("/customer")
    public List<Customer> viewAllCustomer()
    {
        return customerService.viewAllCustomer();
    }
	
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer cust) {
		Customer customers = customerService.updateCustomer(cust);
		return cust;
		
	}
	
	
	@GetMapping("/customer/{customerId}")
    public Customer viewCustomerById(@PathVariable("customerId")int custId)
    {
        return customerService.viewCustomer(custId);
    }
	/*
	@GetMapping("/customer/{customerAddress}")
    public List<Customer> viewCustomerByAddress(@PathVariable("customerAddress")String custAddress)
    {
        return customerService.ViewAllCustomers(custAddress);
    }
	*/
	@DeleteMapping("/customer/{custId}")
	public Customer removeCustomer(@PathVariable("custId")int custId) {
		
		return customerService.removeCustomer(custId);
		
	}
	
	
}
