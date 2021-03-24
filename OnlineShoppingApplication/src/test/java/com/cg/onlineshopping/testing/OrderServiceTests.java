package com.cg.onlineshopping.testing;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.repository.AddressRepository;
import com.cg.onlineshopping.service.AddressService;



@SpringBootTest
public class OrderServiceTests {

	@Autowired
	AddressService addressService;
	
	@MockBean
	AddressRepository addressRepo;
	
	@Test
	public void testAddAddress()
	{
		Address add = new Address();
		add.setStreetNo("131D");
		add.setBuildingName("KrupaComplex");
		add.setCity("Hyderabad");
		add.setState("Telangana");
		add.setCountry("INDIA");
		add.setPincode("500042");
		Customer cust = new Customer();
		cust.setCustomerId(1002);
		add.setCustomerAdd(cust);
		Mockito.when(addressRepo.save(add)).thenReturn(add);
		assertThat(addressService.addAddress(add)).isEqualTo(add);
	}
	
	@Test
	public void testUpdateAddress()
	{
		Address add = new Address();
		add.setStreetNo("131D");
		add.setBuildingName("KrupaComplex");
		add.setCity("Hyderabad");
		add.setState("Telangana");
		add.setCountry("INDIA");
		add.setPincode("500042");
		Customer cust = new Customer();
		cust.setCustomerId(1002);
		add.setCustomerAdd(cust);
		
		Mockito.when(addressRepo.findById(add.getAddressId())).thenReturn(Optional.of(add));
		
		add.setCity("Kolkata");
		Mockito.when(addressRepo.save(add)).thenReturn(add);
		
		assertThat(addressService.updateAddress(add)).isEqualTo(add);
	}
	
	
	@Test
	public void testRemoveAddress()
	{
		Address add = new Address();
		add.setStreetNo("131D");
		add.setBuildingName("KrupaComplex");
		add.setCity("Hyderabad");
		add.setState("Telangana");
		add.setCountry("INDIA");
		add.setPincode("500042");
		Customer cust = new Customer();
		cust.setCustomerId(1002);
		add.setCustomerAdd(cust);
		
		Mockito.when(addressRepo.findById(add.getAddressId())).thenReturn(Optional.of(add));
	    Mockito.when(addressRepo.existsById(add.getAddressId())).thenReturn(false);
	   assertFalse(addressRepo.existsById(add.getAddressId()));
	}
	

	@Test
	public void viewAddressById()
	{
		Address add = new Address();
		add.setStreetNo("131D");
		add.setBuildingName("KrupaComplex");
		add.setCity("Hyderabad");
		add.setState("Telangana");
		add.setCountry("INDIA");
		add.setPincode("500042");
		Customer cust = new Customer();
		cust.setCustomerId(1002);
		add.setCustomerAdd(cust);
		Mockito.when(addressRepo.findById(add.getAddressId())).thenReturn(Optional.of(add));
		assertThat(addressService.viewAddress(add.getAddressId())).isEqualTo(add);
	}
	
	@Test
	public void viewAllAddress()
	{
		Address add1 = new Address();
		add1.setStreetNo("131D");
		add1.setBuildingName("KrupaComplex");
		add1.setCity("Hyderabad");
		add1.setState("Telangana");
		add1.setCountry("INDIA");
		add1.setPincode("500042");
		Customer cust1 = new Customer();
		cust1.setCustomerId(1002);
		add1.setCustomerAdd(cust1);
		
		Address add2 = new Address();
		add2.setStreetNo("131D");
		add2.setBuildingName("KrupaComplex");
		add2.setCity("Hyderabad");
		add2.setState("Telangana");
		add2.setCountry("INDIA");
		add2.setPincode("500042");
		Customer cust2 = new Customer();
		cust2.setCustomerId(1002);
		add2.setCustomerAdd(cust2);
		
		List<Address> addList = new ArrayList<>();
		addList.add(add1); addList.add(add2);
		
		Mockito.when(addressRepo.findAll()).thenReturn(addList);
		
		assertThat(addressService.viewAllAddress()).isEqualTo(addList);
	}
}
