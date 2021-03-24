package com.cg.onlineshopping.testing;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.entities.User;
import com.cg.onlineshopping.repository.LoginRepository;
import com.cg.onlineshopping.service.LoginService;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	LoginService loginService;
	
	@MockBean
	LoginRepository loginRepo;
	
	@Test
	public void testAddUser()
	{
		User user = new User();
		user.setPassword("pass");
		user.setRole("Simple User");
		Customer cust = new Customer();
		cust.setCustomerId(1003);
		user.setCustomerUser(cust);
		
		Mockito.when(loginRepo.save(user)).thenReturn(user);
		assertThat(loginService.addUser(user)).isEqualTo(user);
	}
	@Test
	public void testRemoveUser()
	{
		User user = new User();
		user.setPassword("pass");
		user.setRole("Simple User");
		Customer cust = new Customer();
		cust.setCustomerId(1003);
		user.setCustomerUser(cust);
		Mockito.when(loginRepo.findById(user.getUserId())).thenReturn(Optional.of(user));
	    Mockito.when(loginRepo.existsById(user.getUserId())).thenReturn(false);
	    assertFalse(loginRepo.existsById(cust.getCustomerId()));
	}
	
	@Test
	public void testValidateUser()
	{
		User user = new User();
		user.setUserId(2006);
		user.setPassword("pass");
		user.setRole("Simple User");
		Customer cust = new Customer();
		cust.setCustomerId(1003);
		user.setCustomerUser(cust);
		Mockito.when(loginRepo.findValidateUser(user.getUserId(), user.getPassword())).thenReturn(user);
		Mockito.when(loginRepo.existsById(user.getUserId())).thenReturn(true);
		Mockito.when(loginRepo.getPassword(user.getUserId())).thenReturn(user.getPassword());
		assertThat(loginService.validateUser(user.getUserId())).isEqualTo(user);
	}
	
}
