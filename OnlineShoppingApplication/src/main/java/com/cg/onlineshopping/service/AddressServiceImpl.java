package com.cg.onlineshopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.exception.AddressNotFoundException;
import com.cg.onlineshopping.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addRepo;
	
	
	@Override
	public Address addAddress(Address add) {
		if(add == null)
			throw new AddressNotFoundException("Address Not Found");
		
		else{
			addRepo.save(add);
	
		return add;
	}
	}

	@Override
	public Address updateAddress(Address add) {
		if(add == null)
			throw new AddressNotFoundException("Address Not Found");
		else {
		   addRepo.save(add);
		return add;
	}
	}

	@Override
	public Address removeAddress(int addId) {
		Optional<Address> add = addRepo.findById(addId);
		if(!add.isPresent())
			throw new AddressNotFoundException("Address Not Found");
		else {
		addRepo.deleteById(addId);
		return add.get();
	}
	}
	

	@Override
	public List<Address> viewAllAddress() {
		List<Address> list = addRepo.findAll();
		if(list.isEmpty())
			throw new AddressNotFoundException("Address Not Found");
		else
			return list;
	}

	
	@Override
	public Address viewAddress(int addId) {
		
		Optional<Address> viewAdd = addRepo.findById(addId);
		if(!viewAdd.isPresent())
			throw new AddressNotFoundException("Address Not Found");
		else {
			addRepo.deleteById(addId);
			return viewAdd.get();
		}
	}

}
