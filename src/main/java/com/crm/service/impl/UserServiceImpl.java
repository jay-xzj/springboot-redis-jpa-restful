package com.crm.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.crm.comm.domain.User;
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
	
	
	private Map<Integer,User> users = new HashMap<Integer,User>();
	
	@Autowired
	private CacheManager casheManager;
	
	private void setCacheManager(CacheManager casheManager) {
		this.casheManager =casheManager;
	}
	
	@PostConstruct
	public void setup() {
		Cache usersCashe =casheManager.getCache("users");
		/*for (Integer key : users.keySet()) {
			usersCashe.put(key,users.get(key));
		}*/
		User user = new User();
		user.setAddress("abcdefg");
		usersCashe.put(1,user);
	}
	
	@Cacheable(value ="users")
	public User getUser(int id) {
		System.out.println("dfjdfjdif");
		return users.get(id);
	}
}
