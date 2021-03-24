package com.cg.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.User;
import com.cg.onlineshopping.service.LoginService;

@RestController
@RequestMapping("/onlineshopping/api")
public class UserRestController {

	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/user")
	public User adduser(@RequestBody User user) {
		return loginService.addUser(user);
	}
	
	@GetMapping("/user")
    public User validateuser(@RequestBody User user) {
		return loginService.validateUser(user);
	}
	
	@DeleteMapping("/user/{userId}")
	public User removeUser(@RequestBody int userId) {
		return loginService.removeUser(userId);
	}
}
