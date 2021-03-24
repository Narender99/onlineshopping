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

@RestController
@RequestMapping("/onlineshopping/api")
public class AddressRestController {

	 @Autowired
	 AddressService addressService;
	 

		@PostMapping("/address")
		public Address addAddress(@RequestBody Address add){
			Address address = addressService.addAddress(add);
			return add;
		}	
		
		@PutMapping("/address")
		public Address update(@RequestBody Address add) {
			Address address = addressService.updateAddress(add);
			return address;
		}
		
		@DeleteMapping("/address/{addressId}") 
			public Address removeAddress(@PathVariable("addressId") int addressId) {
			return addressService.removeAddress(addressId);
			
		}
		
		@GetMapping("/address/{addressId}")
		public List<Address> viewAllAddress(@PathVariable("addressId")int addressId) {
			
			return addressService.viewAllAddress(addressId);
			
		}
		/*
		@GetMapping("/address/{addressId}")
		public Address viewAddress(@PathVariable("address") int addressId) {
			return addressService.viewAddress(addressId);
			
		}*/
		
}
