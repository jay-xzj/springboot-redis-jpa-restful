package com.crm.comm.config;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.crm.ApplicationConfig;
import com.crm.comm.domain.User;
import com.crm.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CacheTests {
	
 	@Autowired
	private CacheConfig a;
    
    @Test
    public void testCashe ()  throws Exception {
    		a.addMaps("1", "1", "1");
    		a.getValue("1", "1");
    	
    }
    
    @Test
    public void testCache1() throws Exception {
    	 ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    	 UserService userService = (UserService) context.getBean("initUserService");
    	 User a =userService.getUser(1);
    	 System.out.println(a.getAddress());
    }
}


