package com.crm.service;

import com.crm.comm.domain.User;

public interface UserService {

	public void addUser(User user);
	public void setup() ;
	public User getUser(int id);
	
}
