package com.cg.onlineshopping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.User;
import com.cg.onlineshopping.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepo;
	@Override
	public User addUser(User user) {
		loginRepo.save(user);
		return user;
	}

	@Override
	public User removeUser(int userId) {
		Optional<User> user = loginRepo.findById(userId);
		loginRepo.delete(user.get());
		return user.get();
	}

	@Override
	public User validateUser(User user) {
		
		return loginRepo.findValidateUser(user.getUserId(),user.getPassword());
	}

	@Override
	public User signOut(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
