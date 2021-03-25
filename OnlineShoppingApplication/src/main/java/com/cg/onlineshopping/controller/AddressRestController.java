package com.cg.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/onlineshopping/api")
public class AddressRestController {

	@Autowired
	AddressService addressService;

	Logger logger = LoggerFactory.getLogger(AddressRestController.class);


	@PostMapping("/address")
	public Address addAddress(@RequestBody Address add)
	{
		logger.info("Address addAddress()");
		return addressService.addAddress(add);
	}

	/*@GetMapping("/address/{addId}")
		public List<Address> viewAllAddress(@PathVariable("addId")int addId)
		{
			logger.info("Address viewAllAddress()");
			return addService.viewAllAddress(addId);
		}*/

	@GetMapping("/address/{addId}")
	public Address viewAddress(@PathVariable("addId")int addId)
	{
		logger.info("Address viewAddress()");
		return addressService.viewAddress(addId);
	}
	
	@PutMapping("/address")
	public Address updateAddress(@RequestBody Address add)
	{
		logger.info("Address updateAddress()");
		return addressService.updateAddress(add);
	}

	@DeleteMapping("/address/{addId}")
	public Address removeCustomer(@PathVariable("addId")int addId)
	{
		logger.info("Address removeAddress()");
		return addressService.removeAddress(addId);
	}




}
