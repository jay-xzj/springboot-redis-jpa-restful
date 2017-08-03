package com.crm.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.crm.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testBaseQuery() throws Exception {
		User user=new User();
		user.setEmail("a@126.com");
		user.setNickName("tracy");
		user.setPassword("xxxx");
		user.setUsername("tracy");
		user.setCustomerId(12345454l);
		user.setRegTime("dddd");
		userRepository.findAll();
		userRepository.findOne(1l);
		userRepository.save(user);
		userRepository.delete(user);
		userRepository.count();
		userRepository.exists(1l);

	}
}
