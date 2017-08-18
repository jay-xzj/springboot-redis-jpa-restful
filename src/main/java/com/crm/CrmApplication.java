package com.crm;

/*
 工程启动方法
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CrmApplication {	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}
	   
		
	
}
