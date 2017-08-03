package com.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.domain.User;
import com.crm.repository.UserRepository;
import com.crm.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		
	}
	
}
