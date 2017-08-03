package com.crm.comm.config;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CasheTests {
	
 	@Autowired
	private CasheConfig a;
    
    @Test
    public void testCashe ()  throws Exception {
    		a.addToData("1", "1", "1"); 
    		a.addMaps("1", "1", "1");
    		a.getValue("1", "1");
    	
    }
}


