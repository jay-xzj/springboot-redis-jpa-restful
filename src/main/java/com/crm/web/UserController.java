package com.crm.web;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.comm.domain.User;
import com.crm.repository.UserRepository;
import com.crm.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	public UserService getUserService() {
	    if (userService == null) {
	      throw new RuntimeException("userService not configured. Cannot continue.");
	    }
	    return userService;
	  }
	
	 
	 @RequestMapping("/FindAll")
	 public List<User> findAllUser() {
		 return userRepository.findAll();	 
	 }
	 
	 @RequestMapping("/FindById/{id}")
	  public List<User> findByUserId(@PathVariable Long id) {
	    return userRepository.findByUserId(id);
	  }

	  @RequestMapping("/FindBy/{address}")
	  public List<User> findByAddress(@PathVariable String address) {
	    return userRepository.findByAddress(address);
	  }

	  @RequestMapping(value = "/Add", method = RequestMethod.PUT)
	  public User add(@RequestBody User User) {
	    try {
	      getUserService().addUser(User);
	    } catch (Exception e) {
	      throw new RuntimeException("Could not add User: " + ReflectionToStringBuilder.toString(User), e);
	    }
	    return User;
	  }

	  @RequestMapping(value = "/Update", method = RequestMethod.POST)
	  public String update(@RequestBody User User) {
	    String ret = "UPDATE FAILED";
	    try {
	    		userRepository.saveAndFlush(User);
	    		ret= "UPDATE SUCCESS";
	    } catch (Exception e) {
	      throw new RuntimeException("Could not update User: " + ReflectionToStringBuilder.toString(User), e);
	    }
	    return ret;
	  }

	  @RequestMapping(value = "/Delete", method = RequestMethod.DELETE)
	  public String delete(@RequestBody User User) {
	    String ret = "DELETE FAILED";
	    try {
    			userRepository.delete(User);
	        ret = "DELETE SUCCESSFUL";
	    } catch (Exception e) {
	      throw new RuntimeException("Could not delete User: " + ReflectionToStringBuilder.toString(User), e);
	    }
	    return ret;
	  }	  

}
