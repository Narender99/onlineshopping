package com.cg.onlineshopping.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addRepo;
	
	
	@Override
	public Address addAddress(Address add) {
		addRepo.save(add);
		return add;
	}

	@Override
	public Address updateAddress(Address add) {
		addRepo.save(add);
		return add;
	}

	@Override
	public Address removeAddress(int addId) {
		Address address = addRepo.findById(addId).get();
		addRepo.deleteById(addId);
		return address;
	}
	

	@Override
	public List<Address> viewAllAddress(Integer id) {
		return addRepo.viewAllAddress(id);
	}

	
	@Override
	public Address viewAddress(int addId) {
		
		Address viewAdd = addRepo.findById(addId).get();
		return viewAdd;
	}

}
